

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

    
    String filmeNome = "Nenhum titulo selecionado";
    String filmeNota = "";
    String filmeSinopse = "";
    String filmeCategorias = "";
    String filmeAutor = "";
    int filmeId = -1;
         
    if (list != null && !list.isEmpty()){
    if (request.getParameter("escolherFilme") != null) {
        int randomIndex = (int) (Math.random() * list.size());
        Filme filmeAleatorio = list.get(randomIndex);
        filmeId = filmeAleatorio.getId();
        filmeNome = filmeAleatorio.getTitulo();
        filmeNota = filmeAleatorio.getNota();
        filmeSinopse = filmeAleatorio.getSinopse();
        filmeCategorias = filmeAleatorio.getCategorias();
        filmeAutor = filmeAleatorio.getAutor();
        
        
    }
    }

    
    request.setAttribute("filmeId", filmeId);
    request.setAttribute("filmeNome", filmeNome);
    request.setAttribute("filmeNota", filmeNota);
    request.setAttribute("filmeSinopse", filmeSinopse);
    request.setAttribute("filmeCategorias", filmeCategorias);
    request.setAttribute("filmeAutor", filmeAutor);
    
    
        
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <title>Escolha um filme</title>
        
        
    </head> 
    <body>
       <ul class="nav nav-underline ms-3">
        <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="minhaconta.jsp">Minha conta</a>
        </li>

       </ul>
        <div class=" container text-center mt-4 sm-10 md-6">
            <div class="row">  
            <h1>Pagina Inicial</h1>
                <div class="container mt-5">
                    <h2> Olá, <%= u.getNome() %> </h2>
                    <h2> Selecione seu filme</h2>
                </div>
            <form class="container mt-5" method="get" action="filmes.jsp">
                 
            <button class="btn btn-primary" type="submit" id="botao" name="escolherFilme" value="true"> Escolher filme </button>
            </form>
            <p id="filme" class="container mt-4">Filme escolhido: </p>
            <p id="filme" class="container mt-4"><%= request.getAttribute("filmeNome") %> </p>
            <p id="filme" class="container mt-4"><%= request.getAttribute("filmeNota") %></p>
            <p id="filme" class="container mt-4"><%= request.getAttribute("filmeSinopse") %></p>
            <p id="filme" class="container mt-4"><%= request.getAttribute("filmeCategorias") %></p>
            <p id="filme" class="container mt-4"><%= request.getAttribute("filmeAutor") %></p>
            </div>
            
        </div>
           
    </body>
</html>
