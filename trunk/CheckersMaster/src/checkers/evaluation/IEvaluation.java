package checkers.evaluation;

import checkers.domain.Model;
import checkers.domain.Player;

public interface IEvaluation {
	double evaluate(Model model, Player player);
}
