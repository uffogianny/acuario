package taquilla;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro {
    //Atributos
    private String tamano;
    private String tipo;
    private String pago;
    private String fecha;

    //Setters
    public void setTamano(String tamano){
        this.tamano = tamano;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setPago(String pago){
        this.pago = pago;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    //Pregunta y devuelve la fecha
    static String fechaEsp(boolean benef) throws IOException {
        int dia=0; int mes=0; int ano=0;
        System.out.println("Año:");
        do{ //Si algo no es un nº o < 0 lo vuelve a preguntar
            ano = 2000 + (int) Math.round(Math.random()*20+1);
            System.out.println(ano);
            if(ano<0){System.out.println("Año invalido");}
        }while(ano < 0);
        System.out.println("Mes:");
        do{ //Comprueba que el nº sea posible
            mes= (int) Math.round(Math.random()*11+1);
            System.out.println(mes);
            if(mes<1 || mes>12){
                System.out.println("Ese mes no existe");
            }
        }while(mes<1 || mes>12);
        System.out.println("Dia:");
        do{ //Comprueba que el nº sea posible
            dia = (int) Math.round(Math.random()*30+1);
            System.out.println(dia);
            if(dia<1 || dia>31){
                System.out.println("Ese dia no existe");
            }
        }while(dia<1 || dia>31);
        return ("" + ano + "-" + mes + "-" + dia);
    }

    //Coge la fecha actual
    static String fechaAct(boolean benef){
        Date fechaAct = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  //la convertimos a ese formato
        return dateFormat.format(fechaAct); //La pasamos a str
    }

    //Calcula una estimacion de los beneficios
    static void beneficios(double precio,int contador){
        double mant = 200;
        double coste = mant*contador;
        System.out.println(coste + " - " + precio);
        double benef = coste - precio;
        System.out.println("Beneficios= " + benef);
    }

    //Método escribir()
    //TODO: conectar con la BBDDD
    public void escribir(){

    }

    public static void leer(boolean v1, boolean v2, String fecha){

    }

}
