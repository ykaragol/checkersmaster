package checkers.rules;

import java.util.LinkedList;
import java.util.List;

import checkers.domain.Model;
import checkers.domain.Move;
import checkers.domain.Player;
import checkers.sandbox.SquareState;

public class Successors  implements ISuccessor{
	
	@Override
	public List<Move> getSuccessors(Model model, Player player) {
		LinkedList<Move> list = new LinkedList<Move>();
		//bir karedekini beyaz taþ kabul edip, çaprazlarýný kontrol edip hamle yaptýracaðýz. 
		// i alt satýr, j yan sütun
		SquareState[][] state = model.state;
		for (int i=0; i<state.length; i++){
			for (int j=0; j<state[i].length; j++){
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
		}
		handleList(list);
		return list;
	}

	private void handleList(LinkedList<Move> list) {
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
	}

	private void handleWhiteStone(LinkedList<Move> list, SquareState[][] state, int i, int j) {
		//basit bir taþ sadece ileriye gidebilir...
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
	

	private void handleBlackStone(LinkedList<Move> list, SquareState[][] state, int i, int j) {
		//basit bir taþ sadece ileriye gidebilir...
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
	
	//iki sol altýn deðerini getirir
	private SquareState twoLeftButtom(SquareState[][] state, int i, int j) {
		if(i-2>=0 &&  j-2 >= 0){
			return state[i-2][j-2];
		}
		return null;
	}

	//sol altýn deðerini getirir
	private SquareState leftButtom(SquareState[][] state, int i, int j) {
		if(i-1>=0 &&  j-1 >= 0){
			return state[i-1][j-1];
		}
		return null;
	}

	//iki sað altýn deðerini getirir
	private SquareState twoRightButtom(SquareState[][] state, int i, int j) {
		if( i-2 > 0 && j+2 < state[i].length){
			return state[i-2][j+2];
		}
		return null;
	}

	//sað altýn deðerini getirir
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


	//sol önünü deðerini getirir..
	private SquareState leftForward(SquareState[][] state, int i, int j) {
		if(j-1 >= 0){
			return state[i+1][j-1];
		}
		return null;
	}
	
	//sað önün deðerini getirir..
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
		return i+1 >= state.length;
	}
}

//
////bir karedekini beyaz taþ kabul edip, çaprazlarýný kontrol edip hamle yaptýracaðýz. 
//// i alt satýr, j yan sütun
//for (int i=1;i<=8;i++){
//	for (int j=1;j<=8;j++){
//		//eðer bulunduðun yerde bir beyaz varsa
//		if (m[i][j]==1) 
//		{
//			//eðer sað çaprazý da beyazsa deðiþiklik yapma
//			if (m[i+1][j+1]==1 && (i+1)<=8 && (j+1)<=8)
//			{
//				m[i][j]=1;
//			}
//			// eðer sað çaprazý siyahsa ve siyahýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri beyaz yap(1 yap)
//			else if (m[i+1][j+1]==2 && m[i+2][j+2]==0 && (i+2)<=8 && (j+2)<=8)
//			{
//				m[i][j]=0;
//				m[i+1][j+1]=0;
//				m[i+2][j+2]=1;
//			}
//			// eðer sað çaprazý king beyazsa deðiþiklik yapma
//
//			else if (m[i+1][j+1]==3 && (i+1)<=8 && (j+1)<=8)
//			{
//				m[i][j]=1;
//			}
//			// eðer sað çaprazý king siyahsa ve siyahýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri beyaz yap(1 yap)
//
//			else if(m[i+1][j+1]==4 && m[i+2][j+2]==0 && (i+2)<=8 && (j+2)<=8)
//			{
//				m[i][j]=0;
//				m[i+1][j+1]=0;
//				m[i+2][j+2]=1;
//			}
//			//eðer sol çaprazý beyazsa deðiþiklik yapma
//			else if (m[i-1][j+1]==1 && (j+1)<=8 && 1<=(i-1))
//			{
//				m[i][j]=1;
//			}
//			// eðer sol çaprazý siyahsa ve siyahýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri beyaz yap(1 yap)
//			else if (m[i-1][j+1]==2 && m[i-2][j+2]==0 && (j+2)<=8 && 1<=(i-2))
//			{
//				m[i][j]=0;
//				m[i-1][j+1]=0;
//				m[i-2][j+2]=1;
//			}
//			//eðer sol çaprazý da king beyazsa deðiþiklik yapma
//			else if (m[i-1][j+1]==3 && (j+1)<=8 && 1<=(i-1))
//			{
//				m[i][j]=1;
//			}
//			// eðer sol çaprazý king siyahsa ve siyahýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri beyaz yap(1 yap)
//
//			else if (m[i-1][j+1]==4 && m[i-2][j+2]==0 && (j+2)<=8 && 1<=(i-2))
//			{
//				m[i][j]=0;
//				m[i-1][j+1]=0;
//				m[i-2][j+2]=1;
//			}
//			
//		}
//		
//	}
//}
////eðer beyazlar 8. satýra ulaþmýþsa king beyaz olurlar
//for (i=1;i<=8;i++){
//	if m[i][8]=1;{
//		m[i][8]=3;
//	}
//}
//}
//
//// siyahlar farklý olarak matrisin son elemanlarýndan itibaren hareket etmeye baþlayacaklar
//for (int i=1;i<=8;i++){
//	for (int j=8;1<=j;j--){
//		// eðer bulunduðun karede siyah varsa
//		if m[i][j]==2{
//			//eðer sað çaprazý da siyahsa deðiþiklik yapma
//			if (m[i-1][j-1]==2 && 1<=(j-1)&& 1<=(i-1)){ 
//				m[i][j]=2;
//			}
//			// eðer sað çaprazý beyazsa ve beyazýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri siyah yap(2 yap)
//			else if (m[i-1][j-1]==1 && m[i-2][j-2]==0&& 1<=(j-2) && 1<=(i-2)){
//			m[i-2][j-2]=2;
//			m[i-1][j-1]=0;
//			m[i][j]=0;
//			}
//			// eðer sað çaprazý king siyahsa deðiþiklik yapma
//			else if (m[i-1][j-1]==4 && 1<=(j-1)&& 1<=(i-1)){
//				m[i][j]=2;
//			}
//			// eðer sað çaprazý king beyazsa ve beyazýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri siyah yap(2 yap)
//			else if (m[i-1][j-1]==3 && m[i-2][j-2]==0 && 1<=(j-2)&& 1<=(i-2)){
//				m[i-2][j-2]=2;
//				m[i-1][j-1]=0;
//				m[i][j]=0;
//			}
//			//eðer sol çaprazý da siyahsa deðiþiklik yapma
//			else if (m[i+1][j-1]==2 && 1<=(j-1)&& (i+1)<=8){
//				m[i][j]=2;
//			}
//			// eðer sol çaprazý beyazsa ve beyazýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri siyah yap(2 yap)
//			else if (m[i+1][j-1]==1 && m[i+2][j-2]==0 && 1<=(j-2)&& (i+2)<=8){
//				m[i+2][j-2]=2;
//				m[i+1][j-1]=0;
//				m[i][j]=0;
//			}
//			//eðer sol çaprazý da king siyahsa deðiþiklik yapma
//			else if (m[i+1][j-1]==4 & 1<=(j-1)&& (i+1)<=8){
//				m[i][j]=2;
//			}
//			// eðer sol çaprazý king beyazsa ve beyazýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri siyah yap(2 yap)
//			else if (m[i+1][j-1]==3 && m[i+2][j-2]==0 && 1<=(j-2)&& (i+2)<=8){
//				m[i+1][j-1]=0;
//				m[i+2][j-2]=2;
//				m[i][j]=0;
//		}
//	}
//}
//	//eðer siyahlarlar 1. satýra ulaþmýþsa king siyah olurlar
//   for (i=8;1<=i;i--){
//		if m[i][1]=2;{ 
//			m[i][1]=4;
//		}
//	}
//	
