package edu.plu.cs.farkle.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register {

	public JPanel register(JFrame frame){
		Dimension screenSize = frame.getBounds().getSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		int offsetWidth = (int)width/15;
		int offsetHeight = (int)height/15;
		
		JPanel register = new JPanel();
		register.setBackground(new Color(255, 250, 205));
		register.setBounds(0, 0, (int)width, (int)height);
		frame.getContentPane().add(register);
		register.setLayout(null);
		
		JTextField usernameText = new JTextField();
		usernameText.setBounds((int)width/2, (int)height/2, 86, 20);
		register.add(usernameText);
		usernameText.setColumns(10);
		
		
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds((int)width/2-offsetWidth, (int)height/2, 86, 20);
		register.add(lblUsername);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds((int)width/2, (int)height/2+offsetHeight, 86, 20);
		register.add(passwordField);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds((int)width/2-offsetWidth, (int)height/2+offsetHeight, 65, 14);
		register.add(lblPassword);
		
		
		//REGISTER\\
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = usernameText.getText();
				
				//ENTER CODE HERE FOR REGISTERING USERNAMES AND PASSWORDS\\
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				System.out.println("Username: " + username + " Password: " + password);
				
				
				Database db = new Database(username, password);
				
				db.put();
				
			}
		});
		btnRegister.setBounds((int)width/2+offsetWidth, (int)height/2+offsetHeight/2, 89, 23);
		register.add(btnRegister);
		
		
		JButton goBack = new JButton("Go Back");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				register.setVisible(false);
				//login();
			}
		
		});
		goBack.setBounds((int)width/2, (int)height/2+offsetHeight*2, 89, 23);
		register.add(goBack);
		return register;
	}
	
}
