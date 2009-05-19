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

	public void doMove(Move move) {
		
	}

	public void undoMove(Move move) {
		// TODO Auto-generated method stub
		
	}
	
/*	
	public void move(Move m){
		state[m.toX][m.toY] = state[m.fromX][m.fromY];
		state[m.fromX][m.fromY] = SquareState.BLANK;
	}
*/
}
