/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ventas.controlador;

import com.ventas.modelo.Cliente;
import com.ventas.modelo.ClienteDAO;
import com.ventas.modelo.Empleado;
import com.ventas.modelo.EmpleadoDAO;
import com.ventas.modelo.Producto;
import com.ventas.modelo.ProductoDAO;
import com.ventas.modelo.Venta;
import com.ventas.modelo.VentaDAO;
import com.ventas.utiles.ConexionDB;
import com.ventas.utiles.GenerarSerie;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.persistence.metamodel.SetAttribute;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Cliente cl = new Cliente();
    ClienteDAO ecl = new ClienteDAO();
    Producto pro = new Producto();
    ProductoDAO epro = new ProductoDAO();
    int ide;
    int idc;
    int idp;
    //variables para registrar venta
    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    String numeroserie;
    VentaDAO vdao = new VentaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            System.out.println("ingresaste a empleado");
            System.out.println(accion);
            System.out.println(menu);
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    System.out.println("ingresaste con exito!");
                    String dni = request.getParameter("txtCi");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTelefono");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");

                    em.setCi(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtCi");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTelefono");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setCi(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);//se cambio ide por 0
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    System.out.println("no pudiste entrar");
                    throw new AssertionError();
            }
            request.getRequestDispatcher("empleado.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            System.out.println("ingresaste a cliente");
            System.out.println(accion);
            System.out.println(menu);
            switch (accion) {
                case "Listar":
                    lista = ecl.listar();
                    System.out.println("tamaño" + lista.size());
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtCi");
                    String nom = request.getParameter("txtNombres");
                    String dir = request.getParameter("txtDireccion");
                    String est = request.getParameter("txtEstado");
                    cl.setCi(dni);
                    cl.setNombres(nom);
                    cl.setDireccion(dir);
                    cl.setEstado(est);
                    ecl.agregar(cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    System.out.println("estas en editar");
                    ide = Integer.parseInt(request.getParameter("id"));
                    Cliente c = ecl.listarId(ide);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":

                    String dni1 = request.getParameter("txtCi");
                    String nom1 = request.getParameter("txtNombres");
                    String dir1 = request.getParameter("txtDireccion");
                    String est1 = request.getParameter("txtEstado");
                    cl.setCi(dni1);
                    cl.setNombres(nom1);
                    cl.setDireccion(dir1);
                    cl.setEstado(est1);
                    cl.setId(ide);//se cambio ide por 0
                    ecl.actualizar(cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idc = Integer.parseInt(request.getParameter("id"));
                    ecl.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("clientes.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            System.out.println("ingresaste a producto");
            System.out.println(accion);
            System.out.println(menu);
            switch (accion) {
                case "Listar":
                    List lista = epro.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    String nom = request.getParameter("txtNombres");
                    String pre = request.getParameter("txtPrecio");
                    int st = Integer.parseInt(request.getParameter("txtStock"));
                    String est = request.getParameter("txtEstado");
                    pro.setNombres(nom);
                    pro.setPrecio(Double.parseDouble(pre));
                    pro.setStock(st);
                    pro.setEstado(est);
                    epro.agregar(pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Producto pro = epro.listarId(ide);
                    request.setAttribute("producto", pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    Producto pro1 = new Producto();
                    String nom1 = request.getParameter("txtNombres");
                    Double pre1 = Double.parseDouble(request.getParameter("txtPrecio"));
                    int st1 = Integer.parseInt(request.getParameter("txtStock"));
                    String est1 = request.getParameter("txtEstado");
                    pro1.setNombres(nom1);
                    pro1.setPrecio(pre1);
                    pro1.setStock(st1);
                    pro1.setEstado(est1);
                    pro1.setId(ide);//se cambio ide por 0
                    epro.actualizar(pro1);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    epro.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("producto.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String ci = request.getParameter("codigoCliente");
                    cl.setCi(ci);
                    cl = ecl.buscar(ci);
                    request.setAttribute("c", cl);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoProducto"));
                    pro = epro.listarId(id);
                    request.setAttribute("c", cl);
                    request.setAttribute("producto", pro);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("nserie", numeroserie);
                    break;

                case "Agregar":
                    request.setAttribute("c", cl);
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = pro.getId();
                    descripcion = request.getParameter("nomproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;
                    v = new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                    DateFormat dateFormat = new SimpleDateFormat("d MMM yyyy, HH:mm:ss ");
                    String f = dateFormat.format(new Date());
                    request.setAttribute("fecha", f);

                    break;
                case "GenerarVenta":

                    //actualizar stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cantidad = lista.get(i).getCantidad();
                        int idproducto = lista.get(i).getIdproducto();
                        ProductoDAO aO = new ProductoDAO();
                        System.out.println(idproducto + " id");
                        pr = aO.buscar(idproducto);
                        System.out.println(pr.getStock() + "estok actual");
                        int sac = pr.getStock() - cantidad;
                        aO.actualizarstock(idproducto, sac);
                    }
                    //guardarVenta
                    v.setIdcliente(cl.getId());
                    v.setIdempleado(1);//complemenetar
                    v.setNumserie(numeroserie);
                    v.setFecha("2023-06-26");//complementar

                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVentas(v);
                    //Guardar Detalle ventas
                    int idv = Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleVentas(v);
                    }
                    request.getRequestDispatcher("Controlador?menu=NuevaVenta&accion=default").forward(request, response);
                    break;

                default:
                    v = new Venta();
                    totalPagar = 0.0;
                    lista = new ArrayList<>();
                    numeroserie = vdao.GenerarSerie();
                    System.out.println("numero de serie:" + numeroserie);
                    if (numeroserie == null) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();

                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("registrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("registrarVenta.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
