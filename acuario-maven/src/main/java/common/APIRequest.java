package common;

import acuario.Sala;
import org.json.JSONArray;
import org.json.JSONObject;
import tienda.Cliente;

import java.util.ArrayList;

public class APIRequest {

    private final APIConfig api = new APIConfig();

    // MÉTODOS AÑADIDOS PARA EL ACUARIO
    // API SALAS
    public ArrayList<Sala> getSalas(){
        JSONArray jsonResponse = api.getResponse("/salas");
        ArrayList<Sala> lista=new ArrayList();
        for (int indice = 0; indice < jsonResponse.length(); indice++) {
            JSONObject jsonObject = jsonResponse.getJSONObject(indice);
            String codigo = jsonObject.getString("codigo");
            String nombre = jsonObject.getString("nombre");
            String tipo = jsonObject.getString("tipo");
            lista.add(new Sala(codigo,nombre,tipo));
        }
        return lista;
    }

    // API CLIENTES
    public ArrayList<Cliente> getClientes(){
        JSONArray jsonResponse = api.getResponse("/clientes");
        ArrayList<Cliente> lista=new ArrayList();
        for (int indice = 0; indice < jsonResponse.length(); indice++) {
            JSONObject jsonObject = jsonResponse.getJSONObject(indice);
            String codigo = jsonObject.getString("codigo");
            String nombre = jsonObject.getString("nombre");
            String direccion = jsonObject.getString("direccion");
            String telefono = jsonObject.getString("telefono");
            lista.add(new Cliente(codigo,nombre,direccion,telefono));
        }
        return lista;
    }
}
