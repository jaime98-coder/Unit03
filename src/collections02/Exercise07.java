package collections02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Exercise07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, HashSet<String>> mapaPalabras = new HashMap<Integer, HashSet<String>>();

		String palabraActual = "";
		int tamañoPalabraActual;
		while (!palabraActual.equalsIgnoreCase("fin")) {
			// Clasificar palabras por su longitud
			// EJ: Clave 3, se almacenar palabras de longitud 3, clave 4, palabras de 4
			// letras,etc...
			System.out.println("Introduce una palabra para introducirla en el mapa palabras");
			System.out.println("('fin' para salir)");
			palabraActual = sc.nextLine();
			// Medir el tamaño de las letras de la palabra introducida
			tamañoPalabraActual = palabraActual.length();
			// Lógica para si no existe ya esa key, crearla
			if (!mapaPalabras.containsKey(tamañoPalabraActual)) {
				mapaPalabras.put(tamañoPalabraActual, new HashSet<String>());

			}
			// Añadir la palabra introducida en la posicion tamañoPalabraActual (a partir
			// del length)
			mapaPalabras.get(tamañoPalabraActual).add(palabraActual);
		}
		System.out.println("Mapa de palabras clasificado por letas: ");
		System.out.println(mapaPalabras.toString());

		sc.close();
	}

}
