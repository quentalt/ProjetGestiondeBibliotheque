/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Livre;
import Livre.InscrEmp;
import Livre.jFrame;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author Nicole
 */
public class Bibliotheque {

    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/projet_bibliotheque";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String MAX_POOL = "250";

    private Connection connection;
    private Properties properties;
    private Properties getProperties(){
        if(properties == null){
            properties =new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    public Connection connect(){
        if (connection == null){
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
                System.out.println("Connexion Réussi");
            }catch(ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }
    
    public void disconnect(){
        try{
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            // TODO code application logic here
            InscrEmp emprunt = new InscrEmp();
        }
}
