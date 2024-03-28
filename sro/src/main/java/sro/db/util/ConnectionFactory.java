/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sro.db.util;
///import com.mysql.jdbc.Driver;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
   //    public static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/pn_huila_db?useSSL=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASS = "root";

   
    public static Connection getConnection()
    {
      try {
          DriverManager.registerDriver(new Driver());
          return DriverManager.getConnection(URL, USER, PASS);
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
    }

}
