import java.util.Date;


public class Review extends Paper {
	private String reviewer;
	
	public Review(String thePath, String theAuthor, Date theSubmitDate, String theReviewer) {
		super(thePath, theAuthor, theSubmitDate);
		reviewer = theReviewer;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
}
