package edu.plu.cs.farkle.client;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class FarkleFrame {	
	////////////////VARIABLES\\\\\\\\\\\\\\\\
	private JFrame frame;	
	private Dimension screenSize;	
	private double width, height;
	private int offsetWidth = (int)width/10;
	private int offsetHeight;	
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
		
		frame.add(welcomePanel);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Farkle");
		Dimension temp = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(temp.width, temp.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.addComponentListener(new ResizeListener());
		
		screenSize = frame.getBounds().getSize();
		width = screenSize.getWidth();
		height = screenSize.getHeight();
		offsetWidth = (int)width/15;
		offsetHeight = (int)height/15;	
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
	        frame.validate();
	        frame.repaint();
	        
	    }   
	}
}