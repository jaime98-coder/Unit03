package funciones;

import java.util.Random;
import java.util.Scanner;

public class Exercise004 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// PRIMERA TABLA DEFINIDA
		int[] tablaBusqueda = { 3, 6, 9, 7, 25 };
		System.out.println("Introduce la clave a buscar:");
		int claveABuscar = sc.nextInt();
		System.out.println("-------------------------------------------------------------------------------------");

		System.out.println("\nPrimera tabla busqueda definida");
		mostrarTabla(tablaBusqueda);
		System.out.println();
		int posicionResultado = buscar(tablaBusqueda, claveABuscar);
		System.out.println("-------------------------------------------------------------------------------------");
		// SEGUNDA TABLA ALEATORIA
		System.out.println("\nSegunda tabla busqueda aleatoria");
		Random aleatorio = new Random();
		int[] tablaBusquedaAleatoria = new int[30];
		for (int i = 0; i < tablaBusquedaAleatoria.length; i++) {
			tablaBusquedaAleatoria[i] = aleatorio.nextInt(1, 50);

		}
		mostrarTabla(tablaBusquedaAleatoria);
		System.out.println();
		claveABuscar = buscar(tablaBusquedaAleatoria, claveABuscar);
		System.out.println("-------------------------------------------------------------------------------------");

	}

	public static int buscar(int[] t, int clave) {
		
		int posicionEncontrada = -1;
		for (int i = 0; i < t.length; i++) {
			if (clave == t[i]) {
				posicionEncontrada=i;
				System.out.println("¡La clave aparece en la tabla 't'!");
				System.out.println("Se encuentra en la posición " + i);

			}
		}
		if (clave == -1) {
			System.out.println("\nLa clave NO aparece en la tabla");
		}
		System.out.println();
		return posicionEncontrada;
	}

	public static void mostrarTabla(int[] t2) {
		for (int i = 0; i < t2.length; i++) {
			System.out.print(t2[i] + " ");

		}
	}

}
