package ejerciciosrepaso;

public class Repaso_Ejercicio003 {

	public static void main(String[] args) {
		String texto = "En un lugar de la Mancha2, de cuyo nombre no quiero acordarme3, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor";
		String[] claves = { "mancha", "hidalgo", "sevilla", "caballo", "lanza", "java" };
		String[] encontradas = palabrasEncontradas(texto, claves);
		mostrarResultado(encontradas);

	}

	/**
	 * Comprueba si una palabra está contenida en un texto, sin importar mayúsculas
	 * o minúsculas.
	 * 
	 * @param texto
	 * @param palabra
	 * @return true si la palabra está contenida en el texto, false en caso
	 *         contrario.
	 */
	static boolean contienePalabra(String texto, String palabra) {
		String textoMinuscula = texto.toLowerCase();
		String palabraMinuscula = palabra.toLowerCase();

		return textoMinuscula.contains(palabraMinuscula);
	}

	static String[] palabrasEncontradas(String texto, String[] claves) {
		int contadorParaTamañoArray = 0;
		for (int i = 0; i < claves.length; i++) {
			if (contienePalabra(texto, claves[i])) {
				contadorParaTamañoArray++;
			}
		}
		String[] resultado = new String[contadorParaTamañoArray];
		int posicionResultadoAux = 0;
		for (int i = 0; i < claves.length; i++) {
			if (contienePalabra(texto, claves[i])) {
				resultado[posicionResultadoAux] = claves[i];
				posicionResultadoAux++;
			}
		}
		return resultado;
	}

	static void mostrarResultado(String[] encontradas) {
		if (encontradas.length == 0) {
			System.out.println("No se han encontrado palabras");

		} else {
			System.out.println("Palabras encontradas:");
			for (int i = 0; i < encontradas.length; i++) {
				System.out.print(encontradas[i]);
				{
					if (i < encontradas.length - 1) {
						System.out.print(", ");
					}
				}
			}
		}
	}

}
