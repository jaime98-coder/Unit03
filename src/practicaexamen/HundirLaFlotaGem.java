package practicaexamen;

import java.util.Random;
import java.util.Scanner;

public class HundirLaFlotaGem {
	static char[][] tableroOculto = new char[5][5];
	static char[][] tableroVisible = new char[5][5];
	static final char NIEBLA = '.';
	static final char BARCO = 'B';
	static final char HUNDIDO = 'X';
	static final char FALLIDO = '-';
	static int torpedos = 10;
	static Random rd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int fila = -1;
		int columna = -1;
		boolean casillaValida = false;
		String respuesta;
		do {
			System.out.println("Bienvenidos al juego de Hundir La Flota Simplificado");
			System.out.println("Inicializando tablero...");
			torpedos = 10;
			inicializarTableros();
			while (torpedos > 0 && quedanBarcos() == true) {
				System.out.println("Torpedos restantes: " + torpedos);
				mostrarTablero(tableroVisible);
				casillaValida = false;
				while (!casillaValida) {
					System.out.println("Fila a la que deseas disparar");
					fila = sc.nextInt();
					System.out.println("Columna a la que deseas disparar");
					columna = sc.nextInt();
					if (fila >= 0 && fila <= 4 && columna >= 0 && columna <= 4) {

						casillaValida = true;
					} else {
						System.out.println("ERROR, introduce una casilla válida");
					}
				}
				// Disparo de torpedo
				dispararTorpedo(fila, columna);
				// Gasto de bala
				torpedos--;
				// Aviso cuando te quedes sin balas (inicialmente se tiene 10)
				if (torpedos == 0) {
					System.out.println("Te has quedado sin torpedos.");
				}

			}
			if (!quedanBarcos()) {
				System.out.println("VICTORIA");
			} else if (quedanBarcos() && torpedos == 0) {
				System.out.println("DERROTA");
				System.out.println("Mostrando tablero oculto para ver barcos restantes...");
				mostrarTablero(tableroOculto);
			}
			sc.nextLine();
			System.out.println("¿Deseas jugar otra partida? (S/N)");
			respuesta = sc.nextLine();
		} while (respuesta.equalsIgnoreCase("s"));
	}

	public static void inicializarTableros() {

		for (int i = 0; i < tableroOculto.length; i++) {
			for (int j = 0; j < tableroOculto[i].length; j++) {
				tableroOculto[i][j] = NIEBLA;
				tableroVisible[i][j] = NIEBLA;
			}
		}
		// Asignación aleatoria de posición de barco
		int barcosColocados = 0;
		int filaRd;
		int columnaRd;
		while (barcosColocados < 3) {
			filaRd = rd.nextInt(0, 5);
			columnaRd = rd.nextInt(0, 5);
			if (tableroOculto[filaRd][columnaRd]==NIEBLA) {
				tableroOculto[filaRd][columnaRd]=BARCO;
				barcosColocados++;
			}
		}

	}

	public static void mostrarTablero(char[][] tablero) {

		System.out.print("\t0\t1\t2\t3\t4");
		System.out.println();
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public static void dispararTorpedo(int fila, int columna) {

		if (tableroOculto[fila][columna] == BARCO) {
			tableroVisible[fila][columna] = HUNDIDO;
			tableroOculto[fila][columna] = HUNDIDO;
			System.out.println("BOOM! Barco hundido");
		} else if (tableroOculto[fila][columna] == NIEBLA) {
			tableroVisible[fila][columna] = FALLIDO;
			tableroOculto[fila][columna] = FALLIDO;
			System.out.println("¡Agua! Has fallado.");

		} else {
			System.out.println("Esa casilla ya fue disparada. Pierdes tu turno por inutil");
		}

	}

	public static boolean quedanBarcos() {
		for (int i = 0; i < tableroOculto.length; i++) {
			for (int j = 0; j < tableroOculto[i].length; j++) {
				if (tableroOculto[i][j] == BARCO) {
					return true;
				}
			}
		}
		return false;
	}

}
