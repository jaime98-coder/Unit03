package practicaexamen;

import java.util.Scanner;

public class HackeoDelSistemaGem {

	public static void main(String[] args) {
		char[] solucion = { '@', '#', '$', '&', '#', '@', '&', '$' };
		char[] visible = new char[8];
		int intentosRestantes = 4;
		int posicion1;
		int posicion2;
		Scanner sc = new Scanner(System.in);
		inicializarPanel(visible);

		while (intentosRestantes > 0 && !sistemaDesbloqueado(visible)) {
			System.out.println("Intentos restantes: " + intentosRestantes);
			mostrarPanel(visible);
			boolean jugadaValida = false;
			while (!jugadaValida) {
				// Pedir al usuario que introduzca las posiciones de las casillas a desbloquear
				System.out.println("Introduce la posición 1: ");
				posicion1 = sc.nextInt();
				System.out.println("Introduce la posición 2: ");
				posicion2 = sc.nextInt();
				// Comprobar si la jugada es válida
				if (esJugadaValida(posicion1, posicion2, visible)) {
					jugadaValida = true;
					if (solucion[posicion1] == solucion[posicion2]) {
						System.out.println("¡Pareja encontrada!");
						visible[posicion1] = solucion[posicion1];
						visible[posicion2] = solucion[posicion2];

					} else {
						System.out.println("Fallo. Has visto: " + solucion[posicion1] + " y " + solucion[posicion2]);
						intentosRestantes--;
					}

				} else {
					System.out.println("Jugada no válida. Indique las dos posiciones de nuevo");
				}
			}

		}
		if (sistemaDesbloqueado(visible)) {
			System.out.println("---------------");
			System.out.println("¡Victoria!");
			System.out.println("---------------");

		} else {
			System.out.println("---------------------------");
			System.out.println("Intentos agotados...");
			System.out.println("¡HAS PERDIDO!");
			System.out.println("---------------------------");

		}
		sc.close();
	}

	public static void inicializarPanel(char[] visible) {
		for (int i = 0; i < visible.length; i++) {
			visible[i] = '-';

		}
	}

	public static void mostrarPanel(char[] visible) {
		System.out.println("0" + "\t1" + "\t2" + "\t3" + "\t4" + "\t5" + "\t6" + "\t7");
		for (int i = 0; i < visible.length; i++) {
			System.out.print(visible[i] + "\t");
		}
		System.out.println();
	}

	/**
	 * Si hay '-' = true, Si NO hay '-' = false
	 * 
	 * @param visible
	 * @return boolean noHayCasillas
	 */
	public static boolean sistemaDesbloqueado(char[] visible) {
		boolean noHayCasillas = true;
		for (int i = 0; i < visible.length && noHayCasillas; i++) {

			if (visible[i] == '-') {
				noHayCasillas = false;
				
			}
		}

		return noHayCasillas;
	}

	/**
	 * Si posicion1 y posicion2 estan entre 0 y 7, son distintas entre si y en
	 * visible en esas posiciones hay '-' = true. Si NO se cumple alguna de las
	 * condiciones anteriores = false
	 * 
	 * @param posicion1
	 * @param posicion2
	 * @param visible
	 * @return boolean esJugadaValida
	 */
	public static boolean esJugadaValida(int posicion1, int posicion2, char[] visible) {
		boolean esJugadaValida;

		if ((posicion1 >= 0 && posicion1 <= 7 && posicion2 >= 0 && posicion2 <= 7) && (posicion1 != posicion2)
				&& (visible[posicion1] == '-' && visible[posicion2] == '-')) {
			esJugadaValida = true;
		} else {
			esJugadaValida = false;
		}
		return esJugadaValida;
	}

}
