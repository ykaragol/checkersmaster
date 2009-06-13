package checkers.rules;

import java.util.LinkedList;
import java.util.List;

import checkers.domain.Model;
import checkers.domain.Move;
import checkers.domain.Player;
import checkers.sandbox.SquareState;

public class CopyOfSuccessors  implements ISuccessor{
	
	@Override
	public List<Move> getSuccessors(Model model, Player player) {
		LinkedList<Move> list = new LinkedList<Move>();
		//bir karedekini beyaz taş kabul edip, çaprazlarını kontrol edip hamle yaptıracağız. 
		// i alt satır, j yan sütun
		SquareState[][] state = model.state;
		for (int i=0; i<state.length; i++){
			for (int j=0; j<state[i].length; j++){
				canMoveThisStone(player, list, state, i, j);
			}
		}
		
		handleMust(model, player, list);
		
		return list;
	}

	private boolean handleMust(Model model, Player player, LinkedList<Move> list) {
		boolean hasMust = handleList(list);
		if(hasMust){
			for (Move move : list) {
				model.tryMove(move);
				LinkedList<Move> newList = new LinkedList<Move>();
				canMoveThisStone(player, newList, model.state, move.toX, move.toY);
				if(handleMust(model, player, newList)){
					move.nextMustMove = newList.get(0);
				}
				model.undoTryMove(move);
			}
		}
		return hasMust;
	}
	
	private void canMoveThisStone(Player player, LinkedList<Move> list,
			SquareState[][] state, int i, int j) {
		SquareState square = state[i][j];
		switch (square) {
		case BLACK:
			if(player==Player.BLACK)
				handleBlackStone(list, state, i, j);
			break;
		case KING_BLACK:
			if(player==Player.BLACK)
				handleWhiteKingStone(list, state, i, j);
			break;
		case WHITE:
			if(player==Player.WHITE)
				handleWhiteStone(list, state, i, j);
			break;
		case KING_WHITE:
			if(player==Player.WHITE)
				handleWhiteKingStone(list, state, i, j);
			break;
		default:
			break;
		}
	}

	private boolean handleList(LinkedList<Move> list) {
		boolean hasMust = false;
		for (Move move : list) {
			if(move.must){
				hasMust = true;
				break;
			}
		}
		if(hasMust){
			LinkedList<Move> linkedList = new LinkedList<Move>(list);
			for (Move move : linkedList) {
				if(!move.must){
					list.remove(move);
				}
			}
		}
		return hasMust;
	}

	private void handleWhiteStone(LinkedList<Move> list, SquareState[][] state, int i, int j) {
		//basit bir ta� sadece ileriye gidebilir...
		if(forwardCheck(state, i)){
			throw new IllegalStateException();
		}
		SquareState currentSquare = state[i][j];
		SquareState rightForward = rightForward(state,i,j);
		if(rightForward != null){
			if(rightForward.owner == null){
				//gidebilir:
				Move move = new Move();
				move.fromX=i;
				move.fromY=j;
				move.toX = i+1;
				move.toY = j+1;
				list.add(move);
			}else if(rightForward.owner == currentSquare.owner){
				//gidemez
			}else {
				//yerse gidebilir...
				SquareState twoRightForward = twoRightForward(state,i,j);
				if(twoRightForward == SquareState.BLANK){
					Move move = new Move();
					move.fromX=i;
					move.fromY=j;
					move.toX = i+2;
					move.toY = j+2;
					list.add(move);
					move.must = true;
				}
			}
		}
		SquareState leftForward = leftForward(state,i,j);
		if(leftForward != null){
			if(leftForward.owner == null){
				//gidebilir:
				Move move = new Move();
				move.fromX=i;
				move.fromY=j;
				move.toX = i+1;
				move.toY = j-1;
				list.add(move);
			}else if(leftForward.owner == currentSquare.owner){
				//gidemez
			}else {
				//yerse gidebilir...
				SquareState twoLeftForward = twoLeftForward(state,i,j);
				if(twoLeftForward == SquareState.BLANK){
					Move move = new Move();
					move.fromX=i;
					move.fromY=j;
					move.toX = i+2;
					move.toY = j-2;
					list.add(move);
					move.must = true;
				}
			}
		}
	}

	private void handleWhiteKingStone(LinkedList<Move> list, SquareState[][] state, int i, int j) {
		SquareState currentSquare = state[i][j];
		if(!forwardCheck(state, i)){
			SquareState rightForward = rightForward(state,i,j);
			if(rightForward != null){
				if(rightForward.owner == null){
					//gidebilir:
					Move move = new Move();
					move.fromX=i;
					move.fromY=j;
					move.toX = i+1;
					move.toY = j+1;
					list.add(move);
				}else if(rightForward.owner == currentSquare.owner){
					//gidemez
				}else {
					//yerse gidebilir...
					SquareState twoRightForward = twoRightForward(state,i,j);
					if(twoRightForward == SquareState.BLANK){
						Move move = new Move();
						move.fromX=i;
						move.fromY=j;
						move.toX = i+2;
						move.toY = j+2;
						list.add(move);
						move.must = true;
					}
				}
			}
			SquareState leftForward = leftForward(state,i,j);
			if(leftForward != null){
				if(leftForward.owner == null){
					//gidebilir:
					Move move = new Move();
					move.fromX=i;
					move.fromY=j;
					move.toX = i+1;
					move.toY = j-1;
					list.add(move);
				}else if(leftForward.owner == currentSquare.owner){
					//gidemez
				}else {
					//yerse gidebilir...
					SquareState twoLeftForward = twoLeftForward(state,i,j);
					if(twoLeftForward == SquareState.BLANK){
						Move move = new Move();
						move.fromX=i;
						move.fromY=j;
						move.toX = i+2;
						move.toY = j-2;
						list.add(move);
						move.must = true;
					}
				}
			}
		}
		if(!buttomCheck(state, i)){
			SquareState rightButtom = rightButtom(state,i,j);
			if(rightButtom != null){
				if(rightButtom.owner == null){
					//gidebilir:
					Move move = new Move();
					move.fromX=i;
					move.fromY=j;
					move.toX = i-1;
					move.toY = j+1;
					list.add(move);
				}else if(rightButtom.owner == currentSquare.owner){
					//gidemez
				}else {
					//yerse gidebilir...
					SquareState twoRightButtom = twoRightButtom(state,i,j);
					if(twoRightButtom == SquareState.BLANK){
						Move move = new Move();
						move.fromX=i;
						move.fromY=j;
						move.toX = i-2;
						move.toY = j+2;
						list.add(move);
						move.must = true;
					}
				}
			}
			SquareState leftButtom = leftButtom(state,i,j);
			if(leftButtom != null){
				if(leftButtom.owner == null){
					//gidebilir:
					Move move = new Move();
					move.fromX=i;
					move.fromY=j;
					move.toX = i-1;
					move.toY = j-1;
					list.add(move);
				}else if(leftButtom.owner == currentSquare.owner){
					//gidemez
				}else {
					//yerse gidebilir...
					SquareState twoLeftButtom = twoLeftButtom(state,i,j);
					if(twoLeftButtom == SquareState.BLANK){
						Move move = new Move();
						move.fromX=i;
						move.fromY=j;
						move.toX = i-2;
						move.toY = j-2;
						list.add(move);
						move.must = true;
					}
				}
			}
		}
	}
	

	private void handleBlackStone(LinkedList<Move> list, SquareState[][] state, int i, int j) {
		//basit bir taş sadece ileriye gidebilir...
		if(buttomCheck(state, i)){
			throw new IllegalStateException();
		}
		SquareState currentSquare = state[i][j];
		SquareState rightButtom = rightButtom(state,i,j);
		if(rightButtom != null){
			if(rightButtom.owner == null){
				//gidebilir:
				Move move = new Move();
				move.fromX=i;
				move.fromY=j;
				move.toX = i-1;
				move.toY = j+1;
				list.add(move);
			}else if(rightButtom.owner == currentSquare.owner){
				//gidemez
			}else {
				//yerse gidebilir...
				SquareState twoRightButtom = twoRightButtom(state,i,j);
				if(twoRightButtom == SquareState.BLANK){
					Move move = new Move();
					move.fromX=i;
					move.fromY=j;
					move.toX = i-2;
					move.toY = j+2;
					list.add(move);
					move.must = true;
				}
			}
		}
		SquareState leftButtom = leftButtom(state,i,j);
		if(leftButtom != null){
			if(leftButtom.owner == null){
				//gidebilir:
				Move move = new Move();
				move.fromX=i;
				move.fromY=j;
				move.toX = i-1;
				move.toY = j-1;
				list.add(move);
			}else if(leftButtom.owner == currentSquare.owner){
				//gidemez
			}else {
				//yerse gidebilir...
				SquareState twoLeftButtom = twoLeftButtom(state,i,j);
				if(twoLeftButtom == SquareState.BLANK){
					Move move = new Move();
					move.fromX=i;
					move.fromY=j;
					move.toX = i-2;
					move.toY = j-2;
					list.add(move);
					move.must = true;
				}
			}
		}
	}
	
	//iki sol altın değerini getirir
	private SquareState twoLeftButtom(SquareState[][] state, int i, int j) {
		if(i-2>=0 &&  j-2 >= 0){
			return state[i-2][j-2];
		}
		return null;
	}

	//sol altın değerini getirir
	private SquareState leftButtom(SquareState[][] state, int i, int j) {
		if(i-1>=0 &&  j-1 >= 0){
			return state[i-1][j-1];
		}
		return null;
	}

	//iki sağ altın değerini getirir
	private SquareState twoRightButtom(SquareState[][] state, int i, int j) {
		if( i-2 > 0 && j+2 < state[i].length){
			return state[i-2][j+2];
		}
		return null;
	}

	//sağ altın değerini getirir
	private SquareState rightButtom(SquareState[][] state, int i, int j) {
		if(i-1>=0 &&  j+1 < state[i].length){
			return state[i-1][j+1];
		}
		return null;
	}

	private SquareState twoRightForward(SquareState[][] state, int i, int j) {
		if( i+3 < state.length && j+2 < state[i].length){
			return state[i+2][j+2];
		}
		return null;
	}
	
	private SquareState twoLeftForward(SquareState[][] state, int i, int j) {
		if( i+3 < state.length && j-2 >= 0){
			return state[i+2][j-2];
		}
		return null;
	}


	//sol önün değerini getirir..
	private SquareState leftForward(SquareState[][] state, int i, int j) {
		if(j-1 >= 0){
			return state[i+1][j-1];
		}
		return null;
	}
	
	//sağ önün değerini getirir..
	private SquareState rightForward(SquareState[][] state, int i, int j) {
		if(j+1 < state[i].length){
			return state[i+1][j+1];
		}
		return null;
	}

	//ileriye gidebilir mi?
	private boolean forwardCheck(SquareState[][] state, int i) {
		return i+1 >= state.length;
	}
	
	//ileriye gidebilir mi?
	private boolean buttomCheck(SquareState[][] state, int i) {
		return i-1 < 0;
	}
}
