package edu.plu.cs.farkle.client;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

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
import java.awt.GridLayout;

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
		textBoxHolder.setLayout(new GridLayout(4,0,0, offsetHeight));
		
		JPanel textBoxPanel = new JPanel();
		textBoxHolder.add(textBoxPanel);
		textBoxPanel.setBackground(new Color(255, 250, 205));
		textBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		for(int i = 0; i < players+1; i ++){
			names[i] = new JTextField();
			names[i].setPreferredSize(new Dimension(86, 20));
			//names[i].setBounds((int)width/2, (offsetHeight*4)+offsetHeight*i, 86, 20);
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
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mode.setVisible(false);
				
				String selection = (String) gameplayBox.getSelectedItem();
				System.out.println(selection);
				
				for(int i = 0; i < playerList.size(); i++){
					playerList.get(i).setName(names[i].getText());
				}
				
				if(selection.equals("Standard")){
					StartGame start = new StartGame();
					JPanel strt = start.start(frame, players, playerList);
					
					
					frame.remove(mode);
					frame.getContentPane().add(strt);
				}
				else if(selection.equals("Alternate")){
					AlternateStart start = new AlternateStart();
					JPanel strt = start.start(frame, players, playerList);
					frame.remove(mode);
					frame.getContentPane().add(strt);
				}
			}
		});
		
	
		
		
		
		
		
		return mode;
	}

}
