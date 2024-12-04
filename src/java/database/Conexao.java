package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    private static Connection conn;
    
    public static Connection getConn() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sistema_filmes",
                "root",
                ""
        );
        
        System.out.println(conn.getCatalog());
         return conn;
    }
    
}
