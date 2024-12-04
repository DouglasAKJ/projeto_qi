package database;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.NotaFilme;

public class NotaFilmeDAO {
    
    private static Connection conn;
    
    public  NotaFilmeDAO() throws ClassNotFoundException, SQLException {
        conn = Conexao.getConn();
    }
    
    public ArrayList<NotaFilme> getAllNotas() throws SQLException {
        
        ArrayList<NotaFilme> list = new ArrayList();
        
        String query = "select * from nota_filmes;";
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        ResultSet res = prep.executeQuery();
        
        while( res.next() ) {
            NotaFilme notaFilme = new NotaFilme();
            
            notaFilme.setNota(res.getString("nota") );
            notaFilme.setReview(res.getString("review") );
            notaFilme.setStatus(res.getString("status_filme") );

            
            list.add(notaFilme);
        }
        
        prep.close();
        return list;
    }
    
     public void setNewNota(NotaFilme notaFilme) throws SQLException {
        String query = "insert into nota_filmes(nota, review, status_filme) values(?, ?, ?)";
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        prep.setString(1, notaFilme.getNota());
        prep.setString(2, notaFilme.getReview());
        prep.setString(3, notaFilme.getStatus());
        
        prep.execute();
        prep.close();
    }
    
}