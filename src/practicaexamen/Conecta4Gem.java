package practicaexamen;

import java.util.Scanner;

public class Conecta4Gem {
	static final char VACIO = '.';
	static final char FICHAJ1 = 'X';
	static final char FICHAJ2 = 'O';

	public static void main(String[] args) {
		char[][] tablero = new char[6][7];
		Scanner sc = new Scanner(System.in);
		int columna = 0;
		boolean finalTurno = false;
		// TURNO == 1 --> J1 || TURNO == 2 --> J2
		int turno = 1;
		boolean finPartida = false;
		inicializarTablero(tablero);
		boolean columnaValida = false;
		System.out.println("---------------------------Comienza el juego---------------------------");
		System.out.println("Comienza el J1");
		while (!finPartida && !tableroLleno(tablero)) {
			mostrarTablero(tablero);
			

			if (turno == 1) {
				// Reset de las banderas
				finalTurno=false;
				columnaValida = false;
				while (!finalTurno) {
					System.out.println("Turno: J1");
					while (!columnaValida) {
						System.out.println("Elige la columna donde quieres colocar la ficha");
						columna = sc.nextInt();
						if (columna >= 0 && columna <= 6) {
							columnaValida = true;

						} else {
							System.out.println("Error. elige una columna entre 0 y 6");
							columnaValida = false;
						}
					}
					if (insertarFicha(tablero, columna, FICHAJ1)) {
						if (comprobarGanador(tablero, FICHAJ1)) {
							finPartida = true;
						}
						if (tableroLleno(tablero)) {
							finPartida = true;
						}

						finalTurno = true;
					} else {
						System.out.println("La columna está llena, elige otra columna");
						finalTurno = false;
						// Se resetea bandera para que no se quede en true al haber introducido una columna válida
						columnaValida = false;
					}
				}
				
				turno = 2;
			}
			
			else if (turno == 2 && !finPartida) {
				// Reset de las banderas
				finalTurno=false;
				columnaValida = false;
				while (!finalTurno) {
					System.out.println("Turno: J2");
					while (!columnaValida) {
						System.out.println("Jugador 2. elige la columna donde quieres colocar la ficha");
						columna = sc.nextInt();
						if (columna >= 0 && columna <= 6) {
							columnaValida = true;
							if (comprobarGanador(tablero, FICHAJ2)) {
								finPartida = true;
							}
							if (tableroLleno(tablero)) {
								finPartida = true;
							}

						} else {
							System.out.println("Error. elige una columna entre 0 y 6");
							columnaValida = false;
						}
					}
					if (insertarFicha(tablero, columna, FICHAJ2)) {
						finalTurno = true;
					} else {
						System.out.println("La columna está llena, elige otra columna");
						finalTurno = false;
					}
				}
				mostrarTablero(tablero);
				turno = 1;
			}

		}

	}

	static void inicializarTablero(char[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = VACIO;

			}
		}
	}

	static void mostrarTablero(char[][] tablero) {
		System.out.println("---------------------Tablero---------------------");
		System.out.println("0\t1\t2\t3\t4\t5\t6");

		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + "\t");

			}

			System.out.println();
		}

	}

	static boolean insertarFicha(char[][] tablero, int columna, char fichaDelTurno) {
		boolean jugadaValida = false;
		
			for (int i = tablero.length - 1; i >= 0; i--) {
				if (tablero[i][columna] == VACIO) {
					tablero[i][columna] = fichaDelTurno;
					System.out.println("Ficha colocada correctamente");
					jugadaValida = true;
					break;
				}
			}
		

		
		return jugadaValida;

	}

	static boolean comprobarGanador(char[][] tablero, char ficha) {
		boolean hayGanador = false;
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				
				// FRENO HORIZONTAL: ¿Si le sumo 3 a la columna actual, me salgo del tablero?
				// Solo comprobamos si j+3 es menor que el número total de columnas (7)
				if (j + 3 < tablero[i].length) {
					if (tablero[i][j] == ficha && tablero[i][j + 1] == ficha && tablero[i][j + 2] == ficha && tablero[i][j + 3] == ficha) {
						System.out.println("¡El jugador con la ficha " + ficha + " es el GANADOR!");
						System.out.println("Conecta 4 en horizontal");
						hayGanador = true;
						mostrarTablero(tablero);
					}
				}
				
				// FRENO VERTICAL: ¿Si le sumo 3 a la fila actual, me salgo por abajo?
				// Solo comprobamos si i+3 es menor que el número total de filas (6)
				if (i + 3 < tablero.length) {
					if (tablero[i][j] == ficha && tablero[i + 1][j] == ficha && tablero[i + 2][j] == ficha && tablero[i + 3][j] == ficha) {
						System.out.println("¡El jugador con la ficha " + ficha + " es el GANADOR!");
						System.out.println("Conecta 4 en vertical");
						hayGanador = true;
						mostrarTablero(tablero);
					}
				}
			}
		}
		return hayGanador;
	}

	static boolean tableroLleno(char[][] tablero) {
		boolean tableroLleno = true;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == VACIO) {

					tableroLleno = false;
				}
			}
		}

		return tableroLleno;
	}

}
