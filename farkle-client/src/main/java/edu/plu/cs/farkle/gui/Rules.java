package edu.plu.cs.farkle.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.JButton;

public class Rules {

	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel rules(int selection) {

		JPanel rule = new JPanel();
		rule.setLayout(new BorderLayout(0, 0));
		
		JPanel rulePanel = new JPanel();
		rule.add(rulePanel, BorderLayout.CENTER);
		
		JTextArea ruleList = new JTextArea();
		if(selection == 0){
			ruleList.setText("Standard Rules: ");
		}
		else if(selection == 1){
			ruleList.setText("Alternate Rules: ");
		}
		
		JScrollPane scroller = new JScrollPane(ruleList);
		rulePanel.add(scroller);
		
		JPanel buttonPanel = new JPanel();
		rule.add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnBack = new JButton("Back");
		buttonPanel.add(btnBack);
		
		
		return rule;
	}

}
