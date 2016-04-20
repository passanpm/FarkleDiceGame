package edu.plu.cs.farkle.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class StartGame {
	

	
	private int die, score, bankScore, tempScore = 0;
	
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
	
	private int turn = 0;
	
	//private ArrayList<Player> playerList;
	
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
	 
////////////METHODS///////////////
		
/**
* 
* @param a
* @param j
*/
public void diceIMG(int a, JLabel j){
	
	if(a < roll.size())
		die = roll.get(a);


	switch(die){
	case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
			j.setIcon(new ImageIcon(img));		
			break;
	case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
			j.setIcon(new ImageIcon(img));
			break;
	case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
			j.setIcon(new ImageIcon(img));
			break;
	case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
			j.setIcon(new ImageIcon(img));
			break;
	case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
			j.setIcon(new ImageIcon(img));
			break;
	case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
			j.setIcon(new ImageIcon(img));
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
	
	if(!bdrCheck && roll.get(diceID)>0){
		

    
     	name.setBorder(border);
     	standard.addToSingle(roll.get(diceID));
     	bdrCheck = true;
     
		
		switch ( diceID ) {
		case 0:
			
			if(roll.get(0) > 0)
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
		updateScore();
		
		tempScore = standard.bankScore();
		lblBankScore.setText("Bank Score: " + tempScore);
		
		
		if(standard.getTemp() > 0){
			btnRoll.setEnabled(true);
			
		}
		else
			btnRoll.setEnabled(false);
	}
	else if(bdrCheck && roll.get(diceID)<0){		
		standard.removeFromSingle(roll.get(diceID));
		updateScore();
		tempScore = standard.bankScore();
		
		lblBankScore.setText("Bank Score: " + tempScore);
		
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
		
		if(standard.getTemp()==0)
			btnRoll.setEnabled(false);
		
	}
	
}

public void removeDice(JLabel label, int i){
		standard.removeFromSingle(roll.get(i));
}

public void updateScore() {
	bankScore = standard.bankScore();
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
	
	btnRoll.setEnabled(false);
	
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
	
	if(farkText != null && farkText.isVisible())
		farkText.setVisible(false);
	
	
	
	}

	public JPanel start(JFrame frame, int players, ArrayList<Player> playerList) {		
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			width = screen.getWidth();
			height = screen.getHeight();
			offsetWidth = (int)width/15;
			offsetHeight = (int)height/15;
			
			game = new JPanel();
			game.setBackground(new Color(0, 128, 0));
			game.setBounds(0, 0, (int)width, (int)height);
			frame.getContentPane().add(game);
			game.setLayout(null);
			
			
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
			
			lblScore = new JLabel("Score: 0");
			lblScore.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblScore.setBounds((int)width/2, 42, 162, 57);
			game.add(lblScore);
			
			lblBankScore = new JLabel("Bank Score: "+bankScore);
			lblBankScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblBankScore.setBounds((int)width/2, 82, 162, 57);
			game.add(lblBankScore);
			
			btnRoll = new JButton("Roll");
			btnRoll.setBounds(106, 472, 164, 76);
			game.add(btnRoll);
			btnRoll.setEnabled(false);
			
			endTurn = new JButton("End Turn");
			endTurn.setBounds(106, 568, 164, 76);
			game.add(endTurn);
			
			String data[][] = new String[playerList.size()][2];
			for(int i = 0; i < playerList.size(); i++){
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
			
			currentPlayer = new JLabel("Current Player: ");
			currentPlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
			currentPlayer.setBounds(106, 42, 232, 57);
			game.add(currentPlayer);
			

			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, (int)width, 21);
			game.add(menuBar);
			
			JMenu mnFile = new JMenu("File");
			menuBar.add(mnFile);
			
			//Sign out button
			JMenuItem mntmSignOut = new JMenuItem("Sign Out");
			mntmSignOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					game.setVisible(false);
					LoginScreen login = new LoginScreen();
					JPanel log = login.Login(frame);
					frame.add(log);
				}
			});
			mnFile.add(mntmSignOut);
			
			
			//Exit button
			
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			mnFile.add(mntmExit);
			
			
			playerTurn(playerList);
			
			return game;
		
		
	}
	
	
	private void playerTurn(ArrayList<Player> playerList){
		
		currentPlayer.setText("Current Player: " + playerList.get(turn).getName());
		System.out.println(playerList.get(turn).getName());
		diceObj.rollInit(6, 1, 6);
		
		roll = diceObj.getRoll();
		
		if(diceObj.farkle()){
			farkText = new JTextPane();
			farkText.setText("YOU FARKLED!!!");
			farkText.setBackground(new Color(0, 128, 0));
			farkText.setFont(new Font("Arial", Font.BOLD, 24));
			farkText.setEditable(false);
			farkText.setBounds((int)width/2, (int)height/2+offsetHeight*2, 500, 500);
			game.add(farkText);
			
			btnRoll.setEnabled(false);
			standard.clear();
		}
		
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
		
		
		
		
		//ROLL BUTTON\\
		
	
		
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
				
				
				lblBankScore.setText("Bank Score: " + tempScore);
				btnRoll.setEnabled(false);
			}
		});
	
		
		
		//End turn button
		endTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(turn == playerList.size()){
					turn = 0;
					currentPlayer.setText("Current Player: " + playerList.get(turn).getName());
				}
				
				
				
				score += bankScore;
				playerList.get(turn).setTotal(bankScore);
				lblScore.setText("Score: " + playerList.get(turn).getTotal());
				bankScore = 0;
				standard = new Standard();
				lblDice.setBorder(null);
				label.setBorder(null);
				label_1.setBorder(null);
				label_2.setBorder(null);
				label_3.setBorder(null);
				label_4.setBorder(null);
				restart();
				standard.clear();

				table.setValueAt(String.valueOf(playerList.get(turn).getTotal()), turn, 1);
				
				
				turn++;
				if(turn >= playerList.size()){
					currentPlayer.setText("Current Player: " + playerList.get(0).getName());
					lblScore.setText("Score: " + playerList.get(0).getTotal());
				}
				else{
					currentPlayer.setText("Current Player: " + playerList.get(turn).getName());
					lblScore.setText("Score: " + playerList.get(turn).getTotal());
				}
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		if(diceObj.farkle()){
			
			
			farkText = new JTextPane();
			farkText.setText("YOU FARKLED!!!");
			farkText.setBackground(new Color(0, 128, 0));
			farkText.setFont(new Font("Arial", Font.BOLD, 24));
			farkText.setEditable(false);
			farkText.setBounds((int)width/2, (int)height/2+offsetHeight*2, 500, 500);
			game.add(farkText);
			
			
			btnRoll.setEnabled(false);
			
			standard.clear();
			
		}
	
		
		//frame.setSize((int)width, (int)height);
		//frame.repaint();
		//frame.revalidate();
	}

}
