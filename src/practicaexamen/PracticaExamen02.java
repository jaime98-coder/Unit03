package practicaexamen;

import java.util.Random;
import java.util.Scanner;

public class PracticaExamen02 {
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();
	static char[][] abecedario = { { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
			{ 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q' }, { 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } };

	static String[] frases = {
			"las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos",
			"aprende a vivir y sabras morir bien", "cada dia sabemos mas y entendemos menos",
			"el dinero no puede comprar la vida", "la verdadera sabiduria esta en reconocer la propia ignorancia" };

	static String fraseReal;

	static String fraseCodificada;

	public static void main(String[] args) {
		imprimirPanel();
		desordenaAbecedario();
		imprimirPanel();

	}

	public static void desordenaAbecedario() {
		char auxLetra;
		for (int i = 0; i < abecedario.length; i++) {
			for (int j = 0; j < abecedario[i].length; j++) {
				int filaRd = rd.nextInt(abecedario.length);
				int columnaRd = rd.nextInt(abecedario[0].length);
				auxLetra = abecedario[i][j];
				abecedario[i][j] = abecedario[filaRd][columnaRd];
				abecedario[filaRd][columnaRd] = auxLetra;

			}
		}

	}

	public static void imprimirPanel() {
		for (int i = 0; i < abecedario.length; i++) {
			for (int j = 0; j < abecedario[i].length; j++) {
				System.out.print(abecedario[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}

}
