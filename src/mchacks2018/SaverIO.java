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
	
	// Getter Methods:
	public String getTitle() {
		return this.getSubject() + " (" + this.getDate() + "): " + this.getDescription();
		// DO THIS - returns Subject (date, time): Description
	}
	public String getSubject() {
		return this.subject;
	}
	public String getDescription() {
		return this.description;
	}
	public String getDateString() {
		return this.date;
	}
	public int getMonthNumber() {
		return Integer.parseInt(this.date.substring(0,2));
	}
	public String getMonth() {
		int monthNumber = this.getMonthNumber();
		String monthString;
		switch(monthNumber) {
		case 1: monthString = "January"; break;
		case 2: monthString = "February"; break;
		case 3: monthString = "March"; break;
		case 4: monthString = "April"; break;
		case 5: monthString = "May"; break;
		case 6: monthString = "June"; break;
		case 7: monthString = "July"; break;
		case 8: monthString = "August"; break;
		case 9: monthString = "September"; break;
		case 10: monthString = "October"; break;
		case 11: monthString = "November"; break;
		case 12: monthString = "December"; break;
		default: monthString = "Invalid Month"; break;
		}
		return monthString;
	}
	public int getDayNumber() {
		return Integer.parseInt(this.date.substring(2,4));
	}	
	public String getDay() {
		int dayNumber = this.getDayNumber();
		String prefix;
		switch(dayNumber) {
		case 1: prefix = "st"; break;
		case 2: prefix = "nd"; break;
		case 3: prefix = "rd"; break;
		case 21: prefix = "st"; break;
		case 22: prefix = "nd"; break;
		case 23: prefix = "rd"; break;
		case 31: prefix = "st"; break;
		default: prefix = "th"; break;
		}
		return dayNumber + prefix;
	}
	public int getYear() {
		return 2000 + Integer.parseInt(this.date.substring(4,6));
	}
	public String getDate() {
		return this.getMonth() + " " + this.getDay() + ", " + this.getYear();
	}
	public String getTime() {
		return this.time;
	}
	public String getHour() {
		return this.time.substring(0,1);
	}
	public String getMinute() {
		return this.time.substring(2,3);
	}	
	
	// Setter Methods:
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
		return this.getTitle();
	}
}


// SaverIO Class will serialize(save) objects as binary files.
public class SaverIO {
	
	// Main Method:
	public static void main(String[] args) {
		Recording myRecording = new Recording("MATH-323", "First Probability Lecture", "010318", "08300");
		try {
			saveToFile(myRecording);
		}
		catch (IOException e) {
			e.getMessage();
		}
	}
	
	public static void saveToFile(Recording r) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Recording.bin"));
			objectOutputStream.writeObject(r);
	}
	
	public static void getFromFile() {
		
	}
}


