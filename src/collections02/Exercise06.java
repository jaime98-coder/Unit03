package collections02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Exercise06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// [TRUCO DE EXAMEN] La estructura principal.
		// HashMap funciona como un ARCHIVADOR.
		// - Clave (Key): String -> Es la pestaña de la carpeta (El nombre de la
		// persona).
		// - Valor (Value): ArrayList<Integer> -> Es el folio con la lista de teléfonos
		// que va DENTRO de la carpeta.
		HashMap<String, ArrayList<Integer>> libretaContactos = new HashMap<>();

		int codigoOpcion = -1;
		String nombrePersona;
		int numeroTelefono;

		// Bucle principal: se repetirá MIENTRAS la opción NO sea 0 (Salir).
		while (codigoOpcion != 0) {

			// Imprimimos el estado actual. Muy útil para depurar y ver cómo crece nuestro
			// mapa en tiempo real.
			System.out.println("\nEstado actual de la libreta de contactos: " + libretaContactos.toString());
			System.out.println("------------MENU------------");
			System.out.println("1. Añadir nuevo contacto.");
			System.out.println("2. Añadir teléfono a una persona dada.");
			System.out.println("3. Mostrar los teléfonos de una persona.");
			System.out.println("4. Eliminar el teléfono de una persona.");
			System.out.println("5. Eliminar a una persona.");
			System.out.println("0. Salir.");
			System.out.println("----------------------------");

			// Try-Catch para validar datos.
			try {
				System.out.println("Introduce una de las opciones:");
				codigoOpcion = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Introducción inválida, introduce un número válido.");
			}

			// Limpieza de buffer tras sc.nextInt()
			sc.nextLine();

			switch (codigoOpcion) {

			// OPCIÓN 1: CREAR LA CARPETA (Añadir Contacto)
			case 1: {
				System.out.println("Introduce el nombre de la persona que quieres añadir: ");
				nombrePersona = sc.nextLine();

				// .containsKey() para verificar si existe ese nombrePersona en la libreta de
				// contactos
				if (!libretaContactos.containsKey(nombrePersona)) {
					// .put(Clave, Valor) -> Mete el registro en el mapa.
					// OJO AQUÍ: Le asignamos un "new ArrayList" vacío.
					// Es decir, le damos a esta persona SU PROPIO folio en blanco exclusivo para
					// sus números.
					libretaContactos.put(nombrePersona, new ArrayList<Integer>());
					System.out.println("Contacto creado correctamente.");
				} else {
					System.out.println("Error: El contacto ya existe en la agenda");
				}
				break;
			}

			// OPCIÓN 2: AÑADIR TELÉFONO
			case 2: {
				System.out.println("Introduce el nombre de la persona a la que quieres añadirle un teléfono:");
				nombrePersona = sc.nextLine();

				if (libretaContactos.containsKey(nombrePersona)) {
					System.out.println("Introduce el número de teléfono");
					numeroTelefono = sc.nextInt();
					sc.nextLine(); // Limpieza del buffer tras leer el teléfono

					// [LÓGICA CLAVE]:
					// 1. libretaContactos.get(nombrePersona) -> Saca la lista (ArrayList) de esa
					// persona concreta.
					// 2. .add(numeroTelefono) -> Le añade el número A ESA LISTA.
					libretaContactos.get(nombrePersona).add(numeroTelefono);

					System.out.println("Número de teléfono añadido correctamente a la persona: " + nombrePersona);
				} else {
					System.out.println("La persona: " + nombrePersona + " no se encuentra en la libreta de contactos");
				}
				break;
			}

			// OPCIÓN 3: MOSTRAR TELÉFONOS (Leer el folio)
			case 3: {
				System.out.println("Introduce el nombre de la persona de la que quieres mostrar sus teléfonos:");
				nombrePersona = sc.nextLine();

				if (libretaContactos.containsKey(nombrePersona)) {
					// Imprimimos SOLO lo que devuelve el .get() (que es su ArrayList), no todo el
					// mapa entero.
					System.out.println("Teléfonos de " + nombrePersona + ": " + libretaContactos.get(nombrePersona));
				} else {
					System.out.println("Persona no encontrada");
				}
				break;
			}

			// OPCIÓN 4: BORRAR UN TELÉFONO CONCRETO (Borrar una línea del folio)
			case 4: {
				boolean operacionExitosa; // Variable temporal para guardar si se pudo borrar o no
				System.out.println("Introduce el nombre de la persona a la que quieres eliminarle el número:");
				nombrePersona = sc.nextLine();

				if (libretaContactos.containsKey(nombrePersona)) {
					System.out.println("Introduce el número de teléfono que deseas eliminar:");
					numeroTelefono = sc.nextInt();
					sc.nextLine(); // Limpieza de buffer

					// Integer.valueOf()
					// Si pusiéramos solo .remove(numeroTelefono), el ArrayList creería que quieres
					// borrar
					// la POSICIÓN (índice) equivalente a ese número largo (Ej: posición 654123456),
					// y petaría.
					// Con Integer.valueOf(numeroTelefono) obligas a Java a que busque el OBJETO (el
					// número exacto) y lo borre.
					// El remove() devuelve 'true' si lo encontró y borró, o 'false' si no existía.
					operacionExitosa = libretaContactos.get(nombrePersona).remove(Integer.valueOf(numeroTelefono));

					if (operacionExitosa) {
						System.out.println("Teléfono eliminado correctamente");
					} else {
						System.out.println("Ese número no está registrado para esta persona");
					}

				} else {
					System.out.println("La persona introducida no existe en la agenda");
				}
				break;
			}

			// OPCIÓN 5: BORRAR PERSONA COMPLETA (Tirar la carpeta a la basura)
			case 5: {
				System.out.println("Introduce el nombre de la persona a borrar:");
				nombrePersona = sc.nextLine();

				if (libretaContactos.containsKey(nombrePersona)) {
					// El .remove(Clave) del HashMap borra la entrada completa.
					// Al borrar a la persona, automáticamente su ArrayList desaparece con ella (se
					// lo lleva el recolector de basura).
					libretaContactos.remove(nombrePersona);
					System.out.println("Contacto eliminado correctamente");
				} else {
					System.out.println("El nombre " + nombrePersona + " no se encuentra en la agenda");
				}
				break;
			}

			// OPCIÓN 0: SALIR
			case 0: {
				System.out.println("Saliendo del programa...");
				break;
			}

			// SI TECLEAN UN NÚMERO FUERA DE RANGO (ej: 9)
			default: {
				System.out.println("Seleccione una de las opciones válidas (0-5)");
			}
			}
		}

		// Se cierra el Scanner al salir del bucle para liberar recursos de memoria.
		sc.close();
	}
}