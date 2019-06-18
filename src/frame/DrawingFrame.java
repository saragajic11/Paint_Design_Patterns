package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import controller.DrawingController;
import dialogs.DlgModifyCircle;
import view.DrawingView;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JToggleButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.Paint;

import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class DrawingFrame extends JFrame {

	private DrawingView drawingView = new DrawingView();
	private DrawingController controller;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnEdgeColor;
	private JButton btnAreaColor;
	private JButton btnModify;
	private JButton btnDelete;
	private JFileChooser jFileChooser;
	private JFileChooser openChooser;

	private JMenuItem mntmUndo;
	private JMenuItem mntmRedo;
	private JMenuItem mntmToFront;
	private JMenuItem mntmToBack;
	private JMenuItem mntmBringToFront;
	private JMenuItem mntmBringToBack;
	private JMenuItem mntmGetLog;
	
	private JList list;
	private DefaultListModel<String> dlmLogList;

	public DrawingView getView() {
		return drawingView;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}

	public DrawingFrame() {

		setTitle("Gajic Sara IT17-2016");
		drawingView.setBackground(Color.WHITE);
		getContentPane().add(drawingView, BorderLayout.CENTER);

		JPanel optionsView = new JPanel();
		getContentPane().add(optionsView, BorderLayout.NORTH);
		GridBagLayout gbl_optionsView = new GridBagLayout();
		gbl_optionsView.columnWidths = new int[] { 72, 72, 72, 72, 72, 72, 0 };
		gbl_optionsView.rowHeights = new int[] { 25, 25, 0 };
		gbl_optionsView.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_optionsView.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		optionsView.setLayout(gbl_optionsView);

		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglBtnClicked(tglbtnPoint.getActionCommand());

			}
		});
		buttonGroup.add(tglbtnPoint);
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.fill = GridBagConstraints.BOTH;
		gbc_tglbtnPoint.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPoint.gridx = 0;
		gbc_tglbtnPoint.gridy = 0;
		optionsView.add(tglbtnPoint, gbc_tglbtnPoint);

		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglBtnClicked(tglbtnLine.getActionCommand());

			}
		});
		buttonGroup.add(tglbtnLine);
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.fill = GridBagConstraints.BOTH;
		gbc_tglbtnLine.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnLine.gridx = 1;
		gbc_tglbtnLine.gridy = 0;
		optionsView.add(tglbtnLine, gbc_tglbtnLine);

		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglBtnClicked(tglbtnCircle.getActionCommand());

			}
		});
		buttonGroup.add(tglbtnCircle);
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.fill = GridBagConstraints.BOTH;
		gbc_tglbtnCircle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCircle.gridx = 2;
		gbc_tglbtnCircle.gridy = 0;
		optionsView.add(tglbtnCircle, gbc_tglbtnCircle);

		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglBtnClicked(tglbtnRectangle.getActionCommand());

			}
		});
		buttonGroup.add(tglbtnRectangle);
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.fill = GridBagConstraints.BOTH;
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnRectangle.gridx = 3;
		gbc_tglbtnRectangle.gridy = 0;
		optionsView.add(tglbtnRectangle, gbc_tglbtnRectangle);

		JToggleButton tglbtnSquare = new JToggleButton("Square");
		tglbtnSquare.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglBtnClicked(tglbtnSquare.getActionCommand());

			}
		});
		buttonGroup.add(tglbtnSquare);
		GridBagConstraints gbc_tglbtnSquare = new GridBagConstraints();
		gbc_tglbtnSquare.fill = GridBagConstraints.BOTH;
		gbc_tglbtnSquare.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnSquare.gridx = 4;
		gbc_tglbtnSquare.gridy = 0;
		optionsView.add(tglbtnSquare, gbc_tglbtnSquare);

		JToggleButton tglbtnHexagon = new JToggleButton("Hexagon");
		tglbtnHexagon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglBtnClicked(tglbtnHexagon.getActionCommand());

			}
		});
		buttonGroup.add(tglbtnHexagon);
		GridBagConstraints gbc_tglbtnHexagon = new GridBagConstraints();
		gbc_tglbtnHexagon.fill = GridBagConstraints.BOTH;
		gbc_tglbtnHexagon.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnHexagon.gridx = 5;
		gbc_tglbtnHexagon.gridy = 0;
		optionsView.add(tglbtnHexagon, gbc_tglbtnHexagon);

		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglBtnClicked(tglbtnSelect.getActionCommand());

			}
		});
		buttonGroup.add(tglbtnSelect);
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnSelect.gridx = 0;
		gbc_tglbtnSelect.gridy = 1;
		optionsView.add(tglbtnSelect, gbc_tglbtnSelect);

		btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.btnClicked(btnModify.getActionCommand());

			}
		});
		GridBagConstraints gbc_tglbtnModify = new GridBagConstraints();
		gbc_tglbtnModify.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnModify.gridx = 1;
		gbc_tglbtnModify.gridy = 1;
		optionsView.add(btnModify, gbc_tglbtnModify);
		btnModify.setEnabled(false);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.btnClicked(btnDelete.getActionCommand());

			}
		});
		GridBagConstraints gbc_tglbtnDelete = new GridBagConstraints();
		gbc_tglbtnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnDelete.gridx = 2;
		gbc_tglbtnDelete.gridy = 1;
		optionsView.add(btnDelete, gbc_tglbtnDelete);
		btnDelete.setEnabled(false);

		btnEdgeColor = new JButton("Edge color");
		btnEdgeColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEdgeColor.setBackground(controller.pickColor(btnEdgeColor.getBackground()));

			}
		});
		btnEdgeColor.setForeground(Color.WHITE);
		btnEdgeColor.setBackground(Color.BLACK);
		GridBagConstraints gbc_tglbtnEdgeColor = new GridBagConstraints();
		gbc_tglbtnEdgeColor.fill = GridBagConstraints.BOTH;
		gbc_tglbtnEdgeColor.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnEdgeColor.gridx = 3;
		gbc_tglbtnEdgeColor.gridy = 1;
		optionsView.add(btnEdgeColor, gbc_tglbtnEdgeColor);

		btnAreaColor = new JButton("Area color");
		btnAreaColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnAreaColor.setBackground(controller.pickColor(btnAreaColor.getBackground()));

			}
		});
		btnAreaColor.setBackground(Color.WHITE);
		GridBagConstraints gbc_tglbtnAreaColor = new GridBagConstraints();
		gbc_tglbtnAreaColor.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnAreaColor.gridx = 4;
		gbc_tglbtnAreaColor.gridy = 1;
		optionsView.add(btnAreaColor, gbc_tglbtnAreaColor);

		JPanel logView = new JPanel();
		getContentPane().add(logView, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane();
		logView.add(scrollPane);
		
		dlmLogList = new DefaultListModel<String>();

		list = new JList();
		list.setVisibleRowCount(4);
		list.setFixedCellWidth(600);
		scrollPane.setViewportView(list);
		list.setModel(dlmLogList);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setArmed(true);
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		/*mntmNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DrawingFrame frame = new DrawingFrame();
				
			}
		});*/
		mnFile.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openChooser = new JFileChooser();
				openChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				openChooser.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
				openChooser.enableInputMethods(true);
				openChooser.setMultiSelectionEnabled(false);
				openChooser.setFileHidingEnabled(false);
				openChooser.setEnabled(true);
				openChooser.setAcceptAllFileFilterUsed(false);
				
				openChooser.setFileFilter(new FileNameExtensionFilter("SerializeDraw", "ser"));
				openChooser.setFileFilter(new FileNameExtensionFilter("FileLog", "log"));
				controller.openFile();		
				
			}
		});
		mnFile.add(mntmOpen);

		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jFileChooser = new JFileChooser();
				jFileChooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
				jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				jFileChooser.enableInputMethods(false);
				jFileChooser.setMultiSelectionEnabled(false);
				jFileChooser.setFileHidingEnabled(false);
				jFileChooser.setEnabled(true);
				jFileChooser.setDialogTitle("Save");
				jFileChooser.setAcceptAllFileFilterUsed(false);

				controller.save();

			}
		});
		mnFile.add(mntmSave);

		mnFile.add(mntmClose);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		mntmUndo = new JMenuItem("Undo");
		mntmUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.undoRedo(mntmUndo.getActionCommand());
				
			}
		});
		mnEdit.add(mntmUndo);
		mntmUndo.setEnabled(false);

		mntmRedo = new JMenuItem("Redo");
		mntmRedo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.undoRedo(mntmRedo.getActionCommand());
				
			}
		});
		mnEdit.add(mntmRedo);
		mntmRedo.setEnabled(false);

		mntmToFront = new JMenuItem("To Front");
		mntmToFront.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.moveByZAxis(mntmToFront.getActionCommand());
				
			}
		});
		mnEdit.add(mntmToFront);
		mntmToFront.setEnabled(false);

		mntmToBack = new JMenuItem("To Back");
		mntmToBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.moveByZAxis(mntmToBack.getActionCommand());
				
			}
		});
		mnEdit.add(mntmToBack);
		mntmToBack.setEnabled(false);

		mntmBringToFront = new JMenuItem("Bring To Front");
		mntmBringToFront.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.moveByZAxis(mntmBringToFront.getActionCommand());
				
			}
		});
		mnEdit.add(mntmBringToFront);
		mntmBringToFront.setEnabled(false);

		mntmBringToBack = new JMenuItem("Bring To Back");
		mntmBringToBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.moveByZAxis(mntmBringToBack.getActionCommand());
				
			}
		});
		
		mnEdit.add(mntmBringToBack);
		mntmBringToBack.setEnabled(false);
		
		mntmGetLog = new JMenuItem("Get Log");
		mntmGetLog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.readCommand();
				
			}
		});
		mnEdit.add(mntmGetLog);
		mntmGetLog.setEnabled(false);

		drawingView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				controller.mouseClicked(arg0);

			}
		});
	}

	public JButton getBtnEdgeColor() {
		return btnEdgeColor;
	}

	public void setBtnEdgeColor(JButton btnEdgeColor) {
		this.btnEdgeColor = btnEdgeColor;
	}

	public JButton getBtnAreaColor() {
		return btnAreaColor;
	}

	public void setBtnAreaColor(JButton btnAreaColor) {
		this.btnAreaColor = btnAreaColor;
	}

	public JButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(JButton btnModify) {
		this.btnModify = btnModify;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JFileChooser getjFileChooser() {
		return jFileChooser;
	}

	public void setjFileChooser(JFileChooser jFileChooser) {
		this.jFileChooser = jFileChooser;
	}

	public JFileChooser getOpenChooser() {
		return openChooser;
	}

	public void setOpenChooser(JFileChooser openChooser) {
		this.openChooser = openChooser;
	}

	public JMenuItem getMntmUndo() {
		return mntmUndo;
	}

	public void setMntmUndo(JMenuItem mntmUndo) {
		this.mntmUndo = mntmUndo;
	}

	public JMenuItem getMntmRedo() {
		return mntmRedo;
	}

	public void setMntmRedo(JMenuItem mntmRedo) {
		this.mntmRedo = mntmRedo;
	}

	public JMenuItem getMntmToFront() {
		return mntmToFront;
	}

	public void setMntmToFront(JMenuItem mntmToFront) {
		this.mntmToFront = mntmToFront;
	}

	public JMenuItem getMntmToBack() {
		return mntmToBack;
	}

	public void setMntmToBack(JMenuItem mntmToBack) {
		this.mntmToBack = mntmToBack;
	}

	public JMenuItem getMntmBringToFront() {
		return mntmBringToFront;
	}

	public void setMntmBringToFront(JMenuItem mntmBringToFront) {
		this.mntmBringToFront = mntmBringToFront;
	}

	public JMenuItem getMntmBringToBack() {
		return mntmBringToBack;
	}

	public void setMntmBringToBack(JMenuItem mntmBringToBack) {
		this.mntmBringToBack = mntmBringToBack;
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public DefaultListModel<String> getDlmLogList() {
		return dlmLogList;
	}

	public void setDlmLogList(DefaultListModel<String> dlmLogList) {
		this.dlmLogList = dlmLogList;
	}

	public JMenuItem getMntmGetLog() {
		return mntmGetLog;
	}

	public void setMntmGetLog(JMenuItem mntmGetLog) {
		this.mntmGetLog = mntmGetLog;
	}
	
	
	

}
