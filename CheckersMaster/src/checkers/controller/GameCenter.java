package checkers.controller;

import java.util.List;

import checkers.algorithm.MinimaxAlgorithm;
import checkers.domain.CalculationContext;
import checkers.domain.Model;
import checkers.domain.Move;
import checkers.domain.Player;
import checkers.evaluation.EnhancedWeightenedMenCountEvaluation;
import checkers.gui.ConfigurationModel;
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

//	/**
//	 * Tahtada yapılan değişiklikleri dinleyecek sınıflar
//	 */
//	private List<ModelListener> listeners = new LinkedList<ModelListener>();

	private Engine blackPlayer;
	
	//private Engine whitePlayer;

	private Board board;

	private boolean lock=true;
	
//	public void center(){
//		while(true){
//			//whitePlayer.playTurn(model);
//			while(lock){
//				try {
//					Thread.sleep(50);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			blackPlayer.playTurn(model);
//		}
//	}
	
	public void update(){
//		if(gameFinished)
//			return;
		lock=!lock;
		if(!lock){
			List<Move> listBlack = successors.getSuccessors(model, Player.BLACK);
			if(listBlack==null || listBlack.size()==0){
				System.err.println("yenildim!");
				gameFinished = true;
			}
			blackPlayer.playTurn(model);
			List<Move> listWhite = successors.getSuccessors(model, Player.WHITE);
			if(listWhite==null || listWhite.size()==0){
				System.err.println("yendim!");
				gameFinished = true;
			}
		}
		board.updateUI();
	}
	private boolean gameFinished = false;

	private Successors successors;
	
//	public void run() throws IOException{
//		model = new Model();
//		b = Board.init(model);
//		model.setCallback(this);
//		model.baslat();
//		blackPlayer = new Engine(Player.BLACK);
//		CalculationContext calculationContext = new CalculationContext();
//		calculationContext.setAlgorithm(new MinimaxAlgorithm());
//		calculationContext.setDepth(6);
//		calculationContext.setEvaluationFunction(new EnhancedWeightenedMenCountEvaluation());
//		calculationContext.setPlayer(Player.BLACK);
//		calculationContext.setSuccessorFunction(new Successors());
//		blackPlayer.setCalculationContext(calculationContext);
//		//center();
//	}
	
	public GameCenter(){
		model = new Model();
		model.baslat();
		model.setCallback(this);
		
		blackPlayer = new Engine(Player.BLACK);
		CalculationContext calculationContext = new CalculationContext();
		calculationContext.setAlgorithm(new MinimaxAlgorithm());
		calculationContext.setDepth(6);
		calculationContext.setEvaluationFunction(new EnhancedWeightenedMenCountEvaluation());
		calculationContext.setPlayer(Player.BLACK);
		successors = new Successors();
		calculationContext.setSuccessorFunction(successors);
		blackPlayer.setCalculationContext(calculationContext);
	}
	
	public void configurationChanged(ConfigurationModel newConfigurationModel){
		CalculationContext calculationContext = new CalculationContext();
		calculationContext.setAlgorithm(newConfigurationModel.getSelectedAlgorithm());
		calculationContext.setDepth(newConfigurationModel.getSelectedDepth());
		calculationContext.setEvaluationFunction(newConfigurationModel.getSelectedEvaluation());
		calculationContext.setPlayer(Player.BLACK);
		calculationContext.setSuccessorFunction(successors);
		blackPlayer.setCalculationContext(calculationContext);
	}

	public Model getModel() {
		return model;
	}

	public void setBoard(Board board) {
		this.board = board;
		board.setModel(model);
	}
}
