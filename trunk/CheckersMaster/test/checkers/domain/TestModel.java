package checkers.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import checkers.sandbox.SquareState;

public class TestModel {

	@Test
	public void testBaslat() {
		Model model = new Model();
		model.baslat();
		assertEquals(SquareState.WHITE, model.state[0][0]);
		assertEquals(SquareState.WHITE, model.state[0][2]);
		assertEquals(SquareState.WHITE, model.state[0][4]);
		assertEquals(SquareState.WHITE, model.state[0][6]);
		assertEquals(SquareState.WHITE, model.state[1][1]);
		assertEquals(SquareState.WHITE, model.state[1][3]);
		assertEquals(SquareState.WHITE, model.state[1][5]);
		assertEquals(SquareState.WHITE, model.state[1][7]);
		assertEquals(SquareState.WHITE, model.state[2][0]);
		assertEquals(SquareState.WHITE, model.state[2][2]);
		assertEquals(SquareState.WHITE, model.state[2][4]);
		assertEquals(SquareState.WHITE, model.state[2][6]);
		
		assertEquals(SquareState.BLACK, model.state[7][1]);
		assertEquals(SquareState.BLACK, model.state[7][3]);
		assertEquals(SquareState.BLACK, model.state[7][5]);
		assertEquals(SquareState.BLACK, model.state[7][7]);
		assertEquals(SquareState.BLACK, model.state[6][0]);
		assertEquals(SquareState.BLACK, model.state[6][2]);
		assertEquals(SquareState.BLACK, model.state[6][4]);
		assertEquals(SquareState.BLACK, model.state[6][6]);
		assertEquals(SquareState.BLACK, model.state[5][1]);
		assertEquals(SquareState.BLACK, model.state[5][3]);
		assertEquals(SquareState.BLACK, model.state[5][5]);
		assertEquals(SquareState.BLACK, model.state[5][7]);
	}
//
//	@Test
//	public void testBos() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testTryMove() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDoMove() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUndoTryMove() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetCallback() {
//		fail("Not yet implemented");
//	}

}
