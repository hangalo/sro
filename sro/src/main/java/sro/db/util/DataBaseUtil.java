/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sro.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseUtil {
    private String URL = "jdbc:mysql://127.0.0.1:3306/pn_huila_db?useSSL=false&serverTimezone=UTC";
    private String DRIVERMYSQL8 = "com.mysql.cj.jdbc.Driver";
    private String DRIVERMYSQL5 = "com.mysql.jdbc.Driver";
    private String USER = "root";
    private String PASSWORD = "root";
    private Connection cx = null;

    public DataBaseUtil() {
    }

    public Connection getConnection() {
        if (cx == null) {
            try {
                Class.forName(DRIVERMYSQL8);
                  cx = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DataBaseUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
        return cx;
    }

    public Statement getStatement() throws SQLException, ClassNotFoundException {
        return getConnection().createStatement();
    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException {
        return getConnection().prepareStatement(sql);

    }

    public void closeAll() throws SQLException {
        if (cx != null) {
          //  cx.close();
        }
    }
}
