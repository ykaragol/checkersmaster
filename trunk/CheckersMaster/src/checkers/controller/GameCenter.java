package checkers.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import checkers.algorithm.MinimaxAlgorithm;
import checkers.domain.CalculationContext;
import checkers.domain.Model;
import checkers.domain.Player;
import checkers.evaluation.MenCountEvaluation;
import checkers.rules.Successors;
import checkers.sandbox.Board;

/**
 * Oyuna ait tüm bilgileri tutan kesim. 
 * 
 * @author yusuf
 *
 */
public class GameCenter {
	
	/**
	 * Oyunun tahtası
	 */
	private Model model;

	/**
	 * Tahtada yapılan değişiklikleri dinleyecek sınıflar
	 */
	private List<ModelListener> listeners = new LinkedList<ModelListener>();

	private Engine blackPlayer;
	
	private Engine whitePlayer;

	private Board b;

	private boolean lock=true;
	
	public void center(){
		while(true){
			//whitePlayer.playTurn(model);
			while(lock){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			blackPlayer.playTurn(model);
		}
	}
	
	public void update(){
		lock=!lock;
		if(!lock)
			blackPlayer.playTurn(model);
		b.updateUI();
	}
	
	public void run() throws IOException{
		model = new Model();
		b = Board.init(model);
		model.setCallback(this);
		model.baslat();
		blackPlayer = new Engine(Player.BLACK);
		CalculationContext calculationContext = new CalculationContext();
		calculationContext.setAlgorithm(new MinimaxAlgorithm());
		calculationContext.setDepth(3);
		calculationContext.setEvaluationFunction(new MenCountEvaluation());
		calculationContext.setPlayer(Player.BLACK);
		calculationContext.setSuccessorFunction(new Successors());
		blackPlayer.setCalculationContext(calculationContext);
		//center();
	}
	
	public static void main(String args[]) throws IOException{
		GameCenter g = new GameCenter();
		g.run();
	}
}