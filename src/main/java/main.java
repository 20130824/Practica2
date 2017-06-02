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
        staticFiles.location("/");
        List<estudiante> listaEstudiante = new ArrayList<>();
        listaEstudiante.add(new estudiante(20011136, "Carlos Camacho", "ITT", "1234567"));
        listaEstudiante.add(new estudiante(20011137, "Otro Estudiante", "ISC", "1234567"));
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

            return new ModelAndView(attributes, "mostrarEstudiantes.ftl");
        }, freeMarkerEngine);

        get("/mostrarEstudiantes/:indice", (request, response) -> {

                    Map<String, Object> attributes = new HashMap<>();
                    attributes.put("listaEstudiante", listaEstudiante);
                    int indice = Integer.parseInt(request.params("indice"));


                    return new ModelAndView(attributes, "mostrarEstudiantes.ftl");}, freeMarkerEngine);

        get("/visualizarEstudiante", (request, response) -> {


            Map<String, Object> attributes = new HashMap<>();
            attributes.put("Estudiante", listaEstudiante.get(0));


            return new ModelAndView(attributes, "visualizarEstudiante.ftl");}, freeMarkerEngine);


    }


    }

