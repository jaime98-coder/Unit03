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
		boolean estaJuegoActivo = true;
		// Muestro panel
		mostrarPanel(abecedario);

		// Desordeno panel
//		desordenaAbecedario(abecedario);

		// Se da la eleccion de frase aleatoria y se imprime
		fraseReal = eligeFrase(frases);
		System.out.println("Frase en juego:");
		System.out.println(fraseReal);

		// Codificar frase
		fraseCodificada = codificaFrase(fraseReal, abecedario);
		System.out.println(fraseCodificada);

		// Comprobar codigo
		int codigo;
		int letra;

		sc.close();
	}

	public static void mostrarPanel(char[][] abecedario) {
		for (int i = 0; i < abecedario.length; i++) {
			for (int j = 0; j < abecedario[i].length; j++) {
				System.out.print(abecedario[i][j]);
				if (j < (abecedario[i].length - 1)) {
					System.out.print(", ");
				}
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

				abecedario[i][j] = abecedario[filaRandom][colRandom];

			}
		}
	}

	public static String eligeFrase(String[] frases) {
		Random aleatorio = new Random();
		String fraseAleatoria;
		int posicionAzar = aleatorio.nextInt(frases.length);
		fraseAleatoria = frases[posicionAzar];
		return fraseAleatoria;

	}

	public static String codificaFrase(String fraseReal, char[][] abecedario) {
		String fraseCodificada = "";
		char letraActual;
		boolean encontrada;
		char[] letrasSeparadas = fraseReal.toCharArray();

		for (int i = 0; i < letrasSeparadas.length; i++) {
			letraActual = letrasSeparadas[i];
			encontrada = false;
			if (letraActual == ' ') {
				fraseCodificada += "  ";
			} else {
				for (int j = 0; j < abecedario.length && !encontrada; j++) {
					for (int k = 0; k < abecedario[j].length && !encontrada; k++) {
						if (abecedario[j][k] == letraActual) {
							fraseCodificada += j + "" + k + " ";
							encontrada = true;
						}

					}
				}
			}

		}

		return fraseCodificada;

	}

	public static boolean compruebaCodigo(int codigo, char letra, char[][] abecedario, String fraseCodificada) {
	
	}

}
