<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Venta</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            @media print{
                .parte01, .btn,.accion{
                    display:none;
                }
            }
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5 parte01">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente:</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="search" name="codigoCliente" value="${c.getCi()}"class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombrescliente" value="${c.getNombres()}" class="form-control">
                                </div>

                            </div>
                                <!-- Datos del producto -->
                            <div class="form-group">
                                <label>Datos Del Producto:</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="search" name="codigoProducto"  
                                           class="form-control" value="${producto.getId()}"placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nomproducto" value="${producto.getNombres()}"
                                           placeholder="Datos Producto" class="form-control">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${producto.getPrecio()}" 
                                           class="form-control" placeholder="Bs/.0.00">
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" value="1" name="cant" placeholder="" class="form-control">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${producto.getStock()}" placeholder="stock" class="form-control">
                                </div>
                            </div>
                            <!-- boton agregar al registro -->
                            <div class="form-group">
                                <div class="col-sm-3">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <!-<!-- NUMERO DE SERIE -->
                        <img src="imagenes/compras.jpeg" width="30" height="30" class="d-inline-block align-top" alt="">
            ARCHITECNOLOGY
                        <div class="d-flex col-sm-6 ml-auto">
                            <label>Número De Factura: </label>
                            <input type="text" name="NroSerie" value="${nserie}"class="form-control col-sm-6">
                        </div>
                        <div class="d-flex">
                            <label>Nombre Cliente: </label>
                            <input type="text" name="NroSerie" value="${c.getNombres()}"class="form-control col-sm-5">
                        </div>
                        <div class="d-flex">
                            <label>Fecha: </label>
                            <input type="text" name="NroSerie" value="${fecha}"class="form-control col-sm-5">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr class="text-center">
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                   <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdproducto()}</td>
                                    <td>${list.getDescripcionP()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    <td class="d-flex">
                                        <a href="#" class="btn btn-info">EDITAR</a>
                                        <a href="#" class="btn btn-danger" style="margin-left: 10px">ELIMINAR</a>
                                    </td>
                                </tr>                                    
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()"class="btn btn-outline-success">Generar Venta</a>
                            <a href="Controlador?menu=NuevaVenta&accion=default"class="btn btn-outline-danger">Cancelar</a>
                        </div> 
                        <div class="col-sm-3 ml-auto">
                            <input type="text" name="txtTotal" value="Bs/. ${totalPagar}" class="form-control">
                        </div>
                    </div>
                </div>
            </div> 
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
