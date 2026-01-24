package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloExamen002_Arrays {

	public static void main(String[] args) {
		Random aleatorio = new Random();
		Scanner sc = new Scanner(System.in);
		char[][] abecedario = { { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
				{ 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q' }, { 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } };
		String[] frases = {
				"las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos",
				"aprende a vivir y sabras morir bien", "cada dia sabemos mas y entendemos menos",
				"el dinero no puede comprar la vida", "la verdadera sabiduria esta en reconocer la propia ignorancia" };
		String fraseReal;
		String fraseCodificada;
		mostrarPanel(abecedario);

		sc.close();
	}

	public static void mostrarPanel(char[][] abecedario) {
		for (int i = 0; i < abecedario.length; i++) {
			for (int j = 0; j < abecedario[i].length; j++) {
				System.out.print(abecedario[i][j] + ", ");
			}
			System.out.println();
		}
	}

	public static void desordenaAbecedario(char[][] abecedario) {
		Random aleatorio = new Random();
		for (int i = 0; i < abecedario.length; i++) {
			for (int j = 0; j < abecedario[i].length; j++) {
				int filaRandom;
				filaRandom = aleatorio.nextInt(abecedario.length);
				int colRandom;
				colRandom = aleatorio.nextInt(abecedario[0].length);

				char abecedarioAux = abecedario[i][j];
				
				abecedario[i][j] = abecedario[filaRandom][colRandom];
				

			}
		}
	}

	public static String eligeFrase(String[] frases) {
		Random aleatorio = new Random();
		String fraseAleatoria;
		for (int i = 0; i < frases.length; i++) {
			fraseAleatoria = frases[aleatorio.nextInt(0, frases.length)];
		}

	}

}
