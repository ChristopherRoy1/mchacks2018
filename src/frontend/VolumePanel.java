package frontend;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class VolumePanel extends JPanel{
	public VolumePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JSlider slider = new JSlider();
		add(slider, BorderLayout.SOUTH);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("00:01/50:47");
		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		
		add(textPane, BorderLayout.NORTH);
		
		PlaybackButtonPanel playbackButtonPanel = new PlaybackButtonPanel();
		add(playbackButtonPanel, BorderLayout.CENTER);
	}

}
