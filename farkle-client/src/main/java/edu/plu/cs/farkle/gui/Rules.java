package edu.plu.cs.farkle.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import edu.plu.cs.farkle.client.Database;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rules {

	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel rules(int selection, JFrame frame, int players, String type, String name, Database db) {

		JPanel rule = new JPanel();
		rule.setLayout(new BorderLayout(0, 0));
		
		JPanel rulePanel = new JPanel();
		rule.add(rulePanel, BorderLayout.CENTER);
		
		Color c = null;
		
		JTextArea ruleList = new JTextArea();
		if(selection == 0){
			ruleList.setText("Standard Rules: \nSelect Dice.\n1's = 100, 5's = 50\nThree 1's = 1000\nThree of a Kind 2-6 = Dice Value * 100 (ie: 2 = 200, 5 = 500)");
			c = (new Color(0, 128, 0));
		}
		else if(selection == 1){
			ruleList.setText("Alternate Rules: \nSelect Dice.\n1's = 100, 5's = 50\nThree 1's = 1000\nThree 2-6 = Dice Value * 100 (ie: 2 = 200, 5 = 500)"+
							"\nFull House = Three of a Kind + Pair (ie: 22255) Scored as Three of a Kind + 250\nThree Pair = 1500 (ie: 223355)\nStraight = 2500 (ie: 123456)"+
							"\nFour of a Kind = 2000\nFive of a Kind = 4000\nSix of a Kind = 6000");
			c = new Color(0, 255, 255);
		}
		ruleList.setEditable(false);
		rulePanel.setBackground(c);
		rule.setBackground(c);
		
		JScrollPane scroller = new JScrollPane(ruleList);
		rulePanel.add(scroller);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(c);
		rule.add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rule.setVisible(false);
				
				PlayerScreen player = new PlayerScreen();
				JPanel backPanel = player.initialize(frame, players, type, name, db);
				
				frame.remove(rule);
				frame.getContentPane().add(backPanel);
			}
		});
		buttonPanel.add(btnBack);
		
		
		return rule;
	}

}
