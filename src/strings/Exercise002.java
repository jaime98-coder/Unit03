package strings;

import java.util.Scanner;

public class Exercise002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean haAcertado = false;
		String passSecreta = "Papiroflexia";
		String adivinanza;

		while (!haAcertado) {
			System.out.println("Introduce la contraseña que crees que es");
			adivinanza = sc.nextLine();
			if (adivinanza.equalsIgnoreCase(passSecreta)) {
				haAcertado = true;
				System.out.println("¡Has acertado, enhorabuena!");
			} else {
				System.out.println("Contraseña incorrecta");
				
				if (adivinanza.compareToIgnoreCase(passSecreta) > 0) {
					System.out.println("La palabra introducida es MAYOR alfabeticamente");
				} else  {
					System.out.println("La palabra introducida es MENOR alfabeticamente");

				}
			}
		}

		sc.close();
	}

}
