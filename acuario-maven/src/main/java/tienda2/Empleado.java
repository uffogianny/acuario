package tienda2;

public class Empleado {
    private String nombreApellidos, dni, tipoTrabajo;
    private int vacaciones, id, sueldo, horasTrabajo, valoracion; // valoracion al final lo pongo en int porque va a ser una nota del 1 al 10

    Empleado(){}
    public Empleado(int id,String nombreApellidos, String dni, String tipoTrabajo, int horasTrabajo, int sueldo, int vacaciones, int valoracion){
        this.id=id;
        this.nombreApellidos=nombreApellidos;
        this.dni=dni;
        this.tipoTrabajo=tipoTrabajo;
        this.horasTrabajo=horasTrabajo;
        this.sueldo=sueldo;
        this.vacaciones=vacaciones;
        this.valoracion =valoracion;
    }

    public int getId() {
        return id;
    }
    public String getNombreApellidos() {
        return nombreApellidos;
    }
    public String getDni() {return dni;}
    public String getTipoTrabajo() {return tipoTrabajo;}
    public int getVacaciones() {return vacaciones;}
    public int getSueldo() {return sueldo;}
    public int getHorasTrabajo() {return horasTrabajo;}
    public int getValoracion() {return valoracion;}
}