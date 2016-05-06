package TCSS360;

import java.io.Serializable;

import TCSS360.Manuscript.Status;

public class ProgramChair extends Roles implements Serializable {

	public ProgramChair(Conference theConference) {
		super(theConference);
		// TODO Auto-generated constructor stub
	}
	
	
	public void viewAllManuscripts() {	
		int count = 1;
		for (Manuscript m : Main.currentConference.getManuscripts()) {
			System.out.println(count + ". " + m.getTitle());
			count++;
		}
	}
	
	public void rejectManuscript(Manuscript theManuscript){
		theManuscript.setStatus(Status.REJECTED);
		System.out.println(theManuscript.getTitle() + " by " + theManuscript.getAuthor() + " Rejected.");
		
	}
	
	public void acceptManuscript(Manuscript theManuscript){
		theManuscript.setStatus(Status.ACCEPTED);
		System.out.println(theManuscript.getTitle() + " by " + theManuscript.getAuthor() + " Accepted.");
		
	}
	
	
	public void viewAssignedSubProgManuscripts() {	
		for(User u : Main.currentConference.getSubProChairList()) {
			if(!u.getSubProgManuscript().isEmpty()) {
				System.out.println(u.getMyName() + ":");
				for (Manuscript m: u.getSubProgManuscript()) {
					System.out.println("\t" + m.getTitle());
				}
			}
		}
	}
	
	public void assignSubProgManuscript(User theUser, Manuscript theManuscript) {
		theUser.addSubProgManuscript(theManuscript);
		System.out.println(theManuscript.getTitle() + " assigned to " + theUser.getMyName());
		
	}

}
