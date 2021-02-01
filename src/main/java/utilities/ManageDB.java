package utilities;

import java.sql.DriverManager;

public class ManageDB extends CommonOpps{

    /*
    ####################################################################################################
    Method name: openConnection
    Method description: This method opens connection to MySQL database
    Method parameters: String dbURL - Database URL; Strings user and pass - credentials for connection
    Method return: none
    ####################################################################################################
     */
    public static void openConnection(String dbURL, String user, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, user, pass);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error occurred while connecting to DB; see details: " + e);
        }
    }

    /*
     #####################################################################
     Method name: closeConnection
     Method description: This method closes connection from MySQL database
     Method parameter: none
     Method return: none
     #####################################################################
   */
    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error occurred while closing DB; see details: " + e);
        }
    }
}
