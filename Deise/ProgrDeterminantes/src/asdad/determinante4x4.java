package asdad;

import java.util.Scanner;

public class determinante4x4 {

	public static void main(String[] args) {

	    int i = 0, j = 0, k = 0, contador = 0, contador_2 = 0, det = 0;
	    int valor = 0, soma_direita = 0, soma_esquerda = 0, ordem = 0;
	    int matriz[][] = new int[100][100];
	    
	    Scanner leia = new Scanner(System.in);

	    System.out.print("\n\tCalculo do determinante de uma matriz quadrada de ordem N\n\n");
	    System.out.println("Informe a ordem da matriz:  ");
	    ordem = leia.nextInt();
	    
	    // Leitura dos valores na matriz
	    for ( i = 0; i < ordem; i++ )
	    {
	          for( j = 0; j < ordem; j++ )
	            {
	                   System.out.printf("Informe o valor [%d][%d]: ", i + 1, j + 1);
	                   matriz[i][j]=leia.nextInt();
	            }
	    }

	    // LEITURA DA DIREITA PARA A ESQUERDA
	    j = 0;
	    k = 0;
	    valor = 1;
	    contador = 0;
	    contador_2 = 0;
	    soma_direita = 0;
	    // Quantidade total de leituras na matriz
	    for ( i = 0; i <= ( ordem * ordem ); i++ )
	    {

	        // Retorna i para inicio da matriz
	        if ( j == ordem )
	        {

	            j = 0;
	            contador_2++;
	            k = contador_2;

	        }

	        if ( k == ordem )
	            k = 0;

	        valor = valor * matriz[j][k];

	        j++;
	        k++;
	        contador++;

	        if ( contador == ordem )
	        {

	            soma_direita = soma_direita + valor;
	            valor = 1;
	            contador = 0;

	        }


	    }

	    // LEITURA DA ESQUERDA PARA A DIREITA
	    j = 0;
	    k = ordem - 1;
	    valor = 1;
	    contador = 0;
	    contador_2 = ordem - 1;
	    soma_esquerda = 0;
	    // Quantidade total de leituras na matriz
	    for ( i = 0; i <= ( ordem * ordem ); i++ )
	    {

	        // Retorna i para inicio da matriz
	        if ( j == ordem )
	        {

	            j = 0;
	            contador_2--;
	            k = contador_2;

	        }

	        if ( k < 0 )
	            k = ordem -1 ;

	        valor = valor * matriz[j][k];

	        j++;
	        k--;
	        contador++;

	        if ( contador == ordem )
	        {

	            soma_esquerda = soma_esquerda + valor;
	            valor = 1;
	            contador = 0;

	        }


	    }

	    det = soma_direita + ( soma_esquerda * (-1) );

	    System.out.printf("\nO Determinante e %d:\n\n", det);
	}
}


