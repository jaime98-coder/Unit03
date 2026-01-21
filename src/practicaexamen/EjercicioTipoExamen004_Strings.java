package practicaexamen;

import java.util.Scanner;

public class EjercicioTipoExamen004_Strings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una contraseña (min 8 caracteres, 1 Mayuscula y 1 Numero):");
		String contraseñaUsuario = sc.nextLine();
		boolean contraseñaValida;
		contraseñaValida = validarPassword(contraseñaUsuario);
		if (contraseñaValida) {
			System.out.println("La contraseña es segura");
		} else {
			System.out.println("La contraseña no es segura");
		}
		sc.close();
	}

	public static boolean validarPassword(String contraseña) {
		boolean longitudCorrecta = false;
		boolean tieneMayuscula = false;
		boolean tieneNumero = false;
		boolean contraseñaCorrecta = false;

		char letraActual;

		if (contraseña.length() >= 8) {

			longitudCorrecta = true;
		}
		if (longitudCorrecta) {
			for (int i = 0; i < contraseña.length(); i++) {
				letraActual = contraseña.charAt(i);

				if (Character.isUpperCase(letraActual)) {

					tieneMayuscula = true;
				}
				if (Character.isDigit(letraActual)) {

					tieneNumero = true;

				}
			}
		}
		if (longitudCorrecta && tieneMayuscula && tieneNumero) {
			contraseñaCorrecta = true;
		}
		return contraseñaCorrecta;
	}

}
