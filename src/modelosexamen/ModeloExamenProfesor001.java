package modelosexamen;

import java.util.Scanner;

public class ModeloExamenProfesor001 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Declaración de variables primitivas en la parte superior (Buena práctica)
		int numeroApariciones = 0;
		double porcentajeTexto;
		
		// Solicitud de datos al usuario
		System.out.println("Introduce un texto largo donde buscar un mensaje oculto");
		String textoLargo = sc.nextLine();
		System.out.println("Introduce el mensaje oculto a buscar");
		String mensajeOculto = sc.nextLine();
		
		String textoNormalizado;
		String mensajeOcultoNormalizado;
		textoNormalizado = textoNormalizado(textoLargo);
		mensajeOcultoNormalizado = textoNormalizado(mensajeOculto);

		// Análisis de texto
		// Declaración e inicialización de arrays justo antes de su bloque lógico (Buena práctica)
		char[] almacenLetrasTextoLargo = convertirAArrayLetras(textoNormalizado);
		char[] almacenLetrasFraseOculta = convertirAArrayLetras(mensajeOcultoNormalizado);

		// Declaración de este array justo en el momento de usarlo por primera vez
		int[] posicionesMensajeOculto = buscarMensaje(almacenLetrasTextoLargo, almacenLetrasFraseOculta);
		
		// Calculamos cuántas veces aparece usando la longitud del array devuelto
		numeroApariciones = posicionesMensajeOculto.length;

		// Mostramos el total de apariciones (Requisito del examen)
		System.out.println("El mensaje aparece un total de " + numeroApariciones + " veces.");
		
		System.out.println("Posiciones donde comienza cada mensaje oculto:");
		// Bucle for-each para recorrer el array de resultados y extraer cada posición individual
		for (int posicion : posicionesMensajeOculto) {
			System.out.print(posicion+"\t");
		}
		System.out.println();
		
		// Porcentaje de letras del texto que han sido utilizadas para formar mensajes.
		porcentajeTexto = calcularPorcentajeTexto(textoNormalizado, mensajeOcultoNormalizado, numeroApariciones);
		System.out.println("Porcentaje de letras utilizadas: " + porcentajeTexto + "%");

		sc.close();
	}
/**
 *  Método para normalizar el texto, quitando espacios y poniendo todo en minúscula. Así evitamos problemas de mayúsculas o espacios a la hora de buscar el mensaje oculto.
 * @param textoLargo
 * @return String texto sin espacios
 */
	public static String textoNormalizado(String textoLargo) {
		String textoNormalizado;
		// IMPORTANTE ESTO PARA QUITAR ESPACIOS DE TODOS LADOS
		textoNormalizado = textoLargo.toLowerCase().replace(" ", "");

		return textoNormalizado;
	}

	/**
	 * * @param texto para utilizarlo para dividirlo en letras
	 * @return array de char con las letras
	 */
	public static char[] convertirAArrayLetras(String texto) {
		// En funciones auxiliares se permite declarar e inicializar en la misma línea
		char[] arrayLetras = texto.toCharArray();

		return arrayLetras;
	}

	/**
	 * * @param arrayLetrasTexto
	 * @param arrayLetrasMensajeOculto
	 * @return un array de int con las posiciones donde aparece las letras del
	 * mensaje oculto en el array letras texto
	 */
	public static int[] buscarMensaje(char[] arrayLetrasTexto, char[] arrayLetrasMensajeOculto) {
		// Para almacenar las posiciones en bruto (declarado e inicializado por contexto)
		int[] posicionesAparicionTemporal = new int[arrayLetrasTexto.length];
		// Para almacenar las posiciones exactas, con su tamaño correspondiente
		int[] posicionesAparicion;
		
		// Variable para almacenar el índice de la letra que estoy buscando
		int indiceMensaje = 0;
		// Variable para cuando encuentres la primera letra del mensaje, guardar ahí en qué
		// posición del texto largo la encontre.
		int posicionInicialTemporal = 0;
		// Contador de apariciones del mensaje oculto en el texto
		int contadorApariciones = 0;
		
		// Contador i que recorre el texto largo de principio a fin evaluando coincidencias
		for (int i = 0; i < posicionesAparicionTemporal.length; i++) {
			if (arrayLetrasTexto[i] == arrayLetrasMensajeOculto[indiceMensaje]) {
				if (indiceMensaje == 0) {
					// Solo si es la primera letra, guardo dónde ha empezado
					posicionInicialTemporal = i;
				}
				// Sea la primera, la segunda o la última letra, como ha coincidido,
				// sumo 1 para buscar la siguiente letra en la próxima vuelta.
				indiceMensaje++;
			}
			if (indiceMensaje == arrayLetrasMensajeOculto.length) {
				posicionesAparicionTemporal[contadorApariciones] = posicionInicialTemporal;
				contadorApariciones++;
				// Se pone a 0 el indiceMensaje. Así mi programa estará listo para empezar a
				// buscar la siguiente aparición de la palabra en las letras que quedan del texto
				indiceMensaje = 0;
			}
		}
		
		// Creo el array final con el tamaño exacto, utilizando el contador de apariciones
		posicionesAparicion = new int[contadorApariciones];
		
		// Contador i que se encarga de volcar los datos del array temporal al array final ajustado
		for (int i = 0; i < posicionesAparicion.length; i++) {
			// Paso el contenido del array en bruto (con un tamaño gigante) al array final
			// con el tamaño exacto
			posicionesAparicion[i] = posicionesAparicionTemporal[i];
		}
		return posicionesAparicion;
	}

	public static double calcularPorcentajeTexto(String textoNormalizado, String mensajeOcultoNormalizado, int numeroApariciones) {
		// En funciones auxiliares aplicamos inicialización directa
		int numeroLetrasTexto = textoNormalizado.length();
		int numeroLetrasFraseOculta = mensajeOcultoNormalizado.length() * numeroApariciones;
		double porcentajeTextoUtilizado;
		porcentajeTextoUtilizado = ((numeroLetrasFraseOculta * 100.0) / numeroLetrasTexto);

		return porcentajeTextoUtilizado;
	}
}