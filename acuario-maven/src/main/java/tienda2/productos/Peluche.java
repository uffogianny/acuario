package tienda2.productos;

import tienda2.Producto;

public class Peluche extends Producto {

    //Attribute
    private String tipo;

    //Constructor
    public Peluche() {}
    public Peluche(String nombre, double precioUnit, int cantStock, boolean disponible, String tipo){
        super(nombre, precioUnit, cantStock, disponible);
        this.tipo=tipo;
    }

    //Methods
    @Override
    public String toString(){
        return "PELUCHE "+
                super.toString()+
                "Tipo: "+this.tipo;
    }

    //Gets & Sets
    public String getTipo(){ return this.tipo; }
    public void setTipo(String tipo){ this.tipo=tipo; }
}
