package funciones;

import java.util.Random;

public class Exercise001_2D {

	public static void main(String[] args) {
		// Declaración de la matriz de datos (6 filas x 10 columnas)
		int[][] tablaValoresMain = new int[6][10];
		// Array auxiliar para recoger los dos valores (min y max) que devuelve la
		// función
		int[] tablaMinimoMaximoMain;
		// Instancia del generador de números aleatorios
		Random aleatorio = new Random();

		// Bucle anidado para rellenar la matriz completa
		for (int i = 0; i < tablaValoresMain.length; i++) {
			for (int j = 0; j < tablaValoresMain[i].length; j++) {
				// Asignamos un valor aleatorio entre 0 y 1000 (el límite superior es exclusivo)
				tablaValoresMain[i][j] = aleatorio.nextInt(0, 1001);
			}
		}

		// Invocamos a la función y capturamos el resultado en nuestro array local
		tablaMinimoMaximoMain = minimoYMaximo(tablaValoresMain);

		// Mostramos por consola los resultados obtenidos
		System.out.println("Tabla mínimo y maximo:");
		for (int i = 0; i < tablaMinimoMaximoMain.length; i++) {
			System.out.print(tablaMinimoMaximoMain[i] + "\t");
		}
	}

/**
 * Función que recibe una matriz de enteros y devuelve un array con el valor
 * @param tablaValores
 * @return Un array de dos posiciones donde en la posición 0 se encuentra el valor mínimo y en la posición 1 el valor máximo.
 */
	public static int[] minimoYMaximo(int[][] tablaValores) {
		// Inicializamos min con el valor de la posicion 0, 0 ya que es el primer valor.
		int minimo = tablaValores[0][0];
		// Inicializamos min con el valor de la posicion 0, 0 ya que es el primer valor.
		int maximo = tablaValores[0][0];
		
		// Creamos el array contenedor para la respuesta
		int[] tablaMinimoMaximo = new int[2];

		// Recorremos las filas de la matriz
		for (int i = 0; i < tablaValores.length; i++) {
			// Recorremos las columnas de la fila actual
			for (int j = 0; j < tablaValores[i].length; j++) {
				// Comprobamos si el valor actual es menor que nuestro mínimo registrado
				if (minimo > tablaValores[i][j]) {
					minimo = tablaValores[i][j];
				}
				// Comprobamos si el valor actual es mayor que nuestro máximo registrado
				if (maximo < tablaValores[i][j]) {
					maximo = tablaValores[i][j];
				}
			}
		}

		// Guardamos los resultados finales en las posiciones acordadas
		tablaMinimoMaximo[0] = minimo;
		tablaMinimoMaximo[1] = maximo;

		// Devolvemos el array con la solución
		return tablaMinimoMaximo;
	}

}