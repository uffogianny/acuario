package tienda;

import java.util.ArrayList;

/**
 * Modela un carrito o cesta de la compra mediante un ArrayList
 * @author yuda
 */
public class Carrito {
    private  ArrayList<Articulo> carrito;
    private int codigo;

    /**
     * Constructor que inicializa el ArrayList vacío
     * @param codigo El código identificativo del carrito
     */
    public Carrito(int codigo) {
        this.carrito = new ArrayList<>();
        this.codigo = codigo;
    }

    /**
     * @return Un ArrayList de objetos de la clase Articulo
     */
    public ArrayList<Articulo> getCarrito() {
        return carrito;
    }

    /**
     * @param carrito Un ArrayList de objetos de la clase Artículo
     */
    public void setCarrito(ArrayList<Articulo> carrito) {
        this.carrito = carrito;
    }

    /**
     *
     * @return El código identificador de un carrito
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo El código identificador de un carrito
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param articulo Un objeto de la clase Articulo que se debe poner en el carrito
     */
    public void anadirArticulo(Articulo articulo){
        carrito.add(articulo);
    }

    /**
     *
     * @param articulo Un objeto de la clase Articulo que debe quitarse del carrito
     */
    public void quitarArticulo(Articulo articulo){
        carrito.remove(articulo);
    }

}