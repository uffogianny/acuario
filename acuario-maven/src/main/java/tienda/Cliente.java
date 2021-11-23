package tienda;

import java.util.Scanner;

/**
 * Modela un Cliente (Persona)
 * @author yuda
 */
public class Cliente extends Persona {

    public Cliente(String codigo, String nombre, String direcccion, String telefono) {
        super(codigo, nombre, direcccion, telefono);
    }

    /**
     * @param input Objeto de la clase Scanner para leer por teclado
     * @return retornarán un valor booleano según la respuesta a la pregunta
     * para este MPV estos metodos no se utilizarán
     */
    public boolean solicitarFactura(Scanner input) {
        System.out.println("¿Desea solicitar Factura? (s/n) ");
        return input.nextLine().equalsIgnoreCase("s");
    }

    public boolean solicitarPedido(Scanner input) {
        System.out.println("¿Desea solicitar Pedido? (s/n)");
        return input.nextLine().equalsIgnoreCase("si");
    }

    /**
     * En este metodo podemos controlar el cobro y calcular el cambio a devolver
     * para este MPV no lo implementaremos
     * @param importe El importe total de la compra
     */
    public void pagarCompra(Double importe) {
        System.out.println("El total a pagar es " + importe + " euros");
    }

}