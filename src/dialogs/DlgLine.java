package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import shapes.Line;
import shapes.Point;

import javax.swing.JButton;
import javax.swing.JColorChooser;

public class DlgLine extends JDialog {
	private JTextField txtXCordStartP;
	private JTextField txtYCordStartP;
	private JTextField txtXCordEndP;
	private JTextField txtYCordEndP;
	private int xCordStartP;
	private int yCordStartP;
	private int xCordEndP;
	private int yCordEndP;
	private boolean canceled;
	private Color borderColor;
	private JButton btnBorderColor;
	private Line line;
	
	public static void main (String [] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DlgLine() {
		setTitle("Update Line");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 400, 250);
		setLocationRelativeTo(null);
		JPanel pnlUpdateLine = new JPanel();
		getContentPane().add(pnlUpdateLine, BorderLayout.CENTER);
		GridBagLayout gbl_pnlUpdateLine = new GridBagLayout();
		gbl_pnlUpdateLine.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlUpdateLine.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlUpdateLine.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlUpdateLine.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlUpdateLine.setLayout(gbl_pnlUpdateLine);
		
		JLabel lblXCoordinateOf = new JLabel("X coordinate of start point:");
		GridBagConstraints gbc_lblXCoordinateOf = new GridBagConstraints();
		gbc_lblXCoordinateOf.insets = new Insets(10, 10, 5, 5);
		gbc_lblXCoordinateOf.gridx = 1;
		gbc_lblXCoordinateOf.gridy = 0;
		pnlUpdateLine.add(lblXCoordinateOf, gbc_lblXCoordinateOf);
		
		txtXCordStartP = new JTextField();
		GridBagConstraints gbc_txtXCordStartP = new GridBagConstraints();
		gbc_txtXCordStartP.insets = new Insets(10, 0, 5, 5);
		gbc_txtXCordStartP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXCordStartP.gridx = 2;
		gbc_txtXCordStartP.gridy = 0;
		pnlUpdateLine.add(txtXCordStartP, gbc_txtXCordStartP);
		txtXCordStartP.setColumns(10);
		
		JLabel lblYCoordinateOf = new JLabel("Y coordinate of start point:");
		GridBagConstraints gbc_lblYCoordinateOf = new GridBagConstraints();
		gbc_lblYCoordinateOf.anchor = GridBagConstraints.EAST;
		gbc_lblYCoordinateOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblYCoordinateOf.gridx = 1;
		gbc_lblYCoordinateOf.gridy = 1;
		pnlUpdateLine.add(lblYCoordinateOf, gbc_lblYCoordinateOf);
		
		txtYCordStartP = new JTextField();
		GridBagConstraints gbc_txtYCordStartP = new GridBagConstraints();
		gbc_txtYCordStartP.insets = new Insets(0, 0, 5, 5);
		gbc_txtYCordStartP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYCordStartP.gridx = 2;
		gbc_txtYCordStartP.gridy = 1;
		pnlUpdateLine.add(txtYCordStartP, gbc_txtYCordStartP);
		txtYCordStartP.setColumns(10);
		
		JLabel lblXCoordinateOf_1 = new JLabel("X coordinate of end point:");
		GridBagConstraints gbc_lblXCoordinateOf_1 = new GridBagConstraints();
		gbc_lblXCoordinateOf_1.anchor = GridBagConstraints.EAST;
		gbc_lblXCoordinateOf_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblXCoordinateOf_1.gridx = 1;
		gbc_lblXCoordinateOf_1.gridy = 2;
		pnlUpdateLine.add(lblXCoordinateOf_1, gbc_lblXCoordinateOf_1);
		
		txtXCordEndP = new JTextField();
		GridBagConstraints gbc_txtXCordEndP = new GridBagConstraints();
		gbc_txtXCordEndP.insets = new Insets(0, 0, 5, 5);
		gbc_txtXCordEndP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXCordEndP.gridx = 2;
		gbc_txtXCordEndP.gridy = 2;
		pnlUpdateLine.add(txtXCordEndP, gbc_txtXCordEndP);
		txtXCordEndP.setColumns(10);
		
		JLabel lblYCoordinateOf_1 = new JLabel("Y coordinate of end point:");
		GridBagConstraints gbc_lblYCoordinateOf_1 = new GridBagConstraints();
		gbc_lblYCoordinateOf_1.anchor = GridBagConstraints.EAST;
		gbc_lblYCoordinateOf_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblYCoordinateOf_1.gridx = 1;
		gbc_lblYCoordinateOf_1.gridy = 3;
		pnlUpdateLine.add(lblYCoordinateOf_1, gbc_lblYCoordinateOf_1);
		
		txtYCordEndP = new JTextField();
		GridBagConstraints gbc_txtYCordEndP = new GridBagConstraints();
		gbc_txtYCordEndP.anchor = GridBagConstraints.NORTH;
		gbc_txtYCordEndP.insets = new Insets(0, 0, 5, 5);
		gbc_txtYCordEndP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYCordEndP.gridx = 2;
		gbc_txtYCordEndP.gridy = 3;
		pnlUpdateLine.add(txtYCordEndP, gbc_txtYCordEndP);
		txtYCordEndP.setColumns(10);
		
		btnBorderColor = new JButton("Border color");
		btnBorderColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnBorderColor.setBackground(JColorChooser.showDialog(null, "Choose color", btnBorderColor.getBackground()));
				
			}
		});
		GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
		gbc_btnBorderColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnBorderColor.gridx = 2;
		gbc_btnBorderColor.gridy = 5;
		pnlUpdateLine.add(btnBorderColor, gbc_btnBorderColor);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					xCordStartP=Integer.parseInt(txtXCordStartP.getText());
					yCordStartP= Integer.parseInt(txtYCordStartP.getText());
					xCordEndP = Integer.parseInt(txtXCordEndP.getText());
					yCordEndP = Integer.parseInt(txtYCordEndP.getText());
					borderColor=btnBorderColor.getBackground();
					line=new Line(new Point(xCordStartP,yCordStartP),new Point(xCordEndP,yCordEndP),borderColor);
					dispose();
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Enter the appropriate values!",
						    "Warning",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		pnlButtons.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				canceled=true;
				dispose();
				
			}
		});
		pnlButtons.add(btnCancel);
		
	}

	public JTextField getTxtXCordStartP() {
		return txtXCordStartP;
	}

	public void setTxtXCordStartP(JTextField txtXCordStartP) {
		this.txtXCordStartP = txtXCordStartP;
	}

	public JTextField getTxtYCordStartP() {
		return txtYCordStartP;
	}

	public void setTxtYCordStartP(JTextField txtYCordStartP) {
		this.txtYCordStartP = txtYCordStartP;
	}

	public JTextField getTxtXCordEndP() {
		return txtXCordEndP;
	}

	public void setTxtXCordEndP(JTextField txtXCordEndP) {
		this.txtXCordEndP = txtXCordEndP;
	}

	public JTextField getTxtYCordEndP() {
		return txtYCordEndP;
	}

	public void setTxtYCordEndP(JTextField txtYCordEndP) {
		this.txtYCordEndP = txtYCordEndP;
	}

	public int getxCordStartP() {
		return xCordStartP;
	}

	public void setxCordStartP(int xCordStartP) {
		this.xCordStartP = xCordStartP;
	}

	public int getyCordStartP() {
		return yCordStartP;
	}

	public void setyCordStartP(int yCordStartP) {
		this.yCordStartP = yCordStartP;
	}

	public int getxCordEndP() {
		return xCordEndP;
	}

	public void setxCordEndP(int xCordEndP) {
		this.xCordEndP = xCordEndP;
	}

	public int getyCordEndP() {
		return yCordEndP;
	}

	public void setyCordEndP(int yCordEndP) {
		this.yCordEndP = yCordEndP;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}

}
