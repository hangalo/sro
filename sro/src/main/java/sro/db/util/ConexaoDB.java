
package sro.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoDB {

 private static final String URL = "jdbc:mysql://127.0.0.1:3306/pn_huila_db?useSSL=false&serverTimezone=UTC";
   //  private static final String URL = "jdbc:mysql://127.0.0.1:3306/pn_huila_db?useSSL=false&serverTimezone=UTC?noDatetimeStringSync=true?allowMultiQueries=True?autoReconnect=True";
    
    /*
    noDatetimeStringSync=true&allowMultiQueries=True&autoReconnect=True"
    */
    
    private static final String DRIVERMYSQL8 = "com.mysql.cj.jdbc.Driver";
    private static final String DRIVERMYSQL5 = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection conn;

    public static Connection fezarConexao() {
        if (conn == null) {
            try {
                Class.forName(DRIVERMYSQL8);
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException ex) {
               
                System.err.println("Erro na conexao com a base de dados: " + ex.getMessage());
                return null;
            }

        }
        return conn;
    }

    public static void fechar(Connection conn) {
        fecha(conn, null, null, null);
    }

    public static void fechar(Statement st) {
        fecha(null, null, null, st);
    }

    public static void fechar(Connection conn, PreparedStatement ps) {
        fecha(conn, ps, null, null);
    }

    public static void fechar(Connection conn, PreparedStatement ps, ResultSet rs) {
        fecha(conn, ps, rs, null);
    }

    public static void fechar(Connection conn, PreparedStatement ps, ResultSet rs, Statement st) {
        fecha(conn, ps, rs, st);
    }

    private static void fecha(Connection conn, PreparedStatement ps, ResultSet rs, Statement st) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao desalocar recurso: " + ex.getMessage());
        }

    }

}
