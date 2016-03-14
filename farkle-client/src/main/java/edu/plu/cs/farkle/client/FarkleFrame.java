package edu.plu.cs.farkle.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;

public class FarkleFrame {
	
	
	////////////////VARIABLES\\\\\\\\\\\\\\\\
	private JFrame frame;
	
	private int die, value, score;
	
	private Image img;
	
	private Dice diceObj = new Dice();
	
	private int[] roll = new int[6];
	
	private Standard standard = new Standard();
	
	
	private boolean registerScreen = false;
	
	
	////////////////WINDOW VARIABLES\\\\\\\\\\
	private JTextField txtScore;
	
	private Dimension screenSize;
	private double width, height;
	private JTextField usernameText;
	private JButton btnLogin;
	private JPasswordField passwordField;
	private JPanel welcomePanel, register;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarkleFrame window = new FarkleFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FarkleFrame() {
		initialize();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	////////////METHODS///////////////
	
	/**
	 * 
	 * @param a
	 * @param j
	 */
	public void diceIMG(int a, JLabel j){
		die = roll[a];
		switch(die){
		case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
				j.setIcon(new ImageIcon(img));		
				diceObj.banking(0, die);
				break;
		case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
				j.setIcon(new ImageIcon(img));
				value = 2;
				break;
		case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
				j.setIcon(new ImageIcon(img));
				value = 3;
				break;
		case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
				j.setIcon(new ImageIcon(img));
				value = 4;
				break;
		case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
				j.setIcon(new ImageIcon(img));
				value = 5;
				break;
		case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
				j.setIcon(new ImageIcon(img));
				value = 6;
				break;
		}
	}

	/**
	 * 
	 * @param diceID
	 * @param name
	 * @param e
	 * @param border
	 * @param bdrCheck
	 */
	public void diceClick(int diceID, JLabel name, MouseEvent e, Border border, boolean bdrCheck){
		if(!bdrCheck){
			diceObj.banking(diceID, roll[diceID]);
			if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK) {
				name.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				standard.addToSet(roll[diceID]);
            }else{
            	name.setBorder(border);
            	standard.addToSingle(roll[diceID]);
            }
			bdrCheck=true;
		}
		else{
			
			removeDice(name, diceID);
			
			diceObj.unBank(diceID);
			name.setBorder(null);
			bdrCheck=false;
		}
		
		updateScore();
	}
	
	
	/**
	 * 
	 * @param label
	 * @param i
	 */
	public void removeDice(JLabel label, int i){
		if ( ((LineBorder) label.getBorder()).getLineColor() == Color.RED ){
			standard.removeFromSet(roll[i]);
		}else{
			standard.removeFromSingle(roll[i]);
		}
	}
	
	/**
	 * 
	 */
	public void updateScore() {
		standard.bank();
		score = standard.getScore();
		txtScore.setText("Score: " + score);
	}
	
	
	
	
	
	private void login(){
		welcomePanel = new JPanel();
		welcomePanel.setBackground(new Color(255, 250, 205));
		welcomePanel.setBounds(0, 0, (int)width, (int)height);
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);
		
		usernameText = new JTextField();
		usernameText.setBounds((int)width/2, (int)height/2, 86, 20);
		welcomePanel.add(usernameText);
		usernameText.setColumns(10);
		
		//LOGIN BUTTON\\
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnLogin.setBounds(852, 383, 89, 23);
		welcomePanel.add(btnLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(545, 387, 86, 20);
		welcomePanel.add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(683, 452, 86, 20);
		welcomePanel.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(545, 455, 65, 14);
		welcomePanel.add(lblPassword);
		
		
		
		//REGISTER BUTTON\\
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					welcomePanel.setVisible(false);
					register();
				
				
			}
		});
		btnRegister.setBounds(852, 451, 89, 23);
		welcomePanel.add(btnRegister);
		
		
		JLabel lblFarkle = new JLabel("FARKLE");
		lblFarkle.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblFarkle.setBounds(526, 114, 445, 149);
		welcomePanel.add(lblFarkle);
		
		JLabel DiceDisplay = new JLabel("New label");
		DiceDisplay.setBackground(new Color(0, 0, 128));
		DiceDisplay.setBounds(902, 93, 252, 186);
		welcomePanel.add(DiceDisplay);
		
		img = new ImageIcon(this.getClass().getResource("/3dDice.png")).getImage();
		DiceDisplay.setIcon(new ImageIcon(img));
	}
	
	
	
	private void register(){
		register = new JPanel();
		register.setBackground(new Color(255, 250, 205));
		register.setBounds(0, 0, (int)width, (int)height);
		frame.getContentPane().add(register);
		register.setLayout(null);
		
		usernameText = new JTextField();
		usernameText.setBounds((int)width/2, (int)height/2, 86, 20);
		register.add(usernameText);
		usernameText.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(545, 387, 86, 20);
		register.add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(683, 452, 86, 20);
		register.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(545, 455, 65, 14);
		register.add(lblPassword);
		
		
		//REGISTER\\
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				//ENTER CODE HERE FOR REGISTERING USERNAMES AND PASSWORDS\\
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnRegister.setBounds(852, 420, 89, 23);
		register.add(btnRegister);
		
		
		JButton goBack = new JButton("Go Back");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				register.setVisible(false);
				welcomePanel.setVisible(true);
			}
		
		});
		goBack.setBounds(683, 600, 89, 23);
		register.add(goBack);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.getWidth();
		height = screenSize.getHeight();
		
		frame = new JFrame();
		frame.setSize((int)width, (int)height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		login();
		
		
	}
}
