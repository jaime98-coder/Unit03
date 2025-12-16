package arraysexercises02;

import java.util.Scanner;

public class Exercise02 {
	// Crea un programa que pida al usuario 20 valores enteros e introduzca los 10
	// primeros en un array y los 10 últimos en otro array. Por último, comparará
	// ambos arrays y le dirá al usuario si son iguales o no.
	public static void main(String[] args) {

		boolean iguales = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce 20 números enteros para rellenar 2 arrays diferentes:");
		int numeros[] = new int[20];
		for (int i = 0; i < numeros.length; i++) {
			System.out.print("Número " + (i + 1) + ": ");
			numeros[i] = sc.nextInt();
		}
		int array1[] = new int[10];
		for (int i = 0; i < array1.length; i++) {
			array1[i] = numeros[i];
		}
		int array2[] = new int[10];
		for (int i = 0; i < array2.length; i++) {
			array2[i] = numeros[i + 10];
		}
		if (array1 == array2) {
			iguales = true;
			System.out.println("Los arrays son iguales.");
		} else {
			iguales = false;
			System.out.println("Los arrays no son iguales.");
		}

		sc.close();
	}

}
