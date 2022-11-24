package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * Temporary HTML as an example page.
 * 
 * Based on the Project Workshop code examples.
 * This page currently:
 *  - Provides a link back to the index page
 *  - Displays the list of movies from the Movies Database using the JDBCConnection
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class MapPage implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/mappage.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        //JDBCConnection jdbc = new JDBCConnection();

        // Next we will ask this *class* for the movies
        //ArrayList<String> movies = jdbc.getMovies();
        
        String html = "<!DOCTYPE html>"+
        "<html>"+
        "<title>Coronavirus Overview</title>"+
        "<meta charset=\"UTF-8\">"+
        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"+
        "<link rel=\"stylesheet\" href=\"w3.css\">"+
        "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Inconsolata\">"+
        "<link rel=\"stylesheet\" href=\"common.css\">"+
        ""+
        "<body>"+
        ""+
        "<!-- Links (sit on top) -->"+
        "<div class=\"w3-top\">"+
        "  <div class=\"w3-row w3-padding w3-black\">"+
        "    <h1 style=\"text-align: center;\">COVID-19 CORONAVIRUS PANDEMIC OVERVIEW</h1>"+
        "    <div class=\"w3-col s3\" style=\"font-size: 22px;\">"+
        "      <div class=\"dropdown w3-block w3-black\" style=\"border:none;display:inline-block;padding:8px 16px;vertical-align:middle;text-align:center;\">"+
        "        <a class=\"dropbtn w3-button w3-block w3-black\" href =\"/\" style=\"text-decoration:none;\" >HOME</a>"+
        ""+
        "      </div>"+
        "  </div>"+
        "    <div class=\"w3-col s3\" style=\"font-size: 22px;\">"+
        "      <div class=\"dropdown w3-block w3-black\" style=\"border:none;display:inline-block;padding:8px 16px;vertical-align:middle;text-align:center;\">"+
        "        <a class=\"dropbtn w3-button w3-block w3-black\">WHAT IS COVID-19?</a>"+
        ""+
        "      </div>"+
        "  </div>"+
        "    <div class=\"w3-col s3\" style=\"font-size: 22px;\">"+
        "      <div class=\"dropdown w3-block w3-black\" style=\"border:none;display:inline-block;padding:8px 16px;vertical-align:middle;text-align:center;\">"+
        "        <a class=\"dropbtn w3-button w3-block w3-black\">ABOUT</a>"+
        ""+
        "      </div>"+
        "  </div>"+
        "    <div class=\"w3-col s3\" style=\"font-size: 22px;\">"+
        "        <div class=\"dropdown w3-block w3-black\" style=\"border:none;display:inline-block;padding:8px 16px;vertical-align:middle;text-align:center;\">"+
        "          <a class=\"dropbtn w3-button w3-block w3-black\">VIEW BY:</a>"+
        "          <div class=\"dropdown-content\">"+
        "          <a href=\"#\">LOCATION AND CLIMATE</a>"+
        "          <a href=\"#\">SIMILAR COUNTRIES AND STATE</a>"+
        "          <a href=\"level2page2.html\">DEATHS</a>"+
        "          <a href=\"page2.html\">INFECTIONS</a>"+
        "          </div>"+
        "        </div>"+
        "    </div>"+
        "  </div>"+
        "</div>"+
    

         "<div class=\"w3-sand w3-grayscale w3-large\" style = \"transform: translateY(150px);\">"+
  
         "<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>"+
         "<script type=\"text/javascript\" src=\"map.js\"></script>"+
             
         


        "</body>"+
        "</html>";
            
        
        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }
}
