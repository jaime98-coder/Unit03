package arraysexercises02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Crea un programa que cree un array de tamaño 1000 y lo rellene con valores enteros aleatorios
// entre 0 y 99. Luego pedirá por teclado un valor y se mostrará por pantalla si ese valor existe
// en el array, además de cuántas veces. 
public class Exercise05 {

	public static void main(String[] args) {
		// Creo el random y el scanner
		Random aleatorio = new Random();
		Scanner sc = new Scanner(System.in);

		// Creo el array e introduzco 1000 números aleatorios entre 0 y 99
		int[] array = new int[1000];
		for (int i = 0; i < array.length; i++) {
			array[i] = aleatorio.nextInt(0, 100);
		}
		// Pido un número al usuario y compruebo cuántas veces aparece en el array
		int numUsuario;
		int aparicionesNumUsuario = 0;
		// Variable para saber si ha ganado
		boolean hasGanado = false;
		// Pido el número al usuario
		System.out.println("Adivina el número generado entre 0 y 99");
		numUsuario = sc.nextInt();
		// Recorro el array para contar las apariciones
		for (int i = 0; i < array.length; i++) {
			if (numUsuario == array[i]) {
				aparicionesNumUsuario++;
				// Si aparece al menos una vez, ha ganado
				hasGanado = true;
			}
		}
		// Muestro el resultado si ha ganado
		if (hasGanado == true) {
			System.out.println("¡Acertaste, has ganado!");
		} else {
			System.out.println("Lo siento, no has acertado.");
		}
		// Muestro las apariciones del número
		System.out.println("El nº introducido aparece: " + aparicionesNumUsuario + " veces");
		
		System.out.println("Array ordenado");
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
		
		// Cierro el scanner
		sc.close();

	}

}
