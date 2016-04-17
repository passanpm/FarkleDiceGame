package edu.plu.cs.farkle.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

public class FarkleFrame {	
	////////////////VARIABLES\\\\\\\\\\\\\\\\
	private JFrame frame;	
	private Dimension screenSize;	
	private double width, height;
	private int offsetWidth = (int)width/10;


	private int offsetHeight;
	
	private JTextField usernameText;
	
	private JButton btnLogin;
	
	private JLabel lblDice, label, label_1, label_2, label_3, label_4;
	
	private JPasswordField passwordField;
	
	private JPanel welcomePanel, register, game;
	
	private ArrayList<Player> playerList;
	
	private boolean borderOption, borderOption1, borderOption2, borderOption3, borderOption4, borderOption5= false;
	 Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
	 private JLabel lblScore;
	 private JLabel lblBankScore;
	 private JButton btnRoll;
	 private JButton endTurn;
	 private JTable table;
	 private JLabel currentPlayer;
	 
	 private JTextPane farkText;
	 private JMenuItem mntmExit;
	 private JComboBox comboBox;
	


	/*private int offsetHeight;	
	private JPanel welcomePanel;


	private int offsetHeight;	
	private JPanel welcomePanel; */

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
	
	
	private void login(){
		
		LoginScreen log = new LoginScreen();
		
		welcomePanel = log.Login(frame);
		
		frame.add(welcomePanel);
		
	}


	
	
	
	private void register(){
		Register reg = new Register();
		register = reg.register(frame);
		
		frame.add(register);
	}
	
	private void options(){
		JPanel mode = new JPanel();
		mode.setBackground(new Color(255, 250, 205));
		mode.setBounds(0, 0, (int)width, (int)height);
		frame.getContentPane().add(mode);
		mode.setLayout(null);
		
		JLabel lblWelcomeBack = new JLabel("Welcome Back, " + usernameText.getText() + "!");
		lblWelcomeBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblWelcomeBack.setBounds((int)width/2, offsetHeight*2, 423, 77);
		mode.add(lblWelcomeBack);
		
		JButton btnPlayStandard = new JButton("Play Standard");
		btnPlayStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mode.setVisible(false);
				start();
			}
		});
		btnPlayStandard.setBounds((int)width/2-offsetWidth, (int)height/2-offsetHeight, 240, 109);
		mode.add(btnPlayStandard);
		
		comboBox = new JComboBox();
		comboBox.setBounds((int)width/2+offsetWidth*2, (int)height/2, 54, 30);
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		mode.add(comboBox);
		
		
		
		
		
	}
	
	private void start(){
		game = new JPanel();
		game.setBackground(new Color(0, 128, 0));
		game.setBounds(0, 0, (int)width, (int)height);
		frame.getContentPane().add(game);
		game.setLayout(null);
		
		
		diceObj.rollInit(6, 1, 6);
		roll = diceObj.getRoll();
		
		
		
		//Game Panel
	
		playerList = new ArrayList<player>();
		int temp1 = comboBox.getSelectedIndex()+1;
		System.out.println(temp1);
		for(int i = 0; i <= temp1; i++){
			playerList.add(new player());		
		}
		
		JInternalFrame rules = new JInternalFrame("Rules");
		rules.setBounds((int)width-offsetWidth*3, offsetHeight, 239, 271);
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
		label.setBounds(220, 175, 50, 50);
		game.add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(106, 274, 50, 50);
		game.add(label_1);
				
		label_2 = new JLabel("");
		label_2.setBounds(220, 274, 50, 50);
		game.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setBounds(106, 374, 50, 50);
		game.add(label_3);
		
		label_4 = new JLabel("");
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
			diceIMG(5,label_4);
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
					farkText.setBackground(new Color(0, 128, 0));
					farkText.setFont(new Font("Arial", Font.BOLD, 24));
					farkText.setEditable(false);
					farkText.setBounds((int)width/2, (int)height/2+offsetHeight, 500, 500);
					game.add(farkText);
					
					btnRoll.setEnabled(false);
					
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
				btnRoll.setEnabled(false);
			}
		});
		btnRoll.setBounds(106, 472, 164, 76);
		game.add(btnRoll);
		btnRoll.setEnabled(false);
		
		
		
		
		
		endTurn = new JButton("End Turn");
		endTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				score += bankScore;
				//playerList.get(0).setTotal(score);
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
				standard.clear();
				
				
				
				//table.setValueAt(playerList.get(0).getTotal(), 1, 1);
			}
		});
		endTurn.setBounds(106, 568, 164, 76);
		game.add(endTurn);
		
		
		String data[][] = new String[playerList.size()-1][2];
		for(int i = 0; i < playerList.size()-1; i++){
			data[i][0] = playerList.get(i).getName();
			data[i][1] = String.valueOf(playerList.get(i).getTotal());
		}
		
		String columnNames[] = {"Player", "Score"};
		
		table = new JTable(data, columnNames);
		
		table.setBounds((int)width/2, (int)height/2-offsetHeight, 239, 131);
		table.setVisible(true);
		
		JScrollPane pane = new JScrollPane();
		pane.setBounds((int)width/2, (int)height/2-offsetHeight, 239, 131);
		pane.setViewportView(table);
		game.add(pane);
		
		currentPlayer = new JLabel("Current Player: "+usernameText.getText());
		currentPlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		currentPlayer.setBounds(106, 42, 232, 57);
		game.add(currentPlayer);
		



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Farkle");
		Dimension temp = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(temp.width, temp.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.addComponentListener(new ResizeListener());
		
		screenSize = frame.getBounds().getSize();
		width = screenSize.getWidth();
		height = screenSize.getHeight();
		offsetWidth = (int)width/15;
		offsetHeight = (int)height/15;	
		login();	
	}
	class ResizeListener implements ComponentListener {

	    public void componentHidden(ComponentEvent e) {}
	    public void componentMoved(ComponentEvent e) {}
	    public void componentShown(ComponentEvent e) {}

	    public void componentResized(ComponentEvent e) {
	        Dimension newSize = e.getComponent().getBounds().getSize(); 
	        width = newSize.getWidth();
	        height = newSize.getHeight();
	        frame.setSize((int)width, (int)height);
	        frame.validate();
	        frame.repaint();
	        
	    }   
	}
}