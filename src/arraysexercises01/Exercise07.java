package arraysexercises01;

import java.util.Scanner;

public class Exercise07 {
	// Realiza un programa que pida la temperatura media que ha hecho en cada mes de
	// un determinado año y las almacene en una tabla (una posición por mes). A
	// continuación, se debe mostrar un diagrama de barras horizontales con esos
	// datos. Las barras del diagrama se pueden dibujar a base de asteriscos o
	// cualquier otro carácter.
	public static void main(String[] args) {
		// Creo un ARRAY de 12 de longitud
		double[] temperaturaMedia = new double[12];
		// Creo una variable para almacenar el numero de barras (guiones) a pintar
		int numeroBarras = 0;
		Scanner sc = new Scanner(System.in);
		// Solicito al usuario que introduzca la temperatura media de cada mes
		System.out.println("Introduce la temperatura media de cada mes del año");
		// Recorro el array con un bucle FOR para solicitar y leer la temperatura media
		// de cada mes
		for (int i = 0; i < temperaturaMedia.length; i++) {
			System.out.print("Introduce la temperatura media del mes " + (i + 1) + ": ");
			temperaturaMedia[i] = sc.nextDouble();
		}
		// Presento con un mensaje-título la temperatura por mes
		System.out.println("Temperatura por mes:");
		// Recorro el array con otro bucle FOR para mostrar la temperatura media de cada
		// mes junto con las barras
		for (int i = 0; i < temperaturaMedia.length; i++) {
			numeroBarras = (int) temperaturaMedia[i];
			double temperaturaMediaActual = temperaturaMedia[i];
			// Imprimo la temperatura media de cada mes según la posición i del array
			System.out.print("Mes " + (i + 1) + ": " + temperaturaMediaActual + "ºC ");
			// Bucle para imprimir el número de barras (guiones) según la temperatura media
			// de cada mes
			for (int j = 0; j < numeroBarras; j++) {
				System.out.print("-");
			}
			// Salto de línea después de imprimir las barras de cada mes, para que el
			// siguiente mes se imprima en una nueva línea
			System.out.println();

		}
		// Cierro el Scanner
		sc.close();
	}

}
