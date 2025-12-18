package arraysexercises02;

import java.util.Arrays;
import java.util.Random;

public class Exercise03 {
	// Crea un programa que cree un array de tamaño 30 y lo rellene con
	// valores aleatorios entre 0 y 9. Luego ordena los valores del array y los
	// mostrará por pantalla.
	public static void main(String[] args) {

		int[] numeros = new int[30];
		Random aleatorio = new Random();
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = aleatorio.nextInt(10);
		}
		System.out.println("Contenido del array:");
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		System.out.println();

		System.out.println("Contenido del array ordenado:");
		Arrays.sort(numeros);
		for (int i = 0; i < numeros.length; i++) {

			System.out.print(numeros[i] + " ");
		}

	}

}
