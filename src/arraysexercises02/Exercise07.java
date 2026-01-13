package arraysexercises02;

import java.util.Arrays;

public class Exercise07 {
	// Crea un programa que cree un array de tipo entero e introduzca la siguiente
	// secuencia de valores: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc. hasta
	// introducir 10 diez veces el 10, y luego la muestre por pantalla. En esta
	// ocasión has de utilizar Arrays.fill().
	public static void main(String[] args) {
		// Calculo la longitud del array necesaria
		int maxIterations = 10;
		// La longitud del array es la suma de los primeros 10 números naturales
		int arrayLength = 0;
		int endIndex = 0;
		int startIndex = 0;

		for (int i = 0; i < maxIterations; i++) {
			arrayLength += i + 1;
		}
		System.out.println("Array length: " + arrayLength);
		int[] numeros = new int[arrayLength];

		int currentNumber;
		for (int i = 0; i < maxIterations; i++) {
			currentNumber = i + 1;
			endIndex += currentNumber;
			System.out.print("Current number: " + currentNumber+ ". ");
			System.out.print("Start index: " + startIndex+ ". ");
			System.out.println("End index: " + endIndex);
			Arrays.fill(numeros, startIndex, endIndex, currentNumber);
			startIndex += currentNumber;
		}
		System.out.println();
		System.out.println("Array contents:");
		System.out.println(Arrays.toString(numeros));
	}

}
