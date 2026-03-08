package strings;

import java.util.Scanner;

public class Exercise006 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
		System.out.println("Introduce una frase para comprobar si es palíndroma");
		frase = sc.nextLine();
		if (comprobarPalindromoEficiente(frase)) {
			System.out.println("La frase introducida SI es palíndroma");
		} else {
			System.out.println("La frase introducida NO es palíndroma");
		}
		sc.close();
	}

	// Mi código pre-corrección
	public static boolean comprobarPalindromo(String frase) {
		boolean esPalindroma = false;
		String fraseSinEspacios = "";
		String fraseAlReves = "";
		// Frase sin espacios para hacer un conteo correcto y definir los límites del
		// bucle
		fraseSinEspacios = frase.replace(" ", "");
		for (int i = 0; i < fraseSinEspacios.length(); i++) {
			fraseSinEspacios = fraseSinEspacios + frase.replace(" ", "").charAt(i);
			fraseAlReves = fraseAlReves + frase.replace(" ", "").charAt(fraseSinEspacios.length() - 1 - i);
			if (fraseAlReves.equalsIgnoreCase(fraseSinEspacios)) {
				esPalindroma = true;
			}
		}
		return esPalindroma;
	}

	// Código POST-Correccion eficiente
	public static boolean comprobarPalindromoEficiente(String frase) {
		boolean esPalindroma;
		String fraseSinEspacios = "";
		String fraseAlReves = "";
		// Frase sin espacios para hacer un conteo correcto y definir los límites del
		// bucle
		fraseSinEspacios = frase.replace(" ", "");
		for (int i = 0; i < fraseSinEspacios.length(); i++) {
			fraseAlReves = fraseAlReves + fraseSinEspacios.charAt(fraseSinEspacios.length() - 1 - i);

		}
		if (fraseSinEspacios.equalsIgnoreCase(fraseAlReves)) {
			esPalindroma = true;
		} else {
			esPalindroma = false;

		}
		return esPalindroma;
	}
}
