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
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.CancelledKeyException;

import javax.swing.JButton;

public class DlgAddSquare extends JDialog {
	private JTextField txtSideLenght;
	private boolean canceled = false;
	private int side;

	public static void main(String[] args) {
		try {
			DlgAddSquare dialog = new DlgAddSquare();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgAddSquare() {
		setTitle("Add square");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 300, 200);
		setLocationRelativeTo(null);

		JPanel pnlAddSquare = new JPanel();
		getContentPane().add(pnlAddSquare, BorderLayout.CENTER);
		GridBagLayout gbl_pnlAddSquare = new GridBagLayout();
		gbl_pnlAddSquare.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_pnlAddSquare.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_pnlAddSquare.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_pnlAddSquare.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlAddSquare.setLayout(gbl_pnlAddSquare);

		JLabel lblSideLength = new JLabel("Side length:");
		GridBagConstraints gbc_lblSideLength = new GridBagConstraints();
		gbc_lblSideLength.anchor = GridBagConstraints.EAST;
		gbc_lblSideLength.insets = new Insets(10, 10, 5, 5);
		gbc_lblSideLength.gridx = 1;
		gbc_lblSideLength.gridy = 1;
		pnlAddSquare.add(lblSideLength, gbc_lblSideLength);

		txtSideLenght = new JTextField();
		GridBagConstraints gbc_txtSideLenght = new GridBagConstraints();
		gbc_txtSideLenght.insets = new Insets(10, 0, 5, 5);
		gbc_txtSideLenght.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSideLenght.gridx = 2;
		gbc_txtSideLenght.gridy = 1;
		pnlAddSquare.add(txtSideLenght, gbc_txtSideLenght);
		txtSideLenght.setColumns(10);

		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					side = Integer.parseInt(txtSideLenght.getText());
					setVisible(false);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(rootPane, "Insert the right value!");
					e1.printStackTrace();
				}
			}
		});
		pnlButtons.add(btnConfirm);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtSideLenght.setText("");
				canceled = true;
				dispose();
			}
		});
		pnlButtons.add(btnCancel);

	}

	public JTextField getTxtSideLenght() {
		return txtSideLenght;
	}

	public void setTxtSideLenght(JTextField txtSideLenght) {
		this.txtSideLenght = txtSideLenght;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}
	

}
