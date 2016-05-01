import java.util.Date;
import java.util.List;

public enum Status {
	//Paper status
	SUBMITTED, REVIEWING, RECOMMED, PUBLISHED
}

public class Manuscript extends Paper {
	private String title;
	private List<Review> reviewList;
	private List<String> reviwerList;
	private int recommendation;
	private Status status;
	
	public Manuscript(String thePath, String theAuthor,
					Date theSubmitDate, String theTitle, Status theStatus) {
		super(thePath, theAuthor, theSubmitDate);
		title = theTitle;
		status = theStatus;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}

	public List<Review> getReviewList() {
		// Iterating the list then print out the list
		return null;
	}

	public List<String> getReviwerList() {
		// Iterating the list then print out everything
		return null;
	}
	
}
