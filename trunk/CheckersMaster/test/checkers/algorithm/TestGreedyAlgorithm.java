package checkers.algorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import checkers.domain.CalculationContext;
import checkers.domain.Model;
import checkers.domain.Move;
import checkers.domain.Player;
import checkers.evaluation.MenCountEvaluation;
import checkers.rules.Successors;
import checkers.sandbox.SquareState;

public class TestGreedyAlgorithm {

	private GreedyAlgorithm algorithm;
	private CalculationContext context;
	private Model model;
	private MenCountEvaluation evaluation;

	@Before
	public void setUp() throws Exception {
		algorithm = new GreedyAlgorithm();
		context = new CalculationContext();
		model = new Model();
		evaluation = new MenCountEvaluation();
	}

	@Test
	public void testAlgorithm(){
		context.setDepth(3);
		context.setEvaluationFunction(evaluation);
		
		Successors successors = new Successors();
		context.setSuccessorFunction(successors);
		context.setPlayer(Player.WHITE);
		model.bos();
		model.state[5][0] = SquareState.BLACK;
		model.state[3][0] = SquareState.WHITE;
		model.state[4][3] = SquareState.WHITE;
		
		Move selected = algorithm.algorithm(context, model, Player.WHITE);
	
		assertNotNull(selected);
		assertEquals(1, selected.getValue());
		
		assertEquals(3,selected.fromY);
		assertEquals(4,selected.fromX);
		assertEquals(5,selected.toX);
		assertTrue(4==selected.toY || 1 == selected.toY);
		
		assertEquals(4, selected.next.toX);
		assertEquals(1, selected.next.toY);
		assertEquals(5, selected.next.fromX);
		assertEquals(0, selected.next.fromY);
	}
}
