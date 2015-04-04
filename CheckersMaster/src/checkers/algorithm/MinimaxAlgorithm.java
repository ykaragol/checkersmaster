package checkers.algorithm;

import java.util.List;

import checkers.domain.CalculationContext;
import checkers.domain.Model;
import checkers.domain.Move;
import checkers.domain.Player;
import checkers.evaluation.IEvaluation;
import checkers.rules.ISuccessor;

public class MinimaxAlgorithm implements IAlgorithm{

	@Override
	public Move algorithm(CalculationContext context, Model model, Player whosTurn) {
		if(context == null || model == null) {
			throw new IllegalArgumentException();
		}
		return minimax(context, model, whosTurn, 0);
	}

	Move minimax(CalculationContext context, Model model, Player whosTurn, int currentDepth) {
		if(context.getDepth()==currentDepth){
			Move move = new Move();
			move.setValue(evaluateModel(context, model));
			return move;
		}
		List<Move> successors = getSuccessors(context, model, whosTurn);
		if(successors.isEmpty()){
			Move move = new Move();
			int value = context.getPlayer() == whosTurn ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
			move.setValue(value);
			return move;
		}
		
		double value = 0;
		Move selectedMove = null;
		for (Move move : successors) {
			model.tryMove(move);
			
			Move minimax = minimax(context, model, whosTurn.opposite(), currentDepth+1);
			if(selectedMove == null 
				|| (context.getPlayer() == whosTurn && minimax.getValue()> value)
				|| (context.getPlayer() != whosTurn && minimax.getValue()< value)){
				value = minimax.getValue();
				move.next = minimax;
				selectedMove = move;
			}
			
			model.undoTryMove(move);
		}
		selectedMove.setValue(value);
		return selectedMove;
	}

	private double evaluateModel(CalculationContext context, Model model) {
		IEvaluation evaluationFunction = context.getEvaluationFunction();
		return evaluationFunction.evaluate(model,context.getPlayer());
	}
	
	private List<Move> getSuccessors(CalculationContext context, Model model, Player whosTurn) {
		ISuccessor successor = context.getSuccessorFunction();
		List<Move> successors = successor.getSuccessors(model, whosTurn);
		return successors;
	}

	@Override
	public String getName() {
		return "Min-Max Algorithm";
	}

}
