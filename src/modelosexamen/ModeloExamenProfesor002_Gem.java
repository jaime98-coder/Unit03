package modelosexamen;

import java.util.Scanner;

public class ModeloExamenProfesor002_Gem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Frase larga
		String transmisionLarga;
		System.out.println("Introduce una frase larga (transmisión) donde buscar la firma del virus");
		transmisionLarga = sc.nextLine();
		// Frase corta
		System.out.println("Introduce la firma del virus a buscar en la transmisión");
		String firmaVirus;
		firmaVirus = sc.nextLine();

		// frase larga (transmision) sin espacios y en minusculas
		String transmisionLimpia;
		transmisionLimpia = limpiarTransmision(transmisionLarga);
		// frase larga (transmision) sin espacios y en minusculas
		String firmaVirusLimpia;
		firmaVirusLimpia = limpiarTransmision(firmaVirus);
		// Número de veces que se ha detectado la firma.
		int numeroVecesFirmaDetectada = 0;
		// tabla de caracteres de la transmision
		char[] tablaCaracteresTransmision;
		// tabla de caracteres de la firma del virus
		char[] tablaCaracteresFirma;
		// tabla de caracteres de la frase larga
		tablaCaracteresTransmision = desglosarEnCaracteres(transmisionLimpia);
		// tabla de caracteres de la firma
		tablaCaracteresFirma = desglosarEnCaracteres(firmaVirusLimpia);
		// Posiciones de la firma
		int[] tablaPosiciones;
		tablaPosiciones = rastrearFirma(tablaCaracteresTransmision, tablaCaracteresFirma);
		// Numero de veces firma detectada
		numeroVecesFirmaDetectada = tablaPosiciones.length;
		System.out.println(
				"Se ha detectado la firma del virus " + numeroVecesFirmaDetectada + " veces, en la transmisión");
		// Posiciones que empieza cada firma
		System.out.println("Posiciones en las que empieza cada firma del virus: ");
		for (int posicion : tablaPosiciones) {
			System.out.println("[" + posicion + "]\t");
		}
		
		// Porcentaje de infección de la transmisión
		double porcentajeInfeccion;
		porcentajeInfeccion = calcularNivelInfeccion(transmisionLimpia, firmaVirusLimpia, numeroVecesFirmaDetectada);
		System.out.println("El nivel de infección de la transmisión es: " + porcentajeInfeccion + "%");

		sc.close();
	}

	/**
	 * Método para que el parametro de entrada se quede sin espacios y en minúsculas
	 * 
	 * @param frase
	 * @return String frase limpia
	 */
	public static String limpiarTransmision(String transmisionLarga) {
		String fraseLimpia;
		fraseLimpia = transmisionLarga.toLowerCase().replace(" ", "");
		return fraseLimpia;
	}

	/**
	 * Método para desglosar una frase en caracteres (crear un array de char a
	 * partir de String)
	 * 
	 * @param frase
	 * @return tabla de caracteres de la frase metida como parametro de entrada
	 */
	public static char[] desglosarEnCaracteres(String frase) {
		char[] tablaCaracteres;
		tablaCaracteres = frase.toCharArray();

		return tablaCaracteres;
	}

	/**
	 * Devuelve un array de números enteros (int[]) únicamente con las posiciones de
	 * inicio donde comienza cada aparición de la firma.
	 * 
	 * @param tablaCaracteresTransmision
	 * @param tablaCaracteresFirma
	 * @return int [] array con las posiciones de inicio de cada aparicion de la
	 *         firma
	 */
	public static int[] rastrearFirma(char[] tablaCaracteresTransmision, char[] tablaCaracteresFirma) {
		int[] tablaPosicionesAuxiliar;
		int[] tablaPosicionesExacta;
		// Creo un array auxiliar con el mismo tamaño que la tabla de caracteres de la
		// transmision, para almacenar ahí las posiciones de inicio de cada aparición de
		// la firma. Luego, una vez que sepa cuántas apariciones hay, crearé un nuevo
		// array con el tamaño exacto para almacenar solo las posiciones de inicio de
		// cada aparición de la firma.
		tablaPosicionesAuxiliar = new int[tablaCaracteresTransmision.length];
		int indiceFirmaVirus = 0;
		// Variable para cuando encuentres la primera letra del mensaje, guardar ahí en
		// qué posición del texto largo la encontre.
		int posicionInicialTemporal = 0;
		// Contador de apariciones de la firma del virus en el texto
		int contadorApariciones = 0;
		for (int i = 0; i < tablaCaracteresTransmision.length; i++) {
			if (tablaCaracteresTransmision[i] == tablaCaracteresFirma[indiceFirmaVirus]) {
				if (indiceFirmaVirus == 0) {
					posicionInicialTemporal = i;
				}
				indiceFirmaVirus++;
			}
			// Si el indiceFirma es igual a la longitud de la tabla de caracteres de la
			// firma, significa que hemos encontrado una aparición completa de la firma en
			// el texto.
			if (indiceFirmaVirus == tablaCaracteresFirma.length) {

				tablaPosicionesAuxiliar[contadorApariciones] = posicionInicialTemporal;
				contadorApariciones++;
				// Se pone a 0 el indiceMensaje. Así mi programa estará listo para empezar a
				// buscar la siguiente aparición de la palabra en las letras que quedan del
				// texto
				indiceFirmaVirus = 0;
			}
		}
		// Ahora que ya tengo el número de apariciones, creo un nuevo array con el
		// tamaño exacto para almacenar solo las posiciones de inicio de cada aparición
		// de la firma.
		tablaPosicionesExacta = new int[contadorApariciones];
		for (int j = 0; j < tablaPosicionesExacta.length; j++) {
			tablaPosicionesExacta[j] = tablaPosicionesAuxiliar[j];
		}

		// tablaPosicionesExacta es el array que devuelve el método, con el tamaño
		// exacto de las apariciones de la firma en el texto.
		return tablaPosicionesExacta;

	}

	/**
	 * Calcula el nivel de infección de la transmisión, que se obtiene a través de
	 * la siguiente fórmula:
	 * 
	 * @param transmisionLimpia
	 * @param firmaVirusLimpia
	 * @param numeroApariciones
	 * @return el nivel de infección de la transmisión en porcentaje, con dos
	 *         decimales, utilizando la fórmula: (número de caracteres de la firma
	 *         del virus * número de apariciones de la firma en la transmisión *
	 *         100) / número de caracteres de la transmisión
	 * 
	 */
	public static double calcularNivelInfeccion(String transmisionLimpia, String firmaVirusLimpia,
			int numeroApariciones) {
		double porcentajeInfeccion;
		porcentajeInfeccion = ((firmaVirusLimpia.length() * numeroApariciones) * 100.0) / transmisionLimpia.length();

		return porcentajeInfeccion;
	}

}
