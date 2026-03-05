package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloExamen001_AlmacenGem {

	static final char LOTE_MANUAL = 'M';
	static final char LOTE_AUTOMATICO = 'A';
	static final char CUADRICULA_VACIA = '-';
	static Random rd = new Random();

	public static void main(String[] args) {
		char[][] planoAlmacen = new char[3][3];
		int numeroAsignadorTurnos;
		int filaUsuario;
		int columnaUsuario;
		// Booleano para almacenar cuando uno de los dos consiga consolidar (alineando)
		// 3 lotes se ponga true
		boolean estaConsolidado = false;
		// Booleano para cuando no quepan mas lotes en el almacen. Y contador para que
		// cuando llegue a 9 (lo máximo que cabe en el tablero) pueda aplicar lógica de
		// empate
		boolean estaAlmacenLleno = false;
		int contadorLotesColocados = 0;

		boolean esCorrectoMovimiento = false;
		String respuesta = "";
		Scanner sc = new Scanner(System.in);

		do {
			// Reseteo de variables de control
			estaConsolidado = false;
			estaAlmacenLleno = false;
			contadorLotesColocados = 0;

			System.out.println("¡¡Bienvenid@ al Sistema de Gestión!!");
			System.out.println("Comenzando...");
			// Inicializando almacen con -
			limpiarAlmacen(planoAlmacen);
			System.out.println("Eligiendo turnos...");
			// 1 --> Comienza Operario. 0 --> Comienza Sistema
			numeroAsignadorTurnos = asignadorInicial();
			// Bucle para que se repita siempre que no esté consolidado y no esté el almacen
			// lleno
			while (!estaConsolidado && !estaAlmacenLleno) {

				if (numeroAsignadorTurnos == 1) {
					esCorrectoMovimiento = false;

					System.out.println("Turno del Operario");
					imprimeAlmacen(planoAlmacen);
					while (!esCorrectoMovimiento) {
						System.out.println("Introduce la fila donde quieres colocar el lote");
						filaUsuario = sc.nextInt();
						System.out.println("Introduce la columna donde quieres colocar el lote");
						columnaUsuario = sc.nextInt();
						// Lógica de control para que se coloque si la fila o columna introducida se
						// sale del límite del almacen y es correcto el movimiento (cuadricula no
						// ocupada)
						if (filaUsuario >= 0 && filaUsuario < planoAlmacen.length && columnaUsuario >= 0
								&& columnaUsuario < planoAlmacen.length
								&& operarioAsignaLote(filaUsuario, columnaUsuario, planoAlmacen)) {

							System.out.println("Lote colocado correctamente por el usuario en [ " + filaUsuario + " - "
									+ columnaUsuario + " ]");
							esCorrectoMovimiento = true;
							contadorLotesColocados++;

						} else {
							System.out.println("Cuadrícula no válida, intentalo de nuevo");
						}
					}
					// Comprobación de si el operario ha consolidado
					if (esZonaConsolidada(LOTE_MANUAL, planoAlmacen)) {
						estaConsolidado = true;
					} else {
						System.out.println("Pasando el turno al sistema...");
						numeroAsignadorTurnos = 0;
					}
				} else {
					System.out.println("Turno del Sistema");
					imprimeAlmacen(planoAlmacen);
					// Función para asignar un lote aleatorio
					asignaLoteAleatorio(planoAlmacen);
					contadorLotesColocados++;
					// Comprobación de si el sistema ha consolidado
					if (esZonaConsolidada(LOTE_AUTOMATICO, planoAlmacen)) {
						estaConsolidado = true;
					} else {
						System.out.println("Pasando el turno al operario...");
						numeroAsignadorTurnos = 1;
					}
				}
				if (contadorLotesColocados == 9) {
					estaAlmacenLleno = true;
				}
			}
			// Mensaje de victoria e impresion final del tablero
			imprimeAlmacen(planoAlmacen);
			if (estaConsolidado && numeroAsignadorTurnos == 1) {
				System.out.println("GANA EL OPERARIO");
			} else if (estaConsolidado && numeroAsignadorTurnos == 0) {
				System.out.println("GANA EL SISTEMA");
			} else {
				System.out.println("EMPATE, ALMACEN LLENO");
			}
			sc.nextLine();
			System.out.println("¿Quieres jugar otra partida? (S/N)");
			respuesta = sc.nextLine();
		} while (respuesta.equalsIgnoreCase("S"));
		System.out.println("¡¡ADIOS, HASTA LA PRÓXIMA!!");
		sc.close();
	}

	public static void limpiarAlmacen(char[][] planoAlmacen) {
		for (int i = 0; i < planoAlmacen.length; i++) {
			for (int j = 0; j < planoAlmacen[i].length; j++) {
				planoAlmacen[i][j] = CUADRICULA_VACIA;
			}
		}
	}

	public static void imprimeAlmacen(char[][] planoAlmacen) {
		for (int i = 0; i < planoAlmacen.length; i++) {
			for (int j = 0; j < planoAlmacen[i].length; j++) {
				System.out.print(planoAlmacen[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * Elige aleatoriamente quien comienza a colocar lotes en el planoAlmacen.
	 * 
	 * @return int 1 --> comienza operario. 2--> comienza sistema
	 */
	public static int asignadorInicial() {
		return rd.nextInt(2);
	}

	/**
	 * Lógica donde el sistema coloca aleatoriamente un lote en el plano del almacen
	 * 
	 * @param planoAlmacen
	 */
	public static void asignaLoteAleatorio(char[][] planoAlmacen) {
		int filaAleatoria;
		int columnaAleatoria;
		boolean estaOcupada = true;
		// Lógica para que se repita el bucle siempre que esté ocupada la posición
		while (estaOcupada) {
			filaAleatoria = rd.nextInt(planoAlmacen.length);
			columnaAleatoria = rd.nextInt(planoAlmacen[0].length);
			// Si esta vacia, el sistema coloca un lote en esa posición
			if (planoAlmacen[filaAleatoria][columnaAleatoria] == CUADRICULA_VACIA) {
				planoAlmacen[filaAleatoria][columnaAleatoria] = LOTE_AUTOMATICO;
				estaOcupada = false;
			} else {
				System.out.println("Cuadricula ocupada... Volviendo a intentar");
				estaOcupada = true;

			}
		}
	}

	/**
	 * Lógica para que el operario asigne lote
	 * 
	 * @param filaOperario
	 * @param columnaOperario
	 * @param planoAlmacen
	 * @return un booleano donde true --> lote colocado. flase --> lote no colocado.
	 */
	public static boolean operarioAsignaLote(int filaOperario, int columnaOperario, char[][] planoAlmacen) {
		boolean estaLoteAsignado = false;

		if (planoAlmacen[filaOperario][columnaOperario] == CUADRICULA_VACIA) {
			planoAlmacen[filaOperario][columnaOperario] = LOTE_MANUAL;
			estaLoteAsignado = true;
		}
		return estaLoteAsignado;

	}

	/**
	 * Función para recoger la lógica de victoria
	 * 
	 * @param tipoLote      . Puede ser LOTE_MANUAL o LOTE_AUTOMATICO
	 * @param planoAlmacen. El plano para poder comprobarlo
	 * @return true --> victoria del tipoLote (usuario o sistema)
	 */
	public static boolean esZonaConsolidada(char tipoLote, char[][] planoAlmacen) {
		boolean haConsolidado = false;
		for (int i = 0; i < planoAlmacen.length && !haConsolidado; i++) {
			// Comprobación vertical
			if (planoAlmacen[0][i] == tipoLote && planoAlmacen[1][i] == tipoLote && planoAlmacen[2][i] == tipoLote) {
				haConsolidado = true;
			}

		}
		for (int i = 0; i < planoAlmacen.length && !haConsolidado; i++) {
			// Comprobación horizontal
			if ((planoAlmacen[i][0] == tipoLote && planoAlmacen[i][1] == tipoLote && planoAlmacen[i][2] == tipoLote)) {
				haConsolidado = true;
			}

		}
		// Comprobación diagonales 1 y 2
		if (!haConsolidado && planoAlmacen[0][0] == tipoLote && planoAlmacen[1][1] == tipoLote
				&& planoAlmacen[2][2] == tipoLote) {
			haConsolidado = true;
		} else if (!haConsolidado && planoAlmacen[0][2] == tipoLote && planoAlmacen[1][1] == tipoLote
				&& planoAlmacen[2][0] == tipoLote) {
			haConsolidado = true;

		}
		return haConsolidado;
	}

}
