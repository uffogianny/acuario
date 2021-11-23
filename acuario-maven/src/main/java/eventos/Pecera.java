package eventos;

public class Pecera {
    private int id;
    private boolean tipoDeAgua;
    private String descripcion;
    private float temperatura;
    private float tamano;
    private Pez peces[];

    /** 
     * Constructor de Pecera.
     * @param id Identificador de la pecera (int).
     * @param tipoDeAgua Tipo de agua utilizada por la pecera (True = Dulce, False = Salada) (boolean).
     * @param descripcion Descripción de la pecera (String).
     * @param temperatura Temperatura de la pecera (float).
     * @param tamano Tamaño de la pecera (float).
     * @param peces Lista de peces que contiene la pecera (Pez[]).
     */
    public Pecera(int id, boolean tipoDeAgua, String descripcion, float temperatura, float tamano, Pez[] peces){
        this.id = id;
        this.tipoDeAgua = tipoDeAgua;
        this.descripcion = descripcion;
        this.temperatura = temperatura;
        this.tamano = tamano;
        this.peces = peces;
    }

    /** 
     * Lista todos los datos de todos los peces en la pecera.
     */
    public void listarPeces(){
        System.out.println("## Datos de todos los peces de la piscina " + this.id);
        for(Pez pez : peces){
            pez.mostrarDatos();
        }
    }

    /** 
     * Muestra las características de la pecera.
     */
    public void mostrarCaracteristicas(){
        System.out.println("## Datos de la piscina " + this.id);
        if (this.tipoDeAgua)
            System.out.println(" - Tipo de agua: dulce");
        else
            System.out.println(" - Tipo de agua: salada");
        System.out.println(" - Descripcion: " + this.descripcion);
        System.out.println(" - Temperatura: " + this.temperatura);
        System.out.println(" - Tamaño: " + this.tamano);
    }

}