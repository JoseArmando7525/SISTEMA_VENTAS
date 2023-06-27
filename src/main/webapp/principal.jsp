<%-- 
    Document   : principal
    Created on : 20 jun. 2023, 14:02:29
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body {
                background-image: url(imagenes/upea1.png);
                background-position: center center;
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
                background-color: #66999;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <img src="imagenes/compras.jpeg" width="30" height="30" class="d-inline-block align-top" alt="">
            ARCHITECNOLOGY

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left:10px;border:none" class="btn btn-outline-ligth" 
                           href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left:10px;border:none" class="btn btn-outline-ligth" 
                           href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left:10px;border:none" class="btn btn-outline-ligth" 
                           href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left:10px;border:none" class="btn btn-outline-ligth" 
                           href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva venta</a>
                    </li>
                </ul>
            </div>
            <div class="dropdown">
                <button style="border:none"class="btn btn-outline-ligth dropdown-toggle" 
                        type="button" id="dropdownMenuButton" data-toggle="dropdown">
                    Usuario ingresado: ${usuario.getNom()}
                </button>
                <div class="dropdown-menu text-center" >
                    <a class="dropdown-item" href="#">
                        <img src="imagenes/usuario.png" alt="60" width="60"/>
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                    <a class="dropdown-item" href="#">MasterTeam@gmail.com</a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST">                          
                        <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                    </form>                       
                </div>
            </div>
            <form class="form-inline">
                <input class="form-control mr-sm-2" type="search" placeholder="Buscar" aria-label="Buscar">
                <button type="button"class="btn btn-secondary" type="submit" background-color="cyan">Search</button>
            </form>
        </div>
    </nav>
    <div class="m-4" style="height: 550px;">
        <iframe name="myFrame" style="height: 100%;width: 100%; border:none">

        </iframe>
    </div>                
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
