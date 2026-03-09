package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloExamen002_Arrays_Cript {
	// Declaro e inicializo abecedario ordenado
	static char[][] abecedario = { { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
			{ 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q' }, { 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } };
	// Declaro e inicializo las frases
	static String[] frases = {
			"las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos",
			"aprende a vivir y sabras morir bien", "cada dia sabemos mas y entendemos menos",
			"el dinero no puede comprar la vida", "la verdadera sabiduria esta en reconocer la propia ignorancia" };
	// Frase con la que se va a jugar
	static String fraseReal = "";
	// Frase codificada
	static String fraseCodificada = "";
	static Random rd = new Random();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Booleano de fin de partida
		boolean sonDistintas = true;
		// Variable para almacenar el resultado del Scanner donde el usuario introducirá
		// el código
		int codigoUsuario;
		// Para almacenar la letra del usuario a la que se refiere con el código
		// anterior
		char letraUsuario;
		// Variable de control para cuando ocurre una exception
		boolean entradaValida = false;

		System.out.println("Bienvenidos al juego del CRIPTOGRAMA");
		// Desordena el abecedario
		System.out.println("Desordenando abecedario...");
		desordenaAbecedario();
		// Selecciona de forma aleatoria la frase con la que se va a jugar
		System.out.println("Seleccionando frase con la que jugar...");
		eligeFrase();
		// Se codifica la frase
		System.out.println("Codificando la frase seleccionada...");
		codificaFrase();

		// Siempre que sea distinto la fraseReal y fraseCodificada se repetirá este
		// bucle/bandera
		while (sonDistintas) {
			// Muestro abecedario para verificar que funciona correctamente el programa
			mostrarAbecedario();
			System.out.println();
			// Imprime en pantalla el estado actual de la frase codificada
			System.out.println("Frase codificada:");
			System.out.println(fraseCodificada);
			entradaValida = false;
			// Uso la variable de control para cuando el usuario introduce un codigo
			// inválido, volver aqui
			while (!entradaValida) {

				try {
					System.out.println("Introduce un código");
					codigoUsuario = sc.nextInt();
					System.out.println("Introduce una letra");
					letraUsuario = sc.next().charAt(0);
					// Cambio la entradaValida a true para salir del bucle while ed control
					entradaValida = true;
					// Lógica de comprobación indicando al usuario si acertó o no e indicandoselo
					// mediante un print
					if (compruebaCodigo(codigoUsuario, letraUsuario)) {
						System.out.println("Has acertado");

					} else {
						System.out.println("No has acertado");
					}
					// Uso del método para comprobar si hay victoria
					if (sonIguales()) {
						System.out.println("Has adivinado la frase oculta");
						// Cambio la variable bandera a false para que salga del bucle general
						// while(sonDistintas)
						sonDistintas = false;
					}
				} catch (Exception e) {
					System.out.println("Error de formato, código inválido");
					// Tras capturar la excepción, reseteo el buffer con el código inválido
					sc.nextLine();
				}
			}

		}
		// Mensaje final felicitando y fin del programa
		System.out.println("¡Enhorabuena!¡Has ganado!");
		System.out.println("----------------------------");
		System.out.println("Fin del programa...");
		sc.close();
	}

	/**
	 * Desordena el abecedario, pero intercambiando las letras, para que no se
	 * repitan
	 */
	public static void desordenaAbecedario() {
		int filaAleatoria;
		int columnaAleatoria;
		// Variable aux para almacenar el contenido de cada posición del array
		// abecedario, para así intercambiar posteriormente las posiciones, y que no se
		// pierdan letras.
		char variableAuxiliar;

		// Bucle para recorrer las filas
		for (int i = 0; i < abecedario.length; i++) {
			// Bucle para recorrer las columnas
			for (int j = 0; j < abecedario[i].length; j++) {
				filaAleatoria = rd.nextInt(abecedario.length);
				columnaAleatoria = rd.nextInt(abecedario[0].length);
				// Variable auxiliar para almacenar cada posicion y luego en la misma iteración
				// poder intercambiar las
				// posiciones
				variableAuxiliar = abecedario[i][j];
				abecedario[i][j] = abecedario[filaAleatoria][columnaAleatoria];
				// Aquí se produciría el intercambio
				abecedario[filaAleatoria][columnaAleatoria] = variableAuxiliar;
			}

		}
	}

	/**
	 * Elige aleatoriamente una frase del Array frases y la almacena en el String
	 * fraseReal
	 */
	public static void eligeFrase() {
		int posicionFraseAleatoria;
		posicionFraseAleatoria = rd.nextInt(frases.length);
		fraseReal = frases[posicionFraseAleatoria];
	}

	/**
	 * Función EXTRA para recibir una letra y que te devuelva su código
	 * 
	 * @param letra a buscar
	 * @return cadena con el código en formato String, para que después se pueda
	 *         buscar como String
	 */
	public static String buscarCoordenadas(char letra) {
		String cadenaCodigo = "";
		for (int i = 0; i < abecedario.length; i++) {
			for (int j = 0; j < abecedario[i].length; j++) {
				if (abecedario[i][j] == letra) {
					cadenaCodigo = cadenaCodigo + i + j;
				}
			}

		}
		return cadenaCodigo;

	}

	/**
	 * Método para codificar la frase
	 */
	public static void codificaFrase() {
		// Variable para almacenar la letra actual de cada posición del String fraseReal
		char letraActual;
		// Debemos recorrer la longitud DE LA FRASE (no del abecedario)
		for (int i = 0; i < fraseReal.length(); i++) {
			// Almaceno el valor de cada posición del String fraseReal, para usarla después
			letraActual = fraseReal.charAt(i);

			// Si es espacio, ponemos doble espacio como pide el enunciado
			if (letraActual == ' ') {
				fraseCodificada += "  ";
			} else {
				// Buscamos las coordenadas con el método EXTRA y le concatenamos el espacio
				// separador
				fraseCodificada += buscarCoordenadas(letraActual) + " ";
			}
		}
	}

	/**
	 * 
	 * @param codigo. el código de la frase codificada
	 * @param letra.  la letra a la que se refiere el usuario tras introducir codigo
	 * @return TRUE si has acertado el código respecto a la letra introducida. FALSE
	 *         si no
	 */
	public static boolean compruebaCodigo(int codigo, char letra) {
		boolean hasAcertado = false;
		int fila;
		int columna;
		// Para sacar el primer valor del código introducido (ej: codigo=15. Pues sería
		// el 1)
		fila = codigo / 10;
		// Para sacar el segundo valor del código introducido (el resto de la división)
		// (ej: codigo=15. Pues sería el 5)
		columna = codigo % 10;
		// Condición de comprobación donde se comprueba a partir de la posicion del
		// abecedario con fila y columna
		if (abecedario[fila][columna] == letra) {
			hasAcertado = true;
			// Para convertir un int a cadena, y poder luego utilizarlo
			String codigoExacto = fila + "" + columna;
			// Le asigno y reemplazo a fraseCodificada el String de codigoExacto, por el
			// valor de la letra introducida (asi se destaparia el código)
			fraseCodificada = fraseCodificada.replace(codigoExacto, String.valueOf(letra));
		}
		return hasAcertado;

	}

	/**
	 * Método de comprobación de victoria, para comprobar si la frase codificada y
	 * la frase real son iguales
	 * 
	 * @return
	 */
	public static boolean sonIguales() {
		boolean sonIguales = false;
		if (fraseCodificada.replace(" ", "").equals(fraseReal.replace(" ", ""))) {
			sonIguales = true;
		}
		return sonIguales;

	}

	/**
	 * Método extra para poder verificar si el programa funciona correctamente de
	 * forma rápida, imprimiento el abecedario
	 */
	public static void mostrarAbecedario() {
		System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7\t8\t");
		for (int i = 0; i < abecedario.length; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < abecedario[i].length; j++) {
				System.out.print(abecedario[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
