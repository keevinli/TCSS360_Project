import java.util.Date;
import java.util.List;


public class conference {
	private String Name;
	private String programChair;
	private Date startingDate;
	private Date endingDate;
	private Date paperDeadline;
	private Date reviewDeadline;
	private List<Paper> allSubPaperList;
	private List<String> subProChairList;
	
	public conference(String theName, String theProgramChair,
					Date theStartingDate, Date theEndingDate, 
					Date thePaperDeadline,Date theReviewDeadline){
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
	
	public String getProgramChair() {
		return programChair;
	}
	
	public void setProgramChair(String programChair) {
		this.programChair = programChair;
	}
	
	public Date getStartingDate() {
		return startingDate;
	}
	
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	
	public Date getEndingDate() {
		return endingDate;
	}
	
	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	
	public Date getPaperDeadline() {
		return paperDeadline;
	}
	
	public void setPaperDeadline(Date paperDeadline) {
		this.paperDeadline = paperDeadline;
	}
	
	public Date getReviewDeadline() {
		return reviewDeadline;
	}
	
	public void setReviewDeadline(Date reviewDeadline) {
		this.reviewDeadline = reviewDeadline;
	}
	
	public List<Paper> getAllSubPaperList() {
		return allSubPaperList;
	}
	
	public List<String> getSubProChairList() {
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
