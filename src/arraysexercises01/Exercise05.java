package arraysexercises01;

import java.util.Scanner;

public class Exercise05 {
//Crea un programa que pida diez números reales por teclado, los almacene en un array,
//y luego lo recorra para calcularla suma de todos los números y, además, averiguar el
//máximo y mínimo y mostrarlos por pantalla.
	public static void main(String[] args) {
		double[] numReal = new double[10];
		double suma = 0;
		double maximo;
		double minimo;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce 10 números reales:");
		for (int i = 0; i < numReal.length; i++) {

			System.out.print("Introduce el nº para la posición " + (i) + ": ");
			numReal[i] = sc.nextDouble();
			suma += numReal[i];
		}
		maximo=numReal[0];
		for (int i=1; i<numReal.length;i++) {
			if (numReal[i] > maximo) {
				maximo=numReal[i];
			}	
		}
		minimo=numReal[0];
		for 
		
		System.out.println("El número máximo es: "+maximo);
		System.out.println("La suma de los números es: " + suma);

		sc.close();

	}
}
