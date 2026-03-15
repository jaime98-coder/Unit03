package modelosexamen;

import java.util.Scanner;

public class ModeloExamenAll_v2 {

	/*
	 * =========================================================================
	 * BLOQUE 1: CONSTANTES Y MAPA GLOBAL
	 * =========================================================================
	 */
	static char[][] planoAlmacen = { { 'L', 'L', 'O', 'L', 'L' }, { 'L', 'L', 'O', 'L', 'L' },
			{ 'L', 'L', 'L', 'L', 'D' }, { 'O', 'O', 'O', 'L', 'L' }, { 'L', 'L', 'L', 'L', 'L' } };

	/*
	 * PATRÓN DE CONSTANTES (MAGIC NUMBERS/CHARS): Usar 'final' evita poner letras
	 * sueltas por el código que luego no sabemos qué son. Además, si mañana el jefe
	 * quiere que el destino sea la letra 'X', solo lo cambias aquí.
	 */
	static final char LIBRE = 'L';
	static final char OBSTACULO = 'O';
	static final char DESTINO = 'D';
	static final char ROBOT = 'R';

	static int bateriaRestante = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*
		 * PATRÓN BANDERAS DE CONTROL: Variables booleanas que nos permiten entrar y
		 * salir de los bucles 'while' de forma limpia, sin usar jamás la sentencia
		 * 'break'.
		 */
		boolean llegadaDestino;
		int filaInicio;
		int columnaInicio;
		boolean coordenadaValida = false;
		String movimientos = "";
		String respuesta;

		/*
		 * =========================================================================
		 * BLOQUE 2: BUCLE EXTERNO (REINICIO DE PARTIDA)
		 * =========================================================================
		 */
		do {
			// PATRÓN RESETEO: Fundamental para que la 2ª partida empiece limpia
			llegadaDestino = false;
			respuesta = "";
			bateriaRestante = 3;

			System.out.println("Bienvenido al Simulador de Rutas AGV");

			/*
			 * =========================================================================
			 * BLOQUE 3: BUCLE PRINCIPAL DEL JUEGO Condición: Sigue vivo MIENTRAS no haya
			 * llegado al destino Y le quede batería.
			 * =========================================================================
			 */
			while (!llegadaDestino && bateriaRestante != 0) {
				System.out.println("Estado inicial del mapa: ");

				// PATRÓN DE OCULTACIÓN VISUAL: Pasamos coordenadas negativas (-1, -1)
				// para que el método imprima el mapa limpio, sin mostrar la 'R' del robot.
				imprimirMapa(-1, -1);

				/*
				 * =========================================================================
				 * BLOQUE 4: VALIDACIÓN BLINDADA DE COORDENADAS
				 * =========================================================================
				 */
				while (!coordenadaValida) {
					try {
						System.out.println("Introduce la fila  de inicio");
						filaInicio = sc.nextInt();
						System.out.println("Introduce la columna  de inicio");
						columnaInicio = sc.nextInt();

						/*
						 * PATRÓN DE LIMITES Y RESTRICCIONES (Operador OR ||): Si sale de los límites (<
						 * 0 o >= length) O no es una casilla Libre, da error y repite, SIN restar
						 * intentos.
						 */
						if (filaInicio < 0 || filaInicio >= planoAlmacen.length || columnaInicio < 0
								|| columnaInicio >= planoAlmacen.length
								|| planoAlmacen[filaInicio][columnaInicio] != 'L') {
							coordenadaValida = false;
							System.out.println("ERROR. Coordenada no válida");
						} else {
							// Si pasa todos los filtros, es válida
							coordenadaValida = true;
							System.out.println("Posición inicial aceptada. Mapa actualizado");

							// Mostramos el mapa pero ahora SÍ le pasamos las coordenadas para que pinte la
							// 'R'
							imprimirMapa(filaInicio, columnaInicio);

							System.out.println("Introduce la secuencia de movimientos (Ej: SSSEEN) ");

							// PATRÓN NORMALIZACIÓN DE STRING: toUpperCase() nos salva si el usuario escribe
							// en minúsculas
							movimientos = sc.next().toUpperCase();

							/*
							 * =========================================================================
							 * BLOQUE 5: LLAMADA A LA LÓGICA CORE Dependiendo de lo que devuelva la
							 * simulación, ganamos o restamos batería.
							 * =========================================================================
							 */
							if (simularRuta(filaInicio, columnaInicio, movimientos)) {
								System.out.println("El robot ha llegado a su destino");
								llegadaDestino = true;
							} else {
								System.out.println("La ruta ha fallado");
								bateriaRestante--;
								System.out.println("Bateria restante: " + bateriaRestante);
							}
						}
					} catch (Exception e) {
						/*
						 * PATRÓN TRY-CATCH EXCEPCIONES: Atrapa letras metidas en un nextInt().
						 * Obligatorio limpiar el buffer.
						 */
						System.out.println("ERROR. Dato incoherente");
						sc.nextLine();
					}
				} // Fin del while(!coordenadaValida)

				// Reseteo para que en la siguiente jugada vuelva a pedir la posición de inicio
				coordenadaValida = false;

			} // Fin del while del juego (baterias)

			/*
			 * =========================================================================
			 * BLOQUE 6: RESOLUCIÓN Y PREGUNTA DE REINICIO
			 * =========================================================================
			 */
			if (bateriaRestante == 0 && !llegadaDestino) {
				System.out.println("Perdiste porque se te acabó la batería");
			} else {
				System.out.println("Éxito, has llegado a tu destino");
			}

			// PATRÓN LIMPIEZA DE BUFFER: Siempre antes de un nextLine() si antes hubo
			// next() o nextInt()
			sc.nextLine();
			System.out.println("¿Deseas configurar una nueva ruta para el robot de mañana? (S/N)");
			respuesta = sc.nextLine();

		} while (respuesta.equalsIgnoreCase("S"));

		System.out.println("¡¡Hasta pronto!!");
		System.out.println("-----------------");
		System.out.println("Fin del programa");
		System.out.println("-----------------");
		sc.close();
	}

	/*
	 * =========================================================================
	 * MÉTODOS AUXILIARES
	 * =========================================================================
	 */

	/**
	 * PATRÓN RECORRIDO DE MATRIZ CON CAPA VISUAL SUPERPUESTA: Recorre el array
	 * bidimensional original, pero si detecta que la fila y columna coinciden con
	 * las del robot, imprime la 'R' en lugar de lo que hay debajo. ¡Ojo! No machaca
	 * el array original, solo cambia lo que se ve en la consola.
	 */
	public static void imprimirMapa(int filaRobot, int colRobot) {
		for (int i = 0; i < planoAlmacen.length; i++) {
			for (int j = 0; j < planoAlmacen[i].length; j++) {

				// Lógica de impresión condicional (If-Else para no imprimir dos cosas a la vez)
				if (i == filaRobot && j == colRobot) {
					System.out.print('R' + "\t");
				} else {
					System.out.print(planoAlmacen[i][j] + "\t");
				}

			}
			System.out.println(); // Salto al terminar cada fila
		}
	}

	/**
	 * PATRÓN SEPARAR MOVIMIENTO DE COMPROBACIÓN: Es el patrón más importante para
	 * evitar "Código Espagueti" o anidar cientos de if-else.
	 */
	public static boolean simularRuta(int filaActual, int colActual, String movimientos) {
		// Banderas de control para el bucle for
		boolean rutaActiva = true;
		boolean haLlegado = false;
		char comando;

		// El for se detiene si se acaba el string, si la ruta choca (!rutaActiva) o si
		// llega (!haLlegado)
		for (int i = 0; i < movimientos.length() && rutaActiva && !haLlegado; i++) {
			comando = movimientos.charAt(i);

			// FASE 1: MOVER MATEMÁTICAMENTE
			// Modificamos las coordenadas según la letra. ¡Aún no miramos qué hay en el
			// mapa!
			if (comando == 'N') {
				filaActual--;
			} else if (comando == 'S') {
				filaActual++;
			} else if (comando == 'E') {
				colActual++;
			} else if (comando == 'O') {
				colActual--;
			} else {
				System.out.println("Comando " + comando + " ignorado (no reconocido).");
			}

			// FASE 2: COMPROBAR LAS CONSECUENCIAS DEL MOVIMIENTO

			// A) Comprobar Límites (Tiene que ser el primerísimo if para evitar
			// IndexOutOfBoundsException)
			if (filaActual < 0 || filaActual >= 5 || colActual < 0 || colActual >= 5) {
				System.out.println("¡Alerta! El robot se ha salido de los límites.");
				rutaActiva = false; // Al poner a false, el bucle for no dará la siguiente vuelta
			}
			// B) Si estamos dentro de los límites, ya podemos mirar qué casilla estamos
			// pisando
			else {
				char casillaPisada = planoAlmacen[filaActual][colActual];

				// Usamos las constantes para que el código sea muy fácil de leer
				if (casillaPisada == OBSTACULO) {
					System.out.println("¡Choque detectado en [" + filaActual + "][" + colActual + "]!");
					rutaActiva = false;
				} else if (casillaPisada == DESTINO) {
					System.out.println("¡Destino alcanzado!");
					haLlegado = true; // Frenará el for y será nuestro return positivo
				}
				// Nota: Si la casilla es 'L', no hacemos nada (rutaActiva sigue true y el for
				// sigue)
			}
		}

		// Al terminar (por éxito, choque o quedarse sin letras), devolvemos el estado
		// final
		return haLlegado;
	}
}