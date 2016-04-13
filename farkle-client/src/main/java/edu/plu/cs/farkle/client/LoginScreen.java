package edu.plu.cs.farkle.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;

public class LoginScreen {

	JTextField usernameText;
	
	public LoginScreen() {
		
	}
	
	public JPanel Login(JFrame frame){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screen.getWidth();
		double height = screen.getHeight();
		int offsetWidth = (int)width/15;
		int offsetHeight = (int)height/15;
		JPanel welcomePanel = new JPanel();
		welcomePanel.setBackground(new Color(255, 250, 205));
		welcomePanel.setBounds(0, 0, (int)width, (int)height);
		welcomePanel.setLayout(null);
		
		
		
		//LOGIN BUTTON\\
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				//SEE START METHOD
				//start();
			}
		});
		btnLogin.setBounds((int)width/2+offsetWidth, (int)height/2, 89, 23);
		welcomePanel.add(btnLogin);
		
		JRootPane root = frame.getRootPane();
		root.setDefaultButton(btnLogin);
		
		usernameText = new JTextField();
		usernameText.setBounds((int)width/2, (int)height/2, 86, 20);
		welcomePanel.add(usernameText);
		usernameText.setColumns(10);
		
		
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds((int)width/2-offsetWidth, (int)height/2, 86, 20);
		welcomePanel.add(lblUsername);
		
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds((int)width/2, (int)height/2+offsetHeight, 86, 20);
		welcomePanel.add(passwordField);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds((int)width/2-offsetWidth, (int)height/2+offsetHeight, 65, 14);
		welcomePanel.add(lblPassword);
		
		
		
		//REGISTER BUTTON\\
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					//Goes to register method 
					//SEE REGISTER METHOD
					welcomePanel.setVisible(false);
					RegisterScreen reg = new RegisterScreen();
					JPanel regScreen = reg.register(welcomePanel);
					frame.add(regScreen);
				
			}
		});
		btnRegister.setBounds((int)width/2+offsetWidth, (int)height/2+offsetHeight, 89, 23);
		welcomePanel.add(btnRegister);
		
		
		JLabel lblFarkle = new JLabel("FARKLE");
		lblFarkle.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblFarkle.setBounds(526, 114, 445, 149);
		welcomePanel.add(lblFarkle);
		
		JLabel DiceDisplay = new JLabel("New label");
		DiceDisplay.setBackground(new Color(0, 0, 128));
		DiceDisplay.setBounds(902, 93, 252, 186);
		welcomePanel.add(DiceDisplay);
		
		Image img = new ImageIcon(this.getClass().getResource("/3dDice.png")).getImage();
		DiceDisplay.setIcon(new ImageIcon(img));
		
		return welcomePanel;
	}
	
	public String getText(){
		return usernameText.getText();
	}

}
