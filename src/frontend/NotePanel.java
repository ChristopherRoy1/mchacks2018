package frontend;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JTextPane;

import mchacks2018.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NotePanel extends JPanel {
	ArrayList<Note> notes;
	int numNotes = 0;
	int notesAdded = 0;
	public static void main(String [] args) {
		ArrayList<Note> testnotes = new ArrayList<Note>();
		for(int i = 0; i < 10; i++) {
			Note a = new Note(10, 10, 10, "" + i + "th Big time note taker over here");
			testnotes.add(a);
		}
		JFrame frame = new JFrame("Frame");
		frame.setSize(1000, 700);
	    frame.setResizable(false);
		
		NotePanel a = new NotePanel(testnotes);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(a);
		
		//frame.pack();
		frame.setVisible(true);
	}
	
	
	public NotePanel(ArrayList<Note> notes) {
		this.notes = notes;
		this.numNotes = notes.size();
		initializePanel();
		
		for(int i = 0; i < numNotes; i++) {
			createNote(notes.get(i));
		}
				
			
	}
	
	private void createNote(Note currNote) {
		JTextArea newArea = new JTextArea();
		newArea.setText(currNote.getContent());
		GridBagConstraints gbc_newArea = new GridBagConstraints();
		gbc_newArea.insets = new Insets(0, 0, 0, 5);
		gbc_newArea.fill = GridBagConstraints.BOTH;
		gbc_newArea.gridx = 0;
		gbc_newArea.gridy = notesAdded;
		
		newArea.setEditable(false);
		attachListeners(newArea);
		add(newArea, gbc_newArea);
		notesAdded++;
	}
		
	
	
	private void initializePanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTextArea txtrHello = new JTextArea();
		txtrHello.setEditable(false);
		txtrHello.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		txtrHello.setText("hello");
		GridBagConstraints gbc_txtrHello = new GridBagConstraints();
		gbc_txtrHello.insets = new Insets(0, 0, 5, 5);
		gbc_txtrHello.fill = GridBagConstraints.BOTH;
		gbc_txtrHello.gridx = 0;
		gbc_txtrHello.gridy = 11;
		add(txtrHello, gbc_txtrHello);
	}
	
	private void attachListeners(JTextArea a) {
		a.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					if(!a.isEditable())
						a.setEditable(true);
					else
						a.setEditable(false);					
					
				}
			}
		});
	}
	
}
