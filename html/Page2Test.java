package app;

import java.util.ArrayList;
import java.text.NumberFormat;

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
public class Page2 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/page2.html";

    @Override
    public void handle(Context context) throws Exception {
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<String> countries = jdbc.GetAllCountries();
        // Create a simple HTML webpage in a String
        //JDBCConnection jdbc = new JDBCConnection();

        // Next we will ask this *class* for the movies
        //ArrayList<String> movies = jdbc.getMovies();
        
        
        String html = "<!DOCTYPE html>"+
        "<html>"+
        "<head>" +
        "<title>Coronavirus Overview</title>"+
        "<meta charset=\"UTF-8\">"+
        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"+
        "<link rel=\"stylesheet\" href=\"w3.css\">"+
        "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Inconsolata\">"+
        "<link rel=\"stylesheet\" href=\"common.css\">"+
        "<link rel=\"stylesheet\" href=\"charts.min.css\">" +
        "<link rel=\"stylesheet\" href=\"dropdownsearch.css\">" +
        "<link rel='stylesheet' href='chosen.css'>" +
        "    <script type=\"text/javascript\" src='loader.js'></script>"+
        ""+
        "</head>" +
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
        "          <a href=\"/page4.html\">LOCATION AND CLIMATE</a>"+
        "          <a href=\"/page5.html\">SIMILAR COUNTRIES AND STATE</a>"+
        "          <a href=\"/page2.html\">INFECTIONS AND DEATHS</a>"+
        "          </div>"+
        "        </div>"+
        "    </div>"+
        "  </div>"+
        "</div>"+
        ""+
        "<div class=\" w3-large\" style = \"transform: translateY(150px);\">"+
        ""+
        "      <h5 class=\"w3-center \" style=\"font-size: 45px; padding-bottom: 25px; padding-top: 25px;\">COVID-19 Infections and Deaths</h5>"+
        "      <h5 class=\"w3-center \" style=\"font-size: 35px; padding-bottom: 20px; \">Country Data</h5>"+
        ""+
        "      <div style = \"text-align:center; \">"+
        "        <form action=\"/page2.html\" method=\"post\">"+
        "          <label for=\"datefrom\">Date From:</label>"+
        "          <input type=\"date\" id=\"datefrom\" name=\"datefrom\">"+
        "          <label for=\"dateto\">Date To:</label>"+
        "          <input type=\"date\" id=\"dateto\" name=\"dateto\">"+
        "      <select multiple data-placeholder=\"Select Countries To Compare...\" style=\"width: 225px;\" class=\"chosen-select\" >";
      


        for (int i = 0 ; i < countries.size() ; ++i) {
            html += "<option value=\"" + countries.get(i) + "\">" + countries.get(i) + "</option>";
        }
        

        html += "    </select>"+
        "          <input type=\"submit\">"+
        "          <a href=\"page2.html\"><input type=\"button\" value=\"Reset\"></a>" +
        "        </form>"+

     
	
	
        "    </div>"+
        ""+
        "    <p></p>"+

        "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>"+
       // search bar 1
        "<script>"+
        "$(document).ready(function(){"+
        "  $(\"#myInput\").on(\"keyup\", function() {"+
        "    var value = $(this).val().toLowerCase();"+
        "    $(\"#myTable2 tr\").filter(function() {"+
        "      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)"+
        "    });"+
        "  });"+
        "});"+
        "</script>" + 
            
        
        ""+
        "    <input type=\"text\" id=\"myInput\" placeholder=\"Search for country..\" title=\"Type in a name\" style=\"width: 1000px; text-align:center; margin: auto;"+
        "    display: block;\">"+
        "<p></p>" +

        "    <p></p>"+
        

        
      

        
        

        

        "</body>"+

        

        "</html>";

        String datefrom = context.formParam("datefrom");
        String dateto = context.formParam("dateto");

        if (datefrom == null && dateto == null) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22";
        }
            
        html = html + Table(datefrom, dateto);


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

    public String Table(String datefrom, String dateto) {
        NumberFormat myFormat = NumberFormat.getInstance();
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Integer> cases = jdbc.getCasesBetween(datefrom, dateto);
        ArrayList<Integer> deaths = jdbc.getDeathsBetween(datefrom, dateto);
        ArrayList<String> countries = jdbc.getCountryBetween(datefrom, dateto);
        String date1 = jdbc.getDate(datefrom);
        String date2 = jdbc.getDate(dateto);
        ArrayList<String> mostdate = jdbc.getMostCasesDate(datefrom, dateto);
        ArrayList<String> mostDeathDate = jdbc.getMostDeathsDate(datefrom, dateto);
        ArrayList<Integer> mostcases = jdbc.getMostCases(datefrom, dateto);
        ArrayList<Double> deathcase = jdbc.getCaseDeath();
        ArrayList<Integer> totaldeaths = jdbc.getTotalCountryDeath();

        String html = "";
 
        html += "    <script type=\"text/javascript\" src='loader.js'></script>";
        html += "<div class=\"w3-container\" id=\"menu\">"+
        "        <div class=\"w3-content\" style=\"max-width:1500px\">"+
        "        "+
        "          <div class=\"w3-row w3-center w3-card w3-padding\">"+
        "            <a href=\"javascript:void(0)\" onclick=\"openMenu(event, 'Infections');\" id=\"myLink\">"+
        "              <div class=\"w3-col s6 tablink\">Infections</div>"+
        "            </a>"+
        "            <a href=\"javascript:void(0)\" onclick=\"openMenu(event, 'Deaths');\">"+
        "              <div class=\"w3-col s6 tablink\">Deaths</div>"+
        "            </a>"+
        "          </div>";

       
        //Infections table
    
        html += "<div id=\"Infections\" class=\"w3-container menu w3-padding-48 \">" + "<table style=\"margin-left: auto; margin-right: auto; margin-top: -25px;\" class=\"fixed_header sortable\" id=\"myTable\">"+
        "        <thead>"+
        "        <tr>"+
        "<th>Countries</th>" +
        "<th>Date From</th>" +
        "<th>Date To</th>" +
        " <th>Cases</th>"+
        "<th >Date With Most Cases</th>" +
        "<th >Most Cases In A Day</th>" +
        "<th >Death/Cases %</th>" +
        "        </tr>"+
        "        </thead>";
        html += "<tbody id=\"myTable2\">";
        for (int i = 0 ; i < cases.size() ; ++i) {
            html += "<tr><td>" + countries.get(i) + "</td><td>" + date1 + "</td><td>" + date2 + "</td><td style=\"color: blue;\">" + myFormat.format(cases.get(i)) + "</td><td>" + mostdate.get(i) + "</td><td>" + myFormat.format(mostcases.get(i)) + 
            "</td><td>" + deathcase.get(i) + "%</td></tr>";
        }
        html += "</tbody>";
        html += "      </table>";

        html += " </div>";


        //Deaths table
        html += "<div id=\"Deaths\" class=\"w3-container menu w3-padding-48 \">" + "<table style=\"margin-left: auto; margin-right: auto;  margin-top: -25px;\" class=\"fixed_header sortable\" id=\"myTable\">"+
        "        <thead>"+
        "        <tr>"+
        "<th>Countries</th>" +
        "<th>Date From</th>" +
        "<th>Date To</th>" +
        "   <th >Deaths</th>"+
        "<th >Date With Most Deaths</th>" +
        "<th >Most Deaths In A Day</th>" +
        "<th >Death/Cases %</th>" +
        "        </tr>"+
        "        </thead>";
        html += "<tbody id=\"myTable2\">";
        for (int i = 0 ; i < cases.size() ; ++i) {
            html += "<tr><td>" + countries.get(i) + "</td><td>" + date1 + "</td><td>" + date2 + "</td><td style=\"color: red;\">" + myFormat.format(deaths.get(i)) + "</td><td>" + mostDeathDate.get(i) +"</td><td>" + myFormat.format(totaldeaths.get(i))  +
            "</td><td>" + deathcase.get(i) + "%</td></tr>";
        }
        html += "</tbody>";
        html += "      </table>";

        html += " </div>";

        html +=  "<img style=\"width:100%;max-width:1000px;margin-top:32px;\">"+
        "              </div>"+
        "            </div>";
        return html;
    }
}


