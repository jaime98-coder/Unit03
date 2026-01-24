package practicaexamen;

import java.util.Scanner;

public class Repaso_Ejercicio001 {

    public static void main(String[] args) {
        // Inicialización del Scanner para lectura de datos por teclado
        Scanner sc = new Scanner(System.in);

        // 1. Entrada de datos
        // Solicitamos al usuario la frase que vamos a analizar
        System.out.println("Introduce una frase para comenzar: ");
        String fraseUsuario = sc.nextLine();

        // 2. Procesamiento inicial
        // Llamamos a la función auxiliar para limpiar la frase y convertirla en un array de palabras.
        // Guardamos el resultado en 'listaPalabrasUsuario' para usarlo durante todo el programa.
        String[] listaPalabrasUsuario = obtenerPalabras(fraseUsuario);

        // 3. Salida de datos (Listado)
        // Recorremos el array generado para mostrar palabra por palabra
        System.out.println("\nLista de palabras:");
        for (int i = 0; i < listaPalabrasUsuario.length; i++) {
            System.out.println(listaPalabrasUsuario[i]);
        }

        // 4. Filtrado dinámico por longitud
        // Pedimos al usuario un valor numérico para filtrar las palabras
        System.out.println("Introduce la longitud mínima para marcas los límites funcion: ");
        int longitudMinimaPalabra = sc.nextInt();

        // Calculamos cuántas palabras superan esa longitud introducida utilizando la función genérica
        System.out.println("\nNúmero total de palabras superiores o igual a " + longitudMinimaPalabra);
        int totalPalabrasLargas;
        totalPalabrasLargas = contarPalabrasLargas(listaPalabrasUsuario, longitudMinimaPalabra);
        System.out.println(totalPalabrasLargas);

        // 5. Filtrado estático (Caso específico: 5 letras)
        // Reutilizamos la misma función 'contarPalabrasLargas', pero pasando un 5 fijo como criterio
        System.out.println("\nCuantas palabras tienen 5 o más letras:");
        int conteo5LetrasOMas = contarPalabrasLargas(listaPalabrasUsuario, 5);
        System.out.println("\n5 letras o mas: " + conteo5LetrasOMas);

        // 6. Búsqueda de extremos
        // Buscamos cuál es la palabra con mayor número de caracteres
        String resultadoPalabraMasLarga;
        System.out.println("\nLa palabra más larga encontrada:");
        resultadoPalabraMasLarga = palabraMasLarga(listaPalabrasUsuario);
        System.out.println(resultadoPalabraMasLarga);

        // Cierre de recursos
        sc.close();
    }

    // --- FUNCIONES AUXILIARES ---

    /**
     * Recibe una frase cruda, elimina espacios extremos, la pasa a minúsculas
     * y la divide en un array de palabras usando el espacio como separador.
     */
    static String[] obtenerPalabras(String frase) {
        String[] palabrasSeparadas;
        
        // Limpieza de espacios en blanco al inicio y final
        String fraseLimpia = frase.trim();
        
        // Normalización a minúsculas para unificar el formato
        String fraseMinusculas = fraseLimpia.toLowerCase();
        
        // División del String en un array utilizando el espacio como delimitador
        palabrasSeparadas = fraseMinusculas.split(" ");

        return palabrasSeparadas;
    }

    /**
     * Cuenta cuántos elementos de un array de Strings tienen una longitud
     * mayor o igual a un valor mínimo especificado.
     */
    static int contarPalabrasLargas(String[] palabras, int longitudMinima) {
        int conteoPalabrasLargas = 0;

        // Recorrido del array para verificar la condición de longitud en cada palabra
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].length() >= longitudMinima) {
                conteoPalabrasLargas++;
            }
        }

        return conteoPalabrasLargas;
    }

    /**
     * Recorre el array de palabras para encontrar y devolver la que tiene mayor longitud.
     */
    static String palabraMasLarga(String[] palabras) {
        // Inicialización con cadena vacía para asegurar una base de comparación
        String laPalabraMasLarga = "";
        
        for (int i = 0; i < palabras.length; i++) {
            // Si la palabra actual es más larga que la almacenada, actualizamos el récord
            if (palabras[i].length() > laPalabraMasLarga.length()) {
                laPalabraMasLarga = palabras[i];
            }
        }
        return laPalabraMasLarga;
    }

}