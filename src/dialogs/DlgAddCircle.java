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

import javax.swing.JButton;

public class DlgAddCircle extends JDialog {
	private JTextField txtRadius;
	private int radius;
	private boolean canceled;
	
	public static void main (String [] args) {
		try {
			DlgAddCircle dialog = new DlgAddCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DlgAddCircle() {
		setTitle("Add circle");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 300, 200);
		setLocationRelativeTo(null);
		
		JPanel pnlAddCircle = new JPanel();
		getContentPane().add(pnlAddCircle, BorderLayout.CENTER);
		GridBagLayout gbl_pnlAddCircle = new GridBagLayout();
		gbl_pnlAddCircle.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlAddCircle.rowHeights = new int[]{0, 0, 0};
		gbl_pnlAddCircle.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlAddCircle.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlAddCircle.setLayout(gbl_pnlAddCircle);
		
		JLabel lblRadius = new JLabel("Radius:");
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.insets = new Insets(10, 10, 0, 5);
		gbc_lblRadius.anchor = GridBagConstraints.EAST;
		gbc_lblRadius.gridx = 1;
		gbc_lblRadius.gridy = 1;
		pnlAddCircle.add(lblRadius, gbc_lblRadius);
		
		txtRadius = new JTextField();
		GridBagConstraints gbc_txtRadius = new GridBagConstraints();
		gbc_txtRadius.insets = new Insets(12, 0, 5, 10);
		gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRadius.gridx = 2;
		gbc_txtRadius.gridy = 1;
		pnlAddCircle.add(txtRadius, gbc_txtRadius);
		txtRadius.setColumns(10);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				radius=Integer.parseInt(txtRadius.getText());
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
				txtRadius.setText("");
				canceled=true;
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
