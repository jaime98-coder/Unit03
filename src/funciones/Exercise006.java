package funciones;

public class Exercise006 {

	public static void main(String[] args) {
		// 1. Declaración de variables primitivas
		int elementosPorGrupo = 3;

		// 2. Declaración e inicialización de arrays
		int[] tablasElementos = { 4, 3, 8, 3, 5, 4, 2 };
		int[] tablasResultados;

		// 3. Procesamiento
		tablasResultados = suma(tablasElementos, elementosPorGrupo);

		// 4. Salida de datos
		// Imprimimos el título descriptivo una sola vez
		System.out.println(
				"Tabla de elementos sumados (agrupados de " + elementosPorGrupo + " en " + elementosPorGrupo + "):");

		if (tablasResultados.length == 0) {
			System.out.println("No se han podido realizar agrupaciones (array insuficiente).");
		} else {
			// Recorremos el resultado
			for (int i = 0; i < tablasResultados.length; i++) {
				System.out.print(tablasResultados[i] + "\t");
			}
		}
		System.out.println(); // Salto de línea final para separar del prompt del sistema
	}

	public static int[] suma(int[] t, int numElementos) {
		// Cláusula de guarda: Si no cabe ni un grupo, devolvemos vacío y salimos.
		if (numElementos > t.length) {
			return new int[0];
		}

		// Calculamos el tamaño: Ventana deslizante
		int tamanoResultado = t.length - numElementos + 1;
		int[] sumaElementosAgrupados = new int[tamanoResultado];

		// Bucle Principal: Rellena cada hueco del array resultado
		for (int i = 0; i < sumaElementosAgrupados.length; i++) {

			// Bucle Anidado: Suma los N elementos consecutivos
			for (int j = 0; j < numElementos; j++) {
				// Acumulador: Valor actual + Valor de la ventana deslizante
				sumaElementosAgrupados[i] = sumaElementosAgrupados[i] + t[i + j];
			}
		}

		return sumaElementosAgrupados;
	}
}