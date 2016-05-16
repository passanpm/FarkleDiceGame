package edu.plu.cs.farkle.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.table.JTableHeader;

import edu.plu.cs.farkle.client.Database;
import edu.plu.cs.farkle.client.Player;

import java.awt.FlowLayout;

public class Options{
	
	private int numPlayers=0;
	private JComboBox<String> comboBox ;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel options(JFrame frame, Player play, Database db){		
		JPanel mode = new JPanel();
		mode.setBackground(new Color(255, 250, 205));
		frame.getContentPane().add(mode);
		mode.setLayout(new BorderLayout(0, 0));
		
		JPanel welcomeBack = new JPanel();
		welcomeBack.setBackground(new Color(255, 250, 205));
		mode.add(welcomeBack, BorderLayout.NORTH);
		
		
		
		JLabel lblWelcomeBack = new JLabel("Welcome Back, "+ play.getName() + "!");
		welcomeBack.add(lblWelcomeBack);
		
		lblWelcomeBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JPanel middle = new JPanel();
		middle.setBackground(new Color(255, 250, 205));
		mode.add(middle, BorderLayout.CENTER);
		middle.setLayout(new BorderLayout(0, 0));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(255, 250, 205));
		middle.add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		JButton btnPlayLocal = new JButton("Play Locally");
		buttonPanel.add(btnPlayLocal);
		
		JButton btnPlayAI = new JButton("Play Against AI");
		buttonPanel.add(btnPlayAI);
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBackground(new Color(255, 250, 205));
		middle.add(playerPanel, BorderLayout.CENTER);
		
		
		
		comboBox = new JComboBox<String>();
		playerPanel.add(comboBox);
		
		JLabel num = new JLabel("Select Number of Players");
		playerPanel.add(num);
		num.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel leaderPanel = new JPanel();
		leaderPanel.setBackground(new Color(255, 250, 205));
		mode.add(leaderPanel, BorderLayout.SOUTH);
		
		String data[][] = new String[db.user.getPlayers().size()][2];
		System.out.println(db.user.getPlayers().size());
		for(int i = 0; i < db.user.getPlayers().size(); i++){
			data[i][0] = db.user.getPlayers().get(i).getName();
			
			data[i][1] = String.valueOf(db.user.getPlayers().get(i).getWins());
			if(data[i][0].equals(play.getName())){
				play.setWins(Integer.parseInt(data[i][1]));
			}
			
		}
		
		String columnNames[] = {"Username", "Wins"};
		
		
		
		
		
		//Leader board table
		JTable leaderboard = new JTable(data, columnNames);
		leaderboard.setVisible(true);
		leaderboard.setBackground(new Color(255, 250, 205));
		leaderboard.setGridColor(new Color(255, 250, 205));
		leaderboard.setEnabled(false);
		
		
		JTableHeader head = leaderboard.getTableHeader();
		head.setBackground(new Color(255, 250, 205));
		
		JScrollPane scroll = new JScrollPane();
		leaderPanel.add(scroll);
		scroll.setViewportView(leaderboard);
		
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		btnPlayAI.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				numPlayers = comboBox.getSelectedIndex();
				mode.setVisible(false);
				frame.remove(mode);
				
				
				PlayerScreen player = new PlayerScreen();
				JPanel start = player.initialize(frame, numPlayers, "AI", play, db);
				
				frame.getContentPane().add(start);
				
			}
		});
		btnPlayLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numPlayers = comboBox.getSelectedIndex();
				mode.setVisible(false);
				frame.remove(mode);
				
				
				PlayerScreen player = new PlayerScreen();
				JPanel start = player.initialize(frame, numPlayers, "Local", play, db);
				
				frame.getContentPane().add(start);
				
			}
		});
		
		
		return mode;
		
	}
	
	public int getPlayers(){
		
		System.out.println("Players: " + numPlayers);
		return numPlayers;
	}
}
