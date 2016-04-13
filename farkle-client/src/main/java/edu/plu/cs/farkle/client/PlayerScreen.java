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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PlayerScreen {
	private JTextField textField;

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
				
				
				
				frame.getContentPane().add(strt);
			}
		});
		btnPlay.setBounds(605, 595, 89, 23);
		mode.add(btnPlay);
		
		JTextField[] names = new JTextField[players+1];
		
		ArrayList<Player> playerList = new ArrayList<Player>();
		
		for(int i = 0; i < players+1; i ++){
			names[i] = new JTextField();
			names[i].setBounds((int)width/2, (offsetHeight*4)+offsetHeight*i, 86, 20);
			mode.add(names[i]);
			names[i].setColumns(100);
			
			playerList.add(new Player());
		}
		
		
		
	
		return mode;
	}

}
