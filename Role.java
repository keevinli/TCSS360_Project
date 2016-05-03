import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * The Role class is the general class for the roles that
 * each User can be. 
 * @author Andrew Merz
 * @version 4/30/2016
 *
 */
public class Role implements Serializable {
	
	/**
	 * Serialized ID Number.
	 */
	private static final long serialVersionUID = -233253723716092933L;
	private Conference myConference; 

	public Role() {
		
	}
	
	@SuppressWarnings("unused")
	/**
	 * @author Andrew Merz
	 * @param thePath The file path to the text document.
	 * @param theAuthor The Author of the manuscript.
	 * @param theTitle The Title of the manuscript.
	 * @param theList The list of manuscripts submitted by the User.
	 */
	private void submitManuscript(final String thePath, final String theAuthor,
			Date theDate, String theTitle, List<Manuscript> theList) {
		
		Manuscript newPaper = new Manuscript(thePath, theAuthor, theDate, theTitle);
		// Adds the new paper object to the list that the User holds.
		theList.add(newPaper);
		
		
	}
	
	/**
	 * @author Andrew Merz
	 * Returns the Name of the Class Role.
	 */
	public String toString() {
		return this.getClass().getSimpleName();
		
	}

}
