package checkers.evaluation;

import java.util.LinkedList;

import checkers.domain.Model;
import checkers.domain.Move;
import checkers.domain.Player;
import checkers.rules.Successors;
import checkers.sandbox.SquareState;

public class PlayableWeightenedMenCountEvaluation implements IEvaluation{
	
	/*friendly*/ final static int MEN_WEIGHT = 8;
	/*friendly*/ final static int KING_WEIGHT = 12;
	/*friendly*/ final static int WMEN_WEIGHT = 7;
	/*friendly*/ final static int WKING_WEIGHT = 11;

	private Successors s = new Successors(); 
	private LinkedList<Move> linkedList = new LinkedList<Move>();
	
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
				if(currentSquare == SquareState.BLANK){
					continue;
				}
				linkedList.clear();
				s.handleStone(linkedList, m, i, j);
				double c = 1;
				if(linkedList.size()==0){
					c=0.9;
				}				
				switch (currentSquare) {
				case BLACK:
					count += MEN_WEIGHT*c;
					break;
				case KING_BLACK:
					count += KING_WEIGHT*c;
					break;
				case WHITE:
					count -= WMEN_WEIGHT*c;
					break;
				case KING_WHITE:
					count -= WKING_WEIGHT*c;
					break;
				default:
					break;
				}
			}
		}
		return count * (player==Player.BLACK ? 1:-1);
	}

}
