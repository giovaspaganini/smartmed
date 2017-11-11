<%-- 
    Document   : indexAluno1
    Created on : 02/10/2017, 22:20:40
    Author     : Rodrigo
    Modified   : GIOVANI PAGANINI
--%>
<%@page import="chat.dao.model.Sessaochat"%>
<%@page import="chat.dao.UsuarioDao"%>
<%@page import="chat.dao.model.Usuario"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
        <title>SmartMED - Dashboard Aluno</title>

        <meta name="author" content="Giovani Paganini">
        <meta name="description" content="Desenvolvimento de sites responsivos e modernos atendendo suas necessidades.">
        <meta name="robots" content="all">

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link rel="shortcut icon" href="favicon.png"/>
        <script src="https://use.fontawesome.com/82f3f5046b.js">
        </script>
    </head>
    <body>
        <%
            HttpSession sessao = request.getSession();
            sessao = request.getSession();
            Usuario usuarioTemp = new Usuario();
            Usuario usuarioLogado = new Usuario();
            usuarioTemp.id = (Integer) sessao.getAttribute("idUsuario");
            UsuarioDao dao = new UsuarioDao();
            usuarioLogado = dao.buscar(usuarioTemp);

            //out.print("<h1>usuarioLogado.id:" + usuarioLogado.id + " </h1>");
        %>

        <div class="navbar-fixed">
            <nav class="cyan lighten-1" role="navigation">
                <div class="nav-wrapper container">
                    <a id="logo-container" href="#" class="brand-logo white-text light"><i class="large material-icons left">local_hospital</i> SmartMED</a>
                    <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>

                    <ul class="right hide-on-med-and-down">
                        <li class="active"><a class="white-text light" href="index.html"><i class="material-icons">dashboard</i></a></li>
                        <li><a href="#"><i class="material-icons">settings</i></a></li>
                        <li><a href="#"><i class="material-icons">people</i></a></li>
                        <li><a href="#"><i class="material-icons">security</i></a></li>        
                    </ul>

                    <ul id="nav-mobile" class="side-nav">
                        <li class="active"><a class="white-text light" href="index.html"><i class="material-icons">dashboard</i></a></li>
                        <li><a href="about.html"><i class="material-icons">settings</i></a></li>
                        <li><a href="services.html"><i class="material-icons">people</i></a></li>
                        <li><a href="contact.php"><i class="material-icons">security</i></a></li>                                
                    </ul>      
                </div>
            </nav>
        </div>

        <div id="usuarios" class="section row container">
            <div class="section">
                <div class="col s12 z-depth-1 card-panel">
                    <h1>Aluno: <%=usuarioLogado.nome%></h1>

                    <%
                        if (usuarioLogado.sessoesDisponiveis.isEmpty()) {
                            out.print("<h1>Não há sessões disponíveis </h1>");
                        } else {
                            out.print("<h1>Sessões disponíveis: </h1> ");
                            for (Sessaochat sessaoDisponivel : usuarioLogado.sessoesDisponiveis) {
                                out.print("<h1>Sessao ID:" + sessaoDisponivel.id
                                        + ", Curso:" + sessaoDisponivel.cursoRelacionado
                                        + ", Objetivo:" + sessaoDisponivel.objetivo + " </h1>");
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
