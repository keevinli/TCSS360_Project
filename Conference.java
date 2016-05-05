package TCSS360;
import java.util.List;

public class Conference {
	private String Name;
	private User programChair;
	private String startingDate;
	private String endingDate;
	private String paperDeadline;
	private String reviewDeadline;
	private List<Manuscript> submittedManuscriptList;
	private List<User> subProChairList;
	
	public Conference(String theName, User theProgramChair,
					String theStartingDate, String theEndingDate, 
					String thePaperDeadline,String theReviewDeadline){
		this.Name = theName;
		this.programChair = theProgramChair;
		this.startingDate = theStartingDate;
		this.endingDate = theEndingDate;
		this.paperDeadline = thePaperDeadline;
		this.reviewDeadline = theReviewDeadline;
	}

	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public User getProgramChair() {
		return programChair;
	}
	
	public void setProgramChair(User programChair) {
		this.programChair = programChair;
	}
	
	public String getStartingDate() {
		return startingDate;
	}
	
	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}
	
	public String getEndingDate() {
		return endingDate;
	}
	
	public void setEndingDate(String endingDate) {
		this.endingDate = endingDate;
	}
	
	public String getPaperDeadline() {
		return paperDeadline;
	}
	
	public void setPaperDeadline(String paperDeadline) {
		this.paperDeadline = paperDeadline;
	}
	
	public String getReviewDeadline() {
		return reviewDeadline;
	}
	
	public void setReviewDeadline(String reviewDeadline) {
		this.reviewDeadline = reviewDeadline;
	}
	
	public List<Manuscript> getAllSubPaperList() {
		return submittedManuscriptList;
	}
	
	public List<User> getSubProChairList() {
		return subProChairList;
	}

	@Override
	public String toString() {
		return "conference [Name: " + Name + ", programChair: " + programChair
				+ ", startingDate: " + startingDate + ", endingDate: "
				+ endingDate + ", paperDeadline: " + paperDeadline
				+ ", reviewDeadline: " + reviewDeadline + "]";
	}
}
