package arrays2d;

import java.util.Random;

public class Exercise05 {

	public static void main(String[] args) {
		Random aleatorio = new Random();
		int sumaTotal = 0;
		int sumaFilas = 0;

		int array2D[][] = new int[4][5];
		int sumaColumnas[] = new int[5];

		// --- PRIMER BUCLE: GENERAR Y CALCULAR ---
		for (int i = 0; i < array2D.length; i++) {
			sumaFilas = 0;
			for (int j = 0; j < array2D[i].length; j++) {

				// Generar número
				array2D[i][j] = aleatorio.nextInt(100, 1000);

				// Sumar a la fila (Correcto)
				sumaFilas += array2D[i][j];

				// CORRECCIÓN AQUÍ:
				// Usamos 'j' porque queremos sumar en la hucha de esa COLUMNA específica.
				// Antes tenías [i], por eso sumaba mal.
				sumaColumnas[j] += array2D[i][j];

				// Sumar al total (Correcto)
				sumaTotal += array2D[i][j];
			}
		}

		// --- SEGUNDO BUCLE: MOSTRAR TABLA ---
		System.out.println("----------------------------------------------------------");
		for (int i = 0; i < array2D.length; i++) {
			sumaFilas = 0; // Reiniciamos para volver a calcular visualmente

			for (int j = 0; j < array2D[i].length; j++) {
				// Pongo \t (tabulador) para que queden alineados
				System.out.print(array2D[i][j] + "\t");
				sumaFilas += array2D[i][j];
			}
			// Muestro la suma de la fila al final de la línea
			System.out.println("| Fila " + i + ": " + sumaFilas);
		}

		// --- MOSTRAR SUMA DE COLUMNAS ---
		System.out.println("----------------------------------------------------------");

		// Recorro el array donde guardé las sumas verticales
		for (int j = 0; j < sumaColumnas.length; j++) {
			// Quito el texto "j" y dejo solo el número para que cuadre debajo de su columna
			System.out.print(sumaColumnas[j] + "\t");
		}

		// Muestro el total final separado un poco
		System.out.println("| TOTAL: " + sumaTotal);
	}
}