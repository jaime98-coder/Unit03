package strings;

import java.util.Scanner;

public class Exercise003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
		int contadorEspacios;
		System.out.println("Introduce una frase para contar los espacios que tiene");
		frase = sc.nextLine();
		contadorEspacios = contarEspaciosSeguro(frase);
		System.out.println("La frase contiene " + contadorEspacios + " espacios.");

		sc.close();
	}

//	public static int contarEspacios(String frase) {
//		int contadorEspacios = 0;
//		String[] almacenPalabras;
//		almacenPalabras = frase.split(" ");
//		contadorEspacios = almacenPalabras.length - 1;
//		return contadorEspacios;
//	}

	public static int contarEspaciosSeguro(String frase) {
		int contadorEspacios = 0;
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == ' ') {
				contadorEspacios++;
			}
		}
		return contadorEspacios;
	}

}
