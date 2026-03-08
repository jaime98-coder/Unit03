package strings;

import java.util.Scanner;

public class Exercise005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String palabraAIntroducir;
		String frase = "";
		boolean esFin = false;

		while (!esFin) {
			System.out.println("Introduce una palabra para crear la frase (escribe 'fin' para salir)");
			palabraAIntroducir = sc.nextLine();
			if (palabraAIntroducir.equalsIgnoreCase("fin")) {
				System.out.println("Fin de la inserción");
				System.out.println("---------------------");
				esFin = true;
			} else {
				frase = frase + palabraAIntroducir + " ";
			}

		}
		// Impresión de frase final
		System.out.println("La frase es: ");
		System.out.println(frase);
		sc.close();
	}

}
