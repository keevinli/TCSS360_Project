package TCSS360;

import java.io.Serializable;
import java.util.Date;

public class ReviewForm  extends Paper implements Serializable{
	private User myReviewer;
	
	public ReviewForm(String thePath, String theAuthor, String theDate, String theTitle, User theReviewer) {
		super(thePath, theAuthor, theDate, theTitle);
		myReviewer = theReviewer;
	}

	public User getReviewer() {
		return myReviewer;
	}

	public void setReviewer(User theReviewer) {
		this.myReviewer = theReviewer;
	}
}
