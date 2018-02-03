package mchacks2018;
import java.io.*;

// Make an object "Recording" that has general parameters for a recording (can extend to lecture/meeting objects):
class Recording implements Serializable{
	private String subject, description, date, time;
	
	// Constructor:
	public Recording(String subject, String description, String date, String time) {
		this.subject = subject;				// Subject (i.e MATH-323 or Town Hall Meeting)
		this.description = description;		// Description (i.e Lecture on Graphs -- make this optional???)
		this.date = date;					// Date in form mmddyy where event is at 20yy/mm/dd
		this.time = time;					// Start time in form hhmmT where T is either AM/PM (boolean?) 
	}
	
	// Getters and Setters:
	public String getSubject(Recording r) {
		return r.subject;
	}
	public String getDescription(Recording r) {
		return r.description;
	}
	public String getDate(Recording r) {
		return r.date;
	}
	public String getMonth(Recording r) {
		return r.date.substring(0,1);
	}
	public String getDay(Recording r) {
		return r.date.substring(2,3);
	}	
	public String getYear(Recording r) {
		return "20" + r.date.substring(4,5);
	}
	public String getTime(Recording r) {
		return r.time;
	}
	public String getHour(Recording r) {
		return r.time.substring(0,1);
	}
	public String getMinute(Recording r) {
		return r.time.substring(2,3);
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	

	@Override
	public String toString() {
		return this.subject + " at " + date + time;
	}
}


// Class will serialize(save) objects as binary files.
public class SaverIO {
	
	// Main Method:
	public static void main(String[] args) {
		Recording myRecording = new Recording("MATH-323", "First Probability Lecture", "012518", "08300");
	}
	
	public static void saveToFile(Recording r) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Recording.bin"));
			objectOutputStream.writeObject(r);
	}
	
	public static void getFromFile() {
		
	}
}


