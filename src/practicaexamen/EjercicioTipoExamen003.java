package practicaexamen;

import java.util.Scanner;

public class EjercicioTipoExamen003 {
	/*
	 * Estás a cargo del sistema de reservas de una pequeña sala de cine VIP.
	 * 
	 * Datos del problema:
	 * 
	 * La Sala: Es una matriz de 4 filas y 5 columnas (4x5).
	 * 
	 * Estados:
	 * 
	 * 0: La butaca está LIBRE (se mostrará como [L]).
	 * 
	 * 1: La butaca está OCUPADA (se mostrará como [X]).
	 * 
	 * Requisitos Funcionales (Funciones):
	 * 
	 * mostrarSala: Debe recorrer la matriz e imprimir la cuadrícula por pantalla
	 * para que el usuario vea qué sitios están libres.
	 * 
	 * reservarButaca:
	 * 
	 * Pedirá al usuario una Fila y una Butaca (Columna).
	 * 
	 * Validación: Debe comprobar que las coordenadas son correctas (no salirse de
	 * la sala) y que el asiento no esté ya ocupado.
	 * 
	 * Si todo es correcto, marca la casilla con un 1.
	 */
	public static void main(String[] args) {
		final int FILAS = 4;
		final int COLUMNAS = 5;
		int[][] sala = new int[FILAS][COLUMNAS];
		int opcion=0;
		boolean continuarPrograma = true;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Mostrar sala");
			System.out.println("2. Reservar butaca");
			System.out.println("3. Salir");
			System.out.print("Elige una opción: ");
			try {
				opcion = sc.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Por favor, introduce un número válido.");
				sc.nextLine();
			}
			switch (opcion) {
			case 1:
				mostrarSala(sala);
				break;
			case 2:
				reservarButaca(sala, sc);
				break;
			case 3:
				continuarPrograma = false;
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción no válida. Inténtalo de nuevo.");
			}
		} while (continuarPrograma);
		
		sc.close();
	}
	/**
	 * Muestra el estado de la sala de cine.
	 * 
	 * @param sala Matriz que representa la sala de cine.
	 */
	public static void mostrarSala(int[][] sala) {
		System.out.println("Estado de la sala:");
		for (int i = 0; i < sala.length; i++) {
			for (int j = 0; j < sala[i].length; j++) {
				if (sala[i][j] == 0) {
					System.out.print("[L] ");
				} else {
					System.out.print("[X] ");
				}
			}
			System.out.println();
		}
	}
	
	public static void reservarButaca(int[][] sala, Scanner sc) {
		int fila;
		int columna;
		System.out.print("Introduce la fila (0-3): ");
		fila = sc.nextInt();
		System.out.print("Introduce la columna (0-4): ");
		columna = sc.nextInt();
		
		// Validación de coordenadas
		if (fila < 0 || fila >= sala.length || columna < 0 || columna >= sala[0].length) {
			System.out.println("Coordenadas inválidas. Inténtalo de nuevo.");
			
		}
		
		// Comprobar si la butaca está ocupada
		if (sala[fila][columna] == 1) {
			System.out.println("La butaca ya está ocupada. Elige otra.");
		} else {
			sala[fila][columna] = 1; // Reservar la butaca
			System.out.println("Butaca reservada con éxito.");
		}
	}

}
