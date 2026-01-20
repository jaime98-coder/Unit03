package practicaexamen;

import java.util.Scanner;

public class PracticaTipoExamen003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int NUM_VENDEDORES = 3;
		final int DIAS = 5;
		int[][] tablaVentasMain = new int[NUM_VENDEDORES][DIAS];
		rellenarVentas(tablaVentasMain, sc);
		System.out.println();
		mostrarTabla(tablaVentasMain);
		System.out.println();
		calcularVentas(tablaVentasMain);

	}

	public static void rellenarVentas(int[][] tablaVentas,Scanner sc) {
		int valorVentaAux = 0;
		for (int i = 0; i < tablaVentas.length; i++) {
			System.out.println("Introduce los datos del vendedor nº " + (i + 1) + ": ");
			for (int j = 0; j < tablaVentas[i].length; j++) {
				System.out.println("Introduce las ventas del día " + (j + 1) + ": ");
				do {

					// Cambiar por sc.nextInt;
					tablaVentas[i][j] = sc.nextInt();
					valorVentaAux = tablaVentas[i][j];
					if (valorVentaAux < 0) {
						System.out.println("Introduce un valor positivo en el día " + (j + 1));
					}
				} while (valorVentaAux < 0);
			}

		}

	}

	public static void mostrarTabla(int[][] tablaVentas) {
		System.out.println("--------Tabla de ventas por dia--------");
		System.out.println("\t\tLunes" + "\t\tMartes" + "\t\tMiercoles" + "\tJueves" + "\t\tViernes");
		for (int i = 0; i < tablaVentas.length; i++) {

			System.out.print("Vendedor " + (i + 1) + ":\t");
			for (int j = 0; j < tablaVentas[i].length; j++) {

				System.out.print(tablaVentas[i][j] + "\t\t");
			}
			System.out.println();
		}
	}

	public static void calcularVentas(int[][] tablaVentas) {

		int ventasTotales;
		System.out.println("--------Tabla de ventas totales--------");
		for (int i = 0; i < tablaVentas.length; i++) {
			ventasTotales = 0;

			for (int j = 0; j < tablaVentas[i].length; j++) {
				ventasTotales += tablaVentas[i][j];
			}
			System.out.println("Ventas del venderor nº " + (i + 1) + " ");
			System.out.println(ventasTotales);
		}
	}
}
