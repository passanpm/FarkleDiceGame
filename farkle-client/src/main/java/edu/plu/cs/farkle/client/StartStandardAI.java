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
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.border.MatteBorder;


public class StartStandardAI {

	
	private int die, score, bankScore, tempScore, zach = 0;
	
	private Image img;
	
	private Dice diceObj = new Dice();
	
	private ArrayList<Integer> roll = new ArrayList<Integer>();
	
	private Gameplay gameChoice;// = new gameChoice();
	
	private AI ai;
	
	
	////////////////WINDOW VARIABLES\\\\\\\\\\	
	
	private JTextField txtScore;
	

	
	private double width, height;
	private int lastTemp;
	//amount to offset dimensions
	private int offsetWidth = (int)width/10;
	private int offsetHeight;
	
	private JLabel lblDice, label, label_1, label_2, label_3, label_4;
	
	private JPanel  game;
	
	private int turn = 0;
	
	//private ArrayList<Player> playerList;
	
	private boolean borderOption, borderOption1, borderOption2, borderOption3, borderOption4, borderOption5= false;
	 Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
	 private JLabel lblScore;
	 private JLabel lblBankScore;
	 private JButton btnRoll;
	 private JButton endTurn;
	 private JTable table;
	 private JLabel currentPlayer;
	 
	 private JTextPane farkText;
	 private JMenuItem mntmExit;
	 private JPanel dicePanel;
	 private JPanel WestPanel;
	 private JPanel buttonPanel;
	 private JPanel NorthPanel;
	 private JPanel curPlayer;
	 private JPanel scorePanels;
	 private JPanel CenterPanel;
	 private JPanel SouthPanel;
	 
	 private Color c;
	 
////////////METHODS///////////////
		
/**
* 
* @param a
* @param j
*/
public void diceIMG(int a, JLabel j){
	//System.out.println(roll.toString());
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
		
		try{
		String soundName = "/click.wav";    
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(this.getClass().getResource(soundName).getPath()));
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
     	name.setBorder(border);
     	gameChoice.addToSingle(roll.get(diceID));
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
		
		tempScore = gameChoice.bankScore();
		lblBankScore.setText("Bank Score: " + (bankScore+zach+lastTemp));
		
		
		if(gameChoice.getTemp() > 0 && gameChoice.isChange()){
			btnRoll.setEnabled(true);
			
		}
		else
			btnRoll.setEnabled(false);
	}
	else if(bdrCheck && roll.get(diceID)<0){	
		try{
		String soundName = "/click.wav";    
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(this.getClass().getResource(soundName).getPath()));
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		gameChoice.removeFromSingle(roll.get(diceID));
		updateScore();
		tempScore = gameChoice.bankScore();
		
		lblBankScore.setText("Bank Score: " + (tempScore+zach+lastTemp));
		
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
		
		if(tempScore > 0){
			btnRoll.setEnabled(true);
		}
		
		if(gameChoice.getTemp()==0){
			btnRoll.setEnabled(false);
			
		}
		
	}
	
}

public void removeDice(JLabel label, int i){
		gameChoice.removeFromSingle(roll.get(i));
}

public void updateScore() {
	bankScore = gameChoice.bankScore();
}

public boolean blackout(JLabel dice, boolean b){
	Color c=new Color(1f,0f,0f,0f );
	if (b){
		//dice.setBorder(BorderFactory.createLineBorder(c, 10));
		dice.setVisible(false);
	}
	return b;	
}

public void removeBlackout(JLabel dice){
	/*if (blackout(lblDice, borderOption)==blackout(label, borderOption1)&&
			blackout(label, borderOption1==blackout(label_1, borderOption2)&&
			blackout(label_1, borderOption2)==blackout(label_2, borderOption3)&&
			blackout(label_2, borderOption3)==blackout(label_3, borderOption4)&&
			blackout(label_3, borderOption4)==blackout(label_4, borderOption5)&&
					blackout(label_4, borderOption5)==true
		)){*/
		dice.setVisible(true);
		restart();
	//}
}

public void restart(){
	tempScore = 0;
	zach = 0;
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

	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel start(JFrame frame, int players, ArrayList<Player> playerList, int choice) {		
		game = new JPanel();
		game.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		frame.getContentPane().add(game);
		game.setLayout(new BorderLayout());
		

		
			if(choice == 0){
				System.out.println("Choosing standard");
				gameChoice = new Standard();
				c = new Color(0, 128,0);
				game.setBackground(c);
			}
			else if(choice == 1){
				System.out.println("Choosing alternate");
				gameChoice = new Alternate();
				c = new Color(0, 255, 255);
				game.setBackground(c);
			}
			
		
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			width = screen.getWidth();
			height = screen.getHeight();
			offsetWidth = (int)width/15;
			offsetHeight = (int)height/15;
			
			String data[][] = new String[playerList.size()][2];
			for(int i = 0; i < playerList.size(); i++){
				data[i][0] = playerList.get(i).getName();
				data[i][1] = String.valueOf(playerList.get(i).getTotal());
			}
			String columnNames[] = {"Player", "Score"};
			
			ai = (AI)playerList.get(playerList.size()-1);
			
			JMenuBar menuBar = new JMenuBar();
			frame.getContentPane().add(menuBar, BorderLayout.NORTH);
			
			JMenu mnFile = new JMenu("File");
			menuBar.add(mnFile);
			
			//Sign out button
			JMenuItem mntmSignOut = new JMenuItem("Sign Out");
			mntmSignOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					game.setVisible(false);
					frame.remove(game);
					LoginScreen login = new LoginScreen();
					JPanel log = login.Login(frame);
					frame.getContentPane().add(log);
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
			
			WestPanel = new JPanel();
			WestPanel.setBackground(c);
			game.add(WestPanel, BorderLayout.WEST);
			WestPanel.setLayout(new BorderLayout(0, 0));
			
			dicePanel = new JPanel();
			dicePanel.setBackground(c);
			WestPanel.add(dicePanel, BorderLayout.NORTH);
			dicePanel.setLayout(new GridLayout(3, 2, 50, 50));
			
			lblDice = new JLabel("");
			lblDice.setSize(new Dimension(50, 50));
			dicePanel.add(lblDice);
			
			
			label = new JLabel("");
			label.setSize(new Dimension(50, 50));
			label.setPreferredSize(new Dimension(50,50));
			dicePanel.add(label);
			
			label_1 = new JLabel("");
			label_1.setSize(new Dimension(50, 50));
			label_1.setPreferredSize(new Dimension(50,50));
			dicePanel.add(label_1);
			
			label_2 = new JLabel("");
			label_2.setSize(new Dimension(50, 50));
			label_2.setPreferredSize(new Dimension(50,50));
			dicePanel.add(label_2);
			
			label_3 = new JLabel("");
			label_3.setSize(new Dimension(50, 50));
			label_3.setPreferredSize(new Dimension(50,50));
			dicePanel.add(label_3);
			
			label_4 = new JLabel("");
			label_4.setSize(new Dimension(50, 50));
			label_4.setPreferredSize(new Dimension(50,50));
			dicePanel.add(label_4);
			
			buttonPanel = new JPanel();
			buttonPanel.setBackground(c);
			WestPanel.add(buttonPanel, BorderLayout.SOUTH);
			
			btnRoll = new JButton("Roll");
			buttonPanel.add(btnRoll);
			btnRoll.setEnabled(false);
			
			endTurn = new JButton("End Turn");
			buttonPanel.add(endTurn);
			
			NorthPanel = new JPanel();
			NorthPanel.setBackground(c);
			game.add(NorthPanel, BorderLayout.NORTH);
			NorthPanel.setLayout(new BorderLayout(0, 0));
			
			curPlayer = new JPanel();
			curPlayer.setBackground(c);
			NorthPanel.add(curPlayer, BorderLayout.WEST);
			
			currentPlayer = new JLabel("Current Player: ");
			curPlayer.add(currentPlayer);
			currentPlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			scorePanels = new JPanel();
			scorePanels.setBackground(c);
			NorthPanel.add(scorePanels, BorderLayout.SOUTH);
			scorePanels.setLayout(new GridLayout(0, 2, 0, 0));
			
			lblScore = new JLabel("Score: 0");
			scorePanels.add(lblScore);
			lblScore.setFont(new Font("Tahoma", Font.PLAIN, 21));
			
			lblBankScore = new JLabel("Bank Score: "+bankScore);
			scorePanels.add(lblBankScore);
			lblBankScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			CenterPanel = new JPanel();
			CenterPanel.setBackground(c);
			game.add(CenterPanel, BorderLayout.CENTER);
			
			
			
			
			table = new JTable(data, columnNames);
		
			table.setBackground(c);
			table.setGridColor(c);
			JTableHeader head = table.getTableHeader();
			head.setBackground(c);

			table.setEnabled(false);
			
			table.setVisible(true);
			
			JScrollPane pane = new JScrollPane();
			pane.getViewport().setBackground(c);
			pane.setBorder(BorderFactory.createLineBorder(Color.black));
			CenterPanel.add(pane);
			pane.setViewportView(table);
			
			SouthPanel = new JPanel();
			game.add(SouthPanel, BorderLayout.SOUTH);
			SouthPanel.setBackground(c);
			farkText = new JTextPane();
			farkText.setText("");
			
			diceObj.rollInit(6, 1, 6);
			roll = diceObj.getRoll();
			
			
			playerTurn(playerList, choice);
			
			return game;
		
		
	}
	
	
	private void playerTurn(ArrayList<Player> playerList, int choice){
	
		
		
		if(choice == 0){
			c = new Color(0, 128,0);
		}
		else if(choice == 1){
			c = new Color(0, 255, 255);
		}
		
		currentPlayer.setText("Current Player: " + playerList.get(turn).getName());
		System.out.println(turn);
		
		
		System.out.println(playerList.get(turn).getName());
		
		
		
		
		if(diceObj.farkle()){
			try{
				String soundName = "/sadTrombone.wav";    
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(this.getClass().getResource(soundName).getPath()));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			farkText = new JTextPane();
			farkText.setText("YOU FARKLED!!!");
			farkText.setBackground(c);
			farkText.setFont(new Font("Arial", Font.BOLD, 24));
			farkText.setEditable(false);
			//farkText.setBounds((int)width/2, (int)height/2+offsetHeight*2, 500, 500);
			SouthPanel.add(farkText);
			
			btnRoll.setEnabled(false);
			gameChoice.clear();
			
			diceObj.rollInit(6, 1, 6);
			roll = diceObj.getRoll();
		}
		
		handleDice();
		
		
		
		
		//ROLL BUTTON\\
		
		lastTemp = 0;
		
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String soundName = "/diceThrow.wav";    
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(this.getClass().getResource(soundName).getPath()));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
				diceObj.roll(6, 1, roll);
				
				int i = 0;
				int foundNegative = 0;
				while(i < roll.size()){
					if(roll.get(i) < 0){
						System.out.println("Banked: " + foundNegative);
						foundNegative++;
					}
					i++;
				}
				
				if(foundNegative == 6){
					
					lastTemp = zach+tempScore;
					
					System.out.println("Zach: " + zach + "\nTempScore: " + tempScore + "\nbankScore: " + bankScore + "\nScore" + score);
					//tempScore += zach;
					System.out.println(tempScore);
					lblBankScore.setText("Bank Score: " + lastTemp);
					System.out.println("Success");
					diceObj.rollInit(6, 1, 6);
					roll = diceObj.getRoll();
					
					System.out.println(roll.toString());
					
					removeBlackout(lblDice);
					removeBlackout(label);
					removeBlackout(label_1);
					removeBlackout(label_2);
					removeBlackout(label_3);
					removeBlackout(label_4);
					
					
					
					//handleDice();
					
					
					
				}
				if(diceObj.farkle()){
					try{
						String soundName = "/sadTrombone.wav";    
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(this.getClass().getResource(soundName).getPath()));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
					}catch(Exception ex){
						ex.printStackTrace();
					}
					bankScore = 0;
					tempScore = 0;
					zach = 0;
					farkText = new JTextPane();
					farkText.setText("YOU FARKLED!!!");
					farkText.setBackground(c);
					farkText.setFont(new Font("Arial", Font.BOLD, 24));
					farkText.setEditable(false);
					SouthPanel.add(farkText);				
					btnRoll.setEnabled(false);
					
					gameChoice.clear();	

				}
					
				roll = diceObj.getRoll();
				//die = roll.get(0);
			
				blackout(lblDice, borderOption);
				blackout(label, borderOption1);
				blackout(label_1, borderOption2);
				blackout(label_2, borderOption3);
				blackout(label_3, borderOption4);
				blackout(label_4, borderOption5);
				
				
				
				diceIMG(0, lblDice);
				diceIMG(1, label);
				diceIMG(2, label_1);
				diceIMG(3, label_2);
				diceIMG(4, label_3);
				diceIMG(5, label_4);
				
				
				lblBankScore.setText("Bank Score: " + (tempScore+lastTemp));
				btnRoll.setEnabled(false);
				
				zach += tempScore;
				gameChoice.reset();
			}
		});
	
	
		
		//End turn button
		endTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				
				//Adds dice throwing sound
				try{
					String soundName = "/diceThrow.wav";    
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(this.getClass().getResource(soundName).getPath()));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
				
				if(turn == playerList.size()){
					turn = 0;
					currentPlayer.setText("Current Player: " + playerList.get(turn).getName());
				}
				System.out.println("Player: " + playerList.get(turn).getName() +"\nTurn: " + turn   + "\nScore: " + playerList.get(turn).getTotal());
				
				if(zach > 0){
					playerList.get(turn).setTotal(playerList.get(turn).getTotal()+zach+tempScore+lastTemp);
				}
				else if (tempScore > 0){
					playerList.get(turn).setTotal(playerList.get(turn).getTotal()+tempScore+lastTemp);
				}
				else if(tempScore > 0 && zach > 0){
					playerList.get(turn).setTotal(playerList.get(turn).getTotal()+(zach+tempScore+lastTemp));
				}
				lblScore.setText("Score: " + playerList.get(turn).getTotal());
				
				
				//Determines winner
				if(playerList.get(turn).getTotal() >= 10000 || ai.getTotal() >= 10000){
					farkText = new JTextPane();
					if(playerList.get(turn).getTotal() >= 10000)
						farkText.setText(" " + playerList.get(turn).getName() + " Wins!");
					else if(ai.getTotal() >= 10000)
						farkText.setText(" " + "AI Wins!");
					farkText.setBackground(c);
					farkText.setFont(new Font("Arial", Font.BOLD, 24));
					farkText.setVisible(true);
					farkText.setEditable(false);
					SouthPanel.setVisible(true);
					SouthPanel.add(farkText);
					try{
						String soundName = "/victory.wav";    
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(this.getClass().getResource(soundName).getPath()));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
					}catch(Exception ex){
						ex.printStackTrace();
					}
					
					endTurn.setEnabled(false);
					btnRoll.setEnabled(false);
					
					
					playerList.get(turn).setWins(playerList.get(turn).getWins()+1);
					System.out.println("Wins: " + playerList.get(turn).getWins());
				}
				//If there is no winner...
				else{
					
					
					tempScore = 0;
					lastTemp = 0;
					bankScore = 0;
					zach = 0;
					
					lblDice.setBorder(null);
					label.setBorder(null);
					label_1.setBorder(null);
					label_2.setBorder(null);
					label_3.setBorder(null);
					label_4.setBorder(null);
					
					restart();
					gameChoice.clear();
	
					table.setValueAt(String.valueOf(playerList.get(turn).getTotal()), turn, 1);
					
					
					turn++;
					if(turn == playerList.size()-1){
						
						diceObj.rollInit(6, 1, 6);
						ai.setRoll(diceObj.getRoll());
						
						
						
						//AI's list of scoring dice
						ArrayList<Integer> tempRoll = ai.getScore();
						ai.getIndexes();
						//AI's current total score
						int aiTemp = playerList.get(playerList.size()-1).getTotal();
						
						//Updates AI's total score
						playerList.get(playerList.size()-1).setTotal(gameChoice.aiBankScore(tempRoll)+aiTemp);
						
						table.setValueAt(String.valueOf(playerList.get(turn).getTotal()), turn, 1);
						
						/*try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}*/
						
						gameChoice.clear();
						turn = 0;
						tempRoll.clear();
						
						
					}
					
					
			
					
					removeBlackout(lblDice);
					removeBlackout(label);
					removeBlackout(label_1);
					removeBlackout(label_2);
					removeBlackout(label_3);
					removeBlackout(label_4);
					
					
					
				}
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		if(diceObj.farkle()){
			try{
				String soundName = "/sadTrombone.wav";    
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(this.getClass().getResource(soundName).getPath()));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			farkText = new JTextPane();
			farkText.setText("YOU FARKLED!!!");
			farkText.setBackground(c);
			farkText.setFont(new Font("Arial", Font.BOLD, 24));
			farkText.setEditable(false);
			SouthPanel.add(farkText);
			
			
			btnRoll.setEnabled(false);
			
			gameChoice.clear();
			
		}
	
	}
	
	private void handleDice(){
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
	}

}
