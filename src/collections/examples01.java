package collections;

import java.util.ArrayList;

public class examples01 {

	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<>();
		ArrayList<String> lista2 = new ArrayList<>();
		ArrayList<String> lista3 = new ArrayList<>();
		lista.add("Ana");
		lista.add("Pepe");
		lista.add("Luis");
		// Para añadir un elemento en una posición concreta, se usa el método .add() con dos parámetros: el índice y el elemento a insertar
		lista.add(1, "Manuel");
		System.out.println(lista);
		

	}

}
