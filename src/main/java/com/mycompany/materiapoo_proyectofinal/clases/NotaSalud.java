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
public class NotaSalud  extends  Nota {
    
    private String signosVitales;

    public NotaSalud() {
    }
    
    

    public NotaSalud(String signosVitales, int idNota, String tituloNota, Date fechaCreacion, String descripcion) {
        super(idNota, tituloNota, fechaCreacion, descripcion);
        this.signosVitales = signosVitales;
    }

    public NotaSalud(String signosVitales, String tituloNota, Date fechaCreacion, String descripcion) {
        super(tituloNota, fechaCreacion, descripcion);
        this.signosVitales = signosVitales;
    }

    public String getSignosVitales() {
        return signosVitales;
    }

    public void setSignosVitales(String signosVitales) {
        this.signosVitales = signosVitales;
    }

    @Override
    public String toString() {
        return getTituloNota()+" - "+ getDescripcion()+" - " + signosVitales;
    }
    
    
    
    
    
    
}
