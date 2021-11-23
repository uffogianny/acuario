package acuario;

import common.ConnDB;

/**
 * Clase para crear un objeto tipo Tiburón
 * @author Angel, Jose, Miguel, Paulo
 */
public class Tiburon extends Especie{

    private final ConnDB bbdd=ConnDB.getInstance();
    private String tamano;

    /**
     * Constructor
     * @param codigo            Codigo identificativo del objeto Tiburón
     * @param nombre            Nombre descriptivo del objeto Tiburón
     * @param tamano            Un String que describe el tamaño del objeto Tiburón
     * @param codigo_estanque   Código del objeto Estanque asociado al objeto Tiburón
     */
    public Tiburon(String codigo, String nombre, String tamano, String codigo_estanque){
        super(codigo, nombre);
        setEstanque(bbdd.getEstanqueByCodigo(codigo_estanque));
        this.tamano=tamano;
    }

    /**
     * @return String Devuélve el tamaño del tiburón
     */
    public String getTamano() {
        return tamano;
    }

    /**
     * @param tamano Se le asigna un tamaño al tiburón
     */
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

}