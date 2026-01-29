package practicaexamen;

import java.util.Random;
import java.util.Scanner;

public class PracticaExamen01 {
	static Random rd = new Random();
	static Scanner sc = new Scanner(System.in);

	static char[][] tablero = new char[3][3];
	static final char FICHA_JUGADOR = 'X';
	static final char FICHA_CPU = 'O';
	static final char VACIO = '-';

	public static void main(String[] args) {
		boolean jugarDeNuevo;
		String respuesta;
		boolean hayGanador = false;

		do {
			System.out.println("----- ¡Bienvenido al 3 en raya! -----");
			hayGanador = false;

			int turno;
			System.out.println("¿Quien comenzará...?");
			// Para decidir quien comienza (1 es jugador, 0 es CPU)
			turno = jugadorInicial();
			if (turno == 1) {
				System.out.println("Comienza el jugador");
			} else {
				System.out.println("Comienza la CPU");
			}

			limpiarTablero();
			imprimeTablero();
			boolean empate = false;
			while (!hayGanador && !empate) {

				if (turno == 1) {
					System.out.println("Turno del jugador");
					boolean jugadaValida = false;
					while (!jugadaValida) {
						System.out.println("Elige la fila donde quieres poner la ficha (0-2)");
						int fila = sc.nextInt();
						System.out.println("Elige la columna donde quieres poner la ficha (0-2)");
						int columna = sc.nextInt();
						// Validacion de la jugada del jugador
						if (usuarioMueveFicha(fila, columna)) {
							jugadaValida = true;
						} else {
							System.out.println("Jugada no válida");
							jugadaValida = false;
						}
					}
					imprimeTablero();
					// Comprobacion de si hay ganador
					if (esGanador(FICHA_JUGADOR)) {
						hayGanador = true;
						System.out.println("Enhorabuena has ganado");
					}

				} else {
					System.out.println("Turno de la máquina");
					// Movimiento de la CPU
					mueveFichaAleatoria();
					imprimeTablero();
					if (esGanador(FICHA_CPU)) {
						hayGanador = true;
						System.out.println("La máquina ha ganado");
					}

				}
				if (!hayGanador) {
					if (tableroLleno()) {
						empate = true;
						imprimeTablero();
						System.out.println("El tablero está lleno. Empate");
					}
				}
				if (!hayGanador) {
					if (turno == 1) {
						turno = 0;
					} else if (turno == 0) {
						turno = 1;
					}

				}
			}

			// Lógica para que se repita el juego
			System.out.println("¿Quieres jugar de nuevo? (S/N)");
			sc.nextLine();
			respuesta = sc.nextLine();
			if (respuesta.equalsIgnoreCase("S")) {
				jugarDeNuevo = true;
			} else {
				jugarDeNuevo = false;
				System.out.println("¡Hasta la próxima!");
			}
		} while (jugarDeNuevo);

	}

	// Inicializar y limpiar tablero
	public static void limpiarTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = VACIO;
			}
		}
	}

	public static void imprimeTablero() {
		System.out.println("\n  0 1 2");
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(i + "|");
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int jugadorInicial() {
		int jugadorInicial;
		jugadorInicial = rd.nextInt(2);
		return jugadorInicial;
	}

	public static void mueveFichaAleatoria() {
		boolean fichaColocada = false;
		while (!fichaColocada) {
			int fila = rd.nextInt(0, 3);
			int columna = rd.nextInt(0, 3);
			if (tablero[fila][columna] == VACIO) {
				tablero[fila][columna] = FICHA_CPU;
				fichaColocada = true;
			}
		}
	}

	public static boolean usuarioMueveFicha(int fila, int columna) {
		boolean fichaColocada = false;

		if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3) {
			if (tablero[fila][columna] == VACIO) {
				tablero[fila][columna] = FICHA_JUGADOR;
				fichaColocada = true;
			}
		}
		return fichaColocada;

	}

	public static boolean esGanador(char ficha) {

		// Para comprobar filas
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[i][0] == ficha && tablero[i][1] == ficha && tablero[i][2] == ficha) {
				return true;
			}
		}
		// Para comprobar columnas
		for (int j = 0; j < tablero.length; j++) {
			if (tablero[0][j] == ficha && tablero[1][j] == ficha && tablero[2][j] == ficha) {
				return true;
			}
		}

		// Para comprobar diagonal
		if (tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) {
			return true;
		}

		// Para comprobar diagonal inversa
		if (tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha) {
			return true;
		}

		return false;
	}

	public static boolean tableroLleno() {
		boolean estaLleno = true;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == VACIO) {
					estaLleno = false;
				}
			}
		}
		return estaLleno;
	}
}
