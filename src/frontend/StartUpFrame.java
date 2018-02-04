package frontend;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI.MouseHandler;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class StartUpFrame extends JFrame {
	public StartUpFrame() {
		
		JButton btnasdf = new JButton("Create New Topic");
		getContentPane().add(btnasdf, BorderLayout.WEST);
		btnasdf.setPreferredSize(new Dimension(2*430/7,100));
		
		JButton btnNewButton = new JButton("Work in Existing Topic");
		getContentPane().add(btnNewButton, BorderLayout.CENTER);
		btnNewButton.setPreferredSize(new Dimension(3*430/7,100));
		
		JButton btnNewButton_1 = new JButton("Delete Topic");
		getContentPane().add(btnNewButton_1, BorderLayout.EAST);
		btnNewButton_1.setPreferredSize(new Dimension(2*430/7,100));
	}

	JFrame frame = new JFrame("ConText");
	JPanel panel = new JPanel(new GridLayout(1,3));
	
	
	
	
	public static void main(String[] args) {
		new StartUpFrame();
	}
}
