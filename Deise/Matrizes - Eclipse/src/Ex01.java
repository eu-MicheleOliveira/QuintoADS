
import java.util.Random;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
/*1. Faça um programa em Java que leia uma matriz 2 x 3 de
inteiros,imprima a matriz e a soma de todos os elementos.*/
		
		int m[][] = new int[2][3], i, j;
		Random g = new Random ();
		
		Scanner read = new Scanner(System.in);
 	
		for (i = 0; i < m.length; i++) {
 				
			for (j = 0; j < m.length; j++) {
 					
				m[i][j]=g.nextInt(8+1);

 				}

 	}

 	System.out.println("Matriz");

 	for (i = 0; i < m.length; i++) {

 		for (j = 0; j < m.length; j++) {

 			System.out.printf("%d ", m[i][j]);

 		}

 		System.out.println();
 	}

	}
}
