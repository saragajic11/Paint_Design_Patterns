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

public class DlgModifyCircle extends JDialog {
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	private JTextField txtRadius;
	private int xCoordinate;
	private int yCoordinate;
	private int radius;
	private boolean canceled;
	private Color edgeColor;
	private Color areaColor;
	private JButton btnEdgeColor;
	private JButton btnAreaColor;

	public static void main(String[] args) {
		try {
			DlgModifyCircle dialog = new DlgModifyCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgModifyCircle() {
		setTitle("Modify circle");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 400, 250);
		setLocationRelativeTo(null);

		JPanel pnlModifyCircle = new JPanel();
		getContentPane().add(pnlModifyCircle, BorderLayout.CENTER);
		GridBagLayout gbl_pnlModifyCircle = new GridBagLayout();
		gbl_pnlModifyCircle.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_pnlModifyCircle.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlModifyCircle.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlModifyCircle.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlModifyCircle.setLayout(gbl_pnlModifyCircle);

		JLabel lblXCoordinate = new JLabel("X coordinate:");
		GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
		gbc_lblXCoordinate.anchor = GridBagConstraints.EAST;
		gbc_lblXCoordinate.insets = new Insets(10, 10, 5, 5);
		gbc_lblXCoordinate.gridx = 1;
		gbc_lblXCoordinate.gridy = 1;
		pnlModifyCircle.add(lblXCoordinate, gbc_lblXCoordinate);

		txtXCoordinate = new JTextField();
		GridBagConstraints gbc_txtXCoordinate = new GridBagConstraints();
		gbc_txtXCoordinate.insets = new Insets(10, 0, 5, 10);
		gbc_txtXCoordinate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXCoordinate.gridx = 2;
		gbc_txtXCoordinate.gridy = 1;
		pnlModifyCircle.add(txtXCoordinate, gbc_txtXCoordinate);
		txtXCoordinate.setColumns(10);

		JLabel lblYCoordinate = new JLabel("Y coordinate:");
		GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
		gbc_lblYCoordinate.anchor = GridBagConstraints.EAST;
		gbc_lblYCoordinate.insets = new Insets(0, 0, 5, 5);
		gbc_lblYCoordinate.gridx = 1;
		gbc_lblYCoordinate.gridy = 2;
		pnlModifyCircle.add(lblYCoordinate, gbc_lblYCoordinate);

		txtYCoordinate = new JTextField();
		GridBagConstraints gbc_txtYCoordinate = new GridBagConstraints();
		gbc_txtYCoordinate.anchor = GridBagConstraints.NORTH;
		gbc_txtYCoordinate.insets = new Insets(0, 0, 5, 10);
		gbc_txtYCoordinate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYCoordinate.gridx = 2;
		gbc_txtYCoordinate.gridy = 2;
		pnlModifyCircle.add(txtYCoordinate, gbc_txtYCoordinate);
		txtYCoordinate.setColumns(10);

		JLabel lblRadius = new JLabel("Radius:");
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.anchor = GridBagConstraints.EAST;
		gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
		gbc_lblRadius.gridx = 1;
		gbc_lblRadius.gridy = 3;
		pnlModifyCircle.add(lblRadius, gbc_lblRadius);

		txtRadius = new JTextField();
		GridBagConstraints gbc_txtRadius = new GridBagConstraints();
		gbc_txtRadius.insets = new Insets(0, 0, 5, 10);
		gbc_txtRadius.anchor = GridBagConstraints.NORTH;
		gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRadius.gridx = 2;
		gbc_txtRadius.gridy = 3;
		pnlModifyCircle.add(txtRadius, gbc_txtRadius);
		txtRadius.setColumns(10);

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
		gbc_btnEdgeColor.gridy = 4;
		pnlModifyCircle.add(btnEdgeColor, gbc_btnEdgeColor);

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
		gbc_btnAreaColor.gridy = 5;
		pnlModifyCircle.add(btnAreaColor, gbc_btnAreaColor);

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
					radius = Integer.parseInt(txtRadius.getText());
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
			public void actionPerformed(ActionEvent arg0) {
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

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
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

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
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
	
}
