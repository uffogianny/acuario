package acuario;

import java.util.ArrayList;

/**
 * Clase para crear un objeto tipo Sala
 * @author Angel, Jose, Miguel, Paulo
 */
public class Sala {

    // Maximo de estanques por sala
    public final int maxEstanques = 2;

    // Código de la sala
    private String codigo;

    // Nombre de la sala
    private String nombre;

    // Tipo de la sala
    private String tipo;

    // Estanque que tiene la sala
    private ArrayList<Estanque> estanques = new ArrayList();
    private Planta planta=null;

    /**
     * Constructor por defecto
     * @param codigo Identificador único de cada sala
     * @param nombre Nombre de cada sala
     * @param tipo En que está especializada la sala
     */
    public Sala(String codigo, String nombre, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    /**
     * @return String Devuélve el tipo de la sala
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo Se le asigna un tipo a la sala
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return String Devuélve el código de la sala
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo Se le asigna un código a la sala
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return String Devuélve el nombre de la sala
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Se le asigna un nombre a la sala
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return ArrayList Devuélve un arraylist con los estanques de la sala
     */
    public ArrayList<Estanque> getEstanques() {
        return estanques;
    }

    /**
     * @param estanque Se le añade un estanque a la sala
     */
    public void agregarEstanques(Estanque estanque) {
        this.estanques.add(estanque);
    }

    public Planta getPlanta() {
        return planta;
    }

    public void agregarPlanta(Planta planta) {
        this.planta = planta;
    }


}