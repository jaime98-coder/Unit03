package funciones;

public class Exercise006 {

	public static void main(String[] args) {
		int[] tablasElementos = { 4, 3, 8, 3, 5, 4, 2, 8, 7 };
		tablasElementos = suma(tablasElementos, 3);
		System.out.println("Tabla elementos sumados:");
		for (int i = 0; i < tablasElementos.length; i++) {
			System.out.print(tablasElementos[i] + "\t");
		}

	}

	public static int[] suma(int[] t, int numElementos) {

		int[] sumaElementosAgrupados = new int[10];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < numElementos; j++) {
				sumaElementosAgrupados[i] += t[i];
			}
			// sumaElementos[i] = t[i];
		}
		return sumaElementosAgrupados;
	}

}
