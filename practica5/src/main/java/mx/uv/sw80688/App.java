package mx.uv.sw80688;

import static spark.Spark.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        options("/*",(request,response)->{

            String accessControlRequestHeaders =request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders !=null){
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod =request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod !=null){
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((request,response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/hello/:name", (request, response) -> {
            return "Hello: " +request.params(":name");
        });
        get("/queryparams", (request, response) -> {
            return "Hello: " +request.queryParams("Paraemail");
        });
        post("/json",(request,response) ->{
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(request,body());
            JsonObject peticion = arbol.getAsJsonObject();

            System.out.println("prm: " + peticion.get("ParaEmail"));
            System.out.println("prm: " + peticion.get("ParaPassword"));
            return "algo";
        });

        get("/formdata",(request,response) ->{
            /*JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(request,body());
            JsonObject peticion = arbol.getAsJsonObject();*/
            /*Tener cuidado de utilizar request.body y request.queryParams o viceversa debido a que el framework consume el contenido al momento de usarlo*/
            System.out.println("prm1: " + request.queryParams("Paraemail"));
            System.out.println("prm2: " + request.queryParams("Parapassword"));

            System.out.println("prm: " + request.body());
            System.out.println("prm: " + request.contentType());
            return "algo";
        });
    }
        
    
}    


