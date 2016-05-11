package edu.plu.cs.farkle.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.plu.cs.farkle.client.Database;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Register {

	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel register(JFrame frame){		
		JPanel register = new JPanel();
		register.setBackground(new Color(255, 250, 205));
		frame.getContentPane().add(register);
		register.setLayout(new BorderLayout(0, 0));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 250, 205));
		register.add(centerPanel);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel buttons = new JPanel();
		buttons.setBackground(new Color(255, 250, 205));
		centerPanel.add(buttons, BorderLayout.SOUTH);
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnRegister = new JButton("Register");
		buttons.add(btnRegister);
			
		JButton goBack = new JButton("Go Back");
		buttons.add(goBack);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		centerPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel userPanel = new JPanel();
		userPanel.setBackground(new Color(255, 250, 205));
		panel.add(userPanel, BorderLayout.NORTH);		
		
		JLabel lblUsername = new JLabel("Username");
		userPanel.add(lblUsername);
		
		JTextField usernameText = new JTextField();
		userPanel.add(usernameText);
		usernameText.setColumns(10);
		
		JPanel passPanel = new JPanel();
		passPanel.setBackground(new Color(255, 250, 205));
		panel.add(passPanel, BorderLayout.CENTER);		
		
		JLabel lblPassword = new JLabel("Password");
		passPanel.add(lblPassword);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passPanel.add(passwordField);
		
		JPanel successPanel = new JPanel();
		successPanel.setBackground(new Color(255, 250, 205));
		panel.add(successPanel, BorderLayout.SOUTH);
		
		JLabel regLabel = new JLabel();
		regLabel.setVisible(false);
		successPanel.add(regLabel);
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				register.setVisible(false);
				frame.remove(register);
				
				LoginScreen login = new LoginScreen();
				JPanel log = login.Login(frame);
				
				frame.getContentPane().add(log);
			}
		
		});
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				String username = usernameText.getText();

				@SuppressWarnings("deprecation")
				String password = passwordField.getText();				
				Database db = new Database(username, password);
				
				if(!username.equals("")&&!password.equals("")){
					db.put();
					regLabel.setText("Registered " + username + " as a new user!");
					regLabel.setVisible(true);
				}
				else{
					if(username.equals(""))
						lblUsername.setForeground(Color.red);
					if(password.equals(""))
						lblPassword.setForeground(Color.red);
				}			
			}
		});
		return register;
	}	
}