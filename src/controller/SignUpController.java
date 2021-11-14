package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.UserService;
import service.UserServiceImpl;
import view.LoginPanel;
import view.MainFrame;
import view.SignUpPanel;
import javax.swing.JOptionPane;

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
			}
		});
        signUpPanel.getSignUpBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserService userService = new UserServiceImpl();
                boolean check = userService.registrationByNameAndUserIdAndPassword(signUpPanel.getName(),signUpPanel.getID(), signUpPanel.getPWD());
                if(check)
                    mainFrame.getCardLayout().show(mainFrame.getContentPane(), "loginPanel");
                else
                    JOptionPane.showMessageDialog(null, "회원가입 오류입니다.");
            }
        });
	}
}
