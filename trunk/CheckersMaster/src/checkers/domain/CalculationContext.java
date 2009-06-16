package checkers.domain;

import checkers.algorithm.IAlgorithm;
import checkers.evaluation.IEvaluation;
import checkers.rules.ISuccessor;

/**
 * Tüm algoritmalar için yapılandırma parametreleri içerir.
 * 
 */
public class CalculationContext{

	private int depth;
	private Player player;
	private IEvaluation evaluationFunction;
	private ISuccessor successorFunction;
	private IAlgorithm algorithm;


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

	public void setAlgorithm(IAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	public IAlgorithm getAlgorithm() {
		return algorithm;
	}

}
