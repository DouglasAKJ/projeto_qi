package model;

public class NotaFilme {
    private String id;
    private String nota;
    private String review;
    private String status;

    public NotaFilme() {
    }
    
    

    public NotaFilme(String nota, String review, String status) {
        this.nota = nota;
        this.review = review;
        this.status = status;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
