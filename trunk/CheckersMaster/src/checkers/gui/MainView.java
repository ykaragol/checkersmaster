package checkers.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import checkers.controller.GameCenter;
import checkers.domain.Model;
import checkers.sandbox.Board;

@SuppressWarnings("serial")
public class MainView extends JFrame{
	
	public MainView(String title) {
		super(title);
		init();
	}
		
	private void init() {
		JMenu jmenu = new JMenu("Configuration");
		
		JMenuItem jMenuItem1 = new JMenuItem("White");
		jMenuItem1.addActionListener(new ConfigurationItemListener());
		jmenu.add(jMenuItem1);
		
		JMenuItem jMenuItem2 = new JMenuItem("Black");
		jMenuItem2.addActionListener(new ConfigurationItemListener());
		jmenu.add(jMenuItem2);
		
		JMenuBar jmenubar = new JMenuBar();
		jmenubar.add(jmenu);
		
		this.setJMenuBar(jmenubar);
	}


	private static class ConfigurationItemListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent action) {
			ConfigurationPanel panel = new ConfigurationPanel();
			panel.setConfigurationModel(new ConfigurationModel());
			JFrame frame = new JFrame("Game Configuration");
			frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
			frame.setContentPane( panel );
			frame.pack();
			frame.setResizable(false);
			frame.setVisible( true );
		}
	}
	

	public static void main(String args[]){
		MainView mainView = new MainView("Checkers");
		mainView.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//frame.setContentPane( panel );
		mainView.setResizable(false);
		mainView.setVisible(true);
		
		try {
			Board board = new Board();
			Model model = new Model();
			model.baslat();
			model.setCallback(new GameCenter());
			board.setModel(model);
			mainView.add(board);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		//mainView.pack();
		mainView.setSize(610,654);
	}
}
