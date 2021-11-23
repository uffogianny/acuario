package tienda;

import java.util.Date;

public class Trabajador extends Persona {

    private Double salario;

    public Trabajador(String codigo, String nombre, String direcccion, String telefono, Double salario) {
        super(codigo, nombre, direcccion, telefono);
        this.salario = salario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    /**
     * este metodo no tiene parametros de entrada
     * @return deveulve un objeto de tipo pedido con la fecha del sistema
     */
    public Pedido generarPedido() {
        java.util.Date fecha = new Date();
        Pedido p = new Pedido("pedido1", fecha.toString(), false);
        System.out.println("****************************************\n");
        System.out.println("Se genera un pedido con los siguientes datos: ");
        System.out.println("Numero: " + p.getCodigo() + " Fecha: " + p.getFecha());
        return p;
    }

    /**
     * @param cliente objeto cliente
     * @param importeTotal total de la compra
     * @return deveulve un objeto de tipo factura
     */
    public Factura generarFactura(Cliente cliente, double importeTotal) {
        System.out.println("Se genera una factura con los siguientes datos: ");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Importe total = " + importeTotal);
        return new Factura(cliente.getCodigo(), importeTotal, true);
    }

}
