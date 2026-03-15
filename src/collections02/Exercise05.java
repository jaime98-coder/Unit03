package collections02;

import java.util.HashMap;
import java.util.Scanner;

public class Exercise05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> mapaSeries = new HashMap<>();
		int codigoOpcion = 0;
		String nombreSerie;
		int valoracion;

		while (codigoOpcion != 4) {
			System.out.println("Estado actual del mapa: " + mapaSeries.toString());
			System.out.println("Menú de opciones:");
			System.out.println("1. Agregar serie");
			System.out.println("2. Buscar serie");
			System.out.println("3. Eliminar serie");
			System.out.println("4. Salir");

			System.out.println("Introduce una de las opciones:");
			codigoOpcion = sc.nextInt();
			sc.nextLine();

			switch (codigoOpcion) {
			case 1: {
				// Agregar serie
				System.out.println("Introduce el nombre de la serie: ");
				nombreSerie = sc.nextLine();
				System.out.println("Introduce la valoración de la serie: ");
				valoracion = sc.nextInt();
				mapaSeries.put(nombreSerie, valoracion);
				break;
			}
			// Buscar series
			case 2: {
				System.out.println("Introduce el nombre de la serie que quieres buscar: ");
				nombreSerie = sc.nextLine();
				if (mapaSeries.containsKey(nombreSerie)) {
					System.out.println("La serie: " + nombreSerie + " se encuentra en el mapa con una valoración de: "
							+ mapaSeries.get(nombreSerie));
				} else {
					System.out.println("La serie: " + nombreSerie + " no se encuentra en el mapa");
				}

				break;
			}
			// Eliminar serie
			case 3: {
				System.out.println("Introduce el nombre de la serie que deseas eliminar: ");
				nombreSerie = sc.nextLine();
				if (mapaSeries.remove(nombreSerie) != null) {
					System.out.println("La serie: " + nombreSerie + " se ha eliminado correctamente");
				} else {
					System.out.println("La serie: " + nombreSerie + " no se encuentra en el mapa");
				}
				break;
			}
			// Salir del programa
			case 4: {
				System.out.println("Saliendo del programa...");
				break;
			}
			default: {
				System.out.println("Seleccione una de las opciones válidas (1-4)");
			}
			}
		}
		sc.close();

	}

}
