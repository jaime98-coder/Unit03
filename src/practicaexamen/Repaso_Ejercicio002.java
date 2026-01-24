package practicaexamen;

import java.util.Scanner;

public class Repaso_Ejercicio002 {

	public static void main(String[] args) {
		// Creación del Scanner
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el número de notas que vas a meter en el programa:");
		// Declaro la constante NUMERO_ALUMNOS para crear el array notasClase del tamaño
		// que el usuario introduzca, segun el número de notas a introducir
		final int NUMERO_ALUMNOS;
		NUMERO_ALUMNOS = sc.nextInt();
		// Asigno el tamaño del Array con la constante
		double[] notasClase = new double[NUMERO_ALUMNOS];
		System.out.println("------------------------------------------------------------------");
		// Bucle para rellenar el Array creado con las notas de los alumnos
		for (int i = 0; i < notasClase.length; i++) {
			System.out.print("Introduce la nota número " + (i + 1) + ": ");
			notasClase[i] = sc.nextDouble();
			sc.nextLine();
			// Bucle while para que no se permita introducir notas erroneas.
			while (notasClase[i] < 0 || notasClase[i] > 10) {
				System.out.println("Introduce una nota válida (entre 0 y 10) para el alumno " + (i + 1));
				notasClase[i] = sc.nextDouble();
			}

		}
		// Bucle for para imprimir las notas de la clase introducidas contenidas en el
		// Array
		System.out.println("\nNotas de la clase originales:");
		for (int i = 0; i < notasClase.length; i++) {
			System.out.print(notasClase[i] + "\t");
		}
		System.out.println();

		// Declaracion de la variable notaMediaClase para almacenar la media total
		double notaMediaClase;
		// Asigno en la variable lo que devuelve el método calcularMedia utilizando la
		// tabla notasClase
		notaMediaClase = calcularMedia(notasClase);
		System.out.print("\nNota media de la clase: " + notaMediaClase);
		System.out.println();

		// Declaracion de variable para almacenar la nota máxima
		double notaMaximaClase;
		// Asigno a dicha variable lo que devuelve el método notaMaxima utilizando como
		// entrada la tabla notasClase
		notaMaximaClase = notaMaxima(notasClase);
		System.out.print("\nNota máxima de la clase: " + notaMaximaClase);
		System.out.println();

		// Declaracion de variable para almacenar la el nº de aprobados (>= 5)
		int numeroAprobadosClase;
		// Asigno a dicha variable lo que devuelve el método contarAprobados utilizando
		// como
		// entrada la tabla notasClase
		numeroAprobadosClase = contarAprobados(notasClase);
		System.out.print("\nNúmero de aprobados de la clase: " + numeroAprobadosClase);
		System.out.println();

		// Utilizo el método subirNotas para subir el valor de la 2º entrada del mismo a
		// cada elementoss del Array notasClase
		subirNotas(notasClase, 0.5);
		// Impresion de los datos del array notasClase tras la subida de ntoa
		System.out.println("\nNotas de la clase tras la subida de nota:");
		for (int i = 0; i < notasClase.length; i++) {
			System.out.print(notasClase[i] + "\t");
		}
		System.out.println();

		// Cierre de recursos
		sc.close();
	}

	/**
	 * Método para calcular la nota media de la clase
	 * 
	 * @param notas. Para introducir como entrada los valores contenidos en dicho
	 *               array
	 * @return calcularMedia. Para calcular la nota media de la clase
	 */
	static double calcularMedia(double[] notas) {

		double notaMediaClase = 0;
		double notasTotalesClase = 0;
		for (int i = 0; i < notas.length; i++) {
			notasTotalesClase += notas[i];
		}
		notaMediaClase = notasTotalesClase / notas.length;
		return notaMediaClase;
	}

	/**
	 * Método creado para extraer la nota máxima de los valores introducidos en el
	 * array notas
	 * 
	 * @param notas. Para introducir como entrada los valores contenidos en dicho
	 *               array
	 * @return notaMaxima. Nota máxima de la clase tras recorrer el array notas.
	 */
	static double notaMaxima(double[] notas) {
		double notaMaxima = notas[0];
		for (int i = 0; i < notas.length; i++) {
			if (notaMaxima < notas[i]) {
				notaMaxima = notas[i];
			}
		}
		return notaMaxima;
	}

	/**
	 * Método para devolver el número de aprobados
	 * 
	 * @param notas. Para introducir como entrada los valores contenidos en dicho
	 *               array
	 * @return contarAprobados. Número de notas contenidas en el array mayor o igual
	 *         a 5
	 */
	static int contarAprobados(double[] notas) {
		int conteoAprobados = 0;
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] >= 5) {
				conteoAprobados++;
			}
		}
		return conteoAprobados;
	}

	/**
	 * Método para subir notas a todos los valores del Array
	 * 
	 * @param notas.      Para introducir como entrada los valores contenidos en
	 *                    dicho array
	 * @param incremento. Para sumarle a los valores contenidos en el array notas lo
	 *                    que se le añada aqui.
	 * @return subirNotas. Suma el incremento a cada uno de los valores del Array
	 */
	static void subirNotas(double[] notas, double incremento) {
		for (int i = 0; i < notas.length; i++) {
			notas[i] += incremento;
			if (notas[i] > 10) {
				notas[i] = 10;
			}
		}
	}

}
