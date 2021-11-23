package tienda2.productos;

import tienda2.Producto;

public class Comida extends Producto {

    //Attribute
    private boolean esDulce=false;

    //Constructor
    public Comida() {}
    public Comida(String nombre, double precioUnit, int cantStock, boolean disponible, boolean esDulce){
        super(nombre, precioUnit, cantStock, disponible);
        this.esDulce=esDulce;
    }

    //Methods
    @Override
    public String toString(){
        String aux;
        if(this.esDulce){
            aux="Si";
        } else {
            aux="no";
        }
        return "COMIDA: "+
                super.toString()+
                "Dulce: " +aux;
    }

    //Gets & Sets
    public boolean getDulce(){ return this.esDulce; }
    public void setDulce(boolean dulce){ this.esDulce = dulce; }
}
