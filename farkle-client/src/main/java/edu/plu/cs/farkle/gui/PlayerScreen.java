package edu.plu.cs.farkle.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import edu.plu.cs.farkle.client.AI;
import edu.plu.cs.farkle.client.Player;

import java.awt.GridLayout;

public class PlayerScreen {
	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel initialize(JFrame frame, int players, String type, String name) {	
		JPanel mode = new JPanel();
		mode.setBackground(new Color(255, 250, 205));
		frame.getContentPane().add(mode);
		mode.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		mode.add(panel);
		
		JLabel n = new JLabel("Enter Player Names");
		panel.add(n);
		n.setFont(new Font("Tahoma", Font.BOLD, 31));
			
		JTextField[] names = new JTextField[players+1];
		
		ArrayList<Player> playerList = new ArrayList<Player>();
		
		JPanel textBoxHolder = new JPanel();
		mode.add(textBoxHolder, BorderLayout.CENTER);
		textBoxHolder.setBackground(new Color(255, 250, 205));
		textBoxHolder.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel textBoxPanel = new JPanel();
		textBoxHolder.add(textBoxPanel);
		textBoxPanel.setBackground(new Color(255, 250, 205));
		textBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Player user = new Player();
		user.setName(name);
				
		playerList.add(user);
				
		for(int i = 1; i < players+1; i ++){
			names[i] = new JTextField();
			names[i].setPreferredSize(new Dimension(86, 20));
			textBoxPanel.add(names[i]);
			names[i].setColumns(20);
			
			playerList.add(new Player());
		}
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(255, 250, 205));
		mode.add(buttonPanel);
		
		JComboBox<String> gameplayBox = new JComboBox<String>();
		buttonPanel.add(gameplayBox);
		gameplayBox.addItem("Standard");
		gameplayBox.addItem("Alternate");
				
		JButton btnPlay = new JButton("Play");
		buttonPanel.add(btnPlay);
		
		JPanel rulePanel = new JPanel();
		rulePanel.setBackground(new Color(255, 250, 205));
		mode.add(rulePanel);
		
		JButton btnNewButton = new JButton("Rules");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selection = (String) gameplayBox.getSelectedItem();
				
				if(selection.equals("Standard")){
					mode.setVisible(false);
					Rules rules = new Rules();
					JPanel rulePanel = rules.rules(0, frame, players, type, name);
					frame.remove(mode);
					frame.getContentPane().add(rulePanel);
				}
				else if(selection.equals("Alternate")){
					mode.setVisible(false);
					Rules rules = new Rules();
					JPanel rulePanel = rules.rules(1, frame, players, type, name);
					
					frame.remove(mode);
					frame.getContentPane().add(rulePanel);
				}
			}
		});
		rulePanel.add(btnNewButton);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mode.setVisible(false);
				
				String selection = (String) gameplayBox.getSelectedItem();
				
				for(int i = 1; i < playerList.size(); i++){
					playerList.get(i).setName(names[i].getText());
				}
				if(type.equals("Local")){
					if(selection.equals("Standard")){
						StartGame start = new StartGame();
						JPanel strt = start.start(frame, players, playerList, 0);
						
						
						frame.remove(mode);
						frame.getContentPane().add(strt);
					}
					else if(selection.equals("Alternate")){
						StartGame start = new StartGame();
						JPanel strt = start.start(frame, players, playerList, 1);
						frame.remove(mode);
						frame.getContentPane().add(strt);
					}
				}
				else if(type.equals("AI")){
					playerList.add(new AI(1, "AI"));
					
					if(selection.equals("Standard")){
						StartStandardAI start = new StartStandardAI();
						JPanel strt = start.start(frame, players, playerList, 0);
						
						
						frame.remove(mode);
						frame.getContentPane().add(strt);
					}
					else if(selection.equals("Alternate")){
						StartStandardAI start = new StartStandardAI();
						JPanel strt = start.start(frame, players, playerList, 1);
						frame.remove(mode);
						frame.getContentPane().add(strt);
					}
				}
			}
		});	
		return mode;
	}
}