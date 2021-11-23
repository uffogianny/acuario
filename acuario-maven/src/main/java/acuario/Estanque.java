package acuario;

import common.ConnDB;
import java.util.ArrayList;

/**
 * Clase para crear un objeto tipo Estanque
 * @author Angel, Jose, Miguel, Paulo
 */
public class Estanque {

    // Maximo de tiburones por estanque

    /**
     *
     */
    public final int maxTiburones = 6;

    // Código de estanque
    private String codigo;

    // Nombre de estanque
    private String nombre;

    // Tipo de estanque
    private String tipo;

    // Sala a la que pertenece
    private Sala sala;

    // Tiburones que tiene cada estanque
    private ArrayList<Tiburon> tiburones=new ArrayList();

    private ArrayList<Planta> plantas=new ArrayList();

    /**
     * Constructor por defecto
     * @param codigo Identificador único de cada estanque
     * @param nombre Nombre de cada estanque
     * @param tipo En que está especializada el estanque
     * @param sala Sala a la que petenece
     */

    private final ConnDB bbdd=ConnDB.getInstance();

    public Estanque(String codigo, String tipo, String nombre, String codigo_sala) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.sala = bbdd.getSalaByCodigo(codigo_sala);
    }

    /**
     * @return String Devuelve el tipo de estanque
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo Tipo de estanque
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return String Devuélve el código del estanque
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo Codigo del estanque
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return String Devuelve el nombre del estanque
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nombre del estanque
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param sala Sala a la que pertence el estanque
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * @return Sala Sala a la que pertenece el estanque
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * @return ArrayList Devuélve un arraylist con los tiburones del estanque
     */
    public ArrayList<Tiburon> getTiburones() {
        return tiburones;
    }

    /**
     * @param tiburon Se le añade un tiburon al estanque
     */
    public void agregarTiburones(Tiburon tiburon) {
        this.tiburones.add(tiburon);
    }


    /**
     * @return ArrayList Devuélve un arraylist con las plantas del estanque
     */
    public ArrayList<Planta> getPlantas() {
        return plantas;
    }

    /**
     * @param planta Se le añade una planta al estanque
     */
    public void agregarPlanta(Planta planta) {
        this.plantas.add(planta);
    }

}