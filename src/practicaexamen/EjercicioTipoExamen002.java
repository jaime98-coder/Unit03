package practicaexamen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EjercicioTipoExamen002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int NUMERO_ALUMNOS = 3;
		String[] nombres = new String[NUMERO_ALUMNOS];
		double[] notas = new double[NUMERO_ALUMNOS];
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("Introduce el nombre del alumno nº " + (i + 1)+": ");
			nombres[i] = sc.nextLine();
			System.out.println("Introduce la nota del alumno nº " + (i + 1)+": ");
			notas[i] = sc.nextDouble();
			sc.nextLine();
		}
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("Alumno "+(i+1)+": ");
			System.out.println("Nombre:"+nombres[i]);
			System.out.println("Nota:"+notas[i]);
			System.out.println("------------------------");
		}
		int opcionPrograma = 0;

		System.out.println("Bienvenido al programa de notas");
		do {
			try {

				System.out.println("------------------------------------");
				System.out.println("Elige una de las 3 opciones");
				System.out.println("1. Cargar datos");
				System.out.println("2. Publicar datos");
				System.out.println("3. Salir");
				System.out.println("------------------------------------");
				opcionPrograma = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("ERROR. Introduce un valor numérico");
				sc.nextLine();
				opcionPrograma = 0;
			}
			switch (opcionPrograma) {
			case 1:
				System.out.println("Has elegido la opción 1. Accediendo a: Cargar datos...");
				break;

			case 2:
				System.out.println("Has elegido la opción 2. Accediendo a: Publicar datos...");
				break;
			case 3:
				System.out.println("Saliendo del programa...\n¡Hasta la próxima!");
				break;
			default:
				System.out.println("Elige la opción 1,2 o 3");
				break;
			}
		} while (opcionPrograma != 3);

	}

}
