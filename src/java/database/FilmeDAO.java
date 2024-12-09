package database;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Filme;

public class FilmeDAO {
    
    private static Connection conn;
    
    public FilmeDAO() throws ClassNotFoundException, SQLException {
        conn = Conexao.getConn();
    }
    
    public ArrayList<Filme> getAllMovies() throws SQLException {
        
        ArrayList<Filme> list = new ArrayList();
        
        String query = "select * from filmes;";
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        ResultSet res = prep.executeQuery();
        
        while( res.next() ) {
            Filme filme = new Filme();
            
            filme.setTitulo(res.getString("titulo") );
            filme.setNota(res.getString("nota"));
            filme.setSinopse(res.getString("sinopse") );
            filme.setCategorias(res.getString("categorias"));
            filme.setAutor(res.getString("diretor") );
            
            list.add(filme);
        }
        
        prep.close();
        return list;
    }

    
}
