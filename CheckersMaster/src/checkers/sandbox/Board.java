package checkers.sandbox;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import checkers.domain.Model;
import checkers.domain.Move;
import checkers.domain.Player;
import checkers.rules.Successors;


/*
8 x o x o x o x o
7 o x o x o x o x
6 x o x o x o x o
5 o x o x o x o x
4 x o x o x o x o
3 o x o x o x o x
2 x o x o x o x o
1 o x o x o x o x 
  1 2 3 4 5 6 7 8 
*/

/**
 * Checkers i�in oyun tahtas�n� olu�turan kod.
 * 
 * 
 * @author ykaragol
 */
@SuppressWarnings("serial")
public class Board extends JPanel {

	private Image board = null;
	private Image white = null;
	private Image black = null;
	private Image kingWhite = null;
	private Image kingBlack = null;
	
	private Model model;

	public Image getBoard() {
		return board;
	}

	public void setBoard(Image board) {
		this.board = board;
	}

	public Board() throws IOException {
		File f = new File("./img/board.jpg");
		board = ImageIO.read(f);
		addMouseListener(new BoardMouseListener());
		addMouseMotionListener(new BoardMouseMotionListener());
		
		f = new File("./img/white.gif");
		white = ImageIO.read(f);
		
		f = new File("./img/black.gif");
		black = ImageIO.read(f);
		
		f = new File("./img/kingWhite.gif");
		kingWhite = ImageIO.read(f);
		
		f = new File("./img/kingBlack.gif");
		kingBlack = ImageIO.read(f);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(board, 0, 0, getHeight(), getWidth(), null);
		
		SquareState [][] matrix = model.state;
		
		for (int i = matrix.length-1; i >=0; i--) {
			for (int j = 0; j < matrix[i].length; j++) {
				Image img = null;
				switch(matrix[i][j]){
					case BLACK:
						img = black;
						break;
					case WHITE:
						img = white;
						break;
					case KING_BLACK:
						img = kingBlack;
						break;
					case KING_WHITE:
						img = kingWhite;
						break;
				}
				if(img != null){
					double p = getHeight() / 8;
					g.drawImage(img, (int)(p*j+p*0.15), (int)(p*(7-i)+p*0.15), (int)(p*0.7), (int)(p*0.7), null);
				}
			}
		}
	}
	
	private class BoardMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent event) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent event) {
			// TODO Auto-generated method stub			
		}

		@Override
		public void mouseExited(MouseEvent event) {
			// TODO Auto-generated method stub			
		}
		
		private int _x,_y;
		private LinkedList<Move> possibleMoves;

		@Override
		public void mousePressed(MouseEvent event) {
			double width = Board.this.getWidth();
			double height = Board.this.getHeight();
			
			int x = (int)(event.getX() / (width / 8)) + 1;
			int y = (int)((height - event.getY()) / (height/ 8)) + 1;
			
			//System.err.println("Su noktada basildi:"+ x + " - " + y);
			
			_x=x;
			_y=y;
			
			Successors successors = new Successors();
			LinkedList<Move> moves = new LinkedList<Move>();
			successors.handleStone(moves, model, _y-1, _x-1);
			possibleMoves = moves;
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			if(possibleMoves.size()==0)
				return;
			double width = Board.this.getWidth();
			double height = Board.this.getHeight();
			
			int x = (int)(event.getX() / (width / 8)) + 1;
			int y = (int)((height - event.getY()) / (height/ 8)) + 1;
			
			//System.err.println("Su noktada birakildi:"+ x + " - " + y);
			Move currentMove = null;
			for (Move move : possibleMoves) {
				if(move.toX == y-1 && move.toY == x-1){
					currentMove = move;
					break;
				}
			}
//			Move move  = new Move();
//			move.fromX = _y-1;
//			move.fromY = _x-1;
//			move.toX = y-1;
//			move.toY = x-1;
//			if(move.fromX == move.toX && move.fromY == move.toY)
//				return;
			if(currentMove==null)
				return;
			model.doMove(currentMove);
		}
		
	}
	
	private class BoardMouseMotionListener implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static Board init(Model model) throws IOException {
		Board b = new Board();
		b.model = model;
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(2, 2, 610, 636);
		frame.add(b);
		frame.setResizable(false);
		frame.setVisible(true);
		return b;
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
