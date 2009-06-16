package checkers.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import checkers.controller.GameCenter;
import checkers.sandbox.Board;

@SuppressWarnings("serial")
public class MainView extends JFrame{
	
	public MainView(String title) {
		super(title);
		initGame();
		init();
	}

	private void init() {
		JMenu jmenu = new JMenu("Game");
		
		JMenuItem jMenuItem0 = new JMenuItem("New Game");
		jMenuItem0.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				gameCenter.initNewGame();
			}			
		});
		jmenu.add(jMenuItem0);
		
		JMenuItem jMenuItem1 = new JMenuItem("Configuration");
		jMenuItem1.addActionListener(new ConfigurationItemListener());
		jmenu.add(jMenuItem1);

//		JMenuItem jMenuItem2 = new JMenuItem("Black");
//		jMenuItem2.addActionListener(new ConfigurationItemListener());
//		jmenu.add(jMenuItem2);


		JMenu jmenu2 = new JMenu("About");
		
		JMenuItem jMenuItem3 = new JMenuItem("Pathfinders");
		jMenuItem3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = "GROUP MEMBERS: \nH. Özge Bacak - e160021@metu.edu.tr\nHacer Çatal - e164175@metu.edu.tr\nYusuf Karagöl - e159582@metu.edu.tr";
				JOptionPane.showMessageDialog(MainView.this, str , "Pathfinders", JOptionPane.INFORMATION_MESSAGE);
			}			
		});
		jmenu2.add(jMenuItem3);
		
		JMenuBar jmenubar = new JMenuBar();
		jmenubar.add(jmenu);
		jmenubar.add(jmenu2);
		
		this.setJMenuBar(jmenubar);
	}


	private class ConfigurationItemListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent action) {
			ConfigurationPanel panel = new ConfigurationPanel(MainView.this);
			panel.setConfigurationModel(new ConfigurationModel());
			configurationFrame = new JFrame("Game Configuration");
			configurationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			configurationFrame.setContentPane(panel);
			configurationFrame.pack();
			configurationFrame.setResizable(false);
			configurationFrame.setVisible(true);
		}
	}
	
	private JFrame configurationFrame;

	private void initGame() {
		gameCenter = new GameCenter();
		try {
			Board board = new Board();
			gameCenter.setBoard(board);
			gameCenter.setCallback(this);
			this.add(board);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(-1);
		}
	}

	public static void main(String args[]){
		MainView mainView = new MainView("Pathfinders Checkers");
		mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainView.setResizable(false);
		mainView.setVisible(true);
		mainView.setSize(602,652);
	}
	
	private GameCenter gameCenter;

	public void configurationUpdated(ConfigurationModel newConfigurationModel) {
		gameCenter.configurationChanged(newConfigurationModel);
		if(configurationFrame != null)
			configurationFrame.dispose();
	}

	public void gameFinished(boolean amI) {
		String msg = amI ? "I win!" : "You Win!";
		JOptionPane.showMessageDialog(this, msg , "Game Finished!", JOptionPane.INFORMATION_MESSAGE);
	}
}
