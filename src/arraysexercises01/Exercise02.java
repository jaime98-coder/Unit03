package arraysexercises01;

import java.util.Scanner;

public class Exercise02 {

    public static void main(String[] args) {
        
        // --- 1. Declaración e Inicialización ---
        
        // Es buena práctica en Java poner los corchetes junto al tipo de dato: double[]
        double[] numeros = new double[5]; 
        
        Scanner sc = new Scanner(System.in);

        // --- 2. Entrada de datos ---
        
        // Bucle para rellenar el array
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduce el valor para la posición " + i + ":");
            // Correcto: asignamos al índice 'i'
            numeros[i] = sc.nextDouble(); 
        }

        // --- 3. Salida de datos ---

        System.out.println("Los valores introducidos son:");
        
        // Necesitamos OTRO bucle para recorrer y mostrar el contenido
        for (int i = 0; i < numeros.length; i++) {
            // Aquí accedemos a la posición 'i' para mostrarla
            System.out.println("En la posición " + i + " hay un: " + numeros[i]);
        }
        
        // --- 4. Cierre ---
        sc.close();
    }

}