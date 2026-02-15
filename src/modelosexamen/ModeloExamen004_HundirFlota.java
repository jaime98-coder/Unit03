package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloExamen004_HundirFlota {
	static final char OCULTA = '-';
	static final char BARCO = 'B';
	static final char AGUA = 'A';

	static char[][] tablero;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int filasTablero;
		int columnasTablero;
		char[][] tableroJ1;
		char[][] tableroJ2;
		int numBarquitosAuto;
		boolean turnoAcabado = false;
		System.out.println("Bienvenidos al Hundir la Flota");
		System.out.println("Introduce tamaño del tablero");
		System.out.print("Número de filas:");
		filasTablero = sc.nextInt();
		System.out.println("Número de columnas:");
		columnasTablero = sc.nextInt();
		tablero = inicializaTablero(filasTablero, columnasTablero);
		// Variable dnde almacenaré la lógica del numero de barcos con la raiz cuadrada
		// de filas*columnas
		numBarquitosAuto = (int) Math.sqrt(filasTablero * columnasTablero);

		// Creando tableros de Jugador 1 y Jugador 2

		tableroJ1 = creaTablero(filasTablero, columnasTablero);
		tableroJ2 = creaTablero(filasTablero, columnasTablero);

		// Generando los barcos de Jugador 1 y Jugador 2
		System.out.println("Generando barquitos...");
		generarBarquitos(tableroJ1, numBarquitosAuto);
		generarBarquitos(tableroJ2, numBarquitosAuto);
//		Prueba pintando
//		System.out.println("J1");
//		pintaTablero(tableroJ1);
//		System.out.println("J2");
//		pintaTablero(tableroJ2);
		// Turno del jugador 1

		int filaDisparo;
		int columnaDisparo;
		pintaTablero(tableroJ2);
		System.out.println("Turno del JUGADOR 1");
		// POR AQUI VOYYYYY -----------------------------------------------------------------------
		while (turnoJugador(tablero, tableroJ1)) {

		}

	}

	public static char[][] inicializaTablero(int filas, int columnas) {
		tablero = new char[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = OCULTA;
			}
		}
		// Establezco el tamaño introducido por el usuario
		return tablero;
	}

	public static char[][] creaTablero(int filas, int columnas) {
		tablero = new char[filas][columnas];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = AGUA;
			}
		}
		return tablero;
	}

	/**
	 * 
	 * @param tablero.      Donde se colocaran los barquitos a hundir
	 * @param numBarquitos. Se debe colocar tantos barcos como indique.
	 * 
	 */
	public static void generarBarquitos(char[][] tablero, int numBarquitos) {
		Random rd = new Random();

		while (numBarquitos != 0) {
			int filaRd = rd.nextInt(tablero.length);
			int columnaRd = rd.nextInt(tablero.length);
			if (tablero[filaRd][columnaRd] == BARCO) {
				System.out.println("Máquina intenta colocar en posición con barco, repitiendo...");
			} else {
				tablero[filaRd][columnaRd] = BARCO;
				numBarquitos--;

			}
		}

	}

	public static void pintaTablero(char tableroJugador[][]) {

		for (int i = 0; i < tableroJugador.length; i++) {

			for (int j = 0; j < tableroJugador[i].length; j++) {
				System.out.print(tableroJugador[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * @param tablero.
	 * @param tableroJugador.
	 * @return true si el jugador descubre un barco (B). false si hay agua (A).
	 * 
	 */
	public static boolean turnoJugador(char tablero[][], char tableroJugador[][]) {
		Scanner sc = new Scanner(System.in);
		int fila;
		int columna;
		System.out.println("Selecciona donde crees que hay un barco para disparar");
		System.out.print("Fila");
		fila = sc.nextInt();
		System.out.print("Columna");
		columna = sc.nextInt();
		if (tablero[fila][columna] == BARCO) {
			tablero[fila][columna] = BARCO;
			tableroJugador[fila][columna] = BARCO;

			System.out.println("BOOM. Barco hundido");
			return true;
		} else {
			tablero[fila][columna] = AGUA;
			tableroJugador[fila][columna] = AGUA;
			System.out.println("AGUAAAA");
			return false;
		}

	}

}
