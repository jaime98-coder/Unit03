package arraysexercises;

public class Exercise04 {

	public static void main(String[] args) {
		// Declaro la tabla num de 12 de longitud
		int[] num = new int[12];
		// Relleno la tabla con los valores indicados
		num[0] = 39;
		num[1] = -2;
		num[4] = 0;
		num[6] = 14;
		num[8] = 5;
		num[9] = 120;
		// Recorro la tabla e imprimo el índice y el valor que contiene
		for (int i = 0; i < num.length; i++) {
			System.out.println("El índice " + i + " contiene el valor: " + num[i]);
			
		}
	}

}
