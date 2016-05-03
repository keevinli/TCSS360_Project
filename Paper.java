package TCSS360;

import java.io.Serializable;
import java.util.Date;

public class Paper implements Serializable {
	
	private String myPath;
	private String myAuthor;
	private String mySubmitDate;
	private String myTitle;
	
	public Paper(String thePath, String theAuthor, String theDate,
			     String theTitle) {
		myPath = thePath;
		myAuthor = theAuthor;
		mySubmitDate = theDate;
		myTitle = theTitle;
	}
	
	public String getPath() {
		return myPath;
	}

	public void setPath(String path) {
		this.myPath = path;
	}

	public String getAuthor() {
		return myAuthor;
	}

	public void setAuthor(String author) {
		this.myAuthor = author;
	}

	public String getSubmitDate() {
		return mySubmitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.mySubmitDate = submitDate;
	}
	
	public String getTitle(){
		return myTitle;
	}
	
	public void setTitle(String theTitle) {
		myTitle = theTitle;
	}
}
