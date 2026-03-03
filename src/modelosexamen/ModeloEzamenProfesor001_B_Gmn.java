package modelosexamen;
import java.util.Scanner;

public class ModeloEzamenProfesor001_B_Gmn {

    public static void main(String[] args) {
        // --- DECLARACIÓN DE VARIABLES PRIMITIVAS ---
        int numApariciones;
        double porcentajeUso;
        
        // Inicializamos el objeto Scanner en una sola línea para leer de teclado
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== DETECTOR DE MENSAJES OCULTOS ===");
        System.out.println("Introduce el texto a analizar:");
        // Leemos la línea completa introducida por el usuario
        String textoOriginal = sc.nextLine();
        
        System.out.println("Introduce el mensaje oculto a buscar:");
        // Leemos el mensaje a buscar
        String mensajeOculto = sc.nextLine();
        
        // --- LÓGICA PRINCIPAL Y ARRAYS ---
        // Normalizamos los textos usando nuestra función auxiliar
        String textoLimpio = normalizarTexto(textoOriginal);
        String mensajeLimpio = normalizarTexto(mensajeOculto);
        
        // Declaramos e inicializamos los arrays justo antes de usarlos por primera vez
        char[] arrayTexto = convertirAArray(textoLimpio);
        char[] arrayMensaje = convertirAArray(mensajeLimpio);
        
        // Buscamos el mensaje y guardamos las posiciones en un array
        int[] posiciones = buscarMensaje(arrayTexto, arrayMensaje);
        
        // Obtenemos el número de apariciones contando la longitud del array devuelto
        numApariciones = posiciones.length;
        
        // Calculamos el porcentaje usando la función requerida
        porcentajeUso = calcularPorcentaje(numApariciones, arrayMensaje.length, arrayTexto.length);
        
        // --- SALIDA DE RESULTADOS ---
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("El mensaje aparece " + numApariciones + " veces.");
        
        if (numApariciones > 0) {
            System.out.print("Posiciones iniciales: ");
            // Contador i para recorrer el array de posiciones resultantes
            for (int i = 0; i < posiciones.length; i++) {
                System.out.print(posiciones[i] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Porcentaje de letras utilizadas: " + porcentajeUso + "%");
        
        // Siempre debemos cerrar el Scanner al terminar de usarlo
        sc.close();
    }

    // 1. Función para normalizar el texto
    public static String normalizarTexto(String texto) {
        // Al estar fuera del main, podemos declarar e inicializar en la misma línea
        // Convertimos a minúsculas y reemplazamos los espacios por cadenas vacías
        String textoNormalizado = texto.toLowerCase().replace(" ", "");
        return textoNormalizado;
    }

    // 2. Función para convertir String a Array de caracteres
    public static char[] convertirAArray(String texto) {
        // Utilizamos el método propio de la clase String
        return texto.toCharArray();
    }

    // 3. Función para buscar el mensaje
    public static int[] buscarMensaje(char[] textoArr, char[] msjArr) {
        // Arrays y variables locales de la función
        int[] posicionesTemp = new int[textoArr.length];
        int apariciones = 0;
        int indiceMsj = 0;
        int posInicio = -1;
        
        // Si el mensaje está vacío, devolvemos un array vacío directamente
        if (msjArr.length == 0) {
            return new int[0];
        }

        // Contador i para recorrer el texto caracter a caracter
        for (int i = 0; i < textoArr.length; i++) {
            if (textoArr[i] == msjArr[indiceMsj]) {
                // Si es la primera letra del mensaje, guardamos su posición
                if (indiceMsj == 0) {
                    posInicio = i;
                }
                
                // Avanzamos al siguiente caracter del mensaje a buscar
                indiceMsj++;
                
                // Si hemos encontrado el mensaje completo
                if (indiceMsj == msjArr.length) {
                    posicionesTemp[apariciones] = posInicio;
                    apariciones++;
                    // Reiniciamos el índice para buscar la siguiente aparición
                    indiceMsj = 0; 
                }
            }
        }
        
        // Creamos el array final con el tamaño exacto de las apariciones
        int[] posicionesFinales = new int[apariciones];
        // Contador j para copiar los datos al array definitivo
        for (int j = 0; j < apariciones; j++) {
            posicionesFinales[j] = posicionesTemp[j];
        }
        
        return posicionesFinales;
    }

    // 4. Función para calcular el porcentaje de uso
    public static double calcularPorcentaje(int numApariciones, int longMsj, int longTexto) {
        // Si el texto está vacío, evitamos división por cero
        if (longTexto == 0) {
            return 0.0;
        }
        
        // Calculamos el total de letras usadas
        int letrasUsadas = numApariciones * longMsj;
        
        // Realizamos el cálculo multiplicando por 100.0 para forzar el resultado decimal (double)
        double porcentaje = (letrasUsadas * 100.0) / longTexto;
        
        return porcentaje;
    }
}