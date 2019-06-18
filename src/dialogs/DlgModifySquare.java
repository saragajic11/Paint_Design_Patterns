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
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class DlgModifySquare extends JDialog {
	private JTextField txtYCoordinate;
	private JTextField txtSideLength;
	private JTextField txtXCoordinate;
	private int xCoordinate;
	private int yCoordinate;
	private int side;
	private boolean canceled;
	private Color edgeColor;
	private Color areaColor;
	private JButton btnAreaColor;
	private JButton btnEdgeColor;
	
	public static void main(String[] args) {
		try {
			DlgModifySquare dialog = new DlgModifySquare();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgModifySquare() {
		setTitle("Modify square");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 400, 250);
		setLocationRelativeTo(null);
		
		JPanel pnlModifySquare = new JPanel();
		getContentPane().add(pnlModifySquare, BorderLayout.CENTER);
		GridBagLayout gbl_pnlModifySquare = new GridBagLayout();
		gbl_pnlModifySquare.columnWidths = new int[]{0, 0, 209, 0};
		gbl_pnlModifySquare.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlModifySquare.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlModifySquare.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlModifySquare.setLayout(gbl_pnlModifySquare);
		
		JLabel lblXCoordinate = new JLabel("X coordinate:");
		GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
		gbc_lblXCoordinate.anchor = GridBagConstraints.EAST;
		gbc_lblXCoordinate.insets = new Insets(10, 10, 5, 5);
		gbc_lblXCoordinate.gridx = 1;
		gbc_lblXCoordinate.gridy = 1;
		pnlModifySquare.add(lblXCoordinate, gbc_lblXCoordinate);
		
		txtXCoordinate = new JTextField();
		GridBagConstraints gbc_txtXCoordinate = new GridBagConstraints();
		gbc_txtXCoordinate.insets = new Insets(10, 0, 5, 0);
		gbc_txtXCoordinate.fill = GridBagConstraints.BOTH;
		gbc_txtXCoordinate.gridx = 2;
		gbc_txtXCoordinate.gridy = 1;
		pnlModifySquare.add(txtXCoordinate, gbc_txtXCoordinate);
		txtXCoordinate.setColumns(5);
		
		JLabel lblYCoordinate = new JLabel("Y coordinate:");
		GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
		gbc_lblYCoordinate.anchor = GridBagConstraints.EAST;
		gbc_lblYCoordinate.insets = new Insets(0, 0, 5, 5);
		gbc_lblYCoordinate.gridx = 1;
		gbc_lblYCoordinate.gridy = 2;
		pnlModifySquare.add(lblYCoordinate, gbc_lblYCoordinate);
		
		txtYCoordinate = new JTextField();
		GridBagConstraints gbc_txtYCoordinate = new GridBagConstraints();
		gbc_txtYCoordinate.insets = new Insets(0, 0, 5, 0);
		gbc_txtYCoordinate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYCoordinate.gridx = 2;
		gbc_txtYCoordinate.gridy = 2;
		pnlModifySquare.add(txtYCoordinate, gbc_txtYCoordinate);
		txtYCoordinate.setColumns(5);
		
		JLabel lblSideLength = new JLabel("Side length:");
		GridBagConstraints gbc_lblSideLength = new GridBagConstraints();
		gbc_lblSideLength.anchor = GridBagConstraints.EAST;
		gbc_lblSideLength.insets = new Insets(0, 0, 5, 5);
		gbc_lblSideLength.gridx = 1;
		gbc_lblSideLength.gridy = 3;
		pnlModifySquare.add(lblSideLength, gbc_lblSideLength);
		
		txtSideLength = new JTextField();
		GridBagConstraints gbc_txtSideLength = new GridBagConstraints();
		gbc_txtSideLength.insets = new Insets(0, 0, 5, 0);
		gbc_txtSideLength.anchor = GridBagConstraints.NORTH;
		gbc_txtSideLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSideLength.gridx = 2;
		gbc_txtSideLength.gridy = 3;
		pnlModifySquare.add(txtSideLength, gbc_txtSideLength);
		txtSideLength.setColumns(5);
		
		btnEdgeColor = new JButton("Edge color");
		btnEdgeColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEdgeColor.setBackground(JColorChooser.showDialog(null, "Choose color", btnEdgeColor.getBackground()));
				
			}
		});
		GridBagConstraints gbc_btnEdgeColor = new GridBagConstraints();
		gbc_btnEdgeColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdgeColor.gridx = 2;
		gbc_btnEdgeColor.gridy = 4;
		pnlModifySquare.add(btnEdgeColor, gbc_btnEdgeColor);
		
		btnAreaColor = new JButton("Area color");
		btnAreaColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAreaColor.setBackground(JColorChooser.showDialog(null, "Choose color", btnAreaColor.getBackground()));
				
			}
		});
		GridBagConstraints gbc_btnAreaColor = new GridBagConstraints();
		gbc_btnAreaColor.gridx = 2;
		gbc_btnAreaColor.gridy = 5;
		pnlModifySquare.add(btnAreaColor, gbc_btnAreaColor);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					xCoordinate=Integer.parseInt(txtXCoordinate.getText());
					yCoordinate=Integer.parseInt(txtYCoordinate.getText());
					side = Integer.parseInt(txtSideLength.getText());
					edgeColor=btnEdgeColor.getBackground();
					areaColor=btnAreaColor.getBackground();
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

	public JTextField getTxtYCoordinate() {
		return txtYCoordinate;
	}

	public void setTxtYCoordinate(JTextField txtYCoordinate) {
		this.txtYCoordinate = txtYCoordinate;
	}

	public JTextField getTxtSideLength() {
		return txtSideLength;
	}

	public void setTxtSideLength(JTextField txtSideLength) {
		this.txtSideLength = txtSideLength;
	}

	public JTextField getTxtXCoordinate() {
		return txtXCoordinate;
	}

	public void setTxtXCoordinate(JTextField txtXCoordinate) {
		this.txtXCoordinate = txtXCoordinate;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
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

	public Color getAreaColor() {
		return areaColor;
	}

	public void setAreaColor(Color areaColor) {
		this.areaColor = areaColor;
	}

	public JButton getBtnAreaColor() {
		return btnAreaColor;
	}

	public void setBtnAreaColor(JButton btnAreaColor) {
		this.btnAreaColor = btnAreaColor;
	}

	public JButton getBtnEdgeColor() {
		return btnEdgeColor;
	}

	public void setBtnEdgeColor(JButton btnEdgeColor) {
		this.btnEdgeColor = btnEdgeColor;
	}
	

}
