package arraysexercises02;

import java.util.Scanner;

public class Exercise04 {
	// Necesitamos crear un programa para mostrar el ranking de puntuaciones
	// de un torneo de ajedrez con 8 jugadores. Se le pedirá al usuario que
	// introduzca las puntuaciones de todos los jugadores (habitualmente valores
	// entre 1000 y 2800, de tipo entero) y luego muestre las puntuaciones en orden
	// descendente (de la más alta a la más baja).
	public static void main(String[] args) {
		System.out.println("Sistema de Puntuaciones del torneo de ajedrez:");
		int[] puntuaciones = new int[4];
		//variable auxiliar
		
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < puntuaciones.length; i++) {
			System.out.print("Introduce los puntos del jugador "+(i+1)+": ");
			puntuaciones[i] = sc.nextInt();
			while (puntuaciones[i] < 1000 || puntuaciones[i] > 2800) {
				System.out.println("Por favor, introduce una puntuación válida");
				puntuaciones[i] = sc.nextInt();
			}
			
			
			System.out.println("Puntos jugador " + (i + 1) + ": " + puntuaciones[i]);
		}
		
		System.out.println("Tabla de puntos");
		// Ordenar el array de mayor a menor
		for (int i = 0; i < puntuaciones.length - 1; i++) {
			for (int j = i + 1; j < puntuaciones.length; j++) {
				if (puntuaciones[i] < puntuaciones[j]) {
					// Intercambiar valores
					int puntosAux = puntuaciones[i];
					puntuaciones[i] = puntuaciones[j];
					puntuaciones[j] = puntosAux;
				}
			}
		}
		// Mostrar el array ordenado
		for (int i = 0; i < puntuaciones.length; i++) {
			System.out.println("Puesto " + (i + 1) + ": " + puntuaciones[i] + " puntos");
		}

		sc.close();
	}

}
