package arraysexercises02;

import java.util.Random;

public class Exercise03 {

	public static void main(String[] args) {
		int [] array = new int [30];
		int valoresAleatorios;
		Random aleatorio = new Random();
		for (int i=0; i<array.length; i++) {
			array[i] = aleatorio.nextInt(10);
		}
		System.out.println("Contenido del array:");
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("Contenido del array ordenado:");
		for (int i=0; i<array.length; i++) {
			System.out.print(Arrays.sort[i] + " ");
		}

	}

}
