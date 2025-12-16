package arraysexercises02;

import java.util.Scanner;

public class Exercise01 {
	// Crea un programa que pida al usuario dos valores, tamaño y valor, y luego
	// cree un array del tamaño dado y que almacene valor en todas sus posiciones.
	// Luego muestra el array por pantalla.
	public static void main(String[] args) {
		int tamano;
		int valor;
		Scanner sc = new Scanner(System.in);
		// Pido al usuario el tamaño y el valor y leo de la consola los datos
		// introducidos
		System.out.print("Introduce el tamaño del array: ");
		tamano = sc.nextInt();
		System.out.print("Introduce el valor a almacenar en el array: ");
		valor = sc.nextInt();
		// Creo el array y le doy el tamaño indicado por el usuario
		int[] array = new int[tamano];
		// Relleno el array con el valor indicado por el usuario
		for (int i = 0; i < array.length; i++) {
			array[i] = valor;
		}
		// Muestro el array por pantalla
		System.out.println("Resultados:");
		// Recorro el array e imprimo sus valores
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		// Cierro el scanner
		sc.close();
	}

}
