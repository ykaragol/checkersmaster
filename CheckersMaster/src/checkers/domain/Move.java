package checkers.domain;

import checkers.sandbox.SquareState;

public class Move {
	private double value = Double.NEGATIVE_INFINITY;
	public int fromX;
	public int fromY;
	public int toX;
	public int toY;
	public boolean must = false;
	public SquareState eat;
	public Move next;
	public boolean convert;
	public Move nextMustMove;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
