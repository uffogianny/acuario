package taquilla;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro {

    static final String ruta ="data\\ventas\\";

    //Atributos
    private String tamano;
    private String tipo;
    private String pago;
    private String fecha;

    //setters
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

    //Escribe en el archivo
    public void Escribir() {
        try {
            BufferedWriter in = new BufferedWriter(new FileWriter(ruta + "ventas.txt", true));
            in.write(this.fecha);
            in.newLine();
            in.write(this.pago);
            in.newLine();
            in.write(this.tamano);
            in.newLine();
            in.write(this.tipo);
            in.newLine();
            in.close();
        } catch (IOException ioe) {
        }
    }

    //Lee del archivo
    static void read(boolean op,boolean benef, String strFecha) {
        //op - Si dia especifico o total.
        //benef - Si enseña los beneficios o no.


        String fecha;
        String precio;
        String tamano;
        String tipo;
        String fechaAux="";
        int contador=0;
        double preciotot=0;

        try{

            BufferedReader sal = new BufferedReader(new FileReader(ruta+"Ventas.txt"));

            System.out.println("Fecha      Precio  Tamaño Tipo");
            fecha=sal.readLine();
            while(fecha!=null){
                precio=sal.readLine();
                tamano=sal.readLine();
                tipo=sal.readLine();

                if(op){
                    System.out.println(fecha+" | "+precio+" | "+tamano+" | "+tipo);
                    preciotot+=Double.parseDouble(precio);

                    if(!fecha.equalsIgnoreCase(fechaAux)){
                        contador+=1;

                    }
                }else if(op==false&&fecha.equalsIgnoreCase(strFecha)){ //Si la fecha de la entrada coincide con la actual
                    System.out.println(fecha+" | "+precio+" | "+tamano+" | "+tipo);
                    preciotot+=Double.parseDouble(precio);;
                }

                fechaAux=fecha;
                fecha=sal.readLine();
            }
            System.out.println("Numero de dias = " + contador + " Ganado = " + preciotot);
        }catch(IOException ioe){}

        if(benef==true){ //Enseña los beneficios
            beneficios(preciotot,contador);
        }
    }

    //Pregunta la fecha y va a read()
    static void fechaEsp(boolean benef) throws IOException {
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

        String strFecha = "" + ano + "-" + mes + "-" + dia;

        Registro.read(false,benef,strFecha);
    }


    //Coge la fecha actual y se la manda a read
    static void fechaAct(boolean benef){
        Date fechaAct = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  //la convertimos a ese formato
        String strFecha = dateFormat.format(fechaAct); //La pasamos a str

        read(false,benef, strFecha);
    }

    //Calcula una estimacion de los beneficios
    static void beneficios(double precio,int contador){
        double mant = 200;
        double coste = mant*contador;
        System.out.println(coste + " - " + precio);

        double benef = coste - precio;

        System.out.println("Beneficios= " + benef);
    }

    }
