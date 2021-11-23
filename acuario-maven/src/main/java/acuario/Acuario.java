package acuario;

import common.ConnDB;
import java.util.ArrayList;

/**
 * Clase para crear un objeto tipo Acuario
 * @author Angel, Jose, Miguel, Paulo
 */
public class Acuario {

    // JDBC Conector BBDD
    ConnDB bbdd=null;
    private final String nombre;
    private ArrayList<Sala> inventarioSalas;
    private ArrayList<Estanque> inventarioEstanques;
    private ArrayList<Tiburon> inventarioTiburones;
    private ArrayList<Planta> inventarioPlantas;

    /**
     * Constructor por defecto
     * @param nombre El nombre del acuario
     */
    public Acuario(String nombre) {
        this.bbdd=ConnDB.getInstance();
        this.nombre=nombre;
    }

    public void test() {
        System.out.println(">>>>>>>>>>> Preparando inventario...");
        cargarInventario();
        System.out.println(">>>>>>>>>>> Inventario preparado");
        System.out.println("******************\n");
        System.out.println(">>>>>>>>>>> Mostrando inventario...");
        mostrarInventario();
        // Asignar a cada sala sus estanques, plantas y tiburones correspondientes
        System.out.println(">>>>>>>>>>> Configurando inventario...");
        asignarJerarquia();
        System.out.println(">>>>>>>>>>> Inventario configurado");
        // Se muestra como está configurado el acuario
//        System.out.println(">>>>>>>>>>> Mostrando configuración...");
//        mostrarJeraquia();
        System.out.println("******************\n");
    }

    public void cargarInventario() {
        inventarioSalas=bbdd.getSalas();
        System.out.println(">>>>>>>>>>> Salas cargadas");
        inventarioEstanques=bbdd.getEstanques();
        System.out.println(">>>>>>>>>>> Estanques cargados");
        inventarioTiburones=bbdd.getTiburones();
        System.out.println(">>>>>>>>>>> Tiburones cargados");
        inventarioPlantas=bbdd.getPlantas();
        System.out.println(">>>>>>>>>>> Plantas cargadas");
    }
    /**
     * Muestra el inventario disponible que hay en el acuario que son:
     *      - Salas
     *      - Estanques
     *      - Tiburones
     *      - Plantas
     */
    public void mostrarInventario() {
        System.out.println("\n--- INVENTARIO DEL ACUARIO " + nombre.toUpperCase() + " ---");
        // Mostrar salas
        System.out.println("\nSALAS EXISTENTES");
        bbdd.cargaDatos("SELECT * FROM salas");
        bbdd.mostrarDatosSalas();
        System.out.println("******************\n");
        // Mostrar estanques
        System.out.println("\nESTANQUES EXISTENTES");
        bbdd.cargaDatos("SELECT * FROM estanques");
        bbdd.mostrarDatosEstanques();
        System.out.println("******************\n");
        // Mostrar tiburones
        System.out.println("\nTIBURONES EXISTENTES");
        bbdd.cargaDatos("SELECT * FROM tiburones");
        bbdd.mostrarDatosTiburones();
        System.out.println("******************\n");
        // Mostrar plantas
        System.out.println("\nPLANTAS EXISTENTES");
        bbdd.cargaDatos("SELECT * FROM plantas");
        bbdd.mostrarDatosPlantas();
        System.out.println("******************\n");
    }

    /**
     * Se le asigna a cada sala sus estanques correspondientes y en cada
     * estanque se le asignan los tiburones correspondientes
     */
    public void asignarJerarquia() {
        asignarEstanquesACadaSala();
        asignarPlantasASalasYEstanques();
        asignarTiburonesACadaEstanque();
    }

    /**
     * Se muestra como están organizadas las salas, estanques y tiburones en el
     * acuario
     */
    public void mostrarJeraquia() {
        System.out.println("\n--- CONFIGURACIÓN DEL ACUARIO " + nombre.toUpperCase() + " ---");
        for (Sala sala : inventarioSalas){
            System.out.println(sala.getNombre());
            for (Estanque estanque : sala.getEstanques()){
                System.out.println("\t"+estanque.getNombre());
                for (Tiburon tiburon : estanque.getTiburones()){
                    System.out.println("\t\t"+tiburon.getDescripcion());
                }
                if (estanque.getPlantas()!=null){
                    for (Planta p : estanque.getPlantas()){
                        System.out.println("\t\t"+p.getDescripcion());
                    }
                }
            }
            if (sala.getPlanta()!=null) {
                System.out.println("\t"+sala.getPlanta().getDescripcion());
            }
        }
    }

    private void asignarEstanquesACadaSala() {
        for (Estanque e: inventarioEstanques){
            String codSala=e.getSala().getCodigo();
            for (Sala s : inventarioSalas){
                if (s.getCodigo().equals(codSala)) {
                    s.agregarEstanques(e);
                }
            }
        }
    }

    private void asignarPlantasASalasYEstanques() {
        for (Planta p: inventarioPlantas){
            if (p.getSala()!=null){
                String codSala=p.getSala().getCodigo();
                for (Sala s : inventarioSalas){
                    if (s.getCodigo().equals(codSala)) {
                        s.agregarPlanta(p);
                    }
                }
            }
            if (p.getEstanque()!=null){
                String codEstanque=p.getEstanque().getCodigo();
                for (Estanque e : inventarioEstanques){
                    if (e.getCodigo().equals(codEstanque)) {
                        e.agregarPlanta(p);
                    }
                }
            }

        }
    }

    private void asignarTiburonesACadaEstanque() {
        for (Tiburon t: inventarioTiburones){
            String codEstanque=t.getEstanque().getCodigo();
            for (Estanque e : inventarioEstanques){
                if (e.getCodigo().equals(codEstanque)){
                    e.agregarTiburones(t);
                }
            }
        }
    }

}