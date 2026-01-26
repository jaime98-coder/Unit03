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
		System.out.println("Panel inicial antes de desordenar:");
		mostrarPanel(abecedario);

		// Desordeno panel


		desordenaAbecedario(abecedario);


		// Se da la eleccion de frase aleatoria y se imprime
		fraseReal = eligeFrase(frases);
		System.out.println("Frase en juego:");
		System.out.println(fraseReal);

		// Codificar frase
		fraseCodificada = codificaFrase(fraseReal, abecedario);
		System.out.println("Frase codificada:");
		System.out.println(fraseCodificada);

		do {
			// Comprobar codigo
			System.out.println("Panel en juego:");
			mostrarPanel(abecedario);
			int codigo;
			char letra;
			System.out.println("Introduce el código de la letra");
			codigo = sc.nextInt();
			System.out.println("Introduce la letra");
			letra = sc.next().charAt(0);
			boolean respuestaResultado;
			respuestaResultado = compruebaCodigo(codigo, letra, abecedario, fraseCodificada);

			if (respuestaResultado) {
				System.out.println("Has acertado");
			} else {
				System.out.println("No has acertado");
			}
		} while (!fraseCodificada.equals(fraseReal));
		if (fraseCodificada.equals(fraseReal)) {
			estaJuegoActivo = false;
			System.out.println("¡Has ganado!");
			System.out.println("¡Fin del programa!");
		}
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
		boolean esCorrecto = false;
		int fila;
		int columna;
		String codigoBuscado = "";
		String fraseResultado = "";
		// Cálculo de coordenadas
		fila = codigo / 10;
		columna = codigo % 10;

		// Verificamos coordenadas de seguridad (para no salirnos del array)
		if (fila < abecedario.length && columna < abecedario[fila].length) {
			if (abecedario[fila][columna] == letra) {
				esCorrecto = true;

				if (codigo < 10) {
					codigoBuscado = "0" + codigo;
				} else {
					codigoBuscado = "" + codigo;
				}
				// 4. Troceamos la frase que nos pasaron usando el espacio como separador
				String[] trozos = fraseCodificada.split(" ");

				// 5. Reconstruimos la frase nueva recorriendo los trozos
				for (int i = 0; i < trozos.length; i++) {
					// Si el trozo actual es igual al código que buscamos pegamos la letra
					// descifrada
					if (trozos[i].equals(codigoBuscado)) {
						fraseResultado += letra;
						// Sino pegamos el trozo original de nuevo (los números)
					} else {
						fraseResultado += trozos[i];
					}
					fraseResultado += " ";

				}
				System.out.println("Resultado dentro de la funcion: " + fraseResultado);
			}

		}
		return esCorrecto;
	}

	public static boolean sonIguales(String fraseCodificada, String fraseReal) {
		boolean sonIgual = false;
		String fraseCodificadaSinEspacios = fraseCodificada.replace(" ", "");
		String fraseRealSinEspacios = fraseReal.replace(" ", "");

		if (fraseCodificadaSinEspacios.equals(fraseRealSinEspacios)) {
			sonIgual = true;
		}

		return sonIgual;
	}

}
