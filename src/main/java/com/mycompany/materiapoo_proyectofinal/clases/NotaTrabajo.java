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
public class NotaTrabajo extends Nota{
    private String prioridad;
    private String recordatorios;

    public NotaTrabajo() {
    }

    public NotaTrabajo(String prioridad, String recordatorios, int idNota, String tituloNota, Date fechaCreacion, String descripcion) {
        super(idNota, tituloNota, fechaCreacion, descripcion);
        this.prioridad = prioridad;
        this.recordatorios = recordatorios;
    }

    public NotaTrabajo(String prioridad, String recordatorios, String tituloNota, Date fechaCreacion, String descripcion) {
        super(tituloNota, fechaCreacion, descripcion);
        this.prioridad = prioridad;
        this.recordatorios = recordatorios;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getRecordatorios() {
        return recordatorios;
    }

    public void setRecordatorios(String recordatorios) {
        this.recordatorios = recordatorios;
    }

    @Override
    public String toString() {
        return getTituloNota()+" - "+ getDescripcion()+" - " +  prioridad + " - " + recordatorios;
    }

   
    
    
}
