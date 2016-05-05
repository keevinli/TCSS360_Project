package TCSS360;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class User {
	
	private String myName;
	private String myLoginName;
	private String myEmail;
	private List<Manuscript> myAuthoredManuscripts;
	private List<Roles> myRoles;
	private List<Manuscript> myManuscriptsToReview;
	private List<Manuscript> mySubProgManuscripts;
	private List<ReviewForm> myReviews;
	private List<User> myReviewers;
	//private List<Conference> mySubprogChairsConferences;
	
	public User(String theName, String theLoginName, String theEmail) {
		super();
		this.myName = theName;
		this.myLoginName = theLoginName;
		this.myEmail = theEmail;
		this.myAuthoredManuscripts = new ArrayList<Manuscript>();
		this.myRoles = new ArrayList<Roles>();
		this.myManuscriptsToReview = new ArrayList<Manuscript>();
		this.myReviews = new ArrayList<ReviewForm>();
		this.mySubProgManuscripts = new ArrayList<Manuscript>();
		//this.mySubprogChairsConferences = theSubprogChairsConferences;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String theName) {
		this.myName = theName;
	}

	public String getMyLoginName() {
		return myLoginName;
	}

	public void setMyLoginName(String theLoginName) {
		this.myLoginName = theLoginName;
	}

	public String getMyEmail() {
		return myEmail;
	}

	public void setMyEmail(String theEmail) {
		this.myEmail = theEmail;
	}

	public List<Manuscript> getMyManuscripts() {
		return myAuthoredManuscripts;
	}
	
	public void addSubProgManuscript(Manuscript theManuscript) {
		this.mySubProgManuscripts.add(theManuscript);
	}

	public void addMyManuscript(Manuscript theManuscript) {
		this.myAuthoredManuscripts.add(theManuscript);
	}

	public void removeManuscript(Manuscript theManuscript) {
		this.myAuthoredManuscripts.remove(theManuscript);
	}
	
	public List<Roles> getMyRoles() {
		return myRoles;
	}

	public void addMyRole(Roles theRole) {
		this.myRoles.add(theRole);
	}
	
	public void removeMyRole(Roles theRole) {
		this.myRoles.remove(theRole);
	}

	public List<Manuscript> getMyManuscriptsToReview() {
		return myManuscriptsToReview;
	}

	public void addMyManuscriptsToReview(Manuscript theManuscript) {
		this.myManuscriptsToReview.add(theManuscript);
	}
	
	public void removeMyManuscriptsToReview(Manuscript theManuscript) {
		this.myManuscriptsToReview.remove(theManuscript);
	}
	

	public List<ReviewForm> getMyReviews() {
		return myReviews;
	}
	
	public void addReview(ReviewForm theReview) {
		this.myReviews.add(theReview);
	}
	
	public void removeReview(ReviewForm theReview) {
		this.myReviews.remove(theReview);
	}

	public List<User> getMyReviewers() {
		return myReviewers;
	}

	public void addMyReviewers(User theReviewers) {
		this.myReviewers.add(theReviewers);
	}
	
	public void submitManuscript(final String thePath, String theTitle) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		
		Manuscript newPaper = new Manuscript(thePath, Main.currentUser.getMyName(), date, theTitle);
		
		Main.currentUser.addMyManuscript(newPaper);
		Main.currentConference.addManuscript(newPaper);
		if(!Main.hasRole(Main.currentConference, Main.AUTHOR)) {
			Main.currentUser.addMyRole(new Author(Main.currentConference));
		}
		System.out.println(newPaper.getTitle() + " submitted to Conference " + Main.currentConference.getName());
	}

	public Author findAuthorRole() {
		Author AuthorRole = null;
		for(Roles r : this.getMyRoles()) {
			if(r instanceof Author) {
				AuthorRole = (Author) r;
			}
		}
		return AuthorRole;
	}
	
//	public List<Conference> getMySubprogChairsConferences() {
//		return mySubprogChairsConferences;
//	}
//
//	public void addMySubprogChairsConferences(Conference theSubprogChairsConference) {
//		this.mySubprogChairsConferences.add(theSubprogChairsConference);
//	}
//	
//	public void removeMySubprogChairsConferences(Conference theSubprogChairsConference) {
//		this.mySubprogChairsConferences.remove(theSubprogChairsConference);
//	}

}
