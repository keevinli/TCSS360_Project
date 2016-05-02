package TCSS360;

import java.util.List;

public class User {
	
	private String myName;
	private String myLoginName;
	private String myEmail;
	private List<Manuscript> myManuscripts;
	private List<Roles> myRoles;
	private List<Manuscript> myManuscriptsToReview;
	private List<Conference> mySubprogChairsConferences;
	
	public User(String theName, String theLoginName, String theEmail,
			List<Manuscript> theManuscripts, List<Roles> theRoles,
			List<Manuscript> theManuscriptsToReview,
			List<Conference> theSubprogChairsConferences) {
		super();
		this.myName = theName;
		this.myLoginName = theLoginName;
		this.myEmail = theEmail;
		this.myManuscripts = theManuscripts;
		this.myRoles = theRoles;
		this.myManuscriptsToReview = theManuscriptsToReview;
		this.mySubprogChairsConferences = theSubprogChairsConferences;
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
		return myManuscripts;
	}

	public void addMyManuscript(Manuscript theManuscript) {
		this.myManuscripts.add(theManuscript);
	}

	public void removeManuscript(Manuscript theManuscript) {
		this.myManuscripts.remove(theManuscript);
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

	public List<Conference> getMySubprogChairsConferences() {
		return mySubprogChairsConferences;
	}

	public void addMySubprogChairsConferences(Conference theSubprogChairsConference) {
		this.mySubprogChairsConferences.add(theSubprogChairsConference);
	}
	
	public void removeMySubprogChairsConferences(Conference theSubprogChairsConference) {
		this.mySubprogChairsConferences.remove(theSubprogChairsConference);
	}

}
