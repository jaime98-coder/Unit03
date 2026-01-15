package practicaexamen;

import java.util.Random;
import java.util.Scanner;

public class EjercicioTipoExamen001 {

	public static void main(String[] args) {
		String[] tablaJugador = new String[5];
		String[] tablaMaquina = new String[5];
		int direccionJugador = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("--------Menú--------");
		System.out.println("Elige la dirección del chute:");
		System.out.println("1. Izquierda");
		System.out.println("2. Centro");
		System.out.println("3. Derecha");
		System.out.println("--------------------");
		int direccionChute = sc.nextInt();
		Random movimientoMaquinaRandom = new Random();
		int resultadoJugada = -1;
		switch (direccionJugador) {
		case 1: {
			System.out.println("Has elegido izquierda");
			break;
		}
		case 2: {
			System.out.println("Has elegido centro");
			break;


		}
		case 3: {
			System.out.println("Has elegido derecha");
			break;


		}
		default: {
			System.out.println("No has elegida ninguna opción correcta");
			break;

		}
		}
		int posicionParadaMaquina;
		posicionParadaMaquina = movimientoMaquinaRandom.nextInt(1, 4);
		if (direccionJugador == posicionParadaMaquina) {
			resultadoJugada = 1;
			System.out.println("La maquina ha parado el chute");
		} else {
			resultadoJugada = 0;
			System.out.println("Gol del jugador");
		}
		System.out.println("------------");
		System.out.println(posicionParadaMaquina);
		System.out.println(posicionParadaMaquina);
		System.out.println(posicionParadaMaquina);
		System.out.println(posicionParadaMaquina);
		

	}

}
