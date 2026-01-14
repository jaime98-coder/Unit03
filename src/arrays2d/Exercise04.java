package arrays2d;

import java.util.Scanner;

public class Exercise04 {
	/*
	 * Escribe un programa que cree una tabla de 10x10 que contenga los valores de
	 * las tablas de multiplicar del 1 al 10 (cada tabla de multiplicar en una
	 * fila). Muestra la tabla por pantalla.
	 */
	public static void main(String[] args) {

		// 1. DECLARACIÓN DE LA MATRIZ
		// Creamos una matriz de enteros con 10 filas y 10 columnas.
		// En este momento, todas las casillas valen 0.
		int[][] tablasMultiplicar = new int[10][10];

		// 2. RECORRIDO PARA RELLENAR DATOS
		// Iniciamos el bucle externo 'i' que controla las FILAS (del 0 al 9).
		for (int i = 0; i < tablasMultiplicar.length; i++) {

			// Iniciamos el bucle interno 'j' que controla las COLUMNAS dentro de esa fila.
			for (int j = 0; j < tablasMultiplicar[i].length; j++) {

				// Calculamos el valor. Sumamos 1 a 'i' y 'j' porque los índices empiezan en 0,
				// pero nosotros queremos las tablas del 1 al 10.
				tablasMultiplicar[i][j] = (i + 1) * (j + 1);
			}
		}

		// 3. RECORRIDO PARA MOSTRAR LA TABLA (VISUALIZACIÓN)
		// Volvemos a recorrer las filas para leer lo que hemos guardado.
		for (int i = 0; i < tablasMultiplicar.length; i++) {

			// Recorremos las celdas de la fila actual.
			for (int j = 0; j < tablasMultiplicar[i].length; j++) {

				// Imprimimos la operación y el resultado.
				// Usamos 'print' (sin ln) para que salgan uno al lado del otro.
				System.out.print((i + 1) + "*" + (j + 1) + "=" + tablasMultiplicar[i][j] + "   ");
			}

			// Al terminar de imprimir una fila completa (bucle j), hacemos un salto de
			// línea
			// para que la siguiente tabla (fila i+1) salga debajo.
			System.out.println();
		}

		// 4. PREPARACIÓN DE LA BÚSQUEDA
		System.out.println("Introduce el nº que quieres buscar");

		// Variable para almacenar el número que introduce el usuario.
		int numeroBuscado;

		// Contador para saber cuántas veces encontramos el número. Inicializado a 0.
		int numeroEncontrado = 0;

		// Variables auxiliares para guardar la posición.
		// Las inicializamos a -1 porque es un valor imposible en un array (control de
		// errores).
		int filaEncontrada = -1;
		int columnaEncontrada = -1;

		// Inicializamos el Scanner para leer del teclado.
		Scanner sc = new Scanner(System.in);

		// Leemos el entero y lo guardamos.
		numeroBuscado = sc.nextInt();

		// 5. MOTOR DE BÚSQUEDA
		// Recorremos la matriz nuevamente para buscar coincidencias.
		for (int i = 0; i < tablasMultiplicar.length; i++) {
			for (int j = 0; j < tablasMultiplicar[i].length; j++) {

				// Condición: ¿Es el valor de la celda actual igual al número buscado?
				if (numeroBuscado == tablasMultiplicar[i][j]) {

					// Si es igual, aumentamos el contador de coincidencias.
					numeroEncontrado++;

					// Actualizamos las variables de posición con los índices actuales.
					filaEncontrada = i;
					columnaEncontrada = j;

					// Imprimimos INMEDIATAMENTE dónde lo hemos encontrado.
					// Esto es clave porque si hay varios, queremos verlos todos.
					System.out.println("El número se encuentra en la fila (indice) " + filaEncontrada
							+ " y en la columna (indice) " + columnaEncontrada);
				}

			}
		}

		// 6. RESUMEN FINAL
		// Comprobamos el contador. Si es mayor que 0, significa que apareció al menos
		// una vez.
		if (numeroEncontrado > 0) {
			System.out.println("¡Número encontrado!");
		} else {
			// Si el contador sigue siendo 0, es que no estaba en toda la tabla.
			System.out.println("El número " + numeroBuscado + " no aparece, lo siento.");
		}

		// Buena práctica: Cerramos el Scanner para liberar recursos del sistema.
		sc.close();
	}

}