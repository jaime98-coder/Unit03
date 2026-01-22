package funciones;

public class Exercise005 {

	public static void main(String[] args) {
		int[] tablaValores = { 30, 66, 43, 9, 66, 8, 2, 27 };
		int[] tablaIndices;
		int valorBuscado;
		valorBuscado = 66;
		tablaIndices = buscarTodos(tablaValores, valorBuscado);
		System.out.println("Tabla de indices donde aparece el valor 66");
		if (tablaIndices.length == 0) {
			System.out.println("El valor no se encuentra en la tabla");
		} else {
			for (int i = 0; i < tablaIndices.length; i++) {
				System.out.print(tablaIndices[i] + "\t");
			}
		}
		System.out.println();

	}

	public static int[] buscarTodos(int[] t, int valor) {
		int contadorCoincidencias = 0;
		int[] indicesEncontrados;
		for (int i = 0; i < t.length; i++) {
			if (valor == t[i]) {
				contadorCoincidencias++;
			}
		}
		indicesEncontrados = new int[contadorCoincidencias];

		int indiceDestino = 0;

		for (int i = 0; i < t.length; i++) {
			if (valor == t[i]) {
				indicesEncontrados[indiceDestino] = i;
				indiceDestino++;
			}
		}

		return indicesEncontrados;
	}

}
