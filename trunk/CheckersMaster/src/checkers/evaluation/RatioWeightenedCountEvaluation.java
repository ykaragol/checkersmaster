package checkers.evaluation;


import checkers.domain.Model;
import checkers.domain.Player;
import checkers.sandbox.SquareState;

public class RatioWeightenedCountEvaluation implements IEvaluation{
	
	/*friendly*/ final static int MEN_WEIGHT = 1;
	/*friendly*/ final static int KING_WEIGHT = 3;

	@Override
	public double evaluate(Model m, Player player) {
		int whiteCount = 0;
		int blackCount = 0;
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
					whiteCount += MEN_WEIGHT;
					break;
				case KING_BLACK:
					whiteCount += KING_WEIGHT;
					break;
				case WHITE:
					blackCount += MEN_WEIGHT;
					break;
				case KING_WHITE:
					blackCount += KING_WEIGHT;
					break;
				default:
					break;
				}
			}
		}
		
		if (player==Player.BLACK){
			if(whiteCount==0)
				return Integer.MAX_VALUE;
			else if(blackCount == 0)
				return Integer.MIN_VALUE;
			return blackCount/whiteCount;
		}else{
			if(blackCount==0)
				return Integer.MAX_VALUE;
			else if(whiteCount == 0)
				return Integer.MIN_VALUE;
			return whiteCount/blackCount;
		}		
	}
}