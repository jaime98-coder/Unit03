package practicaexamen;

import java.util.Scanner;

public class gestionReservasHotelGem {

	static final String HABITACION_LIBRE = "LIBRE";

	public static void main(String[] args) {
		String[][] hotel = new String[4][5];
		Scanner sc = new Scanner(System.in);
		int opcion;
		String huesped = "";
		inicializarHotel(hotel);
		System.out.println("Bienvenidos al hotel");
		do {
			System.out.println("\nElige una opción: ");
			System.out.println("1. Ver estado del hotel:");
			System.out.println("2. Realizar Check-in:");
			System.out.println("3. Realizar Check-out:");
			System.out.println("4. Salir.");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1: {
				System.out.println("Mostrando estado del hotel...");
				mostrarHotel(hotel);
				break;
			}
			case 2: {
				sc.nextLine();
				System.out.println("Entrando al check in...");
				System.out.println("Introduce el nombre del cliente");
				huesped = sc.nextLine();
				if (checkIn(hotel, huesped)) {
					System.out.println("Check in realizado con éxito");
				} else {
					System.out.println("Error. Lo sentimos el hotel está lleno.");
				}
				break;
			}
			case 3: {
				sc.nextLine();
				System.out.println("Entrando al check out...");
				System.out.println("Introduce el nombre del cliente");
				huesped = sc.nextLine();
				if (checkOut(hotel, huesped)) {
					System.out.println("Check out realizado con éxito");

				} else {
					System.out.println("Error. Cliente no encontrado.");
				}
				break;
			}
			case 4: {
				System.out.println("Saliendo del programa de reservas...");
				break;
			}
			default: {
				System.out.println("Opción incorrecta, elige una de las opciones válidas.");
				break;
			}
			}
		} while (opcion!=4);
		sc.close();
	}

	/**
	 * Método para poner todas las habitaciones a la cadena LIBRE
	 * 
	 * @param hotel
	 */
	public static void inicializarHotel(String[][] hotel) {
		for (int i = 0; i < hotel.length; i++) {
			for (int j = 0; j < hotel[i].length; j++) {
				hotel[i][j] = HABITACION_LIBRE;
			}
		}
	}

	public static void mostrarHotel(String[][] hotel) {
		for (int i = 0; i < hotel.length; i++) {
			System.out.print("Planta " + i + ": ");

			for (int j = 0; j < hotel[i].length; j++) {
				System.out.print(hotel[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * @param hotel
	 * @param huesped
	 * @return hayHueco = true si hay hueco en el hotel, asignándole la primera habitacion libre al husped.
	 * hayHueco = false si NO hay hueco en el hotel.
	 */
	public static boolean checkIn(String[][] hotel, String huesped) {
		boolean hayHueco = false;
		for (int i = 0; i < hotel.length && !hayHueco; i++) {
			for (int j = 0; j < hotel[i].length && !hayHueco; j++) {
				if (hotel[i][j].equalsIgnoreCase(HABITACION_LIBRE)) {
					hotel[i][j] = huesped;
					System.out.println(huesped + " alojado en la planta " + i + ", habitación " + j);
					hayHueco = true;
				}
			}
		}

		return hayHueco;
	}

	/**
	 * 
	 * @param hotel.   El Array del Hotel
	 * @param huesped. El nombre del huesped
	 * @return true si estabaAlojado algun huesped con ese nombre, o false si no lo
	 *         estaba.
	 */
	public static boolean checkOut(String[][] hotel, String huesped) {
		// Variable booleana de control para finalizar bucle si lo encuentra
		boolean estabaAlojado = false;
		for (int i = 0; i < hotel.length && !estabaAlojado; i++) {
			for (int j = 0; j < hotel[i].length && !estabaAlojado; j++) {
				if (hotel[i][j].equalsIgnoreCase(huesped)) {
					hotel[i][j] = HABITACION_LIBRE;
					estabaAlojado = true;
				}
			}
		}
		return estabaAlojado;

	}

}
