package arrays2d;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise02 {

	public static void main(String[] args) {
		// ---------------------------------------------------------
		// 1. DECLARACIÓN DE CONSTANTES Y VARIABLES
		// ---------------------------------------------------------
		// Constantes para definir el tamaño de la matriz (facilita mantenimiento)
		final int NUM_ALUMNOS = 4;
		final int NUM_ASIGNATURAS = 5;

		// Variables auxiliares para los cálculos estadísticos
		double sumaNotas;
		double notaMinima;
		double notaMaxima;
		double media;

		// Variable temporal para almacenar la nota que se está procesando actualmente
		double notaActual;

		// Bandera para controlar la validación de la entrada de datos
		boolean datoValido;

		Scanner sc = new Scanner(System.in);

		// Matriz para almacenar las notas: 4 filas (Alumnos) x 5 columnas (Asignaturas)
		double[][] tablaNotas = new double[NUM_ALUMNOS][NUM_ASIGNATURAS];

		// ---------------------------------------------------------
		// 2. FASE DE ENTRADA DE DATOS (Carga de la matriz)
		// ---------------------------------------------------------
		for (int indiceAlumno = 0; indiceAlumno < NUM_ALUMNOS; indiceAlumno++) {
			System.out.println("--- Registro de notas para Alumno nº" + (indiceAlumno + 1) + " ---");

			for (int indiceAsignatura = 0; indiceAsignatura < NUM_ASIGNATURAS; indiceAsignatura++) {

				// Reiniciamos la bandera de validación para cada nueva nota
				datoValido = false;

				// Bucle de validación: se repite hasta obtener un número válido entre 0 y 10
				while (!datoValido) {
					try {
						System.out.print("Introduce nota asignatura " + (indiceAsignatura + 1) + ": ");

						// Intentamos leer la nota directamente en la matriz
						tablaNotas[indiceAlumno][indiceAsignatura] = sc.nextDouble();

						// Verificamos si la nota está dentro del rango permitido
						if (tablaNotas[indiceAlumno][indiceAsignatura] < 0
								|| tablaNotas[indiceAlumno][indiceAsignatura] > 10) {
							System.out.println("Error: La nota debe estar comprendida entre 0 y 10.");
							// datoValido sigue siendo false, por lo que el bucle repetirá
						} else {
							// Si es número y el rango es correcto, marcamos como válido para salir del
							// while
							datoValido = true;
						}

					} catch (InputMismatchException e) {
						// Capturamos el error si el usuario introduce texto en lugar de números
						System.out.println("Error: Tipo de dato incorrecto. Por favor, introduce un número.");

						// Limpiamos el buffer del Scanner para evitar un bucle infinito
						sc.next();
					}
				}
			}
			// Salto de línea estético tras terminar un alumno
			System.out.println();
		}

		// ---------------------------------------------------------
		// 3. FASE DE PROCESAMIENTO Y SALIDA (Lectura y Cálculos)
		// ---------------------------------------------------------
		System.out.println("========================================");
		System.out.println("         BOLETÍN DE RESULTADOS          ");
		System.out.println("========================================");

		// Recorremos la matriz alumno por alumno
		for (int i = 0; i < NUM_ALUMNOS; i++) {

			// Inicialización de variables para el alumno actual.
			// Es crítico resetearlas aquí para no mezclar datos entre alumnos.
			sumaNotas = 0;
			notaMinima = 10; // Se inicia con el valor máximo posible
			notaMaxima = 0; // Se inicia con el valor mínimo posible

			System.out.print("Alumno " + (i + 1) + " notas: " );

			// Recorremos las asignaturas del alumno actual
			for (int j = 0; j < NUM_ASIGNATURAS; j++) {
				// Asignamos a variable temporal para mejorar legibilidad del código
				notaActual = tablaNotas[i][j];

				// 1. Visualización: Imprimimos la nota seguida de espacios
				System.out.print(notaActual + "   ");

				// 2. Acumulación: Sumamos para el cálculo posterior de la media
				sumaNotas += notaActual;

				// 3. Comparación Mínimo: Si la nota actual es menor, actualizamos el mínimo
				if (notaActual < notaMinima) {
					notaMinima = notaActual;
				}

				// 4. Comparación Máximo: Si la nota actual es mayor, actualizamos el máximo
				if (notaActual > notaMaxima) {
					notaMaxima = notaActual;
				}
			}

			// Cálculo de la media del alumno
			media = sumaNotas / NUM_ASIGNATURAS;

			// Salida de estadísticas del alumno con formato a 2 decimales
			System.out.println(); // Salto de línea tras las notas individuales
			System.out.printf("Media: %.2f | Mín: %.2f | Máx: %.2f", media, notaMinima, notaMaxima);
			System.out.println("\n"); // Doble salto de línea para separar del siguiente alumno
		}

		// Cierre del recurso Scanner
		sc.close();
	}
}