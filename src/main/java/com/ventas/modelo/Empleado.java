package com.ventas.modelo;

public class Empleado {

    private int id;
    private String ci;
    private String nom;
    private String tel;
    private String estado;
    private String user;

    public Empleado() {
        this.id = 0;
        this.ci="";
        this.nom="";
        this.tel="";
        this.estado="";
        this.user="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
