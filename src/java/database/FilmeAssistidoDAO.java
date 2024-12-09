package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;
import model.Filme;
import java.sql.ResultSet;

public class FilmeAssistidoDAO {

    private Connection connection;

    public FilmeAssistidoDAO() throws SQLException, ClassNotFoundException {
        connection = Conexao.getConn();
    }

    public void marcarComoAssistido(int usuarioId, int filmeId) throws SQLException {
        String sql = "INSERT INTO filmes_assistidos (usuario_id, filme_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, filmeId);
            stmt.executeUpdate();
        }
    }
    
    public ArrayList<Filme> getFilmesAssistidos(int usuarioId) throws SQLException {
        String sql = "SELECT f.id, f.titulo, f.nota, fa.data_assistencia "
                   + "FROM filmes_assistidos fa "
                   + "JOIN filmes f ON fa.filme_id = f.id "
                   + "WHERE fa.usuario_id = ? "
                   + "ORDER BY fa.data_assistencia DESC";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Filme> filmesAssistidos = new ArrayList<>();
            
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setId(rs.getInt("id"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setNota(rs.getString("nota"));
                filmesAssistidos.add(filme);
            }
            return filmesAssistidos;
        }
    }
}
