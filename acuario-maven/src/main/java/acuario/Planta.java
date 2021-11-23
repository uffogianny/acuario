package acuario;

import common.ConnDB;

/**
 *
 * @author Developer
 */
public class Planta extends Especie{

    private final ConnDB bbdd=ConnDB.getInstance();
    private String medioDeVida;
    private Sala sala=null;

    public Planta(String medioDeVida, String codigo, String nombre, String codigo_estanque, String codigo_sala) {
        super(codigo, nombre);
        this.medioDeVida=medioDeVida;
        if (!codigo_sala.equals("")){
            setSala(bbdd.getSalaByCodigo(codigo_sala));
        }
        if (!codigo_estanque.equals("")){
            setEstanque(bbdd.getEstanqueByCodigo(codigo_estanque));
        }
    }

    /**
     * @return String Devuélve el medio de vida
     */
    public String getMedioDeVida() {
        return medioDeVida;
    }

    /**
     * @param medioDeVida Se le asigna un medio de vida a la planta
     */
    public void setMedioDeVida(String medioDeVida) {
        this.medioDeVida = medioDeVida;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

}