package tienda;

import common.ConnDB;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Modela una Factura, que contiene los datos del encabezamiento y una lista
 * de LineaFactura, que reflejan los artículos que en ella figuran, la cantidad
 * vendida y el precio
 *
 * @author Emilio
 */
public class Factura {

    private int numero;
    private String codigoCliente;
    private String fecha;
    private double importeTotal;
    private boolean pagado;
    private final ArrayList<LineaFactura> listaLineasFactura=new ArrayList();

    /**
     * Constructor
     * @param numero        Numero de factura
     * @param codigoCliente Codigo identificativo del Cliente
     * @param fecha         Fecha de emision de la factura
     * @param importeTotal  Importe Total a pagar
     * @param pagado        Un valor lógico que representa si la factura ha sido abonada
     */
    public Factura(int numero, String codigoCliente, String fecha, double importeTotal, boolean pagado) {
        this.numero=numero;
        this.codigoCliente = codigoCliente;
        this.fecha=fecha;
        this.importeTotal = importeTotal;
        this.pagado = pagado;
    }

    /**
     * Constructor
     * @param codigoCliente Codigo identificativo del Cliente
     * @param importeTotal  Importe Total a pagar
     * @param pagado        Un valor lógico que representa si la factura ha sido abonada
     */
    public Factura (String codigoCliente, double importeTotal, boolean pagado){
        this.fecha =  Calendar.getInstance().getTime().toString();
        this.codigoCliente=codigoCliente;
        this.importeTotal=importeTotal;
        this.pagado=pagado;
    }

    /**
     *
     * @return Numero de factura
     */
    public int getNumero() {
        return numero;
    }

    /**
     *
     * @param numero Numero de factura
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @return Código de cliente al que se le emite la factura
     */
    public String getCodigoc() {
        return codigoCliente;
    }

    /**
     *
     * @param codigoCliente Código del cliente al que se le emite la factura
     */
    public void setCodigoc(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    /**
     *
     * @return Fecha de emision de la factura
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha Fecha de emision de la factura
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return Importe Total de la factura
     */
    public double getimpTotal() {
        return importeTotal;
    }

    /**
     *
     * @param importeTotal Importe Total de la factura
     */
    public void setimpTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    /**
     *
     * @return Un valor lógico que representa si la factura ha sido abonada
     */
    public boolean getPagado() {
        return pagado;
    }

    /**
     *
     * @param pagado Un valor lógico que representa si la factura ha sido abonada
     */
    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    /**este metodo recibe como parámetro
     * @param l Un objeto LineaFactura que debe añadirse a la lista
     */
    public void añadirLinea(LineaFactura l) {
        listaLineasFactura.add(l);
    }

    //los siguientes 3 métodos para este MPV no los hemos utilizado
    /**
     *
     * @param linea Un objeto LineaFactura que debe quitarse de la lista
     */
    public void quitarLinea(LineaFactura linea) {
        for (LineaFactura l : listaLineasFactura) {
            if (l.getDescripcion().equals(linea.getDescripcion())) {
                listaLineasFactura.remove(l);
            }
        }
    }

    /**
     * Vuelca en un fichero de texto un modelo de factura con los datos del
     * objeto Factura sobre el que se invoca.
     */
    public void imprimir() {
        System.out.println("Imprimiendo factura...");
        String nombreFichero=numero+".txt";
        String fichero = new File(nombreFichero).getAbsolutePath();
        DecimalFormat df = new DecimalFormat("#.00");
        try {
            FileWriter fw=new FileWriter(fichero, false);
            // Cabecera
            fw.write("#######################################################\n");
            fw.write("#                     FACTURA                         #\n");
            fw.write("#######################################################\n");
            fw.write("##  Número de factura: "+numero+"\n");
            fw.write("##  Tienda Acuario (CIF A11199938H)\n");
            fw.write("##  Fecha: "+fecha+"\n");
            fw.write("#######################################################\n");
            // Datos del cliente
            ConnDB bbdd=ConnDB.getInstance();
            Cliente c=bbdd.getClienteByCodigo(codigoCliente);
            fw.write("##  Código Cliente: "+c.getCodigo()+"\n");
            fw.write("##  Nombre Cliente: "+c.getNombre()+"\n");
            fw.write("##  Direccion: "+c.getDireccion()+"\n");
            fw.write("##  Teléfono: "+c.getTelefono()+"\n");
            fw.write("#######################################################\n");
            // Lineas de la factura
            fw.write("## Cantidad -- Descripcion                    -- Precio\n");
            fw.write("-------------------------------------------------------\n");
            // Recorremos el array para obtener los datos de cada linea
            for(LineaFactura lf : listaLineasFactura){
                String cantidad=String.format("%11d",lf.getCantidad());
                String descripcion=String.format("%-30s",lf.getDescripcion());
                String precio=String.format(df.format(lf.getPrecio()));
                fw.write(cantidad+" -- "+descripcion+" -- "+precio+"\n");
            }
            // Desglose precio, impuestos e importe
            fw.write("-------------------------------------------------------\n");
            double precio = importeTotal/1.21;
            double impuestos = importeTotal-precio;
            fw.write("## Importe (antes de impuestos)                  "+df.format(precio)+"\n");
            fw.write("## Impuestos (21%)                               "+df.format(impuestos)+"\n");
            fw.write("## IMPORTE TOTAL                                 "+df.format(importeTotal)+"\n");
            // Observaciones
            fw.write("#######################################################\n");
            fw.write("## Observaciones\n");
            fw.write("## \n");
            fw.write("#######################################################\n");
            fw.close();

            System.out.println("Factura guardada como "+fichero);
        }catch(IOException ioe){
            System.out.println(ioe.getLocalizedMessage());
        }
    }

    /**
     *  Marca la factura como abonada
     */
    public void cobrar() {
        System.out.println("Factura pagada");
        pagado = true;
    }
}