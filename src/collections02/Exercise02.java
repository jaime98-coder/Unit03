package collections02;

import java.util.LinkedHashSet;
import java.util.Random;

public class Exercise02 {

	public static void main(String[] args) {
		Random rd = new Random();
		final int CANTIDAD_NUMEROS = 10;
		int comprobadorNumeros;
//		boolean esDistinto;
		LinkedHashSet<Integer> almacenNumerosAleatorios = new LinkedHashSet<Integer>();
		for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
			comprobadorNumeros = rd.nextInt(1, 21);
			almacenNumerosAleatorios.add(comprobadorNumeros);
			if (almacenNumerosAleatorios.size() != i) {
				i--;
			}
		}
		System.out.println(almacenNumerosAleatorios.toString());

	}

}
