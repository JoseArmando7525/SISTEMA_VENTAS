
package com.ventas.modelo;

import com.ventas.utiles.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    ConexionDB conn = new ConexionDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    //OPERACIONES PARA ACTUALIZAR STOCK
    public Producto buscar(int id){
        Producto p = new Producto();
       String sql="select * from producto where idProducto="+id;
       try{
           con=conn.conectar();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while (rs.next()){
               p.setId(rs.getInt(1));
               p.setNombres(rs.getString(2));
               p.setPrecio(rs.getDouble(3));
               p.setStock(rs.getInt(4));
               p.setEstado(rs.getString(5));
               System.out.println(p.getNombres()+"artefacto");
           }
       }catch (SQLException e){
       }
       return p;
   }
   public int actualizarstock(int id, int stock){
       String sql="update producto set stock=? where idProducto=?";
       try{
           con=conn.conectar();
           ps=con.prepareStatement(sql);
           ps.setInt(1, stock);
           ps.setInt(2, id);
           ps.executeUpdate();
       }catch (SQLException e){
       }
       return r;
   }

    
    //OPERACIONES CRUD
    public List listar(){
        String sql = "select * from producto";
        List<Producto>lista = new ArrayList<>();
        try{
            con = conn.conectar();
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                Producto pro = new Producto();
                pro.setId(rs.getInt(1));
                pro.setNombres(rs.getString(2));
                pro.setPrecio(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
                lista.add(pro);
            }
        }catch(SQLException e){
            System.out.println("Error de SQL "+e.getMessage());
        }
        return lista;
    }
    public int agregar(Producto pro){
        System.out.println("Estas en agregar");
        String sql="insert into producto (nombres, precio, stock,estado)Values(?,?,?,?)";
        try{
            con = conn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombres());
            ps.setDouble(2, pro.getPrecio());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error de SQL "+e.getMessage());
        }
        return r;
    }
    public Producto listarId(int id){
        Producto pro = new Producto();
        String sql="select * from producto where idProducto="+id;
        try{
            con = conn.conectar();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                pro.setId(rs.getInt(1));
                pro.setNombres(rs.getString(2));
                pro.setPrecio(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
        }
    }catch(Exception e){
        System.out.println("Error de SQL "+e.getMessage());
        }
        return pro;
    }
    public int actualizar(Producto pro){
        String sql="update producto set nombres=?, precio=?, stock=?, estado=? where idProducto=?";
        try{
            con=conn.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getNombres());
            ps.setDouble(2, pro.getPrecio());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());
            ps.setInt(5, pro.getId());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Error de SQL "+e.getMessage());
        }
        return r;
    }
    public void delete(int id){    
        String sql="delete from producto where idProducto="+id;
        try{
            con=conn.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Error de SQL "+e.getMessage());
        }
    }
}
