package mchacks2018;

import java.time.LocalDateTime;

public class AcademicTopic extends Topic {
	private String faculty;
	private String semester;
		
	//Recording attributes
	private String location;
	private String prof;
	private String school;
	private String subject;
	private String description;
	
	
	public AcademicTopic(String location, String prof, String school,String subject) {
		this.location = location;
		this.prof = prof;
		this.school = school;
		this.subject = subject;
		dateCreated = LocalDateTime.now();
	}
	
	public void createAcademicRecording() {
		AcademicRecording newRecording = new AcademicRecording(prof, location, school, subject, description);
		recordings.add(newRecording);
		numRecordings++;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
