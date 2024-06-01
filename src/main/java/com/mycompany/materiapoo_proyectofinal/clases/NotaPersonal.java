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
public class NotaPersonal extends Nota{
    
    private String estadoAnimo;

    public NotaPersonal(String estadoAnimo, int idNota, String tituloNota, Date fechaCreacion, String descripcion) {
        super(idNota, tituloNota, fechaCreacion, descripcion);
        this.estadoAnimo = estadoAnimo;
    }

    public NotaPersonal(String estadoAnimo, String tituloNota, Date fechaCreacion, String descripcion) {
        super(tituloNota, fechaCreacion, descripcion);
        this.estadoAnimo = estadoAnimo;
    }

    public NotaPersonal() {
    }

    public String getEstadoAnimo() {
        return estadoAnimo;
    }

    public void setEstadoAnimo(String estadoAnimo) {
        this.estadoAnimo = estadoAnimo;
    }

    @Override
    public String toString() {
        return getTituloNota()+" - "+ getDescripcion()+" - "+ estadoAnimo ;
    }
    
    
    
    
}
