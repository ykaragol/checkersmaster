package checkers.rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import checkers.domain.Model;
import checkers.domain.Move;
import checkers.domain.Player;
import checkers.sandbox.Board;
import checkers.sandbox.SquareState;

public class TestSuccessors {

	private Successors successors;
	
	@Before
	public void setup(){
		successors = new Successors();
	}
	
	
	//boþ bir tahtada beyaz taþý test eder...
	@Test
	public void testGetSuccessors1() {
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.WHITE;
		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
		assertEquals(2, moves.size());
		assertEquals(2, moves.get(0).fromX);
		assertEquals(3, moves.get(0).fromY);
		assertEquals(2, moves.get(1).fromX);
		assertEquals(3, moves.get(1).fromY);
		
		assertEquals(3, moves.get(0).toX);
		assertEquals(3, moves.get(1).toX);
		assertTrue( (2==moves.get(0).toY && 4==moves.get(1).toY)^(4==moves.get(0).toY && 2==moves.get(1).toY) );
	}
	

	//boþ bir tahtada beyaz kralý taþý test eder...
	@Test
	public void testGetSuccessors11() {
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.KING_WHITE;
		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
		assertEquals(4, moves.size());
	}
	
	
	//boþ bir tahtada siyah taþý test eder...
	@Test
	public void testGetSuccessors12() {
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
		assertEquals(2, moves.size());
		assertEquals(2, moves.get(0).fromX);
		assertEquals(3, moves.get(0).fromY);
		assertEquals(2, moves.get(1).fromX);
		assertEquals(3, moves.get(1).fromY);
		
		assertEquals(1, moves.get(0).toX);
		assertEquals(1, moves.get(1).toX);
		assertTrue( (2==moves.get(0).toY && 4==moves.get(1).toY)^(4==moves.get(0).toY && 2==moves.get(1).toY) );
	}
	
	//boþ bir tahtada siyah kralý taþý test eder...
	@Test
	public void testGetSuccessors13() {
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.KING_BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
		assertEquals(4, moves.size());
	}
	
	//boþ bir tahtada sol duvar kenarýndaki beyaz taþý test eder.
	@Test
	public void testGetSuccessors2() {
		Model model = new Model();
		model.bos();
		model.state[3][0] = SquareState.WHITE;
		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
		assertEquals(1, moves.size());
		assertEquals(3, moves.get(0).fromX);
		assertEquals(0, moves.get(0).fromY);
		assertEquals(4, moves.get(0).toX);
		assertEquals(1, moves.get(0).toY);
	}
	
	//boþ bir tahtada sol duvar kenarýndaki beyaz kral taþý test eder.
	@Test
	public void testGetSuccessors21() {
		Model model = new Model();
		model.bos();
		model.state[3][0] = SquareState.KING_WHITE;
		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
		assertEquals(2, moves.size());
	}
	
	//boþ bir tahtada sol duvar kenarýndaki siyah taþý test eder.
	@Test
	public void testGetSuccessors22() {
		Model model = new Model();
		model.bos();
		model.state[3][0] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
		assertEquals(1, moves.size());
		assertEquals(3, moves.get(0).fromX);
		assertEquals(0, moves.get(0).fromY);
		assertEquals(2, moves.get(0).toX);
		assertEquals(1, moves.get(0).toY);
	}
	
	//boþ bir tahtada sol duvar kenarýndaki siyah kral taþý test eder.
	@Test
	public void testGetSuccessors23() {
		Model model = new Model();
		model.bos();
		model.state[3][0] = SquareState.KING_BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
		assertEquals(2, moves.size());
	}
	
	//boþ bir tahtada sað duvar kenarýndaki beyaz taþý test eder.
	@Test
	public void testGetSuccessors3() {
		Model model = new Model();
		model.bos();
		model.state[3][7] = SquareState.WHITE;
		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
		assertEquals(1, moves.size());
		assertEquals(3, moves.get(0).fromX);
		assertEquals(7, moves.get(0).fromY);
		assertEquals(4, moves.get(0).toX);
		assertEquals(6, moves.get(0).toY);
	}
	
	//boþ bir tahtada sað duvar kenarýndaki beyaz kral taþý test eder.
	@Test
	public void testGetSuccessors31() {
		Model model = new Model();
		model.bos();
		model.state[3][7] = SquareState.KING_WHITE;
		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
		assertEquals(2, moves.size());
	}

	//boþ bir tahtada sað duvar kenarýndaki siyah taþý test eder.
	@Test
	public void testGetSuccessors32() {
		Model model = new Model();
		model.bos();
		model.state[3][7] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
		assertEquals(1, moves.size());
		assertEquals(3, moves.get(0).fromX);
		assertEquals(7, moves.get(0).fromY);
		assertEquals(2, moves.get(0).toX);
		assertEquals(6, moves.get(0).toY);
	}
	
	//boþ bir tahtada sað duvar kenarýndaki beyaz kral taþý test eder.
	@Test
	public void testGetSuccessors33() {
		Model model = new Model();
		model.bos();
		model.state[3][7] = SquareState.KING_BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
		assertEquals(2, moves.size());
	}

	
	//boþ bir tahtada beyaz taþý ve yiyebileceði siyah taþý test eder...
	@Test
	public void testGetSuccessors4() {
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.WHITE;
		model.state[3][2] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
		assertEquals(1, moves.size());
		assertEquals(2, moves.get(0).fromX);
		assertEquals(3, moves.get(0).fromY);
		assertEquals(4, moves.get(0).toX);
		assertEquals(1, moves.get(0).toY);
	}

	//boþ bir tahtada beyaz kral taþý ve yiyebileceði siyah taþý test eder...
	@Test
	public void testGetSuccessors41() {
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.WHITE;
		model.state[3][2] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
		assertEquals(1, moves.size());
		assertEquals(2, moves.get(0).fromX);
		assertEquals(3, moves.get(0).fromY);
		assertEquals(4, moves.get(0).toX);
		assertEquals(1, moves.get(0).toY);
	}
	
	//boþ bir tahtada beyaz taþý ve yiyebileceði siyah taþý test eder...
	@Test
	public void testGetSuccessors42() {
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.WHITE;
		model.state[3][2] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
		assertEquals(1, moves.size());
		assertEquals(3, moves.get(0).fromX);
		assertEquals(2, moves.get(0).fromY);
		assertEquals(1, moves.get(0).toX);
		assertEquals(4, moves.get(0).toY);
	}
	

	//boþ bir tahtada siyah kral taþý ve yiyebileceði siyah taþý test eder...
	@Test
	public void testGetSuccessors43() {
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.WHITE;
		model.state[3][2] = SquareState.KING_BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
		assertEquals(1, moves.size());
		assertEquals(3, moves.get(0).fromX);
		assertEquals(2, moves.get(0).fromY);
		assertEquals(1, moves.get(0).toX);
		assertEquals(4, moves.get(0).toY);
	}
	
	//boþ bir tahtada beyaz taþý ve yiyemeyeceði siyah taþý test eder...
	@Test
	public void testGetSuccessors5() {
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.WHITE;
		model.state[3][2] = SquareState.BLACK;
		model.state[4][1] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
		assertEquals(1, moves.size());
		assertEquals(2, moves.get(0).fromX);
		assertEquals(3, moves.get(0).fromY);
		assertEquals(3, moves.get(0).toX);
		assertEquals(4, moves.get(0).toY);
	}
	
	//boþ bir tahtada beyaz taþý ve yiyemeyeceði siyah taþý test eder...
	@Test
	public void testGetSuccessors51() {
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.KING_WHITE;
		model.state[3][2] = SquareState.BLACK;
		model.state[4][1] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
		assertEquals(3, moves.size());
	}
	
	//boþ bir tahtada siyah taþý ve yiyemeyeceði beyaz taþý test eder...
	@Test
	public void testGetSuccessors52() {
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.WHITE;
		model.state[3][2] = SquareState.WHITE;
		model.state[4][1] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
		assertEquals(1, moves.size());
		assertEquals(4, moves.get(0).fromX);
		assertEquals(1, moves.get(0).fromY);
		assertEquals(3, moves.get(0).toX);
		assertEquals(0, moves.get(0).toY);
	}
	
	//boþ bir tahtada siyah kral taþý ve yiyemeyeceði beyaz taþý test eder...
	@Test
	public void testGetSuccessors53() {
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.KING_BLACK;
		model.state[3][2] = SquareState.WHITE;
		model.state[4][1] = SquareState.WHITE;
		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
		assertEquals(3, moves.size());
	}
	
	//boþ bir tahtada beyaz taþý ve yiyemeyeceði siyah taþý test eder...
	@Test
	public void testGetSuccessors501() {
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.WHITE;
		model.state[3][2] = SquareState.WHITE;
		model.state[4][1] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
		assertEquals(1, moves.size());
		assertEquals(3, moves.get(0).fromX);
		assertEquals(2, moves.get(0).fromY);
		assertEquals(5, moves.get(0).toX);
		assertEquals(0, moves.get(0).toY);
	}
	
	//boþ bir tahtada beyaz taþý ve saðdan yiyeceði siyah taþý test eder...
	@Test
	public void testGetSuccessors6() {		
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.WHITE;
		model.state[3][4] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
		assertEquals(1, moves.size());
		assertEquals(2, moves.get(0).fromX);
		assertEquals(3, moves.get(0).fromY);
		assertEquals(4, moves.get(0).toX);
		assertEquals(5, moves.get(0).toY);
	}
	
	//boþ bir tahtada beyaz taþ ve saðdan yiyeceði siyah taþý test eder... 
	//sonrasýnda king olacak...
	@Test
	public void testGetSuccessors601() {		
		Model model = new Model();
		model.bos();
		model.state[5][4] = SquareState.WHITE;
		model.state[6][3] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
		assertEquals(1, moves.size());
		assertEquals(5, moves.get(0).fromX);
		assertEquals(4, moves.get(0).fromY);
		assertEquals(2, moves.get(0).toY);
		assertEquals(7, moves.get(0).toX);
	}
	
	//boþ bir tahtada beyaz kral taþý ve saðdan yiyeceði siyah taþý test eder...
	@Test
	public void testGetSuccessors61() {		
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.KING_WHITE;
		model.state[3][4] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
		assertEquals(1, moves.size());
		assertEquals(2, moves.get(0).fromX);
		assertEquals(3, moves.get(0).fromY);
		assertEquals(4, moves.get(0).toX);
		assertEquals(5, moves.get(0).toY);
	}
	
	//boþ bir tahtada siyah taþý ve saðdan yiyeceði beyaz taþý test eder...
	@Test
	public void testGetSuccessors62() {		
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.WHITE;
		model.state[3][4] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
		assertEquals(1, moves.size());
		assertEquals(3, moves.get(0).fromX);
		assertEquals(4, moves.get(0).fromY);
		assertEquals(1, moves.get(0).toX);
		assertEquals(2, moves.get(0).toY);
	}
	
	//boþ bir tahtada siyah kral taþý ve soldan yiyeceði beyaz taþý test eder...
	@Test
	public void testGetSuccessors63() {		
		Model model = new Model();
		model.bos();
		model.state[2][3] = SquareState.WHITE;
		model.state[3][4] = SquareState.KING_BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
		assertEquals(1, moves.size());
		assertEquals(3, moves.get(0).fromX);
		assertEquals(4, moves.get(0).fromY);
		assertEquals(1, moves.get(0).toX);
		assertEquals(2, moves.get(0).toY);
	}
	//boþ bir tahtada siyah taþý ve saðdan yiyeceði beyaz taþý test eder... sonrasýnda king olacak
//	@Test
//	public void testGetSuccessors64() {		
//		Model model = new Model();
//		model.bos();
//		model.state[1][3] = SquareState.WHITE;
//		model.state[2][4] = SquareState.BLACK;
//		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
//		assertEquals(1, moves.size());
//		assertEquals(2, moves.get(0).fromX);
//		assertEquals(4, moves.get(0).fromY);
//		assertEquals(0, moves.get(0).toX);
//		assertEquals(2, moves.get(0).toY);
//		assertTrue(moves.get(0).must);
//		assertTrue(moves.get(0).convert);
//	}
	
	//çoklu yeme durumu
	@Test
	public void testGetSuccessors71() {		
		Model model = new Model();
		model.bos();
		model.state[3][2] = SquareState.WHITE;
		model.state[5][2] = SquareState.WHITE;
		model.state[6][3] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
		assertEquals(1, moves.size());
		Move move = moves.get(0);
		assertEquals(6, move.fromX);
		assertEquals(3, move.fromY);
		assertEquals(4, move.toX);
		assertEquals(1, move.toY);
		assertNotNull(move.nextMustMove);
		
		assertEquals(4, move.nextMustMove.fromX);
		assertEquals(1, move.nextMustMove.fromY);
		assertEquals(2, move.nextMustMove.toX);
		assertEquals(3, move.nextMustMove.toY);
	}
	
	//pek çoklu yeme durumu
	@Test
	public void testGetSuccessors72() {		
		Model model = new Model();
		model.bos();
		model.state[1][2] = SquareState.WHITE;
		model.state[3][2] = SquareState.WHITE;
		model.state[5][2] = SquareState.WHITE;
		model.state[6][3] = SquareState.BLACK;
		List<Move> moves = successors.getSuccessors(model, Player.BLACK);
		assertEquals(1, moves.size());
		Move move = moves.get(0);
		assertEquals(6, move.fromX);
		assertEquals(3, move.fromY);
		assertEquals(4, move.toX);
		assertEquals(1, move.toY);
		assertNotNull(move.nextMustMove);
		
		assertEquals(4, move.nextMustMove.fromX);
		assertEquals(1, move.nextMustMove.fromY);
		assertEquals(2, move.nextMustMove.toX);
		assertEquals(3, move.nextMustMove.toY);
		
		assertNotNull(move.nextMustMove.nextMustMove);
		
		assertEquals(2, move.nextMustMove.nextMustMove.fromX);
		assertEquals(3, move.nextMustMove.nextMustMove.fromY);
		assertEquals(0, move.nextMustMove.nextMustMove.toX);
		assertEquals(1, move.nextMustMove.nextMustMove.toY);
	}
	
//	//boþ bir tahtada beyaz taþý ve saðdan yiyeceði iki siyah taþý test eder...
//	@Test
//	public void testGetSuccessors7() {
//		Model model = new Model();
//		model.bos();
//		model.state[2][3] = SquareState.WHITE;
//		model.state[3][4] = SquareState.BLACK;
//		model.state[5][6] = SquareState.BLACK;
//		List<Move> moves = successors.getSuccessors(model, Player.WHITE);
//		assertEquals(2, moves.size());
//		assertEquals(2, moves.get(0).fromX);
//		assertEquals(3, moves.get(0).fromY);
//		assertEquals(2, moves.get(1).fromX);
//		assertEquals(3, moves.get(1).fromY);
//		
//		assertTrue( (3==moves.get(0).toX && 6==moves.get(1).toX)^(6==moves.get(0).toX && 3==moves.get(1).toX) );
//		assertTrue( (2==moves.get(0).toY && 7==moves.get(1).toY)^(7==moves.get(0).toY && 2==moves.get(1).toY) );
//	}
}
