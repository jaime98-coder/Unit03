package arraysexercises01;

import java.util.Random;

public class Exercise01 {

	public static void main(String[] args) {
		int [] numeros  = new int [10];
		Random aleatorio = new Random();
		for (int i=0; i<numeros.length; i++) {
			numeros[i]=aleatorio.nextInt(1, 101);
			System.out.println("Índice "+i+": "+numeros[i]);
		}
		
	}

}
