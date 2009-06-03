package checkers.evaluation;

import checkers.domain.Model;
import checkers.domain.Player;
import checkers.sandbox.SquareState;

/**
 * Max men count in play
 * @author hacer_catal
 *
 */
public class MenCountEvaluation implements IEvaluation{
	
	//TODO : bir tarafýn hiç oynayabilecek elemaný kalmadýysa, oyun bittiyse vs. geriye int_min falan dön..
	@Override
	public double evaluate(Model m, Player player){
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
						count ++;
						break;
					case KING_BLACK:
						count ++;
						break;
					case WHITE:
						count --;
						break;
					case KING_WHITE:
						count --;
						break;
					default:
						break;
				}
			}
		}
		return count * (player==Player.BLACK ? 1:-1);
	}		
}
