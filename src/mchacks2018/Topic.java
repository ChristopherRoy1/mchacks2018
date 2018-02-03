package mchacks2018;

import java.util.ArrayList;

public class Topic {
	String name;
	ArrayList<Recording> recordings;
	int numRecordings;
	
	public Topic() {
		numRecordings=0;
		recordings = new ArrayList<Recording>();
	}
	
	public void addRecording(Recording NewRecording) {
		recordings.add(NewRecording);
	}
	
	public Recording getRecording(int index) {
		return recordings.get(index);
	}
	
	public Recording removeRecording(Recording a) {
		
		for(int i = 0; i < recordings.size(); i++) {
			if(recordings.get(i).equals(a)) {
				return a;
			}
		}
		return null;
				
	}
	
}
