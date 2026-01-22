package funciones;

public class Exercise001_repeat {

	public static void main(String[] args) {
		int resultadoSuma;
		resultadoSuma= sumarNumeros(15,145);
		System.out.println(resultadoSuma);

	}
	public static int sumarNumeros(int num1, int num2) {
		int suma=num1+num2;
		return suma;
	}

}
