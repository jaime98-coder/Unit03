package funciones;

public class Exercise003_2D {

	public static void main(String[] args) {
		int[][] tablaValores = { { 5, 5, 5, 5 }, { 5, 5, 5, 5 }, { 5, 5, 5, 5 }, { 5, 5, 5, 5 } };
		boolean resultadoBooleano;
		resultadoBooleano = esSimetrica(tablaValores);
		if (resultadoBooleano) {
			System.out.println("La matriz es simétrica (ya que es cuadrada)");
		} else {
			System.out.println("La matriz NO es simétrica");

		}
		for (int i = 0; i < tablaValores.length; i++) {
			for (int j = 0; j < tablaValores[i].length; j++) {
				System.out.print(tablaValores[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static boolean esSimetrica(int[][] tabla) {
		boolean esSimetrica = true;
//		int[][] tablaEspejo = new int [tabla.length];
		if (tabla.length != tabla[0].length) {
			esSimetrica = false;
		} else {
			for (int i = 0; i < tabla.length; i++) {
				for (int j = 0; j < tabla[i].length; j++) {
					if (tabla[i][j] != tabla[j][i]) {
						esSimetrica = false;
					}
				}
			}
		}
		return esSimetrica;
	}
}
