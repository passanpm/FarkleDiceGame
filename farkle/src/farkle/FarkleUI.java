package farkle;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.BorderFactory;
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
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class FarkleUI extends Gameplay{

	private JFrame frmFarkle;
	private JTextField txtScore;
	int[] roll = new int[6];
	private Dice d6 = new Dice();
	boolean endTurn = false;
	int die = 0;
	private int score = 0;
	private int value = 0;
	private boolean borderOption, borderOption1, borderOption2, borderOption3, borderOption4, borderOption5= false;
	private int rolling = 1;
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
		
		 Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
		
		
		
		lblDice = new JLabel("");
		lblDice.setBounds(30, 92, 50, 50);
		frmFarkle.getContentPane().add(lblDice);
		
		
		label = new JLabel("");
		label.setBounds(95, 92, 50, 50);
		frmFarkle.getContentPane().add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(160, 92, 50, 50);
		frmFarkle.getContentPane().add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(225, 92, 50, 50);
		frmFarkle.getContentPane().add(label_2);
		
		label_3 = new JLabel("");
		label_3.setBounds(290, 92, 50, 50);
		frmFarkle.getContentPane().add(label_3);
		
		label_4 = new JLabel("");
		label_4.setBounds(355, 92, 50, 50);
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
		/*img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
		lblDice.setIcon(new ImageIcon(img));
		label.setIcon(new ImageIcon(img));
		label_1.setIcon(new ImageIcon(img));
		label_2.setIcon(new ImageIcon(img));
		label_3.setIcon(new ImageIcon(img));
		label_4.setIcon(new ImageIcon(img));*/
		switch(die){
		case 1: img = new ImageIcon(this.getClass().getResource("/Dice1.png")).getImage();
				lblDice.setIcon(new ImageIcon(img));
				
				d6.banking(0, die);
				break;
		case 2: img = new ImageIcon(this.getClass().getResource("/Dice2.png")).getImage();
				lblDice.setIcon(new ImageIcon(img));
				value = 2;
				break;
		case 3: img = new ImageIcon(this.getClass().getResource("/Dice3.png")).getImage();
				lblDice.setIcon(new ImageIcon(img));
				value = 3;
				break;
		case 4: img = new ImageIcon(this.getClass().getResource("/Dice4.png")).getImage();
				lblDice.setIcon(new ImageIcon(img));
				value = 4;
				break;
		case 5: img = new ImageIcon(this.getClass().getResource("/Dice5.png")).getImage();
				lblDice.setIcon(new ImageIcon(img));
				value = 5;
				break;
		case 6: img = new ImageIcon(this.getClass().getResource("/Dice6.png")).getImage();
				lblDice.setIcon(new ImageIcon(img));
				value = 6;
				break;
		}
	
			lblDice.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e){
					
					if(!borderOption){
						d6.banking(0, roll[0]);
						if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK) {
							lblDice.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			            }else{
			            	lblDice.setBorder(border);
			            }
						borderOption=true;
						//end turn button listener; blackout
						btnRoll.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								lblDice.setBorder(BorderFactory.createLineBorder(Color.BLACK, 50));
							}
						});
					}
					else{
						d6.unBank(0);
						lblDice.setBorder(null);
						borderOption=false;
					}
				}
			});
		
		
		
		
		
		
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
		label.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if(!borderOption1){
					d6.banking(1, roll[1]);
					if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK) {
						label.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		            }else{
		            	label.setBorder(border);
		            }
					borderOption1=true;
					//end turn button listener; blackout
					btnRoll.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 50));
						}
					});
				}
				else{
					d6.unBank(1);
					label.setBorder(null);
					borderOption1=false;
				}
			}
		});
		
		
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
		label_1.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if(!borderOption2){
					d6.banking(2, roll[2]);
					if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK) {
						label_1.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		            }else{
		            	label_1.setBorder(border);
		            }
					borderOption2=true;
					//end turn button listener; blackout
					btnRoll.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							label_1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 50));
						}
					});
				}
				else{
					d6.unBank(2);
					label_1.setBorder(null);
					borderOption2=false;
				}
			}
		});
		
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
		label_2.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if(!borderOption3){
					d6.banking(3, roll[3]);
					if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK) {
						label_2.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		            }else{
		            	label_2.setBorder(border);
		            }
					borderOption3=true;
					//end turn button listener; blackout
					btnRoll.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							label_2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 50));
						}
					});
				}
				else{
					d6.unBank(3);
					label_2.setBorder(null);
					borderOption3=false;
				}
			}
		});
		
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
		label_3.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if(!borderOption4){
					d6.banking(4, roll[4]);
					if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK) {
						label_3.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		            }else{
		            	label_3.setBorder(border);
		            }
					borderOption4=true;
					//end turn button listener; blackout
					btnRoll.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							label_3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 50));
						}
					});
				}
				else{
					d6.unBank(4);
					label_3.setBorder(null);
					borderOption4=false;
				}
			}
		});
		
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
		label_4.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if(!borderOption5){
					d6.banking(4, roll[4]);

					if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK) {
						label_4.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		            }else{
		            	label_4.setBorder(border);
		            }
					
					borderOption5=true;
					//end turn button listener; blackout
					btnRoll.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							label_4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 50));
						}
					});
				}
				else{
					d6.unBank(4);
					label_4.setBorder(null);
					borderOption5=false;
				}
			}
		});
		
		//end turn button listener
		btnEndTurn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				
			}
		});
		
		
		
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
