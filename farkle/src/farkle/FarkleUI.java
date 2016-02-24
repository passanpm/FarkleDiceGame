package farkle;

import farkle.*;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Canvas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class FarkleUI {

	private JFrame frmFarkle;
	private JTextField txtScore;
	int[] roll = new int[6];
	private Dice d6 = new Dice();
	boolean endTurn = false;
	int die = 0;
	private int score = 0;
	Image img;
	JLabel lblDice, label, label_1, label_2, label_3, label_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarkleUI window = new FarkleUI();
					window.frmFarkle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FarkleUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		d6.roll(6, 1, 6);
		roll = d6.getRoll();
		frmFarkle = new JFrame();
		frmFarkle.setTitle("Farkle");
		frmFarkle.setBounds(100, 100, 450, 300);
		frmFarkle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmFarkle.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game...");
		mnFile.add(mntmNewGame);
		mntmNewGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				score = 0;
			}
			
		});
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
			
		});
		frmFarkle.getContentPane().setLayout(null);
		
		
		
		
		//Sets up Dice
		
		
		
		
		lblDice = new JLabel("");
		lblDice.setBounds(32, 90, 56, 99);
		frmFarkle.getContentPane().add(lblDice);
		
		label = new JLabel("");
		label.setBounds(100, 90, 56, 99);
		frmFarkle.getContentPane().add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(168, 90, 56, 99);
		frmFarkle.getContentPane().add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(236, 90, 56, 99);
		frmFarkle.getContentPane().add(label_2);
		
		label_3 = new JLabel("");
		label_3.setBounds(304, 90, 56, 99);
		frmFarkle.getContentPane().add(label_3);
		
		label_4 = new JLabel("");
		label_4.setBounds(372, 90, 56, 99);
		frmFarkle.getContentPane().add(label_4);
		
		JButton btnRoll = new JButton("Roll");
		btnRoll.setBounds(42, 204, 90, 28);
		frmFarkle.getContentPane().add(btnRoll);
		
		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.setBounds(314, 204, 90, 28);
		frmFarkle.getContentPane().add(btnEndTurn);
		
		JPanel StartPanel = new JPanel();
		StartPanel.setBackground(Color.GREEN);
		StartPanel.setForeground(Color.GREEN);
		StartPanel.setBounds(0, 0, 434, 238);
		frmFarkle.getContentPane().add(StartPanel);
		StartPanel.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(151, 5, 132, 38);
		StartPanel.add(panel);
		panel.setBackground(Color.GREEN);
		
		txtScore = new JTextField();
		txtScore.setEditable(false);
		txtScore.setText("Score: " + score);
		panel.add(txtScore);
		txtScore.setColumns(10);
		
		die = roll[0];
		
		switch(die){
		case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
				lblDice.setIcon(new ImageIcon(img));
				break;
		case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
				lblDice.setIcon(new ImageIcon(img));
				break;
		case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
				lblDice.setIcon(new ImageIcon(img));
				break;
		case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
				lblDice.setIcon(new ImageIcon(img));
				break;
		case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
				lblDice.setIcon(new ImageIcon(img));
				break;
		case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
				lblDice.setIcon(new ImageIcon(img));
				break;
		}
		
		
		
		
		
		die = roll[1];
		switch(die){
		case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
				label.setIcon(new ImageIcon(img));
				break;
		case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
				label.setIcon(new ImageIcon(img));
				break;
		case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
				label.setIcon(new ImageIcon(img));
				break;
		case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
				label.setIcon(new ImageIcon(img));
				break;
		case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
				label.setIcon(new ImageIcon(img));
				break;
		case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
				label.setIcon(new ImageIcon(img));
				break;
		}
		
		
		
		die = roll[2];
		switch(die){
		case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
				label_1.setIcon(new ImageIcon(img));
				break;
		case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
				label_1.setIcon(new ImageIcon(img));
				break;
		case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
				label_1.setIcon(new ImageIcon(img));
				break;
		case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
				label_1.setIcon(new ImageIcon(img));
				break;
		case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
				label_1.setIcon(new ImageIcon(img));
				break;
		case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
				label_1.setIcon(new ImageIcon(img));
				break;
		}
		
		die = roll[3];
		switch(die){
		case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
				label_2.setIcon(new ImageIcon(img));
				break;
		case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
				label_2.setIcon(new ImageIcon(img));
				break;
		case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
				label_2.setIcon(new ImageIcon(img));
				break;
		case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
				label_2.setIcon(new ImageIcon(img));
				break;
		case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
				label_2.setIcon(new ImageIcon(img));
				break;
		case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
				label_2.setIcon(new ImageIcon(img));
				break;
		}
		
		die = roll[4];
		switch(die){
		case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
				label_3.setIcon(new ImageIcon(img));
				break;
		case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
				label_3.setIcon(new ImageIcon(img));
				break;
		case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
				label_3.setIcon(new ImageIcon(img));
				break;
		case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
				label_3.setIcon(new ImageIcon(img));
				break;
		case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
				label_3.setIcon(new ImageIcon(img));
				break;
		case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
				label_3.setIcon(new ImageIcon(img));
				break;
		}
		
		die = roll[5];
		switch(die){
		case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
				label_4.setIcon(new ImageIcon(img));
				break;
		case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
				label_4.setIcon(new ImageIcon(img));
				break;
		case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
				label_4.setIcon(new ImageIcon(img));
				break;
		case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
				label_4.setIcon(new ImageIcon(img));
				break;
		case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
				label_4.setIcon(new ImageIcon(img));
				break;
		case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
				label_4.setIcon(new ImageIcon(img));
				break;
		}
		
		
		
		btnRoll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				d6.roll(6, 1, 6);
				roll = d6.getRoll();
				die = roll[0];
				
				switch(die){
				case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
						lblDice.setIcon(new ImageIcon(img));
						break;
				case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
						lblDice.setIcon(new ImageIcon(img));
						break;
				case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
						lblDice.setIcon(new ImageIcon(img));
						break;
				case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
						lblDice.setIcon(new ImageIcon(img));
						break;
				case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
						lblDice.setIcon(new ImageIcon(img));
						break;
				case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
						lblDice.setIcon(new ImageIcon(img));
						break;
				}
				
				
				
				
				
				die = roll[1];
				switch(die){
				case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
						label.setIcon(new ImageIcon(img));
						break;
				case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
						label.setIcon(new ImageIcon(img));
						break;
				case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
						label.setIcon(new ImageIcon(img));
						break;
				case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
						label.setIcon(new ImageIcon(img));
						break;
				case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
						label.setIcon(new ImageIcon(img));
						break;
				case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
						label.setIcon(new ImageIcon(img));
						break;
				}
				
				
				
				die = roll[2];
				switch(die){
				case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
						label_1.setIcon(new ImageIcon(img));
						break;
				case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
						label_1.setIcon(new ImageIcon(img));
						break;
				case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
						label_1.setIcon(new ImageIcon(img));
						break;
				case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
						label_1.setIcon(new ImageIcon(img));
						break;
				case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
						label_1.setIcon(new ImageIcon(img));
						break;
				case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
						label_1.setIcon(new ImageIcon(img));
						break;
				}
				
				die = roll[3];
				switch(die){
				case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
						label_2.setIcon(new ImageIcon(img));
						break;
				case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
						label_2.setIcon(new ImageIcon(img));
						break;
				case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
						label_2.setIcon(new ImageIcon(img));
						break;
				case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
						label_2.setIcon(new ImageIcon(img));
						break;
				case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
						label_2.setIcon(new ImageIcon(img));
						break;
				case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
						label_2.setIcon(new ImageIcon(img));
						break;
				}
				
				die = roll[4];
				switch(die){
				case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
						label_3.setIcon(new ImageIcon(img));
						break;
				case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
						label_3.setIcon(new ImageIcon(img));
						break;
				case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
						label_3.setIcon(new ImageIcon(img));
						break;
				case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
						label_3.setIcon(new ImageIcon(img));
						break;
				case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
						label_3.setIcon(new ImageIcon(img));
						break;
				case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
						label_3.setIcon(new ImageIcon(img));
						break;
				}
				
				die = roll[5];
				switch(die){
				case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
						label_4.setIcon(new ImageIcon(img));
						break;
				case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
						label_4.setIcon(new ImageIcon(img));
						break;
				case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
						label_4.setIcon(new ImageIcon(img));
						break;
				case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
						label_4.setIcon(new ImageIcon(img));
						break;
				case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
						label_4.setIcon(new ImageIcon(img));
						break;
				case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
						label_4.setIcon(new ImageIcon(img));
						break;
				}
				
				
				
			}
		});
		
		}
}
