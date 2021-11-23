package common;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIConfig {

    // Parámetros por default
    private static final String DEFAULT_URL = "http://15.188.62.79:8080/api";
    private static final String XAPIKEY = "TgGJrf2EdN1y4VrM79fzZoYP5Q1C89sM";

    // Comprobamos el estado de la URL
    public static String getStatus(String url) throws IOException {

        String result = "";
        try {
            URL urlObj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
            con.setRequestMethod("GET");
            // Set connection timeout
            con.setConnectTimeout(3000);
            con.connect();

            int code = con.getResponseCode();
            if (code == 200) {
                result = "On";
            }
        } catch (Exception e) {
            result = "Off";
        }
        return result;
    }

    public JSONArray getResponse(String path) {

        try {
            // Comprabamos el status de la URL, en caso de responder, continuamos.
            if(getStatus(DEFAULT_URL+path).equals("Off")) { return null; }

            // Creamos un cliente HttpClient, que nos ayudará a acceder a la URL con el método que queramos
            CloseableHttpClient client = HttpClientBuilder.create().build();
            // Definimos el método que queremos utilizar, en este caso GET
            HttpGet request = new HttpGet(DEFAULT_URL+path);
            // Definimos la X-API-KEY para que la API nos autentifique
            request.addHeader("x-api-key", XAPIKEY);

            // Ejecutamos la request y lo guardamos en un response (respuesta)
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();

            // Cogemos el contenido de la respuesta y la convertimos a String
            String responseString = EntityUtils.toString(entity);
            // Para facilitar las cosas, pasamos el string a un JSONObject y los retornamos.
            JSONArray responseJSON = new JSONArray(responseString);
            return  responseJSON;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
