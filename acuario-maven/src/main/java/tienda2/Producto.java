package tienda2;

/* Author: Javier Miralles Rancaño */


public abstract class Producto {

    /* Atributes */
    private String nombre;
    private double precioUnit;
    private int cantStock;
    private boolean disponible=false;
    public static int dimensionArray;

    public Producto(){}

    public Producto(String nombre, double precioUnit, int cantStock, boolean disponible) {
        this.nombre=nombre;
        this.precioUnit=precioUnit;
        this.cantStock=cantStock;
        this.disponible=disponible;
        // Se obtiene la dimensión del array. Según el número de instancias del constructor.
        ++dimensionArray;
    }

    /* Methods */
    @Override
    public String toString(){
        return "Nombre: "+this.getNombre()+"\n"+
                "Precio Unidad: "+this.getPrecioUnit()+"\n"+
                "En stock: "+this.getCantStock()+"\n";
    }

    /* Get & Set */
    public String getNombre(){ return this.nombre; }
    public void setNombre(String nombre) { this.nombre=nombre; }

    public double getPrecioUnit(){ return this.precioUnit; }
    public void setPrecioUnit(double precio){ this.precioUnit=precio; }

    public int getCantStock(){ return this.cantStock; }
    public void setCantStock(int stock){ this.cantStock=stock; }

    public boolean isDisponible(){ return this.disponible; }
    public void setDisponible(boolean disponible){ this.disponible=disponible; }

}
