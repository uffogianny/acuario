package eventos;

import java.util.Calendar;
import java.util.Date;

public class Evento {
    private String nombre;
    private Date fecha;
    private float precio;
    private float duracion;
    private int requisitoEdad;
    private int contadorEntradas;
    private int aforo;

    /** 
     * Constructor de Evento.
     * @param nombre nombre del evento (String).
     * @param fecha fecha en la que se producirá el evento (Date).
     * @param precio precio del evento (float).
     * @param duracion duración del evento en minutos (float).
     * @param requisitoEdad requisito de edad para participar en el evento (int).
     * @param contadorEntradas contador de entradas disponibles para el evento.
     * @param aforo aforo máximo (int).
     */
    public Evento(String nombre, Date fecha, float precio, float duracion, int requisitoEdad, int contadorEntradas, int aforo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.precio = precio;
        this.duracion = duracion;
        this.requisitoEdad = requisitoEdad;
        this.contadorEntradas = contadorEntradas;
        this.aforo = aforo;
    }

    /*
     * Constructor vacío
     */
    public Evento(){}

    /** 
     * Muestra los datos del evento.
     */
    public void mostrarDatos() {
        System.out.println("## Datos del evento");
        System.out.println(" - Nombre: " +  nombre);
        System.out.println(" - Fecha: " + fecha);
        System.out.println(" - Precio: " + precio);
        System.out.println(" - Requisito de edad: " + requisitoEdad);
        System.out.println(" - Contador de entradas: " + contadorEntradas);
        System.out.println(" - Aforo: " + aforo);
        System.out.println(" - Duracion: " + duracion);
    }
    
    /** 
     * Muestra el requisito de edad del evento.
     */
    public void mostrarRequisito(){
        System.out.println(" - Requisito de edad: " + requisitoEdad);
    }

    /** 
     * Comprueba el aforo del evento.
     */
    public void comprobarAforo(){
        if (contadorEntradas<aforo)
            System.out.println(" - Pueden pasar :" + (aforo-contadorEntradas) + "personas");
        else
            System.out.println(" - No se admiten mas personas");

    }

     /** 
     * Comprueba el funcionamiento de las clases.
     */
    public void test() {
        // Creación de unos objetos pez.
        Pez pez1 = new Pez(0, "Pez Gato", false, 0);
        Pez pez2 = new Pez(1, "Pez Peixe", true, 0);
        Pez pez3 = new Pez(2, "Pez Vaca", false, 0);

        // Los objetos creados se almacenan en un array.
        Pez[] arraypeces = {pez1, pez2, pez3};

        for (Pez pez : arraypeces){
            pez.mostrarDatos();
            pez.mostrarPecera();
        }

        // El array se pasa como parámetro para crear la piscina.
        Pecera pecera1 = new Pecera(0, true, "Una pecera bonita", 20, 500, arraypeces);

        // Muestra las caracteristicas de la pecera.
        pecera1.mostrarCaracteristicas();

        // La piscina contiene una función que muestra los datos de todos los peces dentro del array.
        pecera1.listarPeces();

        Evento evento1 = new Evento("Evento navideño", new Date(2021, Calendar.DECEMBER, 25), 5, 4, 12, 0, 75);
        Evento evento2 = new Evento("Evento secundario", new Date(2021, Calendar.DECEMBER, 26), 3, 4, 12, 0, 30);

        evento1.mostrarDatos();
        evento2.mostrarDatos();
    }

}
