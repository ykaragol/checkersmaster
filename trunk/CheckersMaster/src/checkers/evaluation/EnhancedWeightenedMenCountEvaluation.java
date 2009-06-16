package checkers.evaluation;

import checkers.domain.Model;
import checkers.domain.Player;
import checkers.sandbox.SquareState;

public class EnhancedWeightenedMenCountEvaluation implements IEvaluation{
	
	/*friendly*/ final static int MEN_WEIGHT = 8;
	/*friendly*/ final static int KING_WEIGHT = 12;
	/*friendly*/ final static int WMEN_WEIGHT = 7;
	/*friendly*/ final static int WKING_WEIGHT = 11;

	@Override
	public double evaluate(Model m, Player player) {
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
					count -= WMEN_WEIGHT;
					break;
				case KING_WHITE:
					count -= WKING_WEIGHT;
					break;
				default:
					break;
				}
			}
		}
		return count * (player==Player.BLACK ? 1:-1);
	}

}
