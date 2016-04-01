package edu.plu.cs.farkle.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FarkleFrame {
	
	
	////////////////VARIABLES\\\\\\\\\\\\\\\\
	private JFrame frame;
	
	private int die, value, score, bankScore, tempScore = 0;
	
	private Image img;
	
	private Dice diceObj = new Dice();
	
	private ArrayList<Integer> roll = new ArrayList<Integer>();
	
	private Standard standard = new Standard();
	
	
	private boolean registerScreen = false;
	
	
	////////////////WINDOW VARIABLES\\\\\\\\\\	
	
	private JTextField txtScore;
	
	private Dimension screenSize;
	
	private double width, height;
	
	//amount to offset dimensions
	private int offsetWidth = (int)width/10;
	private int offsetHeight;
	
	private JTextField usernameText;
	
	private JButton btnLogin;
	
	private JLabel lblDice, label, label_1, label_2, label_3, label_4;
	
	private JPasswordField passwordField;
	
	private JPanel welcomePanel, register, game;
	
	private boolean borderOption, borderOption1, borderOption2, borderOption3, borderOption4, borderOption5= false;
	 Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
	 private JLabel lblScore;
	 private JLabel lblBankScore;
	 private JButton btnRoll;
	 private JButton endTurn;
	 private JTable table;
	 private JLabel currentPlayer;
	 
	 private JTextPane farkText;
	

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
		
		//BUG HERE\\
		
		//FIX NOW\\
		
		if(a < roll.size())
			die = roll.get(a);
		
		
		
		//////////////////////////////////////////////////////////////
		switch(die){
		case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
				j.setIcon(new ImageIcon(img));		
				//diceObj.banking(0, die);
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
		System.out.println(bdrCheck);
		if(!bdrCheck && roll.get(diceID)>0){
			
			if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK) {
				name.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				standard.addToSet(roll.get(diceID));
            }else{
            	name.setBorder(border);
            	standard.addToSingle(roll.get(diceID));
            	bdrCheck = true;
            }
			
			switch ( diceID ) {
			case 0:
				System.out.println(roll.get(0));
				if(roll.get(0) > 0)
					System.out.println("________________________");
				borderOption = true;
				break;
			case 1: 
				if(roll.get(1) > 0)
				borderOption1 = true;
				break;
			case 2: 
				if(roll.get(2) > 0)
				borderOption2 = true;
				break;
			case 3: 
				if(roll.get(3) > 0)
				borderOption3 = true;
				break;
			case 4: 
				if(roll.get(4) > 0)
				borderOption4 = true;
				break;
			case 5: 
				if(roll.get(5) > 0)
				borderOption5 = true;
				break;
			}
			diceObj.banking(diceID, roll.get(diceID));
		}
		else if(bdrCheck && roll.get(diceID)<0){
			System.out.println("UNBANKING");
			removeDice(name, diceID);
			
			name.setBorder(null);
			switch ( diceID ) {
			case 0: 
				if(roll.get(0) < 0)
				borderOption = false;
				break;
			case 1: 
				if(roll.get(1) < 0)
				borderOption1 = false;
				break;
			case 2: 
				if(roll.get(2) < 0)
				borderOption2 = false;
				break;
			case 3: 
				if(roll.get(3) < 0)
				borderOption3 = false;
				break;
			case 4: 
				if(roll.get(4) < 0)
				borderOption4 = false;
				break;
			case 5: 
				if(roll.get(5) < 0)
				borderOption5 = false;
				break;
			}
			diceObj.unBank(diceID, roll.get(diceID));
		}
		
		
	}
	
	
	/**
	 * 
	 * @param label
	 * @param i
	 */
	public void removeDice(JLabel label, int i){
		if ( ((LineBorder) label.getBorder()).getLineColor() == Color.RED ){
			standard.removeFromSet(roll.get(i));
		}else{
			standard.removeFromSingle(roll.get(i));
		}
	}
	
	/**
	 * 
	 */
	public void updateScore() {
		standard.bank();
		bankScore = standard.getScore();
		
	}
	
	public boolean blackout(JLabel dice, boolean b){
		Color c=new Color(1f,0f,0f,0f );
		if (b){
			dice.setBorder(BorderFactory.createLineBorder(c, 50));
		}
		return b;	
	}
	
	public void removeBlackout(){
		if (blackout(lblDice, borderOption)==blackout(label, borderOption1)&&
				blackout(label, borderOption1==blackout(label_1, borderOption2)&&
				blackout(label_1, borderOption2)==blackout(label_2, borderOption3)&&
				blackout(label_2, borderOption3)==blackout(label_3, borderOption4)&&
				blackout(label_3, borderOption4)==blackout(label_4, borderOption5)&&
						blackout(label_4, borderOption5)==true
			)){
			restart();
		}
	}
	
	public void restart(){
		//txtScore.setText(score);
		tempScore = 0;
		txtScore = new JTextField(100);
		txtScore.setText("Score: " + score);
		lblBankScore.setText("Bank Score: " + tempScore);
		diceObj.rollInit(6, 1, 6);
		roll = diceObj.getRoll();
		borderOption = false;
		borderOption1= false;
		borderOption2= false;
		borderOption3= false;
		borderOption4= false;
		borderOption5= false;
		
		lblDice.setBorder(null);
		label.setBorder(null);
		label_1.setBorder(null);
		label_2.setBorder(null);
		label_3.setBorder(null);
		label_4.setBorder(null);
		diceIMG(0, lblDice);
		diceIMG(1, label);
		diceIMG(2, label_1);
		diceIMG(3, label_2);
		diceIMG(4, label_3);
		diceIMG(5, label_4);
		
		if(farkText.isVisible())
			farkText.setVisible(false);
		
	}
	
	
	
	
	private void login(){
		
		welcomePanel = new JPanel();
		welcomePanel.setBackground(new Color(255, 250, 205));
		welcomePanel.setBounds(0, 0, (int)width, (int)height);
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);
		
		
		
		//LOGIN BUTTON\\
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				//SEE START METHOD
				start();
			}
		});
		btnLogin.setBounds((int)width/2+offsetWidth, (int)height/2, 89, 23);
		welcomePanel.add(btnLogin);
		
		usernameText = new JTextField();
		usernameText.setBounds((int)width/2, (int)height/2, 86, 20);
		welcomePanel.add(usernameText);
		usernameText.setColumns(10);
		
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds((int)width/2-offsetWidth, (int)height/2, 86, 20);
		welcomePanel.add(lblUsername);
		
		passwordField = new JPasswordField();
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
					register();
				
				
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
		lblUsername.setBounds((int)width/2-offsetWidth, (int)height/2, 86, 20);
		register.add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds((int)width/2, (int)height/2+offsetHeight, 86, 20);
		register.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds((int)width/2-offsetWidth, (int)height/2+offsetHeight, 65, 14);
		register.add(lblPassword);
		
		
		//REGISTER\\
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				//ENTER CODE HERE FOR REGISTERING USERNAMES AND PASSWORDS\\
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnRegister.setBounds((int)width/2+offsetWidth, (int)height/2+offsetHeight/2, 89, 23);
		register.add(btnRegister);
		
		
		JButton goBack = new JButton("Go Back");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				register.setVisible(false);
				welcomePanel.setVisible(true);
			}
		
		});
		goBack.setBounds((int)width/2, (int)height/2+offsetHeight*2, 89, 23);
		register.add(goBack);
	}
	
	
	
	private void start(){
		diceObj.rollInit(6, 1, 6);
		roll = diceObj.getRoll();
		
		if(diceObj.farkle()){
			
			
			farkText = new JTextPane();
			farkText.setText("YOU FARKLED!!!");
			farkText.setEditable(false);
			farkText.setBounds((int)width/2, (int)height/2, 213, 230);
			game.add(farkText);
			
			standard.clear();
			
		}
		
		
		//Game Panel
		game = new JPanel();
		game.setBackground(new Color(0, 128, 0));
		game.setBounds(0, 0, (int)width, (int)height);
		frame.getContentPane().add(game);
		game.setLayout(null);
		
		JInternalFrame rules = new JInternalFrame();
		rules.setBounds(1095,11, 239, 271);
		game.add(rules);
		rules.setVisible(true);
		rules.getContentPane().setLayout(null);
		
		JTextPane txtpnWelcomeToFarkle = new JTextPane();
		txtpnWelcomeToFarkle.setText("Welcome to Farkle! Here are some rules of the game mode you have selected.\n\nThere are six dice that you roll "
				+ "and you will choose dice to bank based on this scoring system:\n\n1's are worth 100 points\n5's are worth 50 points\n"
				+ "3 1's are worth 1000 points\n3 2's are worth 200 points\n");
		txtpnWelcomeToFarkle.setEditable(false);
		txtpnWelcomeToFarkle.setBounds(0, 0, 213, 230);
		rules.getContentPane().add(txtpnWelcomeToFarkle);
		
		lblDice = new JLabel("");
		lblDice.setBounds(106, 175, 50, 50);
		game.add(lblDice);
		
		
		label = new JLabel("");
		//label.setIcon(new ImageIcon("C:\\Users\\tjb46_000\\Documents\\farkle-red\\farkle-client\\bin\\Dice2.png"));
		label.setBounds(220, 175, 50, 50);
		game.add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(106, 274, 50, 50);
		game.add(label_1);
		
		
		
		label_2 = new JLabel("");
		//label_2.setIcon(new ImageIcon("C:\\Users\\tjb46_000\\Documents\\farkle-red\\farkle-client\\bin\\Dice3.png"));
		label_2.setBounds(220, 274, 50, 50);
		game.add(label_2);
		
		label_3 = new JLabel("");
		//label_3.setIcon(new ImageIcon("C:\\Users\\tjb46_000\\Documents\\farkle-red\\farkle-client\\bin\\Dice5.png"));
		label_3.setBounds(106, 374, 50, 50);
		game.add(label_3);
		
		label_4 = new JLabel("");
		//label_4.setIcon(new ImageIcon("C:\\Users\\tjb46_000\\Documents\\farkle-red\\farkle-client\\bin\\Dice4.png"));
		label_4.setBounds(220, 374, 50, 50);
		game.add(label_4);
		
		
		/*
		 * Handle Dice 0
		 */
		int temp = roll.get(0);
		if( temp >0){
			diceIMG(0,lblDice);
				lblDice.addMouseListener(new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent e){
						diceClick(0,lblDice, e, border, borderOption);
	
					}
				});
		}
		
		
		/*
		 * Handle Dice 1
		 */
		temp = roll.get(1);
		if( temp > 0){
			diceIMG(1,label);
			label.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e){
					diceClick(1, label, e, border, borderOption1);
	
				}
			});
		}
		
		/*
		 * Handle Dice 2
		 */
		temp = roll.get(2);
		if( temp > 0){
			diceIMG(2,label_1);
			label_1.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e){
					diceClick(2, label_1, e, border, borderOption2);
	
				}
			});
		}
		
		/*
		 * Handle Dice 3
		 */
		temp = roll.get(3);
		if( temp > 0){
			diceIMG(3,label_2);
			label_2.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e){
					diceClick(3, label_2, e, border, borderOption3);
	
				}
			});
		}
		
		/*
		 * Handle Dice 4
		 */
		temp = roll.get(4);
		if( temp > 0){
			diceIMG(4,label_3);
			label_3.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e){
					diceClick(4,label_3, e, border, borderOption4);
	
				}
			});
		}
		
		/*
		 * Handle Dice 5
		 */
		temp = roll.get(5);
		if( temp > 0){
			diceIMG(roll.size()-1,label_4);
			label_4.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e){
					diceClick(5, label_4, e, border, borderOption5);
	
				}
			});
		}
		
		lblScore = new JLabel("Score: "+score);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblScore.setBounds((int)width/2, 42, 162, 57);
		game.add(lblScore);
		
		lblBankScore = new JLabel("Bank Score: "+bankScore);
		lblBankScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBankScore.setBounds((int)width/2, 82, 162, 57);
		game.add(lblBankScore);
		
		
		//ROLL BUTTON\\
		
		btnRoll = new JButton("Roll");
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				diceObj.roll(6, 1, roll);
				
				if(diceObj.farkle()){
					bankScore = 0;
					tempScore = 0;
					farkText = new JTextPane();
					farkText.setText("YOU FARKLED!!!");
					farkText.setEditable(false);
					farkText.setBounds((int)width/2, (int)height/2, 213, 230);
					game.add(farkText);
					
					standard.clear();
					
				}
					
				roll = diceObj.getRoll();
				die = roll.get(0);
				

				blackout(lblDice, borderOption);
				blackout(label, borderOption1);
				blackout(label_1, borderOption2);
				blackout(label_2, borderOption3);
				blackout(label_3, borderOption4);
				blackout(label_4, borderOption5);
				
				removeBlackout();
				
				diceIMG(0, lblDice);
				diceIMG(1, label);
				diceIMG(2, label_1);
				diceIMG(3, label_2);
				diceIMG(4, label_3);
				diceIMG(5, label_4);
				
				updateScore();
				
				tempScore += standard.getTemp();
				lblBankScore.setText("Bank Score: " + tempScore);
			}
		});
		btnRoll.setBounds(106, 472, 164, 76);
		game.add(btnRoll);
		
		endTurn = new JButton("End Turn");
		endTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				score += bankScore;
				lblScore.setText("Score: " + score);
				bankScore = 0;
				standard = new Standard();
				lblDice.setBorder(null);
				label.setBorder(null);
				label_1.setBorder(null);
				label_2.setBorder(null);
				label_3.setBorder(null);
				label_4.setBorder(null);
				restart();
				standard.debug();
				
				
				
				
			}
		});
		endTurn.setBounds(106, 568, 164, 76);
		game.add(endTurn);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Player", "Score"},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setBounds(1095, 329, 239, 131);
		game.add(table);
		
		currentPlayer = new JLabel("Current Player: "+usernameText.getText());
		currentPlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		currentPlayer.setBounds(106, 42, 232, 57);
		game.add(currentPlayer);
		
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.getWidth();
		height = screenSize.getHeight();
		offsetWidth = (int)width/15;
		offsetHeight = (int)height/15;
		
		frame = new JFrame();
		frame.setSize((int)width, (int)height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		login();
		
		
		//start();
		
		
	}
}
