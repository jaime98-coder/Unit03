package collections02;

import java.util.ArrayList;
import java.util.Random;

public class Exercise01 {

	public static void main(String[] args) {
		Random rd = new Random();
		final int LONGITUD_LISTA = 10;
		int indiceAleatorio;
		int numeroExtraido;

		ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
		for (int i = 0; i < LONGITUD_LISTA; i++) {
			listaNumeros.add(i + 1);
		}

		System.out.println("Original: " + listaNumeros);

		ArrayList<Integer> listaDesordenada = new ArrayList<Integer>();

		// Usamos while para vaciar la lista por completo
		// Mientras el tamaño sea mayor que 0, seguimos sacando
		while (listaNumeros.size() > 0) {
			// Sacamos un número aleatorio de la lista original y lo añadimos a la nueva
			// lista
			indiceAleatorio = rd.nextInt(listaNumeros.size());
			// Sacamos el número usando remove, que devuelve el elemento eliminado
			numeroExtraido = listaNumeros.remove(indiceAleatorio);
			// Al usar remove, el número extraído se elimina de la lista original, por lo
			// que no se repetirá
			listaDesordenada.add(numeroExtraido);
		}

		System.out.println("Mezclada: " + listaDesordenada);
	}
}