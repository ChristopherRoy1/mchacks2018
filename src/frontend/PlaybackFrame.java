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

public class PlaybackFrame extends JFrame{
	public PlaybackFrame() {
		
		VolumePanel volumePanel = new VolumePanel();
		getContentPane().add(volumePanel, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(10, 1, 0, 0));
		
		JTextPane txtpnAdamSucks = new JTextPane();
		txtpnAdamSucks.setText("Adam sucks");
		panel.add(txtpnAdamSucks);
		
		JTextPane txtpnBigTimeNote = new JTextPane();
		txtpnBigTimeNote.setText("big time note takeer");
		panel.add(txtpnBigTimeNote);
		
		JTextPane txtpnWhatIsUp = new JTextPane();
		txtpnWhatIsUp.setText("What is up");
		panel.add(txtpnWhatIsUp);
	}
}
