package checkers.algorithm;

import checkers.domain.CalculationContext;
import checkers.domain.Model;
import checkers.domain.Move;
import checkers.domain.Player;

public interface IAlgorithm {
	Move algorithm(CalculationContext context, Model model, Player whosTurn);
	
	String getName();
}
