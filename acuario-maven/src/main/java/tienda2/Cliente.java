package tienda2;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Cliente {

    private String nombre,apellidos,dni,correoElectronico,nombreResponsable,horaEntrada,horaSalida;
    private int edad,valoracion,numVisitante;
    //final int LONGNOMBRE = 30;
    //final int LONGAPELLIDOS = 50;
    //final int LONGDNI = 9;
    //final int LONGCORREO=40;
    //final int LONGNOMBRERESPONSABLE=30;
    //final int LONGHORAENTRADA=5;
    //final int LONGHORASALIDA=5;



    Cliente(){}
    public Cliente(int numVisitante, String nombre, String apellidos, String dni, String correoElectronico, String nombreResponsable, int edad, String horaEntrada, String horaSalida, int valoracion){
        this.numVisitante=numVisitante;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.dni=dni;
        this.correoElectronico=correoElectronico;
        this.nombreResponsable=nombreResponsable;
        this.edad=edad;
        this.horaEntrada=horaEntrada;
        this.horaSalida=horaSalida;
        this.valoracion=valoracion;


    }
    public int getNumVisitante(){
        return this.numVisitante;
    }
    public String getnombre() {
        return this.nombre;
    }
    public String getapellidos(){
        return this.apellidos;
    }
    public String getdni(){
        return this.dni;
    }
    public String getcorreoElectronico(){
        return this.correoElectronico;
    }
    public String getnombreResponsable(){
        return this.nombreResponsable;
    }
    public int getedad(){
        return this.edad;
    }
    public String gethoraEntrada(){
        return this.horaEntrada;
    }
    public String gethoraSalida(){
        return this.horaSalida;
    }

    public int getvaloracion(){
        return this.valoracion;
    }

    void setnumVisitante(int numVisitante){
        this.numVisitante=numVisitante;
    }
    void setnombre(String nombre) {
        this.nombre = nombre;
    }
    void setapellidos(String apellidos){
        this.apellidos = apellidos;
    }
    void setdni(String dni){
        this.dni= dni;
    }
    void setcorreoElectronico(String correoElectronico){
        this.correoElectronico= correoElectronico;
    }
    void setnombreResponsable(String nombreResponsable){
        this.nombreResponsable=nombreResponsable;
    }
    void setedad(int edad){
        this.edad=edad;
    }
    void sethoraEntrada(String horaEntrada){
        this.horaEntrada=horaEntrada;
    }
    void setHoraSalida(String horaSalida){
        this.horaSalida=horaSalida;
    }

    void setvaloracion(int valoracion){
        this.valoracion=valoracion;
    }



/*
    public int tamano(){

        return(4+2+30+2+50+2+9+2+40+2+30+4+2+5+2+5+4);
    }

    public boolean leerDeArchivo(RandomAccessFile f){
        boolean finArchivo = false;
        try{
            numVisitante=f.readInt();
            nombre=f.readUTF();
            apellidos=f.readUTF();
            dni=f.readUTF();
            correoElectronico=f.readUTF();
            nombreResponsable=f.readUTF();
            edad=f.readInt();
            horaEntrada=f.readUTF();
            horaSalida=f.readUTF();

            valoracion=f.readInt();


        }catch(EOFException eofe){
            finArchivo=true;
        }catch(IOException ioe){
            System.out.println("Error: "+ioe);
        }
        return (finArchivo);
    }
 */
    public void mostrarDatosEntrada(){
        System.out.println("El visitante numero "+numVisitante+" llamado "+nombre.trim()+" "+apellidos.trim()+" entró al acuario a las "+horaEntrada.trim()+" horas.");
    }
    public void mostrarDatosSalida(){
        System.out.println("El visitante numero "+numVisitante+" llamado "+nombre.trim()+" "+apellidos.trim()+" salió del acuario a las "+horaSalida.trim()+" horas.");
    }
    public void mostrarDatos(){
        System.out.println("Número de visitante: "+numVisitante+", Nombre: "+nombre.trim()+", Apellidos: "+apellidos.trim()+", DNI: "+dni.trim()+", Correo electrónico: "+correoElectronico.trim()+", Nombre de la persona responsable: "+nombreResponsable.trim()+", Edad:"+edad+", Hora de entrada al recinto: "+horaEntrada.trim()+", Hora de salida del recinto: "+horaSalida.trim()+", Valoracion: "+valoracion);
    }
    public void mostrarDatosValoracion(){
        System.out.println("El visitante numero "+numVisitante+" llamado "+nombre.trim()+" "+apellidos.trim()+" le dio una valoracion al acuario de " + valoracion + " sobre 5.");
    }
}
