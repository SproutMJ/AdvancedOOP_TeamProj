package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.UserService;
import service.UserServiceImpl;
import view.LoginPanel;
import view.MainFrame;
import view.SignUpPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SignUpController {

	private MainFrame mainFrame;
	private LoginPanel loginPanel;
	private SignUpPanel signUpPanel;

	public SignUpController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.loginPanel = mainFrame.getLoginPanel();
		this.signUpPanel = mainFrame.getSinUpPanel();
		eventInit();
	}

	private void eventInit() {
		signUpPanel.getGoBackButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "loginPanel");
				signUpPanel.Clean();
			}
		});
		signUpPanel.getSignUpBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// password랑 passwordRE랑 같은지 비교
				if (signUpPanel.getCheckBox().isSelected()) {
					if (!signUpPanel.getVisibleTextField()[0].getText()
							.equals(signUpPanel.getVisibleTextField()[1].getText())) {
						JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
						return;
					}
				} else {
					if (!signUpPanel.getUnVisibleTextField()[0].getText()
							.equals(signUpPanel.getUnVisibleTextField()[1].getText())) {
						JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
						return;
					}
				}

				UserService userService = new UserServiceImpl();
				boolean check = userService.registrationByNameAndUserIdAndPassword(signUpPanel.getName(),
						signUpPanel.getID(), signUpPanel.getPWD());
				if (check) {
					mainFrame.getCardLayout().show(mainFrame.getContentPane(), "loginPanel");
					signUpPanel.Clean();
				} else
					JOptionPane.showMessageDialog(null, "회원가입 오류입니다.");
			}
		});

		signUpPanel.getCheckBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// show password 체크
				if (signUpPanel.getCheckBox().isSelected()) {
					for (int i = 0; i < 2; i++) {
						signUpPanel.getVisibleTextField()[i].setText(signUpPanel.getUnVisibleTextField()[i].getText());
						signUpPanel.getVisibleTextField()[i].setVisible(true);
						signUpPanel.getUnVisibleTextField()[i].setVisible(false);
					}
				} else {
					for (int i = 0; i < 2; i++) {
						signUpPanel.getUnVisibleTextField()[i].setText(signUpPanel.getVisibleTextField()[i].getText());
						signUpPanel.getUnVisibleTextField()[i].setVisible(true);
						signUpPanel.getVisibleTextField()[i].setVisible(false);
					}
				}
			}
		});
	}
}
