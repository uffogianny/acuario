package taquilla;

import java.math.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    static int opcion;

    public static void main(String[] args) throws IOException{
        System.out.println("\n\n\n************************************************\n\t\t TEST TAQUILLA");
        Taquilla taquilla = new Taquilla();

        System.out.println("\n\n\n************************************************\n");
        System.out.println("Compra de entradas");
        taquilla.Entrada();

        System.out.println("\n\n\n************************************************\n");
        System.out.println("Historial de ventas");
        taquilla.historial();

        System.out.println("\n\n\n************************************************\n");
        System.out.println("Beneficios");
        taquilla.beneficios();
    }

}
