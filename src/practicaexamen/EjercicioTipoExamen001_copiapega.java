package practicaexamen;

import java.util.Scanner;

public class EjercicioTipoExamen001_copiapega {

    public static void main(String[] args) {
        // --- 1. DECLARACIÓN DE VARIABLES (Al principio) ---
        // Arrays para guardar los resultados (GOL o FALLO)
        String[] tablaJugador;
        String[] tablaMaquina;
        
        // Contadores y variables auxiliares
        int i;
        int direccionChute; 
        
        // --- 2. INICIALIZACIÓN ---
        Scanner sc = new Scanner(System.in);
        
        // Inicializamos los arrays antes del bucle
        tablaJugador = new String[5];
        tablaMaquina = new String[5];

        System.out.println("--- TANDA DE PENALTIS ---");

        // --- 3. BUCLE PRINCIPAL (5 LANZAMIENTOS) ---
        // Usamos un for porque sabemos exactamente cuántas veces iterar (5)
        for (i = 0; i < 5; i++) {
            System.out.println("\n--- LANZAMIENTO Nº " + (i + 1) + " ---");
            
            // MENÚ (Debe estar DENTRO del bucle para que salga cada vez)
            System.out.println("Elige la dirección del chute:");
            System.out.println("1. Izquierda");
            System.out.println("2. Centro");
            System.out.println("3. Derecha");
            System.out.print("Opción: ");
            
            // Leemos la opción
            direccionChute = sc.nextInt();
            
            // VALIDACIÓN BÁSICA (Opcional pero recomendada)
            // Si mete un número raro, asignamos centro por defecto o repetimos (aquí simplifico)
            if (direccionChute < 1 || direccionChute > 3) {
                System.out.println("Opción no válida. Chutarás al Centro (2) por defecto.");
                direccionChute = 2;
            }

            // LLAMADA A FUNCIÓN Y ALMACENAMIENTO EN ARRAY
            // Guardamos lo que devuelve la función en la posición 'i' del array
            tablaJugador[i] = partida(direccionChute);
            
            // Mostramos qué pasó en este turno
            System.out.println("Resultado de tu tiro: " + tablaJugador[i]);
        }
        
        // Cierre del Scanner
        sc.close();
    }

    /**
     * Función que calcula si es GOL o PARADA
     * @param direccionJugador El número (1, 2, 3) donde chuta el jugador
     * @return String "GOL" o "PARADA"
     */
    public static String partida(int direccionJugador) {
        // --- Declaración variables locales ---
        int posicionParadaMaquina;
        String resultado;

        // Feedback al usuario (Usamos if-else en lugar de switch para evitar errores de break)
        if (direccionJugador == 1) {
            System.out.println(">> Has chutado a la IZQUIERDA.");
        } else if (direccionJugador == 2) {
            System.out.println(">> Has chutado al CENTRO.");
        } else {
            System.out.println(">> Has chutado a la DERECHA.");
        }

        // Generar movimiento del portero (Máquina)
        // Usamos Math.random() que es estándar y no requiere importar java.util.Random
        // Fórmula: (int)(Math.random() * (Max - Min + 1)) + Min
        posicionParadaMaquina = (int)(Math.random() * 3) + 1;

        System.out.println("(El portero se lanza a la posición " + posicionParadaMaquina + ")");

        // Lógica de comparación
        if (direccionJugador == posicionParadaMaquina) {
            // Si coinciden, el portero lo para
            resultado = "PARADA";
            System.out.println("¡Maldición! La máquina lo ha parado.");
        } else {
            // Si no coinciden, entra
            resultado = "GOL";
            System.out.println("¡GOOOOOOL!");
        }
        
        // Devolvemos el String para guardarlo en el array del main
        return resultado;
    }
}