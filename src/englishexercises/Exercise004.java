package englishexercises;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays; // Importamos Arrays solo para visualizarlo al final si queremos

public class Exercise004 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        // 1. Declaración de Constantes y Variables
        final int MAP_SIZE = 20;
        final int TOTAL_MINES = 6;
        final int MINE_CODE = -1; // Usamos -1 para identificar la mina internamente

        // map: contendrá la lógica (-1 mina, o >=0 número de minas cerca)
        int[] map = new int[MAP_SIZE];
        
        // visualMap: contendrá lo que ve el usuario (0 oculto, 1 revelado)
        // Usamos un array booleano paralelo para saber qué mostrar
        boolean[] isRevealed = new boolean[MAP_SIZE];

        int minesPlaced = 0;
        int randomPos;
        boolean isGameActive = true;
        int userPos;

        // ---------------------------------------------------------
        // FASE 1: COLOCACIÓN DE MINAS
        // ---------------------------------------------------------
        
        // Mientras no hayamos puesto todas las minas...
        while (minesPlaced < TOTAL_MINES) {
            randomPos = rd.nextInt(MAP_SIZE);

            // Verificamos si esa posición está vacía (0) antes de poner mina
            if (map[randomPos] != MINE_CODE) {
                map[randomPos] = MINE_CODE;
                minesPlaced++;
            }
        }

        // ---------------------------------------------------------
        // FASE 2: CÁLCULO DE PISTAS (Initializes the array with clues)
        // ---------------------------------------------------------
        
        // i: recorre cada casilla del mapa para calcular su pista
        for (int i = 0; i < map.length; i++) {
            
            // Si soy una mina, no necesito calcular pista, salto a la siguiente vuelta
            if (map[i] == MINE_CODE) {
                continue; 
            }

            int nearbyMines = 0;

            // Mirar a la IZQUIERDA (i-1)
            // Solo miramos si i > 0 para no salirnos del array
            if (i > 0 && map[i - 1] == MINE_CODE) {
                nearbyMines++;
            }

            // Mirar a la DERECHA (i+1)
            // Solo miramos si i < última posición para no salirnos
            if (i < map.length - 1 && map[i + 1] == MINE_CODE) {
                nearbyMines++;
            }

            // Guardamos la pista en la casilla
            map[i] = nearbyMines;
        }

        // ---------------------------------------------------------
        // FASE 3: BUCLE DE JUEGO
        // ---------------------------------------------------------
        
        System.out.println("Minesweeper 1D Game Started!");
        System.out.println("Find the empty spots. Be careful with the 6 mines!");

        while (isGameActive) {
            
            // Mostramos el tablero al usuario
            System.out.println("\nStatus:");
            // k: contador auxiliar solo para imprimir
            for (int k = 0; k < map.length; k++) {
                if (isRevealed[k]) {
                    // Si está revelado, mostramos lo que hay en el mapa lógico
                    // Si es mina (caso perder) mostramos *, si no el número
                     if (map[k] == MINE_CODE) {
                         System.out.print("* ");
                     } else {
                         System.out.print(map[k] + " ");
                     }
                } else {
                    // Si no está revelado, mostramos un símbolo de incógnita
                    System.out.print("? ");
                }
            }
            System.out.println(""); // Salto de línea estético
            System.out.println("------------------------------------------------");

            System.out.println("Select a position to reveal (0 - " + (MAP_SIZE - 1) + "): ");
            userPos = sc.nextInt();

            // Verificamos rango válido
            if (userPos >= 0 && userPos < MAP_SIZE) {
                
                if (map[userPos] == MINE_CODE) {
                    System.out.println("\nBOOOM!!! You stepped on a mine at position " + userPos);
                    isRevealed[userPos] = true; // Revelamos la mina para que la vea
                    isGameActive = false;       // Fin del juego
                } else {
                    System.out.println("Safe! Checking surroundings...");
                    // Marcamos como revelada para que se dibuje en la siguiente vuelta
                    isRevealed[userPos] = true;
                }
                
            } else {
                System.out.println("Invalid position!");
            }
        }

        System.out.println("Game Over.");
        sc.close();
    }
}