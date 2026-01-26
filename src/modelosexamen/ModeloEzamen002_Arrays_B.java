package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloEzamen002_Arrays_B {

	// --- VARIABLES GLOBALES ---
	static char[][] abecedario = { 
			{ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
			{ 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q' }, 
			{ 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } 
	};

	static String[] frases = {
			"las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos",
			"aprende a vivir y sabras morir bien", 
			"cada dia sabemos mas y entendemos menos",
			"el dinero no puede comprar la vida", 
			"la verdadera sabiduria esta en reconocer la propia ignorancia" 
	};

	static String fraseReal; 
	static String fraseCodificada; 

	// ---------------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Configuración inicial
		desordenaAbecedario();
		eligeFrase();
		codificaFrase();

		System.out.println("COMIENZA EL JUEGO");

		// Bucle del juego
		while (!sonIguales()) {

			System.out.println("\nFRASE ACTUAL: " + fraseCodificada);

			System.out.println("TABLA DE CÓDIGOS:");
			mostrarPanel();

			try {
				System.out.println("Introduce el CÓDIGO:");
				int codigoUsuario = sc.nextInt();

				System.out.println("Introduce la LETRA:");
				char letraUsuario = sc.next().toLowerCase().charAt(0);

				boolean acierto = compruebaCodigo(codigoUsuario, letraUsuario);

				if (acierto) {
					System.out.println("Has acertado.");
				} else {
					System.out.println("No has acertado.");
				}
				
			} catch (java.util.InputMismatchException e) {
				System.out.println("Error: Introduce un número válido.");
				sc.nextLine(); // Limpiar buffer
			}
		} 

		System.out.println("\n¡ENHORABUENA! HAS GANADO");
		System.out.println("Frase final: " + fraseCodificada);

		sc.close();
	}

	// --- MÉTODOS ---

	public static void mostrarPanel() {
		// Solo dejo este formato porque es necesario para leer la tabla
		System.out.println("   0 1 2 3 4 5 6 7 8");
		System.out.println("  -------------------");
		for (int i = 0; i < abecedario.length; i++) {
			System.out.print(i + "| "); 
			for (int j = 0; j < abecedario[i].length; j++) {
				System.out.print(abecedario[i][j] + " ");
			}
			System.out.println(); 
		}
	}

	public static void desordenaAbecedario() {
		Random aleatorio = new Random();
		char auxiliar; 

		for (int i = 0; i < abecedario.length; i++) {
			for (int j = 0; j < abecedario[i].length; j++) {
				int fRandom = aleatorio.nextInt(abecedario.length);
				int cRandom = aleatorio.nextInt(abecedario[0].length);

				auxiliar = abecedario[i][j]; 
				abecedario[i][j] = abecedario[fRandom][cRandom]; 
				abecedario[fRandom][cRandom] = auxiliar; 
			}
		}
	}

	public static void eligeFrase() {
		Random aleatorio = new Random();
		int posicion = aleatorio.nextInt(frases.length);
		fraseReal = frases[posicion];
	}

	public static void codificaFrase() {
		fraseCodificada = "";
		char[] letras = fraseReal.toCharArray();
		boolean encontrada;

		for (int i = 0; i < letras.length; i++) {
			char letraActual = letras[i];
			encontrada = false;

			if (letraActual == ' ') {
				fraseCodificada += "  "; 
			} else {
				for (int f = 0; f < abecedario.length && !encontrada; f++) {
					for (int c = 0; c < abecedario[f].length && !encontrada; c++) {
						if (abecedario[f][c] == letraActual) {
							fraseCodificada += f + "" + c + " ";
							encontrada = true;
						}
					}
				}
			}
		}
	}

	public static boolean compruebaCodigo(int codigo, char letra) {
		boolean exito = false;
		int f = codigo / 10;
		int c = codigo % 10;

		if (f < abecedario.length && c < abecedario[f].length) {
			if (abecedario[f][c] == letra) {
				exito = true;

				String codigoTexto = (codigo < 10) ? "0" + codigo : "" + codigo;
				String nuevaFrase = "";
				String[] trozos = fraseCodificada.split(" ");

				for (int i = 0; i < trozos.length; i++) {
					if (trozos[i].equals(codigoTexto)) {
						nuevaFrase += letra; 
					} else {
						nuevaFrase += trozos[i]; 
					}
					nuevaFrase += " "; 
				}
				fraseCodificada = nuevaFrase;
			}
		}
		return exito;
	}

	public static boolean sonIguales() {
		String codificadaLimpia = fraseCodificada.replace(" ", "");
		String realLimpia = fraseReal.replace(" ", "");
		return codificadaLimpia.equals(realLimpia);
	}
}