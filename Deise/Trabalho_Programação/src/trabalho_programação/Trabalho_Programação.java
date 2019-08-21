/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_programação;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Trabalho_Programação {

   
    public static void main(String[] args) {
     
        int A[][] = new int [2][2], i, j = 0;
        
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
            A[i][j]=Integer.parseInt(JOptionPane.showInputDialog(A[i][j]));    
            }
            
        }
        
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
             System.out.println(Arrays.toString(A));
            }
            
        }
        
       
       
    }
    
}
