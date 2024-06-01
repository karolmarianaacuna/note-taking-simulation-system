/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.materiapoo_proyectofinal.clases;

/**
 *
 * @author USUARIO
 */
public class Principal {
    
    
    private  NotaAcademica idNotaAcademica;
    private NotaPersonal idNotaPersonal;
    private NotaTrabajo idNotaTrabajo;
    private NotaSalud idNotaSalud;
    private NotaVarios idNotaVarios;
    private  NotaFinanza idNotaFinanza;
    private Persona idsPersona;

    public Principal() {
    }



    public Principal(NotaAcademica idNotaAcademica, NotaPersonal idNotaPersonal, NotaTrabajo idNotaTrabajo, NotaSalud idNotaSalud, NotaVarios idNotaVarios, NotaFinanza idNotaFinanza, Persona idsPersona) {
        this.idNotaAcademica = idNotaAcademica;
        this.idNotaPersonal = idNotaPersonal;
        this.idNotaTrabajo = idNotaTrabajo;
        this.idNotaSalud = idNotaSalud;
        this.idNotaVarios = idNotaVarios;
        this.idNotaFinanza = idNotaFinanza;
        this.idsPersona = idsPersona;
    }
    

   

    public NotaAcademica getIdNotaAcademica() {
        return idNotaAcademica;
    }

    public void setIdNotaAcademica(NotaAcademica idNotaAcademica) {
        this.idNotaAcademica = idNotaAcademica;
    }

    public NotaPersonal getIdNotaPersonal() {
        return idNotaPersonal;
    }

    public void setIdNotaPersonal(NotaPersonal idNotaPersonal) {
        this.idNotaPersonal = idNotaPersonal;
    }

    public NotaTrabajo getIdNotaTrabajo() {
        return idNotaTrabajo;
    }

    public void setIdNotaTrabajo(NotaTrabajo idNotaTrabajo) {
        this.idNotaTrabajo = idNotaTrabajo;
    }

    public NotaSalud getIdNotaSalud() {
        return idNotaSalud;
    }

    public void setIdNotaSalud(NotaSalud idNotaSalud) {
        this.idNotaSalud = idNotaSalud;
    }

    public NotaVarios getIdNotaVarios() {
        return idNotaVarios;
    }

    public void setIdNotaVarios(NotaVarios idNotaVarios) {
        this.idNotaVarios = idNotaVarios;
    }

    public NotaFinanza getIdNotaFinanza() {
        return idNotaFinanza;
    }

    public void setIdNotaFinanza(NotaFinanza idNotaFinanza) {
        this.idNotaFinanza = idNotaFinanza;
    }

    public Persona getIdsPersona() {
        return idsPersona;
    }

    public void setIdsPersona(Persona idsPersona) {
        this.idsPersona = idsPersona;
    }

    @Override
    public String toString() {
        return   idNotaAcademica + ", idNotaPersonal=" + idNotaPersonal + ", idNotaTrabajo=" + idNotaTrabajo + ", idNotaSalud=" + idNotaSalud + ", idNotaVarios=" + idNotaVarios + ", idNotaFinanza=" + idNotaFinanza + ", idsPersona=" + idsPersona + '}';
    }
    
    
    
    
    
    
    
    
    
    
}
