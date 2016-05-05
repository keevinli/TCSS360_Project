package TCSS360;

import java.io.Serializable;

public class SubprogramChair extends Roles implements Serializable {
	public SubprogramChair(Conference theConference) {
		super(theConference);
		// TODO Auto-generated constructor stub
	}


	
	
//	private void assignReviewer(User theReviewer) {
//		Roles rev = new Reviewer();
//		theReviewer.addMyRole(rev);
//		myReviewers.add((Reviewer)rev);
//	}
//	
//	private void assignReviewerManuscript(User theUser, Manuscript theManuscript) {
//		//Get instance of Reviewer 
//		List<Roles> roles = theUser.getMyRoles();
//		
//		
//		for(Roles r : roles) {
//			if(r.getClass().equals(Reviewer.class)){
//				theUser.addMyManuscript(theManuscript);
//			}
//		}
//		
//	}
//	
//	private void submitRecomendation(Manuscript theManuscript, int score) {
//		RecommendationForm form = new RecommendationForm(score);
//		//theManuscript.addRecomendation(form);
//	}

	
	
}
