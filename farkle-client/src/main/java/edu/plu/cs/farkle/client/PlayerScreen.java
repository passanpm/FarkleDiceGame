package edu.plu.cs.farkle.client;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerScreen {

	//private JFrame frame;


	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel initialize(JFrame frame, int players) {
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
		
		JLabel n = new JLabel("Enter Player Names");
		n.setFont(new Font("Tahoma", Font.BOLD, 31));
		n.setBounds(516, 61, 317, 115);
		
		mode.add(n);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mode.setVisible(false);
				
				
				StartGame start = new StartGame();
				JPanel strt = start.start(frame, players);
				
				
				
				frame.add(strt);
			}
		});
		btnPlay.setBounds(605, 595, 89, 23);
		mode.add(btnPlay);
	
		return mode;
	}

}
