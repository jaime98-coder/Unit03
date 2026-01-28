package modelosexamen;

import java.util.Scanner;
import java.util.Random;

public class ModeloExamen001_Arrays_Repeat {

	// --- CONSTANTES Y VARIABLES GLOBALES ---
	static final int FILAS_TABLERO = 3;
	static final int COLUMNAS_TABLERO = 3;

	// Fichas
	static final char FICHA_USUARIO = 'X';
	static final char FICHA_PROGRAMA = 'O';
	static final char CASILLA_VACIA = '-';

	// Tablero (se inicializa en el main o métodos)
	static char[][] tablero = new char[FILAS_TABLERO][COLUMNAS_TABLERO];

	// Herramientas compartidas
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();

	// ---------------------------------------------------------

	public static void main(String[] args) {
		// --- DECLARACIÓN DE VARIABLES PRIMITIVAS (MAIN) ---
		// Control de la sesión de juego
		boolean jugarOtraVez = true;
		boolean partidaTerminada;
		boolean hayGanador;
		boolean empate;

		// Control de turnos (1 = Usuario, 0 = Programa)
		int turnoActual;

		// Entradas del usuario
		int filaUsuario;
		int colUsuario;
		boolean movimientoValido;

		// Respuesta para reiniciar
		String respuestaUsuario;

		// --- INICIO DEL PROGRAMA ---
		System.out.println("--- BIENVENIDO AL TRES EN RAYA ---");

		// Bucle principal de la sesión (permite jugar varias partidas)
		while (jugarOtraVez) {

			// 1. Configuración inicial de la partida
			limpiarTablero();
			partidaTerminada = false;
			hayGanador = false;
			empate = false;

			// Determinamos quién empieza
			turnoActual = jugadorInicial();

			if (turnoActual == 1) {
				System.out.println("Comienza el usuario (" + FICHA_USUARIO + ")");
			} else {
				System.out.println("Comienza el programa (" + FICHA_PROGRAMA + ")");
			}

			imprimeTablero();

			// 2. Bucle de la partida (turno a turno)
			while (!partidaTerminada) {

				if (turnoActual == 1) {
					// --- TURNO USUARIO ---
					System.out.println("\nTu turno. Introduce coordenadas.");
					movimientoValido = false;

					// Bucle de validación de entrada
					while (!movimientoValido) {
						try {
							System.out.print("Fila (0-2): ");
							filaUsuario = sc.nextInt();
							System.out.print("Columna (0-2): ");
							colUsuario = sc.nextInt();

							// Intentamos mover
							movimientoValido = usuarioMueveFicha(filaUsuario, colUsuario);

							if (!movimientoValido) {
								System.out.println(
										"Movimiento no válido (casilla ocupada o fuera de rango). Intenta de nuevo.");
							}
						} catch (java.util.InputMismatchException e) {
							System.out.println("Error: Introduce números enteros.");
							sc.nextLine(); // Limpiar buffer
						}
					}

				} else {
					// --- TURNO PROGRAMA ---
					System.out.println("\nTurno del Programa...");
					mueveFichaAleatoria();
				}

				// 3. Actualización y comprobaciones tras el movimiento
				imprimeTablero();

				// Comprobamos si el jugador actual ha ganado
				if (turnoActual == 1) {
					hayGanador = esGanador(FICHA_USUARIO);
				} else {
					hayGanador = esGanador(FICHA_PROGRAMA);
				}

				// Verificamos condiciones de fin
				if (hayGanador) {
					partidaTerminada = true;
					if (turnoActual == 1) {
						System.out.println("\n¡ENHORABUENA! ¡HAS GANADO!");
					} else {
						System.out.println("\n¡EL PROGRAMA HA GANADO! Suerte la próxima vez.");
					}
				} else {
					// Si no hay ganador, miramos si hay empate (tablero lleno)
					// Nota: Podríamos hacer una función 'tableroLleno', pero 'limpiarTablero'
					// devuelve void.
					// Lo comprobaremos recorriendo o contando jugadas. Aquí usaré una comprobación
					// rápida.
					if (comprobarEmpate()) {
						partidaTerminada = true;
						empate = true;
						System.out.println("\n¡EMPATE! El tablero está completo.");
					} else {
						// Si no ha terminado, cambiamos el turno
						// Si era 1 pasa a 0, si era 0 pasa a 1
						if (turnoActual == 1) {
							turnoActual = 0;
						} else {
							turnoActual = 1;
						}
					}
				}
			} // Fin bucle partida

			// 4. Preguntar si quiere jugar otra vez
			System.out.println("\n¿Quieres jugar otra vez? (s/n):");
			respuestaUsuario = sc.next();

			if (respuestaUsuario.equalsIgnoreCase("s")) {
				jugarOtraVez = true;
			} else {
				jugarOtraVez = false;
				System.out.println("¡ADIOS! Gracias por jugar.");
			}

		} // Fin bucle sesión

		sc.close();
	}

	// ---------------------------------------------------------
	// --- MÉTODOS ---
	// ---------------------------------------------------------

	public static void limpiarTablero() {
		// Recorremos filas
		for (int i = 0; i < FILAS_TABLERO; i++) {
			// Recorremos columnas
			for (int j = 0; j < COLUMNAS_TABLERO; j++) {
				tablero[i][j] = CASILLA_VACIA;
			}
		}
	}

	public static void imprimeTablero() {
		System.out.println("  0 1 2");
		// Recorremos filas
		for (int i = 0; i < FILAS_TABLERO; i++) {
			System.out.print(i + " ");
			// Recorremos columnas
			for (int j = 0; j < COLUMNAS_TABLERO; j++) {
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

	public static boolean usuarioMueveFicha(int fila, int columna) {
		boolean exito = false;

		// Primero validamos que las coordenadas estén dentro del rango
		if (fila >= 0 && fila < FILAS_TABLERO && columna >= 0 && columna < COLUMNAS_TABLERO) {
			// Después validamos que la casilla esté vacía
			if (tablero[fila][columna] == CASILLA_VACIA) {
				tablero[fila][columna] = FICHA_USUARIO;
				exito = true;
			}
		}
		return exito;
	}

	public static void mueveFichaAleatoria() {
		boolean casillaValidaPrograma;
		int fRandom;
		int cRandom;

		// Lógica de "pensar" una casilla vacía
		do {
			fRandom = rd.nextInt(FILAS_TABLERO);
			cRandom = rd.nextInt(COLUMNAS_TABLERO);

			if (tablero[fRandom][cRandom] == CASILLA_VACIA) {
				casillaValidaPrograma = true;
			} else {
				casillaValidaPrograma = false;
			}
		} while (!casillaValidaPrograma);

		// Asignación final
		tablero[fRandom][cRandom] = FICHA_PROGRAMA;
		System.out.println("El programa ha marcado: " + fRandom + "," + cRandom);
	}

	// Método auxiliar para no ensuciar el main
	public static boolean comprobarEmpate() {
		boolean lleno = true;
		// Recorremos filas buscando huecos
		for (int i = 0; i < FILAS_TABLERO; i++) {
			// Recorremos columnas
			for (int j = 0; j < COLUMNAS_TABLERO; j++) {
				if (tablero[i][j] == CASILLA_VACIA) {
					lleno = false; // Aún queda hueco
				}
			}
		}
		return lleno;
	}

	public static boolean esGanador(char ficha) {
		boolean haGanado = false;

		// 1. Comprobar Filas
		// Variable contador i para filas
		for (int i = 0; i < FILAS_TABLERO; i++) {
			if (tablero[i][0] == ficha && tablero[i][1] == ficha && tablero[i][2] == ficha) {
				haGanado = true;
			}
		}

		// 2. Comprobar Columnas (solo si no ha ganado ya)
		if (!haGanado) {
			// Variable contador j para columnas
			for (int j = 0; j < COLUMNAS_TABLERO; j++) {
				if (tablero[0][j] == ficha && tablero[1][j] == ficha && tablero[2][j] == ficha) {
					haGanado = true;
				}
			}
		}

		// 3. Comprobar Diagonales (solo si no ha ganado ya)
		if (!haGanado) {
			// Diagonal principal
			if (tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) {
				haGanado = true;
			}
			// Diagonal inversa
			if (tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha) {
				haGanado = true;
			}
		}

		return haGanado;
	}
}