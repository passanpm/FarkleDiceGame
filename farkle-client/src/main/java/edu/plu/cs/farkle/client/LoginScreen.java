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
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class LoginScreen {

	JTextField usernameText;
	String userName;
	

	public LoginScreen() {
		
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel Login(JFrame frame){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screen.getWidth();
		double height = screen.getHeight();
		int offsetWidth = (int)width/15;
		int offsetHeight = (int)height/15;
		
		JPanel welcomePanel = new JPanel();
		welcomePanel.setBackground(new Color(255, 250, 205));
		//welcomePanel.setBounds(0, 0, (int)width, (int)height);
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(new BorderLayout(0, 0));
		
		JRootPane root = frame.getRootPane();
		
		Image img = new ImageIcon(this.getClass().getResource("/3dDice.png")).getImage();
		
		JPanel titlePanel = new JPanel();
		welcomePanel.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		titlePanel.setBackground(new Color(255, 250, 205));
		
		
		JLabel lblFarkle = new JLabel("FARKLE");
		titlePanel.add(lblFarkle);
		lblFarkle.setFont(new Font("Tahoma", Font.PLAIN, 99));
		
		JLabel DiceDisplay = new JLabel("");
		titlePanel.add(DiceDisplay);
		DiceDisplay.setBackground(new Color(0, 0, 128));
		DiceDisplay.setIcon(new ImageIcon(img));
				
				JPanel southPanel = new JPanel();
				southPanel.setBackground(new Color(255, 250, 205));
				welcomePanel.add(southPanel, BorderLayout.CENTER);
				
				JPanel infoPanel = new JPanel();
				southPanel.add(infoPanel);
				infoPanel.setLayout(new GridLayout(2, 2, 0, 0));
				infoPanel.setBackground(new Color(255, 250, 205));
				infoPanel.setBackground(new Color(255, 250, 205));
				
				JPanel uName = new JPanel();
				infoPanel.add(uName);
				uName.setBackground(new Color(255, 250, 205));
				
				
				
				
				JLabel lblUsername = new JLabel("Username");
				uName.add(lblUsername);
				
				JPanel uNameText = new JPanel();
				infoPanel.add(uNameText);
				uNameText.setBackground(new Color(255, 250, 205));
				uNameText.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
				
				
				
				
				
				
				usernameText = new JTextField();
				uNameText.add(usernameText);
				usernameText.setColumns(10);
				
				JPanel pWord = new JPanel();
				infoPanel.add(pWord);
				pWord.setBackground(new Color(255, 250, 205));
				
				
				
				JLabel lblPassword = new JLabel("Password");
				pWord.add(lblPassword);
				
				JPanel pWordText = new JPanel();
				infoPanel.add(pWordText);
				pWordText.setBackground(new Color(255, 250, 205));
				
				
				
				JPasswordField passwordField = new JPasswordField();
				passwordField.setColumns(10);
				pWordText.add(passwordField);
				
				JPanel buttonPanel = new JPanel();
				southPanel.add(buttonPanel);
				buttonPanel.setLayout(new GridLayout(2, 1, 0, 0));
				buttonPanel.setBackground(new Color(255, 250, 205));
				
				JPanel logButton = new JPanel();
				logButton.setBackground(new Color(255, 250, 205));
				buttonPanel.add(logButton);
				
				
				//LOGIN BUTTON\\
						JButton btnLogin = new JButton("Login");
						logButton.add(btnLogin);
						btnLogin.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String test = usernameText.getText();
								
								String password = passwordField.getText();
							

								Database db = new Database(test, password);
								System.out.println(db.get());
								if (db.get()){
									System.out.println(test + " : " + password);
									System.out.println("LOgin debug");
									welcomePanel.setVisible(false);
									frame.remove(welcomePanel);
									
									Options options = new Options();
									JPanel mode = options.options(frame, test, db);
									frame.getContentPane().add(mode);
								}
								}
								
								
								
						});
						root.setDefaultButton(btnLogin);
						
						JPanel regButton = new JPanel();
						buttonPanel.add(regButton);
						regButton.setBackground(new Color(255, 250, 205));
						
						//REGISTER BUTTON\\
						JButton btnRegister = new JButton("Register");
						regButton.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					welcomePanel.setVisible(false);
					frame.remove(welcomePanel);
					//
					
					Register reg = new Register();
					JPanel regis = reg.register(frame);
					frame.getContentPane().add(regis);
				
				
			}
		});
		
		return welcomePanel;
	}
	
	public String getText(){
		return usernameText.getText();
	}

}
