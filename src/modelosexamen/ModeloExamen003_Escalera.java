package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloExamen003_Escalera {
	static String[][] juegos = { { "CASA", "PATO" }, { "PISO", "TUBO" }, { "CENA", "MURO" }, { "BONO", "DEDO" },
			{ "ROJO", "PASA" } };
	static String palabraInicio;
	static String palabraObjetivo;
	static String jugada;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Es jugada válida cuando solo cambia una letra entre la palabraDelJugador y la
		// anterior jugada (o palabra inicial si es la primera jugada)
		boolean jugadaValida = false;
		boolean hayGanador = false;
		int intentosRestantes = 7;

		String jugadaActual;
		System.out.println("Bienvenido al juego de la Escalera de Palabras");
		System.out.println("Seleccionando palabras de juego de forma automática...");
		seleccionaJuego();
		System.out.println("Palabra de inicio: " + palabraInicio);
		System.out.println("Palabra objetivo: " + palabraObjetivo);
		System.out.println("------------------------------");
		// Bucle fin de juego
		while (!hayGanador && intentosRestantes > 0) {
			while (!jugadaValida) {
				System.out.println("Introduce una palabra:");
				jugadaActual = sc.nextLine().toUpperCase();
				if (jugadaActual.length() != 4) {
					System.out.println("Error, la longitud de la palabra es incorrecta (4 letras)");
				} else {
					if (compruebaIntento(jugadaActual)) {
						System.out.println("Palabra recogida correctamente");
						jugada += jugadaActual + " - ";
						intentosRestantes--;
						jugadaValida = true;
					} else {
						System.out.println("ERROR. Has cambiado más de 1 letra");
					}
				}

			}
			System.out.println("El último intento fue: " + ultimoIntento());
			// Reset de la bandera jugadaValida para seguir el juego
			jugadaValida = false;
			System.out.println("Jugada: " + jugada);
			System.out.println("Intentos restantes: " + intentosRestantes);

			if (ultimoIntento().equals(palabraObjetivo)) {
				hayGanador = true;
				System.out.println("¡¡ENHORABUENA!!");
				System.out.println("HAS ALCANZADO LA PALABRA");
			}
			if (intentosRestantes == 0 && !hayGanador) {

				System.out.println("Has agotado todos tus intentos...");
				System.out.println("¡¡¡¡YOU LOSE!!!!");
			}
		}
		System.out.println("Saliendo del programa...");
		sc.close();
	}

	public static void seleccionaJuego() {
		Random rd = new Random();
		int casillaAleatoria;
		casillaAleatoria = rd.nextInt(juegos.length);
		palabraInicio = juegos[casillaAleatoria][0];
		palabraObjetivo = juegos[casillaAleatoria][1];
		jugada = palabraInicio + " - ";

	}

	public static String ultimoIntento() {
		String ultimaJugada = "";
		try {
			ultimaJugada = ultimaJugada + jugada.substring(jugada.length() - 7, jugada.length() - 3);
		} catch (Exception e) {
			System.out.println("Aviso del Sistema: NO hay historial suficiente para extraer el intento");
			ultimaJugada = palabraInicio;
		}
		return ultimaJugada;
	}

	public static boolean compruebaIntento(String intento) {
		boolean esCorrecto = false;
		int contadorIguales = 0;
		char[] intentoDespiezado;
		char[] ultimoIntentoDespiezado;
		// Normalizo todo a mayusculas
		intento = intento.toUpperCase();
		// Creo almacen de letras
		intentoDespiezado = intento.toCharArray();
		ultimoIntentoDespiezado = ultimoIntento().toCharArray();

		for (int i = 0; i < intentoDespiezado.length; i++) {
			if (intentoDespiezado[i] == ultimoIntentoDespiezado[i]) {
				contadorIguales++;
			}
		}
		if (contadorIguales == 3) {
			esCorrecto = true;
		}
		return esCorrecto;

	}

}
