package strings;

import java.util.Scanner;

public class Exercise002_ADV {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean haAcertado = false;
		String passSecreta;
		String adivinanza;
		char[] letrasAdivinanza;
		char[] letrasPassSecreta;

		System.out.println("Introduce la contraseña para que el usuario nº2 lo adivine");
		passSecreta = sc.nextLine();
		while (!haAcertado) {

			System.out.println("Introduce la contraseña que crees que es");
			adivinanza = sc.nextLine();
			if (adivinanza.equalsIgnoreCase(passSecreta)) {
				haAcertado = true;
				System.out.println("¡Has acertado, enhorabuena!");
			} else {
				System.out.println("Contraseña incorrecta");
				letrasAdivinanza = adivinanza.replace(" ", "").toCharArray();
				letrasPassSecreta = passSecreta.toCharArray();

				// Calculamos el limite seguro para iterar sin salirnos de ningun array
				int limiteSeguro;
				if (letrasAdivinanza.length < letrasPassSecreta.length) {
					limiteSeguro = letrasAdivinanza.length;
				} else {
					limiteSeguro = letrasPassSecreta.length;
				}
				for (int i = 0; i < limiteSeguro; i++) {
					if (Character.toLowerCase(letrasAdivinanza[i]) == Character.toLowerCase(letrasPassSecreta[i])) {
						System.out.print(letrasAdivinanza[i]);
					} else {
						System.out.print("*");
					}
				}
				for (int j = limiteSeguro; j < letrasPassSecreta.length; j++) {
					System.out.print("*");
				}

				System.out.println();

			}
		}

		sc.close();
	}

}
