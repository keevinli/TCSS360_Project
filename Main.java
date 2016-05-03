package TCSS360;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements Serializable {
	public static User currentUser;// = new User("Adam", "adamgroup5", "adam@adam.com");

	private static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] theargs) {
		Conference currentConference;
		boolean finished = false;
		boolean exit = false;
		
		int input;
		List<User> userList = new ArrayList<User>();
		userList.add(new User("adam", "adamlogin", "adam@adam.com"));
		
		List<Conference> conferenceList = new ArrayList<Conference>();
		conferenceList.add(new Conference("Conf1", userList.get(0), "start date", "end date", "paper deadline", "rev deadline"));
		conferenceList.add(new Conference("Conf2", userList.get(0), "start date", "end date", "paper deadline", "rev deadline"));
		conferenceList.add(new Conference("Conf3", userList.get(0), "start date", "end date", "paper deadline", "rev deadline"));
		userList.get(0).addMyRole(new SubprogramChair(conferenceList.get(0)));
		
		while(!finished) {
			System.out.println("Select an option: \n1.Login\n2.Register\n3.Exit");
			input = userInput.nextInt();
			switch(input) {
				case 1:
					login(userList);
					finished = true;
					break;
				case 2:
					userList.add(register());
					break;
				case 3:
					exit();
					finished = true;
					exit = true;
					break;
				default:
					System.out.println("Invalid selection, returning to last menu");
					break;
			}
		}
		finished = false;
		while (!finished && !exit) {
			int count = 0;
			System.out.println("Select a conference: ");
			
			for(Conference c : conferenceList) {
				count++;
				System.out.println(count + ". " + c.getName());
			}
			input = userInput.nextInt();
			System.out.println("\nConference " + input + " selected.");
			currentConference = conferenceList.get(input - 1);
			finished = true;
		}
		finished = false;
		//display options for current conference based on roles.	
		while(!finished && !exit) {
			System.out.println("\nSelect an option:\nM. Submit Manuscript\nE. Exit");
			
			for(Roles r : currentUser.getMyRoles()) {
				//System.out.println(r.getClass().getSimpleName());
				if(r.getClass().getSimpleName().equals("Author")) {
					System.out.println("A. Author Options");
				}
				if(r.getClass().getSimpleName().equals("ProgramChair")) {
					System.out.println("P. Program Chair Options");
				}
				if(r.getClass().getSimpleName().equals("Reviewer")) {
					System.out.println("R. Reviewer Options");
				}
				if(r.getClass().getSimpleName().equals("SubprogramChair")) {
					System.out.println("S. Subprogram Chair Options");
				}
				
			}
			
			String roleChoiceInput = userInput.next();
			switch(roleChoiceInput) {
				case "E":
					exit = true;
					finished = true;
					break;
				case "S": 
					finished = true;
					break;
				default: 
					System.out.println("Invalid selection, returning to last menu");
					break;
			}
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
	
	public static void login(List<User> userList) {
		System.out.print("Enter your username: ");
		String input = userInput.next();
		boolean success = false;
		
		for(User u : userList) {
			System.out.println(u.getMyLoginName());
			if(u.getMyLoginName().equals(input)) {
				currentUser = u;
				success = true;				
			}
		}
		if (success) {
			System.out.println("\nSuccessfully logged in as " + currentUser.getMyLoginName());
		} else {
			System.out.println("\nNo such user exists, returning to last menu.");
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
