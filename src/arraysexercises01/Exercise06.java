package arraysexercises01;

import java.util.Scanner;

public class Exercise06 {
//	Realiza un programa que pida 8 números enteros y los almacene en una tabla.
//	A continuación, en un bucle distinto, recorrerá esa tabla y mostrará esos números
//	junto con la palabra “par” o “impar” según proceda.
	public static void main(String[] args) {
		// Creo el array para almacenar los 8 números enteros
		int[] numeros = new int[8];
		// Declaracion de variables auxiliares
		int numeroActual;
		String parOImpar;

		Scanner sc = new Scanner(System.in);

		// Solicito al usuario que introduzca 8 nº enteros fuera del bucle para que no
		// se repita cada vez que da una iteración mi bucle FOR
		System.out.println("Introduce 8 números enteros");
		// Creo un bucle FOR para recorrer todas las posiciones de mi Array numeros,
		for (int i = 0; i < numeros.length; i++) {
			// Leo de la consola el nº para cada posición hasta llegar a la introducción de
			// los 8 números
			numeros[i] = sc.nextInt();
		}
		// Recorro el array con otro FOR para comprobar si cada número es par o impar
		for (int i = 0; i < numeros.length; i++) {
			// Asigno a la variable auxiliar numeroActual el valor de la posición i para que
			// con cada iteración vaya asignándole un valor a cada posición de mi Array
			numeroActual = numeros[i];
			// Compruebo si el número es par o impar mediante el operador módulo %
			if (numeroActual % 2 == 0) {
				// Si el resto de la división entre 2 es 0, es par, asigno a la variable
				// parOImpar el String "PAR"
				parOImpar = "PAR";
				// Si no, asigno a la variable parOImpar el String "IMPAR"
			} else {
				parOImpar = "IMPAR";
			}
			// Imprimo el resultado por pantalla con la posición, el número
			// y si es par o impar
			System.out.println("Posición [" + i + "]: " + numeroActual + " es " + parOImpar);
		}
		// Cierro el Scanner
		sc.close();
	}

}
