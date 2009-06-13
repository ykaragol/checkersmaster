package checkers.domain;

import checkers.sandbox.SquareState;

public class Move {
	private int value = Integer.MIN_VALUE;
	public int fromX;
	public int fromY;
	public int toX;
	public int toY;
	public boolean must = false;
	public SquareState eat;
	public Move next;
	public boolean convert;
	public Move nextMustMove;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
