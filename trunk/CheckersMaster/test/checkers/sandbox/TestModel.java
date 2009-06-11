package checkers.sandbox;

import static org.junit.Assert.assertTrue;
import checkers.domain.Model;


public class TestModel {
	
	/**
	 * Tablonun dizilimini test eder.
	 * ilk index yukarıdan aşağı, ikinci index sağdan sola
	 */
	//@Test
	public void test(){
		Model m = new Model();
		m.baslat();
		for (int i = 0; i < m.state.length; i++) {
			SquareState square = m.state[i][0];
			assertTrue( !(i==1) || square == SquareState.WHITE); // if 1 then White
			assertTrue( !(i==5 || i==7) || square == SquareState.BLACK); //  if(5|7) then Black
			assertTrue( (i==1 || i==5 || i==7) || square == SquareState.BLANK ); //if not (1|5|7) then Blank
		}
	}
}
