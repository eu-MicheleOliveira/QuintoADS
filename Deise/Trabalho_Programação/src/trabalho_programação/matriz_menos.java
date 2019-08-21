/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_programação;

import java.util.Random;


public class matriz_menos {

public static void main(String[]args){
 
    int A[][] = new int[3][3], i, j,soma=0;
   int B[][] = new int [3][3], C[][]=new int [3][3];
Random g = new Random();

for (i = 0; i < A.length; i++) {
for (j = 0; j < A.length; j++){
A[i][j] = g.nextInt(5+1)+1;
B[i][j] = g.nextInt(5+1)+1;
}}

for (i = 0; i < A.length; i++) {
for (j = 0; j < A.length; j++){
C[i][j]=A[i][j]-B[i][j];
}}

System.out.println("\nMatriz A");

for (i = 0; i < A.length; i++) {
            for (j = 0; j < A.length; j++) {

             System.out.printf("%02d ", A[i][j]);
            }
           
           System.out.println(" ");
           
        }

System.out.println("\nMatriz B");

for (i = 0; i < B.length; i++) {
            for (j = 0; j < B.length; j++) {
            System.out.printf("%02d ", B[i][j]);
            }
           
           System.out.println(" ");
           
        }
System.out.println("\nMatriz C");

for (i = 0; i < C.length; i++) {
            for (j = 0; j < C.length; j++) {
            System.out.printf("%02d ", C[i][j]);
            }
           
           System.out.println(" ");
           
        }
}
}    
   