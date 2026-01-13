package arrays2d;

import java.util.Scanner;

public class Exercise03 {

	public static void main(String[] args) {
		// --- 1. Declaración de Variables ---
		Scanner sc = new Scanner(System.in);
		int filasUsuario;
		int columnasUsuario;

		// --- 2. Entrada de Datos ---
		System.out.println("Introduce el nº de filas de la tabla:");
		filasUsuario = sc.nextInt();

		System.out.println("Introduce el nº de columnas de la tabla:");
		columnasUsuario = sc.nextInt();

		// Inicializamos la tabla con las dimensiones que nos ha dado el usuario
		int[][] tabla = new int[filasUsuario][columnasUsuario];

		// --- 3. Lógica de Relleno (Proceso) ---
		// En este bloque SOLO rellenamos, no imprimimos nada.
		for (int i = 0; i < filasUsuario; i++) {
			for (int j = 0; j < columnasUsuario; j++) {
				// Aplicamos la fórmula del enunciado
				tabla[i][j] = 10 * i + j;
			}
		}

		// --- 4. Salida por Pantalla (Visualización) ---
		System.out.println("\n--- TABLA GENERADA ---");

		for (int i = 0; i < filasUsuario; i++) {
			for (int j = 0; j < columnasUsuario; j++) {
				// Usamos printf con "%5d" para que reserve 5 espacios.
				// Así, si sale un número de 1 cifra y otro de 2, la tabla no se tuerce.
				System.out.printf("%5d", tabla[i][j]);
			}
			// Importante: Salto de línea al terminar cada fila (fuera del bucle j)
			System.out.println();
		}

		// Siempre cerramos recursos
		sc.close();
	}
}