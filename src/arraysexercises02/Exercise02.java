package arraysexercises02;

import java.util.Scanner;

public class Exercise02 {
	// Crea un programa que pida al usuario 20 valores enteros e introduzca los 10
	// primeros en un array y los 10 últimos en otro array. Por último, comparará
	// ambos arrays y le dirá al usuario si son iguales o no.
	public static void main(String[] args) {
		// 1. Declaración de variables primitivas
		boolean sonIguales = true;
		// Variable auxiliar para almacenar temporalmente lo que el usuario escribe
		int numeroLeido;

		Scanner sc = new Scanner(System.in);

		// 2. Declaración de los arrays contextualizada
		// Declaramos ambos arrays vacíos esperando ser llenados
		int[] array1 = new int[10];
		int[] array2 = new int[10];

		System.out.println("Introduce 20 números enteros (los 10 primeros irán al Array1 y los 10 siguientes al Array2):");

		// Iterador 'i': Recorre las 20 entradas totales que vamos a solicitar
		for (int i = 0; i < 20; i++) {
			System.out.print("Número " + (i + 1) + ": ");
			numeroLeido = sc.nextInt();

			// Condicional para decidir en qué array guardar el dato
			if (i < 10) {
				// Estamos en los primeros 10 números (índices 0 al 9)
				array1[i] = numeroLeido;
			} else {
				// Estamos en los siguientes 10 números (índices 10 al 19)
				// Usamos (i - 10) para convertir el índice 10 en 0, el 11 en 1, etc.
				array2[i - 10] = numeroLeido;
			}
		}
		// --- Impresión de los arrays1 y 2 ---
		System.out.println("Array 1:");
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + " ");
		}
		System.out.println();
		System.out.println("Array 2:");
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " ");
		}
		System.out.println();

		// --- Comparación (Esta parte se mantiene igual de bien que antes) ---

		// Iterador 'i': Recorre ambos arrays para comparar posición a posición
		for (int i = 0; i < array1.length && sonIguales; i++) {
			if (array1[i] != array2[i]) {
				sonIguales = false;
			}
		}

		if (sonIguales) {
			System.out.println("Los arrays son iguales");
		} else {
			System.out.println("Los arrays no son iguales");
		}

		sc.close();
	}
}