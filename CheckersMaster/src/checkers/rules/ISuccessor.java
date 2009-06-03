package checkers.rules;

import java.util.List;

import checkers.domain.Model;
import checkers.domain.Move;
import checkers.domain.Player;

public interface ISuccessor {
	List<Move> getSuccessors(Model model, Player player);
}
