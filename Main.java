package TCSS360;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements Serializable {
	public static User currentUser;// = new User("Adam", "adamgroup5", "adam@adam.com");
	public static Conference currentConference;

	private static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] theargs) {
		
		boolean finished = false;
		boolean exit = false;
		
		List<User> userList = new ArrayList<User>();
		userList.add(new User("adam", "adamlogin", "adam@adam.com"));
		
		List<Conference> conferenceList = new ArrayList<Conference>();
		conferenceList.add(new Conference("Conf1", userList.get(0), "start date", "end date", "paper deadline", "rev deadline"));
		conferenceList.add(new Conference("Conf2", userList.get(0), "start date", "end date", "paper deadline", "rev deadline"));
		conferenceList.add(new Conference("Conf3", userList.get(0), "start date", "end date", "paper deadline", "rev deadline"));
		userList.get(0).addMyRole(new SubprogramChair(conferenceList.get(0)));
		

		//First menu
		registerLoginMenu(finished, exit, userList, conferenceList);
		
		//display options for current conference based on roles.	

		
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
			
			int input = userInput.nextInt();
			System.out.println("\nConference " + input + " selected.");
			
			if(input > 0) {
			currentConference = theConferenceList.get(input - 1);			
			//call next menu
			selectRoleMenu(theExitFlag, theFinishedFlag, theUserList, theConferenceList);
			} else {
				exit();
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
				case "E":
					exit();
					theExitFlag = true;
					theFinishedFlag = true;
					break;
				case "S": 
					theFinishedFlag = true;
					break;
				default: 
					System.out.println("Invalid selection, returning to last menu");
					break;
			}
	}
	
	
	public static boolean hasRole(Conference theConference, Roles theRole) {
		boolean result = false;
		String specifiedRole = theRole.getClass().toString();
		
		for (Roles r: currentUser.getMyRoles()){
			if (specifiedRole == r.getClass().toString()) {
				if(theRole.getConference().getName() == r.getConference().getName()) {
					result = true;
				}
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
		System.out.println("Please enter your full name");
		String input = userInput.next();
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
