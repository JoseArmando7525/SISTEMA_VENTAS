
package com.ventas.modelo;

import com.ventas.utiles.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    ConexionDB conn = new ConexionDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Cliente buscar(String ci) {
        Cliente c = new Cliente();
        String sql = "Select * from cliente where ci=" + ci;
        try {
            con = conn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setCi(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("Error de SQL "+e.getMessage());
        }
        return c;
    }
    
    //OPERACIONES CRUD
    public List listar(){
        String sql = "select * from cliente";
        List<Cliente>lista = new ArrayList<>();
        try{
            con = conn.conectar();
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setId(rs.getInt(1));
                cl.setCi(rs.getString(2));
                cl.setNombres(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setEstado(rs.getString(5));
                lista.add(cl);
                System.out.println("listaste cliente");
            }
        }catch(SQLException e){
            System.out.println("Error de SQL "+e.getMessage());
        }
        return lista;
    }
    public int agregar(Cliente em){
        String sql="insert into cliente (ci, nombres, direccion, estado)Values(?,?,?,?)";
        try{
            con = conn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getCi());
            ps.setString(2, em.getNombres());
            ps.setString(3, em.getDireccion());
            ps.setString(4, em.getEstado());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error de SQL "+e.getMessage());
        }
        return r;
    }
    public Cliente listarId(int id){
        Cliente c= new Cliente();
        String sql="select* from cliente where idCliente="+id;
        try{
            con = conn.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                c.setId(rs.getInt(1));
                c.setCi(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
        }
    }catch(SQLException e){
        System.out.println("Error de SQL "+e.getMessage());
        }
        return c;
    }
    public int actualizar(Cliente e){
        System.out.println("estas en actualizar");
        String sql="update cliente set ci=?, nombres=?, direccion=?, estado=? where idCliente=?";
        try{
            con=conn.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, e.getCi());
            ps.setString(2, e.getNombres());
            ps.setString(3, e.getDireccion());
            ps.setString(4, e.getEstado());
            ps.setInt(5, e.getId());
            ps.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error de SQL "+ex.getMessage());
        }
        return r;
    }
    public void delete(int id){    
        String sql="delete from cliente where idCliente="+id;
        try{
            con=conn.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error de SQL "+e.getMessage());
        }
    }
}
