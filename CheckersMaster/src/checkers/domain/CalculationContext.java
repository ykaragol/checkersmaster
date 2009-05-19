package checkers.domain;

import checkers.evaluation.IEvaluation;
import checkers.rules.ISuccessor;


public class CalculationContext{

	private int depth;
	private Player player;//player'ýn context'te olmasý doðru olmayabilir...
	private IEvaluation evaluationFunction;
	private ISuccessor successorFunction;


	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}

	public void setEvaluationFunction(IEvaluation evaluation) {
		this.evaluationFunction = evaluation;
	}

	public IEvaluation getEvaluationFunction() {
		return evaluationFunction;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setSuccessorFunction(ISuccessor successor) {
		this.successorFunction = successor;
	}

	public ISuccessor getSuccessorFunction() {
		return successorFunction;
	}

}
