/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_programação;

import java.util.Random;

//MATRIZ IDENTIDADE
public class matriz_identidade {
    


   
    public static void main(String[] args) {
     
        int A[][] = new int [7][7], i, j = 0;
        Random g = new Random ();
        for (i = 0; i < A.length; i++) {
            for (j = 0; j < A.length; j++) {
            
              A[i][j]=g.nextInt(8+1)+1;
            //A[i][j]=Integer.parseInt(JOptionPane.showInputDialog(A[i][j]));    
            }
        }  
        
        for (i = 0; i < A.length; i++) {
            for (j = 0; j < A.length; j++) {
        if(i==j){
            A[i][j]=1;
        } else        
            A[i][j]=0;
            }
            
        }
        
        
        for (i = 0; i < A.length; i++) {
            for (j = 0; j < A.length; j++) {
             System.out.print(A[i][j]+ " ");
            }
           
           System.out.println(" ");
           
        }
        
   
       
    }
   }
