import models.CD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;



public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<CD> allCDs = CD.getAll();
            model.put("allCDs", allCDs);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/success/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String artist = request.queryParams("artistName");
            String album = request.queryParams("albumName");
            int year = Integer.parseInt(request.queryParams("releaseYear"));
            int price = Integer.parseInt(request.queryParams("price"));
            CD newCD = new CD(artist,album,year,price);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());



    }
}