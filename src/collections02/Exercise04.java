package collections02;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise04 {
	public static void main(String[] args) {

		ArrayList<String> listaNombres = new ArrayList<>();
		String nombreABuscar = "";
		Scanner sc = new Scanner(System.in);
		int codigoOpcion = 0;

		while (codigoOpcion != 5) {
			System.out.println("1. Añadir nuevo nombre a la lista.");
			System.out.println("2. Elimina un nombre específico");
			System.out.println("3. Ordena la lista alfabéticamente.");
			System.out.println("4. Busca si un nombre específico está en la lista");
			System.out.println("5. Salir");

			System.out.println("Introduce una de las opciones:");
			codigoOpcion = sc.nextInt();
			sc.nextLine();
			System.out.println("Estado actual de la lista: " + listaNombres.toString());

			switch (codigoOpcion) {
			case 1: {
				int posicion;
				System.out.println("Introduce un nombre para meterlo en la lista: ");
				nombreABuscar = sc.nextLine();
				listaNombres.add(nombreABuscar);
				break;
			}
			case 2: {
				System.out.println("Introduce el nombre que deseas eliminar: ");
				nombreABuscar = sc.nextLine();
				if (!listaNombres.contains(nombreABuscar)) {
					System.out.println("El nombre no se encuentra en la lista");
				} else {
					listaNombres.remove(nombreABuscar);
				}
				break;
			}
			// Ordena alfabeticamente (null = alfabeticamente)
			case 3: {
				listaNombres.sort(null);
				System.out.println("Nombres de la lista ordenados correctamente");
				System.out.println(listaNombres.toString());
				break;
			}
			// Busca un nombre específico
			case 4: {
				System.out.println("Introduce el nombre que deseas buscar en la lista: ");
				nombreABuscar = sc.nextLine();
				if (listaNombres.contains(nombreABuscar)) {
					System.out.println("El nombre: " + nombreABuscar + " se encuentra en la lista");
				} else {
					System.out.println("El nombre: " + nombreABuscar + "NO se encuentra en la lista");
				}
				break;
			}
			// Salir del programa
			case 5: {
				System.out.println("Saliendo del programa...");
				break;
			}
			default: {
				System.out.println("Seleccione una de las opciones válidas (1-5)");
			}
			}
		}
		sc.close();
	}
}
