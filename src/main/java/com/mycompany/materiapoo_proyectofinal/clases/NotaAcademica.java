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
public class NotaAcademica extends Nota{
    private String objetivosAprendizaje;

    public NotaAcademica() {
    }

    public NotaAcademica(String objetivosAprendizaje, int idNota, String tituloNota, Date fechaCreacion, String descripcion) {
        super(idNota, tituloNota, fechaCreacion, descripcion);
        this.objetivosAprendizaje = objetivosAprendizaje;
    }

    public NotaAcademica(String objetivosAprendizaje, String tituloNota, Date fechaCreacion, String descripcion) {
        super(tituloNota, fechaCreacion, descripcion);
        this.objetivosAprendizaje = objetivosAprendizaje;
    }

    public String getObjetivosAprendizaje() {
        return objetivosAprendizaje;
    }

    public void setObjetivosAprendizaje(String objetivosAprendizaje) {
        this.objetivosAprendizaje = objetivosAprendizaje;
    }

    @Override
    public String toString() {
        return getTituloNota()+" - "+ getDescripcion()+" - " + objetivosAprendizaje;
    }

    
    
    
    
}
