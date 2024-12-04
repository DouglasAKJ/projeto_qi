

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="database.FilmeDAO"%>
<%@page import="model.Filme"%>
<%@page import="database.UsuarioDAO"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@include file="session/validar.jsp"%>

<%
    FilmeDAO dao = new FilmeDAO();
    ArrayList<Filme> list = dao.getAllMovies();
    Usuario u = (Usuario) request.getSession().getAttribute("userLogged");

        // Seleção aleatória do filme
    Filme filmeAleatorio = null;
    if (list != null && !list.isEmpty()) {
        int randomIndex = (int) (Math.random() * list.size());
        filmeAleatorio = list.get(randomIndex);
    }

    String filmeNome = (filmeAleatorio != null) ? filmeAleatorio.getTitulo() : "Nenhum filme disponível";
    request.setAttribute("filmeNome", filmeNome);
        
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class=" container text-center mt-4">
        <h1>Pagina Inicial</h1>
        <div class="container mt-5">
        <h2> Selecione seu filme</h2>
        </div>
        <form class="container mt-5" method="get" action="filmes.jsp">
        <button class="btn btn-primary" type="submit" id="botao" > Escolher filme </button>
        </form>
        <p id="filme" class="container mt-4">Filme escolhido: <%= request.getAttribute("filmeNome") %></p>
        </div>
       
           
           
        <script>   

        </script>
    </body>
</html>
