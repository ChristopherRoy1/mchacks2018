package frontend;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlaybackButtonPanel extends JPanel {
	public PlaybackButtonPanel() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton = new JButton("<<");
		add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Play");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton(">>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNewButton_1);
	}

}
