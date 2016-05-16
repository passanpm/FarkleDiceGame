package edu.plu.cs.farkle.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.awt.BorderLayout;


public class FarkleFrame {	
	////////////////VARIABLES\\\\\\\\\\\\\\\\
	private JFrame frame;	
	private Dimension screenSize;	
	private double width, height;

	private JPanel welcomePanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarkleFrame window = new FarkleFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FarkleFrame() {
		initialize();
	}
	
	/**
	 * Launch Initial Screen (Login and option to register)
	 */
	private void login(){
		
		LoginScreen log = new LoginScreen();
		
		welcomePanel = log.Login(frame);
		
		frame.getContentPane().add(welcomePanel);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Farkle");
		Dimension temp = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(temp.width, temp.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		frame.addComponentListener(new ResizeListener());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		screenSize = frame.getBounds().getSize();
		width = screenSize.getWidth();
		height = screenSize.getHeight();
		
		try{
			String soundName = "/loop.wav";    
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(this.getClass().getResource(soundName).getPath()));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.loop(clip.LOOP_CONTINUOUSLY);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		login();	
	}
	class ResizeListener implements ComponentListener {

	    public void componentHidden(ComponentEvent e) {}
	    public void componentMoved(ComponentEvent e) {}
	    public void componentShown(ComponentEvent e) {}

	    public void componentResized(ComponentEvent e) {
	        Dimension newSize = e.getComponent().getBounds().getSize(); 
	        width = newSize.getWidth();
	        height = newSize.getHeight();
	        frame.setSize((int)width, (int)height);
	        frame.revalidate();
	        frame.repaint();
	        
	    }   
	}
}