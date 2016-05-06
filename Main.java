package TCSS360;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import TCSS360.Manuscript.Status;

public class Main implements Serializable {
	public static User currentUser;// = new User("Adam", "adamgroup5", "adam@adam.com");
	public static Conference currentConference;
	public static final Author AUTHOR = new Author(null);
	public static final Reviewer REVIEWER = new Reviewer(null);
	public static final SubprogramChair SUBPROGRAM_CHAIR = new SubprogramChair(null);
	public static final ProgramChair PROGRAM_CHAIR = new ProgramChair(null);
	private static List<Conference> conferenceList;
	private static List<User> userList;

	private static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] theargs) {
		
		boolean initialized = false;
		boolean finished = false;
		boolean exit = false;
		
		if(!initialized) {
			initialized = setup();
		}


		//First menu
		registerLoginMenu(finished, exit, userList, conferenceList);
		
		//display options for current conference based on roles.	

		
	}
	
	private static boolean setup() {
		// TODO Auto-generated method stub
		userList = new ArrayList<User>();
		userList.add(new User("adam", "adamlogin", "adam@adam.com"));
		userList.add(new User("kevin", "kevinl", "kevin@adam.com"));
		userList.add(new User("andrew", "andrewl", "andrew@adam.com"));
		
		
		conferenceList = new ArrayList<Conference>();
		conferenceList.add(new Conference("Conf1", userList.get(0), "start date", "end date", "paper deadline", "rev deadline"));
		conferenceList.add(new Conference("Conf2", userList.get(0), "start date", "end date", "paper deadline", "rev deadline"));
		conferenceList.add(new Conference("Conf3", userList.get(0), "start date", "end date", "paper deadline", "rev deadline"));
		userList.get(0).addMyRole(new SubprogramChair(conferenceList.get(0)));
		userList.get(0).addMyRole(new Author(conferenceList.get(0)));
		userList.get(0).addMyRole(new ProgramChair(conferenceList.get(0)));
		userList.get(0).addMyRole(new Reviewer(conferenceList.get(0)));
		
		userList.get(1).addMyRole(new SubprogramChair(conferenceList.get(0)));
		userList.get(1).addMyRole(new Reviewer(conferenceList.get(0)));
		
		
		currentUser = userList.get(0);
		currentConference = conferenceList.get(0);
		currentConference.addSubProChairList(currentUser);
		currentUser.submitManuscript("path1", "Manuscript 1");
		currentUser.submitManuscript("path1", "Manuscript 2");
		currentUser.submitManuscript("path1", "Manuscript 3");
		SubprogramChair initSubprogramChair = currentUser.findSubprogramChairRole();
		initSubprogramChair.submitRecomendation(currentConference.getManuscripts().get(0), 1, "reccpath", "rectitle");
		initSubprogramChair.submitRecomendation(currentConference.getManuscripts().get(1), 3, "reccpath", "rectitle");
		initSubprogramChair.submitRecomendation(currentConference.getManuscripts().get(2), 2, "reccpath", "rectitle");
		ProgramChair initProgramChair = currentUser.findProgramChairRole();
		initProgramChair.assignSubProgManuscript(userList.get(1), currentConference.getManuscripts().get(0));
		initProgramChair.assignSubProgManuscript(userList.get(1), currentConference.getManuscripts().get(2));
		initSubprogramChair.assignReviewerManuscript(userList.get(1), currentConference.getManuscripts().get(0));
		
		currentUser = userList.get(1);
		currentConference.addSubProChairList(currentUser);
		
		currentUser = null;
		currentConference = null;
		return true;
	}

	public static void registerLoginMenu(boolean theFinishedFlag, boolean theExitFlag, List<User> theUserList, List<Conference> theConferenceList) {
			System.out.println("Select an option: \n1.Login\n2.Register\n3.Exit");
			int input = userInput.nextInt();
			
			switch(input) {
				case 1:				
					theFinishedFlag = login(theUserList);
					break;
				case 2:
					theUserList.add(register());
					break;
				case 3:
					exit();
					theExitFlag = true;
					break;
				default:
					System.out.println("Invalid selection, returning to last menu");
					break;
			}
			
			if(!theFinishedFlag && !theExitFlag) {
				registerLoginMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
			} else if (!theExitFlag){
				theFinishedFlag = false;
				selectConferenceMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
			}
	}
	
	public static void selectConferenceMenu(boolean theFinishedFlag, boolean theExitFlag, List<User> theUserList, List<Conference> theConferenceList) {
			int count = 0;
			System.out.println("Select a conference or option: ");
			
			for(Conference c : theConferenceList) {
				count++;
				System.out.println(count + ". " + c.getName());
			}
			System.out.println("B. Back\nE. Exit");
			
			String input = userInput.next();
			
			switch(input) {
				case "E": 
					exit();
					break;
				case "B":
					registerLoginMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
					break;
				default: 
					if(Integer.parseInt(input) > theConferenceList.size()) {
						System.out.println("Invalid selection returning to last menu");
						selectConferenceMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
					} else {
						System.out.println("\nConference " + input + " selected.");
						currentConference = theConferenceList.get(Integer.parseInt(input) - 1);			
						//call next menu
						selectRoleMenu(theExitFlag, theFinishedFlag, theUserList, theConferenceList);
					}
					break;
			}
	}
	
	public static void selectRoleMenu(boolean theFinishedFlag, boolean theExitFlag, List<User> theUserList, List<Conference> theConferenceList) {
			System.out.println("\nSelect an option:\nM. Submit Manuscript");
			
			for(Roles r : currentUser.getMyRoles()) {
				//System.out.println(r.getClass().getSimpleName());
				if(r.getClass().getSimpleName().equals("Author") && r.getConference() == currentConference) {
					System.out.println("A. Author Options");
				}
				if(r.getClass().getSimpleName().equals("ProgramChair") && r.getConference() == currentConference) {
					System.out.println("P. Program Chair Options");
				}
				if(r.getClass().getSimpleName().equals("Reviewer") && r.getConference() == currentConference) {
					System.out.println("R. Reviewer Options");
				}
				if(r.getClass().getSimpleName().equals("SubprogramChair") && r.getConference() == currentConference) {
					System.out.println("S. Subprogram Chair Options");
				}	
			}
			
			System.out.println("B. Back\nE. Exit");
			
			String roleChoiceInput = userInput.next();
			switch(roleChoiceInput) {
				case "A":
					hasRole(currentConference, AUTHOR, currentUser);
					authorMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
					break;
				case "E":
					exit();
					break;
				case "B":
					selectConferenceMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
					break;
				case "S": 
					hasRole(currentConference, SUBPROGRAM_CHAIR, currentUser);
					subprogramChairMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
					break;
				case "M":
					System.out.println("Enter the path to the manuscript: ");
					String path = userInput.next();
					System.out.println("Enter the title of the manuscript: ");
					String title = userInput.next();				
					currentUser.submitManuscript(path, title);
					selectRoleMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
					break;
				case "P": 
					hasRole(currentConference, PROGRAM_CHAIR, currentUser);
					programChairMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
					break;
				case "R": 
					hasRole(currentConference, REVIEWER, currentUser);
					reviewerMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
					break;
				default: 
					System.out.println("Invalid selection, returning to last menu");
					selectRoleMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
					break;
			}
	}
	
	public static void authorMenu(boolean theFinishedFlag, boolean theExitFlag, List<User> theUserList, List<Conference> theConferenceList) {
		System.out.println("Select an option: ");
		System.out.println("1. Update Manuscript");
		System.out.println("2. Unsubmit Manuscript");
		System.out.println("3. Back");
		System.out.println("4. Exit");
		
		int input = userInput.nextInt();
		int count = 1;
		Author tempAuthor = currentUser.findAuthorRole();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());	
		
		switch(input) {
			case 1:
				//Update Manuscript
				System.out.println("Select a manuscript to update: ");
				for(Manuscript m : currentUser.getMyManuscripts()) {
					System.out.println(count + ". " + m.getTitle());
					count++;
				}
				input = userInput.nextInt();
				Manuscript tempManuscript = currentUser.getMyManuscripts().get(input - 1);			
				System.out.println("Enter the path of the updated manuscript");
				String path = userInput.next();
		
				Manuscript updatedManuscript = new Manuscript(path, currentUser.getMyName(), date, tempManuscript.getTitle());
				tempAuthor.updateAuthoredManuscript(updatedManuscript, theConferenceList);
				authorMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
				break;
			case 2:
				//Unsubmit Manuscript
				for(Manuscript m : currentUser.getMyManuscripts()) {
					System.out.println(count + ". " + m.getTitle());
					count++;
				}			
				input = userInput.nextInt();			
				Manuscript removedManuscript = currentUser.getMyManuscripts().get(input - 1);
				tempAuthor.unsubmitManuscript(removedManuscript, theConferenceList);	
				authorMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
				break;
			case 3: 
				selectRoleMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
				break;
			case 4:
				exit();
				break;
			default: 
				System.out.println("Invalid Selection returning to last menu");
				authorMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
				break;
		}
	}
	
	public static void programChairMenu(boolean theFinishedFlag, boolean theExitFlag, List<User> theUserList, List<Conference> theConferenceList) {
		System.out.println("Select an option: ");
		System.out.println("1. View all manuscripts");
		System.out.println("2. Reject/Accept Manuscript");
		System.out.println("3. View all assigned Subprogram Chair manuscripts");
		System.out.println("4. Assign a manuscript to a Subprogram Chair");
		System.out.println("5. Back");
		System.out.println("6. Exit");
		
		int input = userInput.nextInt();
		int count = 1;
		ProgramChair tempProgramChair = currentUser.findProgramChairRole();
		Manuscript selectedManuscript;
		
		switch(input) {
			case 1:
				tempProgramChair.viewAllManuscripts();
				programChairMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
				break;
			case 2:
				ArrayList<Manuscript> reccomendedList = new ArrayList<>();
				for(Manuscript m : currentConference.getManuscripts()) {
					if(m.getStatus() == Status.RECOMMENDED) {
						reccomendedList.add(m);
						System.out.println(count + ". " + m.getTitle());
						System.out.print("\tReccomendations: ");
						for(RecommendationForm rf : m.getRecomFormList()) {
							System.out.print(rf.getScore() + ", ");
						}
						System.out.println();
						count++;
					}
				}
				input = userInput.nextInt();
				selectedManuscript = reccomendedList.get(input - 1);
				
				
				System.out.println("1. Aceept");
				System.out.println("2. Reject");
				System.out.println("3. Back");
				System.out.println("4. Exit");
				input = userInput.nextInt();
				
				switch(input) {
					case 1: 
						tempProgramChair.acceptManuscript(selectedManuscript);
						programChairMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
						break;
					case 2: 
						tempProgramChair.rejectManuscript(selectedManuscript);
						programChairMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
						break;
					case 3:
						programChairMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
						break;
					case 4:
						exit();
						break;
				}
				
				break;
			case 3:
				tempProgramChair.viewAssignedSubProgManuscripts();
				programChairMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
				break;
			case 4:
				//print list of SPCs, pick manuscript
				count = 1;
				for(User sc : currentConference.getSubProChairList()) {
					System.out.println(count + ". " + sc.getMyName());
					count++;
				}
				
				input = userInput.nextInt();
				User selected = currentConference.getSubProChairList().get(input - 1);		
				tempProgramChair.viewAllManuscripts();
				System.out.println("Select a manuscript to assign to " + selected.getMyName());
				input = userInput.nextInt();			
				selectedManuscript = currentConference.getManuscripts().get(input - 1);
				tempProgramChair.assignSubProgManuscript(selected, selectedManuscript);
				programChairMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
				break;
			case 5:
				selectRoleMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
				break;
			case 6:
				exit();
				break;
			default:
				System.out.println("Invalid Selection returning to last menu");
				programChairMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
				break;
		}
	}
	
	public static void reviewerMenu(boolean theFinishedFlag, boolean theExitFlag, List<User> theUserList, List<Conference> theConferenceList) {
		System.out.println("Select an option: ");
		System.out.println("1. View assigned manuscripts to review");
		System.out.println("2. Upload a review form");
		System.out.println("3. Back");
		System.out.println("4. Exit");
		
		Reviewer tempReview = currentUser.findReviewerRole();
		
		
		int input = userInput.nextInt();
		
		switch(input) {
			case 1:
				tempReview.viewAssignedManuscripts();
				reviewerMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
				break;
			case 2:
				System.out.println("Select a manuscript to upload a review for");
				tempReview.viewAssignedManuscripts();
				input = userInput.nextInt();
				Manuscript selectedManuscript = currentUser.getMyManuscriptsToReview().get(input - 1);
				System.out.println("Enter the path to the review form");
				userInput.nextLine();
				String path = userInput.nextLine();
				System.out.println("Enter the title of the review form");
				String title = userInput.nextLine();
				tempReview.uploadReviewForm(path, currentUser.getMyName(), title, selectedManuscript);
				reviewerMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
				break;
			case 3:
				selectRoleMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
				break;
			case 4:
				exit();
				break;
			default: 
				System.out.println("Invalid selection.");
				reviewerMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
				break;
		}
	}
	
	public static void subprogramChairMenu(boolean theFinishedFlag, boolean theExitFlag, List<User> theUserList, List<Conference> theConferenceList) {
		System.out.println("Select an option: ");
		System.out.println("1. Assign a manuscript to a reviewer");
		System.out.println("2. Submit a reccomendation for a manuscript");
		System.out.println("3. Back");
		System.out.println("4. Exit");
		
		SubprogramChair tempSubprogramChair = currentUser.findSubprogramChairRole();
		
		int count = 1;
		int input = userInput.nextInt();
		Manuscript selectedManuscript;
		
		switch(input) {
		case 1:
			System.out.println("Select a manuscript to assign to a reviewer");
			for(Manuscript m : currentUser.getSubProgManuscript()) {
				System.out.println(count + ". " + m.getTitle());
				count++;
			}
			
			input = userInput.nextInt();
			selectedManuscript = currentUser.getSubProgManuscript().get(input - 1);
			ArrayList<User> reviewerList = new ArrayList<User>();
			
			for(User u : userList) {
				if(hasRole(currentConference, REVIEWER, u )) {
					reviewerList.add(u);
				}
			}
			
			count = 1;
			System.out.println("Select a reviewer to assign the selected manuscript");
			
			for(User u : reviewerList) {
				System.out.println(count + ". " + u.getMyName());
			}
			
			input = userInput.nextInt();
			User selectedReviewer = reviewerList.get(input - 1);
			
			tempSubprogramChair.assignReviewerManuscript(selectedReviewer, selectedManuscript);
			subprogramChairMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
			break;
		case 2:
			System.out.println("Select a manuscript to assign a reccomendation");
			for(Manuscript m : currentUser.getSubProgManuscript()) {
				System.out.println(count + ". " + m.getTitle());
				count++;
			}
			input = userInput.nextInt();
			selectedManuscript = currentUser.getSubProgManuscript().get(input - 1);
			System.out.println("Enter the path to the reccomendation form");
			userInput.nextLine();
			String path = userInput.nextLine();
			System.out.println("Enter a reccomendation score");
			int score = userInput.nextInt();
			System.out.println("Enter a title for the reccomendation form");
			userInput.nextLine();
			String title = userInput.nextLine();
			tempSubprogramChair.submitRecomendation(selectedManuscript, score, path, title);
			subprogramChairMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
			break;
		case 3:
			selectRoleMenu(theFinishedFlag, theExitFlag, theUserList, theConferenceList);
			break;
		case 4:
			exit();
			break;
		}
	}
	
	public static boolean hasRole(Conference theConference, Roles theRole, User theUser) {
		boolean result = false;
		
		for (Roles r: theUser.getMyRoles()){
			if(r.getConference().equals(currentConference)) {
				result = true;
			}
		}
		return result;
	}
	
	public static boolean login(List<User> userList) {
		System.out.print("Enter your username: ");
		String input = userInput.next();
		boolean success = false;
		
		for(User u : userList) {
			if(u.getMyLoginName().equals(input)) {
				currentUser = u;
				success = true;				
			}
		}
		if (success) {
			System.out.println("\nSuccessfully logged in as " + currentUser.getMyLoginName());
			return true;
		} else {
			System.out.println("\nNo such user exists, returning to last menu.");
			return false;
		}
	}
	
	public static User register() {
		userInput.nextLine();
		System.out.println("Please enter your full name");
		String input = userInput.nextLine();
		System.out.println("Please enter your desired login name");
		String input2 = userInput.next();
		System.out.println("Please enter your email address");
		String input3 = userInput.next();
		
		return new User(input,input2,input3);
	}
	
	public static void exit() {
		System.out.println("You selected exit.");
	}
}
