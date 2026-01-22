package modelosexamen;

import java.util.Random;

public class modeloExamen001_Arrays {

	public static void main(String[] args) {
		boolean partidaTerminada = false;
		String fichaJugador = "X";
		String fichaMaquina = "O";
		System.out.println("¡Bienvenidos al tres en raya!\n");
		imprimeTablero();
		do {
			if (jugadorInicial()) {
				System.out.println("Comienza el jugador.");
				usuarioMueveFicha(1, 1); // Ejemplo de movimiento del usuario en la posición (1,1)

			} else {
				System.out.println("Comienza la máquina.");
				mueveFichaAleatoria();
			}

		} while (!partidaTerminada);

	}

	public static void imprimeTablero() {
		int[][] tablero = new int[3][3];

		// Pintar el tablero con guiones

		System.out.println("\nTablero inicializado:");
		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero.length; j++) {
				System.out.print("-\t");
			}
			System.out.println();
		}

	}

	public static boolean jugadorInicial() {
		Random aleatorio = new Random();
		boolean jugadorComienza;
		jugadorComienza = aleatorio.nextBoolean();

		return jugadorComienza;
	}

	/*
	 * Esta función se utiliza para mover las fichas del programa. Debe generar una
	 * posición aleatoria y colocar una ficha del programa en esa posición del
	 * tablero. Hay que tener cuidado de que la casilla no esté ya ocupada,
	 * volviendo a generar una posición aleatoria hasta que dé con una casilla no
	 * ocupada.
	 */

	public static void mueveFichaAleatoria() {
		Random aleatorio = new Random();
		int[][] posicionJugada = new int[3][3];
		int[][] casillasOcupadas = new int[3][3];
		boolean jugadaValida = true;
		int fila;
		int columna;
		do {
			fila = aleatorio.nextInt(3);
			columna = aleatorio.nextInt(3);
			if (casillasOcupadas[fila][columna] == 0) {
				posicionJugada[fila][columna] = 1; // Colocar ficha del programa
				casillasOcupadas[fila][columna] = 1; // Marcar casilla como ocupada
				jugadaValida = true;
			} else {
				jugadaValida = false; // Casilla ya ocupada, generar nueva posición
			}
		} while (!jugadaValida);

	}

	public static int usuarioMueveFicha(int filaUsuario, int columnaUsuario) {
		int[][] posicionJugadaUsuario = new int[3][3];
		int[][] casillasOcupadasUsuario = new int[3][3];
		if (casillasOcupadasUsuario[filaUsuario][columnaUsuario] == 0) {
			posicionJugadaUsuario[filaUsuario][columnaUsuario] = 1; // Colocar ficha del usuario
			casillasOcupadasUsuario[filaUsuario][columnaUsuario] = 1; // Marcar casilla como ocupada
			return 1; // Movimiento válido
		} else {
			return -1; // Casilla ya ocupada, movimiento inválido
		}
	}

}
