package collections;

import java.util.ArrayList;

public class EjemploForEach {

	public static void main(String[] args) {
		int[] notas = { 7, 5, 9, 10, 6 };
		int suma = 0;
		for (int nota : notas) {
			suma += nota;
		}
		double media = (double) suma / notas.length;
		System.out.println("La media es: " + media);
		
		ArrayList<String> alumnos = new ArrayList<>();
		alumnos.add("Ana");
		alumnos.add("Luis");
		alumnos.add("Marta");
		
		for (String nombre: alumnos) {
			System.out.println("Alumnos: "+nombre.toUpperCase());
		}
		
		

	}

}
