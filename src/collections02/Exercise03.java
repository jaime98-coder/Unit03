package collections02;

import java.util.HashMap;
import java.util.Map;

public class Exercise03 {
	public static void main(String[] args) {
		String frase = "En un agujero en el suelo, vivia un hobbit. No un agujero humedo, sucio, repugnante, con restos de gusanos y olor a fango, ni tampoco un agujero, seco, desnudo y arenoso, sin nada en que sentarse o que comer: era un agujero-hobbit, y eso significa comodidad";

		// Pasamos a minúsculas para que 'E' y 'e' cuenten como la misma letra
		frase = frase.toLowerCase();

		// Mapa donde la Clave es el Character (letra) y el Valor es el Integer
		// (contador)
		HashMap<Character, Integer> cuentaLetras = new HashMap<>();

		char letraActual;

		// Recorremos la frase carácter a carácter
		for (int i = 0; i < frase.length(); i++) {
			letraActual = frase.charAt(i);

			// Aplicamos la pista: ¿Es una letra? (Ignora espacios, puntos y comas)
			if (Character.isLetter(letraActual)) {

				// Si la letra ya existe en el mapa, incrementamos su valor
				if (cuentaLetras.containsKey(letraActual)) {
					cuentaLetras.put(letraActual, cuentaLetras.get(letraActual) + 1);
				} else {
					// Si es la primera vez que aparece, la registramos con 1
					cuentaLetras.put(letraActual, 1);
				}
			}
		}

		// Mostramos el resultado recorriendo el mapa
		System.out.println("Frecuencia de aparición de cada letra:");
		for (Map.Entry<Character, Integer> entrada : cuentaLetras.entrySet()) {
			System.out.println("Letra '" + entrada.getKey() + "': " + entrada.getValue() + " veces.");
		}
	}
}