package collections02;

import java.util.LinkedHashSet;
import java.util.Random;

public class Exercise02 {

	public static void main(String[] args) {
		Random rd = new Random();
		final int CANTIDAD_NUMEROS = 10;
		int aleatorioAux;
		int comprobadorNumeros;
		// LinkedHashSet (para que no haya números repetidos)
		LinkedHashSet<Integer> almacenNumerosAleatorios = new LinkedHashSet<Integer>();

		// Bucle para que hasta que el tamaño del LinkedHashSet no sea igual que la
		// cantidad de números (10 tamaño del hashset), no pare.
		while (almacenNumerosAleatorios.size() != CANTIDAD_NUMEROS) {
			aleatorioAux = rd.nextInt(1, 21);
			almacenNumerosAleatorios.add(aleatorioAux);
		}
		System.out.println(almacenNumerosAleatorios.toString());

	}

}
