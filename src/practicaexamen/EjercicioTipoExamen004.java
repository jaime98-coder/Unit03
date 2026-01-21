package practicaexamen;

import java.util.Scanner;
import java.util.Random; // <-- ¡IMPORTANTE! Necesario para usar Random

public class EjercicioTipoExamen004 {

    public static void main(String[] args) {
        // --- 1. DECLARACIÓN DE VARIABLES ---
        Scanner sc = new Scanner(System.in);
        
        final int TAMANO = 5;
        final int BARCOS_TOTALES = 3;

        // Matriz del tablero: 0=Agua, 1=Barco, 2=Fallo, 3=Tocado
        int[][] tablero = new int[TAMANO][TAMANO];

        int barcosHundidos = 0;
        int filaUsuario = 0;
        int colUsuario = 0;
        boolean juegoActivo = true;
        boolean coordenadaValida;

        System.out.println("--- HUNDIR LA FLOTA (EXAMEN) ---");
        System.out.println("Tablero de " + TAMANO + "x" + TAMANO + ". Hay " + BARCOS_TOTALES + " barcos ocultos.");

        // --- 2. CONFIGURACIÓN INICIAL ---
        // Colocamos los barcos usando la nueva lógica con Random
        colocarBarcos(tablero, BARCOS_TOTALES);

        // --- 3. BUCLE PRINCIPAL DEL JUEGO ---
        while (juegoActivo) {

            // Paso A: Mostrar el tablero
            mostrarTablero(tablero);
            
            System.out.println("\nLlevas hundidos: " + barcosHundidos + " de " + BARCOS_TOTALES);

            // Paso B: Pedir coordenadas con validación
            coordenadaValida = false;
            while (!coordenadaValida) {
                try {
                    System.out.println("Introduce coordenadas de disparo:");
                    
                    System.out.print("Fila (1-" + TAMANO + "): ");
                    filaUsuario = sc.nextInt();
                    
                    System.out.print("Columna (1-" + TAMANO + "): ");
                    colUsuario = sc.nextInt();
                    
                    sc.nextLine(); // Limpiar buffer

                    // Ajustamos de 1-5 a 0-4
                    filaUsuario = filaUsuario - 1;
                    colUsuario = colUsuario - 1;

                    // Comprobamos rango
                    if (filaUsuario >= 0 && filaUsuario < TAMANO && colUsuario >= 0 && colUsuario < TAMANO) {
                        coordenadaValida = true;
                    } else {
                        System.out.println("ERROR: Coordenadas fuera del tablero.");
                    }

                } catch (Exception e) {
                    System.out.println("ERROR: Debes introducir números enteros.");
                    sc.nextLine();
                }
            }

            // Paso C: Lógica de Disparo
            if (tablero[filaUsuario][colUsuario] == 0) {
                System.out.println(" Has fallado.");
                tablero[filaUsuario][colUsuario] = 2; // Fallo

            } else if (tablero[filaUsuario][colUsuario] == 1) {
                System.out.println("¡BARCO HUNDIDO!");
                tablero[filaUsuario][colUsuario] = 3; // Tocado
                barcosHundidos++;

            } else {
                System.out.println("\n>>> ¡Ya habías disparado en esta casilla!");
            }

            // Paso D: Victoria
            if (barcosHundidos == BARCOS_TOTALES) {
                juegoActivo = false;
            }
        }

        // --- 4. FIN DEL JUEGO ---
        System.out.println("\n*****************************************");
        System.out.println(" ¡VICTORIA! HAS ELIMINADO TODA LA FLOTA ");
        System.out.println("*****************************************");
        
        mostrarTablero(tablero);
        
        sc.close();
    }

    /**
     * Coloca barcos usando la clase Random (Versión Mejorada).
     */
    public static void colocarBarcos(int[][] tablero, int cantidad) {
        // Instanciamos la clase Random una sola vez
        Random aleatorio = new Random();
        
        int barcosPuestos = 0;
        int fRandom, cRandom;

        while (barcosPuestos < cantidad) {
            
            // Generamos enteros aleatorios entre 0 y el tamaño del tablero (exclusivo)
            // Si tablero.length es 5, nextInt(5) devuelve 0, 1, 2, 3 o 4.
            fRandom = aleatorio.nextInt(tablero.length);
            cRandom = aleatorio.nextInt(tablero[0].length);

            // Verificamos si es AGUA (0)
            if (tablero[fRandom][cRandom] == 0) {
                tablero[fRandom][cRandom] = 1; // Ponemos barco
                barcosPuestos++;
            }
        }
    }

    /**
     * Muestra el tablero por pantalla con la máscara visual.
     */
    public static void mostrarTablero(int[][] tablero) {

        System.out.println("---------");
        
        for (int i = 0; i < tablero.length; i++) {
        
            
            for (int j = 0; j < tablero[i].length; j++) {
                
                if (tablero[i][j] == 0 || tablero[i][j] == 1) {
                    System.out.print("~ "); // Oculto
                } else if (tablero[i][j] == 2) {
                    System.out.print("O "); // Fallo
                } else if (tablero[i][j] == 3) {
                    System.out.print("X "); // Tocado
                }
            }
            System.out.println();
        }
    }
}