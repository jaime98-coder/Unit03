package funciones;

public class Exercise005_2D {

	public static void main(String[] args) {
		// Declaramos e inicializamos la matriz de prueba (3x3)
		int[][] tablaOriginal = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// Mostramos el estado inicial
		System.out.println("--- Matriz Original ---");
		imprimirMatriz(tablaOriginal);

		// Declaramos la variable para el resultado e invocamos a la función
		int[][] tablaResultado = gira90(tablaOriginal);

		// Mostramos el resultado final
		System.out.println("\n--- Matriz Girada 90º ---");
		imprimirMatriz(tablaResultado);
	}

	public static int[][] gira90(int[][] tablaInicio) {
		// Obtenemos la dimensión de la matriz (N) para usarla en los cálculos
		int n = tablaInicio.length;

		// Declaramos e inicializamos la nueva matriz vacía
		// Esta matriz almacenará los valores ya reubicados
		int[][] tablaRotada = new int[n][n];

		// Recorremos las filas de la matriz original
		for (int i = 0; i < tablaInicio.length; i++) {
			// Recorremos las columnas de la matriz original
			for (int j = 0; j < tablaInicio[i].length; j++) {

				// --- LÓGICA DE ROTACIÓN 90º ---
				// El valor de la posición original [i][j] se mueve a una nueva posición.
				// Nueva Fila = Columna original (j)
				// Nueva Columna = (N - 1) - Fila original (i)
				tablaRotada[j][(n - 1) - i] = tablaInicio[i][j];
			}
		}

		return tablaRotada;
	}

	// Método auxiliar para visualizar la matriz de forma limpia
	public static void imprimirMatriz(int[][] tabla) {
		// Recorremos las filas
		for (int i = 0; i < tabla.length; i++) {
			// Recorremos las columnas
			for (int j = 0; j < tabla[i].length; j++) {
				// Imprimimos el elemento con un tabulador para alinearlo
				System.out.print(tabla[i][j] + "\t");
			}
			// Hacemos un salto de línea al terminar cada fila
			System.out.println();
		}
	}
}