package collections;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise001 {

	/**
	 * Crear una lista de números enteros positivos introducidos por consola hasta
	 * que se introduzca uno negativo. A continuación, recorrer la lista y mostrar
	 * por pantalla los índices de los elementos de valor par.
	 */
	public static void main(String[] args) {
		// Variable inicializada para permitir la entrada al bucle while
		boolean esPositivo = true;
		// Declaración de variable primitiva en la parte superior del main
		int numEntrada;

		// Declaración e inicialización del Scanner en la misma línea
		Scanner sc = new Scanner(System.in);

		// Declaración e inicialización de la lista justo antes de empezar a usarla
		ArrayList<Integer> listaPositivos = new ArrayList<>();

		System.out.println("Introduce números enteros positivos");

		while (esPositivo) {
			numEntrada = sc.nextInt();

			if (numEntrada >= 0) {
				listaPositivos.add(numEntrada);
			} else {
				System.out.println("Has introducido un número negativo.");
				System.out.println("Fin de la inserción...");
				esPositivo = false;
			}
		}

		System.out.println("Índices de los elementos de valor par:");
		// Llamada al método que se encarga de la lógica de búsqueda e impresión
		mostrarIndicesPares(listaPositivos);

		// Cierre obligatorio de los recursos
		sc.close();
	}

	// Método auxiliar para buscar e imprimir. Recibe la lista ya tipada.
	public static void mostrarIndicesPares(ArrayList<Integer> listaPositivos) {
		// El contador i representa el índice actual dentro del recorrido de la lista
		for (int i = 0; i < listaPositivos.size(); i++) {
			// Usamos el método .get(i) para obtener el valor y ver si es par
			if (listaPositivos.get(i) % 2 == 0) {
				// Imprimimos el índice (i), no el valor
				System.out.print(i + "\t");
			}
		}
		System.out.println();
	}

}