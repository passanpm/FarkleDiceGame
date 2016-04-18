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
	
	public JPanel options(JFrame frame){
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
		
		JLabel lblWelcomeBack = new JLabel("Welcome Back, "  + "");
		lblWelcomeBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblWelcomeBack.setBounds((int)width/2, offsetHeight*2, 423, 77);
		mode.add(lblWelcomeBack);
		
		
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds((int)width/2+offsetWidth*2, (int)height/2, 54, 30);
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		mode.add(comboBox);
		
		
		
		JButton btnPlayStandard = new JButton("Play Standard");
		btnPlayStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numPlayers = comboBox.getSelectedIndex();
				System.out.println("Number: "+numPlayers);
				mode.setVisible(false);
				
				
				
				PlayerScreen player = new PlayerScreen();
				JPanel start = player.initialize(frame, numPlayers);
				
				frame.add(start);
				
			}
		});
		btnPlayStandard.setBounds((int)width/2-offsetWidth, (int)height/2-offsetHeight, 240, 109);
		mode.add(btnPlayStandard);
		
		return mode;
		
	}
	
	public int getPlayers(){
		
		System.out.println("Players: " + numPlayers);
		return numPlayers;
	}

}
