package practicaexamen;

import java.util.Random;
import java.util.Scanner;

public class JardineroVSPlaga {
	static char[][] jardin = new char[6][6];
	static final char JARDINERO = 'F';
	static final char MALEZA = 'M';
	static final char SUELO_VACIO = '.';

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// String de respuesta respecto a si quiere jugar otra partida
		String respuesta = "";
		boolean finPartida = false;
		boolean jugarOtraPartida = false;

		do {
			finPartida = false;
			// Reglas del juego
			System.out.println("Bienvenidos al juego de Jardinero VS Plaga ");
			System.out.println("Gana el que tenga más flores o maleza plantada en el jardin completo.");
			System.out.println(
					"Si el hueco está ocupado por el contrincante, se vaciará, sino, se colocará una planta/maleza");
			System.out.println("----------------------------------");
			System.out.println("Inicializando Jardin...");

			inicializarJardin();
			// Se muestra el jardín
			mostrarJardin();
			System.out.println("----------------------------------");
			do {

				// Usuario juega su turno
				System.out.println("Turno del jardinero");

				if (turnoJardinero()) {
					contarFlores();

				}
				// Comprobación para ve sis e ha llenado tras la acción del usuario
				if (jardinCompleto()) {
					finPartida = true;
				} else {
					System.out.println("Turno de la plaga");
					turnoPlaga();
					contarMaleza();
					mostrarJardin();
					if (jardinCompleto()) {
						finPartida = true;
					}
				}

			} while (!finPartida && !jardinCompleto());
			System.out.println("--------- Recuento final ---------");
			System.out.println("Flores del jardinero: " + contarFlores());
			System.out.println("Maleza en el jardin: " + contarMaleza());
			// Lógica de victoria
			if (contarFlores() > contarMaleza()) {
				System.out.println("Gana el jardinero");
			} else if (contarMaleza() > contarFlores()) {
				System.out.println("Gana la plaga");
			} else {
				System.out.println("Empate");
			}
			System.out.println("----------------------------------");
			System.out.println("Fin de la partida");
			sc.nextLine();
			System.out.println("¿Desea jugar otra partida? (s/n)");
			respuesta = sc.nextLine();
			if (respuesta.equalsIgnoreCase("s")) {
				jugarOtraPartida = true;
			} else {
				jugarOtraPartida = false;
			}
		} while (jugarOtraPartida);
		System.out.println("Fin del programa");
		sc.close();
	}

	/**
	 * Función para iniciar el jardin con . (ni plantas ni maleza)
	 */
	static void inicializarJardin() {
		for (int i = 0; i < jardin.length; i++) {
			for (int j = 0; j < jardin[i].length; j++) {
				jardin[i][j] = '.';
			}
		}

	}

	/**
	 * Función para mostrar el estado actual del jardin
	 */
	static void mostrarJardin() {
		for (int i = 0; i < jardin.length; i++) {
			for (int j = 0; j < jardin[i].length; j++) {
				System.out.print(jardin[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * Función para contar las flores que hay actualmente en el jardím
	 * 
	 * @return entero, conteo de las flores
	 */
	static int contarFlores() {
		int contadorFlores = 0;
		for (int i = 0; i < jardin.length; i++) {
			for (int j = 0; j < jardin[i].length; j++) {
				if (jardin[i][j] == JARDINERO) {
					contadorFlores++;
				}
			}
		}
		return contadorFlores;
	}

	/**
	 * Función para contar maleza que hay actualmente en el jardím
	 * 
	 * @return entero, conteo de la maleza
	 */
	static int contarMaleza() {
		int contadorMaleza = 0;
		for (int i = 0; i < jardin.length; i++) {
			for (int j = 0; j < jardin[i].length; j++) {
				if (jardin[i][j] == MALEZA) {
					contadorMaleza++;
				}
			}
		}
		return contadorMaleza;
	}

	/**
	 * Método que indica la acción del jardinero
	 * 
	 * @return booleano cuando se complete el fin de turno del jardinero
	 */
	static boolean turnoJardinero() {
		int fila;
		int columna;
		boolean jugadaValida;
		do {
			System.out.println("Introduce la fila donde deseas plantar una flor");
			fila = sc.nextInt();
			System.out.println("Introduce la columna donde deseas plantar una flor");
			columna = sc.nextInt();
			if (fila < 0 || fila >= jardin.length || columna < 0 || columna >= jardin[0].length) {
				System.out.println("Error. Por favor introduce una posición válida (0-5)");
				jugadaValida = false;
			} else {
				if (jardin[fila][columna] == SUELO_VACIO) {
					jardin[fila][columna] = JARDINERO;
					System.out
							.println("Has colocado una flor (F) en las posiciones ( " + fila + " - " + columna + " )");
					jugadaValida = true;
				}
				// Revisar si tengo que restar al contador de maleza, haciendolo previamente
				// variable global.
				else if (jardin[fila][columna] == MALEZA) {
					jardin[fila][columna] = SUELO_VACIO;
					System.out.println("Has ARRANCADO MALEZA de las posiciones ( " + fila + " - " + columna + " )");
					jugadaValida = true;

				} else {
					System.out.println("Error. Ya hay una flor en esta posición, seleccione otra fila y columna");
					jugadaValida = false;
				}
			}

		} while (!jugadaValida);
		// Fin de accion del jardi
		System.out.println("Fin de la acción del jardinero");
		return jugadaValida;
	}

	/**
	 * Método que indica la acción de la plaga
	 * 
	 * @return booleano cuando se complete el fin de turno de la plaga
	 */
	public static void turnoPlaga() {
		Random rd = new Random();
		int fila;
		int columna;
		boolean jugadaValida;
		do {
			fila = rd.nextInt(0, jardin.length);
			columna = rd.nextInt(0, jardin[0].length);

			if (jardin[fila][columna] == SUELO_VACIO) {
				jardin[fila][columna] = MALEZA;
				System.out.println("Plaga planta maleza en las posiciones ( " + fila + " - " + columna + " )");
				jugadaValida = true;
			} else if (jardin[fila][columna] == JARDINERO) {
				jardin[fila][columna] = SUELO_VACIO;
				System.out.println("La plaga se comío la flor de la posición ( " + fila + " - " + columna + " )");
				jugadaValida = true;
			} else {
				System.out.println(
						"La plaga intentó crecer maleza donde ya había... Se produce otro movimiento de la plaga");
				jugadaValida = false;
			}
		} while (!jugadaValida);

	}

	/**
	 * Método que indica que el jardín esta completo.
	 * 
	 * @return booleano cuando se complete el jardin
	 */
	public static boolean jardinCompleto() {
		boolean huecoVacio = false;
		for (int i = 0; i < jardin.length; i++) {
			for (int j = 0; j < jardin[i].length; j++) {
				if (jardin[i][j] == SUELO_VACIO) {

					huecoVacio = true;

				}
			}
		}
		return !huecoVacio;

	}

}
