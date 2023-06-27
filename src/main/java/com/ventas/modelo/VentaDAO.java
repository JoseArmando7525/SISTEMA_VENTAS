package com.ventas.modelo;

import com.ventas.utiles.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentaDAO {

    Connection con;
    ConexionDB cn = new ConexionDB();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public String GenerarSerie() {
        String numeroserie = "";
        String sql = "select max(numeroSerie) from ventas";
        try {
            //se genero la serie
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroserie = rs.getString(1);
            }
        } catch (SQLException e) {

        }
        return numeroserie;
    }

    public String IdVentas() {
        String idventas="";
        String sql = "select max(idVentas) from ventas";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idventas = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idventas;
    }

    public int guardarVentas(Venta ve) {
        String sql = "insert into ventas(idCliente,idEmpleado,numeroSerie,fechaVentas,monto,estado)values(?,?,?,?,?,?)";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getIdcliente());
            ps.setInt(2, ve.getIdempleado());
            ps.setString(3, ve.getNumserie());
            ps.setString(4, ve.getFecha());
            ps.setDouble(5, ve.getMonto());
            ps.setString(6, ve.getEstado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    public int guardarDetalleVentas(Venta ve){
        String sql = "insert into detalle_ventas(idVentas,idProducto,cantidad,precioVenta) values(?,?,?,?)";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getId());
            ps.setInt(2, ve.getIdproducto());
            ps.setInt(3, ve.getCantidad());
            ps.setDouble(4, ve.getPrecio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
