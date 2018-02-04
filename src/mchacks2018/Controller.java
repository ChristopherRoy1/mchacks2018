package mchacks2018;

import javax.swing.*;

public class Controller {
	boolean isPlaying;
	JFrame currentView;
	//add objects that we need here
	
	
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
	
	
	
}
