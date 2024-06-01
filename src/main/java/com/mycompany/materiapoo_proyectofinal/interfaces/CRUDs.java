/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.materiapoo_proyectofinal.interfaces;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface CRUDs<T> {
    
    public Boolean agregar( T objeto);
    public Boolean eliminar( T objeto);
    public Boolean actualizar( T objeto);
    public T findOne(int id); // t hace referrncia al objeto generico  y el findOnes es para que busque y traiga solo un objeto de tipo id
    public List<T> cosultar();
    public List<T> findOneLike( String texto);
    public List<T> listar( String texto);
    
    
    
    
    
}
