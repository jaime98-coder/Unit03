package arraysexercises01;

import java.util.Random;
import java.util.Scanner;

public class Exercise08 {

	public static void main(String[] args) {
		// Declaro la tabla numeros de 100 de longitud para poder almacenar 100 valores.
		int[] numeros = new int[100];
		// Creo el Random para así poder rellenar la tabla con números aleatorios
		Random aleatorio = new Random();
		// Creo el Scanner para poder leer de la consola
		Scanner sc = new Scanner(System.in);
		// Declaro numBuscado para poder almacenar el nº que quiere buscar el usuario
		int numBuscado;
		// Declaro e inicializo en 0 la variable números encontrados
		int numerosEncontrados = 0;
		// Creo un FOR para recorrer la matriz e ir asignando con cada iteración las
		// diferentes posiciones de mi tabla numeros con un nº aleatorio entre 1 y 10
		// (recordar que 11 queda excluido)
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = aleatorio.nextInt(1, 11);
		}
		// Imprimo en pantalla el mensaje solicitando al usuario que introduzca el nº
		// que quiere buscar y lo leo de la consola
		System.out.println("Introduce el número que quieres buscar (entre 1 y 10): ");
		numBuscado = sc.nextInt();
		// Creo un FOR para visualizar la matriz completa que se ha generado de forma
		// aleatoria imprimiendo
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " - ");
		}
		// Hago saltos de linea para separar la matriz del resultado
		System.out.println();
		System.out.println();

		// Hago un FOR para recorrer la tabla y comparar cada posición (ya que la i es
		// cada vuelta) con la variable numBuscado que es el número que debo buscar en
		// mi matriz (tabla) de 100 números aleatorios, además.
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] == numBuscado) {
				// Cuando se cumpla el IF, me va a imprimir en pantalla en que posición se ha
				// encontrado, además de sumarle 1 a numerosEncontrados
				System.out.println("Encontrado en la posición: " + i);
				numerosEncontrados++;
			}
		}
		// Imprimo el mensaje final indicando el nº buscado, y el nº de veces que
		// aparece en mi array (tabla)
		System.out.println("El número " + numBuscado + " aparece " + numerosEncontrados + " veces en el array.");
		// Cierro el Scanner
		sc.close();

	}

}
