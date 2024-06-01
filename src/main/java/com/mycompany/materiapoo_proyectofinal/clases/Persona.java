/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.materiapoo_proyectofinal.clases;

public class Persona {
    private int idPersona;
    private String nombre;
    private String apellido;
    private String genero;
    private String email;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String genero, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.email = email;
    }
    
    

    public Persona(int idPersona, String nombre, String apellido, String genero, String email) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.email = email;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  nombre + " " + apellido + " - " + genero + " - " + email ;
    }
    
    
    
}
