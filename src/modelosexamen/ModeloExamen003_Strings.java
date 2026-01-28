package modelosexamen;

import java.util.Random;
import java.util.Scanner;

public class ModeloExamen003_Strings {
	static String [][]juegos = {{"CASA", "PATO"},
								{"PISO", "TUBO"},
								{"CENA", "MURO"},
								{"BONO", "DEDO"},
								{"ROJO", "PASA"}};
	
	static String palabraInicio;
	static String palabraObjetivo;
	static String jugada;
	static Random rd = new Random();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String juegoSeleccionado;
		int intentosRestantes=7;
		boolean jugadaValida=false;
		seleccionaJuego(juegos);
		System.out.println("¡Bienvenido al juego de palabras!");
		System.out.println("Palabra inicio: "+palabraInicio);
		System.out.println("Palabra objetivo: "+palabraObjetivo);
		System.out.println("Introduce tu primera jugada:");
		jugada=sc.nextLine().toLowerCase();
		while (intentosRestantes>0 && !jugada.equals(palabraObjetivo)) {
			System.out.println("Tu jugada actual es: "+ultimoIntento(jugada));
			System.out.println("Introduce tu siguiente jugada:");
			String nuevoIntento=sc.nextLine().toLowerCase();
			jugadaValida=compruebaIntento(nuevoIntento);
			if (jugadaValida) {
				jugada=nuevoIntento;
				System.out.println("Jugada válida.");
			} else {
				intentosRestantes--;
				System.out.println("Jugada no válida. Te quedan "+intentosRestantes+" intentos.");
			}
			if (jugada.equals(palabraObjetivo)) {
				System.out.println("¡Enhorabuena! Has ganado el juego.");
			} else {
				System.out.println("Lo siento, has perdido. La palabra objetivo era: "+palabraObjetivo);
			}
		}
		
		
		
		
		sc.close();
	}
	
	public static void seleccionaJuego(String[][]juegos) {
		int filaSeleccAleatoria;
		filaSeleccAleatoria=rd.nextInt(0,juegos.length);
		palabraInicio=juegos[filaSeleccAleatoria][0];
		palabraObjetivo=juegos[filaSeleccAleatoria][1];
		jugada=palabraInicio;
		
	}
	
	public static String ultimoIntento() {
		String palabraResultado="";
		return ultimoIntento;
	}
//	Recibe el nuevo 
//	intento del jugador y devuelve un booleano para indicar si el intento es 
//	correcto, es decir, sólo varía una letra entre intento y el último intento. 
	
	public static boolean compruebaIntento(String intento) {
		boolean jugadaCorrecta = false;
		String jugadaLimpia;
		jugadaLimpia=jugada.trim();
		int letrasDiferentes=0;
		for (int i = 0; i < intento.length(); i++) {
			if (intento.charAt(i)!=jugadaLimpia.charAt(i)) {
				letrasDiferentes++;
			}
		}
		if (letrasDiferentes==1) {
			jugadaCorrecta=true;
			jugada=intento;
		}
		return jugadaCorrecta;		
		
	}
	
	
	

}
