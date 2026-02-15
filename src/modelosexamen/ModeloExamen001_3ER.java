package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloExamen001_3ER {
	static final char USUARIO = 'X';
	static final char CPU = 'O';
	static final char VACIO = '-';
	static final char[][] tablero = new char[3][3];
	static Random rd = new Random();
	static int numFichasColocadas = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean hayGanador = false;
		boolean esEmpate = false;
		int turno;
		boolean jugarOtraVez = true;
		char respuestaJugarOtraVez;
		int filaUsuario;
		int columnaUsuario;
		boolean jugadaValida = false;

		System.out.println("---------- 3 EN RAYA ----------");
		do {
			hayGanador = false;
			numFichasColocadas = 0;
			System.out.println("Bienvenidos a una nueva partida");
			turno = jugadorInicial();

			if (turno == 1) {
				System.out.println("Comienza el usuario");

			} else {
				System.out.println("Comienza la CPU");

			}
			System.out.println("Preparando tablero...");
			limpiarTablero();
			while (!hayGanador && !esEmpate) {

				imprimeTablero();
				if (turno == 1) {
					jugadaValida = false;
					// Turno del usuario
					System.out.println("Turno del usuario");
					System.out.println("Introduce fila y columna donde quieres colocar la ficha");
					while (!jugadaValida) {
						System.out.print("Fila: ");
						filaUsuario = sc.nextInt();
						System.out.print("Columna: ");
						columnaUsuario = sc.nextInt();

						if (usuarioMueveFicha(filaUsuario, columnaUsuario)) {
							jugadaValida = true;
						} else {
							jugadaValida = false;
							System.out.println("Error. Casilla ocupada o datos incorrectos");
						}
					}

					if (esGanador(USUARIO)) {
						hayGanador = true;
						System.out.println("¡GANA EL USUARIO!");
					}
					numFichasColocadas++;

				} else {
					// Turno de la CPU

					System.out.println("Turno de la CPU");
					System.out.println("CPU colocando ficha...");
					mueveFichaAleatoria();
					imprimeTablero();
					System.out.println("Ficha colocada");
					
					if (esGanador(CPU)) {
						hayGanador = true;
						System.out.println("¡GANA LA CPU!");

					}
					numFichasColocadas++;
				}
				// Comprobación para paso de turno
				

				if (!hayGanador) {
					if (empate()) {
						esEmpate = true;
						System.out.println("¡EMPATE!");
					} else {
						esEmpate = false;
					}
					if (turno == 1) {
						turno = 0;
					} else {
						turno = 1;
					}

				}

			}
			System.out.println("Fin de la partida");
			System.out.println("¿Deseas jugar de nuevo? S/N");
			respuestaJugarOtraVez = sc.next().toLowerCase().charAt(0);
			if (respuestaJugarOtraVez == 's') {
				jugarOtraVez = true;
				System.out.println("Comenzando de nuevo partida...");
			} else {
				jugarOtraVez = false;
				System.out.println("¡Fin de la partida!");

			}

		} while (jugarOtraVez);
		System.out.println("Gracias por jugar");

		sc.close();
	}

	public static void limpiarTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = VACIO;
			}
		}

	}

	public static void imprimeTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static int jugadorInicial() {
		int jugadorInicial;
		jugadorInicial = rd.nextInt(0, 2);
		return jugadorInicial;
	}

	public static void mueveFichaAleatoria() {

		boolean jugadaValida = false;

		while (!jugadaValida) {
			int filaRd = rd.nextInt(0, 3);
			int columnaRd = rd.nextInt(0, 3);
			if (tablero[filaRd][columnaRd] == VACIO) {
				tablero[filaRd][columnaRd] = CPU;
				jugadaValida = true;
			}
		}

	}

	public static boolean usuarioMueveFicha(int fila, int columna) {
		boolean jugadaValida = false;

		if (tablero[fila][columna] == VACIO && (fila >= 0 && fila < 3 && columna >= 0 && columna < 3)) {
			tablero[fila][columna] = USUARIO;
			jugadaValida = true;
		}
		return jugadaValida;
	}

	public static boolean esGanador(char fichaGanadora) {
		// Comprobación de filas y columnas
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[i][0] == fichaGanadora && tablero[i][1] == fichaGanadora && tablero[i][2] == fichaGanadora) {
				return true;
			}
			if (tablero[0][i] == fichaGanadora && tablero[1][i] == fichaGanadora && tablero[2][i] == fichaGanadora) {
				return true;
			}
		}

		// Comprobación de diagonal Principal (de arriba-izq a abajo-der)
		if (tablero[0][0] == fichaGanadora && tablero[1][1] == fichaGanadora && tablero[2][2] == fichaGanadora) {
			return true;
		}

		// Comprobación de diagonal inversa (de arriba-der a abajo-izq)
		if (tablero[0][2] == fichaGanadora && tablero[1][1] == fichaGanadora && tablero[2][0] == fichaGanadora) {
			return true;
		}
		return false;

	}

	public static boolean empate() {
		// Devuelve true si llegamos a 9 fichas, false si no.
		return numFichasColocadas == 9;

	}

}
