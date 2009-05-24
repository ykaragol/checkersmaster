package checkers.algorithm;

import java.util.List;

import checkers.domain.CalculationContext;
import checkers.domain.Move;
import checkers.domain.Player;
import checkers.evaluation.IEvaluation;
import checkers.rules.ISuccessor;
import checkers.sandbox.Model;

public class MinimaxAlgorithm {

	public Move minimax(CalculationContext context, Model model, Player whosTurn) {
		if(context == null || model == null) {
			throw new IllegalArgumentException();
		}
		if(context.getDepth()==0){
			Move move = new Move();
			move.setValue(evaluateModel(context, model));
			return move;
		}
		context.setDepth(context.getDepth()-1);
		List<Move> successors = getSuccessors(context, model, whosTurn);
		boolean isAssigned = false;
		int value = 0;
		Move selectedMove = null;
		for (Move move : successors) {
			model.doMove(move);
			Move minimax = minimax(context, model, whosTurn.opposite());
			if(!isAssigned){
				isAssigned = true;
				value = minimax.getValue();
				move.next = minimax;
				selectedMove = move;
			}else{
				if(context.getPlayer() == whosTurn){
					if(minimax.getValue()> value){
						selectedMove = move;
						move.next = minimax;
						value = minimax.getValue();
					}
				}else{
					if(minimax.getValue()< value){
						selectedMove = move;
						move.next = minimax;
						value = minimax.getValue();
					}
				}
			}
			model.undoMove(move);
		}
		selectedMove.setValue(value);
		return selectedMove;
	}

	private int evaluateModel(CalculationContext context, Model model) {
		IEvaluation evaluationFunction = context.getEvaluationFunction();
		return (int) evaluationFunction.evaluate(model,context.getPlayer());
		// TODO:geri dönecek olan sayý tipi int deðil double olacak.
	}
	
	private List<Move> getSuccessors(CalculationContext context, Model model, Player whosTurn) {
		ISuccessor successor = context.getSuccessorFunction();
		List<Move> successors = successor.getSuccessors(model, whosTurn);
		return successors;
	}

}
