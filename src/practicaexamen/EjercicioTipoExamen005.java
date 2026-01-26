package practicaexamen;

import java.util.Scanner;

public class EjercicioTipoExamen005 {

	public static void main(String[] args) {
		final int NUMERO_FILAS = 5;
		final int NUMERO_COLUMNAS = 5;
		int[][] salaCine = new int[NUMERO_FILAS][NUMERO_COLUMNAS];

		mostrarSala(salaCine);
		int fila;
		int columna;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nElige la fila que quieres reservar (0-4): ");
		fila = sc.nextInt();
		System.out.println("Elige la butaca (colummna) que quieres reservar (0-4): ");
		columna = sc.nextInt();
		if (reservarButaca(fila, columna, salaCine)) {
			System.out.println("Butaca reservada con éxito");
		} else {
			System.out.println("La butaca está ocupada");
		}
		mostrarSala(salaCine);

		;
	}

	public static void inicializarSala(int[][] salaCine) {
		for (int i = 0; i < salaCine.length; i++) {
			for (int j = 0; j < salaCine[i].length; j++) {
				salaCine[i][j] = 0;
			}
		}

	}

	public static void mostrarSala(int[][] salaCine) {
		for (int i = 0; i < salaCine.length; i++) {
			for (int j = 0; j < salaCine[i].length; j++) {
				System.out.print(salaCine[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static boolean reservarButaca(int fila, int columna, int[][] salaCine) {
		boolean estaLibre = false;

		if (salaCine[fila][columna] == 0) {
			estaLibre = true;
			if (estaLibre) {
				salaCine[fila][columna] = 1;
			}
		} else {
			System.out.println("La butaca está ocupada");
			estaLibre = false;
		}

		return estaLibre;
	}

}
