package checkers.sandbox;

import java.util.LinkedList;
import java.util.List;

/**
 * Burasý denemelerimizi yapabileceðimiz yer.
 * 
 * @author yusuf
 * 
 */
public class GUIManager {
	// public static void main(String[] args) {
		// System.err.println("This is the main program");
		// for (int i = 1; i <= 9; i = i + 5) {
			// System.err.println("i=" + i);
		// }
	// 0 means blank
	// 1 means white
	// 2 means black
	// 3 means king white
	// 4 means king black
		int[][] m = new int[8][8];
// bir karedekini beyaz taþ kabul edip, çaprazlarýný kontrol edip hamle yaptýracaðýz. 
		// i alt satýr, j yan sütun
		for (int i=1;i<=8;i++){
			for (int i=1;i<=8;i++){
				//eðer bulunduðun yerde bir beyaz varsa
				if (m[i][j]=1) 
				{
					//eðer sað çaprazý da beyazsa deðiþiklik yapma
					if (m[i+1][j+1]=1)
					{
						m[i][j]=1;
					}
					// eðer sað çaprazý siyahsa ve siyahýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri beyaz yap(1 yap)
					else if (m[i+1][j+1]=2 and m[i+2][j+2] and i<=8 and j<=8 )
					{
						m[i][j]=0;
						m[i+1][j+1]=0;
						m[i+2][j+2]=1;
					}
					// eðer sað çaprazý king beyazsa deðiþiklik yapma

					else if (m[i+1][j+1]=3)
					{
						m[i][j]=1;
					}
					// eðer sað çaprazý king siyahsa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri beyaz yap(1 yap)

					else (m[i+1][j+1]=4 and m[i+2][j+2] and i<=8 and j<=8 )
					{
						m[i][j]=0;
						m[i+1][j+1]=0;
						m[i+2][j+2]=1;
					}
				}
				// eðer bulunduðun yerde siyah varsa
				else if 
				
					
				}
			}

		}
		List<Move> nextMoves = successors(m,1);
	}

	private static List<Move> successors(int[][] m, int i) {
		List<Move> list = new LinkedList<Move>();
		
		return list;
	}
}
class Move{
	int fromX;
	int fromY;
	int toX;
	int toY;
}