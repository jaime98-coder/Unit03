package arraysexercises02;

import java.util.Random;

public class Exercise06 {
	/*
	 * Realiza un programa que cree dos tablas, la primera con los 6 números de una
	 * apuesta de la primitiva generados aleatoriamente entre 1 y 49 y, la segunda
	 * (ordenada) con los 6 números de la combinación ganadora. La combinación
	 * ganadora debe establecerse en el momento de crear la tabla. El programa
	 * devolverá el número de aciertos.
	 */
	public static void main(String[] args) {
		// --- 1. Declaración de Variables Primitivas (Siempre arriba) ---
		// Contador de aciertos totales
		int numAciertos = 0;
		// Bandera para controlar el bucle sin usar break
		boolean encontrado;

		// --- 2. Instanciación de Objetos ---
		Random aleatorio = new Random();

		// --- 3. Lógica del Array Apuesta ---
		// Array para guardar los números de la apuesta
		int[] apuesta = new int[6];

		// Iterador para recorrer las posiciones de la apuesta
		for (int i = 0; i < apuesta.length; i++) {
			// Generamos del 1 al 49 (Forma compatible con todas las versiones de Java)
			apuesta[i] = aleatorio.nextInt(1, 50);
		}

		// --- 4. Lógica del Cupón Ganador ---
		// Array inicializado manualmente y ORDENADO (requisito del enunciado)
		int[] cuponGanador = { 2, 6, 7, 9, 38, 41 };

		// --- 5. Proceso de Comprobación ---
		// Iterador para recorrer cada número de mi apuesta
		for (int i = 0; i < apuesta.length; i++) {

			// Reiniciamos la bandera antes de buscar el número actual
			encontrado = false;

			// Iterador para recorrer el cupón ganador
			// La condición !encontrado optimiza el bucle (simulando un break limpio)
			for (int j = 0; j < cuponGanador.length && !encontrado; j++) {
				if (apuesta[i] == cuponGanador[j]) {
					numAciertos++;
					encontrado = true;
				}
			}
		}

		// --- 6. Salida de Datos ---
		System.out.println("Número apostado:");
		// Iterador para imprimir la apuesta
		for (int i = 0; i < apuesta.length; i++) {
			System.out.print(apuesta[i] + " ");
		}

		System.out.println(); // Salto de línea para separar

		System.out.println("Número cupón ganador:");
		// Iterador para imprimir el cupón ganador
		for (int i = 0; i < cuponGanador.length; i++) {
			System.out.print(cuponGanador[i] + " ");
		}

		System.out.println();
		System.out.println("Número de aciertos: " + numAciertos);
	}

}
