package edu.plu.cs.farkle.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
	public JPanel rules(int selection, JFrame frame, int players, String type, String name) {

		JPanel rule = new JPanel();
		rule.setLayout(new BorderLayout(0, 0));
		
		JPanel rulePanel = new JPanel();
		rule.add(rulePanel, BorderLayout.CENTER);
		
		Color c = null;
		
		JTextArea ruleList = new JTextArea();
		if(selection == 0){
			ruleList.setText("Standard Rules: Play the game and win");
			c = (new Color(0, 128, 0));
		}
		else if(selection == 1){
			ruleList.setText("Alternate Rules: Play the game and lose");
			c = new Color(0, 255, 255);
		}
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
				JPanel backPanel = player.initialize(frame, players, type, name);
				
				frame.remove(rule);
				frame.getContentPane().add(backPanel);
			}
		});
		buttonPanel.add(btnBack);
		
		
		return rule;
	}

}
