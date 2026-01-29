package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloEzamen001_Arrays_B {

	// --- VARIABLES GLOBALES ---
	static char[][] tablero = new char[3][3];
	static Scanner sc = new Scanner(System.in);

	// Constantes para hacer el código más legible
	static final char USUARIO = 'X';
	static final char MAQUINA = 'O';
	static final char VACIO = '-';

	public static void main(String[] args) {
		boolean jugarOtraVez = true;

		System.out.println("¡BIENVENIDO AL TRES EN RAYA!");

		// Bucle principal para reiniciar la partida si el usuario quiere
		do {
			// 1. Preparar la partida
			limpiarTablero();
			int turno = jugadorInicial(); // 0 = Programa, 1 = Usuario
			boolean hayGanador = false;
			boolean empate = false;

			System.out.println("Sorteando turno...");
			if (turno == 1) {
				System.out.println("-> Comienzas tú (Usuario - X)");
			} else {
				System.out.println("-> Comienza el programa (Máquina - O)");
			}

			// 2. Bucle de la partida (turno a turno)
			while (!hayGanador && !empate) {
				
				// Imprimimos el estado actual
				imprimeTablero();

				if (turno == 1) {
					// --- TURNO USUARIO ---
					boolean movimientoValido = false;
					while (!movimientoValido) {
						try {
							System.out.println("Tu turno. Introduce Fila (0-2) y Columna (0-2) separadas por espacio:");
							int f = sc.nextInt();
							int c = sc.nextInt();

							// Llamamos a la función que valida y coloca la ficha
							if (usuarioMueveFicha(f, c)) {
								movimientoValido = true;
							} else {
								System.out.println("Posición no válida (ocupada o fuera de rango). Intenta de nuevo.");
							}
						} catch (java.util.InputMismatchException e) {
							System.out.println("Error: Debes introducir números enteros.");
							sc.nextLine(); // Limpiamos el buffer del scanner
						}
					}
					
					// Comprobamos si el usuario ha ganado con este movimiento
					if (esGanador(USUARIO)) {
						hayGanador = true;
						imprimeTablero();
						System.out.println("¡ENHORABUENA! ¡HAS GANADO!");
					}

				} else {
					// --- TURNO PROGRAMA ---
					System.out.println("Turno del Programa...");
										
					mueveFichaAleatoria();
					
					// Comprobamos si la máquina ha ganado
					if (esGanador(MAQUINA)) {
						hayGanador = true;
						imprimeTablero();
						System.out.println("¡LA MÁQUINA HA GANADO! Suerte la próxima vez.");
					}
				}

				// 3. Comprobar empate (si no hay ganador aún)
				if (!hayGanador) {
					if (tableroLleno()) {
						empate = true;
						imprimeTablero();
						System.out.println("¡EMPATE! El tablero está completo.");
					} else {
						// Cambiamos de turno para la siguiente vuelta
						// Si era 1 pasa a 0, si era 0 pasa a 1
						if (turno == 1) turno = 0;
						else turno = 1;
					}
				}
			} // Fin del while de la partida

			// Preguntar si quiere jugar otra vez
			System.out.println("\n¿Quieres jugar otra partida? (s/n):");
			char respuesta = sc.next().toLowerCase().charAt(0);
			if (respuesta != 's') {
				jugarOtraVez = false;
				System.out.println("¡ADIOS!");
			}

		} while (jugarOtraVez);
		
		sc.close();
	}

	// ---------------- MÉTODOS ----------------

	/**
	 * Inicializa el tablero poniendo '-' en todas las posiciones
	 */
	public static void limpiarTablero() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tablero[i][j] = VACIO;
			}
		}
	}

	/**
	 * Imprime el tablero con un formato visual claro
	 */
	public static void imprimeTablero() {
		System.out.println("\n  0 1 2");
		System.out.println(" -------");
		for (int i = 0; i < 3; i++) {
			System.out.print(i + "|");
			for (int j = 0; j < 3; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Devuelve 1 (Usuario) o 0 (Programa) al azar
	 */
	public static int jugadorInicial() {
		Random r = new Random();
		return r.nextInt(2); // Genera 0 o 1
	}

	/**
	 * Intenta colocar la ficha del usuario.
	 * Devuelve true si se pudo colocar, false si la posición no es válida.
	 */
	public static boolean usuarioMueveFicha(int f, int c) {
		// 1. Validar que las coordenadas estén dentro del tablero
		if (f >= 0 && f < 3 && c >= 0 && c < 3) {
			// 2. Validar que la casilla esté vacía
			if (tablero[f][c] == VACIO) {
				tablero[f][c] = USUARIO;
				return true;
			}
		}
		return false;
	}

	/**
	 * Genera coordenadas aleatorias hasta encontrar una libre para la máquina
	 */
	public static void mueveFichaAleatoria() {
		Random r = new Random();
		boolean fichaColocada = false;

		while (!fichaColocada) {
			int f = r.nextInt(3);
			int c = r.nextInt(3);

			if (tablero[f][c] == VACIO) {
				tablero[f][c] = MAQUINA;
				fichaColocada = true;
			}
		}
	}

	/**
	 * Comprueba todas las combinaciones ganadoras para una ficha dada ('X' u 'O')
	 */
	public static boolean esGanador(char ficha) {
		// 1. Comprobar Filas
		for (int i = 0; i < 3; i++) {
			if (tablero[i][0] == ficha && tablero[i][1] == ficha && tablero[i][2] == ficha) {
				return true;
			}
		}

		// 2. Comprobar Columnas
		for (int j = 0; j < 3; j++) {
			if (tablero[0][j] == ficha && tablero[1][j] == ficha && tablero[2][j] == ficha) {
				return true;
			}
		}

		// 3. Comprobar Diagonales
		// Diagonal principal
		if (tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) {
			return true;
		}
		// Diagonal inversa
		if (tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha) {
			return true;
		}

		return false;
	}

	/**
	 * Función auxiliar para saber si hay empate (tablero lleno sin ganador)
	 */
	public static boolean tableroLleno() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tablero[i][j] == VACIO) {
					return false; // Todavía queda al menos un hueco
				}
			}
		}
		return true; // No quedan huecos
	}
}