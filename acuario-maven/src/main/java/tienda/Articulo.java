package tienda;

/**
 * Modela un artículo de la tienda
 * @author Emilio
 */
public abstract class Articulo {

    private String codigo;
    private String descripcion;
    private int stock;
    private double precio;

    /**
     * Constructor
     *
     * @param codigo      Codigo que identifica al artículo en la BBDD
     * @param descripcion Descripción comprensible del artículo
     * @param stock       Cantidad disponible en stock
     * @param precio      Precio unitario del artículo
     */
    public Articulo(String codigo, String descripcion, int stock, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }

    /**
     * @return Codigo del artículo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo Codigo del articulo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return Descripcion del artículo
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion Descripción del artículo
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return Stock actual
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock Nuevo stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return Precio del artículo
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio Nuevo precio del artículo
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

}