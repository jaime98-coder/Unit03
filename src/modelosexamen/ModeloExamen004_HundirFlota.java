package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloExamen004_HundirFlota {
	static final char OCULTA = '-';
	static final char BARCO = 'B';
	static final char AGUA = 'A';

	static Scanner sc = new Scanner(System.in);
	// CORRECCIÓN: Borrada la variable global barquitosHundidos. No sirve aquí.

	public static void main(String[] args) {
		char[][] tablero; // Tablero SOLUCIÓN
		int filasTablero;
		int columnasTablero;
		char[][] tableroJ1; // Cuaderno J1
		char[][] tableroJ2; // Cuaderno J2
		int numBarquitosAuto;
		boolean finPartida = false;
		
		// CORRECCIÓN: Contadores individuales para la carrera
		int aciertosJ1 = 0;
		int aciertosJ2 = 0;

		System.out.println("Bienvenidos al Hundir la Flota");
		System.out.println("Introduce tamaño del tablero");
		System.out.print("Número de filas:");
		filasTablero = sc.nextInt();
		System.out.println("Número de columnas:");
		columnasTablero = sc.nextInt();
		
		// 1. Crear tableros
		tablero = creaTablero(filasTablero, columnasTablero); // Solución llena de AGUA
		tableroJ1 = inicializaTablero(filasTablero, columnasTablero); // J1 lleno de '-'
		tableroJ2 = inicializaTablero(filasTablero, columnasTablero); // J2 lleno de '-'

		// 2. Calcular barcos
		numBarquitosAuto = (int) Math.sqrt(filasTablero * columnasTablero);
		System.out.println("Se esconderan " + numBarquitosAuto + " barcos en total");

		// 3. Generar barcos (SOLO EN LA SOLUCIÓN)
		System.out.println("La máquina está escondiendo los barcos...");
		generarBarquitos(tablero, numBarquitosAuto);

		// Pinta la solución solo para tus pruebas (borrar en examen)
		System.out.println("--- SOLUCIÓN (SPOILER) ---");
		pintaTablero(tablero); 
		System.out.println("--------------------------");

		// CORRECCIÓN: Variables para controlar los turnos dentro del bucle
		boolean turnoDelJugadorActivo; 
		
		// CORRECCIÓN: Bucle principal. Juegan MIENTRAS no haya fin de partida.
		while (!finPartida) {
			
			// --- TURNO JUGADOR 1 ---
			System.out.println("\nTURNO DEL JUGADOR 1 (Llevas " + aciertosJ1 + " aciertos)");
			pintaTablero(tableroJ1); // Mostramos SU tablero
			turnoDelJugadorActivo = true; // Empieza su turno
			
			// Mientras acierte y la partida no haya acabado...
			while (turnoDelJugadorActivo && !finPartida) {
				// CORRECCIÓN: Pasamos tablero (solución) y tableroJ1 (su cuaderno)
				if (turnoJugador(tablero, tableroJ1)) {
					System.out.println("¡TOCADO! Vuelves a disparar.");
					aciertosJ1++; // Sumamos punto
					
					// Comprobamos victoria INMEDIATAMENTE
					if (aciertosJ1 == numBarquitosAuto) {
						System.out.println("¡JUGADOR 1 GANA LA PARTIDA!");
						finPartida = true;
					}
				} else {
					// Ha fallado
					turnoDelJugadorActivo = false; // Se acaba su turno
				}
			}

			// --- TURNO JUGADOR 2 ---
			// Solo juega si el J1 no ha ganado ya
			if (!finPartida) {
				System.out.println("\nTURNO DEL JUGADOR 2 (Llevas " + aciertosJ2 + " aciertos)");
				pintaTablero(tableroJ2); // Mostramos SU tablero
				turnoDelJugadorActivo = true;
				
				while (turnoDelJugadorActivo && !finPartida) {
					// CORRECCIÓN: Pasamos tablero (solución) y tableroJ2 (su cuaderno)
					if (turnoJugador(tablero, tableroJ2)) {
						System.out.println("¡TOCADO! Vuelves a disparar.");
						aciertosJ2++;
						
						if (aciertosJ2 == numBarquitosAuto) {
							System.out.println("¡JUGADOR 2 GANA LA PARTIDA!");
							finPartida = true;
						}
					} else {
						turnoDelJugadorActivo = false;
					}
				}
			}
		}
	}

	public static char[][] inicializaTablero(int filas, int columnas) {
		char[][] tablaJugador = new char[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablaJugador[i][j] = OCULTA;
			}
		}
		return tablaJugador;
	}

	public static char[][] creaTablero(int filas, int columnas) {
		char[][] tablaCentral = new char[filas][columnas];
		// CORRECCIÓN: Usar tablaCentral.length o filas, no la variable 'tablero' que no existe aquí
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablaCentral[i][j] = AGUA;
			}
		}
		return tablaCentral;
	}

	public static void generarBarquitos(char[][] tablero, int numBarquitos) {
		Random rd = new Random();
		while (numBarquitos != 0) {
			int filaRd = rd.nextInt(tablero.length);
			// CORRECCIÓN: tablero[0].length para columnas es más seguro
			int columnaRd = rd.nextInt(tablero[0].length); 
			
			// Si intenta poner donde hay BARCO, repite. Si hay AGUA, pone barco.
			if (tablero[filaRd][columnaRd] == AGUA) {
				tablero[filaRd][columnaRd] = BARCO;
				numBarquitos--;
			}
			// Si ya había barco, el bucle repite solo.
		}
	}

	public static void pintaTablero(char tableroJugador[][]) {
		// CORRECCIÓN: Añadidos números de columna para ayudar al usuario
		System.out.print("\t");
		for(int k=0; k<tableroJugador[0].length; k++) System.out.print(k+"\t");
		System.out.println();
		
		for (int i = 0; i < tableroJugador.length; i++) {
			System.out.print(i+"\t"); // Número de fila
			for (int j = 0; j < tableroJugador[i].length; j++) {
				System.out.print(tableroJugador[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static boolean turnoJugador(char tablero[][], char tableroJugador[][]) {
		// CORRECCIÓN: Scanner mejor usar el global 'sc', pero si creas uno nuevo, no pasa nada grave
		// CORRECCIÓN: Borrado barquitosHundidos = 0;
		int fila;
		int columna;
		
		System.out.println("Selecciona disparo (Fila enter Columna):");
		fila = sc.nextInt();
		columna = sc.nextInt();
		
		// Verificar que no se salga del rango (opcional pero recomendable)
		if(fila < 0 || fila >= tablero.length || columna < 0 || columna >= tablero[0].length) {
			System.out.println("¡Fuera de rango! Pierdes turno.");
			return false;
		}

		if (tablero[fila][columna] == BARCO) {
			tableroJugador[fila][columna] = BARCO; // Apuntamos en su cuaderno
			System.out.println("BOOM. Barco hundido");
			return true; // Devuelve true (acertó)
		} else {
			// CORRECCIÓN: NO tocar 'tablero' (la solución), solo 'tableroJugador'
			tableroJugador[fila][columna] = AGUA; 
			System.out.println("AGUAAAA");
			return false; // Devuelve false (falló)
		}
	}
}