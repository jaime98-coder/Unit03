package practicaexamen;

import java.util.Scanner;

public class Repaso_Ejercicio002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fraseUsuario = sc.nextLine();
		System.out.println(obtenerPalabras(fraseUsuario) + ", ");
	}

	static String[] obtenerPalabras(String frase) {
		String[] palabrasSeparadas = new String[frase.length() - 1];
		String[] palabraFormateada;

		for (int i = 0; i < palabrasSeparadas.length; i++) {
			palabraFormateada[i] = frase.trim();
			palabraFormateada []= frase.toLowerCase();
			palabraFormateada[i] = palabrasSeparadas[i];
		}

		return palabraFormateada;
	}

}
