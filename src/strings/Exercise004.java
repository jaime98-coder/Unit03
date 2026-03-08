package strings;

import java.util.Scanner;

public class Exercise004 {

	public static void main(String[] args) {
		String frase;
		String fraseInvertida;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una frase para voltearla");
		frase = sc.nextLine();
		fraseInvertida = voltearFrase(frase);
		System.out.println("La frase volteada sería: " + fraseInvertida);
		sc.close();
	}

	public static String voltearFrase(String frase) {
		String fraseInvertida = "";
		for (int i = frase.length() - 1; i >= 0; i--) {
			fraseInvertida = fraseInvertida + frase.charAt(i);
		}
		return fraseInvertida;
	}

}
