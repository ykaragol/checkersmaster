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
			for (int j=1;j<=8;j++){
				//eðer bulunduðun yerde bir beyaz varsa
				if (m[i][j]==1) 
				{
					//eðer sað çaprazý da beyazsa deðiþiklik yapma
					if (m[i+1][j+1]==1 && (i+1)<=8 && (j+1)<=8)
					{
						m[i][j]=1;
					}
					// eðer sað çaprazý siyahsa ve siyahýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri beyaz yap(1 yap)
					else if (m[i+1][j+1]==2 && m[i+2][j+2]==0 && (i+2)<=8 && (j+2)<=8)
					{
						m[i][j]=0;
						m[i+1][j+1]=0;
						m[i+2][j+2]=1;
					}
					// eðer sað çaprazý king beyazsa deðiþiklik yapma

					else if (m[i+1][j+1]==3 && (i+1)<=8 && (j+1)<=8)
					{
						m[i][j]=1;
					}
					// eðer sað çaprazý king siyahsa ve siyahýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri beyaz yap(1 yap)

					else if(m[i+1][j+1]==4 && m[i+2][j+2]==0 && (i+2)<=8 && (j+2)<=8)
					{
						m[i][j]=0;
						m[i+1][j+1]=0;
						m[i+2][j+2]=1;
					}
					//eðer sol çaprazý beyazsa deðiþiklik yapma
					else if (m[i-1][j+1]==1 && (j+1)<=8 && 1<=(i-1))
					{
						m[i][j]=1;
					}
					// eðer sol çaprazý siyahsa ve siyahýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri beyaz yap(1 yap)
					else if (m[i-1][j+1]==2 && m[i-2][j+2]==0 && (j+2)<=8 && 1<=(i-2))
					{
						m[i][j]=0;
						m[i-1][j+1]=0;
						m[i-2][j+2]=1;
					}
					//eðer sol çaprazý da king beyazsa deðiþiklik yapma
					else if (m[i-1][j+1]==3 && (j+1)<=8 && 1<=(i-1))
					{
						m[i][j]=1;
					}
					// eðer sol çaprazý king siyahsa ve siyahýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri beyaz yap(1 yap)

					else if (m[i-1][j+1]==4 && m[i-2][j+2]==0 && (j+2)<=8 && 1<=(i-2))
					{
						m[i][j]=0;
						m[i-1][j+1]=0;
						m[i-2][j+2]=1;
					}
					
				}
				
			}
		}
		//eðer beyazlar 8. satýra ulaþmýþsa king beyaz olurlar
		for (i=1;i<=8;i++){
			if m[i][8]=1;{
				m[i][8]=3;
			}
		}
}

		// siyahlar farklý olarak matrisin son elemanlarýndan itibaren hareket etmeye baþlayacaklar
		for (int i=1;i<=8;i++){
			for (int j=8;1<=j;j--){
				// eðer bulunduðun karede siyah varsa
				if m[i][j]==2{
					//eðer sað çaprazý da siyahsa deðiþiklik yapma
					if (m[i-1][j-1]==2 && 1<=(j-1)&& 1<=(i-1)){ 
						m[i][j]=2;
					}
					// eðer sað çaprazý beyazsa ve beyazýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri siyah yap(2 yap)
					else if (m[i-1][j-1]==1 && m[i-2][j-2]==0&& 1<=(j-2) && 1<=(i-2)){
					m[i-2][j-2]=2;
					m[i-1][j-1]=0;
					m[i][j]=0;
					}
					// eðer sað çaprazý king siyahsa deðiþiklik yapma
					else if (m[i-1][j-1]==4 && 1<=(j-1)&& 1<=(i-1)){
						m[i][j]=2;
					}
					// eðer sað çaprazý king beyazsa ve beyazýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri siyah yap(2 yap)
					else if (m[i-1][j-1]==3 && m[i-2][j-2]==0 && 1<=(j-2)&& 1<=(i-2)){
						m[i-2][j-2]=2;
						m[i-1][j-1]=0;
						m[i][j]=0;
					}
					//eðer sol çaprazý da siyahsa deðiþiklik yapma
					else if (m[i+1][j-1]==2 && 1<=(j-1)&& (i+1)<=8){
						m[i][j]=2;
					}
					// eðer sol çaprazý beyazsa ve beyazýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri siyah yap(2 yap)
					else if (m[i+1][j-1]==1 && m[i+2][j-2]==0 && 1<=(j-2)&& (i+2)<=8){
						m[i+2][j-2]=2;
						m[i+1][j-1]=0;
						m[i][j]=0;
					}
					//eðer sol çaprazý da king siyahsa deðiþiklik yapma
					else if (m[i+1][j-1]==4 & 1<=(j-1)&& (i+1)<=8){
						m[i][j]=2;
					}
					// eðer sol çaprazý king beyazsa ve beyazýn arkasý boþluksa üstünden atlat ve önceden bulunduðu yeri sýfýrlayýp(blank yap) yeni yeri siyah yap(2 yap)
					else if (m[i+1][j-1]==3 && m[i+2][j-2]==0 && 1<=(j-2)&& (i+2)<=8){
						m[i+1][j-1]=0;
						m[i+2][j-2]=2;
						m[i][j]=0;
				}
			}
		}
			//eðer siyahlarlar 1. satýra ulaþmýþsa king siyah olurlar
           for (i=8;1<=i;i--){
				if m[i][1]=2;{ 
					m[i][1]=4;
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