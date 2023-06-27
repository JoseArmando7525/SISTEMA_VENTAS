package com.ventas.controlador;

import com.ventas.modelo.Empleado;
import com.ventas.modelo.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {

    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado em = new Empleado();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if(accion.equalsIgnoreCase("ingresar")){
            String user = request.getParameter("txtuser");
            String password = request.getParameter("txtpass");
            em = edao.validar(user, password);
            if(em.getUser()!=""){
                request.setAttribute("usuario",em);
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
            }else{               
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
