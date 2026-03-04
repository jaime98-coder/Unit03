package modelosexamen;

import java.util.Scanner;

public class ModeloExamenProfesor003_Gem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String secuenciaProduccion;
		String patronDefectuoso;
		String secuenciaProduccionLimpia;
		String patronDefectuosoLimpio;

		System.out.println("Introduce una secuencia de producción:");
		secuenciaProduccion = sc.nextLine();
		secuenciaProduccionLimpia = limpiarSecuencia(secuenciaProduccion);

		System.out.println("Introduce el patrón defectuoso para buscarlo en la secuencia de producción:");
		patronDefectuoso = sc.nextLine();
		patronDefectuosoLimpio = limpiarSecuencia(patronDefectuoso);

		// Syso de prueba para ver que se limpie
		System.out.println(secuenciaProduccionLimpia);

		// Variables char [] para almacenar los caracteres de ambas frases (secuencia y
		// patron)
		char[] secuenciaProdEnCaracteres;
		char[] patronDefectEnCaracteres;
		// Para llenar el array con la secuencia de produccion limpia
		secuenciaProdEnCaracteres = extraerArray(secuenciaProduccionLimpia);
		// Para llenar el array con el patron defectuoso limpio
		patronDefectEnCaracteres = extraerArray(patronDefectuosoLimpio);

		int[] posicionesInicialesPatron;
		posicionesInicialesPatron = buscarPatronConsecutivo(secuenciaProdEnCaracteres, patronDefectEnCaracteres);
		System.out.println("Posiciones iniciales donde se encuentra el patron defectuoso");
		for (int posicion : posicionesInicialesPatron) {
			System.out.println(posicion + "\t");
		}

		double porcentajeCalidad;
		porcentajeCalidad = evaluarCalidad(secuenciaProdEnCaracteres, patronDefectEnCaracteres,
				posicionesInicialesPatron.length);
		System.out.println("Porcentaje de calidad: " + porcentajeCalidad+"%");
		sc.close();
	}

	/**
	 * 
	 * @param texto
	 * @return String texto limpio
	 */
	public static String limpiarSecuencia(String texto) {
		String textoLimpio;
		textoLimpio = texto.toUpperCase().replace(" ", "").replace("-", "").replace("_", "");

		return textoLimpio;
	}

	/**
	 * 
	 * @param textoLimpio
	 * @return char [] caracteres del texto contenidos en un array
	 */
	public static char[] extraerArray(String textoLimpio) {
		char[] arrayCaracteres;
		arrayCaracteres = textoLimpio.toCharArray();
		return arrayCaracteres;
	}

	public static int[] buscarPatronConsecutivo(char[] arraySecuencia, char[] arrayPatronDefectuoso) {
		// Declaro variable auxiliar de tipo int para crear un array del maximo tamaño
		// (tamaño de la secuencia), para posteriormente pasarla a un array con el
		// tamaño exacto que contenga las posiciones iniciales del patron defectuoso
		int[] tablaPosicionesPatronAuxiliar;
		// Creo variable indicePatron para controlar la busqueda de los caracteres
		// dentro del arrayPatronDefectuoso
		int indicePatron = 0;
		// Contador de apariciones del patron en la secuencia de producción, para hacer
		// un array del tamaño exacto
		int aparicionesPatronDefectuoso = 0;

		int posicionInicialTemporal = 0;
		tablaPosicionesPatronAuxiliar = new int[arraySecuencia.length];
		// Creo bucle for donde la i será el indice para recorrer el arraySecuencia
		for (int i = 0; i < arraySecuencia.length; i++) {
			if (arraySecuencia[i] == arrayPatronDefectuoso[indicePatron]) {
				if (indicePatron == 0) {
					posicionInicialTemporal = i;
				}
				indicePatron++;
			} else {
				posicionInicialTemporal = 0;
				if (indicePatron>0) {
					i--;
				}
				indicePatron = 0;
				
			}
			if (arrayPatronDefectuoso.length == indicePatron) {
				tablaPosicionesPatronAuxiliar[aparicionesPatronDefectuoso] = posicionInicialTemporal;
				aparicionesPatronDefectuoso++;
				indicePatron = 0;
			}

		}

		int[] tablaPosicionesPatronExacta = new int[aparicionesPatronDefectuoso];
		for (int j = 0; j < tablaPosicionesPatronExacta.length; j++) {
			tablaPosicionesPatronExacta[j] = tablaPosicionesPatronAuxiliar[j];
		}

		return tablaPosicionesPatronExacta;

	}

	/**
	 * 
	 * @param arraySecuencia
	 * @param arrayPatronDefectuoso
	 * @param apariciones
	 * @return un tipo double que equivale al porcentaje
	 */
	public static double evaluarCalidad(char[] arraySecuencia, char[] arrayPatronDefectuoso, int apariciones) {
		double porcentajePiezasPatronDefectuosa;
		porcentajePiezasPatronDefectuosa = ((arrayPatronDefectuoso.length * apariciones) * 100.0)
				/ arraySecuencia.length;

		return porcentajePiezasPatronDefectuosa;
	}
}
