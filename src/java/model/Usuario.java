package model;

import database.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.tomcat.dbcp.dbcp2.SQLExceptionList;


public class Usuario {
    
   private int id;
   private String nome;
   private String email;
   private String senha;
    
   public Usuario(){};
    
   public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
   public Usuario(String email, String senha){
        this.email = email;
        this.senha = senha;
    }
   
   public Usuario(int id, String nome, String email){
       this.id = id;
       this.nome = nome;
       this.email = email;
   }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean login() throws ClassNotFoundException, SQLException {
        boolean key = false;
        UsuarioDAO dao = new UsuarioDAO();
        ArrayList<Usuario> list = dao.getAllUsers();
        
        for (Usuario i : list){
            if(i.getEmail().equals(this.email)){
                if(i.getSenha().equals(this.senha)){
                    key = true;
                }
            }
        }
        return key;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + '}';
    }
    
    
}
