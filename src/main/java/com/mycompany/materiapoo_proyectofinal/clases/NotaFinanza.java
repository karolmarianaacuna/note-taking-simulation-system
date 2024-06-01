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
public class NotaFinanza  extends Nota{
    private String medioPago;

    public NotaFinanza() {
    }

    public NotaFinanza(String medioPago, int idNota, String tituloNota, Date fechaCreacion, String descripcion) {
        super(idNota, tituloNota, fechaCreacion, descripcion);
        this.medioPago = medioPago;
    }

    public NotaFinanza(String medioPago, String tituloNota, Date fechaCreacion, String descripcion) {
        super(tituloNota, fechaCreacion, descripcion);
        this.medioPago = medioPago;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    @Override
    public String toString() {
        return getTituloNota()+" - "+ getDescripcion()+" - "+ medioPago;
    }
    
    
    
    
    
    
    
}
