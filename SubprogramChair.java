package TCSS360;

import java.io.Serializable;
import java.util.List;

public class SubprogramChair implements Roles, Serializable {
	private List<Reviewer> myReviewers;
	
	
	private void assignReviewer(User theReviewer) {
		Roles rev = new Reviewer();
		theReviewer.addMyRole(rev);
		myReviewers.add((Reviewer)rev);
	}
	
	private void assignReviewerManuscript(User theUser, Manuscript theManuscript) {
		//Get instance of Reviewer 
		List<Roles> roles = theUser.getMyRoles();
		
		
		for(Roles r : roles) {
			if(r.getClass().equals(Reviewer.class)){
				theUser.addMyManuscript(theManuscript);
			}
		}
		
	}
	
	private void submitRecomendation(Manuscript theManuscript, int score) {
		RecommendationForm form = new RecommendationForm(score);
		//theManuscript.addRecomendation(form);
	}

	
	
}
