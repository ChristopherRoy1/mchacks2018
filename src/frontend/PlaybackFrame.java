package frontend;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import javax.swing.DropMode;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import mchacks2018.Note;

import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import java.util.ArrayList;

public class PlaybackFrame extends JFrame{
	public static void main (String [] args) {
		ArrayList<Note> testnotes = new ArrayList<Note>();
		for(int i = 0; i < 10; i++) {
			Note a = new Note(10, 10, 10, "" + i + "th Big time note taker over here");
			testnotes.add(a);
		}
		PlaybackFrame a = new PlaybackFrame(testnotes);
		a.setVisible(true);
		
	}
	public PlaybackFrame(ArrayList<Note> notes) {
		
		VolumePanel volumePanel = new VolumePanel();
		getContentPane().add(volumePanel, BorderLayout.SOUTH);
		
		
		NoteDisplayPanel noteDisplayPanel = new NoteDisplayPanel(notes);
		getContentPane().add(noteDisplayPanel, BorderLayout.CENTER);
	}
}
