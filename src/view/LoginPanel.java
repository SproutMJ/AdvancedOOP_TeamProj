package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.LoginController;

public class LoginPanel extends JPanel {

	private JTextField txtId;
	private JTextField txtPswd;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public LoginPanel() {
		setBounds(103, 10, 1028, 661);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC640! \uB098\uB77C\uC704\uD0A4");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 50));
		lblNewLabel.setBounds(341, 10, 400, 219);
		this.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(404, 260, 18, 26);
		this.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(318, 306, 111, 26);
		this.add(lblNewLabel_2);

		txtId = new JTextField();
		txtId.setText("id");
		txtId.setFont(new Font("굴림", Font.PLAIN, 22));
		txtId.setBounds(441, 253, 155, 35);
		this.add(txtId);
		txtId.setColumns(10);

		txtPswd = new JTextField();
		txtPswd.setText("pswd");
		txtPswd.setFont(new Font("굴림", Font.PLAIN, 22));
		txtPswd.setBounds(441, 302, 155, 35);
		this.add(txtPswd);
		txtPswd.setColumns(10);

		btnNewButton = new JButton("Sign in");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 22));
		btnNewButton.setBounds(441, 369, 150, 35);
		this.add(btnNewButton);

		btnNewButton_1 = new JButton("Sigin up");
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 22));
		btnNewButton_1.setBounds(441, 413, 150, 35);
		this.add(btnNewButton_1);

	}

	public void setBtnListener(ActionListener l) {
		btnNewButton.addActionListener(l);
		btnNewButton_1.addActionListener(l);
	}

	public JButton getSignInBtn() {
		return btnNewButton;
	}

	public JButton getSignUpBtn() {
		return btnNewButton_1;
	}

	public String getID() {
		return txtId.getText();
	}

	public String getPWD() {
		return txtPswd.getText();
	}

}