package practicaexamen;

import java.util.Random;
import java.util.Scanner;

public class criptogramaReal {
	// Panel inicial ordenado
	static char[][] abecedario = { { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
			{ 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q' }, { 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } };
	// Repertorio de frases
	static String[] frases = { "las guerras seguiran mientras el color de la piel siga siendo mas importante",
			"que el de los ojos", "aprende a vivir y sabras morir bien", "cada dia sabemos mas y entendemos menos",
			"el dinero no puede comprar la vida", "la verdadera sabiduria esta en reconocer la propia ignorancia" };
	// Frase con la que se va a jugar
	static String fraseReal;
	// Frase real pero codificada con números según la posición de cada letra en el
	// abecedario
	static String fraseCodificada;

	static Random rd = new Random();

	public static void main(String[] args) {
		int codigoUsuario;
		char letraUsuario;
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------------------");
		System.out.println("Bienvenido al juego del CRIPTOGRAMA");
		System.out.println("-------------------------------------");
		boolean jugarDeNuevo = true;
		do {
			// Desordenamos el array del abecedario
			desordenaAbecedario();
			// Seleccionamos aleatoriamente la frase con la que jugar
			eligeFrase();
			// Codificamos la frase seleccionada
			codificaFrase();
			while (!sonIguales()) {
				System.out.println(fraseCodificada);
				System.out.println("Introduce un código: ");
				codigoUsuario = sc.nextInt();

				System.out.println("Introduce una letra: ");
				letraUsuario = sc.next().charAt(0);
				if (compruebaCodigo(codigoUsuario, letraUsuario)) {
					System.out.println("Has acertado");
				} else {
					System.out.println("No has acertado");
				}

			}
			sc.nextLine();
			System.out.println("¿Quieres jugar otra partida? (S/N)");
			String respuesta;
			boolean respuestaValida=false;
			while (!respuestaValida) {
				respuesta = sc.nextLine();
				if (respuesta.equalsIgnoreCase("S")) {
					jugarDeNuevo = true;
				} else if (respuesta.equalsIgnoreCase("N")) {
					jugarDeNuevo = false;
				} else {
					System.out.println("Responda S o N");
				} 
			}
		} while (jugarDeNuevo);

		sc.close();
	}

	/**
	 * Desordena las filas del abecedario
	 */
	static void desordenaAbecedario() {
		char variableAuxiliar;

		for (int i = 0; i < abecedario.length; i++) {
			int filaRd = rd.nextInt(3);
			for (int j = 0; j < abecedario[i].length; j++) {
				variableAuxiliar = abecedario[i][j];
				abecedario[i][j] = abecedario[filaRd][j];
				abecedario[filaRd][j] = variableAuxiliar;
			}
		}

	}

	/**
	 * Elige frase aleatoria del Array Frases
	 */
	static void eligeFrase() {
		fraseReal = frases[rd.nextInt(frases.length)];
	}

	/*
	 * Método para mostrar el abecedario
	 */
	static void mostrarAbecedario() {
		System.out.println("\t0" + "\t1" + "\t2" + "\t3" + "\t4" + "\t5" + "\t6" + "\t7" + "\t8");
		for (int i = 0; i < abecedario.length; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < abecedario[i].length; j++) {
				System.out.print(abecedario[i][j] + "\t");
			}
			System.out.println();
		}
	}

	// Esta función recibe UNA letra y te devuelve su código (ej: "14")
	static String buscarCoordenadas(char letra) {
		for (int i = 0; i < abecedario.length; i++) {
			for (int j = 0; j < abecedario[i].length; j++) {
				if (abecedario[i][j] == letra) {
					return i + "" + j; // Devuelve la fila y columna juntas
				}
			}
		}
		return ""; // Por si hay algún error y no la encuentra
	}

	static void codificaFrase() {
		fraseCodificada = "";

		// ¡SOLO UN BUCLE! Recorremos la fraseReal
		for (int i = 0; i < fraseReal.length(); i++) {

			char letraActual = fraseReal.charAt(i);

			// Regla del PDF: Los espacios de la fraseReal se convierten en dos espacios
			if (letraActual == ' ') {
				fraseCodificada += "  ";
			} else {
				// ¡Magia! Llamamos al ayudante y le sumamos el espacio separador
				fraseCodificada += buscarCoordenadas(letraActual) + " ";
			}
		}
	}

	static boolean compruebaCodigo(int codigo, char letra) {
		boolean hasAcertado = false;
		int fila = codigo / 10;
		int columna = codigo % 10;
		if (abecedario[fila][columna] == letra) {

			hasAcertado = true;

			String codigoExacto = fila + "" + columna;

			fraseCodificada = fraseCodificada.replace(codigoExacto, String.valueOf(letra));
		}

		return hasAcertado;
	}

	static boolean sonIguales() {
		boolean sonIguales;
		// Quitamos todos los espacios en blanco de ambas frases y luego las comparamos
		String realSinEspacios = fraseReal.replace(" ", "");
		String codificadaSinEspacios = fraseCodificada.replace(" ", "");
		if (codificadaSinEspacios.equals(realSinEspacios)) {
			System.out.println("Acierto");

			sonIguales = true;
		} else {

			sonIguales = false;
		}
		return sonIguales;

	}

}
