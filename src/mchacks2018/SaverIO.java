package mchacks2018;
import java.io.*;

// Make an object "Recording" that has general parameters for a recording (can extend to lecture/meeting objects):
class Recording implements Serializable{
	private String subject, description;
	private int date, time;
	
	// Constructor:
	public Recording(String subject, String description, int date, int time) {
		this.subject = subject;				// Subject (i.e MATH-240 or Town Hall Meeting)
		this.description = description;		// Description (i.e Lecture on Graphs -- make this an optional parameter with null???)
		this.date = date;					// Date in the form (yy,mm,dd) where event is at 20yy/mm/dd
		this.time = time;					// Start time in the form (hh:mm:ss:T) where T is either AM/PM (use boolean?) 
	}
	
	@Override
	public String toString() {
		return "asdf";
	}
}


// Class will serialize(save) objects as binary files.
public class SaverIO {
	
	// Main Method:
	public static void main(String[] args) {
		System.out.println("hello");
	}
}


