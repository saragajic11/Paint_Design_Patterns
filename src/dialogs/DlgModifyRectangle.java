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

public class DlgModifyRectangle extends JDialog {
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	private JTextField txtHeight;
	private JTextField txtWidth;
	private int xCoordinate;
	private int yCoordinate;
	private int heightRec;
	private int widthRec;
	private boolean canceled;
	private JButton btnEdgeColor;
	private JButton btnAreaColor;
	private Color edgeColor;
	private Color areaColor;

	public static void main(String[] args) {
		try {
			DlgModifyRectangle dialog = new DlgModifyRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgModifyRectangle() {
		setTitle("Modify rectangle");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 400, 280);
		setLocationRelativeTo(null);

		JPanel pnlModifyRectangle = new JPanel();
		getContentPane().add(pnlModifyRectangle, BorderLayout.CENTER);
		GridBagLayout gbl_pnlModifyRectangle = new GridBagLayout();
		gbl_pnlModifyRectangle.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_pnlModifyRectangle.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlModifyRectangle.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlModifyRectangle.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlModifyRectangle.setLayout(gbl_pnlModifyRectangle);

		JLabel lblXCoordinate = new JLabel("X coordinate:");
		GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
		gbc_lblXCoordinate.anchor = GridBagConstraints.EAST;
		gbc_lblXCoordinate.insets = new Insets(10, 10, 5, 5);
		gbc_lblXCoordinate.gridx = 1;
		gbc_lblXCoordinate.gridy = 1;
		pnlModifyRectangle.add(lblXCoordinate, gbc_lblXCoordinate);

		txtXCoordinate = new JTextField();
		GridBagConstraints gbc_txtXCoordinate = new GridBagConstraints();
		gbc_txtXCoordinate.anchor = GridBagConstraints.NORTH;
		gbc_txtXCoordinate.insets = new Insets(10, 0, 5, 0);
		gbc_txtXCoordinate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXCoordinate.gridx = 2;
		gbc_txtXCoordinate.gridy = 1;
		pnlModifyRectangle.add(txtXCoordinate, gbc_txtXCoordinate);
		txtXCoordinate.setColumns(10);

		JLabel lblYCoordinate = new JLabel("Y coordinate:");
		GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
		gbc_lblYCoordinate.anchor = GridBagConstraints.EAST;
		gbc_lblYCoordinate.insets = new Insets(0, 0, 5, 5);
		gbc_lblYCoordinate.gridx = 1;
		gbc_lblYCoordinate.gridy = 2;
		pnlModifyRectangle.add(lblYCoordinate, gbc_lblYCoordinate);

		txtYCoordinate = new JTextField();
		GridBagConstraints gbc_txtYCoordinate = new GridBagConstraints();
		gbc_txtYCoordinate.insets = new Insets(0, 0, 5, 0);
		gbc_txtYCoordinate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYCoordinate.gridx = 2;
		gbc_txtYCoordinate.gridy = 2;
		pnlModifyRectangle.add(txtYCoordinate, gbc_txtYCoordinate);
		txtYCoordinate.setColumns(10);

		JLabel lblHeight = new JLabel("Height:");
		GridBagConstraints gbc_lblHeight = new GridBagConstraints();
		gbc_lblHeight.anchor = GridBagConstraints.EAST;
		gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeight.gridx = 1;
		gbc_lblHeight.gridy = 3;
		pnlModifyRectangle.add(lblHeight, gbc_lblHeight);

		txtHeight = new JTextField();
		GridBagConstraints gbc_txtHeight = new GridBagConstraints();
		gbc_txtHeight.anchor = GridBagConstraints.NORTH;
		gbc_txtHeight.insets = new Insets(0, 0, 5, 0);
		gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHeight.gridx = 2;
		gbc_txtHeight.gridy = 3;
		pnlModifyRectangle.add(txtHeight, gbc_txtHeight);
		txtHeight.setColumns(10);

		JLabel lblWidth = new JLabel("Width:");
		GridBagConstraints gbc_lblWidth = new GridBagConstraints();
		gbc_lblWidth.anchor = GridBagConstraints.EAST;
		gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
		gbc_lblWidth.gridx = 1;
		gbc_lblWidth.gridy = 4;
		pnlModifyRectangle.add(lblWidth, gbc_lblWidth);

		txtWidth = new JTextField();
		GridBagConstraints gbc_txtWidth = new GridBagConstraints();
		gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
		gbc_txtWidth.anchor = GridBagConstraints.NORTH;
		gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWidth.gridx = 2;
		gbc_txtWidth.gridy = 4;
		pnlModifyRectangle.add(txtWidth, gbc_txtWidth);
		txtWidth.setColumns(10);

		btnEdgeColor = new JButton("Edge color");
		btnEdgeColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEdgeColor
						.setBackground(JColorChooser.showDialog(null, "Choose color", btnEdgeColor.getBackground()));

			}
		});
		GridBagConstraints gbc_btnEdgeColor = new GridBagConstraints();
		gbc_btnEdgeColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdgeColor.gridx = 2;
		gbc_btnEdgeColor.gridy = 5;
		pnlModifyRectangle.add(btnEdgeColor, gbc_btnEdgeColor);

		btnAreaColor = new JButton("Area color");
		btnAreaColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnAreaColor
						.setBackground(JColorChooser.showDialog(null, "Choose color", btnAreaColor.getBackground()));

			}
		});
		GridBagConstraints gbc_btnAreaColor = new GridBagConstraints();
		gbc_btnAreaColor.gridx = 2;
		gbc_btnAreaColor.gridy = 6;
		pnlModifyRectangle.add(btnAreaColor, gbc_btnAreaColor);

		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					xCoordinate = Integer.parseInt(txtXCoordinate.getText());
					yCoordinate = Integer.parseInt(txtYCoordinate.getText());
					heightRec = Integer.parseInt(txtHeight.getText());
					widthRec = Integer.parseInt(txtWidth.getText());
					edgeColor = btnEdgeColor.getBackground();
					areaColor = btnAreaColor.getBackground();
					dispose();
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Enter the appropriate values!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		pnlButtons.add(btnConfirm);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canceled = true;
				dispose();

			}
		});
		pnlButtons.add(btnCancel);
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

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
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

	public int getHeightRec() {
		return heightRec;
	}

	public void setHeightRec(int heightRec) {
		this.heightRec = heightRec;
	}

	public int getWidthRec() {
		return widthRec;
	}

	public void setWidthRec(int widthRec) {
		this.widthRec = widthRec;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
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
	
	
}
