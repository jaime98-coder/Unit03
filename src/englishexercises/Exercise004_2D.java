package englishexercises;

import java.util.Random;
import java.util.Scanner;

public class Exercise004_2D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		// 1. Declaración de Constantes y Variables
		final int ROWS = 8; // Filas del tablero
		final int COLS = 8; // Columnas del tablero
		final int TOTAL_MINES = 10;
		final int MINE_CODE = -1;

		// Declaramos la matriz lógica (datos) y la visual (lo que se ve)
		int[][] board = new int[ROWS][COLS];
		boolean[][] isRevealed = new boolean[ROWS][COLS];

		int minesPlaced = 0;
		int rowRnd, colRnd; // Coordenadas aleatorias
		int userRow, userCol; // Coordenadas del usuario
		boolean isGameActive = true;

		System.out.println("--- MINESWEEPER 2D ---");

		// ---------------------------------------------------------
		// FASE 1: COLOCACIÓN DE MINAS
		// ---------------------------------------------------------

		while (minesPlaced < TOTAL_MINES) {
			// Generamos fila y columna aleatoria
			rowRnd = rd.nextInt(ROWS);
			colRnd = rd.nextInt(COLS);

			// Si la casilla está vacía (0), ponemos mina (-1)
			if (board[rowRnd][colRnd] != MINE_CODE) {
				board[rowRnd][colRnd] = MINE_CODE;
				minesPlaced++;
			}
		}

		// ---------------------------------------------------------
		// FASE 2: CÁLCULO DE PISTAS (El desafío de los 8 vecinos)
		// ---------------------------------------------------------

		// i: recorre filas
		for (int i = 0; i < ROWS; i++) {
			// j: recorre columnas
			for (int j = 0; j < COLS; j++) {

				// Si la celda actual es una mina, no calculamos nada
				if (board[i][j] == MINE_CODE) {
					continue;
				}

				int minesFound = 0;

				// BLOQUE DE VECINOS:
				// Recorremos desde la fila anterior (i-1) hasta la siguiente (i+1)
				// y desde la columna anterior (j-1) hasta la siguiente (j+1)
				for (int rowCheck = i - 1; rowCheck <= i + 1; rowCheck++) {
					for (int colCheck = j - 1; colCheck <= j + 1; colCheck++) {

						// VALIDACIÓN DE LÍMITES (La parte más importante):
						// Verificamos que 'rowCheck' y 'colCheck' estén DENTRO del tablero.
						// Si rowCheck es -1 o igual a ROWS, nos salimos del mapa.
						if (rowCheck >= 0 && rowCheck < ROWS && colCheck >= 0 && colCheck < COLS) {

							// Si encontramos una mina en ese vecino, sumamos
							if (board[rowCheck][colCheck] == MINE_CODE) {
								minesFound++;
							}
						}
					}
				}

				// Guardamos el número de minas encontradas en la celda actual
				board[i][j] = minesFound;
			}
		}

		// ---------------------------------------------------------
		// FASE 3: BUCLE DE JUEGO
		// ---------------------------------------------------------

		while (isGameActive) {

			// DIBUJAR TABLERO
			System.out.print("  "); // Espacio para cabecera de columnas
			// Imprimimos números de columnas arriba
			for (int j = 0; j < COLS; j++)
				System.out.print(j + " ");
			System.out.println();

			// Imprimimos filas
			for (int i = 0; i < ROWS; i++) {
				System.out.print(i + " "); // Número de fila a la izquierda
				for (int j = 0; j < COLS; j++) {
					if (isRevealed[i][j]) {
						if (board[i][j] == MINE_CODE)
							System.out.print("* ");
						else
							System.out.print(board[i][j] + " ");
					} else {
						System.out.print("? ");
					}
				}
				System.out.println(); // Salto de línea al terminar la fila
			}

			// PEDIR COORDENADAS
			System.out.println("\nEnter Row (0-" + (ROWS - 1) + "):");
			userRow = sc.nextInt();
			System.out.println("Enter Column (0-" + (COLS - 1) + "):");
			userCol = sc.nextInt();

			// VALIDACIÓN DE ENTRADA
			if (userRow >= 0 && userRow < ROWS && userCol >= 0 && userCol < COLS) {

				// Lógica de juego
				if (board[userRow][userCol] == MINE_CODE) {
					System.out.println("BOOOOM! Game Over.");
					isRevealed[userRow][userCol] = true;
					isGameActive = false; // Fin
				} else {
					// Revelamos la casilla
					isRevealed[userRow][userCol] = true;
					// Aquí podríamos añadir lógica para ganar (si revela todas las seguras)
				}

			} else {
				System.out.println("Invalid coordinates.");
			}
		}

		sc.close();
	}
}