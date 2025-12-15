package funciones;

import java.util.Scanner;

public class Exercise002 {
	// Diseñar la función: int maximo(int t[]), que devuelva
	// el máximo valor contenido en la tabla t.
	public static void main(String[] args) {
		int[] numeros = new int[5];
		System.out.println("Introduce 5 numeros enteros para saber cual es el máximo valor:");
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < numeros.length; i++) {
			System.out.print("Introduce el elemento " + (i + 1) + ": ");
			numeros[i] = sc.nextInt();
		}
		int maximoValor = maximo(numeros);
		System.out.println("Maximo = " + maximoValor);
		sc.close();
	}

	/**
	 * Devuelve el valor maximo de una tabla de enteros.
	 * 
	 * @param tabla de entrada (no puede ser null o estar vacia)
	 * @return valor maximo de la tabla
	 */
	public static int maximo(int tabla[]) {
		if (tabla == null || tabla.length == 0) {
			throw new IllegalArgumentException("La tabla no puede ser null o estar vacia.");
		}
		int maximoValor = tabla[0];
		// Ponemos indiceActual a 1 porque ya hemos cogido el valor de la posicion 0 en
		// maximoValor = tabla[0];
		for (int indiceActual = 1; indiceActual < tabla.length; indiceActual++) {
			if (tabla[indiceActual] > maximoValor) {
				maximoValor = tabla[indiceActual];
			}
		}

		return maximoValor;

	}

}
