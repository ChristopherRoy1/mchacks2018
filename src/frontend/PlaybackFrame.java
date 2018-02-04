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
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import java.util.ArrayList;

public class PlaybackFrame extends JFrame{
	public PlaybackFrame(ArrayList<notes> notes) {
		
		VolumePanel volumePanel = new VolumePanel();
		getContentPane().add(volumePanel, BorderLayout.SOUTH);
		
		NoteDisplayPanel noteDisplayPanel = new NoteDisplayPanel((ArrayList) null);
		getContentPane().add(noteDisplayPanel, BorderLayout.CENTER);
	}
}
