package common;

import tienda.articulos.*;
import tienda.*;
import acuario.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Clase principal para conectarse a la base de datos
 *
 * @author angel
 */
public class ConnDB {

    private static ConnDB instanciaUnica;
    private static Connection conn;
    private ResultSet rs;

    /**
     * Constructor para conectarse la base de datos por defecto
     */
    public ConnDB() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://easybyte.club:2223/peixepop", "jdbc", "peixejdbc@Servo2021*");
            System.out.println(">>>>>>>>>>> La conexión a la Base de Datos se ha creado con éxito");
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(">>>>>>>>>>> No se puede conectar con la base de datos");
        }
    }

    public static ConnDB getInstance(){
        if (instanciaUnica==null){
            instanciaUnica=new ConnDB();
        }
        return instanciaUnica;
    }

    /**
     * Hace una consulta a la base de datos y se guarda en el ResultSet
     * @param query Hacer una consulta a la base de datos
     */
    public void cargaDatos(String query) {
        Statement stmt = null;
        try {
            stmt = (Statement) conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }


    // MÉTODOS AÑADIDOS PARA EL ACUARIO
    // API SALAS
    public ArrayList<Sala> getSalas(){
        ArrayList<Sala> lista=new ArrayList();
        this.cargaDatos("SELECT * FROM salas");
        try{
            while (rs.next()) {
                String codigo=rs.getString("codigo");
                String nombre=rs.getString("nombre");
                String tipo=rs.getString("tipo");
                lista.add(new Sala(codigo,nombre,tipo));
            }
        } catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return lista;
    }

    public Sala getSalaByCodigo(String codigoSala){
        Sala s=null;
        this.cargaDatos("SELECT * FROM salas WHERE codigo='"+codigoSala+"'");
        try{
            while (rs.next()) {
                String codigo=rs.getString("codigo");
                String nombre=rs.getString("nombre");
                String tipo=rs.getString("tipo");
                s=new Sala(codigo,nombre,tipo);
            }
        } catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return s;
    }

    // API ESTANQUES
    public ArrayList<Estanque> getEstanques(){
        ArrayList<Estanque> lista=new ArrayList();
        this.cargaDatos("SELECT * FROM estanques");
        try{
            while (rs.next()) {
                String codigo=rs.getString("codigo");
                String tipo=rs.getString("tipo");
                String nombre=rs.getString("nombre");
                String codigo_sala=rs.getString("codigo_sala");
                lista.add(new Estanque(codigo,tipo,nombre,codigo_sala));
            }
        } catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return lista;
    }

    public Estanque getEstanqueByCodigo(String codigoEstanque){
        Estanque e=null;
        this.cargaDatos("SELECT * FROM estanques WHERE codigo='"+codigoEstanque+"'");
        try{
            while (rs.next()) {
                String codigo=rs.getString("codigo");
                String tipo=rs.getString("tipo");
                String nombre=rs.getString("nombre");
                String codigo_sala=rs.getString("codigo_sala");
                e=new Estanque(codigo,nombre,tipo,codigo_sala);
            }
        } catch (SQLException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return e;
    }

    // API TIBURONES
    public ArrayList<Tiburon> getTiburones(){
        ArrayList<Tiburon> lista=new ArrayList();
        this.cargaDatos("SELECT * FROM tiburones");
        try{
            while (rs.next()) {
                String codigo=rs.getString("codigo");
                String nombre=rs.getString("nombre");
                String tamano=rs.getString("tamano");
                String codigo_estanque=rs.getString("codigo_estanque");
                lista.add(new Tiburon(codigo,nombre,tamano,codigo_estanque));
            }
        } catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return lista;
    }

    // API PLANTAS
    public ArrayList<Planta> getPlantas(){
        ArrayList<Planta> lista=new ArrayList();
        this.cargaDatos("SELECT * FROM plantas");
        try{
            while (rs.next()) {
                String codigo=rs.getString("codigo");
                String medioDeVida=rs.getString("medio_de_vida");
                String nombre=rs.getString("nombre");
                String cod_estanque="";
                String cod_sala="";
                switch (medioDeVida){
                    case "Acuatico":
                        cod_estanque=rs.getString("codigo_estanque");
                        break;
                    case "Terrestre":
                        cod_sala = rs.getString("codigo_sala");
                        break;
                }
                lista.add(new Planta(medioDeVida,codigo,nombre,cod_estanque,cod_sala));
            }
        } catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return lista;
    }

    public int getNumeroFilas(char tabla){
        int contador=0;
        switch (tabla){
            case 'S':
                this.cargaDatos("SELECT * FROM salas");
                break;
            case 'E':
                this.cargaDatos("SELECT * FROM estanques");
                break;
            case 'T':
                this.cargaDatos("SELECT * FROM tiburones");
                break;
            case 'P':
                this.cargaDatos("SELECT * FROM plantas");
                break;
        }
        try {
            while (rs.next()){
                contador++;
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return contador;
    }

    /**
     * Muestra los datos de la tabla estanques
     */
    public void mostrarDatosEstanques() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String tipo = rs.getString("tipo");
                String nombre = rs.getString("nombre");
                String codigoSala = rs.getString("codigo_sala");
                System.out.println(codigo + "," + tipo + "," + nombre + "," + codigoSala);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra los datos de la tabla plantas
     */
    public void mostrarDatosPlantas() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String medioDeVida = rs.getString("medio_de_vida");
                String nombre = rs.getString("nombre");
                String codigoEstanque = rs.getString("codigo_estanque");
                String codigoSala = rs.getString("codigo_sala");
                System.out.println(codigo + "," + medioDeVida + "," + nombre + "," + codigoEstanque + "," + codigoSala);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra los datos de la tabla salas
     */
    public void mostrarDatosSalas() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                System.out.println(codigo + "," + nombre + "," + tipo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra los datos de la tabla tiburones
     */
    public void mostrarDatosTiburones() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String tamano = rs.getString("tamano");
                String codigoEstanque = rs.getString("codigo_estanque");
                System.out.println(codigo + "," + nombre + "," + tamano + "," + codigoEstanque);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    // MÉTODOS AÑADIDOS PARA LA TIENDA
    // API ARTICULOS
    public ArrayList<Articulo> getArticulos(){
        ArrayList<Articulo> lista=new ArrayList();
        this.cargaDatos("SELECT * FROM articulos");
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("descripcion");
                int stock = Integer.parseInt(rs.getString("stock"));
                double precio = Double.parseDouble(rs.getString("precio"));
                int tipo_articulo = Integer.parseInt(rs.getString("tipo_articulo"));
                switch(tipo_articulo){
                    case 1:
                        lista.add(new AnimalAcuatico(codigo,nombre,stock,precio));
                        break;
                    case 2:
                        lista.add(new PlantaAcuatica(codigo,nombre,stock,precio));
                        break;
                    case 3:
                        lista.add(new Alimento(codigo,nombre,stock,precio));
                        break;
                    case 4:
                        lista.add(new Accesorio(codigo,nombre,stock,precio));
                        break;
                    case 5:
                        lista.add(new Pecera(codigo,nombre,stock,precio));
                        break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return lista;
    }

    public Articulo getArticuloByCodigo(String codigoArticulo){
        Articulo a=null;
        this.cargaDatos("SELECT * FROM articulos WHERE codigo='"+codigoArticulo+"'");
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("descripcion");
                int stock = Integer.parseInt(rs.getString("stock"));
                double precio = Double.parseDouble(rs.getString("precio"));
                int tipo_articulo = Integer.parseInt(rs.getString("tipo_articulo"));
                switch(tipo_articulo){
                    case 1:
                        a=new AnimalAcuatico(codigo,nombre,stock,precio);
                        break;
                    case 2:
                        a=new PlantaAcuatica(codigo,nombre,stock,precio);
                        break;
                    case 3:
                        a=new Alimento(codigo,nombre,stock,precio);
                        break;
                    case 4:
                        a=new Accesorio(codigo,nombre,stock,precio);
                        break;
                    case 5:
                        a=new Pecera(codigo,nombre,stock,precio);
                        break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return a;
    }

    public Articulo getArticuloRandom(){
        Articulo a=null;
        this.cargaDatos("SELECT * FROM articulos ORDER BY RAND() LIMIT 1");
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("descripcion");
                int stock = Integer.parseInt(rs.getString("stock"));
                double precio = Double.parseDouble(rs.getString("precio"));
                int tipo_articulo = Integer.parseInt(rs.getString("tipo_articulo"));
                switch(tipo_articulo){
                    case 1:
                        a=new AnimalAcuatico(codigo,nombre,stock,precio);
                        break;
                    case 2:
                        a=new PlantaAcuatica(codigo,nombre,stock,precio);
                        break;
                    case 3:
                        a=new Alimento(codigo,nombre,stock,precio);
                        break;
                    case 4:
                        a=new Accesorio(codigo,nombre,stock,precio);
                        break;
                    case 5:
                        a=new Pecera(codigo,nombre,stock,precio);
                        break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return a;
    }

    // API CLIENTES
    public ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> lista=new ArrayList();
        this.cargaDatos("SELECT * FROM clientes");
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                lista.add(new Cliente(codigo, nombre, direccion, telefono));
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return lista;
    }

    public Cliente getClienteByCodigo(String codigoCliente){
        Cliente c=null;
        this.cargaDatos("SELECT * FROM clientes WHERE codigo='"+codigoCliente+"'");
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String direccion=rs.getString("direccion");
                String telefono=rs.getString("telefono");
                c=new Cliente(codigo,nombre,direccion,telefono);
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return c;
    }

    public Cliente getClienteRandom(){
        Cliente c=null;
        this.cargaDatos("SELECT * FROM clientes  ORDER BY RAND() LIMIT 1");
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String direccion=rs.getString("direccion");
                String telefono=rs.getString("telefono");
                c=new Cliente(codigo,nombre,direccion,telefono);
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return c;
    }

    // API TRABAJADORES
    public ArrayList<Trabajador> getTrabajadores(){
        ArrayList<Trabajador> lista=new ArrayList();
        this.cargaDatos("SELECT * FROM trabajadores");
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                Double salario = Double.parseDouble(rs.getString("salario"));
                lista.add(new Trabajador(codigo, nombre, direccion, telefono, salario));
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return lista;
    }

    public Trabajador getTrabajadorByCodigo(String codigoTrabajador){
        Trabajador t=null;
        this.cargaDatos("SELECT * FROM trabajadores WHERE codigo='"+codigoTrabajador+"'");
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String direccion=rs.getString("direccion");
                String telefono=rs.getString("telefono");
                Double salario = Double.parseDouble(rs.getString("salario"));
                t=new Trabajador(codigo, nombre, direccion, telefono, salario);
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return t;
    }

    public Trabajador getTrabajadorRandom(){
        Trabajador t=null;
        this.cargaDatos("SELECT * FROM trabajadores ORDER BY RAND() LIMIT 1");
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String direccion=rs.getString("direccion");
                String telefono=rs.getString("telefono");
                Double salario = Double.parseDouble(rs.getString("salario"));
                t=new Trabajador(codigo, nombre, direccion, telefono, salario);
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return t;
    }

    // API FACTURAS
    public ArrayList<Factura> getFacturas(){
        ArrayList<Factura> lista=new ArrayList();
        this.cargaDatos("SELECT * FROM facturas");
        try {
            while (rs.next()) {
                int numero = Integer.parseInt(rs.getString("codigo"));
                String cliente = rs.getString("codigo_cliente");
                String fecha = rs.getString("fecha");
                Double importeTotal = Double.parseDouble(rs.getString("importeTotal"));
                boolean pagada = Integer.parseInt(rs.getString("pagada"))==1;
                Factura f=new Factura(numero, cliente, fecha, importeTotal,pagada);
                ArrayList<LineaFactura> lineas=this.getLineasFacturaByNumeroFactura(numero);
                for(LineaFactura l : lineas){
                    f.añadirLinea(l);
                }
                lista.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return lista;
    }

    public Factura getFacturaByNumero(int numeroFactura){
        Factura f=null;
        this.cargaDatos("SELECT * FROM facturas WHERE codigo='"+numeroFactura+"'");
        try {
            while (rs.next()) {
                int numero = Integer.parseInt(rs.getString("codigo"));
                String codigoCliente = rs.getString("codigo_cliente");
                String fecha=rs.getString("fecha");
                Double importeTotal = Double.parseDouble(rs.getString("importeTotal"));
                boolean pagada = Integer.parseInt(rs.getString("pagada"))==1;
                f=new Factura(numero,codigoCliente,fecha,importeTotal, pagada);
                ArrayList<LineaFactura> lineas=this.getLineasFacturaByNumeroFactura(numero);
                for(LineaFactura l : lineas){
                    f.añadirLinea(l);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return f;
    }

    public ArrayList<LineaFactura> getLineasFacturaByNumeroFactura(int numeroFactura){
        ArrayList<LineaFactura> lista=new ArrayList();
        this.cargaDatos("SELECT * FROM lineas_facturas WHERE codigo_factura='"+numeroFactura+"'");
        try {
            while (rs.next()) {
                int cantidad = Integer.parseInt(rs.getString("cantidad"));
                String descripcion = rs.getString("descripcion");
                Double precio = Double.parseDouble(rs.getString("precio"));
                LineaFactura lf=new LineaFactura(cantidad,descripcion,precio);
                lista.add(lf);
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return lista;
    }

    // API PEDIDOS
    public ArrayList<Pedido> getPedidos(){
        ArrayList<Pedido> lista=new ArrayList();
        this.cargaDatos("SELECT * FROM pedidos");
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String fecha = rs.getString("fecha");
                boolean recibido = Integer.parseInt(rs.getString("recibido"))==1;
                Pedido p=new Pedido(codigo, fecha, recibido);
                ArrayList<LineaPedido> lineas=this.getLineasPedidoByCodigoPedido(codigo);
                for(LineaPedido l : lineas){
                    p.añadirLinea(l.getArticulo(),l.getCantidad());
                }
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return lista;
    }

    public Pedido getPedidoByCodigo(int codigoPedido){
        Pedido p=null;
        this.cargaDatos("SELECT * FROM pedidos WHERE codigo='"+codigoPedido+"'");
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String fecha = rs.getString("fecha");
                boolean recibido = Integer.parseInt(rs.getString("recibido"))==1;
                p=new Pedido(codigo, fecha, recibido);
                ArrayList<LineaPedido> lineas=this.getLineasPedidoByCodigoPedido(codigo);
                for(LineaPedido l : lineas){
                    p.añadirLinea(l.getArticulo(),l.getCantidad());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return p;
    }

    public ArrayList<LineaPedido> getLineasPedidoByCodigoPedido(String codigoPedido){
        ArrayList<LineaPedido> lista=new ArrayList();
        this.cargaDatos("SELECT * FROM lineas_pedidos WHERE codigo_pedido='"+codigoPedido+"'");
        try {
            while (rs.next()) {
                Articulo articulo=this.getArticuloByCodigo(rs.getString("codigo_articulo"));
                int cantidad = Integer.parseInt(rs.getString("cantidad"));
                Double precio = Double.parseDouble(rs.getString("precio"));
                LineaPedido lp=new LineaPedido(articulo,cantidad,precio);
                lista.add(lp);
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return lista;
    }

    /**
     * Muestra los datos de la tabla articulos
     */
    public void mostrarDatosArticulos() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String descripcion = rs.getString("descripcion");
                String stock = rs.getString("stock");
                String precio = rs.getString("precio");
                String tipoArticulo = rs.getString("tipo_articulo");
                System.out.println(codigo + "," + descripcion + "," + stock + "," + precio + "," + tipoArticulo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra los datos de la tabla clientes
     */
    public void mostrarDatosClientes() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                System.out.println(codigo + "," + nombre + "," + direccion + "," + telefono);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Muestra los datos de la tabla trabajadores
     */
    public void mostrarDatosTrabajadores() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String salario = rs.getString("salario");
                System.out.println(codigo + "," + nombre + "," + direccion + "," + telefono + "," + salario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra los datos de la tabla factura
     */
    public void mostrarDatosFacturas() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String codigoCliente = rs.getString("codigo_cliente");
                String fecha = rs.getString("fecha");
                String importeTotal = rs.getString("importe_total");
                String pagada = rs.getString("pagada");
                System.out.println(codigo + "," + codigoCliente + "," + fecha + "," + importeTotal + "," + pagada);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra los datos de la tabla lineas_facturas
     */
    public void mostrarDatosLineasFacturas() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String cantidad = rs.getString("cantidad");
                String descripcion = rs.getString("descripcion");
                String precio = rs.getString("precio");
                String codigoFactura = rs.getString("codigo_factura");
                System.out.println(codigo + "," + cantidad + "," + descripcion + "," + precio + "," + codigoFactura);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra los datos de la tabla lineas_facturas
     */
    public void mostrarDatosLineasPedidos() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String codigoArticulo = rs.getString("codigo_articulo");
                String cantidad = rs.getString("cantidad");
                String precio = rs.getString("precio");
                String codigoPedido = rs.getString("codigo_pedido");
                System.out.println(codigo + "," + codigoArticulo + "," + cantidad + "," + precio + "," + codigoPedido);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra los datos de la tabla pedidos
     */
    public void mostrarDatosPedidos() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String fecha = rs.getString("fecha");
                String recibido = rs.getString("recibido");
                System.out.println(codigo + "," + fecha + "," + recibido);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}