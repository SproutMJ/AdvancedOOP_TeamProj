package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.UserService;
import service.UserServiceImpl;
import view.LoginPanel;
import view.MainFrame;
import view.MainNavigatorPanel;
import view.MainRetrievePanel;
import view.SignUpPanel;

public class LoginController {

	private MainFrame mainFrame;
	private LoginPanel loginPanel;
	private SignUpPanel signUpPanel;
	private MainNavigatorPanel mainNavigatorPanel;
	private UserService userService = new UserServiceImpl();

	// LoginPanel의 이베
	public LoginController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.loginPanel = mainFrame.getLoginPanel();
		this.signUpPanel = mainFrame.getSinUpPanel();
		this.mainNavigatorPanel = mainFrame.getMainNevigatorPanel();
		eventInit();
	}

	public void eventInit() {
		loginPanel.getSignInBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean check = userService.loginByUserIdAndPassword(loginPanel.getID(), loginPanel.getPWD());

				if (check) {
					mainFrame.getCardLayout().show(mainFrame.getContentPane(), "mainNavigatorPanel");
					mainFrame.setJMenuBar(true);
				} else {
					System.out.println("Login Fail!!");
				}
			}
		});

		loginPanel.getSignUpBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "signUpPanel");
			}
		});
		
		loginPanel.getCheckBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//체크박스 체크 되있는 경우 = show pwd
				if(loginPanel.getCheckBox().isSelected()) {
					loginPanel.getVisibleTextField().setText(loginPanel.getUnVisibleTextField().getText());
					loginPanel.getVisibleTextField().setVisible(true);
					loginPanel.getUnVisibleTextField().setVisible(false);
				}
				else {
					loginPanel.getUnVisibleTextField().setText(loginPanel.getVisibleTextField().getText());
					loginPanel.getVisibleTextField().setVisible(false);
					loginPanel.getUnVisibleTextField().setVisible(true);
				}
			}
		});
	}
}
