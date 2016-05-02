package TCSS360;

import java.util.List;

public class ProgramChair {
	
	
	private void viewAllManuscripts(Conference theConference) {
		System.out.println("List of manuscripts: ");
		List<Manuscript> manuscripts = theConference.getManuscripts();
		for (Manuscript m : manuscripts) {
			System.out.println(m.toString());
		}
	}
	
	private void acceptRejectManuscript(Manuscript theManuscript, char theDecision) {
		theManuscript.setDecision(theDecision);
	}
	
	private void viewAssignedSubProgManuscripts(Conference theConference) {
		List<User> users = Conference.getUsers();
		List<Roles> roles = Conference.getRoles();
		List<Manuscript> manuscripts;
		
		for(User u : users) {
			for (Roles r : roles) {
				if(r.getClass().equals(SubprogramChair.class)) {
					manuscripts = u.getMyManuscripts();
				}
			}
		}
	}
	
	private void assignSubProgManuscript(User theUser, Manuscript theManuscript) {
		List<Roles> roles = theUser.getMyRoles();
		for(Roles r : roles) {
			if(r.getClass().equals(Reviewer.class)){
				theUser.addMyManuscript(theManuscript);
			}
		}
		
	}

}
