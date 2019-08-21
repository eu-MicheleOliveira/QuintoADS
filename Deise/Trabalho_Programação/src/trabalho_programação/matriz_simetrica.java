
package trabalho_programação;

//MATRIZ SIMETRICA

import java.util.Arrays;
import javax.swing.JOptionPane;

public class matriz_simetrica {

    public static void main(String[]args){
    
        boolean teste = false;
		int A [][] = new int [3][3]; 
		int i,j;
		
                for (i = 0; i < A.length; i++) {
                for (j = 0; j < A.length; j++) {
                A[i][j]=Integer.parseInt(JOptionPane.showInputDialog("Informe os elementos da Matriz"));    
        }    
        }
		
		
                for ( i= 0; i < A.length; i++){
			for (j=0; j < A.length; j++){
				if ( A[i][j] == A[j][i]){
					teste = true;
				}
				else {
					teste = false;
				}
			}
		}
		//IMPRESSÃO	
		System.out.println();
		if (teste == true){
			System.out.println("Matriz simétrica");
                for (i = 0; i < A.length; i++) {
            for (j = 0; j < A.length; j++) {
             System.out.print(A[i][j]+ " ");
            }
           
           System.out.println(" ");
           
        }
                }
		else {
			System.out.println("A matriz não é simétrica");
                        for (i = 0; i < A.length; i++) {
            for (j = 0; j < A.length; j++) {
             System.out.print(A[i][j]+ " ");
            }
           
           System.out.println(" ");
           
        }
		}
	}
}