package mchacks2018;

public class Note {
	private final long recordingStart;	
	private final long noteStart;
	private final long noteEnd;
	private String content;
	
	public Note(long recordingStart, long noteStart, long noteEnd, String content) {
		this.recordingStart = recordingStart;
		this.noteStart = noteStart;
		this.noteEnd = noteEnd;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getRecordingStart() {
		return recordingStart;
	}

	public long getNoteStart() {
		return noteStart;
	}

	public long getNoteEnd() {
		return noteEnd;
	}
	
	
}
