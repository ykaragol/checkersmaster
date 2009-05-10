package checkers.evaluation;

import checkers.sandbox.Model;
import checkers.sandbox.SquareState;

public class WeightenedMenCountEvaluation {
	
	/*friendly*/ final static int MEN_WEIGHT = 1;
	/*friendly*/ final static int KING_WEIGHT = 3;

	public int evaluate(Model m, SquareState player) {
		int count = 0;
		SquareState[][] state = m.state;
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[i].length; j++) {
				SquareState currentSquare = state[i][j];
				if(currentSquare == null){
					String msg = String.format("Cell [%d,%d] is null", i,j);
					throw new IllegalStateException(msg);
				}
				switch (currentSquare) {
				case BLACK:
					count += MEN_WEIGHT;
					break;
				case KING_BLACK:
					count += KING_WEIGHT;
					break;
				case WHITE:
					count -= MEN_WEIGHT;
					break;
				case KING_WHITE:
					count -= KING_WEIGHT;
					break;
				default:
					break;
				}
			}
		}
		return count * (player==SquareState.BLACK ? 1:-1);
	}

}
