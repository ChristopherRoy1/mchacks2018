package mchacks2018;

import java.util.ArrayList;
import javax.swing.*;

public class Controller {
	boolean isPlaying;
	JFrame currentView;
	Topic currentTopic;
	Recording currentRecording;
	ArrayList<Recording> listOfRecordings;
	//add any more objects that we need here
	
	
	// Constructors that make sure that only one instance of controller exists (called myController):
	private static Controller myController = null;
	private Controller() {
	// does nothing
		}
	public static Controller getInstance() {
		if(myController == null) {
			myController = new Controller();
		}
		return myController;
	}
	
	//
	
	
	
	
	
	
	
}
