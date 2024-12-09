<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Filme"%>
<%@page import="database.FilmeAssistidoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
    session = request.getSession();
    model.Usuario usuario = (model.Usuario) session.getAttribute("userLogged");
    
    if (usuario == null) {
        response.sendRedirect("login.jsp");
    }
    
    int usuarioId = usuario.getId();
    FilmeAssistidoDAO filmeAssistidoDAO = new FilmeAssistidoDAO();
    ArrayList<Filme> filmesAssistidos = filmeAssistidoDAO.getFilmesAssistidos(usuarioId);
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Filmes Assistidos</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Meus Filmes Assistidos</h2>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Nome do Filme</th>
                    <th>Nota</th>
                    <th>Data de Assistência</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    if (filmesAssistidos.isEmpty()) {
                %>
                    <tr>
                        <td colspan="3">Você ainda não assistiu nenhum filme.</td>
                    </tr>
                <% 
                    } else {
                        for (Filme filme : filmesAssistidos) {
                %>
                    <tr>
                        <td><%= filme.getTitulo() %></td>
                        <td><%= filme.getNota() %></td>
                    </tr>
                <% 
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>