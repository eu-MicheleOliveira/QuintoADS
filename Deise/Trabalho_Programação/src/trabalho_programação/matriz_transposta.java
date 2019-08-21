
package trabalho_programação;

import java.util.Random;

public class matriz_transposta {

    public static void main (String[]args){
        
int A[][] = new int [4][6], B[][]= new int [6][4],i,j,k;
    Random g = new Random();
    for(i = 0; i < 4; i++)
      for (j = 0; j < 6; j++) 
                A[i][j] = g.nextInt(8+1)+1;
    
         
        
     
    System.out.println("Elementos da Matriz A: ");
               for (i = 0; i < 4; i++) {
            for (j = 0; j < 6; j++) {
             System.out.print(A[i][j]+ " ");
            }
           
           System.out.println(" ");
           
        }
           
            
               
                System.out.println("Elementos da Matriz B: ");
               for (i = 0; i < 6; i++) {
            for (j = 0; j < 4; j++) {
             System.out.print(A[j][i]+ " ");
            }
           
           System.out.println(" ");
           
        }   
       }
}
