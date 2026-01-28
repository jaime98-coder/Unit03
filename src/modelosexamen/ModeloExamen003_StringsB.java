package modelosexamen;

import java.util.Scanner;

public class ModeloExamen003_StringsB {

	// Variables globales estáticas (según el enunciado)
	static String[][] juegos = { { "CASA", "PATO" }, { "BONO", "DEDO" }, { "RATA", "GATO" }, { "LUNA", "LOBO" } };

	static String palabraInicio;
	static String palabraObjetivo;
	static String jugada;

	public static void main(String[] args) {
		// Regla: Declaración de variables primitivas/referencias al inicio del main
		int intentosRealizados;
		int maximosIntentos;
		boolean juegoTerminado;
		boolean objetivoAlcanzado;
		String intentoUsuario;
		String ultimaPalabra;
		boolean esIntentoValido;

		// Regla: Instanciación del Scanner en la misma línea
		Scanner sc = new Scanner(System.in);

		// Inicialización de variables para la lógica del juego
		intentosRealizados = 0;
		maximosIntentos = 7;
		juegoTerminado = false;
		objetivoAlcanzado = false;

		// Selección del escenario de juego
		seleccionaJuego();

		System.out.println("=== BIENVENIDO A LA ESCALERA DE PALABRAS ===");
		System.out.println("Palabra de Inicio: " + palabraInicio);
		System.out.println("Palabra Objetivo:  " + palabraObjetivo);
		System.out.println("Tienes " + maximosIntentos + " intentos.");
		System.out.println("---------------------------------------------");

		// Regla: Bucle sin 'break', controlado por condiciones booleanas
		while (intentosRealizados < maximosIntentos && !juegoTerminado) {

			// Obtenemos la última palabra válida jugada
			ultimaPalabra = ultimoIntento();

			System.out.println("\nJugada actual: " + jugada);
			System.out.println("Introduce tu siguiente palabra (Intento " + (intentosRealizados + 1) + " de "
					+ maximosIntentos + "):");

			// Leemos y normalizamos a mayúsculas
			intentoUsuario = sc.next().toUpperCase();

			// Validación 1: Longitud correcta (4 letras)
			if (intentoUsuario.length() != 4) {
				System.out.println("Error: La palabra debe tener exactamente 4 letras.");
			} else {
				// Validación 2: Lógica de la escalera (solo cambia 1 letra)
				esIntentoValido = compruebaIntento(intentoUsuario);

				if (esIntentoValido) {
					// Actualizamos la variable global 'jugada'
					jugada = jugada + " - " + intentoUsuario;
					intentosRealizados++;

					// Comprobamos si ha ganado
					if (intentoUsuario.equals(palabraObjetivo)) {
						objetivoAlcanzado = true;
						juegoTerminado = true;
					}

				} else {
					System.out.println(
							"Error: La palabra debe diferir en exactamente una letra de '" + ultimaPalabra + "'.");
					// Nota: El enunciado dice "El juego no avanzará", por tanto no descontamos
					// intentos si falla la lógica.
				}
			}
		}

		System.out.println("---------------------------------------------");

		if (objetivoAlcanzado) {
			System.out.println("¡ENHORABUENA! Has completado la escalera.");
			System.out.println("Trayectoria final: " + jugada);
		} else {
			System.out.println("Has agotado tus intentos. ¡Has perdido!");
			System.out.println("Debías llegar a: " + palabraObjetivo);
		}

		// Regla: Cerrar siempre el Scanner
		sc.close();
	}

	// ---------------------------------------------------------
	// MÉTODOS AUXILIARES
	// ---------------------------------------------------------

	/**
	 * Selecciona aleatoriamente un juego del array y configura las variables
	 * globales.
	 */
	public static void seleccionaJuego() {
		// En funciones auxiliares podemos declarar e inicializar en la misma línea
		int indiceAleatorio = (int) (Math.random() * juegos.length);

		palabraInicio = juegos[indiceAleatorio][0];
		palabraObjetivo = juegos[indiceAleatorio][1];

		// Inicializamos la jugada con la palabra de inicio
		jugada = palabraInicio;
	}

	/**
	 * Devuelve la última palabra introducida en la cadena 'jugada'.
	 */
	public static String ultimoIntento() {
		// Variable para almacenar el resultado
		String palabraResultado = "";

		// Buscamos el último separador " - ". Si no existe, es la palabra inicial.
		int indiceUltimoSeparador = jugada.lastIndexOf("-");

		if (indiceUltimoSeparador == -1) {
			palabraResultado = jugada;
		} else {
			// Extraemos desde el carácter siguiente al espacio después del guion
			palabraResultado = jugada.substring(indiceUltimoSeparador + 2);
		}

		return palabraResultado;
	}

	/**
	 * Comprueba si el intento cambia exactamente una letra respecto a la última
	 * palabra.
	 */
	public static boolean compruebaIntento(String intento) {
		String referencia = ultimoIntento();
		int diferencias = 0;

		// Contador para el bucle
		// Comentario explicativo del contador: 'i' recorre los caracteres de las
		// palabras
		for (int i = 0; i < referencia.length(); i++) {
			if (referencia.charAt(i) != intento.charAt(i)) {
				diferencias++;
			}
		}

		// Devuelve true solo si hay exactamente una diferencia
		return diferencias == 1;
	}
}