package checkers.evaluation;

import checkers.domain.Player;
import checkers.sandbox.Model;

public interface IEvaluation {
	double evaluate(Model model, Player player);
}
