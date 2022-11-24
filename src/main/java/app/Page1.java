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
public class Page1 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/";

    @Override
    public void handle(Context context) throws Exception {
        
        JDBCConnection jdbc = new JDBCConnection();
        Integer TotalCases = jdbc.getTotalCases();
        Integer TotalDeaths = jdbc.getTotalDeath();
        ArrayList<String> Top3Country = jdbc.GetTop3MostAffected();
        // Create a simple HTML webpage in a String
        String html = "<html>";

        html += "<meta name='viewport' content='width=device-width, initial-scale=1'>";
        html+= "<meta charset='UTF-8'>";
        html += "<link rel='stylesheet' href='w3.css'>";
        html += "<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Inconsolata'>";
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        

        
        html += "<div class='w3-top'>";
        html += "<div class='w3-row w3-padding w3-black'>";
        html += "<h1 style='text-align: center;'>COVID-19 CORONAVIRUS PANDEMIC OVERVIEW</h1>";
        html += "<div class='w3-col s3' style='font-size: 22px;'>";
        html += "<div class='dropdown w3-block w3-black' style='border:none;display:inline-block;padding:8px 16px;vertical-align:middle;text-align:center;'>";
        html += "<a class='dropbtn w3-button w3-block w3-black' href ='/'>HOME</a>";
        
        html += "</div>";
        html += "</div>";
        html += "<div class='w3-col s3' style='font-size: 22px;'>";
        html += "<div class='dropdown w3-block w3-black' style='border:none;display:inline-block;padding:8px 16px;vertical-align:middle;text-align:center;'>";
        html += "<a href='https://www.health.gov.au/news/health-alerts/novel-coronavirus-2019-ncov-health-alert/what-you-need-to-know-about-coronavirus-covid-19' target = 'blank' class='dropbtn w3-button w3-block w3-black'>WHAT IS COVID-19?</a>";
        
        html += "</div>";
        html += "</div>";
        html += "<div class='w3-col s3' style='font-size: 22px;'>";
        html += "<div class='dropdown w3-block w3-black' style='border:none;display:inline-block;padding:8px 16px;vertical-align:middle;text-align:center;'>";
        html += "<a class='dropbtn w3-button w3-block w3-black' href='/page2.html'> DEATH/CASES DATA</a>";
        
        html += "</div>";
        html += "</div>";
        html += "<div class='w3-col s3' style='font-size: 22px;'>";
        html += "<div class='dropdown w3-block w3-black' style='border:none;display:inline-block;padding:8px 16px;vertical-align:middle;text-align:center;'>";
        html += "<a class='dropbtn w3-button w3-block w3-black' href=\"/page5.html\">SIMILAR COUNTRIES AND STATE DATA</a>";
        html += "</div>";
        html += "</div>";
        html += "</div>";
        html += "</div>";
      
        
        html += "<header  id='home' style='transform: translateY(160px);'>";
        html += "<img src='newmap.png' width='100%' height='85%'>";
        html += "<div class='w3-display-bottomleft w3-center w3-padding-large w3-hide-small'>";
        html += "<span class='w3-tag' style='font-size: 15px'>Last updated 4:00pm CEST, 22 April 2021</span> </div>";
        
        html += "<div style='width: 1000px; height: 450px; background-color: rgb(0, 0, 0, 0.6); position: absolute; left: 0; top: 0; bottom: 0; right: 0; margin: auto;'>";
        html += "<div class='w3-display-middle w3-center display: inline-block;' >";
        html += "<h6  style='font-size: 45px; color: aqua; text-shadow: 2px 2px #000000; white-space: nowrap;'><a href='/page2.html' style='text-decoration:none;'>" + TotalCases +
        " CONFIRMED CASES</a></h6>";
        html += "<h6  style='font-size:45px; color: rgb(255, 115, 0); text-shadow: 2px 2px #000000; white-space: nowrap;'><a href='/page3.html' style='text-decoration:none;'>" + TotalDeaths +  " DEATHS</a></h6>";
        html += "<h6 style='font-size:45px; color: rgb(255, 0, 0); text-shadow: 2px 2px #000000; white-space: nowrap;'>TOP 3 COUNTRIES MOST AT RISK</h6>";
        html += "<h6 style='font-size:35px; color: rgb(255, 255, 255); text-shadow: 2px 2px #000000; white-space: nowrap;'>1. " + Top3Country.get(0) + "</h6>";
        html += "<h6 style='font-size:35px; color: rgb(255, 255, 255); text-shadow: 2px 2px #000000; white-space: nowrap;'>2. " + Top3Country.get(1) +"</h6>";
        html += "<h6  style='font-size:35px; color: rgb(255, 255, 255); text-shadow: 2px 2px #000000; white-space: nowrap;'>3. "+ Top3Country.get(2) + "</h6> </div> </div>"; 
            
        html += "<div style='width: 250px; height: 55px; background-color: rgb(0, 0, 0, 0.5); position: absolute; left: 0; top: 550px; bottom: 0; right: 0; margin: auto;'>";
        html += "<h6 style='font-size:20px; color: rgb(255, 255, 255); text-shadow: 2px 2px #000000; text-align: center;'></h6> ";
        html += "<a style='text-decoration:none;";
        html += "color: rgb(255, 255, 255); text-shadow: 2px 2px #000000; text-align: center;'> <h6 style = 'font-size: 20px;'>VIEW WORLD MAP </h6></a> </div> </img> </header> ";
        /*
        // Add some Header information
        html = html + "<head>" + 
               "<title>Movies</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";

        // Add the body
        html = html + "<body>";

        // Add HTML for link back to the homepage
        html = html + "<h1>Page 1</h1>";
        html = html + "<p>Return to Homepage: ";
        html = html + "<a href='/'>Link to Homepage</a>";
        html = html + "</p>";

        // Look up some information from JDBC
        // First we need to use your JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();

        // Next we will ask this *class* for the movies
        ArrayList<String> movies = jdbc.getMovies();

        // Add HTML for the movies list
        html = html + "<h1>Movies</h1>" + "<ul>";

        // Finally we can print out all of the movies
        for (String movie : movies) {
            html = html + "<li>" + movie + "</li>";
        }

        // Finish the List HTML
        html = html + "</ul>"; */

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
