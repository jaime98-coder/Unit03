package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloEzamen001_3ER_3 {
	static final char[][] parking = new char[4][4];
	// Hueco libre
	static final char LIBRE = 'L';
	// Vehículo gestionado por usuario
	static final char ELECTRICO = 'E';
	// Vehículo gestionado por sistema
	static final char COMBUSTION = 'C';

	static Random rd = new Random();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int turno;
		int contadorPlazasOcupadas = 0;
		int filaUsuario;
		int columnaUsuario;
		boolean aparcamientoValido = false;
		boolean hayBloque = false;
		boolean estaParkingLleno = false;
		String respuesta = "";

		do {
			estaParkingLleno = false;
			hayBloque = false;
			contadorPlazasOcupadas = 0;
			aparcamientoValido = false;
			// Bienvenida
			System.out.println("Bienvenido al Sistema de Parking Inteligente");
			// Inicializacion
			System.out.println("Inicializando parking...");
			limpiarParking();
			// Eligiendo turnos
			System.out.println("Eligiendo quien comienza a aparcar...");
			turno = sorteoTurno();
			// Muestra parking vacio inicial
			imprimeParking();
			System.out.println();
			System.out.println();
			while (!hayBloque && !estaParkingLleno) {

				// Lógica de turno del usuario/operario
				if (turno == 1) {
					System.out.println("Turno del operario");
					aparcamientoValido = false;
					while (!aparcamientoValido) {

						System.out.println("Introduce fila del parking donde quieres aparcar el coche");
						filaUsuario = sc.nextInt();
						System.out.println("Introduce columna del parking donde quieres aparcar el coche");
						columnaUsuario = sc.nextInt();
						// Si es true el método, aparcamientoValido es true y sale del bucle
						if (operarioAparcaElectrico(filaUsuario, columnaUsuario)) {
							System.out.println(
									"Coche aparcado correctamente en [" + filaUsuario + " - " + columnaUsuario + " ]");
							contadorPlazasOcupadas++;

							aparcamientoValido = true;
							// Sino devuelve false y vuelve a iterar el bucle de aparcamiento valido
						} else {
							System.out.println("Introduce de nuevo una posición válida");

						}
					}
					// Comprobación de si hay bloque (booleano que finaliza el bucle)
					if (detectarZonaBloque(ELECTRICO)) {
						hayBloque = true;

					} else if (turno == 1) {
						turno = 0;
						System.out.println("Pasando turno al sistema...");
					}

					imprimeParking();
				} else {
					System.out.println("Turno del sistema");
					entradaCocheAutomatico();
					System.out.println("El sistema ha aparcado un coche de combustión (automático)");

					contadorPlazasOcupadas++;
					if (detectarZonaBloque(COMBUSTION)) {
						hayBloque = true;

					} else {
						turno = 1;
						System.out.println("Pasando turno al usuario...");
					}
					imprimeParking();
				}
				if (!hayBloque && contadorPlazasOcupadas == 16) {
					estaParkingLleno = true;

				}
			}
			if (hayBloque && turno == 1) {
				System.out.println("¡Zona de Bajas Emisiones de 2x2 completada!");

			} else if (hayBloque && turno == 0) {
				System.out.println("¡Alerta! Zona de Alta Contaminación de 2x2 detectada. Error del sistema...");
			} else if (estaParkingLleno) {
				System.out.println("Parking lleno. No se formaron zonas.");
			}
			sc.nextLine();
			System.out.println("¿Desea reiniciar el Sistema para un nuevo día? (S/N)");
			respuesta = sc.nextLine();
		} while (respuesta.equalsIgnoreCase("S"));
		System.out.println("¡¡Hasta el próximo día!!");
		sc.close();
	}

	// Inicializar parking a LIBRE
	public static void limpiarParking() {
		for (int i = 0; i < parking.length; i++) {
			for (int j = 0; j < parking[i].length; j++) {
				parking[i][j] = LIBRE;
			}
		}
	}

	/*
	 * Imprimir en consola el estado actual del parking
	 */
	public static void imprimeParking() {
		for (int i = 0; i < parking.length; i++) {
			for (int j = 0; j < parking[i].length; j++) {
				System.out.print(parking[i][j] + " ");
			}
			System.out.println();
		}
	}

	/*
	 * Método para decidir quien comienza a colocar coches en parking 1 --> Usuario.
	 * 0 --> Sistema
	 * 
	 * @return devuelve el turno (0-1)
	 */
	public static int sorteoTurno() {
		return rd.nextInt(2);
	}

	public static void entradaCocheAutomatico() {
		int filaAleatoria;
		int columnaAleatoria;
		boolean estaVacia = false;

		while (!estaVacia) {
			filaAleatoria = rd.nextInt(parking.length);
			columnaAleatoria = rd.nextInt(parking[0].length);
			if (parking[filaAleatoria][columnaAleatoria] == LIBRE) {
				parking[filaAleatoria][columnaAleatoria] = COMBUSTION;

				estaVacia = true;

			} else {
				System.out.println("Sistema intentó aparcar en una plaza ocupada, reintentando...");
			}
		}

	}

	/**
	 * Método con lógica para que usuario aparque el coche (siempre que no esté
	 * ocupado, ya que daría false y no haría nada)
	 * 
	 * @param fila
	 * @param columna
	 * @return
	 */
	public static boolean operarioAparcaElectrico(int fila, int columna) {
		boolean posicionValida = false;

		if (fila >= 0 && fila < parking.length && columna >= 0 && columna < parking.length
				&& parking[fila][columna] == LIBRE) {
			parking[fila][columna] = ELECTRICO;
			posicionValida = true;
		} else {
			System.out.println("Posición no válida...");
			posicionValida = false;
		}

		return posicionValida;

	}

	public static boolean detectarZonaBloque(char tipoVehiculo) {
		boolean bloqueFormado = false;
		for (int l = 0; l < parking.length - 1 && !bloqueFormado; l++) {
			// Comprobación de las 2 filas de arriba
			for (int i = 0; i < parking.length - 1 && !bloqueFormado; i++) {
				if (parking[l][i] == tipoVehiculo && parking[l][i + 1] == tipoVehiculo
						&& parking[l + 1][i] == tipoVehiculo && parking[l + 1][i + 1] == tipoVehiculo) {
					bloqueFormado = true;
				}
			}
		}

		return bloqueFormado;
	}

}
