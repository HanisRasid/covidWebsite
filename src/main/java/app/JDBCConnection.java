package app;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for Managing the JDBC Connection to a SQLLite Database.
 * Allows SQL queries to be used with the SQLLite Databse in Java.
 * 
 * This is an example JDBC Connection that has a single query for the Movies Database
 * This is similar to the project workshop JDBC examples.
 *
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 */
public class JDBCConnection {

    // Name of database file (contained in database folder)
    private static final String DATABASE = "jdbc:sqlite:database/COVID19DataNew.db";
    

    public JDBCConnection() {
        System.out.println("Created JDBC Connection Object");
    }

    /**
     * Get all of the Movies in the database
     */
    public ArrayList<Integer> getCasesBetween(String date1, String date2) {
        ArrayList<Integer> cases = new ArrayList<Integer>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(Cases) FROM CountryDaily WHERE DATE BETWEEN " +  "\""+ date1 + "\" AND \"" + date2 + "\"" + " GROUP BY CountryRegion;";
            

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
  
                Integer numcases     = results.getInt("SUM(Cases)");

                // For now we will just store the movieName and ignore the id
 
                cases.add(numcases);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        

        // Finally we return all of the movies
        return cases;
    }

    public ArrayList<String> getCountryBetween(String date1, String date2) {
        ArrayList<String> country = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT CountryRegion FROM CountryDaily WHERE DATE BETWEEN " +  "\""+ date1 + "\" AND \"" + date2 + "\"" + " GROUP BY CountryRegion;";
            

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String countryname         = results.getString("CountryRegion");

                // For now we will just store the movieName and ignore the id
                country.add(countryname);
   
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return country;
    }

    public Integer getTotalCases() {
        Integer TotalCases = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(totalcases) From Country;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
  
                TotalCases = results.getInt("SUM(totalcases)");

                // For now we will just store the movieName and ignore the id
 
                
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return TotalCases;
    }

    public Integer getTotalDeath() {
        Integer TotalDeaths = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(totaldeaths) From Country;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
  
                TotalDeaths = results.getInt("SUM(totaldeaths)");

                // For now we will just store the movieName and ignore the id
 
                
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return TotalDeaths;
    }

    public String getDate(String date) {
        String datestr = date;

        return datestr;
    }

    public ArrayList<String> getMostCasesDate() {
        ArrayList<String> datearr = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DATE, MAX(cases) FROM CountryDaily GROUP BY CountryRegion;";
            

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String date         = results.getString("DATE");

                // For now we will just store the movieName and ignore the id
                datearr.add(date);
   
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return datearr;
    }

    public ArrayList<Integer> getMostCases() {
        ArrayList<Integer> cases = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DATE, MAX(cases) FROM CountryDaily GROUP BY CountryRegion;";
            

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                int infection         = results.getInt("MAX(cases)");

                // For now we will just store the movieName and ignore the id
                cases.add(infection);
   
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return cases;
    }

    public ArrayList<Double> getCaseDeath() {
        ArrayList<Double> ratioarr = new ArrayList<Double>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT round(Sum(Deaths)/Sum(Cases) * 100, 3) FROM CountryDaily GROUP BY CountryRegion;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                double ratio         = results.getDouble("round(Sum(Deaths)/Sum(Cases) * 100, 3)");

                // For now we will just store the movieName and ignore the id
                ratioarr.add(ratio);
   
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return ratioarr;
    }


    public ArrayList<Integer> getTotalCountryDeath() {
        ArrayList<Integer> totalDeathArr = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT totaldeaths FROM country";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer totalDeaths         = results.getInt("totaldeaths");

                // For now we will just store the movieName and ignore the id
                totalDeathArr.add(totalDeaths);
   
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return totalDeathArr;
    }


    public ArrayList<Integer> getDeathsBetween(String date1, String date2) {
        ArrayList<Integer> deaths = new ArrayList<Integer>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(Deaths) FROM CountryDaily WHERE DATE BETWEEN " +  "\""+ date1 + "\" AND \"" + date2 + "\"" + " GROUP BY CountryRegion;";
            


            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
  
                Integer numDeaths     = results.getInt("SUM(Deaths)");

                // For now we will just store the movieName and ignore the id
 
                deaths.add(numDeaths);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return deaths;
    }

    public ArrayList<String> getMostDeathsDate() {
        ArrayList<String> datearr = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DATE, MAX(deaths) FROM CountryDaily GROUP BY CountryRegion;";
            

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String date         = results.getString("DATE");

                // For now we will just store the movieName and ignore the id
                datearr.add(date);
   
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return datearr;
    }

    public ArrayList<Integer> getMostDeaths() {
        ArrayList<Integer> deaths = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DATE, MAX(deaths) FROM CountryDaily GROUP BY CountryRegion;";
            


            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                int deathCount         = results.getInt("MAX(deaths)");

                // For now we will just store the movieName and ignore the id
                deaths.add(deathCount);
   
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return deaths;
    }

    public ArrayList<String> GetTop3MostAffected() {
        ArrayList<String> Country = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT CountryRegion, round(Sum(Deaths)/Sum(Cases) * 100, 3) FROM CountryDaily GROUP BY CountryRegion ORDER BY round(Sum(Deaths)/Sum(Cases) * 100, 3) DESC;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String countryname         = results.getString("CountryRegion");

                // For now we will just store the movieName and ignore the id
                Country.add(countryname);
   
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return Country;
    }

    public ArrayList<String> GetAllCountriesWithStates() {
        ArrayList<String> Country = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT Country FROM State GROUP BY Country;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String countryname         = results.getString("Country");

                // For now we will just store the movieName and ignore the id
                Country.add(countryname);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return Country;
    }

    public ArrayList<String> GetAllCountries() {
        ArrayList<String> country = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT Name FROM Country GROUP BY Name;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String countryname         = results.getString("Name");

                // For now we will just store the movieName and ignore the id
                country.add(countryname);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return country;
    }
    public ArrayList<String> GetAllUSStates() {
        ArrayList<String> states = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT ProvinceState FROM State where Country = \"United States\" GROUP BY ProvinceState;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String statename         = results.getString("ProvinceState");

                // For now we will just store the movieName and ignore the id
                states.add(statename);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return states;
    }
    //FOR TABLE DATA
    public ArrayList<String> GetCountryAndStatesInfectionsPerMillionName(String countryState, double infecMil) {
        ArrayList<String> infectionsPerMilName = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT Name FROM CountryStateData WHERE NOT Name= \"" + countryState + "\" ORDER BY ABS(InfectionsMil - " + infecMil +") LIMIT 10;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String name         = results.getString("Name");

                // For now we will just store the movieName and ignore the id
                infectionsPerMilName.add(name);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return infectionsPerMilName;
    }

        //FOR TABLE DATA
        public ArrayList<Double> GetCountryAndStatesInfectionsPerMillion(String countryState, double infecMil) {
            ArrayList<Double> infectionsPerMil = new ArrayList<Double>();
    
    
            // Setup the variable for the JDBC connection
            Connection connection = null;
    
            try {
                // Connect to JDBC data base
                connection = DriverManager.getConnection(DATABASE);
    
                // Prepare a new SQL Query & Set a timeout
                Statement statement = connection.createStatement();
                statement.setQueryTimeout(30);
    
                // The Query
                String query = "SELECT InfectionsMil FROM CountryStateData WHERE NOT Name= \"" + countryState + "\" ORDER BY ABS(InfectionsMil - " + infecMil +") LIMIT 10;";
                
                // Get Result
                ResultSet results = statement.executeQuery(query);
    
                // Process all of the results
                // The "results" variable is similar to an array
                // We can iterate through all of the database query results
                while (results.next()) {
                    // We can lookup a column of the a single record in the
                    // result using the column name
                    // BUT, we must be careful of the column type!
                    Double infectionData         = results.getDouble("InfectionsMil");
    
                    // For now we will just store the movieName and ignore the id
                    infectionsPerMil.add(infectionData);
                }
    
                // Close the statement because we are done with it
                statement.close();
            } catch (SQLException e) {
                // If there is an error, lets just pring the error
                System.err.println(e.getMessage());
            } finally {
                // Safety code to cleanup
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    // connection close failed.
                    System.err.println(e.getMessage());
                }
            }
            // Finally we return all of the movies
            return infectionsPerMil;
        }
    //TO PUT INSIDE METHOD TO FIND SIMILAR COUNTRIES
    public double getCountryInfecMil(String countryState) {
        double countryInfecMil=0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT InfectionsMil FROM CountryStateData WHERE Name= \"" + countryState + "\";";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
  
                countryInfecMil = results.getDouble("InfectionsMil");

                // For now we will just store the movieName and ignore the id
 
                
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return countryInfecMil;
    }
    //TO PUT INSIDE METHOD
    public double GetCountryStateDeathCase(String countryState) {
        double deathCase = 0;


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT COALESCE(DeathCases, 0) FROM CountryStateData WHERE Name= \"" + countryState + "\";";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                deathCase         = results.getDouble("COALESCE(DeathCases, 0)");

                // For now we will just store the movieName and ignore the id
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return deathCase;
    }
    //FOR TABLE DATA
    public ArrayList<String> GetCountryStateDeathCasesName(String countryState, double deathCases) {
        ArrayList<String> deathCasesName = new ArrayList<String>();
        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT Name FROM CountryStateData WHERE NOT Name= \"" + countryState + "\" ORDER BY ABS(COALESCE(DeathCases , 0) - " + deathCases +") LIMIT 10;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String name         = results.getString("Name");

                // For now we will just store the movieName and ignore the id
                deathCasesName.add(name);
            }

            // Close the statement because we are done with it
            statement.close();
        }
        catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return deathCasesName;
    }

    //FOR TABLE DATA
    public ArrayList<Double> GetCountryStateDeathCasesData(String countryState, double deathCases) {
        ArrayList<Double> deathCasesDataArr = new ArrayList<Double>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DeathCases FROM CountryStateData WHERE NOT Name= \"" + countryState + "\" ORDER BY ABS(COALESCE(DeathCases , 0) - " + deathCases +") LIMIT 10;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Double deathCasesData         = results.getDouble("DeathCases");

                // For now we will just store the movieName and ignore the id
                deathCasesDataArr.add(deathCasesData);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return deathCasesDataArr;
    }

    public ArrayList<String> GetStates() {
        ArrayList<String> states = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT ProvinceState FROM State;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String statename         = results.getString("ProvinceState");

                // For now we will just store the movieName and ignore the id
                states.add(statename);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return states;
    }

    //FOR TABLE DATA
    public ArrayList<String> GetCountryStatePeakCasesName(String countryState, double peakCaseDate) {
        ArrayList<String> peakCasesName = new ArrayList<String>();
        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT Name FROM PeakCases WHERE NOT Name= \"" + countryState + "\" ORDER BY ABS(JULIANDAY(Date) - " + peakCaseDate +") LIMIT 10;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String name         = results.getString("Name");

                // For now we will just store the movieName and ignore the id
                peakCasesName.add(name);
            }

            // Close the statement because we are done with it
            statement.close();
        }
        catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return peakCasesName;
    }
    //TO INPUT IN METHOD
    public double GetCountryStatePeakCaseDate(String countryState) {
        double peakDate = 0;


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT JULIANDAY(Date) FROM PeakCases WHERE Name= \"" + countryState + "\";";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                peakDate         = results.getDouble("JULIANDAY(Date)");

                // For now we will just store the movieName and ignore the id
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return peakDate;
    }

//FOR STATISTICS
    public String GetCountryStatePeakCaseDateGregorian(String countryState) {
        String peakDate = "";


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT Date FROM PeakCases WHERE Name= \"" + countryState + "\";";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                peakDate         = results.getString("Date");

                // For now we will just store the movieName and ignore the id
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return peakDate;
    }

    //FOR TABLE DATA
    public ArrayList<String> GetCountryStatePeakCasesDates(String countryState, double peakCaseDate) {
        ArrayList<String> peakCasesDates = new ArrayList<String>();
        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT Date FROM PeakCases WHERE NOT Name= \"" + countryState + "\" ORDER BY ABS(JULIANDAY(Date) - " + peakCaseDate +") LIMIT 10;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String peakCaseDates  = results.getString("Date");

                // For now we will just store the movieName and ignore the id
                peakCasesDates.add(peakCaseDates);
            }

            // Close the statement because we are done with it
            statement.close();
        }
        catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return peakCasesDates;
    }

    //TO INPUT IN METHOD
    public double GetCountryStatePeakDeathDate(String countryState) {
        double peakDate = 0;


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT JULIANDAY(Date) FROM PeakDeaths WHERE Name= \"" + countryState + "\";";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                peakDate         = results.getDouble("JULIANDAY(Date)");

                // For now we will just store the movieName and ignore the id
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return peakDate;
    }

    public String GetCountryStatePeakDeathDateGregorian(String countryState) {
        String peakDate = "";


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT Date FROM PeakDeaths WHERE Name= \"" + countryState + "\";";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                peakDate         = results.getString("Date");

                // For now we will just store the movieName and ignore the id
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return peakDate;
    }
    
    //FOR TABLE DATA
    public ArrayList<String> GetCountryStatePeakDeathsName(String countryState, double peakDeathDate) {
        ArrayList<String> peakDeathsName = new ArrayList<String>();
        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT Name FROM PeakDeaths WHERE NOT Name= \"" + countryState + "\" ORDER BY ABS(JULIANDAY(Date) - " + peakDeathDate +") LIMIT 10;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String name         = results.getString("Name");

                // For now we will just store the movieName and ignore the id
                peakDeathsName.add(name);
            }

            // Close the statement because we are done with it
            statement.close();
        }
        catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return peakDeathsName;
    }

    //FOR TABLE DATA
    public ArrayList<String> GetCountryStatePeakDeathsDates(String countryState, double peakDeathDate) {
        ArrayList<String> peakDeathsDates = new ArrayList<String>();
        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT Date FROM PeakDeaths WHERE NOT Name= \"" + countryState + "\" ORDER BY ABS(JULIANDAY(Date) - " + peakDeathDate +") LIMIT 10;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String peakDDate  = results.getString("Date");

                // For now we will just store the movieName and ignore the id
                peakDeathsDates.add(peakDDate);
            }

            // Close the statement because we are done with it
            statement.close();
        }
        catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return peakDeathsDates;
    }

    public ArrayList<String> GetCertainCountriesWithStates(String datefrom, String dateto, ArrayList<String> country) {
        ArrayList<String> CountryList = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT sd.ProvinceState, SUM(sd.Cases), SUM(sd.Deaths) FROM StateDaily as sd JOIN State as s ON s.ProvinceState = sd.ProvinceState WHERE (DATE BETWEEN \""+ datefrom + "\" AND \"" + dateto + "\") AND ";
            
            for (int i = 0 ; i < country.size() ; ++i) {
                if (i == 0) {
                    query += "s.Country = \"" + country.get(i) + "\"";
                }
                else {
                    query += " OR s.Country = \"" + country.get(i) + "\"";
                }
            }

            query += " GROUP BY sd.ProvinceState;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String countryname         = results.getString("ProvinceState");

                // For now we will just store the movieName and ignore the id
                CountryList.add(countryname);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return CountryList;
    }

    public ArrayList<Integer> GetCertainCasesWithStates(String datefrom, String dateto, ArrayList<String> country) {
        ArrayList<Integer> Cases = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT sd.ProvinceState, SUM(sd.Cases), SUM(sd.Deaths) FROM StateDaily as sd JOIN State as s ON s.ProvinceState = sd.ProvinceState WHERE DATE BETWEEN \""+ datefrom + "\" AND \"" + dateto + "\" GROUP BY sd.ProvinceState;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer countryname         = results.getInt("SUM(sd.Cases)");

                // For now we will just store the movieName and ignore the id
                Cases.add(countryname);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return Cases;
    }

    public ArrayList<Integer> GetCertainDeathsWithStates(String datefrom, String dateto, ArrayList<String> country) {
        ArrayList<Integer> Deaths = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT sd.ProvinceState, SUM(sd.Cases), SUM(sd.Deaths) FROM StateDaily as sd JOIN State as s ON s.ProvinceState = sd.ProvinceState WHERE DATE BETWEEN \""+ datefrom + "\" AND \"" + dateto + "\" GROUP BY sd.ProvinceState;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer countryname         = results.getInt("SUM(sd.Deaths)");

                // For now we will just store the movieName and ignore the id
                Deaths.add(countryname);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return Deaths;
    }

    public ArrayList<String> GetMostCaseDateState(ArrayList<String> country) {
        ArrayList<String> date = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT sd.ProvinceState, sd.Date, Max(sd.Cases) FROM StateDaily as sd JOIN State as s ON s.ProvinceState = sd.ProvinceState WHERE ";
            for (int i = 0 ; i < country.size() ; ++i) {
                if (i == 0 ) {
                    query += "s.Country = \"" + country.get(i) + "\"";
                }
                else {
                    query += " OR s.Country = \"" + country.get(i) + "\""; 
                }
            }
       
            query += " GROUP By sd.ProvinceState;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String datein         = results.getString("Date");

                // For now we will just store the movieName and ignore the id
                date.add(datein);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return date;
    }

    public ArrayList<Integer> GetMostCaseState(ArrayList<String> country) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT sd.ProvinceState, sd.Date, Max(sd.Cases) FROM StateDaily as sd JOIN State as s ON s.ProvinceState = sd.ProvinceState WHERE ";
    
            for (int i = 0 ; i < country.size() ; ++i) {
                if (i == 0 ) {
                    query += "s.Country = \"" + country.get(i) + "\"";
                }
                else {
                    query += " OR s.Country = \"" + country.get(i) + "\""; 
                }
            }
       
            query += " GROUP By sd.ProvinceState;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer resultin         = results.getInt("Max(sd.Cases)");

                // For now we will just store the movieName and ignore the id
                result.add(resultin);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> GetMostDeathState(ArrayList<String> country) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT sd.ProvinceState, sd.Date, Max(sd.Deaths) FROM StateDaily as sd JOIN State as s ON s.ProvinceState = sd.ProvinceState WHERE ";
    
            for (int i = 0 ; i < country.size() ; ++i) {
                if (i == 0 ) {
                    query += "s.Country = \"" + country.get(i) + "\"";
                }
                else {
                    query += " OR s.Country = \"" + country.get(i) + "\""; 
                }
            }
       
            query += " GROUP By sd.ProvinceState;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer resultin         = results.getInt("Max(sd.Deaths)");

                // For now we will just store the movieName and ignore the id
                result.add(resultin);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<String> GetMostDeathDateState(ArrayList<String> country) {
        ArrayList<String> date = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT sd.ProvinceState, sd.Date, Max(sd.Deaths) FROM StateDaily as sd JOIN State as s ON s.ProvinceState = sd.ProvinceState WHERE ";
            for (int i = 0 ; i < country.size() ; ++i) {
                if (i == 0 ) {
                    query += "s.Country = \"" + country.get(i) + "\"";
                }
                else {
                    query += " OR s.Country = \"" + country.get(i) + "\""; 
                }
            }
       
            query += " GROUP By sd.ProvinceState;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String datein         = results.getString("Date");

                // For now we will just store the movieName and ignore the id
                date.add(datein);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return date;
    }

    public ArrayList<Double> GetDeathCaseState(ArrayList<String> country) {
        ArrayList<Double> deathCasesDataArr = new ArrayList<Double>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT sd.ProvinceState, IFNULL(round(Sum(sd.Deaths)/Sum(sd.Cases) * 100, 3), 0) FROM StateDaily as sd JOIN State as s ON s.ProvinceState = sd.ProvinceState WHERE ";
           
            for (int i = 0 ; i < country.size() ; ++i) {
                if (i == 0 ) {
                    query += "s.Country = \"" + country.get(i) + "\"";
                }
                else {
                    query += " OR s.Country = \"" + country.get(i) + "\""; 
                }
            }

            query += " GROUP By sd.ProvinceState;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Double deathCasesData         = results.getDouble("IFNULL(round(Sum(sd.Deaths)/Sum(sd.Cases) * 100, 3), 0)");

                // For now we will just store the movieName and ignore the id
                deathCasesDataArr.add(deathCasesData);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return deathCasesDataArr;
    }

    public ArrayList<Integer> GetDailyCountryCases(String datefrom, String dateto, String country) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT CountryRegion, Date, Cases From CountryDaily WHERE (DATE BETWEEN \"" + datefrom + "\" AND \"" + dateto + "\") AND (CountryRegion = \"" + country + "\");"; 
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("Cases");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<String> GetDays(String datefrom, String dateto) {
        ArrayList<String> result = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT Date FROM CountryDaily WHERE DATE BETWEEN \"" + datefrom + "\" AND \"" + dateto + "\" GROUP BY Date;"; 
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String result2         = results.getString("Date");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> GetDailyCountryDeaths(String datefrom, String dateto, String country) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT CountryRegion, Date, Deaths From CountryDaily WHERE (DATE BETWEEN \"" + datefrom + "\" AND \"" + dateto + "\") AND (CountryRegion = \"" + country + "\");"; 
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("Deaths");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<String> GetStateFromCountry(String country) {
        ArrayList<String> result = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT ProvinceState FROM State Where Country = \"" + country + "\";"; 
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String result2         = results.getString("ProvinceState");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> GetDailyStateCases(String datefrom, String dateto, String state) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT ProvinceState, Date, Cases, Deaths FROM StateDaily WHERE (DATE BETWEEN \"" + datefrom + "\" AND \"" + dateto + "\") AND ProvinceState = \"" + state + "\";"; 
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("Cases");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> GetDailyStateDeaths(String datefrom, String dateto, String state) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT ProvinceState, Date, Cases, Deaths FROM StateDaily WHERE (DATE BETWEEN \"" + datefrom + "\" AND \"" + dateto + "\") AND ProvinceState = \"" + state + "\";"; 
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("Deaths");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> GetDailyGlobalCases(String datefrom, String dateto) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT Date, Sum(Cases), Sum(Deaths) From CountryDaily WHERE (DATE BETWEEN \"" + datefrom + "\" AND \"" + dateto + "\") Group By Date;"; 
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("Sum(Cases)");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> getDailyGlobalDeaths(String datefrom, String dateto) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT Date, Sum(Cases), Sum(Deaths) From CountryDaily WHERE (DATE BETWEEN \"" + datefrom + "\" AND \"" + dateto + "\") Group By Date;"; 
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("Sum(Deaths)");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }
   
//top 5 most affected countries    

    public ArrayList<String> getTop5Country() {
        ArrayList<String> result = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, c.population, Sum(cd.Cases), Sum(cd.Deaths), IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) desc; ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String result2         = results.getString("CountryRegion");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> getTop5CountryCase() {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, c.population, Sum(cd.Cases), Sum(cd.Deaths), IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) desc; ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("Sum(cd.Cases)");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> getTop5CountryPopulation() {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, c.population, Sum(cd.Cases), Sum(cd.Deaths), IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) desc; ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("population");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> getTop5CountryDeath() {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, c.population, Sum(cd.Cases), Sum(cd.Deaths), IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) desc; ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("Sum(cd.Deaths)");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Double> getTop5CountryRatio() {
        ArrayList<Double> result = new ArrayList<Double>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, c.population, Sum(cd.Cases), Sum(cd.Deaths), IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) desc; ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Double result2         = results.getDouble("IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0)");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Double> getTop5CountryCasesPop() {
        ArrayList<Double> result = new ArrayList<Double>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, c.population , IFNULL(round(Sum(cd.Cases)/c.population * 100, 3), 0) ,  IFNULL(round(Sum(cd.Deaths)/c.population * 100, 3), 0), IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) desc;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Double result2         = results.getDouble("IFNULL(round(Sum(cd.Cases)/c.population * 100, 3), 0)");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Double> getTop5CountryDeathsPop() {
        ArrayList<Double> result = new ArrayList<Double>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, c.population , IFNULL(round(Sum(cd.Cases)/c.population * 100, 3), 0) ,  IFNULL(round(Sum(cd.Deaths)/c.population * 100, 3), 0), IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) desc;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Double result2         = results.getDouble("IFNULL(round(Sum(cd.Deaths)/c.population * 100, 3), 0)");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

//top 5 least affected countries

    public ArrayList<String> getTop5Country2() {
        ArrayList<String> result = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, c.population, Sum(cd.Cases), Sum(cd.Deaths), IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) asc; ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String result2         = results.getString("CountryRegion");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> getTop5CountryCase2() {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, c.population, Sum(cd.Cases), Sum(cd.Deaths), IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) asc; ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("Sum(cd.Cases)");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> getTop5CountryPopulation2() {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, c.population, Sum(cd.Cases), Sum(cd.Deaths), IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) asc; ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("population");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> getTop5CountryDeath2() {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, c.population, Sum(cd.Cases), Sum(cd.Deaths), IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) asc; ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("Sum(cd.Deaths)");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Double> getTop5CountryRatio2() {
        ArrayList<Double> result = new ArrayList<Double>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, c.population, Sum(cd.Cases), Sum(cd.Deaths), IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) asc; ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Double result2         = results.getDouble("IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0)");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Double> getTop5CountryCasesPop2() {
        ArrayList<Double> result = new ArrayList<Double>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, c.population , IFNULL(round(Sum(cd.Cases)/c.population * 100, 3), 0) ,  IFNULL(round(Sum(cd.Deaths)/c.population * 100, 3), 0), IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) asc;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Double result2         = results.getDouble("IFNULL(round(Sum(cd.Cases)/c.population * 100, 3), 0)");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Double> getTop5CountryDeathsPop2() {
        ArrayList<Double> result = new ArrayList<Double>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, c.population , IFNULL(round(Sum(cd.Cases)/c.population * 100, 3), 0) ,  IFNULL(round(Sum(cd.Deaths)/c.population * 100, 3), 0), IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  IFNULL(round(Sum(cd.Deaths)/Sum(cd.Cases) * 100, 3), 0) asc;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Double result2         = results.getDouble("IFNULL(round(Sum(cd.Deaths)/c.population * 100, 3), 0)");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> getCumulativeCases(String datefrom, String dateto, String Country) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT a.Date, SUM(b.Cumulative) CumulativeTotal FROM " +
           " (SELECT Date, SUM(Cases) Cumulative FROM CountryDaily " +
            "WHERE LOWER(CountryRegion) = LOWER(\""+ Country +"\") " +
            "AND DATE BETWEEN \""+ datefrom +"\" AND \""+ dateto +"\" " +
            "GROUP BY Date ORDER BY Date) as a, " +
            "(SELECT Date, SUM(Cases) Cumulative FROM CountryDaily " +
            "WHERE LOWER(CountryRegion) = LOWER(\""+ Country +"\") " +
            "AND DATE BETWEEN \""+ datefrom +"\" AND \""+ dateto +"\" " +
            "GROUP BY Date ORDER BY Date) as b " +
            "WHERE a.DATE >= b.DATE " +
            "GROUP BY a.DATE;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("CumulativeTotal");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> getCumulativeDeaths(String datefrom, String dateto, String Country) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT a.Date, SUM(b.Cumulative) CumulativeTotal FROM " +
           " (SELECT Date, SUM(Deaths) Cumulative FROM CountryDaily " +
            "WHERE LOWER(CountryRegion) = LOWER(\""+ Country +"\") " +
            "AND DATE BETWEEN \""+ datefrom +"\" AND \""+ dateto +"\" " +
            "GROUP BY Date ORDER BY Date) as a, " +
            "(SELECT Date, SUM(Deaths) Cumulative FROM CountryDaily " +
            "WHERE LOWER(CountryRegion) = LOWER(\""+ Country +"\") " +
            "AND DATE BETWEEN \""+ datefrom +"\" AND \""+ dateto +"\" " +
            "GROUP BY Date ORDER BY Date) as b " +
            "WHERE a.DATE >= b.DATE " +
            "GROUP BY a.DATE;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("CumulativeTotal");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> getGlobalCumulativeCases(String datefrom, String dateto) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT a.Date, SUM(b.Cumulative) CumulativeTotal FROM " +
            "(SELECT Date, SUM(Cases) Cumulative FROM CountryDaily " +
            "WHERE DATE BETWEEN \""+ datefrom +"\" AND \""+ dateto +"\" " +
            "GROUP BY Date ORDER BY Date) as a, " +
            "(SELECT Date, SUM(Cases) Cumulative FROM CountryDaily " +
            "WHERE DATE BETWEEN \""+ datefrom +"\" AND \""+ dateto +"\" " +
            "GROUP BY Date ORDER BY Date) as b " +
            "WHERE a.DATE >= b.DATE " +
            "GROUP BY a.DATE; ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("CumulativeTotal");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> getGlobalCumulativeDeaths(String datefrom, String dateto) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT a.Date, SUM(b.Cumulative) CumulativeTotal FROM " +
            "(SELECT Date, SUM(Deaths) Cumulative FROM CountryDaily " +
            "WHERE DATE BETWEEN \""+ datefrom +"\" AND \""+ dateto +"\" " +
            "GROUP BY Date ORDER BY Date) as a, " +
            "(SELECT Date, SUM(Deaths) Cumulative FROM CountryDaily " +
            "WHERE DATE BETWEEN \""+ datefrom +"\" AND \""+ dateto +"\" " +
            "GROUP BY Date ORDER BY Date) as b " +
            "WHERE a.DATE >= b.DATE " +
            "GROUP BY a.DATE; ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("CumulativeTotal");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> getStateCumulativeCases(String datefrom, String dateto, String Country) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT a.Date, SUM(b.Cumulative) CumulativeTotal FROM " +
           " (SELECT Date, SUM(Cases) Cumulative FROM StateDaily " +
            "WHERE LOWER(ProvinceState) = LOWER(\""+ Country +"\") " +
            "AND DATE BETWEEN \""+ datefrom +"\" AND \""+ dateto +"\" " +
            "GROUP BY Date ORDER BY Date) as a, " +
            "(SELECT Date, SUM(Cases) Cumulative FROM StateDaily " +
            "WHERE LOWER(ProvinceState) = LOWER(\""+ Country +"\") " +
            "AND DATE BETWEEN \""+ datefrom +"\" AND \""+ dateto +"\" " +
            "GROUP BY Date ORDER BY Date) as b " +
            "WHERE a.DATE >= b.DATE " +
            "GROUP BY a.DATE;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("CumulativeTotal");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> getStateCumulativeDeaths(String datefrom, String dateto, String Country) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT a.Date, SUM(b.Cumulative) CumulativeTotal FROM " +
           " (SELECT Date, SUM(Deaths) Cumulative FROM StateDaily " +
            "WHERE LOWER(ProvinceState) = LOWER(\""+ Country +"\") " +
            "AND DATE BETWEEN \""+ datefrom +"\" AND \""+ dateto +"\" " +
            "GROUP BY Date ORDER BY Date) as a, " +
            "(SELECT Date, SUM(Deaths) Cumulative FROM StateDaily " +
            "WHERE LOWER(ProvinceState) = LOWER(\""+ Country +"\") " +
            "AND DATE BETWEEN \""+ datefrom +"\" AND \""+ dateto +"\" " +
            "GROUP BY Date ORDER BY Date) as b " +
            "WHERE a.DATE >= b.DATE " +
            "GROUP BY a.DATE;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("CumulativeTotal");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Double> getCaseDeathToPopulation() {
        ArrayList<Double> result = new ArrayList<Double>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select cd.CountryRegion, IFNULL(round((Sum(cd.Deaths)+Sum(cd.Cases))/c.population * 100, 3), 0) " +
            "From CountryDaily as cd " +
            "JOIN Country as c " +
            "ON c.name = cd.CountryRegion " +
            "Group By CountryRegion " +
            "Order By  CountryRegion  asc;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query reslts
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Double result2         = results.getDouble("IFNULL(round((Sum(cd.Deaths)+Sum(cd.Cases))/c.population * 100, 3), 0)");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<String> getSimilarClimate(String Country) {
        ArrayList<String> result = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select Name, Latitude " +
            "From Country " +
            "Where Latitude < (Select Latitude + 5 " +
            "From Country Where Name = \""+ Country +"\") AND Latitude > (Select Latitude - 5 " +
            "From Country Where Name = \""+ Country +"\");";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String result2         = results.getString("Name");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<String> getNearestCountries(String Country) {
        ArrayList<String> result = new ArrayList<String>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select Name, Latitude, Longitude " +
            "From Country " +
            "Where Latitude < (Select Latitude + 30 " +
            "From Country Where Name = \""+ Country +"\") AND Latitude > (Select Latitude - 30 " +
            "From Country Where Name = \""+ Country +"\") AND Longitude < (Select Longitude + 30 " +
            "From Country Where Name = \""+ Country +"\") AND Longitude > (Select Longitude - 30 " +
            "From Country Where Name = \""+ Country +"\"); ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String result2         = results.getString("Name");

                // For now we will just store the movieName and ignore the id
                result.add(result2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public ArrayList<Integer> getDailyCasesArrayList(String countryState) {
        ArrayList<Integer> dailyCases = new ArrayList<Integer>();


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT CountryState, Date, Cases FROM CountryStateDailyCases WHERE CountryState = '" + countryState + "'ORDER BY Date;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer cases         = results.getInt("Cases");

                // For now we will just store the movieName and ignore the id
                dailyCases.add(cases);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return dailyCases;
    }

    public Integer getTotalCases(String Country) {
        Integer result = 0;


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT c.name, c.Population, SUM(cd.cases), Sum(cd.deaths) " +
            "FROM Country as c " +
            "JOIN CountryDaily as cd " +
            "ON c.name = cd.CountryRegion " +
            "Where c.name = \""+ Country +"\" " +
            "Group by c.name; ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("SUM(cd.cases)");

                // For now we will just store the movieName and ignore the id
                result = result2;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

    public Integer getTotalDeaths(String Country) {
        Integer result = 0;


        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT c.name, c.Population, SUM(cd.cases), Sum(cd.deaths) " +
            "FROM Country as c " +
            "JOIN CountryDaily as cd " +
            "ON c.name = cd.CountryRegion " +
            "Where c.name = \""+ Country +"\" " +
            "Group by c.name; ";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                Integer result2         = results.getInt("Sum(cd.deaths)");

                // For now we will just store the movieName and ignore the id
                result = result2;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        // Finally we return all of the movies
        return result;
    }

}



