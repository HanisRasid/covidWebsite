package app;

import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.util.Random;

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
        ArrayList<String> statecountry = jdbc.GetAllCountriesWithStates();
        ArrayList<String> state = jdbc.GetStates();
        


    

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
        "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.3.2/chart.js\"></script> "+
  
        "<style> button:hover{ background: #787878;} </style>" +
        
                "<style>"+
        "#myBtn {"+
        "  display: none;"+
        "  position: fixed;"+
        "  bottom: 20px;"+
        "  right: 30px;"+
        "  z-index: 99;"+
        "  font-size: 18px;"+
        "  border: none;"+
        "  outline: none;"+
        "  background-color: #333333;"+
        "  color: white;"+
        "  cursor: pointer;"+
        "  padding: 15px;"+
        "  border-radius: 4px;"+
        "}"+
        ""+
        "#myBtn:hover {"+
        "  background-color: #8f8f8f;"+
        "}"+
        "</style>" +
	

	

 
        ""+
        "</head>" +
        "<body>"+
        "<button onclick=\"topFunction()\" id=\"myBtn\" title=\"Go to top\">Top</button>" +
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
        "        <a href='https://www.health.gov.au/news/health-alerts/novel-coronavirus-2019-ncov-health-alert/what-you-need-to-know-about-coronavirus-covid-19' class=\"dropbtn w3-button w3-block w3-black\">WHAT IS COVID-19?</a>"+
        ""+
        "      </div>"+
        "  </div>"+
        "    <div class=\"w3-col s3\" style=\"font-size: 22px;\">"+
        "      <div class=\"dropdown w3-block w3-black\" style=\"border:none;display:inline-block;padding:8px 16px;vertical-align:middle;text-align:center;\">"+
        "        <a class=\"dropbtn w3-button w3-block w3-black\" href='/page2.html'>DEATH/CASES DATA</a>"+
        ""+
        "      </div>"+
        "  </div>"+
        "    <div class=\"w3-col s3\" style=\"font-size: 22px;\">"+
        "        <div class=\"dropdown w3-block w3-black\" style=\"border:none;display:inline-block;padding:8px 16px;vertical-align:middle;text-align:center;\">"+
        "          <a class=\"dropbtn w3-button w3-block w3-black\" href=\"/page5.html\">SIMILAR COUNTRIES AND STATE DATA</a>"+

        "        </div>"+
        "    </div>"+
        "  </div>"+
        "</div>"+
        ""+
        "<div class=\" w3-large\" style = \"transform: translateY(150px);\">"+
      
        ""+
        "      <h5 class=\"w3-center \" style=\"font-size: 45px; padding-bottom: 25px; padding-top: 25px; font-family:arial\">COVID-19 Infections and Deaths</h5>"+
        "      <h5 class=\"w3-center \" style=\"font-size: 35px; padding-bottom: 20px; \">Country Data</h5>"+
        ""+
        "      <div style = \"text-align:center; \">"+
        "        <form action=\"/page2.html\" method=\"post\">"+ 
        "<input style='width: 134px; font-size: 15px' placeholder=\"Date From\" class=\"textbox-n\" type=\"text\" onfocus=\"(this.type='date')\" id=\"datefrom\" name=\"datefrom\">" + 
        " " +
        "<input style='width: 134px; font-size: 15px' placeholder=\"Date To\" class=\"textbox-n\" type=\"text\" onfocus=\"(this.type='date')\" id=\"dateto\" name=\"dateto\">" + 
       /* "          <label for=\"datefrom\">Date From:</label>"+
        "          <input type=\"date\" id=\"datefrom\" name=\"datefrom\">"+
        "          <label for=\"dateto\">Date To:</label>"+
        "          <input type=\"date\" id=\"dateto\" name=\"dateto\">"+ */
        "      <select multiple data-placeholder=\"Select Countries To Compare...\" style=\"width: 300px;\" class=\"chosen-select\" name=\"country_drop\" id=\"country_drop\" >";
      


        for (int i = 0 ; i < countries.size() ; ++i) {
            html += "<option>" + countries.get(i) + "</option>";
        }
        

        html += "    </select>"+
        
        "<span  unselectable=\"on\" onselectstart=\"return false;\" onmousedown=\"return false;\" style =\"background-color: #2e2e2e; margin-left: 10px; padding-right: 10px; padding-top: 8px; padding-bottom: 8px\">" +
        "  <label for=\"simclimate\" style=\"color: white;\">Compare With Similar Climate Countries</label> <input type=\"checkbox\" id=\"simclimate\" name=\"simclimate\" value=\"yessimclimate\">" +
        "</span>" + 
        "<span  unselectable=\"on\" onselectstart=\"return false;\" onmousedown=\"return false;\" style =\"background-color: #2e2e2e; margin-left: 10px; padding-right: 10px; padding-top: 8px; padding-bottom: 8px\">" +
        "  <label for=\"nearcountry\" style=\"color: white;\">Compare With Nearest Countries</label> <input type=\"checkbox\" id=\"nearcountry\" name=\"nearcountry\" value=\"yesnearcountry\">" +
        "</span>" + 

        "        <button type=\"submit\" class=\"btn\" style=\"height: 40px\">Submit</button>"+
        "        <button type=\"refresh\" class=\"btn\" style=\"height: 40px\">Reset</button>"+
        "        </form>"+

        "<p id = \"ClimateCheck\" style=\"color: red;\"></p>" +
	
	
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

        "    <p></p>";
        
        
        
        



        List<String> selectedCountry = context.formParams("country_drop");
        ArrayList<String> selectedCountries = new ArrayList<String>();
        for (int i = 0 ; i < selectedCountry.size(); ++i) {
                selectedCountries.add(selectedCountry.get(i));
        }

        String datefrom = context.formParam("datefrom");
        String dateto = context.formParam("dateto");

        String nearcountrycheck = context.formParam("nearcountry");
        String simclimatecheck = context.formParam("simclimate");

        if ((datefrom == null || dateto == null)) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22";
        }
        if (selectedCountries.isEmpty()) {
            for (int i = 0 ; i < countries.size() ; ++i) {
                selectedCountries.add(countries.get(i));
            }
        }
            
     

        html = html + Table(datefrom, dateto, selectedCountries, simclimatecheck, nearcountrycheck);

        html += " <div style=\"width: 1500px; margin-left: auto; margin-right: auto; margin-top: -100px; margin-bottom: 50px\"><canvas id=\"myChart5\" style=\"width:1500px !important; height:450px !important; \"></canvas></div>";

        
        html += "<div id=\"statetable\" style=\"text-align: center; position: absolute; top: 1300px; left: 0;\"></div>";
        
        html += "<div style = \"transform: translateY(0px);\">";

        html += "      <h5 class=\"w3-center \" style=\"font-size: 35px; padding-bottom: 20px;\">State Data</h5>";

        html += "<script>"+
        "$(document).ready(function(){"+
        "  $(\"#myInput3\").on(\"keyup\", function() {"+
        "    var value = $(this).val().toLowerCase();"+
        "    $(\"#myTable3 tr\").filter(function() {"+
        "      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)"+
        "    });"+
        "  });"+
        "});"+
        "</script>";
            
        
        
        html += ""+
        "    <input type=\"text\" id=\"myInput3\" placeholder=\"Search for state..\" title=\"Type in a name\" style=\"width: 1000px; text-align:center; margin: auto;"+
        "    display: block;\">"+
        "    <p></p>";
       

        html += "<div class=\"flex-container\">"+
        "  <div class=\"flex-item-left\">"+
        ""+ 
        "<div class=\"container\">"+
    
        "      <h5 style=\"font-weight: bold;\">Select Countries</h5>"+
        "      <form action=\"#statetable\" method=\"post\" >"+
        "      <select multiple data-placeholder=\"Select...\" style=\"width: 275px;\" class=\"chosen-select\"  id=\"country_drop2\" name=\"country_drop2\">";


                
        for (int i = 0 ; i < statecountry.size() ; ++i) {
            html += "<option>" + statecountry.get(i) + "</option>";
        }

        
        html += "    </select>"+
        "      <h5 style=\"font-weight: bold;\">Select States</h5>"+

        "      <select multiple data-placeholder=\"Select...\" style=\"width: 275px;\" class=\"chosen-select\" name=\"state_drop\" id=\"state_drop\" >";
 
        for (int i = 0 ; i < state.size() ; ++i) {
            html += "<option>" + state.get(i) + "</option>";
        }

        html += "    </select>"+
        

        "      <h5 style=\"font-weight: bold;\">Select Dates</h5>"+
        "<input style='width: 135px;' placeholder=\"From\" class=\"textbox-n\" type=\"text\" onfocus=\"(this.type='date')\" id=\"datefrom2\" name=\"datefrom2\">" + 
        " " +
        "<input style='width: 135px;' placeholder=\"To\" class=\"textbox-n\" type=\"text\" onfocus=\"(this.type='date')\" id=\"dateto2\" name=\"dateto2\">" + 
        "<br><br>" +

        "        <button type=\"submit\" class=\"btn\">Submit</button>"+
        "        <button type=\"refresh\" class=\"btn\">Reset</button>"+
        "      </form>"+
        "    </div>" +
        
        
        "  </div>"; 

        List<String> selectedCountry2 = context.formParams("country_drop2");
        ArrayList<String> selectedCountries2 = new ArrayList<String>();
        
        for (int i = 0 ; i < selectedCountry2.size(); ++i) {
                selectedCountries2.add(selectedCountry2.get(i));
        }

        if (selectedCountries2.isEmpty()) {
            for (int i = 0 ; i < statecountry.size() ; ++i) {
                selectedCountries2.add(statecountry.get(i));
            }
        }

        List<String> selectedState = context.formParams("state_drop");
        ArrayList<String> selectedStates = new ArrayList<String>();

        for (int i = 0 ; i < selectedState.size() ; ++i) {
            selectedStates.add(selectedState.get(i));
        }

        if (selectedStates.isEmpty()) {
            for (int i = 0 ; i < state.size() ; ++i) {
                selectedStates.add(state.get(i));
            }
        }

        String datefrom2 = context.formParam("datefrom2");
        String dateto2 = context.formParam("dateto2");

        if ((datefrom2 == null || dateto2 == null)) {
            datefrom2 = "2020-01-22";
            dateto2 = "2021-04-22"; 
        } 

        html += "  <div class=\"flex-item-right\">"+

        "    <table  class=\"fixed_header2 sortable\" id=\"myTable\" style=\"width: 1100px; font-size: 15px;\">"+
        "      <thead>"+
        "      <tr>"+
        "        <th>State</th>"+
        "        <th>Date From</th>"+
        "        <th>Date To</th>"+
        "        <th>Cases</th>"+
        "        <th>Deaths</th>"+
        "        <th>Date With Most Cases</th>"+
        "        <th>Most Cases In A Day</th>"+
        "        <th>Date With Most Deaths</th>"+
        "        <th>Most Deaths In A Day</th>"+
        "        <th>Death/Cases %</th>"+
        "      </tr>"+
        "      </thead>"+
        "<tbody id=\"myTable3\">";

        html = html + Table2(datefrom2, dateto2, selectedCountries2, selectedStates); 

        html += "</tbody>" +
        "    </table>"+
        "  </div>"+
        "</div>";

        // chart

        html += "<div id=\"chart1\" style=\"text-align: center; position: absolute; top: 500px; left: 0;\"></div>";

        html += "      <h5 class=\"w3-center \" style=\"font-size: 35px; margin-bottom: 50px\"><span id=\"charttitle1\"></span><span id=\"charttitle1\"></span></h5>";

        html +=    "      <div style = \"text-align:center; margin-bottom: 50px\">"+
        "        <form action=\"#chart1\" method=\"post\">"+
        "<input style='width: 134px; font-size: 15px' placeholder=\"Date From\" class=\"textbox-n\" type=\"text\" onfocus=\"(this.type='date')\" id=\"datefrom3\" name=\"datefrom3\">" + 
        " " +
        "<input style='width: 134px; font-size: 15px' placeholder=\"Date To\" class=\"textbox-n\" type=\"text\" onfocus=\"(this.type='date')\" id=\"dateto3\" name=\"dateto3\">" + 
        /*"          <label for=\"datefrom3\">Date From:</label>"+
        "          <input type=\"date\" id=\"datefrom3\" name=\"datefrom3\">"+
        "          <label for=\"dateto3\">Date To:</label>"+
        "          <input type=\"date\" id=\"dateto3\" name=\"dateto3\">"+ */
        "      <select multiple data-placeholder=\"Select Countries To Compare...\" style=\"width: 300px;\" class=\"chosen-select\" name=\"country_drop3\" id=\"country_drop3\" >";
      


        for (int i = 0 ; i < countries.size() ; ++i) {
            html += "<option>" + countries.get(i) + "</option>";
        }
        

        html += "    </select>"+
        
        "<span  unselectable=\"on\" onselectstart=\"return false;\" onmousedown=\"return false;\" style =\"background-color: #2e2e2e; margin-left: 10px; padding-right: 10px; padding-top: 8px; padding-bottom: 8px\">" +
        "  <label for=\"global\" style=\"color: white;\">Compare With Global Data</label> <input type=\"checkbox\" id=\"global\" name=\"global\" value=\"globalyes\">" +
        "</span>" + 

        "<span  unselectable=\"on\" onselectstart=\"return false;\" onmousedown=\"return false;\" style =\"background-color: #2e2e2e; margin-left: 10px; padding-right: 10px; padding-top: 8px; padding-bottom: 8px\">" +
        "  <label for=\"simclimate2\" style=\"color: white;\">Compare With Similar Climate Countries</label> <input type=\"checkbox\" id=\"simclimate2\" name=\"simclimate2\" value=\"true\">" +
        "</span>" + 
        "<span  unselectable=\"on\" onselectstart=\"return false;\" onmousedown=\"return false;\" style =\"background-color: #2e2e2e; margin-left: 10px; padding-right: 10px; padding-top: 8px; padding-bottom: 8px\">" +
        "  <label for=\"nearcountry2\" style=\"color: white;\">Compare With Nearest Countries</label> <input type=\"checkbox\" id=\"nearcountry2\" name=\"nearcountry2\" value=\"true\">" +
        "</span>" + 
        "<br><br>" +
        "        <button type=\"submit\" class=\"btn\" style=\"height:  35px\">Submit</button>"+
        "        <button type=\"refresh\" class=\"btn\" style=\"height: 35px\">Reset</button>"+
        "        </form>"+

        "<p id=\"ClimateCheck2\" style=\"color: red;\"></p>" +
        "    </div>";

        List<String> selectedChartCountry = context.formParams("country_drop3");
        ArrayList<String> selectedChartCountries = new ArrayList<String>();
        
        for (int i = 0 ; i < selectedChartCountry.size(); ++i) {
                selectedChartCountries.add(selectedChartCountry.get(i));
        }



       String globalcheck = context.formParam("global");
      
       String nearcountrycheck2 = context.formParam("nearcountry2");
       String simclimatecheck2 = context.formParam("simclimate2");


        String datefrom3 = context.formParam("datefrom3");
        String dateto3 = context.formParam("dateto3");

        if ((datefrom3 == null || dateto3 == null)) {
            datefrom3 = "2020-01-22";
            dateto3 = "2021-04-22"; 
        } 

        html += "</div>";

                html += "<div class=\"w3-container\" id=\"menu2\" style=\"margin-top: 0px\">"+
                "        <div class=\"w3-content\" style=\"max-width:1500px\">"+
                "            <div class=\"w3-row w3-center w3-card w3-padding\" style=\"width: 250px; padding: 5px\">"+
                "                <a href=\"javascript:void(0)\" onclick=\"openMenu2(event, 'Infections2');\" id=\"myLink2\">"+
                "                  <div class=\"w3-col s6 tablink2\">Cases</div>"+
                "                </a>"+
                "                <a href=\"javascript:void(0)\" onclick=\"openMenu2(event, 'Deaths2');\">"+
                "                  <div class=\"w3-col s6 tablink2\">Deaths</div>"+
                "                </a>"+
                "              </div>"+
                "<div style=\"margin-left: 25px; margin-top: 10px\"><button class = \"btn\" onclick=\"updateDailyChart(myChart); ChangeChartTitle(); updateDailyChart2(myChart2);\" style=\"font-size: 15px; height:35px\">Daily</button>" +
                "<button class = \"btn\" onclick=\"updateCumulativeChart(myChart); ChangeChartTitle2(); updateCumulativeChart2(myChart2); \" style=\"font-size: 15px; margin-left: 15px; height:35px\">Cumulative</button></div>"+
                "                "+
                "        <div id=\"Infections2\" class=\"w3-container menu2\" style=\"padding-top: 0px;\">"+
                "            <canvas id=\"myChart\" style=\"width:1000px !important; height:450px !important;\"></canvas>"+
                "        </div>"+
                ""+
                "        <div id=\"Deaths2\" class=\"w3-container menu2\" style=\"padding-top: 0px;\">"+
                "            <canvas id=\"myChart2\" style=\"width:1000px !important; height:450px !important;\"></canvas>"+
                "            </div>"+
                "        </div>"+
                "    </div>";

                html += "      <h5 class=\"w3-center \" style=\"font-size: 35px; margin-bottom: 20px;  margin-top: 50px\"><span id=\"charttitle2\"></span><span id=\"charttitle2\"></h5>";

                html += "<div class=\"w3-container\" id=\"menu3\" style=\"margin-top: 0px\">"+
                "        <div class=\"w3-content\" style=\"max-width:1500px;\">"+
                "            <div class=\"w3-row w3-center w3-card w3-padding\" style=\"width: 250px; padding: 5px\">"+
                "                <a href=\"javascript:void(0)\" onclick=\"openMenu3(event, 'Infections3');\" id=\"myLink3\">"+
                "                  <div class=\"w3-col s6 tablink3\">Cases</div>"+
                "                </a>"+
                "                <a href=\"javascript:void(0)\" onclick=\"openMenu3(event, 'Deaths3');\">"+
                "                  <div class=\"w3-col s6 tablink3\">Deaths</div>"+
                "                </a>"+
                "              </div>"+ 
                "<div style=\"margin-left: 25px; margin-top: 10px\"><button class = \"btn\" onclick=\"ChangeChartTitle3(); updateDailyChart3(myChart3); updateDailyChart4(myChart4)\" style=\"font-size: 15px; height:35px\">Daily</button>" +
                "<button class = \"btn\" onclick=\"ChangeChartTitle4(); updateCumulativeChart3(myChart3); updateCumulativeChart4(myChart4)\" style=\"font-size: 15px; margin-left: 15px; height:35px\">Cumulative</button></div>"+
                "                "+
                "        <div id=\"Infections3\" class=\"w3-container menu3\" style=\"padding-top: 20px;\">"+
                "            <canvas id=\"myChart3\" style=\"width:1000px !important; height:400px !important;\"></canvas>"+
                "        </div>"+
                ""+
                "        <div id=\"Deaths3\" class=\"w3-container menu3\" style=\"padding-top: 20px;\">"+
                "            <canvas id=\"myChart4\" style=\"width:1000px !important; height:400px !important;\"></canvas>"+
                "            </div>"+
                "        </div>"+
                "    </div>" +
                                    
            

                "<br>";

                // java script 

                html += LineChartCaseCheck(selectedChartCountries, globalcheck, simclimatecheck2, nearcountrycheck2);

                html += "<script>" +
                "  document.getElementById(\"charttitle1\").innerHTML = \"Country Daily Situation\";"+
                "function ChangeChartTitle() {"+
                "  document.getElementById(\"charttitle1\").innerHTML = \"Country Daily Situation\";"+
                "}"+
                ""+
                "function ChangeChartTitle2() {"+
                "  document.getElementById(\"charttitle1\").innerHTML = \"Country Cumulative Situation\";"+
                "}" +
                "</script>";


                html += "<script>" +
                "  document.getElementById(\"charttitle2\").innerHTML = \"State Daily Situation\";"+
                "function ChangeChartTitle3() {"+
                "  document.getElementById(\"charttitle2\").innerHTML = \"State Daily Situation\";"+
                "}"+
                ""+
                "function ChangeChartTitle4() {"+
                "  document.getElementById(\"charttitle2\").innerHTML = \"State Cumulative Situation\";"+
                "}" +
                "</script>";

           
	
 

                html +="<script>"+
                "        var ctx = document.getElementById('myChart').getContext('2d');"+
                ""+
                "       "+
                "       "+
                "        var myChart = new Chart(ctx, {"+
                "            type:'line',"+
                "            data:{";

                html = html + Days(datefrom3, dateto3);
                
                html += "                datasets:[";
                
               
                
                html = html + LineChartCase(datefrom3, dateto3, selectedChartCountries, globalcheck, simclimatecheck2, nearcountrycheck2); 

                html += "        ]";

      

                html += "            },"+
                "            options:{"+
                "                responsive: true,"+
                "                plugins: {"+
                "                    legend: {"+
                "                        position: 'top',"+
                "                    },"+
                "                },"+
                "                scales: {"+
                "                    x: {"+
                "                    display: true,"+
                "                    title: {"+
                "                        display: true,"+
                "                        text: 'Date',"+
                "                        font: {"+
                "                            size: 25,"+
                "                            fontColor: 'black'"+
                "                        }"+
                "                        }"+
                "                    },"+
                "                    y: {"+
                "                    display: true,"+
                "                    beginAtZero: true," +
                "                    min: 0," +
                "                    title: {"+
                "                        display: true,"+
                "                        text: 'Cases',"+
                "                        font: {"+
                "                            size: 25,"+
                "                            fontColor: 'black'"+
                "                        }"+
                "                        }"+
                "                    }"+
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
                "        });";

                ArrayList<String> DailyCountryCases = LineChartCaseDaily(datefrom3, dateto3, selectedChartCountries, globalcheck, simclimatecheck2, nearcountrycheck2);
                ArrayList<String> CumulativeCountryCases = LineChartCaseCumulative(datefrom3, dateto3, selectedChartCountries, globalcheck, simclimatecheck2, nearcountrycheck2);
      

                html += "    function updateDailyChart(myChart) {";

                for (int i = 0 ; i < DailyCountryCases.size() ; ++i) {
                    html += " myChart.data.datasets["+ i +"].data = "+ DailyCountryCases.get(i) +"";
                }
            
                html += "    myChart.update();"+
               " };";

               html += "    function updateCumulativeChart(myChart) {";

               for (int i = 0 ; i < CumulativeCountryCases.size() ; ++i) {
                   html += " myChart.data.datasets["+ i +"].data = "+ CumulativeCountryCases.get(i) +"";
               }
    
               html += "    myChart.update();"+
              " };";
            
                html += "    </script>"+
                ""+


                "    <script>"+
                "        var ctx = document.getElementById('myChart2').getContext('2d');"+
                ""+
                "        "+
                ""+
                "       var myChart2 = new Chart(ctx, {"+
                "            type:'line',"+
                "            data:{";

                html = html + Days(datefrom3, dateto3);
                
                html += "                datasets:[";
                
                
                html = html + LineChartDeath(datefrom3, dateto3, selectedChartCountries, globalcheck, simclimatecheck2, nearcountrycheck2); 

                html += "        ]";
       


                html += "            },"+
                "            options:{"+
                "                responsive: true,"+
                "                plugins: {"+
                "                    legend: {"+
                "                        position: 'top',"+
                "                    },"+
                "                },"+
                "                scales: {"+
                "                    x: {"+
                "                    display: true,"+
                "                    title: {"+
                "                        display: true,"+
                "                        text: 'Date',"+
                "                        font: {"+
                "                            size: 25,"+
                "                            fontColor: 'black'"+
                "                        }"+
                "                        }"+
                "                    },"+
                "                    y: {"+
                "                    display: true,"+
                "                    beginAtZero: true," +
                "                    min: 0, " +
                "                    title: {"+
                "                        display: true,"+
                "                        text: 'Deaths',"+
                "                        font: {"+
                "                            size: 25,"+
                "                            fontColor: 'black'"+
                "                        }"+
                "                        }"+
                "                    }"+
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
                "        });";

                ArrayList<String> DailyCountryDeaths = LineChartDeathDaily(datefrom3, dateto3, selectedChartCountries, globalcheck, simclimatecheck2, nearcountrycheck2);
                ArrayList<String> CumulativeCountryDeaths = LineChartDeathCumulative(datefrom3, dateto3, selectedChartCountries, globalcheck, simclimatecheck2, nearcountrycheck2);

                html += "    function updateDailyChart2(myChart2) {";

                for (int i = 0 ; i < DailyCountryDeaths.size() ; ++i) {
                    html += " myChart2.data.datasets["+ i +"].data = "+ DailyCountryDeaths.get(i) +"";
                }
            
                html += "    myChart2.update();"+
               " };";

               html += "    function updateCumulativeChart2(myChart2) {";

               for (int i = 0 ; i < CumulativeCountryDeaths.size() ; ++i) {
                   html += " myChart2.data.datasets["+ i +"].data = "+ CumulativeCountryDeaths.get(i) +"";
               }
    
               html += "    myChart2.update();"+
              " };" +
            


                "    </script>";
                

                
                html +="<script>"+
                "        var ctx = document.getElementById('myChart3').getContext('2d');"+
                ""+
                "       "+
                "       "+
                "        var myChart3 = new Chart(ctx, {"+
                "            type:'line',"+
                "            data:{";

                html = html + Days(datefrom3, dateto3);
                
                html += "                datasets:[";
                
               
                
                html = html + LineChartCase2(datefrom3, dateto3, selectedChartCountries); 

                html += "        ]";

      

                html += "            },"+
                "            options:{"+
                "                responsive: true,"+
                "                plugins: {"+
                "                    legend: {"+
                "                        position: 'top',"+
                "                    },"+
                "                },"+
                "                scales: {"+
                "                    x: {"+
                "                    display: true,"+
                "                    title: {"+
                "                        display: true,"+
                "                        text: 'Date',"+
                "                        font: {"+
                "                            size: 25,"+
                "                            fontColor: 'black'"+
                "                        }"+
                "                        }"+
                "                    },"+
                "                    y: {"+
                "                    display: true,"+
                "                    beginAtZero: true," +
                "                    min: 0," +
                "                    title: {"+
                "                        display: true,"+
                "                        text: 'Cases',"+
                "                        font: {"+
                "                            size: 25,"+
                "                            fontColor: 'black'"+
                "                        }"+
                "                        }"+
                "                    }"+
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
                "        });";
               
                ArrayList<String> DailyStateCases = LineChartStateCaseDaily(datefrom3, dateto3, selectedChartCountries);
                ArrayList<String> CumulativeStateCases = LineChartStateCaseCumulative(datefrom3, dateto3, selectedChartCountries);
      
               
                html += "    function updateDailyChart3(myChart3) {";

                for (int i = 0 ; i < DailyStateCases.size() ; ++i) {
                    html += " myChart3.data.datasets["+ i +"].data = "+ DailyStateCases.get(i) +"";
                }
            
                html += "    myChart3.update();"+
               " };";
                
               html += "    function updateCumulativeChart3(myChart3) {";

               for (int i = 0 ; i < CumulativeStateCases.size() ; ++i) {
                   html += " myChart3.data.datasets["+ i +"].data = "+ CumulativeStateCases.get(i) +"";
               }
    
               html += "    myChart3.update();"+
              " };"; 
              
                html += "    </script>";

                html += "    <script>"+
                "        var ctx = document.getElementById('myChart4').getContext('2d');"+
                ""+
                "        "+
                ""+
                "        var myChart4 = new Chart(ctx, {"+
                "            type:'line',"+
                "            data:{";

                html = html + Days(datefrom3, dateto3);
                
                html += "                datasets:[";
                
                
                html = html + LineChartDeath2(datefrom3, dateto3, selectedChartCountries); 

                html += "        ]";
       


                html += "            },"+
                "            options:{"+
                "                responsive: true,"+
                "                plugins: {"+
                "                    legend: {"+
                "                        position: 'top',"+
                "                    },"+
                "                },"+
                "                scales: {"+
                "                    x: {"+
                "                    display: true,"+
                "                    title: {"+
                "                        display: true,"+
                "                        text: 'Date',"+
                "                        font: {"+
                "                            size: 25,"+
                "                            fontColor: 'black'"+
                "                        }"+
                "                        }"+
                "                    },"+
                "                    y: {"+
                "                    display: true,"+
                "                    beginAtZero: true," +
                "                    min: 0, " +
                "                    title: {"+
                "                        display: true,"+
                "                        text: 'Deaths',"+
                "                        font: {"+
                "                            size: 25,"+
                "                            fontColor: 'black'"+
                "                        }"+
                "                        }"+
                "                    }"+
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
                "        });";

                ArrayList<String> DailyStateDeaths = LineChartStateDeathDaily(datefrom3, dateto3, selectedChartCountries);
                ArrayList<String> CumulativeStateDeaths = LineChartStateDeathCumulative(datefrom3, dateto3, selectedChartCountries);
      
               
                html += "    function updateDailyChart4(myChart4) {";

                for (int i = 0 ; i < DailyStateDeaths.size() ; ++i) {
                    html += " myChart4.data.datasets["+ i +"].data = "+ DailyStateDeaths.get(i) +"";
                }
            
                html += "    myChart4.update();"+
               " };";
                
               html += "    function updateCumulativeChart4(myChart4) {";

               for (int i = 0 ; i < CumulativeStateDeaths.size() ; ++i) {
                   html += " myChart4.data.datasets["+ i +"].data = "+ CumulativeStateDeaths.get(i) +"";
               }
    
               html += "    myChart4.update();"+
              " };"; 

                html += "    </script>";

               

                html += "<script>"+
                "    let myChart5 = document.getElementById('myChart5').getContext('2d');"+
                ""+
                "    let massPopChart5 = new Chart(myChart5, {"+
                "        type:'bar',"+
                "        data:{"+
                "            labels: [" + CountryName(selectedCountries, simclimatecheck, nearcountrycheck) + "],"+
                "  datasets: [{"+
                "    label: 'Total Cases',"+
                "    data: ["+ TotalCases(selectedCountries, simclimatecheck, nearcountrycheck) +"],"+
                "    backgroundColor: ["+
                "    'rgba(0, 150, 255, 0.75)',"+
                "      'rgba(0, 150, 255, 0.75)',"+
                "      'rgba(0, 150, 255, 0.75)',"+
                "      'rgba(0, 150, 255, 0.75)',"+
                "      'rgba(0, 150, 255, 0.75)',"+
                "      'rgba(0, 150, 255, 0.75)',"+
                "      'rgba(0, 150, 255, 0.75)',"+
                "    ],"+
                "    borderColor: ["+
                "      'rgba(0, 150, 200)',"+
                "      'rgba(0, 150, 200)',"+
                "      'rgba(0, 150, 200)',"+
                "      'rgba(0, 150, 200)',"+
                "      'rgba(0, 150, 200)',"+
                "      'rgba(0, 150, 200)',"+
                "      'rgba(0, 150, 200)',"+
                "    ],"+
                "    borderWidth: 1"+
                "  },"+
                "  {"+
                "    label: 'Total Deaths',"+
                "    data: ["+ TotalDeaths(selectedCountries, simclimatecheck, nearcountrycheck)  +"],"+
                "    backgroundColor: ["+
                "    'rgba(255, 50, 50, 0.75)',"+
                "      'rgba(255, 50, 50, 0.75)',"+
                "      'rgba(255, 50, 50, 0.75)',"+
                "      'rgba(255, 50, 50, 0.75)',"+
                "      'rgba(255, 50, 50, 0.75)',"+
                "      'rgba(255, 50, 50, 0.75)',"+
                "      'rgba(255, 50, 50, 0.75)',"+
                "    ],"+
                "    borderColor: ["+
                "      'rgba(200, 50, 50)',"+
                "      'rgba(200, 50, 50)',"+
                "      'rgba(200, 50, 50)',"+
                "      'rgba(200, 50, 50)',"+
                "      'rgba(200, 50, 50)',"+
                "      'rgba(200, 50, 50)',"+
                "      'rgba(200, 50, 50)',"+
                "    ],"+
                "    borderWidth: 1"+
                "  },"+
                " ]"+
                "        },"+
                "        options:{" +
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
                "}"+
                "    });"+
                "</script>";
	

        html += "<script>"+
        ""+
        "var mybutton = document.getElementById(\"myBtn\");"+
        ""+
        ""+
        "window.onscroll = function() {scrollFunction()};"+
        ""+
        "function scrollFunction() {"+
        "  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {"+
        "    mybutton.style.display = \"block\";"+
        "  } else {"+
        "    mybutton.style.display = \"none\";"+
        "  }"+
        "}"+
        ""+
        ""+
        "function topFunction() {"+
        "  document.body.scrollTop = 0;"+
        "  document.documentElement.scrollTop = 0;"+
        "}"+
        "</script>";
            
                
        
        
                    

        html += "    <script src=\"jquery-3.2.1.min.js\"></script>"+
        "    <script src=\"chosen.jquery.js\"></script>"+
        "    <script type=\"text/javascript\">"+
        "        $(\".chosen-select\").chosen({"+
        "        });"+
        "    </script>";

        html += "    <script type=\"text/javascript\" src='loader.js'></script> ";
        html += "    <script type=\"text/javascript\" src='tablesorting.js'></script> " +

        "</body>"+

        

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

    public String Table(String datefrom, String dateto, ArrayList<String> CountryList, String simclimatecheck, String nearcountrycheck) {
        
        String html = "";

        NumberFormat myFormat = NumberFormat.getInstance();
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Integer> cases = jdbc.getCasesBetween(datefrom, dateto);
        ArrayList<Integer> deaths = jdbc.getDeathsBetween(datefrom, dateto);
        ArrayList<String> countries = jdbc.getCountryBetween(datefrom, dateto);
        String date1 = datefrom;
        String date2 = dateto;
        ArrayList<String> mostdate = jdbc.getMostCasesDate();
        ArrayList<String> mostDeathDate = jdbc.getMostDeathsDate();
        ArrayList<Integer> mostcases = jdbc.getMostCases();
        ArrayList<Double> deathcase = jdbc.getCaseDeath();
        ArrayList<Integer> mostdeaths = jdbc.getMostDeaths();
        ArrayList<Double> casedeathpopulation = jdbc.getCaseDeathToPopulation();

        if (simclimatecheck != null && CountryList.size() > 1) {
            html += "<script> document.getElementById(\"ClimateCheck\").innerHTML = \"Only One Country Can Be Selected When Comparing Countries With Similar Climate\";</script>";
        }
        else if (simclimatecheck != null) {
            CountryList = jdbc.getSimilarClimate(CountryList.get(0));
        }

        if (nearcountrycheck != null && CountryList.size() > 1) {
            html += "<script> document.getElementById(\"ClimateCheck\").innerHTML = \"Only One Country Can Be Selected When Comparing Nearest Countries\";</script>";
        }
        else if (nearcountrycheck != null) {
            CountryList = jdbc.getNearestCountries(CountryList.get(0));
        }

        if (nearcountrycheck != null && simclimatecheck != null) {
            html += "<script> document.getElementById(\"ClimateCheck\").innerHTML = \"Only One Country Comparison Option Can Be Selected\";</script>";
        }
       
        if (datefrom == "" || datefrom == null || dateto == "" || dateto == null ) {
            cases = jdbc.getCasesBetween("2020-01-22", "2021-04-22");
            deaths = jdbc.getDeathsBetween("2020-01-22", "2021-04-22");
            countries = jdbc.getCountryBetween("2020-01-22", "2021-04-22");
            date1 = "2020-01-22";
            date2 = "2021-04-22";
        } 

        date1 = ChangeDateFormat(date1);
        date2 = ChangeDateFormat(date2);

       
 

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
        "<th >Death and Cases / Population %</th>" +
        "        </tr>"+
        "        </thead>";
        html += "<tbody id=\"myTable2\">";
        for (int i = 0 ; i < cases.size() ; ++i) {
            for (int j = 0 ; j < CountryList.size() ; ++j) {
                if (countries.get(i).equals(CountryList.get(j))) {
                    html += "<tr><td>" + countries.get(i) + "</td><td>" + date1 + "</td><td>" + date2 + "</td><td style=\"color: blue;\">" + myFormat.format(cases.get(i)) + "</td><td>" +  ChangeDateFormat(mostdate.get(i)) + "</td><td>" + myFormat.format(mostcases.get(i)) + 
                    "</td><td>" + deathcase.get(i) + "%</td><td> "+ casedeathpopulation.get(i) + "%</td></tr>";
                    break;
                }
            }
            
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
        "<th >Death and Cases / Population %</th>" +
        "        </tr>"+
        "        </thead>";
        html += "<tbody id=\"myTable2\">";
        for (int i = 0 ; i < cases.size() ; ++i) {
            for (int j = 0 ; j < CountryList.size() ; ++j) {
                if (countries.get(i).equals(CountryList.get(j))) {
                    html += "<tr><td>" + countries.get(i) + "</td><td>" + date1 + "</td><td>" + date2 + "</td><td style=\"color: red;\">" + myFormat.format(deaths.get(i)) + "</td><td>" +  ChangeDateFormat(mostDeathDate.get(i)) +"</td><td>" + myFormat.format(mostdeaths.get(i))  +
                    "</td><td>" + deathcase.get(i) + "%</td><td> "+ casedeathpopulation.get(i) + "%</td></tr>";
                    break;
                }
            }
        }
        html += "</tbody>";
        html += "      </table>";

        html += " </div>";

        html +=  "<img style=\"width:100%;max-width:1000px;margin-top:32px;\">"+
        "              </div>"+
        "            </div>";
    
        return html;
    }
    
    public String Table2(String datefrom2, String dateto2, ArrayList<String> CountryList, ArrayList<String> StateList) {
        
        if (datefrom2 == null || datefrom2.isEmpty() || dateto2 == null || dateto2.isEmpty()) {
            datefrom2 = "2020-01-22";
            dateto2 = "2021-04-22"; 
        } 

        NumberFormat myFormat = NumberFormat.getInstance();
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<String> countries = jdbc.GetCertainCountriesWithStates(datefrom2, dateto2, CountryList);
        ArrayList<Integer> cases = jdbc.GetCertainCasesWithStates(datefrom2, dateto2, CountryList);
        ArrayList<Integer> deaths = jdbc.GetCertainDeathsWithStates(datefrom2, dateto2, CountryList);
        ArrayList<String> mostcasedate = jdbc.GetMostCaseDateState(CountryList);
        ArrayList<Integer> mostcase = jdbc.GetMostCaseState(CountryList);
        ArrayList<Integer> mostdeath = jdbc.GetMostDeathState(CountryList);
        ArrayList<String> mostdeathdate = jdbc.GetMostDeathDateState(CountryList);
        ArrayList<Double> DeathCaseRatio = jdbc.GetDeathCaseState(CountryList);

        String html = "";

        datefrom2 = ChangeDateFormat(datefrom2); dateto2 = ChangeDateFormat(dateto2);
        
        for (int i = 0 ; i < countries.size() ; ++i) {    
            for (int j = 0 ; j < StateList.size() ; ++j) {
                if (StateList.get(j).equals(countries.get(i))) {

                    html += "      <tr>"+
                    "        <td>" + countries.get(i) + "</td>"+
                    "        <td>" + datefrom2 + "</td>"+
                    "        <td>" + dateto2 + "</td>"+
                    "        <td style=\"color: blue;\">" + myFormat.format(cases.get(i)) + "</td>"+
                    "        <td style=\"color: red;\">" + myFormat.format(deaths.get(i)) + "</td>"+
                    "        <td>" + ChangeDateFormat(mostcasedate.get(i)) + "</td>"+
                    "        <td style=\"color: blue;\">" + myFormat.format(mostcase.get(i)) + "</td>"+
                    "        <td>" + ChangeDateFormat(mostdeathdate.get(i)) + "</td>"+
                    "        <td style=\"color: red;\">" + mostdeath.get(i) + "</td>"+
                    "        <td>" + DeathCaseRatio.get(i) + "%</td>"+
                    "      </tr>";

                    break;
                    
                    }

          
                }
            }

        return html;
    } 
    
    public String Days(String datefrom, String dateto) {
        if (datefrom == null || datefrom.isEmpty() || dateto == null || dateto.isEmpty()) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22"; 
        } 

        String html = "";

        NumberFormat myFormat = NumberFormat.getInstance();
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<String> days = jdbc.GetDays(datefrom, dateto);

        html += " labels:[";

        for (int i = 0 ; i < days.size() ; ++i) {
            html += "\"" + ChangeDateFormat(days.get(i)) + "\",";
        }

        html += "],";

        return html;
    }

    public String LineChartCase(String datefrom, String dateto, ArrayList<String> CountryList, String globalcheck, String simclimatecheck2, String nearcountrycheck2) {
        // for countrys
        if (datefrom == null || datefrom.isEmpty() || dateto == null || dateto.isEmpty()) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22"; 
        } 

        int j = 0; int k = 0; int u = 0; int l = 0;

        String html = "";

  
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Integer> dailycase = new ArrayList<Integer>();
        
        if (nearcountrycheck2 != null && simclimatecheck2 != null) {
            //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Comparison Option Can Be Selected\";</script>";
        }
        else {
            if (simclimatecheck2 != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Countries With Similar Climate\";</script>";
            }
            else if (simclimatecheck2 != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getSimilarClimate(CountryList.get(0));
            }
    
            if (nearcountrycheck2 != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Nearest Countries\";</script>";
            }
            else if (nearcountrycheck2 != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getNearestCountries(CountryList.get(0));
            }
        }
       
        Random rand = new Random();
        int r = 0; int g = 0; int b = 0;String colour = "";

        if (!CountryList.isEmpty()) {
            for (int i = 0 ; i < CountryList.size() ; ++i) {

                r = rand.nextInt(255) + 1; g = rand.nextInt(255) + 1; b = rand.nextInt(255) + 1;

                colour = "rgba(" + r + ", " + g + ", " + b + ")";

                dailycase = jdbc.GetDailyCountryCases(datefrom, dateto, CountryList.get(i));
                html += "{"+
                " label:\"" + CountryList.get(i) + "\","+
                "                    data:[";
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    html += dailycase.get(k) + ", ";
                }
                html += "],"+
                "                    backgroundColor:\"" + colour + "\","+
                "                    borderWidth:2,"+
                "                    pointBorderWidth:0 ," +
                "                    borderColor: \"" + colour + "\","+
                "                    hoverBorderWidth:10,"+
                "                    "+
                "                   "+
                "                },";
            }

            if (globalcheck != null) {
                r = rand.nextInt(255) + 1; g = rand.nextInt(255) + 1; b = rand.nextInt(255) + 1;

                colour = "rgba(" + r + ", " + g + ", " + b + ")";

                dailycase = jdbc.GetDailyGlobalCases(datefrom, dateto);
               
                html += "{"+
                " label:\"" + "Global" + "\","+
                "                    data:[";
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    html += dailycase.get(k) + ", ";
                }
                html += "],"+
                "                    backgroundColor:\"" + colour + "\","+
                "                    borderWidth:2,"+
                "                    pointBorderWidth:0 ," +
                "                    borderColor: \"" + colour + "\","+
                "                    hoverBorderWidth:10,"+
                "                    "+
                "                   "+
                "                },";
            }

        }
        else {
            r = rand.nextInt(255) + 1; g = rand.nextInt(255) + 1; b = rand.nextInt(255) + 1;

                colour = "rgba(" + r + ", " + g + ", " + b + ")";

                dailycase = jdbc.GetDailyGlobalCases(datefrom, dateto);
               
                html += "{"+
                " label:\"" + "Global" + "\","+
                "                    data:[";
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    html += dailycase.get(k) + ", ";
                }
                html += "],"+
                "                    backgroundColor:\"" + colour + "\","+
                "                    borderWidth:2,"+
                "                    pointBorderWidth:0 ," +
                "                    borderColor: \"" + colour + "\","+
                "                    hoverBorderWidth:10,"+
                "                    "+
                "                   "+
                "                },";
        }

        return html;
    } 

    public String LineChartCaseCheck(ArrayList<String> CountryList, String globalcheck, String simclimatecheck2, String nearcountrycheck2) {
        // for countrys
        String html = "";

        if (nearcountrycheck2 != null && simclimatecheck2 != null) {
            html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Comparison Option Can Be Selected\";</script>";
        }
        else {
            if (simclimatecheck2 != null && CountryList.size() > 1) {
                html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Countries With Similar Climate\";</script>";
            }
            if (nearcountrycheck2 != null && CountryList.size() > 1) {
                html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Nearest Countries\";</script>";
            }
    
        }
       
        return html;
    } 

    public ArrayList<String> LineChartCaseDaily(String datefrom, String dateto, ArrayList<String> CountryList, String globalcheck, String simclimatecheck2, String nearcountrycheck2) {
        // for countrys
        if (datefrom == null || datefrom.isEmpty() || dateto == null || dateto.isEmpty()) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22"; 
        } 

        int j = 0; int k = 0; int u = 0; int l = 0;

        String html = ""; String currstr = "";

  
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Integer> dailycase = new ArrayList<Integer>();

        ArrayList<String> CountryDailyCase = new ArrayList<String>();

        if (nearcountrycheck2 != null && simclimatecheck2 != null) {
            //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Comparison Option Can Be Selected\";</script>";
        }
        else {
            if (simclimatecheck2 != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Countries With Similar Climate\";</script>";
            }
            else if (simclimatecheck2 != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getSimilarClimate(CountryList.get(0));
            }
    
            if (nearcountrycheck2 != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Nearest Countries\";</script>";
            }
            else if (nearcountrycheck2 != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getNearestCountries(CountryList.get(0));
            }
        }
   
        if (!CountryList.isEmpty()) {
            for (int i = 0 ; i < CountryList.size() ; ++i) {

                dailycase = jdbc.GetDailyCountryCases(datefrom, dateto, CountryList.get(i));

                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                CountryDailyCase.add("[" + currstr + "];");

                currstr = "";

            }

            if (globalcheck != null) {

                dailycase = jdbc.GetDailyGlobalCases(datefrom, dateto);
               
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                CountryDailyCase.add("[" + currstr + "];");
                
                currstr = "";
            }

        }
        else {

                dailycase = jdbc.GetDailyGlobalCases(datefrom, dateto);  
          
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                CountryDailyCase.add("[" + currstr + "];");
                
                currstr = "";
        }

        return CountryDailyCase;
    } 

    public ArrayList<String> LineChartCaseCumulative(String datefrom, String dateto, ArrayList<String> CountryList, String globalcheck, String simclimatecheck2, String nearcountrycheck2) {
        // for countrys
        if (datefrom == null || datefrom.isEmpty() || dateto == null || dateto.isEmpty()) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22"; 
        } 

        int k = 0; int u = 0; int l = 0;

        String html = ""; String currstr = "";

  
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Integer> dailycase = new ArrayList<Integer>();

        ArrayList<String> CountryDailyCase = new ArrayList<String>();

        if (nearcountrycheck2 != null && simclimatecheck2 != null) {
            //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Comparison Option Can Be Selected\";</script>";
        }
        else {
            if (simclimatecheck2 != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Countries With Similar Climate\";</script>";
            }
            else if (simclimatecheck2 != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getSimilarClimate(CountryList.get(0));
            }
    
            if (nearcountrycheck2 != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Nearest Countries\";</script>";
            }
            else if (nearcountrycheck2 != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getNearestCountries(CountryList.get(0));
            }
        }
   
        if (!CountryList.isEmpty()) {
            for (int i = 0 ; i < CountryList.size() ; ++i) {

                dailycase = jdbc.getCumulativeCases(datefrom, dateto, CountryList.get(i));
                
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                CountryDailyCase.add("[" + currstr + "];");

                currstr = "";

            }

            if (globalcheck != null) {

                dailycase = jdbc.getGlobalCumulativeCases(datefrom, dateto);

                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                CountryDailyCase.add("[" + currstr + "];");
                
                currstr = "";
            }

        }
        else {

                dailycase = jdbc.getGlobalCumulativeCases(datefrom, dateto);  
          
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                CountryDailyCase.add("[" + currstr + "];");
                
                currstr = "";
        }

        return CountryDailyCase;
    } 

    public String LineChartDeath(String datefrom, String dateto, ArrayList<String> CountryList,  String globalcheck, String simclimatecheck2, String nearcountrycheck2) {
        
        if (datefrom == null || datefrom.isEmpty() || dateto == null || dateto.isEmpty()) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22"; 
        } 

        int j = 0; int k = 0; int u = 0; int l = 0;

        String html = "";

       
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Integer> dailycase = new ArrayList<Integer>();
        
        if (nearcountrycheck2 != null && simclimatecheck2 != null) {
            //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Comparison Option Can Be Selected\";</script>";
        }
        else {
            if (simclimatecheck2 != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Countries With Similar Climate\";</script>";
            }
            else if (simclimatecheck2 != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getSimilarClimate(CountryList.get(0));
            }
    
            if (nearcountrycheck2 != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Nearest Countries\";</script>";
            }
            else if (nearcountrycheck2 != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getNearestCountries(CountryList.get(0));
            }
        }

        Random rand = new Random();
        int r = 0; int g = 0; int b = 0; String colour = "";

        if (!CountryList.isEmpty()) {
            for (int i = 0 ; i < CountryList.size() ; ++i) {

                r = rand.nextInt(255) + 1; g = rand.nextInt(255) + 1; b = rand.nextInt(255) + 1;

                colour = "rgba(" + r + ", " + g + ", " + b + ")";

                dailycase = jdbc.GetDailyCountryDeaths(datefrom, dateto, CountryList.get(i));

                html += "{"+
                " label:\"" + CountryList.get(i) + "\","+
                "                    data:[";
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    html += dailycase.get(k) + ", ";
                }
                html += "],"+
                "                    backgroundColor:\"" + colour + "\","+
                "                    borderWidth:2,"+
                "                    pointBorderWidth:0 ," +
                "                    borderColor: \"" + colour + "\","+
                "                    hoverBorderWidth:10,"+
                "                    "+
                "                   "+
                "                },";
        
            }

            if (globalcheck != null) {
                r = rand.nextInt(255) + 1; g = rand.nextInt(255) + 1; b = rand.nextInt(255) + 1;

                colour = "rgba(" + r + ", " + g + ", " + b + ")";

                dailycase = jdbc.getDailyGlobalDeaths(datefrom, dateto);
               
                html += "{"+
                " label:\"" + "Global" + "\","+
                "                    data:[";
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    html += dailycase.get(k) + ", ";
                }
                html += "],"+
                "                    backgroundColor:\"" + colour + "\","+
                "                    borderWidth:2,"+
                "                    pointBorderWidth:0 ," +
                "                    borderColor: \"" + colour + "\","+
                "                    hoverBorderWidth:10,"+
                "                    "+
                "                   "+
                "                },";
            }
            
        }
        else {
            r = rand.nextInt(255) + 1; g = rand.nextInt(255) + 1; b = rand.nextInt(255) + 1;

            colour = "rgba(" + r + ", " + g + ", " + b + ")";

            dailycase = jdbc.getDailyGlobalDeaths(datefrom, dateto);
           
            html += "{"+
            " label:\"" + "Global" + "\","+
            "                    data:[";
            for (k = 0 ; k < dailycase.size() ; ++k) {
                html += dailycase.get(k) + ", ";
            }
            html += "],"+
            "                    backgroundColor:\"" + colour + "\","+
            "                    borderWidth:2,"+
            "                    pointBorderWidth:0 ," +
            "                    borderColor: \"" + colour + "\","+
            "                    hoverBorderWidth:10,"+
            "                    "+
            "                   "+
            "                },";
        }

        return html;
    } 

    public ArrayList<String> LineChartDeathCumulative(String datefrom, String dateto, ArrayList<String> CountryList, String globalcheck, String simclimatecheck2, String nearcountrycheck2) {
        // for countrys
        if (datefrom == null || datefrom.isEmpty() || dateto == null || dateto.isEmpty()) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22"; 
        } 

        int k = 0; int u = 0; int l = 0;

        String html = ""; String currstr = "";

  
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Integer> dailycase = new ArrayList<Integer>();

        ArrayList<String> CountryDailyCase = new ArrayList<String>();

        if (nearcountrycheck2 != null && simclimatecheck2 != null) {
            //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Comparison Option Can Be Selected\";</script>";
        }
        else {
            if (simclimatecheck2 != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Countries With Similar Climate\";</script>";
            }
            else if (simclimatecheck2 != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getSimilarClimate(CountryList.get(0));
            }
    
            if (nearcountrycheck2 != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Nearest Countries\";</script>";
            }
            else if (nearcountrycheck2 != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getNearestCountries(CountryList.get(0));
            }
        }
   
        if (!CountryList.isEmpty()) {
            for (int i = 0 ; i < CountryList.size() ; ++i) {

                dailycase = jdbc.getCumulativeDeaths(datefrom, dateto, CountryList.get(i));
                
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                CountryDailyCase.add("[" + currstr + "];");

                currstr = "";

            }

            if (globalcheck != null) {

                dailycase = jdbc.getGlobalCumulativeDeaths(datefrom, dateto);

                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                CountryDailyCase.add("[" + currstr + "];");
                
                currstr = "";
            }

        }
        else {

                dailycase = jdbc.getGlobalCumulativeDeaths(datefrom, dateto);  
          
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                CountryDailyCase.add("[" + currstr + "];");
                
                currstr = "";
        }

        return CountryDailyCase;
    } 

    public ArrayList<String> LineChartDeathDaily(String datefrom, String dateto, ArrayList<String> CountryList, String globalcheck, String simclimatecheck2, String nearcountrycheck2) {
        // for countrys
        if (datefrom == null || datefrom.isEmpty() || dateto == null || dateto.isEmpty()) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22"; 
        } 

        int j = 0; int k = 0; int u = 0; int l = 0;

        String html = ""; String currstr = "";

  
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Integer> dailycase = new ArrayList<Integer>();

        ArrayList<String> CountryDailyCase = new ArrayList<String>();

        if (nearcountrycheck2 != null && simclimatecheck2 != null) {
            //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Comparison Option Can Be Selected\";</script>";
        }
        else {
            if (simclimatecheck2 != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Countries With Similar Climate\";</script>";
            }
            else if (simclimatecheck2 != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getSimilarClimate(CountryList.get(0));
            }
    
            if (nearcountrycheck2 != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Nearest Countries\";</script>";
            }
            else if (nearcountrycheck2 != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getNearestCountries(CountryList.get(0));
            }
        }
   
        if (!CountryList.isEmpty()) {
            for (int i = 0 ; i < CountryList.size() ; ++i) {

                dailycase = jdbc.GetDailyCountryDeaths(datefrom, dateto, CountryList.get(i));

                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                CountryDailyCase.add("[" + currstr + "];");

                currstr = "";

            }

            if (globalcheck != null) {

                dailycase = jdbc.getDailyGlobalDeaths(datefrom, dateto);
               
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                CountryDailyCase.add("[" + currstr + "];");
                
                currstr = "";
            }

        }
        else {

                dailycase = jdbc.getDailyGlobalDeaths(datefrom, dateto);  
          
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                CountryDailyCase.add("[" + currstr + "];");
                
                currstr = "";
        }

        return CountryDailyCase;
    } 

    public String LineChartCase2(String datefrom, String dateto, ArrayList<String> CountryList) {
        
        if (datefrom == null || datefrom.isEmpty() || dateto == null || dateto.isEmpty()) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22"; 
        } 

        int k = 0; int u = 0; int l = 0;

        String html = "";

     
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Integer> dailycase = new ArrayList<Integer>();
        ArrayList<String> currstates = new ArrayList<String>();
 
        ArrayList<String> days = jdbc.GetDays(datefrom, dateto);



        Random rand = new Random();
        int r = 0; int g = 0; int b = 0;String colour = "";

        for (int j = 0 ; j < CountryList.size() ; ++j) {

            currstates = jdbc.GetStateFromCountry(CountryList.get(j));

            for (int i = 0 ; i < currstates.size() ; ++i) {

                r = rand.nextInt(255) + 1; g = rand.nextInt(255) + 1; b = rand.nextInt(255) + 1;

                colour = "rgba(" + r + ", " + g + ", " + b + ")";

                dailycase = jdbc.GetDailyStateCases(datefrom, dateto, currstates.get(i));

                html += "{"+
                " label:\"" + currstates.get(i) + "\","+
                "                    data:[";
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    html += dailycase.get(k) + ", ";
                }
                html += "],"+
                "                    backgroundColor:\"" + colour + "\","+
                "                    borderWidth:2,"+
                "                    pointBorderWidth:0 ," +
                "                    borderColor: \"" + colour + "\","+
                "                    hoverBorderWidth:10,"+
                "                    "+
                "                   "+
                "                },";
                
            }
        }

        return html;
    } 

    public ArrayList<String> LineChartStateCaseDaily(String datefrom, String dateto, ArrayList<String> CountryList) {
        
        if (datefrom == null || datefrom.isEmpty() || dateto == null || dateto.isEmpty()) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22"; 
        } 

        int k = 0; 

        String currstr = "";

     
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Integer> dailycase = new ArrayList<Integer>();
        ArrayList<String> currstates = new ArrayList<String>();
 
        ArrayList<String> days = jdbc.GetDays(datefrom, dateto);

        ArrayList<String> StateDailyCase = new ArrayList<String>();


        for (int j = 0 ; j < CountryList.size() ; ++j) {

            currstates = jdbc.GetStateFromCountry(CountryList.get(j));

            for (int i = 0 ; i < currstates.size() ; ++i) {

                dailycase = jdbc.GetDailyStateCases(datefrom, dateto, currstates.get(i));

                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                StateDailyCase.add("[" + currstr + "];");

                currstr = "";
            }
        }

        return StateDailyCase;
    } 

    public ArrayList<String> LineChartStateCaseCumulative(String datefrom, String dateto, ArrayList<String> CountryList) {
        
        if (datefrom == null || datefrom.isEmpty() || dateto == null || dateto.isEmpty()) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22"; 
        } 

        int k = 0; 

        String currstr = "";

        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Integer> dailycase = new ArrayList<Integer>();
        ArrayList<String> currstates = new ArrayList<String>();
 
        ArrayList<String> days = jdbc.GetDays(datefrom, dateto);

        ArrayList<String> StateDailyCase = new ArrayList<String>();

        for (int j = 0 ; j < CountryList.size() ; ++j) {

            currstates = jdbc.GetStateFromCountry(CountryList.get(j));

            for (int i = 0 ; i < currstates.size() ; ++i) {

                dailycase = jdbc.getStateCumulativeCases(datefrom, dateto, currstates.get(i));

                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                StateDailyCase.add("[" + currstr + "];");

                currstr = "";
            }
        }

        return StateDailyCase;
    } 

    public ArrayList<String> LineChartStateDeathDaily(String datefrom, String dateto, ArrayList<String> CountryList) {
        
        if (datefrom == null || datefrom.isEmpty() || dateto == null || dateto.isEmpty()) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22"; 
        } 

        int k = 0; 

        String currstr = "";

     
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Integer> dailycase = new ArrayList<Integer>();
        ArrayList<String> currstates = new ArrayList<String>();
 
        ArrayList<String> days = jdbc.GetDays(datefrom, dateto);

        ArrayList<String> StateDailyCase = new ArrayList<String>();


        for (int j = 0 ; j < CountryList.size() ; ++j) {

            currstates = jdbc.GetStateFromCountry(CountryList.get(j));

            for (int i = 0 ; i < currstates.size() ; ++i) {

                dailycase = jdbc.GetDailyStateDeaths(datefrom, dateto, currstates.get(i));

                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                StateDailyCase.add("[" + currstr + "];");

                currstr = "";
            }
        }

        return StateDailyCase;
    } 

    public ArrayList<String> LineChartStateDeathCumulative(String datefrom, String dateto, ArrayList<String> CountryList) {
        
        if (datefrom == null || datefrom.isEmpty() || dateto == null || dateto.isEmpty()) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22"; 
        } 

        int k = 0; 

        String currstr = "";

        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Integer> dailycase = new ArrayList<Integer>();
        ArrayList<String> currstates = new ArrayList<String>();
 
        ArrayList<String> days = jdbc.GetDays(datefrom, dateto);

        ArrayList<String> StateDailyCase = new ArrayList<String>();

        for (int j = 0 ; j < CountryList.size() ; ++j) {

            currstates = jdbc.GetStateFromCountry(CountryList.get(j));

            for (int i = 0 ; i < currstates.size() ; ++i) {

                dailycase = jdbc.getStateCumulativeDeaths(datefrom, dateto, currstates.get(i));

                for (k = 0 ; k < dailycase.size() ; ++k) {
                    currstr += dailycase.get(k) + ", ";
                }

                StateDailyCase.add("[" + currstr + "];");

                currstr = "";
            }
        }

        return StateDailyCase;
    } 

    public String LineChartDeath2(String datefrom, String dateto, ArrayList<String> CountryList) {
        
        if (datefrom == null || datefrom.isEmpty() || dateto == null || dateto.isEmpty()) {
            datefrom = "2020-01-22";
            dateto = "2021-04-22"; 
        } 

        int k = 0; int u = 0; int l = 0;

        String html = "";

     
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Integer> dailycase = new ArrayList<Integer>();
        ArrayList<String> currstates = new ArrayList<String>();
 
        ArrayList<String> days = jdbc.GetDays(datefrom, dateto);



        Random rand = new Random();
        int r = 0; int g = 0; int b = 0;String colour = "";

        for (int j = 0 ; j < CountryList.size() ; ++j) {

            currstates = jdbc.GetStateFromCountry(CountryList.get(j));

            for (int i = 0 ; i < currstates.size() ; ++i) {

                r = rand.nextInt(255) + 1; g = rand.nextInt(255) + 1; b = rand.nextInt(255) + 1;

                colour = "rgba(" + r + ", " + g + ", " + b + ")";

                dailycase = jdbc.GetDailyStateDeaths(datefrom, dateto, currstates.get(i));

                html += "{"+
                " label:\"" + currstates.get(i) + "\","+
                "                    data:[";
                for (k = 0 ; k < dailycase.size() ; ++k) {
                    html += dailycase.get(k) + ", ";
                }
                html += "],"+
                "                    backgroundColor:\"" + colour + "\","+
                "                    borderWidth:2,"+
                "                    pointBorderWidth:0 ," +
                "                    borderColor: \"" + colour + "\","+
                "                    hoverBorderWidth:10,"+
                "                    "+
                "                   "+
                "                },";
                
            }
        }

        return html;
    } 

    public String CountryName(ArrayList<String> CountryList, String simclimatecheck, String nearcountrycheck) {
        String html = "";
        
        JDBCConnection jdbc = new JDBCConnection();

        if (nearcountrycheck != null && simclimatecheck != null) {
            //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Comparison Option Can Be Selected\";</script>";
        }
        else {
            if (simclimatecheck != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Countries With Similar Climate\";</script>";
            }
            else if (simclimatecheck != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getSimilarClimate(CountryList.get(0));
            }
    
            if (nearcountrycheck != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Nearest Countries\";</script>";
            }
            else if (nearcountrycheck != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getNearestCountries(CountryList.get(0));
            }
        }
        
        for (int i = 0 ; i < CountryList.size() ; ++i) {
            html += "\"" + CountryList.get(i) + "\", ";
        }

        return html;
    }

    public String TotalCases(ArrayList<String> CountryList, String simclimatecheck, String nearcountrycheck) {
        String html = ""; int currnum = 0;
        
        JDBCConnection jdbc = new JDBCConnection();

        if (nearcountrycheck != null && simclimatecheck != null) {
            //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Comparison Option Can Be Selected\";</script>";
        }
        else {
            if (simclimatecheck != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Countries With Similar Climate\";</script>";
            }
            else if (simclimatecheck != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getSimilarClimate(CountryList.get(0));
            }
    
            if (nearcountrycheck != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Nearest Countries\";</script>";
            }
            else if (nearcountrycheck != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getNearestCountries(CountryList.get(0));
            }
        }
        
        for (int i = 0 ; i < CountryList.size() ; ++i) {
            currnum = jdbc.getTotalCases(CountryList.get(i));
            html += currnum + ", ";
        }

        return html;
    }

    public String TotalDeaths(ArrayList<String> CountryList, String simclimatecheck, String nearcountrycheck) {
        String html = ""; int currnum = 0;
        
        JDBCConnection jdbc = new JDBCConnection();

        if (nearcountrycheck != null && simclimatecheck != null) {
            //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Comparison Option Can Be Selected\";</script>";
        }
        else {
            if (simclimatecheck != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Countries With Similar Climate\";</script>";
            }
            else if (simclimatecheck != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getSimilarClimate(CountryList.get(0));
            }
    
            if (nearcountrycheck != null && CountryList.size() > 1) {
                //html += "<script> document.getElementById(\"ClimateCheck2\").innerHTML = \"Only One Country Can Be Selected When Comparing Nearest Countries\";</script>";
            }
            else if (nearcountrycheck != null && !CountryList.isEmpty()) {
                CountryList = jdbc.getNearestCountries(CountryList.get(0));
            }
        }
        
        for (int i = 0 ; i < CountryList.size() ; ++i) {
            currnum = jdbc.getTotalDeaths(CountryList.get(i));
            html += currnum + ", ";
        }

        return html;
    }

  
      
}

