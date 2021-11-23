package eventos;
public class Pez {
    private int id;
    private String especie;
    private boolean tipoDeAgua;
    private int codigoDePiscina;

    /** 
     * Constructor de Pecera.
     * @param id Identificador de la pecera (int).
     * @param especie Especie del pez (String).
     * @param tipoDeAgua Tipo de agua de la piscina (True = Dulce, False = Salada) (boolean).
     * @param codigoDePiscina Código de la piscina contenedora (int).
     */
    public Pez(int id, String especie, boolean tipoDeAgua, int codigoDePiscina) {
        this.id = id;
        this.especie = especie;
        this.tipoDeAgua = tipoDeAgua;
        this.codigoDePiscina = codigoDePiscina;
    }

    // Muestra la pecera contenedora
    public void mostrarPecera() {
        System.out.println("# Pecera del pez con codigo " + this.id);
        System.out.println(" - " + codigoDePiscina);
    }

    public void mostrarDatos() {
        System.out.println("# Datos del pez con codigo " + this.id);
        System.out.println(" - Especie: " + this.especie);
        if (this.tipoDeAgua) // El booleano controla el tipo de agua
            System.out.println(" - Tipo de agua: dulce");
        else
            System.out.println(" - Tipo de agua: salada");
        System.out.println(" - Código de la piscina contenedora: " + codigoDePiscina);
    }
}
