/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.materiapoo_proyectofinal.clases;

import java.util.Date;

/**
 *
 * @author USUARIO
 */
public abstract class  Nota {
    private int idNota;
    private String tituloNota;
    private  Date fechaCreacion;
    private String descripcion;

    public Nota() {
    }

    public Nota(int idNota, String tituloNota, Date fechaCreacion, String descripcion) {
        this.idNota = idNota;
        this.tituloNota = tituloNota;
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
    }

    public Nota(String tituloNota, Date fechaCreacion, String descripcion) {
        this.tituloNota = tituloNota;
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getTituloNota() {
        return tituloNota;
    }

    public void setTituloNota(String tituloNota) {
        this.tituloNota = tituloNota;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Nota{" + "idNota=" + idNota + ", tituloNota=" + tituloNota + ", fechaCreacion=" + fechaCreacion + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
    
    
    
    
    
}
