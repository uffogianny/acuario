package tienda;

public class LineaFactura {

    private int cantidad;
    private String descripcion;
    private double precio;

    public LineaFactura(int cantidad, String descripcion, double precio) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}