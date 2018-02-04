package mchacks2018;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Topic {
	LocalDateTime dateCreated;
	ArrayList<Recording> recordings;
	int numRecordings;
	
	public Topic() {
		dateCreated = LocalDateTime.now();
		numRecordings=0;
		recordings = new ArrayList<Recording>();
	}
	
	public void addRecording(Recording NewRecording) {
		recordings.add(NewRecording);
		numRecordings++;
	}
	
	public Recording getRecording(int index) {
		return recordings.get(index);
	}
	
	public Recording removeRecording(Recording a) {		
		for(int i = 0; i < recordings.size(); i++) {
			if(recordings.get(i).equals(a)) {
				numRecordings--;
				return a;
			}
		}
		return null;				
	}	
	
	public ArrayList<Recording> getAllRecordings(){
		return recordings;
	}
	
		
}
	