package checkers.sandbox;

import checkers.domain.Player;

/**
 * 
 * @author yusuf
 *
 */
public enum SquareState{
	BLANK (null),
	WHITE (Player.WHITE),
	BLACK (Player.BLACK),
	KING_WHITE (Player.WHITE),
	KING_BLACK (Player.BLACK);
	
	public final Player owner;
	
	private SquareState(Player owner){
		this.owner = owner;
	}

	public SquareState convertKing() {
		if(this==WHITE || this==BLACK)
			return values()[this.ordinal()+2];
		return this;
	}

	public SquareState convertNormal() {
		if(this==KING_WHITE || this==KING_BLACK)
			return values()[this.ordinal()-2];
		return this;
	}
	
	public boolean isKing(){
		return (this==KING_BLACK || this==KING_WHITE);
	}
}
	// 0 means blank
	// 1 means white
	// 2 means black
	// 3 means king white
	// 4 means king black

