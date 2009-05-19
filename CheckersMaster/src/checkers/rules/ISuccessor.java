package checkers.rules;

import java.util.List;

import checkers.domain.Move;
import checkers.domain.Player;
import checkers.sandbox.Model;

public interface ISuccessor {
	List<Move> getSuccessors(Model model, Player player);
}
