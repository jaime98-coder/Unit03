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
		int[] puntuaciones = new int[8];
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
		for (int i=0; i<puntuaciones.length;i++) {
			
			System.out.print("Puntos del jugador"+(i+1)+": "+puntuaciones[i]);
		}

		sc.close();
	}

}
