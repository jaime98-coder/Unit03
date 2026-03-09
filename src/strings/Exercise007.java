package strings;

import java.util.Scanner;

public class Exercise007 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una frase");
		String frase = sc.nextLine();
		String palabraABuscar;
		int contadorPalabrasEnFrase;
		System.out.println("Introduce la palabra que quieres buscar en la frase");
		palabraABuscar = sc.nextLine();
		contadorPalabrasEnFrase = contarPalabraEnFrase(frase, palabraABuscar);
		if (contadorPalabrasEnFrase > 0) {
			System.out.println("La palabra introducida aparece en la frase " + contadorPalabrasEnFrase + " veces");
		} else {
			System.out.println("La palabra introducida no aparece ninguna vez en la frase");
		}

		sc.close();
	}

	public static int contarPalabraEnFrase(String frase, String palabra) {
		String[] almacenPalabrasFrase;
		int contadorPalabrasEnFrase = 0;
		almacenPalabrasFrase = frase.split(" ");
		for (int i = 0; i < almacenPalabrasFrase.length; i++) {
			if (almacenPalabrasFrase[i].equalsIgnoreCase(palabra)) {
				contadorPalabrasEnFrase++;
			}
		}
		return contadorPalabrasEnFrase;
	}

}
