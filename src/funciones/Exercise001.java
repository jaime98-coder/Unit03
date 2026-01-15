package funciones;

import java.util.Scanner;

public class Exercise001 {
	//	Realiza una función que reciba como parámetro una tabla de enteros y devuelva
	//	la suma de todos los valores almacenados en la tabla. Prueba el comportamiento
	//	de la función en un método main.

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int cantidadNumerosASumar=0;
		System.out.println("¿Cuantos numeros vas a sumar?");
		cantidadNumerosASumar = sc.nextInt();
		int sumaTotal=0;
		int [] tablaNumeros = new int [cantidadNumerosASumar];
		System.out.println("Introduce los "+cantidadNumerosASumar+" números: ");
		for (int i=0; i<tablaNumeros.length; i++) {
			tablaNumeros[i]=sc.nextInt();
			
		}
		sumaTotal = sumarTabla(tablaNumeros);
		System.out.println("Suma Total:"+sumaTotal);
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
