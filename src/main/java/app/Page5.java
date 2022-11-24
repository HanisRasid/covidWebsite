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
public class Page5 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/page5.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        JDBCConnection jdbc = new JDBCConnection();
        
        String html = "<!DOCTYPE html>"+
        "<html id=\"html\">"+
        "    <head>"+
        "        <meta charset=\"UTF-8\">"+
        "        <title>Coronavirus Overview</title>"+
        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
        "        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Inconsolata\">"+
        "        <link rel=\"stylesheet\" type 'text/css' href=\"w3.css\">"+
        "        <link rel=\"stylesheet\" type='text/css' href='common.css'>"+
        "        <link rel=\"stylesheet\" type= 'text/css' href=\"l3p2.css\">"+
        "        <script src=\"https://cdn.jsdelivr.net/npm/chart.js@3.3.2/dist/chart.min.js\"></script>" +
        "    </head>"+
        "    <body>"+
        "        <header>"+
        "            <!-- Navigation Bar (sits on top) -->"+
        "            <nav>"+
        "              <div class=\"w3-top\">"+
        "                <div class=\"w3-row w3-padding w3-black\">"+
        "                  <h1 style=\"text-align: center;\">COVID-19 CORONAVIRUS OVERVIEW</h1>"+
        "                  <div class=\"w3-col s3\" style=\"font-size: 22px;\">"+
        "                    <div class=\"dropdown w3-block w3-black\" style=\"border:none;display:inline-block;padding:8px 16px;vertical-align:middle;text-align:center;\">"+
        "                      <a class=\"dropbtn w3-button w3-block w3-black\" href =\"/\">HOME</a>"+
        "                    </div>"+
        "                  </div>"+
        "                  <div class=\"w3-col s3\" style=\"font-size: 22px;\">"+
        "                    <div class=\"dropdown w3-block w3-black\" style=\"border:none;display:inline-block;padding:8px 16px;vertical-align:middle;text-align:center;\">"+
        "                      <a class=\"dropbtn w3-button w3-block w3-black\" href=\"https://www.health.gov.au/news/health-alerts/novel-coronavirus-2019-ncov-health-alert/what-you-need-to-know-about-coronavirus-covid-19\" target=\"_blank\">WHAT IS COVID-19?</a>"+
        "                    </div>"+
        "                  </div>"+
        "                  <div class=\"w3-col s3\" style=\"font-size: 22px;\">"+
        "                    <div class=\"dropdown w3-block w3-black\" style=\"border:none;display:inline-block;padding:8px 16px;vertical-align:middle;text-align:center;\">"+
        "                      <a class=\"dropbtn w3-button w3-block w3-black\" href='/page2.html'>DEATH/CASES DATA</a>"+
        "                    </div>"+
        "                </div>"+
        "                  <div class=\"w3-col s3\" style=\"font-size: 22px;\">"+
        "                      <div class=\"dropdown w3-block w3-black\" style=\"border:none;display:inline-block;padding:8px 16px;vertical-align:middle;text-align:center;\">"+
        "                        <a class=\"dropbtn w3-button w3-block w3-black\" href=\"/page5.html\">SIMILAR COUNTRIES AND STATE DATA</a>"+

        "                      </div>"+
        "                  </div>"+
        "                </div>"+
        "              </div>"+
        "            </nav>"+
        "        </header>"+
        "        <main>"+
        "            <h1 class=\"heading\" style=\"font-family:arial\">Similar Countries and States</h1>"+
        "            <form action='/page5.html' method='post'>"+
        "              <label for='country'>Country:</label>"+
                        "<div>"+
        "                <select name = 'country' class=\"country\" id=\"country\">" +
        "<option value=\"none\" selected hidden disabled>Select a Country...</option>";
        html += getCountries();

        html += "                </select>"+
        "                </div>"+
        "                <br>"+
        "                <div class=\"state\">"+
        "                    <label for=\"state\">State (For USA only):</label><br>"+
        "                    <select name = 'state'  id=\"state\">"+
        "                      <option value=\"none\" selected hidden disabled>Select a State...</option>";
        html += getUSStates();
        html += "                    </select>"+
        "                </div>" +
        "                <br>"+
        "                <input type=\"submit\" value=\"Submit\">"+
        "                <input type=\"reset\">"+
        "            </form>"+
        "            <br><br>";
        
        String country = context.formParam("country");
        String state = context.formParam("state");
        String countryState = "";
        String countryStateImg = "";
        if(state != null) {
            countryState = state;
            countryStateImg = countryState.trim() + ".png";
        }
        if(country != null) {
            countryState = country;
            countryStateImg = countryState.trim() + ".gif";
        }

        double infecMil = jdbc.getCountryInfecMil(countryState);
        double deathCase = jdbc.GetCountryStateDeathCase(countryState);
        double peakCaseDate = jdbc.GetCountryStatePeakCaseDate(countryState);
        double peakDeathDate = jdbc.GetCountryStatePeakDeathDate(countryState);
        String peakCaseDateGreg = jdbc.GetCountryStatePeakCaseDateGregorian(countryState);
        String peakDeathDateGreg = jdbc.GetCountryStatePeakDeathDateGregorian(countryState);

        //CountryState information
        if(countryState != null) {
            html += "<div class=flex-container><span id=\"stats\"><h2>Country/State statistics</h2>" +
                "<h3>Country/State</h3>" + 
                "<h4>" + countryState +  "</h4>" +
                "<img  id=\"myImg\" src=\"" + countryStateImg.toLowerCase() + "\" alt=\"" + countryState + "\" width:\"300\" height:\"200\"/>" +
                "<h3>Infections per million</h3>" + 
                "<h4>"+ infecMil + "</h4>" + 
                "<h3>Death/Cases %</h3>" + 
                "<h4>"+ deathCase + "</h4>" + 
                "<h3>Date of peak cases</h3>" + 
                "<h4 id=\"blue\">"+ peakCaseDateGreg +  "</h4>" + 
                "<h3>Date of peak deaths</h3>" + 
                "<h4 id=\"red\">"+ peakDeathDateGreg + "</h4></span>";
        }


        html += "<div class=\"container\">" +
        "<canvas id=\"myChart\"></canvas>" +
        "</div></div><br><br>";

        ArrayList<String> days = jdbc.GetDays("2020-01-22", "2021-04-22");
        


        html += table(countryState, infecMil, deathCase, peakCaseDate, peakDeathDate);

        html += "<script>"+
        "        let myChart = document.getElementById('myChart').getContext('2d');"+
        ""+
        "        let lineChart = new Chart(myChart, {"+
        "            type:'line',"+
        "            data:{";
        html += " labels:[";

        for (int i = 0 ; i < days.size() ; ++i) {
            html += "\"" + ChangeDateFormat(days.get(i)) + "\",";
        }

        html += "],";
        html += "                datasets:[{"+
        "                    label:'Daily Cases',";

        ArrayList<Integer> dailyCases = jdbc.getDailyCasesArrayList(countryState);


        html +="                    data:[";

        for (int i = 0 ; i < dailyCases.size() ; ++i) {
            html += dailyCases.get(i) + ",";
        }

        html += "],";

        html += "radius: 0," +
        "                    borderColor:'green',"+
        "                    borderJoinStyle: 'round',"+
        "                    fill: { target: 'origin', above:'rgba(29, 227, 112, 0.4)' }"+
        "                }]"+
        "            },"+
        "            options:" + 
        "                   {"+
        "                maintainAspectRatio:false," +
        "                responsive: true," +
        "                legend:{"+
        "                    position:'top',"+
        "                },"+
        "                tooltips: {"+
        "                    mode: 'index',"+
        "                    intersect: false,"+
        "                },"+
        "                interaction: {"+
        "                    mode: 'index',"+
        "                    intersect: false,"+
        "                },"+
        "                hover: {"+
        "                    mode: 'index',"+
        "                    intersect: false"+
        "                }"+
        "            }"+
        "        });"+
        "    </script>";
	
	

        html += "        </main>"+
        "    </body>"+
        "</html>";

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

    public String ChangeDateFormat(String date) {
        String[] datelist = date.split("-");

        String newdate = datelist[2] + "/" + datelist[1] + "/" + datelist[0];

        return newdate;
    }

    public String getCountries() {
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<String> countries = jdbc.GetAllCountries();
        String html = null;

        for(int i=0; i < countries.size(); i++) {
            html += "<option>" + countries.get(i) + "</option>";
        }
        return html;
    }

    public String getUSStates() {
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<String> states = jdbc.GetAllUSStates();
        String html = null;

        for(int i=0; i < states.size(); i++) {
            html += "<option>" + states.get(i) + "</option>";
        }
        return html;
    }

    public String table(String countryState, double infecMil, double deathCase, double peakCaseDate, double peakDeathDate) {
        JDBCConnection jdbc = new JDBCConnection();
            String html = "<table style=\"width:80%\">"+
        "                <caption>Most similar countries/state data (Arranged in order of similarity)</caption>"+
        "                <thead>"+
        "                  <tr>"+
        "                    <th colspan =\"2\">Most similar infections per million</th>"+
        "                    <th colspan=\"2\">Most similar Death/Cases %</th>"+
        "                    <th colspan=\"2\">Most similar peak daily infections <br>(Within a range of 5 days)</th>"+
        "                    <th colspan =\"2\">Most similar peak daily deaths <br>(Within a range of 5 days)</th>"+
        "                  </tr>"+
        "                  <tr>"+
        "                    <th>Country/State</th>"+
        "                    <th>Infections per million</th>"+
        "                    <th>Country/State</th>"+
        "                    <th>Death/Cases %</th>"+
        "                    <th>Country/State</th>"+
        "                    <th>Peak daily infection</th>"+
        "                    <th>Country/State</th>"+
        "                    <th>Peak daily deaths</th>"+
        "                  </tr>"+
        "                </thead>"+
        "                <tbody>";

        ArrayList<String> countriesInfecName =  jdbc.GetCountryAndStatesInfectionsPerMillionName(countryState, infecMil);
        ArrayList<Double> countriesInfecData = jdbc.GetCountryAndStatesInfectionsPerMillion(countryState, infecMil);
        ArrayList<String> deathCasesName = jdbc.GetCountryStateDeathCasesName(countryState, deathCase);
        ArrayList<Double> deathCasesData = jdbc.GetCountryStateDeathCasesData(countryState, deathCase);
        ArrayList<String> peakCaseNames = jdbc.GetCountryStatePeakCasesName(countryState, peakCaseDate);
        ArrayList<String> peakCasesDates = jdbc.GetCountryStatePeakCasesDates(countryState, peakCaseDate);
        ArrayList<String> peakDeathNames = jdbc.GetCountryStatePeakDeathsName(countryState, peakDeathDate);
        ArrayList<String> peakDeathDates = jdbc.GetCountryStatePeakDeathsDates(countryState, peakDeathDate);
        for(int i=0; i < countriesInfecName.size(); i++) {
            html += "<tr><td>" + countriesInfecName.get(i) + "</td>" + "<td>" + countriesInfecData.get(i) + "</td><td>" + deathCasesName.get(i) + "</td><td>" + deathCasesData.get(i) + "</td><td>" + 
                    peakCaseNames.get(i) + "</td><td>" + ChangeDateFormat(peakCasesDates.get(i)) + "</td><td>" + peakDeathNames.get(i) + "</td><td>" + ChangeDateFormat(peakDeathDates.get(i)) + "</td></tr>";
        }


        html += "                </tbody>"+
        "            </table>" +
        "           <br><br>";

        return html;
    }

}
