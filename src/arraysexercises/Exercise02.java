package arraysexercises;

import java.util.Scanner;

public class Exercise02 {

	public static void main(String[] args) {
		// Creo una tabla con 5 de longitud (indíces del 0 al 4)
		double numeros[] = new double [5];
		Scanner sc = new Scanner(System.in);
		// Creo un bucle for para ir añadiendo valores a la tabla en las diferentes posiciones.
		for (int i=0; i<numeros.length; i++) {
			System.out.println("Introduce un valor "+i);
			numeros=sc.nextDouble();
		}

		
		sc.close();
	}

}
