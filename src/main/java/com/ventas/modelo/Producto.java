
package com.ventas.modelo;

public class Producto {
    int id;
    String nombres;
    double precio;
    int stock;
    String estado;

    public Producto() {
        this.id=0;
        this.nombres="";
        this.precio=0;
        this.stock = 0;
        this.estado ="";
    }

    public int getId() {
        return id;
    }

    public void setId(int idProducto) {
        this.id = idProducto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
        
}
