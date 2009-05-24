package checkers.sandbox;

import checkers.domain.Player;

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
}
	// 0 means blank
	// 1 means white
	// 2 means black
	// 3 means king white
	// 4 means king black

