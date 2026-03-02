package practicaexamen;

import java.util.Scanner;

public class ReservasVIPGem {
	final static char LIBRE = 'L';
	final static char OCUPADO = 'O';

	public static void main(String[] args) {
		char[] sala = new char[10];
		Scanner sc = new Scanner(System.in);
		int opcion;
		boolean finPrograma = false;
		// Inicializo el cine a 'L'
		inicializarFila(sala);
		do {
			System.out.println("------Menú------");
			System.out.println("1. Mostrar asientos");
			System.out.println("2. Asignar primer asiento libre automáticamente");
			System.out.println("3. Salir");
			System.out.println("----------------");
			System.out.println("Elige una opción");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1: {
				System.out.println("Mostrando asientos disponibles...");
				mostrarFila(sala);
				break;
			}
			case 2: {
				System.out.println("Asignando asiento libre automáticamente...");
				if (buscarPrimerLibre(sala)) {
					System.out.println("¡Asiento reservado con exito!");
				}
				break;
			}
			case 3: {
				System.out.println("Saliendo del programa...");
				System.out.println("¡¡Hasta pronto!!");
				finPrograma = true;
				break;
			}
			default: {
				System.out.println("Elige una de las 3 opciones");
				break;
			}
			}

		} while (!finPrograma);

		sc.close();
	}

	static void inicializarFila(char[] sala) {
		for (int i = 0; i < sala.length; i++) {
			sala[i] = LIBRE;
		}
	}

	static void mostrarFila(char[] sala) {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("0\t1\t2\t3\t4\t5\t6\t7\t8\t9");
		for (int i = 0; i < sala.length; i++) {
			System.out.print(sala[i] + "\t");
		}
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");

	}

	/**
	 * 
	 * @return boolean. True si reserva asiento. False si
	 */
	static boolean buscarPrimerLibre(char[] sala) {
		boolean encontrado = false;
		// Bucle para que se repita

		for (int i = 0; i < sala.length && !encontrado; i++) {
			// Lógica para cambiar de LIBRE a OCUPADO
			if (sala[i] == LIBRE) {
				sala[i] = OCUPADO;
				encontrado = true;
				System.out.println("Asiento reservado en la posición " + i);

			}
		}
		// Si no hay asientos libres, imprime el mensaje indicandoo y ademas el método
		// devuelve false
		if (!encontrado) {
			System.out.println("No quedan asientos libres");
		}

		return encontrado;
	}

}
