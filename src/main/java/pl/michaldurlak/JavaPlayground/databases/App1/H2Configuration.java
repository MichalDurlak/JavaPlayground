package pl.michaldurlak.JavaPlayground.databases.App1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Configuration {

    private static String H2DRIVER = "org.h2.Driver";

    // adres do bazy danych ktora znajduje sie w pamieci
    private static String H2ADDR = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";

    // username i password jest puste dla bazy ktora jest w pamieci
    private static String USER ="" ;
    private static String PASSWORD = "";


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection connection = getDBConnection();

        if(connection!=null){
            System.out.println("Connected " + connection);
        }

    }


    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;

        // na początku implementujemy driver -> driver do Oracle, driver do MSSQL, driver do H2
        Class.forName(H2DRIVER);

        connection = DriverManager.getConnection(H2ADDR, USER, PASSWORD);


        return connection;
    }

}
