package frontend;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.ScrollPaneConstants;

import mchacks2018.Note;

import java.util.ArrayList;

public class NoteDisplayPanel extends JPanel{

	public static void main(String [] args) {
		ArrayList<Note> testnotes = new ArrayList<Note>();
		for(int i = 0; i < 10; i++) {
			Note a = new Note(10, 10, 10, "" + i + "th Big time note taker over here");
			testnotes.add(a);
		}
		
	
		NoteDisplayPanel c = new NoteDisplayPanel(testnotes);
		
		JFrame test = new JFrame("Frame");
		test.setSize(1000, 400);
	    test.setResizable(false);
	    
	    test.getContentPane().setLayout(new FlowLayout());
	    test.getContentPane().add(c);
		test.setVisible(true);
		
	}
	
	
	public NoteDisplayPanel(ArrayList<Note> notes) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		NotePanel notePanel = new NotePanel(notes);
		scrollPane.setViewportView(notePanel);
		add(scrollPane);
		
		
	}
}
