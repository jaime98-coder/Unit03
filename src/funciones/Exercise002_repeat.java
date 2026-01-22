package funciones;

public class Exercise002_repeat {

	public static void main(String[] args) {
		int[] tablaValores = { 34, 645, 4, 73, 9 };
		int numMaximo;

		numMaximo = maximo(tablaValores);
		System.out.println("El nº máximo de la tabla es: ");
		System.out.println(numMaximo);

	}

	public static int maximo(int[] t) {
		int numMaximo = -10000;
		for (int i = 0; i < t.length; i++) {
			if (numMaximo < t[i]) {
				numMaximo = t[i];
			}
		}
		return numMaximo;

	}

}
