package gameoflife;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainWindow extends JFrame {
	private static final int WINDOW_WIDTH = 500;
	private static final int WINDOW_HEIGHT = 500;
	
	private static final String TITLE = "John Conway's Game of Life";
	
	private ButtonsPanel buttonsPanel;
	private Environment environment;
	
	public MainWindow() {
		buttonsPanel = new ButtonsPanel();
		environment = new Environment();
		
		setTitle(TITLE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setVisible(true);
	    
	    setLayout(new BorderLayout());
	    add(buttonsPanel, BorderLayout.NORTH);
	    add(environment, BorderLayout.CENTER);
	    
	    setListeners();
	}
	
	private void setRadioButtonsListeners() {
		buttonsPanel.getAliveCell().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				environment.setPaintAliveCells(true);
			}
		});
		
		buttonsPanel.getDeadCell().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				environment.setPaintAliveCells(false);
			}
		});
	}
	
	private void setListeners() {
		setRadioButtonsListeners();
	}
	
	public void setUpConfigurations() {
		environment.setUpEnviroment();
	}
	
	public static void main(String[] args) {
		
		try {
			// Set the OS' default LAF
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("Slider.paintValue", false);
			
			MainWindow mainWindow = new MainWindow();
			mainWindow.setVisible(true);
			mainWindow.setUpConfigurations();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
