/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

public class detalles {
    private String Nombre;
    private int cantidad;
    private int idEntrega;
    private Date Fecha_ent;
    private String Marca;
    private String Modelo;
    private String Nombre_emp;
    private String Pat_emp;
    private String Mat_emp;
    private int idDisp;

    public int getIdDisp() {
        return idDisp;
    }

    public void setIdDisp(int idDisp) {
        this.idDisp = idDisp;
    }
    
    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Date getFecha_ent() {
        return Fecha_ent;
    }

    public void setFecha_ent(Date Fecha_ent) {
        this.Fecha_ent = Fecha_ent;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getNombre_emp() {
        return Nombre_emp;
    }

    public void setNombre_emp(String Nombre_emp) {
        this.Nombre_emp = Nombre_emp;
    }

    public String getPat_emp() {
        return Pat_emp;
    }

    public void setPat_emp(String Pat_emp) {
        this.Pat_emp = Pat_emp;
    }

    public String getMat_emp() {
        return Mat_emp;
    }

    public void setMat_emp(String Mat_emp) {
        this.Mat_emp = Mat_emp;
    }



}
