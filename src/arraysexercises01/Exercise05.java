package arraysexercises01;

import java.util.Scanner;

public class Exercise05 {
//Crea un programa que pida diez números reales por teclado, los almacene en un array,
//y luego lo recorra para calcularla suma de todos los números y, además, averiguar el
//máximo y mínimo y mostrarlos por pantalla.
	public static void main(String[] args) {
		// Creo el array para almacenar los 10 números reales
		double[] numReal = new double[10];
		double suma = 0;
		double maximo;
		double minimo;

		Scanner sc = new Scanner(System.in);

		// Solicito al usuario que introduzca 10 nº reales fuera del bucle para que no
		// se repita cada vez que da una iteración
		System.out.println("Introduce 10 números reales:");
		// Creo un bucle for para recorrer todas las posiciones de mi Array numReal,
		// donde almacenaré los distintos valores introducidos por el usuario
		for (int i = 0; i < numReal.length; i++) {
			// Solicito al usuario y leo de la consola el nº para cada posición hasta llegar
			// a introducir los 10 números
			System.out.print("Introduce el nº para la posición " + (i) + ": ");
			numReal[i] = sc.nextDouble();
			// Almaceno y sumo en la variable suma el valor de cada número real, para que se
			// vayan acumulando con cada iteración
			suma += numReal[i];
		}
		// Inicializo las variables maximo y minimo con el primer valor del array para
		// recorrer mediante un bucle for el Array, y luego comparar cada valor con el
		// valor almacenado en maximo y minimo
		maximo = numReal[0];
		for (int i = 1; i < numReal.length; i++) {
			if (numReal[i] > maximo) {
				maximo = numReal[i];
			}
		}
		minimo = numReal[0];
		for (int i = 1; i < numReal.length; i++) {
			if (numReal[i] < minimo) {
				minimo = numReal[i];
			}
		}
		// Muestro por pantalla los resultados obtenidos
		System.out.println("El número máximo es: " + maximo);
		System.out.println("La suma de los números es: " + suma);
		System.out.println("El número mínimo es: " + minimo);

		// Cierro el Scanner
		sc.close();

	}
}
