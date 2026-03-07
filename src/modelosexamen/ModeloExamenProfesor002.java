package modelosexamen;

import java.util.Scanner;

public class ModeloExamenProfesor002 {
	static int marcadosComoAlterados;
	static String mensajeConMayorLongitud;

	public static void main(String[] args) {
		String[] mensajes = { "LA NIEBLA CUBRE EL PUENTE", "NO MIRES DETRÁS DE LA PUERTA",
				"EL RELOJ SUENA A MEDIANOCHE", "LAS SOMBRAS SABEN TU NOMBRE", "TODO MENSAJE DEJA UNA HUELLA",
				"EL ECO REPITE LA VERDAD", "ALGUIEN ESCONDE ALGO AQUI", "NUNCA APAGUES LA RADIO" };

		Scanner sc = new Scanner(System.in);

		int contadorLetras;
		int posicionArrayFrases;
		String mensajeExtraido;
		int respuestaMenu;
		int numeroMensajesConPalabra = 0;
		String palabraABuscar = "";
		char letraABuscar;

		// MENÚ INICIAL
		System.out.println("\nARCHIVO DE LOS ECOS");
		System.out.println("----------------------------------------------");
		System.out.println("1. Mostrar mensajes");
		System.out.println("2. Contar letra en un mensaje");
		System.out.println("3. Extraer mensaje oculto");
		System.out.println("4. Buscar palabra en todos los mensajes");
		System.out.println("5. Marcar mensaje como alterado");
		System.out.println("6. Mostrar palabra más larga de un mensaje");
		System.out.println("7. Mostrar estadísticas generales");
		System.out.println("8. Salir");
		System.out.println("----------------------------------------------");
		boolean finDePrograma = false;

		// BUCLE HASTA QUE SE MARCA SALIR
		while (!finDePrograma) {

			System.out.println("Elige una opción del MENÚ para continuar con el programa");
			respuestaMenu = sc.nextInt();

			switch (respuestaMenu) {
			case 1: {
				System.out.println("Mostrando mensajes...");
				mostrarMensajes(mensajes);
				break;
			}
			case 2: {
				System.out.println("Accediendo a contar letras en un mensaje...");
				System.out.println("Introduce la posición del mensaje que quieres buscar");
				// Llamo a la funcion mostrar mensajes para recordar al usuario las posiciones
				mostrarMensajes(mensajes);
				posicionArrayFrases = sc.nextInt();
				if (esIndiceValido(mensajes, posicionArrayFrases)) {
					System.out.println("Introduce la letra que quieres buscar en un mensaje concreto");
					letraABuscar = sc.next().charAt(0);

					// Contador de letras
					contadorLetras = contarLetra(mensajes[posicionArrayFrases], letraABuscar);
					System.out.println("La letra aparece: " + contadorLetras + " veces.");
				} else {
					System.out.println("Índice incorrecto. El mensaje no existe");
				}

				// Pdte imprimirlo en estadisticas generales
				break;
			}
			case 3: {
				System.out.println("Accediendo a extraer mensaje oculto");
				System.out.println("Introduce la posición del mensaje que quieres buscar");
				// Llamo a la funcion mostrar mensajes para recordar al usuario las posiciones
				mostrarMensajes(mensajes);
				posicionArrayFrases = sc.nextInt();
				if (esIndiceValido(mensajes, posicionArrayFrases)) {
					mensajeExtraido = extraerMensajeOculto(mensajes[posicionArrayFrases]);
					System.out.println("Mensaje extraido: " + mensajeExtraido);
				} else {
					System.out.println("Índice incorrecto. El mensaje no existe");
				}

				// Pdte de imprimirlo en mostrar estadisticas generales
				break;

			}
			case 4: {
				sc.nextLine();
				System.out.println("Accediendo a buscar palabra en todos los mensajes...");
				System.out.println("Introduce la palabra que quieres buscar en los mensajes (frases)");
				palabraABuscar = sc.nextLine();

				numeroMensajesConPalabra = buscarMensajesConPalabra(mensajes, palabraABuscar.toUpperCase());
				// Pdte pasar esto a estadisticas generales
				System.out
						.println("Numero de mensajes que contiene la palabra introducida: " + numeroMensajesConPalabra);
				break;
			}
			case 5: {
				System.out.println("Accediendo a: Marcar mensaje como alterado");
				System.out.println("Introduce la posición del mensaje que quieres buscar");
				// Llamo a la funcion mostrar mensajes para recordar al usuario las posiciones
				mostrarMensajes(mensajes);
				posicionArrayFrases = sc.nextInt();
				if (esIndiceValido(mensajes, posicionArrayFrases)) {
					if (marcarAlterado(mensajes, posicionArrayFrases)) {
						System.out.println("EL MENSAJE ESTÁ ALTERADO");
					} else {
						System.out.println("El mensaje NO está alterado");
					}
				} else {
					System.out.println("Índice incorrecto. El mensaje no existe");
				}

				break;

			}
			// No muestra palabra mas larga
			case 6: {
				System.out.println("Accediendo a: Mostrar la palabra más larga");
				System.out.println("Introduce la posición del mensaje que quieres buscar");
				// Llamo a la funcion mostrar mensajes para recordar al usuario las posiciones
				mostrarMensajes(mensajes);
				posicionArrayFrases = sc.nextInt();

				String palabraMasLarga;
				if (esIndiceValido(mensajes, posicionArrayFrases)) {

					palabraMasLarga = palabraMasLarga(mensajes[posicionArrayFrases]);
					System.out.println("La palabra más larga es: " + palabraMasLarga);
				} else {
					System.out.println("Índice incorrecto. El mensaje no existe");
				}
				break;
			}
			case 7: {
				System.out.println("Mostrando estadisticas generales...");
				mostrarEstadisticas(mensajes);
				break;
			}
			case 8: {
				System.out.println("Saliendo del programa...");
				System.out.println("¡¡Hasta luego!!");
				finDePrograma = true;
				break;
			}
			default: {
				System.out.println("ERROR. Por favor, elige una de las opciones mostradas en pantalla");
				System.out.println("----------------------------------------------");
				System.out.println("1. Mostrar mensajes");
				System.out.println("2. Contar letra en un mensaje");
				System.out.println("3. Extraer mensaje oculto");
				System.out.println("4. Buscar palabra en todos los mensajes");
				System.out.println("5. Marcar mensaje como alterado");
				System.out.println("6. Mostrar palabra más larga de un mensaje");
				System.out.println("7. Mostrar estadísticas generales");
				System.out.println("8. Salir");
				System.out.println("----------------------------------------------");
			}

			}
		}

		// Limpio espacios de la posicion elegida anteriormente
		// PDte revisar para ver si se añade en el metodo extraer mensaje oculto
//		mensajeSinEspacios = quitarEspacios(mensajes[posicionArrayFrases]);

		sc.close();
	}

	/**
	 * Muestra mensajes indicando su índice
	 * 
	 * @param mensajes
	 */
	public static void mostrarMensajes(String[] mensajes) {
		for (int i = 0; i < mensajes.length; i++) {
			System.out.println(i + ". " + mensajes[i]);
		}
	}

	/**
	 * Método para validar índice. True si existe en el array. False si no existe.
	 * 
	 * @param mensajes
	 * @param indice
	 * @return booleano indicando si es válido índice
	 */
	public static boolean esIndiceValido(String[] mensajes, int indice) {
		boolean esIndiceValido = false;

		if (indice >= 0 && indice <= mensajes.length - 1) {
			esIndiceValido = true;
		}

		return esIndiceValido;
	}

	/**
	 * 
	 * @param mensaje
	 * @param letra
	 * @return int contador de letras
	 */
	public static int contarLetra(String mensaje, char letra) {
		int contadorLetras = 0;
		char[] almacenLetras;
		// Pasa a minusculas
		almacenLetras = mensaje.toLowerCase().toCharArray();
		char letraMinuscula;
		letraMinuscula = Character.toLowerCase(letra);

		for (int i = 0; i < almacenLetras.length; i++) {
			if (letraMinuscula == almacenLetras[i]) {
				contadorLetras++;
			}
		}

		return contadorLetras;
	}

	public static String quitarEspacios(String mensaje) {
		String mensajeSinEspacios;
		mensajeSinEspacios = mensaje.replace(" ", "");

		return mensajeSinEspacios;
	}

	public static String extraerMensajeOculto(String mensaje) {
		String mensajeExtraido = "";
		String mensajeSinEspacios;
		mensajeSinEspacios = quitarEspacios(mensaje);

		for (int i = 0; i < mensajeSinEspacios.length(); i = i + 2) {
			mensajeExtraido += mensajeSinEspacios.substring(i, i + 1);
		}
		return mensajeExtraido;
	}

	/**
	 * Devuelve cuántos mensajes contienen esa palabra, sin distinguir entre
	 * mayúsculas y minúsculas.
	 * 
	 * @param mensajes
	 * @param palabra
	 * @return int con el numero de mensajes que contienen esa palabra (en el array
	 *         general mensajes)
	 */

	public static int buscarMensajesConPalabra(String[] mensajes, String palabra) {
		int contadorPalabras = 0;

		for (int i = 0; i < mensajes.length; i++) {
			// Revisar por que no cuenta, si puse el contains
			if (mensajes[i].toLowerCase().contains(palabra.toLowerCase())) {
				contadorPalabras++;
			}
		}
		return contadorPalabras;

	}

	public static boolean marcarAlterado(String[] mensajes, int indice) {
		boolean seHaMarcado = false;
		if (esIndiceValido(mensajes, indice)) {

			// Al mensaje, se le concatena la cadena ALTERADO
			mensajes[indice] = "[ALTERADO]" + mensajes[indice];
			seHaMarcado = true;
			marcadosComoAlterados++;

			System.out.println(mensajes[indice]);
		}

		return seHaMarcado;
	}

	/**
	 * 
	 * @param mensaje
	 * @return la palabra mas larga (tras analizarlo con el metodo .length() de los
	 *         String
	 */
	public static String palabraMasLarga(String mensaje) {
		String[] almacenPalabras;
		String palabraMasLarga = "";
		almacenPalabras = mensaje.split(" ");
		for (int i = 0; i < almacenPalabras.length; i++) {
			if (almacenPalabras[i].length() > palabraMasLarga.length()) {
				palabraMasLarga = almacenPalabras[i];
			}
		}
		mensajeConMayorLongitud = palabraMasLarga;

		return palabraMasLarga;

	}

	public static void mostrarEstadisticas(String[] mensajes) {
		// Cuantos mensajes hay en total
		int contadorMensajes;
		int contadorLetrasA = 0;

		System.out.println("Número de mensajes: " + mensajes.length);
		System.out.println("Marcados como alterados: " + marcadosComoAlterados);
		System.out.println("Mensaje con mayor longitud: " + mensajeConMayorLongitud);

		for (int i = 0; i < mensajes.length; i++) {
			contadorLetrasA += contarLetra(mensajes[i], 'a');
		}
		System.out.println("Número de veces que aparece la letra A en todos los mensajes: " + contadorLetrasA);

	}

}
