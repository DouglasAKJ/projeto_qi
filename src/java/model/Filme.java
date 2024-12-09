package model;

import java.util.ArrayList;

public class Filme {
    private int id;
    private String titulo;
    private String nota;
    private String sinopse;
    private String categorias;
    private String autor;
    
    
    public Filme(){};

    public Filme(String titulo, String nota, String sinopse) {
        this.titulo = titulo;
        this.nota = nota;
        this.sinopse = sinopse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String ator) {
        this.autor = ator;
    }
    
    
    
    
}
