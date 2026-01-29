package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloEzamen004_Arrays_B {

	// Scanner estático para poder usarlo en todas las funciones
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("=== HUNDIR LA FLOTA ===");
		
		// 1. Configuración del Tablero
		System.out.println("Introduce el número de FILAS:");
		int filas = sc.nextInt();
		
		System.out.println("Introduce el número de COLUMNAS:");
		int cols = sc.nextInt();
		
		// 2. Creación e inicialización de tableros
		// Tablero MAESTRO (donde están los barcos ocultos)
		char[][] tableroJuego = creaTablero(filas, cols);
		
		// Tableros de los JUGADORES (lo que ellos ven)
		char[][] tableroJ1 = inicializaTablero(filas, cols);
		char[][] tableroJ2 = inicializaTablero(filas, cols);
		
		// 3. Generación de Barcos
		int numBarcos = (int) Math.sqrt(filas * cols); // Fórmula del enunciado
		System.out.println("Generando " + numBarcos + " barcos en el mar...");
		generarBarquitos(tableroJuego, numBarcos);
		
		// 4. Variables de control del juego
		int barcosHundidosJ1 = 0;
		int barcosHundidosJ2 = 0;
		boolean turnoJ1 = true; // true = J1, false = J2
		boolean juegoTerminado = false;

		// 5. Bucle Principal
		while (!juegoTerminado) {
			
			System.out.println("\n------------------------------------------------");
			if (turnoJ1) {
				System.out.println("TURNO JUGADOR 1 (Barcos hundidos: " + barcosHundidosJ1 + "/" + numBarcos + ")");
				pintaTablero(tableroJ1);
				
				// La función devuelve true si toca barco (repite turno) o false si es agua (pierde turno)
				boolean haAcertado = turnoJugador(tableroJuego, tableroJ1);
				
				if (haAcertado) {
					// Comprobamos si ya hemos contado este barco antes para no sumar doble
					// (Aunque la lógica del enunciado implica descubrir, asumimos que si acierta suma)
					// Para hacerlo perfecto, deberíamos chequear si esa casilla YA estaba descubierta antes,
					// pero seguiremos la lógica simple: si acierta un barco, suma punto.
					barcosHundidosJ1++;
					if (barcosHundidosJ1 == numBarcos) {
						System.out.println("¡JUGADOR 1 HA HUNDIDO TODOS LOS BARCOS!");
						juegoTerminado = true;
					}
				} else {
					turnoJ1 = false; // Cambio de turno
					System.out.println("¡Fallo! Turno para el Jugador 2.");
				}
				
			} else {
				System.out.println("TURNO JUGADOR 2 (Barcos hundidos: " + barcosHundidosJ2 + "/" + numBarcos + ")");
				pintaTablero(tableroJ2);
				
				boolean haAcertado = turnoJugador(tableroJuego, tableroJ2);
				
				if (haAcertado) {
					barcosHundidosJ2++;
					if (barcosHundidosJ2 == numBarcos) {
						System.out.println("¡JUGADOR 2 HA HUNDIDO TODOS LOS BARCOS!");
						juegoTerminado = true;
					}
				} else {
					turnoJ1 = true; // Cambio de turno
					System.out.println("¡Fallo! Turno para el Jugador 1.");
				}
			}
		}
		
		System.out.println("---FIN DEL JUEGO---");
		sc.close();
	}

	// ---------------- MÉTODOS SOLICITADOS ----------------

	/**
	 * Crea el tablero del jugador relleno de guiones '-'
	 */
	public static char[][] inicializaTablero(int filas, int columnas) {
		char[][] t = new char[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				t[i][j] = '-';
			}
		}
		return t;
	}

	/**
	 * Crea el tablero maestro relleno de agua 'A'
	 */
	public static char[][] creaTablero(int filas, int columnas) {
		char[][] t = new char[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				t[i][j] = 'A';
			}
		}
		return t;
	}

	/**
	 * Coloca los barcos 'B' aleatoriamente sin repetir posición
	 */
	public static void generarBarquitos(char tablero[][], int numBarquitos) {
		Random r = new Random();
		int barcosColocados = 0;
		
		while (barcosColocados < numBarquitos) {
			int f = r.nextInt(tablero.length);
			int c = r.nextInt(tablero[0].length);
			
			// Solo colocamos si hay agua ('A')
			if (tablero[f][c] == 'A') {
				tablero[f][c] = 'B';
				barcosColocados++;
			}
		}
	}

	/**
	 * Imprime el tablero con cabeceras numéricas y letras laterales
	 * 1 2 3 4
	 * A - - - -
	 * B - - - -
	 */
	public static void pintaTablero(char tableroJugador[][]) {
		// 1. Imprimir cabecera de números
		System.out.print("  "); // Espacio para la letra de la fila
		for (int k = 1; k <= tableroJugador[0].length; k++) {
			System.out.print(k + " ");
		}
		System.out.println(); // Salto después de la cabecera
		
		// 2. Imprimir filas con su letra
		for (int i = 0; i < tableroJugador.length; i++) {
			// Convertimos índice 0 -> 'A', 1 -> 'B', etc.
			char letraFila = (char) ('A' + i);
			System.out.print(letraFila + " ");
			
			for (int j = 0; j < tableroJugador[i].length; j++) {
				System.out.print(tableroJugador[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Gestiona el disparo del usuario. 
	 * Pide coordenadas, valida, descubre la casilla y devuelve si acertó.
	 */
	public static boolean turnoJugador(char tablero[][], char tableroJugador[][]) {
		int filaIndex = -1;
		int colIndex = -1;
		boolean coordenadasValidas = false;

		// Bucle para asegurar que mete coordenadas dentro del rango
		while (!coordenadasValidas) {
			try {
				System.out.println("Introduzca la fila mediante una letra (ej: A):");
				char letra = sc.next().toUpperCase().charAt(0);
				
				System.out.println("Introduzca el número de columna:");
				int numero = sc.nextInt();
				
				// --- CONVERSIÓN DE COORDENADAS ---
				// De Letra a Índice: 'A' - 'A' = 0; 'B' - 'A' = 1...
				filaIndex = letra - 'A';
				// De Número a Índice: El usuario ve 1, el array empieza en 0
				colIndex = numero - 1;
				
				// Validamos que esté dentro del tablero
				if (filaIndex >= 0 && filaIndex < tablero.length && 
					colIndex >= 0 && colIndex < tablero[0].length) {
					
					// Comprobamos si la casilla YA estaba descubierta (opcional pero recomendable)
					if (tableroJugador[filaIndex][colIndex] != '-') {
						System.out.println("¡Ya habías disparado ahí! Elige otra.");
					} else {
						coordenadasValidas = true;
					}
				} else {
					System.out.println("Coordenadas fuera del tablero. Intenta de nuevo.");
				}
				
			} catch (Exception e) {
				System.out.println("Error de entrada. Introduce letra y número válidos.");
				sc.nextLine(); // Limpiar buffer
			}
		}

		// --- LÓGICA DE ACIERTO O FALLO ---
		char contenidoReal = tablero[filaIndex][colIndex];
		
		// Actualizamos el tablero del jugador con lo que había en el tablero maestro
		tableroJugador[filaIndex][colIndex] = contenidoReal;
		
		if (contenidoReal == 'B') {
			System.out.println("¡HUNDIDO!");
			return true; // Repite turno / Acierto
		} else {
			System.out.println("AGUA...");
			return false; // Pierde turno
		}
	}

}