package tienda;

import common.ConnDB;
import java.util.Date;

public class Tienda {

    // Conector JDBC y patrón Singleton
    private static ConnDB bbdd=ConnDB.getInstance();
    private static Tienda instanciaUnica=null;

    private Tienda(){
    }

    public static Tienda getInstance(){
        if (instanciaUnica==null){
            instanciaUnica=new Tienda();
        }
        return instanciaUnica;
    }

    // Este método muestra todos los datos almacenados en la BBDD
    public void mostrarTodo(){
        System.out.println("\n\n--- INVENTARIO DE LA TIENDA ---");
        System.out.println("\nDATOS DE ARTÍCULOS");
        bbdd.cargaDatos("SELECT * FROM articulos");
        bbdd.mostrarDatosArticulos();
        System.out.println("******************\n");
        System.out.println("\nDATOS DE CLIENTES");
        bbdd.cargaDatos("SELECT * FROM clientes");
        bbdd.mostrarDatosClientes();
        System.out.println("******************\n");
        System.out.println("\nDATOS DE TRABAJADORES");
        bbdd.cargaDatos("SELECT * FROM trabajadores");
        bbdd.mostrarDatosTrabajadores();
        System.out.println("******************\n");
    }

    /* Este método muestra el funcionamiento de la tienda
     * Se tomará aleatoriamente de la BBDD un cliente, un trabajador y tres artículos
     * Se realizará la venta, se generará un pedido para los artículos sin stock
     * y se imprimirá una factura (que será volcada a un fichero de texto)
     */
    public void test(){
        System.out.println("\n\n\n************************************************\n\t\t TEST TIENDA");

        System.out.println("Llega un cliente, un trabajador le atiende y pone 3 artículos en su carrito de compra");
        Cliente c = bbdd.getClienteRandom();
        Trabajador t=bbdd.getTrabajadorRandom();

        // Creamos un objeto de tipo pedido y otro de tipo factura
        Pedido p = null;
        Factura f;

        // Creamos un carrito de la compra
        int codCarrito=(int) Math.random();
        Carrito carrito=new Carrito(codCarrito);
        for (int i = 0; i < 3; i++) {
            int cantidad = (int) ((Math.random() * 10) + 1);
            Articulo a=bbdd.getArticuloRandom();
            // Comprobemos que hay suficiente stck
            if (a.getStock() == 0) {
                // Si no hay stock, comprobamos si ya hay un pedido creado. Si no lo hay, lo creamos
                if (p == null) {
                    p = t.generarPedido();
                }
                // Llamamos al método añadirLinea pasándole como parámetros el artículo y la cantidad
                p.añadirLinea(a, cantidad);
            } else {
                carrito.anadirArticulo(a);
            }

        }
        System.out.println("************************************************\n");
        System.out.println("Para proceder a la venta, obtenemos el precio de cada articulo del carrito y pagamos");
        // Recorremos el carrito con un foreach y acumulamos el precio de cada articulo
        double importeTotal = 0;
        for (Articulo a : carrito.getCarrito()) {
            importeTotal += a.getPrecio();
        }

        // Llamamos al metodo pagarCompra() del objeto cliente
        c.pagarCompra(importeTotal);
        System.out.println("************************************************\n");

        System.out.println("Suponemos que el cliente quiere una factura");
        /* Llamamos al metodo generarFactura de nuestro objeto trabajador
         * Recorremos el carrito creando una lineaFactura con los datos de cada articulo
         * y lo añadimos a nuestra factura
         */
        f = t.generarFactura(c, importeTotal);
        System.out.println("Fecha de la factura: " + f.getFecha());
        LineaFactura lf;
        for (Articulo a : carrito.getCarrito()) {
            System.out.println(a.getDescripcion() + " - " + a.getPrecio());
            lf = new LineaFactura(1, a.getDescripcion(), a.getPrecio());
            f.añadirLinea(lf);
        }

        System.out.println("IMPRIMIMOS FACTURA EN FICHERO");
        f.imprimir();
    }

}
