package funciones;

import java.util.Arrays;
import java.util.Random;

public class Exercise003_repeat {

	public static void main(String[] args) {
		int[] tablaValoresMain = rellenaPares(8, 100);
		System.out.println("Tabla de valores aleatorios y pares de menor a mayor: ");
		for (int i = 0; i < tablaValoresMain.length; i++) {
			System.out.println(tablaValoresMain[i]);
		}
		System.out.println();
		System.out.println("Tabla ordenada de mayor a menor: ");
		for (int i = tablaValoresMain.length - 1; i > 0; i--) {
			System.out.println(tablaValoresMain[i]);
		}
	}

	public static int[] rellenaPares(int longitud, int fin) {
		Random aleatorio = new Random();
		int valorAleatorio;
		int[] tablaOrdenada = new int[longitud];
		int contadorValoresNoPares = 0;
		for (int i = 0; i < tablaOrdenada.length; i++) {
			valorAleatorio = aleatorio.nextInt(1, (fin + 1));
			if (valorAleatorio % 2 == 0) {
				tablaOrdenada[i] = valorAleatorio;

			} else {
				contadorValoresNoPares++;
			}
		}
		System.out.println(
				"Contador de valores No Pares los cuales aparecerán como 0 en la tabla: " + contadorValoresNoPares);

		Arrays.sort(tablaOrdenada);

		return tablaOrdenada;
	}

}
