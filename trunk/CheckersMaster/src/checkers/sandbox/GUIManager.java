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
		for (int i=1;i<=8;i++){
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
           for (int i=8;1<=i;i--){
				if m[i][1]=2;{ 
					m[i][1]=4;
				}
			}
           
           
           for (int i=1;i<=8;i++){
        	   for (int j=1;j<=8;j++){
        		   for (int k=1;k<=6;k++){
        		// eðer bulunduðun karede king beyaz varsa
        		   if (m[i][j]==3){
        				   //eðer king beyaz ön sað çaprazýnda siyahla karþýlaþýrsa
        			   if (m[i+k][j+k]==2 && m[i+k+1][j+k+1]==0 && (i+k)<=7 && (j+k)<=7){
        				   // üst satýra i+k<=7 ve j+k<=7 dememin nedeni, eðer 8 deseydim, siyah taþ 8'li bir satýr ya da 8'l bir sütunda da olabilirdi. 
        				   //ama beyaz kingin gidecek bir yeri olmazdý. beyaz king en son gitse gitse 8'li satýr ya da sütunlara
        				   //ulaþabileceði için i+k ve j+k sýnýrlarýný 7 ile sýnýrladým.
        				   m[i][j]=0;
        				   m[i+k][j+k]=0;
        				   m[i+k+1][j+k+1]=3;
        			   }
    				   //king beyaz ön sað çaprazýnda king siyahla karþýlaþýrsa
        			   else if (m[i+k][j+k]==4 && m[i+k+1][j+k+1]==0 && (i+k)<=7 && (j+k)<=7){
        				   m[i][j]=0;
        				   m[i+k][j+k]=0;
        				   m[i+k+1][j+k+1]=3;
        			   }
        			   //king beyaz ön sol çaprazýnda siyahla karþýlaþýrsa
        			   else if (m[i-k][j+k]==2 && m[i-k-1][j+k+1]==0 && (i-k)>=2 && (j+k)<=7){
        				   m[i][j]=0;
        				   m[i-k][j+k]=0;
        				   m[i-k-1][j+k+1]=3;
        			   }
        			 //king beyaz ön sol çaprazýnda king siyahla karþýlaþýrsa
        			   else if (m[i-k][j+k]==4 && m[i-k-1][j+k+1]==0 && (i-k)>=2 && (j+k)<=7){
        				   m[i][j]=0;
        				   m[i-k][j+k]=0;
        				   m[i-k-1][j+k+1]=3;
        			   }
        			   //king beyaz arka sað çaprazýnda siyahla karþýlaþýrsa
        			   else if (m[i+k][j-k]==2 && m[i+k+1][j-k-1]==0 && (i+k)<=7 && (j-k)>=2){
        				   m[i][j]=0;
        				   m[i+k][j-k]=0;
        				   m[i+k+1][j-k-1]=3;
        			   }
        			 //king beyaz arka sað çaprazýnda king siyahla karþýlaþýrsa
        			   else if (m[i+k][j-k]==4 && m[i+k+1][j-k-1]==0 && (i+k)<=7 && (j-k)>=2){
        				   m[i][j]=0;
        				   m[i+k][j-k]=0;
        				   m[i+k+1][j-k-1]=3;
        			   }
        			 //king beyaz arka sol çaprazýnda siyahla karþýlaþýrsa
        			   else if (m[i-k][j-k]==2 && m[i-k-1][j-k-1]==0 && (i-k)>=2 && (j-k)>=2){
        				   m[i][j]=0;
        				   m[i-k][j-k]=0;
        				   m[i-k-1][j-k-1]=3;
        			   }
        			   //king beyaz arka sol çaprazýnda king siyahla karþýlaþýrsa
        			   else if (m[i-k][j-k]==4 && m[i-k-1][j-k-1]==0 && (i-k)>=2 && (j-k)>=2){
        				   m[i][j]=0;
        				   m[i-k][j-k]=0;
        				   m[i-k-1][j-k-1]=3;
        			   }
        		   }
        		   }
        	   }
           }
           
           for (int i=1;i<=8;i++){
        	   for (int j=1;j<=8;j++){
        		   for (int k=1;k<=6;k++){
        		// eðer bulunduðun karede king siyah varsa
            		   if (m[i][j]==4){
            			//eðer king siyah ön sað çaprazýnda beyazla karþýlaþýrsa
            			   if (m[i-k][j-k]==1 && m[i-k-1][j-k-1]==0 && (i-k)>=2 && (j-k)>=2){
            				   m[i][j]=0;
            				   m[i-k][j-k]=0;
            				   m[i-k-1][j-k-1]=4;
            			   }
        				   //king siyah ön sað çaprazýnda king beyazla karþýlaþýrsa
            			   if (m[i-k][j-k]==3 && m[i-k-1][j-k-1]==0 && (i-k)>=2 && (j-k)>=2){
            				   m[i][j]=0;
            				   m[i-k][j-k]=0;
            				   m[i-k-1][j-k-1]=4;
            			   }
            			   //king siyah ön sol çaprazýnda beyazla karþýlaþýrsa
            			   else if (m[i+k][j-k]==1 && m[i+k+1][j-k-1]==0 && (j-k)>=2 && (i+k)<=7){
            				   m[i][j]=0;
            				   m[i+k][j-k]=0;
            				   m[i+k+1][j-k-1]=4;
            			   }
            			 //king siyah ön sol çaprazýnda king beyazla karþýlaþýrsa
            			   else if (m[i+k][j-k]==3 && m[i+k+1][j-k-1]==0 && (j-k)>=2 && (i+k)<=7){
            				   m[i][j]=0;
            				   m[i+k][j-k]=0;
            				   m[i+k+1][j-k-1]=4;
            			   }
            			   //king siyah arka sað çaprazýnda beyazla karþýlaþýrsa
            			   else if (m[i-k][j+k]==1 && m[i-k-1][j+k+1]==0 && (j+k)<=7 && (i-k)>=2){
            				   m[i][j]=0;
            				   m[i-k][j+k]=0;
            				   m[i-k-1][j+k+1]=4;
            			   }
            			   //king siyah arka sað çaprazýnda king beyazla karþýlaþýrsa
            			   else if (m[i-k][j+k]==3 && m[i-k-1][j+k+1]==0 && (j+k)<=7 && (i-k)>=2){
            				   m[i][j]=0;
            				   m[i-k][j+k]=0;
            				   m[i-k-1][j+k+1]=4;
            			   }
            			 //king siyah arka sol çaprazýnda beyazla karþýlaþýrsa
            			   else if (m[i+k][j+k]==1 && m[i+k+1][j+k+1]==0 && (i+k)<=7 && (j+k)<=7){
            				   m[i][j]=0;
            				   m[i+k][j+k]=0;
            				   m[i+k+1][j+k+1]=4;
            			   }
            			   //king siyah arka sol çaprazýnda king beyazla karþýlaþýrsa
            			   else if (m[i+k][j+k]==3 && m[i+k+1][j+k+1]==0 && (i+k)<=7 && (j+k)<=7){
            				   m[i][j]=0;
            				   m[i+k][j+k]=0;
            				   m[i+k+1][j+k+1]=4;
            			   }
            		   }
            		   }
            	   }
               }
               
        		
			
		List<Move> nextMoves = successors(m,1);
	}

	private static List<Move> successors(int[][]m , int i) {
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