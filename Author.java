package TCSS360;

import java.util.List;

public class Author extends Roles {

	public Author(Conference theConference) {
		super(theConference);
	}
	
	public void viewAuthorSubManuscript() {
		List<Manuscript> manuList = Main.currentUser.getMyManuscripts();
		int i = 1;
		for (Manuscript manu : manuList){
			System.out.print(i + ". ");
			System.out.println(manu.toString());
			i++;
		}
	}
	
	public void updateAuthoredManuscript(Manuscript theManuscript, List<Conference> theConferences) {
		boolean found = false;
		
		for(Conference c: theConferences) {
			if (c.getManuscripts().contains(theManuscript)) {
				c.removeManuscript(theManuscript);
				Main.currentUser.removeManuscript(theManuscript);
				
				c.addManuscript(theManuscript);
				Main.currentUser.addMyManuscript(theManuscript);
				found = true;
				
			}
		}
		
		if (found) {
			System.out.println(theManuscript.getTitle() + " has been updated.");
		}
		else {
			System.out.println(theManuscript.getTitle() + " was not found.");
		}
		
		
	}
	
	public void unsubmitManuscript(Manuscript theManuscript, List<Conference> theConferences) {
		for(Conference c: theConferences) {
			if (c.getManuscripts().contains(theManuscript)) {
				c.removeManuscript(theManuscript);
				Main.currentUser.removeManuscript(theManuscript);
			}
		}
		
		System.out.println(theManuscript.getTitle() + " has been removed.");
	}
}