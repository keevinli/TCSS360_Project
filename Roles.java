package TCSS360;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Roles implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8960444196072543003L;
	private Conference myConference;
	
	public Roles (Conference theConference) {
		myConference = theConference;
	}
	
	public void setConference(Conference theConference) {
		myConference = theConference;
	}
	
	public Conference getConference() {
		return myConference;
	}
}
