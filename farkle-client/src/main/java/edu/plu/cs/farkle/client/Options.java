package edu.plu.cs.farkle.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Options{
	
	private int numPlayers=0;
	private JComboBox<String> comboBox ;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel options(JFrame frame, String name){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screen.getWidth();
		double height = screen.getHeight();
		int offsetWidth = (int)width/15;
		int offsetHeight = (int)height/15;
		
		JPanel mode = new JPanel();
		mode.setBackground(new Color(255, 250, 205));
		mode.setBounds(0, 0, (int)width, (int)height);
		frame.getContentPane().add(mode);
		mode.setLayout(null);
		
		
		
		JLabel lblWelcomeBack = new JLabel("Welcome Back, "+ name + "!");
		
		lblWelcomeBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblWelcomeBack.setBounds((int)width/2-offsetWidth, offsetHeight*2, 423, 77);
		mode.add(lblWelcomeBack);
		
		
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds((int)width/2+offsetWidth*2, (int)height/2, 60, 30);
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		mode.add(comboBox);
		
		JLabel num = new JLabel("Select Number of Players");
		num.setFont(new Font("Tahoma", Font.PLAIN, 12));
		num.setBounds((int)width/2+offsetWidth*3, (int)height/2, 741,30);
		mode.add(num);
		
		JButton btnPlayStandard = new JButton("Play Locally");
		btnPlayStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numPlayers = comboBox.getSelectedIndex();
				System.out.println("Number: "+numPlayers);
				mode.setVisible(false);
				
				
				
				PlayerScreen player = new PlayerScreen();
				JPanel start = player.initialize(frame, numPlayers);
				
				frame.getContentPane().add(start);
				
			}
		});
		btnPlayStandard.setBounds((int)width/2-offsetWidth, (int)height/2-offsetHeight, 240, 109);
		mode.add(btnPlayStandard);
		
		JButton btnPlayAI = new JButton("Play Against AI");
		btnPlayAI.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				
				
			}
		});
		btnPlayAI.setBounds((int)width/2-offsetWidth, (int)height/2+offsetHeight*2, 240, 109);
		mode.add(btnPlayAI);
		
		JComboBox<String> gameplayBox = new JComboBox<String>();
		gameplayBox.setBounds((int)width/2, (int)height/2-offsetHeight*2, 100, 20);
		mode.add(gameplayBox);
		gameplayBox.addItem("Standard");
		gameplayBox.addItem("Alternate");
		
		
		return mode;
		
	}
	
	public int getPlayers(){
		
		System.out.println("Players: " + numPlayers);
		return numPlayers;
	}
}
