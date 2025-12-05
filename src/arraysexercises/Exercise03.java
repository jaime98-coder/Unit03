package arraysexercises;

import java.util.Scanner;

public class Exercise03 {

	public static void main(String[] args) {

		// --- 1. Declaración de variables ---

		// Declaro el array de 10 posiciones.
		// Es preferible usar double[] numeros en lugar de double numeros[].
		double[] numeros = new double[10];

		// Inicializo el Scanner
		Scanner sc = new Scanner(System.in);

		// --- 2. Entrada de datos (Llenar el array) ---

		// Bucle para leer los 10 números
		for (int i = 0; i < numeros.length; i++) {
			// Añado un espacio en el texto para que se lea mejor en consola
			System.out.println("Introduce el número de la posición " + i + "/9:");

			numeros[i] = sc.nextDouble();
		}

		// --- 3. Salida de datos (Orden inverso) ---

		System.out.println("Los números en orden inverso son:");

		// CORRECCIÓN IMPORTANTE:
		// Inicializamos 'i' en (numeros.length - 1) para apuntar a la última casilla
		// (índice 9).
		// La condición es i >= 0 para que llegue hasta la primera casilla (índice 0).
		for (int i = numeros.length - 1; i >= 0; i--) {
			System.out.print(numeros[i] + " ");
		}

		// --- 4. Cierre de recursos ---
		sc.close();
	}
}