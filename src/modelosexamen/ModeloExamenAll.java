package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloExamenAll {
	
	/* =========================================================================
	 * BLOQUE 1: VARIABLES GLOBALES (ESTADO DEL SISTEMA)
	 * Se declaran 'static' fuera del main para que todos los métodos puedan
	 * leerlas y modificarlas sin necesidad de pasarlas por parámetro.
	 * ========================================================================= */
	static char[][] discoDañado = { { 'D', 'X', 'B', 'R' }, { 'T', 'A', 'O', 'M' }, { 'C', 'J', 'V', 'E' },
			{ 'Z', 'O', 'T', 'S' } };
	static String[] clavesDisponibles = { "DATO", "ROOT", "BASE", "JAVA" };
	
	// Almacenará la clave que el técnico debe intentar recuperar en la partida actual
	static String claveObjetivo;
	// Almacenará el estado actual de la claveRecuperada
	static String claveRecuperada = "";
	static int intentosRestantes = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int filaUsuario;
		int columnaUsuario;
		
		/* PATRÓN DE BANDERAS BOOLEANAS: 
		 * Se usan para controlar los bucles 'while' sin usar 'break'. */
		boolean sonIguales = false; 
		boolean coordenadaValida = false;
		String respuesta = "";

		System.out.println("-------------------------------------------------");
		System.out.println("Bienvenido al Sistema de Recuperación de Datos");
		System.out.println("-------------------------------------------------");

		/* =========================================================================
		 * BLOQUE 2: BUCLE DE REINICIO DE PARTIDA (do-while)
		 * Todo el juego va dentro. Al final preguntará si queremos jugar de nuevo.
		 * ========================================================================= */
		do {
			/* PATRÓN DE RESETEO VITAL: 
			 * Si el usuario juega una 2ª partida, las variables deben volver a su estado 
			 * original, de lo contrario, el programa recordará la victoria/derrota anterior. */
			sonIguales = false;
			claveRecuperada = "";
			intentosRestantes = 3;

			System.out.println("Seleccionando clave objetivo...");
			seleccionarClave();
			System.out.println("Clave objetivo: ");
			System.out.println(claveObjetivo);

			/* =========================================================================
			 * BLOQUE 3: BUCLE PRINCIPAL DEL JUEGO
			 * Se repite MIENTRAS no hayamos ganado (!sonIguales) Y nos queden intentos.
			 * ========================================================================= */
			while (!sonIguales && intentosRestantes > 0) {
				System.out.println("Estado actual: ");
				System.out.println(claveRecuperada);
				System.out.println("Intentos restantes: " + intentosRestantes);
				imprimirDisco();

				/* =========================================================================
				 * BLOQUE 4: VALIDACIÓN BLINDADA (Try-Catch + Límites de Matriz)
				 * Este bucle atrapa al usuario hasta que introduce unas coordenadas 
				 * 100% válidas (que sean números y que estén dentro del tablero).
				 * ========================================================================= */
				while (!coordenadaValida) {
					try {
						System.out.println("Introduce la FILA de donde quieres extraer la siguiente letra");
						filaUsuario = sc.nextInt();
						System.out.println("Introduce la COLUMNA de donde quieres extraer la siguiente letra");
						columnaUsuario = sc.nextInt();
						
						/* PATRÓN LÍMITES DE MATRIZ: 
						 * Se usa el operador OR (||). Si la fila o columna son negativas o superan
						 * el tamaño de la matriz, da error, pero NO RESTA INTENTOS. */
						if (filaUsuario < 0 || filaUsuario >= discoDañado.length || columnaUsuario < 0
								|| columnaUsuario >= discoDañado[0].length) {
							System.out.println("Error, coordenadas inválidas");
						} else {
							// Si llegamos aquí, los datos son números y están dentro del tablero.
							coordenadaValida = true;
							
							// Evaluamos la jugada llamando al método
							if (extraerSector(filaUsuario, columnaUsuario)) {
								System.out.println("Extracción correcta");
							} else {
								System.out.println("Error. Sector incorrecto");
								intentosRestantes--; // Solo penalizamos si la coordenada era válida pero se equivocó de letra
							}
						}
					} catch (Exception e) {
						/* PATRÓN TRY-CATCH: 
						 * Si mete letras en sc.nextInt(), salta aquí en lugar de colgar el programa. */
						System.out.println("FORMATO NO CORRECTO");
						// VITAL: Limpiamos la basura del teclado para que el bucle no se vuelva infinito
						sc.nextLine();
					}
				}
				
				// Reseteamos esta bandera para que en la siguiente jugada vuelva a pedir coordenadas
				coordenadaValida = false;
				
				/* =========================================================================
				 * BLOQUE 5: COMPROBACIONES DE VICTORIA Y DERROTA
				 * ========================================================================= */
				// ¿Ha ganado?
				if (claveRecuperada.equals(claveObjetivo)) {
					sonIguales = true; // Esto detendrá el bucle principal en la siguiente vuelta
					System.out.println("¡¡Éxito total!!");
				}
				// ¿Ha perdido?
				if (intentosRestantes == 0) {
					System.out.println("SISTEMA BLOQUEADO POR SEGURIDAD. DATOS PERDIDOS");
				}
				
			} // Fin del while principal del juego
			
			/* =========================================================================
			 * BLOQUE 6: GESTIÓN DE NUEVA PARTIDA
			 * Al salir del juego (por victoria o por derrota), preguntamos si repetimos.
			 * ========================================================================= */
			if (sonIguales || intentosRestantes == 0) {
				// PATRÓN LIMPIEZA DE BUFFER: Antes de leer un String después de haber 
				// leído números (nextInt), hay que hacer nextLine() para limpiar el salto de línea.
				sc.nextLine();
				System.out.println("¿Deseas reiniciar el sistema para intentar recuperar otra clave? (S/N)");
				respuesta = sc.nextLine();
			}
		} while (respuesta.equalsIgnoreCase("s"));
		
		System.out.println("---------------------");
		System.out.println("Fin del programa...");
		System.out.println("---------------------");

		sc.close(); // Siempre cerrar el Scanner al terminar su uso
	}

	/* =========================================================================
	 * MÉTODOS AUXILIARES
	 * ========================================================================= */

	/**
	 * PATRÓN RECORRER MATRIZ: 
	 * Se usan dos bucles 'for' anidados. El exterior (i) para las filas y 
	 * el interior (j) para las columnas.
	 */
	public static void imprimirDisco() {
		System.out.println("\t0\t1\t2\t3");
		for (int i = 0; i < discoDañado.length; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < discoDañado.length; j++) {
				System.out.print(discoDañado[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * PATRÓN SELECCIÓN ALEATORIA DE UN ARRAY 1D:
	 * Se genera un número entre 0 y la longitud del array, y se usa como índice.
	 */
	public static void seleccionarClave() {
		Random rd = new Random();
		int posicionAleatoria;
		posicionAleatoria = rd.nextInt(clavesDisponibles.length);
		claveObjetivo = clavesDisponibles[posicionAleatoria];
	}

	/**
	 * Método para ir rellenando la clave oculta de forma ORDENADA
	 * * @param fila.    para indicar posicion fila del array discoDañado
	 * @param columna. para indicar posicion columna del array discoDañado
	 * @return booleano, TRUE si la letra coincide. FALSE si no
	 */
	public static boolean extraerSector(int fila, int columna) {
		char letraActual;
		boolean letraCoincide = false;
		
		/* PATRÓN SEGUIMIENTO POR LONGITUD:
		 * Como claveRecuperada empieza vacía (length = 0), nos dirá que miremos 
		 * el charAt(0) de la claveObjetivo. Si acertamos, length pasa a 1, 
		 * por lo que en el siguiente turno miraremos charAt(1). ¡Así forzamos el orden! */
		int indiceQueToca = claveRecuperada.length();
		
		letraActual = discoDañado[fila][columna];
		
		// Comprueba estrictamente si la letra sacada es LA QUE TOCA AHORA MISMO
		if (letraActual == claveObjetivo.charAt(indiceQueToca)) {
			letraCoincide = true;
			claveRecuperada += letraActual;
			System.out.println("CORRECTO");
		}
		
		return letraCoincide;
	}
}