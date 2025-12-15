package funciones;

public class Exercise001 {
	//	Realiza una función que reciba como parámetro una tabla de enteros y devuelva
	//	la suma de todos los valores almacenados en la tabla. Prueba el comportamiento
	//	de la función en un método main.

	public static void main(String[] args) {
		int[] numeros = { 10, 1, 5 };

		// Llamada a la funcion sumarTabla
		int sumaTotal = sumarTabla(numeros);
		System.out.println("Suma total = " + sumaTotal);
	}

	/**
	 * Suma todos los valores de una tabla de enteros.
	 * 
	 * @param numeros tabla de entrada (no puede ser null)
	 * @return suma total de los elementos de la tabla
	 */

	public static int sumarTabla(int[] numeros) { // La variable numeros es una variable MUDA, da igual el nombre que le
													// ponga
		if (numeros == null) {
			throw new IllegalArgumentException("La tabla no puede ser null.");
		}
		int sumaTotal = 0;
		for (int indiceActual = 0; indiceActual < numeros.length; indiceActual++) {
			sumaTotal += numeros[indiceActual];
		}
		return sumaTotal;
	}
}
