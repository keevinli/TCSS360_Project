package TCSS360;

import java.io.Serializable;


public class RecommendationForm extends Paper implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3321573126528462233L;
	private int myScore; 
	
	public RecommendationForm(String thePath, String theAuthor, String theSubmitDate, String theTitle, int theScore) {
		super(thePath, theAuthor, theSubmitDate, theTitle);
		myScore = theScore;
	}

	public int getScore() {
		return myScore;
	}

	public void setScore(int theScore) {
		this.myScore = theScore;
	}

	@Override
	public String toString() {
		return "Recommendation score: " + myScore + " "
				+ "Author: ";
	}
}
