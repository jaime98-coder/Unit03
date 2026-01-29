package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloEzamen003_Arrays_B {

	// --- VARIABLES GLOBALES (ESTÁTICAS) ---
	
	// Array bidimensional con los juegos (Fila: Juego, Col 0: Inicio, Col 1: Fin)
	static String[][] juegos = {
			{ "CASA", "PATO" },
			{ "PISO", "TUBO" },
			{ "CENA", "MURO" },
			{ "BONO", "DEDO" },
			{ "ROJO", "PASA" }
	};
	
	static String palabraInicio;
	static String palabraObjetivo;
	// Variable acumuladora: "CASA - CARA - ..."
	static String jugada; 

	// ---------------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1. Configuración inicial del juego
		seleccionaJuego();
		
		System.out.println("=== JUEGO ESCALERA DE PALABRAS ===");
		System.out.println("Transforma la palabra INICIO en OBJETIVO cambiando una letra cada vez.");
		System.out.println("Tienes 7 intentos.");
		System.out.println("----------------------------------");
		System.out.println("Palabra INICIO:   " + palabraInicio);
		System.out.println("Palabra OBJETIVO: " + palabraObjetivo);
		System.out.println("----------------------------------");

		int intentosConsumidos = 0;
		boolean ganado = false;

		// 2. Bucle del juego (Mientras no ganemos y queden intentos)
		while (!ganado && intentosConsumidos < 7) {
			
			// Mostramos cómo va la cadena de jugadas actual
			System.out.println("\nCadena actual: " + jugada);
			System.out.println("Intento nº " + (intentosConsumidos + 1) + ". Introduce nueva palabra:");
			
			try {
				// Leemos y convertimos a mayúsculas para evitar problemas de comparación
				String intentoUsuario = sc.next().toUpperCase();
				
				// A. Validar longitud (Debe ser de 4 letras)
				if (intentoUsuario.length() != 4) {
					System.out.println(">>> ERROR: La palabra debe tener 4 letras. Inténtalo de nuevo.");
					// El "continue" hace que el bucle vuelva a empezar sin contar intento
					continue; 
				}
				
				// B. Validar lógica (Solo cambia una letra respecto a la anterior)
				// Si compruebaIntento devuelve true, es un movimiento válido
				if (compruebaIntento(intentoUsuario)) {
					
					// Añadimos la palabra válida a la cadena histórica
					jugada += " - " + intentoUsuario;
					intentosConsumidos++; // Gastamos un turno
					
					// C. Comprobar Victoria
					if (intentoUsuario.equals(palabraObjetivo)) {
						ganado = true;
					}
					
				} else {
					// Si devuelve false, es que ha cambiado más de una letra o ninguna
					System.out.println(">>> ERROR: Solo puedes cambiar UNA letra respecto a la anterior.");
				}
				
			} catch (Exception e) {
				System.out.println("Error en la entrada de datos.");
				sc.nextLine(); // Limpiar buffer por seguridad
			}
		} 

		// 3. Final del juego
		System.out.println("\n==================================");
		if (ganado) {
			System.out.println("¡ENHORABUENA! ¡HAS GANADO!");
			System.out.println("Ruta final: " + jugada);
		} else {
			System.out.println("¡HAS PERDIDO! Se agotaron los 7 intentos.");
			System.out.println("Te quedaste en: " + jugada);
		}
		System.out.println("==================================");
		
		sc.close();
	}

	// --- MÉTODOS AUXILIARES ---

	/**
	 * Selecciona una fila al azar del array 'juegos' e inicializa las variables.
	 */
	public static void seleccionaJuego() {
		Random aleatorio = new Random();
		// Elegimos un índice de fila aleatorio (de 0 a juegos.length - 1)
		int filaRandom = aleatorio.nextInt(juegos.length);
		
		palabraInicio = juegos[filaRandom][0];
		palabraObjetivo = juegos[filaRandom][1];
		
		// Inicializamos la jugada con la primera palabra
		jugada = palabraInicio;
	}

	/**
	 * Extrae la última palabra escrita en la cadena 'jugada'.
	 * @return La última palabra (String)
	 */
	public static String ultimoIntento() {
		// La cadena tiene formato: "CASA - CARA - PARA"
		// Usamos lastIndexOf("-") para buscar el último guión
		int ultimaPosicionGuion = jugada.lastIndexOf("-");
		
		if (ultimaPosicionGuion == -1) {
			// Si no hay guiones, es que estamos al principio (solo está "CASA")
			return jugada;
		} else {
			// Cortamos desde el guión + 2 (para saltar el guión y el espacio) hasta el final
			// Ejemplo: "... - PARA". El guión está en X. X+1 es espacio. X+2 es la P.
			// Usamos trim() por seguridad para quitar espacios sobrantes.
			return jugada.substring(ultimaPosicionGuion + 1).replace(" ", "");
		}
	}

	/**
	 * Comprueba si el intento es válido respecto a la última palabra jugada.
	 * @param intento La palabra nueva que quiere poner el usuario
	 * @return true si solo cambia 1 letra, false en caso contrario
	 */
	public static boolean compruebaIntento(String intento) {
		String ultimaPalabra = ultimoIntento();
		
		// Contador de letras diferentes
		int diferencias = 0;
		
		// Recorremos las 4 letras
		for (int i = 0; i < 4; i++) {
			// Si la letra en la posición 'i' es distinta, sumamos diferencia
			if (intento.charAt(i) != ultimaPalabra.charAt(i)) {
				diferencias++;
			}
		}
		
		// Para que sea válido, debe haber EXACTAMENTE 1 diferencia.
		// Si hay 0 es la misma palabra. Si hay 2 o más, es inválido.
		if (diferencias == 1) {
			return true;
		} else {
			return false;
		}
	}

}