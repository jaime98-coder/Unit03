package cleancodeexercises;

import java.util.Scanner;

public class Exercise01 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double IVA = 0.21;
        final double DESCUENTO_MAS_DE_100 = 0.10;
        final double DESCUENTO_SOCIO = 0.05;
        final double LIMITE_DESCUENTO = 100.0;

        final int TAM_STOCK = 200;
        final int STOCK_INICIAL = 10;

        int[] stock = new int[TAM_STOCK];
        for (int i = 0; i < stock.length; i++) stock[i] = STOCK_INICIAL;

        boolean seguirComprando = true;

        while (seguirComprando) {
            int numeroProductos = leerEnteroEnRango(scanner, "¿Cuántos productos vas a introducir?", 1, 50);

            String[] nombresProducto = new String[numeroProductos];
            double[] preciosProducto = new double[numeroProductos];
            int[] unidadesProducto = new int[numeroProductos];

            double subtotal = 0.0;

            for (int i = 0; i < numeroProductos; i++) {
                System.out.println("Nombre del producto " + (i + 1) + ":");
                nombresProducto[i] = scanner.nextLine().trim();

                preciosProducto[i] = leerDoubleMin(scanner, "Precio del producto " + (i + 1) + ":", 0.0);
                unidadesProducto[i] = leerEnteroEnRango(scanner, "Unidades del producto " + (i + 1) + ":", 1, 100);

                subtotal += preciosProducto[i] * unidadesProducto[i];

                int indexStock = obtenerIndexStock(nombresProducto[i], i, TAM_STOCK);
                stock[indexStock] -= unidadesProducto[i];
                if (stock[indexStock] < 0) System.out.println("Aviso: stock negativo (simulación).");
            }

            boolean esSocio = leerSiNo(scanner, "¿Es socio?");

            double[] totales = calcularTotales(subtotal, esSocio, LIMITE_DESCUENTO,
                    DESCUENTO_MAS_DE_100, DESCUENTO_SOCIO, IVA);

            double descuento1 = totales[0];
            double descuento2 = totales[1];
            double baseImponible = totales[2];
            double importeIva = totales[3];
            double total = totales[4];

            imprimirTicket(nombresProducto, preciosProducto, unidadesProducto,
                    subtotal, descuento1, descuento2, baseImponible, importeIva, total);

            seguirComprando = leerSiNo(scanner, "¿Quieres registrar otra compra?");
        }
    }

    private static int leerEnteroEnRango(Scanner scanner, String mensaje, int min, int max) {
        int valor;
        do {
            System.out.println(mensaje);
            valor = scanner.nextInt();
            if (valor < min || valor > max) System.out.println("Valor inválido. Debe estar entre " + min + " y " + max + ".");
        } while (valor < min || valor > max);
        scanner.nextLine();
        return valor;
    }

    private static double leerDoubleMin(Scanner scanner, String mensaje, double min) {
        double valor;
        do {
            System.out.println(mensaje);
            valor = scanner.nextDouble();
            if (valor < min) System.out.println("Valor inválido. Debe ser >= " + min + ".");
        } while (valor < min);
        scanner.nextLine();
        return valor;
    }

    private static boolean leerSiNo(Scanner scanner, String mensaje) {
        String respuesta;
        do {
            System.out.println(mensaje + " (S/N)");
            respuesta = scanner.nextLine().trim();
            if (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")) {
                System.out.println("Respuesta inválida. Escribe S o N.");
            }
        } while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
        return respuesta.equalsIgnoreCase("S");
    }

    private static int obtenerIndexStock(String nombreProducto, int posicion, int tamStock) {
        return (nombreProducto.length() * 17 + posicion * 3) % tamStock;
    }

    private static double[] calcularTotales(double subtotal, boolean esSocio,
                                            double umbral, double descSubtotal, double descSocio, double iva) {
        double descuento1 = subtotal > umbral ? subtotal * descSubtotal : 0.0;
        double subtotalConDescuento = subtotal - descuento1;
        double descuento2 = esSocio ? subtotalConDescuento * descSocio : 0.0;

        double baseImponible = subtotalConDescuento - descuento2;
        double importeIva = baseImponible * iva;
        double total = baseImponible + importeIva;

        return new double[]{descuento1, descuento2, baseImponible, importeIva, total};
    }

    private static void imprimirTicket(String[] nombres, double[] precios, int[] unidades,
                                       double subtotal, double descuento1, double descuento2,
                                       double baseImponible, double iva, double total) {
        System.out.println("=========== TICKET ===========");
        for (int i = 0; i < nombres.length; i++) {
            double linea = precios[i] * unidades[i];
            System.out.println((i + 1) + ") " + nombres[i] + "  " + unidades[i] + " x " + precios[i] + " = " + linea);
        }
        System.out.println("------------------------------");
        System.out.println("SUBTOTAL: " + subtotal);
        System.out.println("DESC > 100: " + descuento1);
        System.out.println("DESC SOCIO: " + descuento2);
        System.out.println("BASE: " + baseImponible);
        System.out.println("IVA: " + iva);
        System.out.println("TOTAL: " + total);
        System.out.println("==============================");
    }
}
