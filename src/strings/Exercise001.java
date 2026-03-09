package strings;

public class Exercise001 {

	public static void main(String[] args) {
		String frase1 = "Me llamo Jaime";
		String frase2 = "Que tal estas";
		// Creacion de booleano (innecesario) para practicar
		boolean esFrase1MasCorta=false;
		if (frase1.length()<frase2.length()) {
			
			esFrase1MasCorta=true;
		} 
		if (esFrase1MasCorta) {
			System.out.println("La frase 1 es mas corta");
		} else {
			System.out.println("La frase 2 es mas corta");
		}
	}

}
