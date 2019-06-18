package dialogs;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import shapes.Point;

import javax.swing.JButton;
import javax.swing.JColorChooser;

public class DlgPoint extends JDialog {
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	private int xCordModified;
	private int yCordModified;
	private boolean canceled;
	private Color edgeColor;
	private Point point;
	private JButton btnBorderColor;
	
	public static void main (String[]args) {
		try {
			DlgPoint dlgPoint = new DlgPoint();
			dlgPoint.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dlgPoint.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgPoint() {
		setTitle("Update point");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 400, 200);
		setLocationRelativeTo(null);
		
		JPanel pnlUpdatePoint = new JPanel();
		getContentPane().add(pnlUpdatePoint, BorderLayout.CENTER);
		GridBagLayout gbl_pnlUpdatePoint = new GridBagLayout();
		gbl_pnlUpdatePoint.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlUpdatePoint.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlUpdatePoint.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlUpdatePoint.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlUpdatePoint.setLayout(gbl_pnlUpdatePoint);
		
		JLabel lblXCoordinate = new JLabel("X coordinate:");
		GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
		gbc_lblXCoordinate.insets = new Insets(10, 10, 5, 5);
		gbc_lblXCoordinate.gridx = 2;
		gbc_lblXCoordinate.gridy = 1;
		pnlUpdatePoint.add(lblXCoordinate, gbc_lblXCoordinate);
		
		txtXCoordinate = new JTextField();
		GridBagConstraints gbc_txtXCoordinate = new GridBagConstraints();
		gbc_txtXCoordinate.insets = new Insets(10, 10, 5, 5);
		gbc_txtXCoordinate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXCoordinate.gridx = 4;
		gbc_txtXCoordinate.gridy = 1;
		pnlUpdatePoint.add(txtXCoordinate, gbc_txtXCoordinate);
		txtXCoordinate.setColumns(10);
		
		JLabel lblYCoordinate = new JLabel("Y coordinate:");
		GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
		gbc_lblYCoordinate.insets = new Insets(10, 10, 5, 5);
		gbc_lblYCoordinate.gridx = 2;
		gbc_lblYCoordinate.gridy = 2;
		pnlUpdatePoint.add(lblYCoordinate, gbc_lblYCoordinate);
		
		txtYCoordinate = new JTextField();
		GridBagConstraints gbc_txtYCoordinate = new GridBagConstraints();
		gbc_txtYCoordinate.insets = new Insets(10, 10, 5, 5);
		gbc_txtYCoordinate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYCoordinate.gridx = 4;
		gbc_txtYCoordinate.gridy = 2;
		pnlUpdatePoint.add(txtYCoordinate, gbc_txtYCoordinate);
		txtYCoordinate.setColumns(10);
		
		btnBorderColor = new JButton("Border color");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBorderColor.setBackground(JColorChooser.showDialog(null, "Choose color", btnBorderColor.getBackground()));
			}
		});
		GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
		gbc_btnBorderColor.insets = new Insets(10, 10, 0, 5);
		gbc_btnBorderColor.gridx = 4;
		gbc_btnBorderColor.gridy = 3;
		pnlUpdatePoint.add(btnBorderColor, gbc_btnBorderColor);
		
		JPanel pnlButton = new JPanel();
		pnlButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(pnlButton, BorderLayout.SOUTH);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					xCordModified = Integer.parseInt(txtXCoordinate.getText());
					yCordModified = Integer.parseInt(txtYCoordinate.getText());
					edgeColor= btnBorderColor.getBackground();
					point = new Point(xCordModified,yCordModified,edgeColor);
					dispose();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Enter the appropriate values!",
						    "Warning",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		pnlButton.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				canceled=true;
				dispose();
				
			}
		});
		pnlButton.add(btnCancel);
		
		
	}

	public JTextField getTxtXCoordinate() {
		return txtXCoordinate;
	}

	public void setTxtXCoordinate(JTextField txtXCoordinate) {
		this.txtXCoordinate = txtXCoordinate;
	}

	public JTextField getTxtYCoordinate() {
		return txtYCoordinate;
	}

	public void setTxtYCoordinate(JTextField txtYCoordinate) {
		this.txtYCoordinate = txtYCoordinate;
	}

	public int getxCordModified() {
		return xCordModified;
	}

	public void setxCordModified(int xCordModified) {
		this.xCordModified = xCordModified;
	}

	public int getyCordModified() {
		return yCordModified;
	}

	public void setyCordModified(int yCordModified) {
		this.yCordModified = yCordModified;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}

	
}
