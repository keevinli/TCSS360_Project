import java.util.Date;


public class Paper {
	public String path;
	public String author;
	public Date submitDate;
	
	public Paper(String thePath, String theAuthor, Date theSubmitDate){
		path = thePath;
		author = theAuthor;
		submitDate = theSubmitDate;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
}
