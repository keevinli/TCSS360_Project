import java.util.Date;


public class Recommendation extends Paper {
	private int score; 
	
	public Recommendation(String thePath, String theAuthor, Date theSubmitDate, int theScore) {
		super(thePath, theAuthor, theSubmitDate);
		score = theScore;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Recommendation score: " + score + " "
				+ "Author: ";
	}
}
