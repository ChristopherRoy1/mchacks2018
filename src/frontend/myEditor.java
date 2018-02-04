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

public class myEditor extends JFrame implements ActionListener {
	private JTextPane tp;
	private int count;
	private JMenuBar menuBar;
	private JMenu fileM, editM, viewM;
	private JToolBar topBar;
	private JScrollPane scpane;
	private JMenuItem exitI, cutI, copyI, pasteI, selectI, saveI, loadI, statusI;
	private String pad;
	private JToolBar toolBar;
	private JComboBox fontList;
	private JComboBox fontSizeChooser;
	private JButton colorB;
	private JButton boldB;
	private JButton italicB;
	private JButton underlineB;
	private StringSelection stringSelection;
	private Clipboard clpbrd;
	private Font newButtonFont;
	private Action selectLine;
	private JMenuItem anItem;
	private JButton record;
	private long lastTimeStampRecorded;
	private long recordStart;
	private JLabel lblRecordingInProcess;
	private JButton btnStop;
	///

	public myEditor() {
		super("Document");
		
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());

		count = 0;
		pad = " ";
		tp = new JTextPane(); // textpane
		menuBar = new JMenuBar(); // menubar
		fileM = new JMenu("File"); // file menu
		editM = new JMenu("Edit"); // edit menu
		viewM = new JMenu("View"); // edit menu
		scpane = new JScrollPane(tp); // scrollpane and add textpane to scrollpane
		exitI = new JMenuItem("Exit");
		cutI = new JMenuItem("Cut");
		copyI = new JMenuItem("Copy");
		pasteI = new JMenuItem("Paste");
		selectI = new JMenuItem("Select All"); // menuitems
		saveI = new JMenuItem("Save"); // menuitems
		loadI = new JMenuItem("Load"); // menuitems
		statusI = new JMenuItem("Status"); // menuitems
		toolBar = new JToolBar();
		topBar = new JToolBar();
		String[] fonts = { "Arial", "Times New Roman", "Comic Sans MS", "Courier New", "Windings" };
		String[] fontSizes = { "10", "12", "14", "16", "18", "20" };
		fontList = new JComboBox(fonts);
		fontSizeChooser = new JComboBox(fontSizes);
		colorB = new JButton("Colour");
		boldB = new JButton("B");
		italicB = new JButton("I");
		underlineB = new JButton("U");
		record = new JButton("Record");

		newButtonFont = new Font(boldB.getFont().getName(), Font.BOLD, boldB.getFont().getSize());
		boldB.setFont(newButtonFont);

		newButtonFont = new Font(italicB.getFont().getName(), Font.CENTER_BASELINE, italicB.getFont().getSize());
		italicB.setFont(newButtonFont);

		newButtonFont = new Font(underlineB.getFont().getName(), Font.BOLD, underlineB.getFont().getSize());
		underlineB.setFont(newButtonFont);

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

		pane.add(scpane, BorderLayout.CENTER);
		pane.add(toolBar, BorderLayout.SOUTH);

		lblRecordingInProcess = new JLabel("Recording In Process...");
		toolBar.add(lblRecordingInProcess);

		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// controller
			}
		});
		btnStop.setHorizontalAlignment(SwingConstants.RIGHT);
		toolBar.add(btnStop);
		pane.add(topBar, BorderLayout.NORTH);

		topBar.add(fontList);
		topBar.add(fontSizeChooser);
		topBar.add(colorB);
		topBar.add(boldB);
		topBar.add(italicB);
		topBar.add(underlineB);
		topBar.add(record);

		// toolBar.

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

		tp.addMouseListener(new PopClickListener());

		KeyStroke enterKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		String bindingKey = enterKeyStroke.toString();

		// get our input map and action map
		int condition = JComponent.WHEN_FOCUSED;
		InputMap inputMap = tp.getInputMap(condition); // only want when focused
		ActionMap actionMap = tp.getActionMap();

		// set up the binding of the key stroke to the action
		inputMap.put(enterKeyStroke, bindingKey);
		actionMap.put(bindingKey, new enterAction());
		
		
		Action enterkey = new AbstractAction()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		        //Call the controller and generate a note
		    }
		};
		
		

		setVisible(true);

	}

	private class enterAction extends AbstractAction {
		
		public void actionPerformed(ActionEvent e) {
			long currentTime = getTimeStamp();
			// controller(lastTimeRecorded, currentTime, getNote());
			lastTimeStampRecorded = currentTime;
			String space = tp.getText();
			space += "\r\n";
			tp.setText(space);
		}
	}

	private long getTimeStamp() {
		return System.currentTimeMillis();
	}

	class PopClickListener extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {

			if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
				selectLine = getAction(DefaultEditorKit.selectLineAction);
				selectLine.actionPerformed(null);

			}
		}

		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger())
				doPop(e);
		}

		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger()) {

				doPop(e);

			}
		}

		private void doPop(MouseEvent e) {
			PopUpDemo menu = new PopUpDemo();
			menu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	private Action getAction(String name) {
		Action action = null;
		Action[] actions = tp.getActions();

		for (int i = 0; i < actions.length; i++) {
			if (name.equals(actions[i].getValue(Action.NAME).toString())) {
				action = actions[i];
				break;
			}
		}
		return action;
	}

	class PopUpDemo extends JPopupMenu {

		public PopUpDemo() {
			anItem = new JMenuItem(new MyAction());
			add(anItem);
		}
	}

	public class MyAction extends AbstractAction {
		public MyAction() {
			super("Listen 2 Recording");
		}

		public void actionPerformed(ActionEvent e) {
			String temp = tp.getSelectedText();
			// use temp and run thru arraylist of Notes & then play the video
		}
	}

	public void actionPerformed(ActionEvent e) {
		JMenuItem choice = (JMenuItem) e.getSource();
		JButton butchoice = (JButton) e.getSource();
		boolean recording = false;

		clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		if (choice == saveI) {
			// not yet implmented
		} else if (choice == exitI)
			System.exit(0);
		else if (choice == cutI) {
			pad = tp.getSelectedText();
			tp.replaceSelection("");
			stringSelection = new StringSelection(pad);
			clpbrd.setContents(stringSelection, null);
		} else if (choice == copyI) {
			pad = tp.getSelectedText();
			stringSelection = new StringSelection(pad);
			clpbrd.setContents(stringSelection, null);

		} else if (choice == pasteI) {
			Transferable contents = clpbrd.getContents(null);
			boolean hasTransferableText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
			if (hasTransferableText) {
				try {
					pad = (String) contents.getTransferData(DataFlavor.stringFlavor);
				} catch (IOException | UnsupportedFlavorException ex) {
					System.out.println(ex);
					ex.printStackTrace();
				}

				tp.replaceSelection(pad);
			}

		} else if (choice == anItem) {
			System.out.println("Haha");
		}

		// tp.insert(pad, tp.getCaretPosition());
		else if (choice == selectI)
			tp.selectAll();
		else if (e.getSource() == statusI) {
			// not yet implmented
		}

		if (butchoice == record) {
			if (!recording) {
				recordStart = getTimeStamp();
				lastTimeStampRecorded = recordStart;
				record.setText("Stop");
				recording = true;
				// Controller.startRecording(recordStart);
			} else {
				// controller
				recording = false;
				record.setText("Record");
			}
		}
	}

	public static void main(String[] args) {
		new myEditor();
	}

	public String getNote() {
		String entireNote = tp.getText();
		String[] array = entireNote.split("\n");
		return array[array.length - 1];
	}

}