package checkers.sandbox;

import checkers.domain.Move;

/**
 * 
 * @author hacer
 */
public class Model {
	
	public SquareState state[][];

	public void baslat(){
		SquareState ilk[][] = {
				{SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE},
				{SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK},
				{SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE,SquareState.BLANK,SquareState.WHITE},
				{SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK},
				{SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK,SquareState.BLANK},
				{SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK},
				{SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK},
				{SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK,SquareState.BLACK,SquareState.BLANK},
		};
		state = ilk;
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
	
	public void doMove(Move move) {
		state[move.toX][move.toY]=state[move.fromX][move.fromY];
		state[move.fromX][move.fromY] = SquareState.BLANK;
		if(move.must){
			move.eat = state[(move.toX+move.fromX)/2][(move.toY+move.fromY)/2];
			state[(move.toX+move.fromX)/2][(move.toY+move.fromY)/2] = SquareState.BLANK;
		}
	}

	public void undoMove(Move move) {
		state[move.fromX][move.fromY]=state[move.toX][move.toY];
		state[move.toX][move.toY] = SquareState.BLANK;
		if(move.eat != null){
			state[(move.toX+move.fromX)/2][(move.toY+move.fromY)/2] = move.eat;
		}
	}
	
/*	
	public void move(Move m){
		state[m.toX][m.toY] = state[m.fromX][m.fromY];
		state[m.fromX][m.fromY] = SquareState.BLANK;
	}
*/
}
