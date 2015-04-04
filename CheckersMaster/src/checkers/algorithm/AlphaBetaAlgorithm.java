package checkers.algorithm;

import java.util.List;

import checkers.domain.CalculationContext;
import checkers.domain.Model;
import checkers.domain.Move;
import checkers.domain.Player;
import checkers.evaluation.IEvaluation;
import checkers.rules.ISuccessor;

/**
 * Alpha-Beta Pruning Algorithm Implementation
 */ 
public class AlphaBetaAlgorithm implements IAlgorithm{

	public Move algorithm(CalculationContext context, Model model, Player whosTurn) {
		if(context == null || model == null) {
			throw new IllegalArgumentException();
		}
		//set initial values to start recursion:
		return alphaBeta(context, model, whosTurn, 0, 0, 0, false, false);
	}

	Move alphaBeta(CalculationContext context, Model model, Player whosTurn, int currentDepth, 
				double prunMin, double prunMax, boolean isPrunMinUsed, boolean isPrunMaxUsed) {
		
		//check if reached target-depth
		if(context.getDepth()==currentDepth){
			Move move = new Move();
			move.setValue(evaluateModel(context, model));
			return move;
		}
		
		//get all possible moves:
		List<Move> successors = getSuccessors(context, model, whosTurn);
		//if there is no possible move, set min or max value
		if(successors.isEmpty()){
			Move move = new Move();
			move.setValue(evaluateModel(context, model));
			return move;
		}
		
		
		double selectedValue = 0;
		Move selectedMove = null;
		for (Move move : successors) {
			model.tryMove(move);// make move
			
			//to calculate pruning values:
			if(selectedMove!=null){
				if(context.getPlayer() == whosTurn){
					if(isPrunMinUsed){
						prunMin = prunMin > selectedValue ? selectedValue : prunMin;
					}else{
						prunMin = selectedValue;
						isPrunMinUsed = true;
					}
				}else{
					if(isPrunMaxUsed){
						prunMax = prunMax < selectedValue ? selectedValue : prunMax;
					}else{
						prunMax = selectedValue;
						isPrunMaxUsed = true;
					}
				}
			}
			
			//recursion:
			Move minimax = alphaBeta(context, model, whosTurn.opposite(), currentDepth+1, prunMin, prunMax, isPrunMinUsed, isPrunMaxUsed);
			if(selectedMove==null                                                               //to set initial move
					|| (context.getPlayer() == whosTurn && minimax.getValue()> selectedValue)   //max value is desired for computer
					|| (context.getPlayer() != whosTurn && minimax.getValue()< selectedValue)){ //min value is desired for opponent
				
				selectedValue = minimax.getValue();
				move.next = minimax;
				selectedMove = move;
			}
			
			model.undoTryMove(move); // remove move back
			
			//to make pruning:
			if(context.getPlayer() == whosTurn && isPrunMinUsed){
				if(prunMin >= selectedValue){
					selectedMove.setValue(selectedValue);
					return selectedMove;
				}
			}
			if(context.getPlayer() != whosTurn && isPrunMaxUsed){
				if(prunMax <= selectedValue){
					selectedMove.setValue(selectedValue);
					return selectedMove;
				}
			}
		}
		selectedMove.setValue(selectedValue);
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
		return "Alpha Beta Algorithm";
	}

}
