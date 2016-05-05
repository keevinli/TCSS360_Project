package TCSS360;

import java.io.Serializable;
import java.util.List;

public class Manuscript extends Paper implements Serializable {

	private int myRecommendation;
	private Status myStatus;
	private List<ReviewForm> myReviewFormList;
	private List<User> myReviewerList;
	private List<RecommendationForm> myRecomFormList;
	

	 public static enum Status {
		 //Paper status
		 SUBMITTED, RECOMMENDED, ACCEPTED, REJECTED;
	 }

	public Manuscript(String thePath, String theAuthor, String theSubmitDate,
			String theTitle) {
		super(thePath, theAuthor, theSubmitDate, theTitle);
		myStatus = Status.SUBMITTED;
	}

	public Status getStatus() {
		return myStatus;
	}

	public void setStatus(Status status) {
		this.myStatus = status;
	}

	public int getRecommendation() {
		return myRecommendation;
	}

	public void setRecommendation(int recommendation) {
		this.myRecommendation = recommendation;
	}

	public List<ReviewForm> getReviewList() {
		return myReviewFormList;
	}
	
	public void addReviewForm(ReviewForm theReview){
		myReviewFormList.add(theReview);
	}

	public List<User> getReviwerList() {
		// Iterating the list then print out everything
		return myReviewerList;
	}
	
	public void addReviewer(User theReviewer){
		myReviewerList.add(theReviewer);
	}
	
	public List<RecommendationForm> getRecomForm() {
		return myRecomFormList;
	}
	
	public void addRecommendation (RecommendationForm theRecom){
		myRecomFormList.add(theRecom);
	}
}
