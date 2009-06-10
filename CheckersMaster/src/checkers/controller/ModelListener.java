package checkers.controller;

import checkers.domain.Model;

public interface ModelListener {

	void modelUpdated(Model model, Engine updater);
}
