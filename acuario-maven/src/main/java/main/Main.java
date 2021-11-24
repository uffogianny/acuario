package main;
import acuario.Acuario;
import taquilla.Taquilla;
import tienda.Tienda;

/**
 * Clase deonde se ejecuta el programa
 * @author Angel, Jose, Miguel, Paulo, Rocio, Yudaisy, Gianny, Emilio
 */
public class Main {

    public static void main(String[] args)  {
        try {
            Acuario acuario = new Acuario("PEIXEPOP");
            acuario.test();
            Tienda tienda=Tienda.getInstance();
            tienda.mostrarTodo();
            tienda.test();
            Taquilla taquilla=new Taquilla();
            taquilla.test();
        } catch (Exception e) {
            System.out.println(">>>>>>>>>>> No se puede conectar con la base de datos");
        }
    }
}
