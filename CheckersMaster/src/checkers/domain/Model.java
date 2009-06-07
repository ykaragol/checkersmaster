package checkers.domain;

import checkers.algorithm.MinimaxAlgorithm;
import checkers.evaluation.IEvaluation;
import checkers.evaluation.WeightenedMenCountEvaluation;
import checkers.rules.Successors;
import checkers.sandbox.Board;
import checkers.sandbox.SquareState;

/**
 * 
 * @author hacer
 */
public class Model {
	
	public SquareState state[][];
	private Board callBack;
	private CalculationContext context;
	private MinimaxAlgorithm algorithm = new MinimaxAlgorithm();

	public void baslat(){
		SquareState ilk[][] = {
				{SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK},
				{SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE},
				{SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK},
				{SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK},
				{SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK},
				{SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK},
				{SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK},
				{SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK},
		};
		state = ilk;
		context = new CalculationContext();
		IEvaluation evaluation = new WeightenedMenCountEvaluation();
		context.setEvaluationFunction(evaluation);
		context.setDepth(2);
		context.setPlayer(Player.WHITE);
		context.setSuccessorFunction(new Successors());
	}

	public void bos(){
		SquareState[][] bos = new SquareState[8][8];
		for (int i = 0; i < bos.length; i++) {
			for (int j = 0; j < bos[i].length; j++) {
				bos[i][j] = SquareState.BLANK;
			}
		}
		state = bos;
	}
	
	public void tryMove(Move move) {
		state[move.toX][move.toY]=state[move.fromX][move.fromY];
		state[move.fromX][move.fromY] = SquareState.BLANK;
		if(move.must){
			move.eat = state[(move.toX+move.fromX)/2][(move.toY+move.fromY)/2];
			state[(move.toX+move.fromX)/2][(move.toY+move.fromY)/2] = SquareState.BLANK;
		}
	}

	public void doMove(Move move) {
		state[move.toX][move.toY]=state[move.fromX][move.fromY];
		state[move.fromX][move.fromY] = SquareState.BLANK;
		if(Math.abs(move.toX-move.toY)>1){
			move.eat = state[(move.toX+move.fromX)/2][(move.toY+move.fromY)/2];
			state[(move.toX+move.fromX)/2][(move.toY+move.fromY)/2] = SquareState.BLANK;
		}
		callBack.updateUI();
		Move minimax = algorithm.minimax(context, this, Player.BLACK);
		tryMove(minimax);
		callBack.updateUI();
	}
	
	
	public void undoTryMove(Move move) {
		state[move.fromX][move.fromY]=state[move.toX][move.toY];
		state[move.toX][move.toY] = SquareState.BLANK;
		if(move.eat != null){
			state[(move.toX+move.fromX)/2][(move.toY+move.fromY)/2] = move.eat;
		}
	}
	
	public void setCallback(Board callBack){
		this.callBack = callBack;
	}
	
/*	
	public void move(Move m){
		state[m.toX][m.toY] = state[m.fromX][m.fromY];
		state[m.fromX][m.fromY] = SquareState.BLANK;
	}
*/
}
