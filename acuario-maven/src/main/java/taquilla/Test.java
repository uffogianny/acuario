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
        Taquilla taquilla = new Taquilla();

        System.out.println("\n_______Compra de entradas_______");
        taquilla.Entrada();
        System.out.println("\n_______Historial de ventas_______--");
        taquilla.historial();
        System.out.println("\n_______Beneficios_______");
        taquilla.beneficios();
    }

}
