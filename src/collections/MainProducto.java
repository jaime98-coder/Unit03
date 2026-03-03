package collections;

import java.util.ArrayList;

public class MainProducto {

	public static void main(String[] args) {
		ArrayList<Producto> cesta = new ArrayList<>();
//		Producto pan = new Producto("Pan", 1.20);
//		cesta.add(pan);
		double total = 0;
		cesta.add(new Producto("Pan", 1.20));
		cesta.add(new Producto("Leche", 0.80));
		cesta.add(new Producto("Huevos", 2.50));
		
		for (Producto productoEnCesta: cesta) {
			System.out.println(productoEnCesta.getNombre());
			total += productoEnCesta.getPrecio();
		}
		System.out.println("Total: "+total+"€");
	}

}
