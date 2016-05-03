package TCSS360;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String myName;
	private String myLoginName;
	private String myEmail;
	private List<Manuscript> myAuthoredManuscripts;
	private List<Roles> myRoles;
	private List<Manuscript> myManuscriptsToReview;
	private List<ReviewForm> myReviews;
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
