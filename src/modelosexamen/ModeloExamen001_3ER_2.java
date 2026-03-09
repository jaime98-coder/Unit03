package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloExamen001_3ER_2 {
	static char FICHA_USUARIO = 'X';
	static char FICHA_CPU = 'O';
	static char CASILLA_VACIA = '-';
	static char[][] tablero = new char[3][3];
	static Random rd = new Random();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Variable esEmpate para cuando el tablero se llene
		boolean esEmpate;
		int contadorFichas = 0;
		boolean hayGanador;
		int filaUsuario;
		int columnaUsuario;
		boolean movimientoValido = false;
		String respuesta;

		// Variable para controlar los turnos. 1 = jugador. 0 = cpu.
		int monedaTurnos;
		do {
			// Reset de booleanos para que cuando se inicie otra partida tras finalizar,
			// funcionen correctamente los bucles
			contadorFichas = 0;
			esEmpate = false;
			hayGanador = false;
			// Asignación inicial para ver quien empieza
			System.out.println("--------------------------------------------------");
			System.out.println("--------BIENVENIDO AL JUEGO DEL 3 EN RAYA---------");
			System.out.println("--------------------------------------------------");
			System.out.println();
			System.out.println("Preparando el tablero...");
			limpiarTablero();
			System.out.println("Tirando moneda para decidir quien comienza...");
			monedaTurnos = jugadorInicial();
			while (!hayGanador && !esEmpate) {
				// TURNO DEL USUARIO
				if (monedaTurnos == 1) {
					// Reseteo el boolean movimientoValido en el inicio de cada turno
					movimientoValido = false;
					System.out.println("Turno del usuario");
					while (!movimientoValido) {
						try {
							System.out.println("Introduce la fila donde quieres colocar ficha...");
							filaUsuario = sc.nextInt();
							System.out.println("Introduce la columna donde quieres colocar ficha...");
							columnaUsuario = sc.nextInt();
							// Mientras sea true el método con sus condiciones correctas y la fila y columna
							// no se salga de los limites del tablero
							if (filaUsuario >= 0 && filaUsuario < 3 && columnaUsuario >= 0 && columnaUsuario < 3
									&& usuarioMueveFicha(filaUsuario, columnaUsuario)) {
								System.out.println("Usuario coloca ficha correctamente");
								movimientoValido = true;
								imprimeTablero();
							} else {
								System.out.println("Error, introduce una casilla válida");
							}
						} catch (Exception e) {

							System.out.println("ERROR: ¡Debes introducir números enteros!");
							sc.nextLine();
						}
					}
					// Sumo 1 al contador de fichas, ya que la ficha se colocó correctamente
					contadorFichas++;
					// Comprobación de si USUARIO es ganador al final
					hayGanador = esGanador(FICHA_USUARIO);
					if (!hayGanador) {
						// Paso al turno de la CPU para que entre en el ELSE
						monedaTurnos = 0;
					}
				} else {

					System.out.println("Turno de la CPU");
					mueveFichaAleatoria();
					imprimeTablero();
					contadorFichas++;

					// Comprobación de si la CPU ha ganado
					hayGanador = esGanador(FICHA_CPU);
					if (!hayGanador) {
						// Paso al turno de la CPU para que entre en el ELSE
						monedaTurnos = 1;
					}
				}
				// Lógica de empate para asi poder salir del bucle, aunque no muestre quien gana
				// hasta despues de salir de este
				if (contadorFichas == 9) {

					esEmpate = true;
				}
			}
			if (hayGanador && monedaTurnos == 1) {
				System.out.println("¡¡Ha ganado el usuario!!");
			} else if (hayGanador && monedaTurnos == 0) {
				System.out.println("¡¡Ha ganado la CPU!!");

			} else {
				if (contadorFichas == 9) {
					System.out.println("-----------¡Empate!----------");
					System.out.println("Ningún jugador hizo 3 en raya");

				}
			}
			sc.nextLine();
			System.out.println("¿Quieres jugar otra partida? (S/N)");
			respuesta = sc.nextLine();
		} while (respuesta.equalsIgnoreCase("S"));
		System.out.println("Gracias por haber jugado al 3 EN RAYA");
		System.out.println("¡ADIOS!");
		sc.close();
	}

	/**
	 * Función para imprimir el tablero
	 */
	public static void imprimeTablero() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
			System.out.println();
		}

	}

	/**
	 * Función para limpiar tablero, poniendo todas las casillas a CASILLA_VACIA (-)
	 */
	public static void limpiarTablero() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tablero[i][j] = CASILLA_VACIA;
			}
		}
	}

	/**
	 * 
	 * @return numero entero. 1 --> Comienza Jugador. 0 --> Comienza CPU
	 */
	public static int jugadorInicial() {
		int numeroAleatorio;
		numeroAleatorio = rd.nextInt(2);

		return numeroAleatorio;
	}

	/**
	 * Método para que la CPU coloque ficha de forma aleatoria (siempre y cuando no
	 * esté ya ocupada esa casilla)
	 * 
	 * @param tablero
	 */
	public static void mueveFichaAleatoria() {
		int filaAleatoria;
		int columnaAleatoria;
		boolean estaOcupada = true;
		// Lógica para repetir si está ocupada la casilla
		while (estaOcupada) {
			// Para generar posicion aleatoria en fila y columna (la longitud del tablero es
			// 3x3)
			filaAleatoria = rd.nextInt(tablero.length);
			columnaAleatoria = rd.nextInt(tablero[0].length);
			// Suponemos que está ocupada para forzar a entrar al bucle while

			if (tablero[filaAleatoria][columnaAleatoria] == CASILLA_VACIA) {
				// Asigno la ficha de la cpu a la fila y columna aleatoria
				tablero[filaAleatoria][columnaAleatoria] = FICHA_CPU;
				System.out.println("CPU coloca ficha correctamente");
				estaOcupada = false;
			} else {
				System.out.println("La CPU intentó colocar su ficha en una casilla ocupada");
				System.out.println("Repitiendo movimiento...");
				estaOcupada = true;
			}
		}

	}

	/**
	 * Método para que el usuario coloque ficha
	 * 
	 * @param filaUsuario
	 * @param columnaUsuario
	 * @return booleano donde true = se coloca ficha (posicion válida) y false =
	 *         posición no válida
	 */
	public static boolean usuarioMueveFicha(int filaUsuario, int columnaUsuario) {
		boolean posicionValida = false;

		if (tablero[filaUsuario][columnaUsuario] == CASILLA_VACIA) {
			tablero[filaUsuario][columnaUsuario] = FICHA_USUARIO;
			posicionValida = true;
		}

		return posicionValida;
	}

	/**
	 * Método para almacenar la lógica de victoria
	 * 
	 * @param ficha
	 * @return true = ganó la ficha introducida por parametro de entrada. false = no
	 *         ganó la ficha introducida
	 */
	public static boolean esGanador(char ficha) {
		boolean hayGanador = false;
		// Comprobación de casillas verticalmente (arriba a abajo)
		for (int i = 0; i < tablero.length && !hayGanador; i++) {
			if (tablero[0][i] == ficha && tablero[1][i] == ficha && tablero[2][i] == ficha) {
				hayGanador = true;
			}
		}
		// Comprobación de casillas horizontalmente (arriba a abajo)
		for (int j = 0; j < tablero.length && !hayGanador; j++) {
			if (tablero[j][0] == ficha && tablero[j][1] == ficha && tablero[j][2] == ficha) {
				hayGanador = true;
			}
		}
		if (!hayGanador) {
			// Comprobación de casillas en diagonal 1 y 2
			if (tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) {
				hayGanador = true;
			} else if (tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha) {
				hayGanador = true;
			}

		}
		return hayGanador;
	}

}
