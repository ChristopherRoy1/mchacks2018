package mchacks2018;

public class AcademicTopic extends Topic {
	String faculty;
	String semester;
	
	String dateCreated;
	
	
	
	//Recording attributes
	private String location;
	private String prof;
	private String school;
	private String subject;
	private String description;
	
	
	public AcademicTopic() {
		
	}
	
	public void createRecording() {
		AcademicRecording a = new AcademicRecording(prof,location, school, subject, description);
	}
	
	
	
}
