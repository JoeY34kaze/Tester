import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.FlowLayout;

import javax.swing.JPanel;


public class Tester {

	public static SPanel panel;
	public static Izpisi_panel panel2;
	
	public SFrame frame;
	public Izpisi_Frame frame2;
	public static Test t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tester window = new Tester();
					window.frame2.setVisible(true);
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
	public Tester() {
		initialize();
		t=new Test();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//1. okno
		frame = new SFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		panel = new SPanel(frame);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		//2.okno
		frame2= new Izpisi_Frame();
		frame2.setBounds(100, 100, 600, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel2=new Izpisi_panel();
		frame2.getContentPane().add(panel2, BorderLayout.CENTER);
		
		
		
		
		
		
	}

}
