package checkers.algorithm;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import checkers.domain.CalculationContext;
import checkers.domain.Model;
import checkers.domain.Move;
import checkers.domain.Player;
import checkers.evaluation.MenCountEvaluation;
import checkers.rules.Successors;
import checkers.sandbox.SquareState;

public class TestAlphaBetaAlgorithm {

	private AlphaBetaAlgorithm algorithm;
	private CalculationContext context;
	private Model model;
	private MenCountEvaluation evaluation;

	@Before
	public void setUp() throws Exception {
		algorithm = new AlphaBetaAlgorithm();
		context = new CalculationContext();
		model = new Model();
		evaluation = new MenCountEvaluation();
	}

	@Test
	public void testAlgorithm(){
		try{
			algorithm.algorithm(context, null, Player.WHITE);
			fail("Hata �retmeliydi...");
		}catch(IllegalArgumentException exc){
			
		}catch (Throwable e) {
			fail("Hata gelmemeliydi..." + e.getClass());
		}
	}
	
	@Test
	public void testAlgorithm2(){
		context.setDepth(0);
		context.setEvaluationFunction(evaluation);
		model.baslat();
		Move minimax = algorithm.algorithm(context, model, Player.WHITE);
		assertNotNull(minimax);
	}

	@Test
	public void testAlgorithm3(){
		context.setDepth(0);
		EvaluationMock mock = new EvaluationMock();
		mock.callCount = 5;
		mock.retVal = 23;
		context.setEvaluationFunction(mock);
		model.baslat();
		Move minimax = algorithm.algorithm(context, model, Player.WHITE);
		assertNotNull(minimax);
		assertEquals(23, minimax.getValue());
		
		assertEquals(6,mock.callCount);
	}
	
	
	@Test
	public void testAlgorithm4(){
		context.setDepth(1);
		EvaluationMock mock = new EvaluationMock();
		mock.callCount = 5;
		mock.retVal = 23;
		context.setEvaluationFunction(mock);
		
		MockSuccessor smock = new MockSuccessor();
		smock.value = 45;
		context.setSuccessorFunction(smock);
		model.baslat();
		Move minimax = algorithm.algorithm(context, model, Player.WHITE);
		assertNotNull(minimax);
		assertEquals(23, minimax.getValue());
		
		assertEquals(6,mock.callCount);
	}
	
	@Test
	public void testAlgorithm5(){
		context.setDepth(1);
		EvaluationMock mock = new EvaluationMock();
		mock.callCount = 5;
		mock.retVal = 23;
		context.setEvaluationFunction(mock);
		
		MockSuccessor smock = new MockSuccessor();
		smock.value = 45;
		context.setSuccessorFunction(smock);
		model.baslat();
		Move minimax = algorithm.algorithm(context, model, Player.WHITE);
		assertNotNull(minimax);
		assertEquals(23, minimax.getValue());
		
		assertEquals(6,mock.callCount);
	}
	
	@Test
	public void testAlgorithm6(){
		context.setDepth(1);
		EvaluationMock mock = new EvaluationMock();
		mock.callCount = 5;
		mock.retVal = 23;
		context.setEvaluationFunction(mock);
		
		MockSuccessor smock = new MockSuccessor();
		smock.value = 45;
		context.setSuccessorFunction(smock);
		model.baslat();
		Move minimax = algorithm.algorithm(context, model, Player.WHITE);
		assertNotNull(minimax);
		assertEquals(23, minimax.getValue());
		
		assertEquals(6,mock.callCount);
	}
	
	
	@Test
	public void testAlgorithmFully(){
		context.setDepth(3);
		context.setEvaluationFunction(evaluation);
		
		Successors successors = new Successors();
		context.setSuccessorFunction(successors);
		context.setPlayer(Player.WHITE);
		model.bos();
		model.state[5][0] = SquareState.BLACK;
		model.state[3][0] = SquareState.WHITE;
		model.state[4][3] = SquareState.WHITE;
		Move minimax = algorithm.algorithm(context, model, Player.WHITE);
		assertNotNull(minimax);
		//assertEquals(23, minimax.getValue());
		assertEquals(3,minimax.fromY);
		assertEquals(4,minimax.fromX);
		assertEquals(5,minimax.toX);
		assertTrue(4==minimax.toY || 1 == minimax.toY);
		assertEquals(2, minimax.getValue());

		assertEquals(4, minimax.next.toX);
		assertEquals(1, minimax.next.toY);
		assertEquals(5, minimax.next.fromX);
		assertEquals(0, minimax.next.fromY);
	}

}
