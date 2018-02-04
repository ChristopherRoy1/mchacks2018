package frontend;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;

public class NoteDisplayPanel extends JPanel{
	public NoteDisplayPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		
		
		
		
		NotePanel notePanel = new NotePanel(null);
		scrollPane.setViewportView(notePanel);
	}
}
