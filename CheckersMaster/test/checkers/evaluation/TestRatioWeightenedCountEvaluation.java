package checkers.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xpath.internal.operations.Div;

import checkers.domain.Player;
import checkers.sandbox.Model;
import checkers.sandbox.SquareState;


public class TestRatioWeightenedCountEvaluation {

	private RatioWeightenedCountEvaluation eval;
	private Model m;

	@Before
	public void setup() {
		eval = new RatioWeightenedCountEvaluation();
		m = new Model();
		m.state = new SquareState[8][8];
		init(m);
	}

	private void init(Model m) {
		SquareState[][] state = m.state;
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[i].length; j++) {
				state[i][j] = SquareState.BLANK;
			}
		}
	}
	
	@Test
	public void test(){
		try{
			double value = eval.evaluate(m, Player.WHITE);
			fail("hata gelmedi");
		}catch (ArithmeticException e) {
			//...
		}catch (Throwable e) {
			fail("baska hata geldi...");
		}
	}
	
	@Test
	public void test2(){
		m.state[5][4]=SquareState.BLACK;
		m.state[2][4]=SquareState.WHITE;
		double value = eval.evaluate(m, Player.WHITE);
		assertEquals(1, value);

	}
}
