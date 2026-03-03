package modelosexamen;

import java.util.Scanner;

public class ModeloExamenProfesor001 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Introduce un texto largo donde buscar un mensaje oculto");
		String textoLargo = sc.nextLine();
		System.out.println("Introduce el mensaje oculto a buscar");
		String mensajeOculto = sc.nextLine();

		String textoNormalizado;
		int [] posicionesMensajeOculto;
		textoNormalizado = textoNormalizado(textoLargo);
		System.out.println("Prueba de texto normalizado:");
		System.out.println(textoNormalizado);
		// Almacen de letras tras convertir el texto normalizado a un char []
		char[] almacenLetrasTextoLargo;
		char[] almacenLetrasFraseOculta;
		// Para almacenar las letras del Texto Largo
		almacenLetrasTextoLargo = convertirAArrayLetras(textoNormalizado);
		// Para almacenar las letras de Frase Oculta en un array 
		almacenLetrasFraseOculta = convertirAArrayLetras(textoNormalizado);
		// Almacenando las posiciones 
		posicionesMensajeOculto=buscarMensaje(almacenLetrasTextoLargo, almacenLetrasFraseOculta);
		System.out.println("Posiciones mensaje oculto:");
		for (int posicion: posicionesMensajeOculto) {
			System.out.println(posicion);
		}
		sc.close();
	}

	public static String textoNormalizado(String textoLargo) {
		String textoNormalizado;
		textoNormalizado = textoLargo.toLowerCase().trim();

		return textoNormalizado;
	}

	/**
	 * 
	 * @param texto para utilizarlo para dividirlo en letras
	 * @return array de char con las letras
	 */
	public static char[] convertirAArrayLetras(String texto) {
		char[] arrayLetras;

		arrayLetras = texto.toCharArray();

		return arrayLetras;
	}

	/**
	 * 
	 * @param arrayLetrasTexto
	 * @param arrayLetrasMensajeOculto
	 * @return un array de int con las posiciones donde aparece las letras del
	 *         mensaje oculto en el array letras texto
	 */
	public static int[] buscarMensaje(char[] arrayLetrasTexto, char[] arrayLetrasMensajeOculto) {
		int[] posicionesAparicion;
		boolean finalArrayMensaje = false;
		posicionesAparicion = new int[arrayLetrasMensajeOculto.length];
		for (int i = 0; i < arrayLetrasTexto.length && !finalArrayMensaje; i++) {
			if (arrayLetrasTexto[i] == arrayLetrasMensajeOculto[i]) {
				posicionesAparicion[i] = i;
			}
			if (i == arrayLetrasMensajeOculto.length) {
				finalArrayMensaje = true;
			}
		}

		return posicionesAparicion;

	}

//	public static double calcularPorcentajeTexto() {
//		
//		return ;
//	}
}
