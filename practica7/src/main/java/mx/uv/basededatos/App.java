package mx.uv.basededatos;

import static spark.Spark.*;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Gson gson = new Gson();
    private static Map<String,Usuarios> usuarios = new HashMap<>();

    public static void main( String[] args )
    {
        before((req,res) -> res,type("application/json"));
        get("/usuarios", (req,res) -> gson.toJson(usuarios.values()));

        post("/usuarios",( req,res) -> {
            String query = req.body();
            System.out.println( "peticion:" + query);
            Usuarios u= gson.fromJson(query,Usuarios.class);
            String id = UUID.randomUUID().toString();
            u.setId(id);
            usuarios.put(id,u);
            return "Se creo el usuario con id" + id;
        });

    }
}
