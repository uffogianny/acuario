package tienda2;

/* Author: Javier Miralles Rancaño */

import tienda2.productos.Comida;
import tienda2.productos.Peluche;

public class Tienda2 {

    /* Attributes */
    private Producto productos[] = null;
    private double caja;

    /* Constructor */
    public Tienda2() {
    }

    public Tienda2(Producto[] productos) {
        this.productos = productos;
    }

    /* Methods */
    public Producto[] cargarProductos() {
        return productos;
    }

    public void mostrarProductos(Producto[] productos) {
        for (Producto producto : productos) {
            System.out.print(producto + "\n-----\n");
        }
    }

    public void mostrarNombreProductos(Producto[] productos) {
        for (int i = 0; i < productos.length; i++) {
            System.out.println(i + 1 + " " + productos[i].getNombre() + "\n");
        }
        System.out.println("\n-------\n");
    }

    public double venderProducto(Producto[] productos, int num, int cantidadUnidades) {
        if (productos[num - 1].isDisponible()) {
            if (productos[num - 1].getCantStock() >= cantidadUnidades) {
                System.out.println("La compra se ha realizado con éxito.\n");
                productos[num - 1].setCantStock(productos[num - 1].getCantStock() - cantidadUnidades);
                return caja += cantidadUnidades * productos[num - 1].getPrecioUnit();
            } else {
                System.out.println("No hay cantidad suficiente de producto.");
            }
        } else {
            System.out.println("No hay cantidad suficiente de producto.");
        }
        return caja;
    }

    public double mostrarCaja() {
        System.out.print("El total de la casa es: ");
        caja = Math.round(caja * 100);
        return caja / 100;
    }


    // TEST TIENDA :
    public void test() {
        //Se instancian y cargan los productos
        Producto peluche1 = new Peluche("Pez Globo", 16.43, 10, true, "relleno");
        Producto peluche2 = new Peluche("Tiburón", 9.99, 12, true, "rígido");
        Producto chocolateBlanco = new Comida("Chocolate Edición Acuario", 4.55, 4, true, true);
        Producto golosinaMedusa = new Comida("Medusa Golosa", 0.45, 200, true, true);

        //Creamos el array "catálogo" para contener los productos. Su dimensión viene del número de veces que se instancia el constructor Producto.
        Producto[] catalogo = new Producto[Producto.dimensionArray];

        //Se crea el objeto gestión para trabajar (mostrar, vender productos, y mostrar caja)
        System.out.println("TEST TIENDA : ");

        // Mostrar stock de la tienda
        System.out.println("\nStock disponible : \n");
        mostrarProductos(catalogo);

        // Vender productos
        System.out.println("\nVenta de productos : \n");
        venderProducto(catalogo, 1, 1);
        System.out.println("\nStock disponible tras la operacion : \n");
        mostrarProductos(catalogo);

        // Mostrar beneficios de caja
        System.out.println("\nBeneficios en caja : \n");
        System.out.println(mostrarCaja() + " €");
    }
}
