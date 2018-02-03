package mchacks2018;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class myEditor extends JFrame implements ActionListener
{
private JTextPane tp;
private int count;
private JMenuBar menuBar;
private JMenu fileM,editM,viewM;
private JToolBar topBar;
private JScrollPane scpane;
private JMenuItem exitI,cutI,copyI,pasteI,selectI,saveI,loadI,statusI;
private String pad;
private JToolBar toolBar;
private JComboBox fontList;
private JComboBox fontSizeChooser;
final JButton colorB;
private StringSelection stringSelection;
private Clipboard clpbrd;

public myEditor()
{
    super("Document");
    setSize(600, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = getContentPane();
    pane.setLayout(new BorderLayout());

    count = 0;
    pad = " ";
    tp = new JTextPane(); //textpane
    menuBar = new JMenuBar(); //menubar
    fileM = new JMenu("File"); //file menu
    editM = new JMenu("Edit"); //edit menu
    viewM = new JMenu("View"); //edit menu
    scpane = new JScrollPane(tp); //scrollpane  and add textarea to scrollpane
    exitI = new JMenuItem("Exit");
    cutI = new JMenuItem("Cut");
    copyI = new JMenuItem("Copy");
    pasteI = new JMenuItem("Paste");
    selectI = new JMenuItem("Select All"); //menuitems
    saveI = new JMenuItem("Save"); //menuitems
    loadI = new JMenuItem("Load"); //menuitems
    statusI = new JMenuItem("Status"); //menuitems
    toolBar = new JToolBar();
    topBar = new JToolBar();
    String[] fonts = {"Arial", "Times New Roman", "Comic Sans MS", "Courier New", "Windings"};
    String[] fontSizes = {"10", "12", "14", "16", "18", "20"};
    fontList = new JComboBox(fonts);
    fontSizeChooser = new JComboBox(fontSizes);
    colorB = new JButton("Colour");


    setJMenuBar(menuBar);
    menuBar.add(fileM);
    menuBar.add(editM);
    menuBar.add(viewM);

    fileM.add(saveI);
    fileM.add(loadI);
    fileM.add(exitI);

    editM.add(cutI);
    editM.add(copyI);
    editM.add(pasteI);        
    editM.add(selectI);

    viewM.add(statusI);

    saveI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    loadI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
    cutI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    copyI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    pasteI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
    selectI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

    pane.add(scpane,BorderLayout.CENTER);
    pane.add(toolBar,BorderLayout.SOUTH);
    pane.add(topBar,BorderLayout.NORTH);
    
    topBar.add(fontList);
    topBar.add(fontSizeChooser);
    topBar.add(colorB);
    
    fontList.setSelectedIndex(4);
    fontSizeChooser.setSelectedIndex(5);
    
    
    colorB.addActionListener(this);
    saveI.addActionListener(this);
    loadI.addActionListener(this);
    exitI.addActionListener(this);
    cutI.addActionListener(this);
    copyI.addActionListener(this);
    pasteI.addActionListener(this);
    selectI.addActionListener(this);
    statusI.addActionListener(this);
    fontList.addActionListener(this);
    
    //Color newColor = JColorChooser.showDialog(...);
    //SimpleAttributeSet attr = new SimpleAttributeSet();
    //StyleConstants.setForeground(attr, newColor);
    //tp.setCharacterAttributes(attr, false);

    setVisible(true);
}
public void actionPerformed(ActionEvent e) 
{
    JMenuItem choice = (JMenuItem) e.getSource();
    clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
    if (choice == saveI)
    {
        //not yet implmented
    }
    else if (choice == exitI)
        System.exit(0);
    else if (choice == cutI)
    {
        pad = tp.getSelectedText();
        tp.replaceSelection("");
        stringSelection = new StringSelection(pad);
		clpbrd.setContents(stringSelection, null); 
    }
    else if (choice == copyI) {
        pad = tp.getSelectedText();
    		stringSelection = new StringSelection(pad);
    		clpbrd.setContents(stringSelection, null);
    		
	} else if (choice == pasteI) {
		Transferable contents = clpbrd.getContents(null);
		boolean hasTransferableText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
		if(hasTransferableText) {
			try {
				pad = (String)contents.getTransferData(DataFlavor.stringFlavor);
			}
			catch (IOException | UnsupportedFlavorException ex) {
			      System.out.println(ex);
			      ex.printStackTrace();
			}
			
			tp.replaceSelection(pad);
		}
	
	}

        //tp.insert(pad, tp.getCaretPosition());
    else if (choice == selectI)
        tp.selectAll();
    else if (e.getSource() == statusI)
    {
        //not yet implmented
    }
}
public static void main(String[] args) 
{
    new myEditor();
}
}