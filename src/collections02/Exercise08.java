package collections02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Exercise08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcionElegida = -1;
		String categoria;
		String tarea;

		// [EL ARCHIVADOR DE TAREAS]
		// Clave (String): La CATEGORÍA (Es la pegatina por fuera de la carpeta. Ej:
		// "TRABAJO").
		// Valor (ArrayList<String>): LA LISTA DE TAREAS (Es el folio que va dentro de
		// esa carpeta).
		HashMap<String, ArrayList<String>> listaTareas = new HashMap<>();

		// Bucle del menú. Se repite hasta que el usuario elija 4 (Salir).
		while (opcionElegida != 4) {
			// Imprimimos el estado "en crudo" para ir viendo cómo crece el mapa
			// internamente
			System.out.println("\nEstado actual de la lista: ");
			System.out.println(listaTareas.toString());

			System.out.println("-----MENU-----");
			System.out.println("1. Añadir");
			System.out.println("2. Eliminar");
			System.out.println("3. Listar tareas por categoría");
			System.out.println("4. Salir");
			System.out.println("--------------");
			opcionElegida = sc.nextInt();
			sc.nextLine();

			switch (opcionElegida) {

			// Añadir tarea
			case 1: {
				System.out.println("---------AÑADIR TAREA---------");
				System.out.println("Introduce una categoria: ");
				categoria = sc.nextLine();
				System.out.println("Introduce una tarea: ");
				tarea = sc.nextLine();

				// 1. ¿No existe la carpeta de esta categoría?
				if (!listaTareas.containsKey(categoria)) {
					// Entonces fabricamos la carpeta y le metemos un folio (ArrayList) en blanco.
					listaTareas.put(categoria, new ArrayList<String>());
				}

				// 2. Encadenamiento mágico:
				// Saca el folio de la categoría (.get) y añádele la tarea (.add).
				// Esto se ejecuta SIEMPRE, tanto si la carpeta es nueva como si ya existía.
				listaTareas.get(categoria).add(tarea);
				break;
			}

			// ==========================================
			// CASE 2: ELIMINAR
			// ==========================================
			case 2: {
				System.out.println("---------ELIMINAR TAREA---------");
				System.out.println("Introduce la categoria de la cual quieres eliminar la tarea: ");
				categoria = sc.nextLine();

				// 1. Comprobamos si la CATEGORÍA (Clave) existe en el archivador
				if (listaTareas.containsKey(categoria)) {
					System.out.println("Introduce la tarea a eliminar: ");
					tarea = sc.nextLine();

					boolean borradoExitoso;
					// 2. Extraemos la lista (.get) y usamos su método .remove(String)
					// Nos devolverá 'true' si encontró la palabra y la borró, o 'false' si no
					// estaba.
					borradoExitoso = listaTareas.get(categoria).remove(tarea);

					if (borradoExitoso) {
						System.out.println("Tarea eliminada");
					} else {
						System.out.println("Error: Esa tarea no existe dentro de la categoría");
					}
				} else {
					System.out.println("Error: La categoría '" + categoria + "' no existe.");
				}
				break;
			}

			// Listar tareas por categoría
			case 3: {
				System.out.println("--- LISTA DE TAREAS POR CATEGORÍA ---");

				// Validación rápida: si el archivador no tiene ni una sola carpeta, avisamos.
				if (listaTareas.isEmpty()) {
					System.out.println("No hay tareas registradas");
				} else {
					System.out.println("---------TAREAS POR CATEGORÍA---------");

					// BUCLE 1 (EL MAPA): .keySet() nos da una lista con todas las CLAVES
					// (Categorías).
					for (String categoriaActual : listaTareas.keySet()) {

						// Imprimimos el título de la carpeta en mayúsculas
						System.out.println("\n" + categoriaActual.toUpperCase());

						// Sacamos el folio (ArrayList) de esa categoría concreta
						ArrayList<String> tareasDeEstaCategoria = listaTareas.get(categoriaActual);

						// BUCLE 2 (LA LISTA): Recorremos el folio línea a línea
						for (String tareaActual : tareasDeEstaCategoria) {
							System.out.println(" - " + tareaActual);
						}
					}
				}
				break;
			}

			// Salir
			case 4: {
				System.out.println("Saliendo del programa...");
				break;
			}

			}
		}

		sc.close();
	}
}