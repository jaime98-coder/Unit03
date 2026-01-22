package funciones;

public class Exercise004_2D {

	public static void main(String[] args) {
		int[][] tablaValores = { { 5, 5, 5 }, { 5, 7, 5 }, { 5, 5, 5 } };
		System.out.println(esMagica(tablaValores));

	}

	public static boolean esMagica(int[][] tabla) {
		boolean esMagica = true;

		int sumaObjetivo = 0;
		for (int i = 0; i < tabla.length; i++) {

			sumaObjetivo += tabla[0][i];

		}
		int sumaFilaActualAux;
		for (int i = 0; i < tabla.length && esMagica; i++) {
			sumaFilaActualAux = 0;
			for (int j = 0; j < tabla[i].length; j++) {
				sumaFilaActualAux += tabla[i][j];

			}
			if (sumaFilaActualAux != sumaObjetivo) {
				esMagica = false;
			}
		}
		int sumaColumnaActualAux = 0;
		for (int i = 0; i < tabla.length && esMagica; i++) {
			sumaColumnaActualAux = 0;
			for (int j = 0; j < tabla.length; j++) {
				sumaColumnaActualAux += tabla[j][i];

			}
			if (sumaColumnaActualAux != sumaObjetivo) {
				esMagica = false;
			}
		}
		return esMagica;

	}
}
