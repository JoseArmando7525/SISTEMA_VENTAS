
package com.ventas.modelo;

import com.ventas.utiles.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    
    ConexionDB conn = new ConexionDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Empleado validar(String user,String ci){
        Empleado em = new Empleado();
        String sql = "select * from empleado where user=? and ci=?";
        try{
            con=conn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, ci);
            rs = ps.executeQuery();
            while(rs.next()){
                em.setCi(rs.getString("ci"));
                em.setNom(rs.getString("nombres"));
                em.setId(rs.getInt("idEmpleado"));
                em.setTel(rs.getString("telefono"));
                em.setEstado(rs.getString("estado"));
                em.setUser(rs.getString("user"));
            }
        }catch(Exception e){          
        }
        return em;
    }
    //OPERACIONES CRUD
    public List listar(){
        String sql = "select* from empleado";
        List<Empleado>lista = new ArrayList<>();
        try{
            con = conn.conectar();
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setCi(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
            }
        }catch(SQLException e){
            System.out.println("Error de SQL "+e.getMessage());
        }
        return lista;
    }
    public int agregar(Empleado em){
        String sql="insert into empleado (ci, nombres, telefono, estado,user)Values(?,?,?,?,?)";
        try{
            con = conn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getCi());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error de SQL "+e.getMessage());
        }
        return r;
    }
    public Empleado listarId(int id){
        Empleado emp= new Empleado();
        String sql="select* from empleado where idEmpleado="+id;
        try{
            con = conn.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){               
                emp.setId(rs.getInt(1));
                emp.setCi(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
        }
    }catch(Exception e){
        System.out.println("Error de SQL "+e.getMessage());
        }
        return emp;
    }
    public int actualizar(Empleado em){
        String sql="update empleado set ci=?, nombres=?, telefono=?, estado=?,user=? where idEmpleado=?";
        try{
            con=conn.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getCi());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Error de SQL "+e.getMessage());
        }
        return r;
    }
    public void delete(int id){    
        String sql="delete from empleado where idEmpleado="+id;
        try{
            con=conn.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Error de SQL "+e.getMessage());
        }
    }
}
