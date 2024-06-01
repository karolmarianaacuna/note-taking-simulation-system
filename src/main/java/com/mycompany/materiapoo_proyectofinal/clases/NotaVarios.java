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
public class NotaVarios extends Nota{
    
    private String recordatorios;

    public NotaVarios() {
    }
    
    

    public NotaVarios(String recordatorios, int idNota, String tituloNota, Date fechaCreacion, String descripcion) {
        super(idNota, tituloNota, fechaCreacion, descripcion);
        this.recordatorios = recordatorios;
    }

    public NotaVarios(String recordatorios, String tituloNota, Date fechaCreacion, String descripcion) {
        super(tituloNota, fechaCreacion, descripcion);
        this.recordatorios = recordatorios;
    }

    public String getRecordatorios() {
        return recordatorios;
    }

    public void setRecordatorios(String recordatorios) {
        this.recordatorios = recordatorios;
    }

    @Override
    public String toString() {
        return getTituloNota()+" - "+ getDescripcion()+" - " + recordatorios;
    }
    
    
    
    
    
    
    
    
}
