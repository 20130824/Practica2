/**
 * Created by Isaac Perez on 31/5/2017.
 */
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import org.omg.CORBA.INTERNAL;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static spark.Spark.*;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;


public class main {

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFiles.location("/");
        List<estudiante> listaEstudiante = new ArrayList<>();
        listaEstudiante.add(new estudiante(20130824, "Isaac", "Perez", "1234567"));
        listaEstudiante.add(new estudiante(20131111, "Jose", "Perez", "1234567"));
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(main.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);


        get("/crearEstudiante", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();

            return new ModelAndView(attributes, "crearEstudiante.ftl");
        }, freeMarkerEngine);

        post("/crearEstudiante", (request, response) -> {
            int Matricula = Integer.parseInt(request.queryParams("matricula"));
            String Nombre = request.queryParams("nombre");
            String Apellido = request.queryParams("apellido");
            String Telefono = request.queryParams("telefono");

            listaEstudiante.add(new estudiante(Matricula, Nombre, Apellido, Telefono));
            Map<String, Object> attributes = new HashMap<>();
            response.redirect("/mostrarEstudiantes");
            return null;
        }, freeMarkerEngine);

        get("/mostrarEstudiantes", (request, response) -> {

                    Map<String, Object> attributes = new HashMap<>();
                    attributes.put("listaEstudiante", listaEstudiante);



                    return new ModelAndView(attributes, "mostrarEstudiantes.ftl");}, freeMarkerEngine);

        get("/modificarEstudiante/:indice", (request, response) -> {


            Map<String, Object> attributes = new HashMap<>();

             int indice = Integer.parseInt(request.params("indice"));
            attributes.put("estudiante", listaEstudiante.get(indice));
            attributes.put("indice", indice);
            return new ModelAndView(attributes, "modificarEstudiante.ftl");}, freeMarkerEngine);


        post("/editarEstudiante/:indice", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            int indice = Integer.parseInt(request.params("indice"));
            System.out.println(indice);
            int Matricula = Integer.parseInt(request.queryParams("matricula"));
            String Nombre = request.queryParams("nombre");
            String Apellido = request.queryParams("apellido");
            String Telefono = request.queryParams("telefono");


            listaEstudiante.set(indice,new estudiante(Matricula, Nombre, Apellido, Telefono));
            response.redirect("/mostrarEstudiantes");

            return null;}, freeMarkerEngine);

        post("/borrarEstudiante/:indice", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            int indice = Integer.parseInt(request.params("indice"));


            listaEstudiante.remove(indice);
            response.redirect("/mostrarEstudiantes");

            return null;}, freeMarkerEngine);



    }
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }


    }

