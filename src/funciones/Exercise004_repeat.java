package funciones;

public class Exercise004_repeat {
	public static void main(String[] args) {
		int[] tablaBusqueda = { 6, 8, 23, 9, 27, 34 };
		int posicionValorBuscado;
		posicionValorBuscado = buscar(tablaBusqueda, 27);
		if (posicionValorBuscado == -1) {
			System.out.println("El valor buscado no se encuentra en la tabla");
		} else {
			System.out.println("Valor encontrado en la posición: " + posicionValorBuscado);
		}
	}

	public static int buscar(int[] t, int clave) {
		int valorEncontrado = 0;
		int posicionValorEncontrado = -1;
		for (int i = 0; i < t.length; i++) {
			if (clave == t[i]) {
				valorEncontrado = t[i];
				posicionValorEncontrado = i;
			}
		}
		return posicionValorEncontrado;

	}
}
