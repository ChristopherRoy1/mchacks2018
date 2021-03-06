package mchacks2018;
import java.io.*;
import java.util.ArrayList;


// Make an object AcademicRecording that corresponds to a single instance of a class recording:
public class AcademicRecording implements Serializable, Recording{
	private String prof, location, school, subject, description, date, time;
	private ArrayList<Note> listOfNotes;
	
	// Constructors:
	public AcademicRecording(String prof, String location, String school, String subject, String description, 
			String date, String time) {
		this.prof = prof;
		this.location = location;
		this.school = school;
		this.subject = subject;				// Subject (i.e MATH-323 or Town Hall Meeting)
		this.description = description;		// Description (i.e Lecture on Graphs -- make this optional???)
		this.date = date;					// Date in form mmddyy where event is at 20yy/mm/dd
		this.time = time;					// Start time in form hhmmT where T is either AM/PM (boolean?)
		this.listOfNotes = new ArrayList<Note>();
	}
	
	public AcademicRecording(String prof, String location, String school, String subject, String description) {
		this.prof = prof;					// Lecturer (i.e Prof. Albert Einstein)
		this.location = location;			// Location/Room (i.e Burnside 1B23)
		this.school = school;				// School/Institution (i.e McGill University)
		this.subject = subject;				// Subject (i.e MATH-323 or Town Hall Meeting)
		this.description = description;		// Description (i.e Lecture on Graphs -- make this optional???)
		this.listOfNotes = new ArrayList<Note>();
	}
	
	// Getter Methods:
	public String getProf() {
		return this.prof;
	}
	public String getLocation() {
		return this.location;
	}
	public String getSchool() {
		return this.school;
	}
	public String getSubject() {
		return this.subject;
	}
	public String getDescription() {
		return this.description;
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
	public String getHour() {
		return this.time.substring(0,1);
	}
	public String getMinute() {
		return this.time.substring(2,3);
	}	
	public String getTitle() {
		return this.getSubject() + " (" + this.getProf() + ", " + this.getSchool() + ") " + this.getDate() + ": " + this.getDescription();
	}
	public String getFilename() {
		return this.getSubject() + " " + this.getMonth() + this.getDay();
	}
	
	
	// Setter Methods:
	public void setProf(String prof) {
		this.prof = prof;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setSchool(String school) {
		this.school = school;
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
		return this.getTitle();
	}
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println("I am the main method");
	}
}
