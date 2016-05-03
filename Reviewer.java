import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reviewer implements Serializable {
	;
	
	
	public Reviewer(String theID) {
		
	}
	
	private void uploadReviewForm(final String thePath) {
		Review r = new Review(thePath);
		myReviews.add(r);
	}
	
	private void viewAssignedManuscripts() {
		// Prints all the manuscripts out from a list provided by user.
		for (int i = 0; i < myAssignedManuscripts.size(); i++) {
			System.out.println(myAssignedManuscripts.get(i).getTitle());
		}
		
	}
	
	public String toString() {
		return this.getClass().getSimpleName();
		
	}

}
