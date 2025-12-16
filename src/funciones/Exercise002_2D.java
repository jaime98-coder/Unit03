package funciones;

public class Exercise002_2D {

	public static void main(String[] args) {
		int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] transpuesta = transponer(matriz);
		System.out.println("Original: ");
		imprimirMatriz(matriz);
		System.out.println("Transpuesta: ");
		imprimirMatriz(transpuesta);
	}

	/**
	 * Funcion que transpone una matriz rectangular de enteros
	 * 
	 * @param matriz arrays bidimensional (2d)
	 * @return matriz bidimensional (2d) transpuesta de la matriz original
	 */
	public static int[][] transponer(int[][] matriz) {
		if (matriz == null) {
			throw new IllegalArgumentException("La matriz no puede ser nula");
		}
		if (matriz.length == 0) {
			throw new IllegalArgumentException("La matriz no puede estar vacía");
		}
		int filas = matriz.length;
		int columnas = matriz[0].length;
		for (int indiceFila = 1; indiceFila < filas; indiceFila++) {
			if (matriz[indiceFila].length != columnas) {
				throw new IllegalArgumentException("La matriz debe ser rectangular");
			}
		}
		// Esto seria el resultado real
		// Crear la matriz transpuesta donde filas y columnas se intercambian
		int[][] tablaTranspuesta = new int[columnas][filas];
		for (int fila = 0; fila < filas; fila++) {
			for (int columna = 0; columna < columnas; columna++) {
				tablaTranspuesta[columna][fila] = matriz[fila][columna];
			}
		}
		return tablaTranspuesta;
	}

	/**
	 * Funcion que imprime una matriz bidimensional por pantalla
	 * 
	 * @param matriz arrays bidimensional (2d)
	 */
	public static void imprimirMatriz(int[][] matriz) {
		for (int fila = 0; fila < matriz.length; fila++) {
			for (int columna = 0; columna < matriz[fila].length; columna++) {
				System.out.print(matriz[fila][columna] + "\t");
			}
			System.out.println();
		}
	}
}
