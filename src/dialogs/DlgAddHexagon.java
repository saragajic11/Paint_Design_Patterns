package dialogs;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class DlgAddHexagon extends JDialog {
	private JTextField txtRadius;
	private int radius;
	private boolean canceled;

	public static void main(String[] args) {
		try {
			DlgAddHexagon dialog = new DlgAddHexagon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public DlgAddHexagon() {
		setTitle("Add hexagon");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 300, 200);
		setLocationRelativeTo(null);

		JPanel pnlAddHexagon = new JPanel();
		getContentPane().add(pnlAddHexagon, BorderLayout.CENTER);
		GridBagLayout gbl_pnlAddHexagon = new GridBagLayout();
		gbl_pnlAddHexagon.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_pnlAddHexagon.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnlAddHexagon.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlAddHexagon.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		pnlAddHexagon.setLayout(gbl_pnlAddHexagon);

		JLabel lblRadius = new JLabel("Radius:");
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.insets = new Insets(10, 10, 0, 5);
		gbc_lblRadius.anchor = GridBagConstraints.EAST;
		gbc_lblRadius.gridx = 1;
		gbc_lblRadius.gridy = 1;
		pnlAddHexagon.add(lblRadius, gbc_lblRadius);

		txtRadius = new JTextField();
		GridBagConstraints gbc_txtRadius = new GridBagConstraints();
		gbc_txtRadius.insets = new Insets(12, 0, 5, 10);
		gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRadius.gridx = 2;
		gbc_txtRadius.gridy = 1;
		pnlAddHexagon.add(txtRadius, gbc_txtRadius);
		txtRadius.setColumns(10);

		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					radius = Integer.parseInt(txtRadius.getText());
					setVisible(false);

				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(rootPane, "Insert the right value!");
					e2.printStackTrace();
				}

			}
		});
		pnlButtons.add(btnConfirm);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtRadius.setText("");
				canceled = true;
				dispose();

			}
		});
		pnlButtons.add(btnCancel);

	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
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

}
