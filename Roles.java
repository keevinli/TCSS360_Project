package TCSS360;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Roles implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8960444196072543003L;
	private Conference myConference;
	
	public Roles (Conference theConference) {
		myConference = theConference;
	}
	
	public void submitManuscript(final String thePath, final String theAuthor,
			String theDate, String theTitle, List<Manuscript> theList) {
		
		Manuscript newPaper = new Manuscript(thePath, theAuthor, theDate, theTitle);
		// Adds the new paper object to the list that the User holds.
		theList.add(newPaper);
	}
	
	public void setConference(Conference theConference) {
		myConference = theConference;
	}
	
	public Conference getConference() {
		return myConference;
	}
}
