/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.materiapoo_proyectofinal.DAOS;

import com.mycompany.materiapoo_proyectofinal.clases.NotaAcademica;
import com.mycompany.materiapoo_proyectofinal.clases.NotaFinanza;
import com.mycompany.materiapoo_proyectofinal.clases.NotaPersonal;
import com.mycompany.materiapoo_proyectofinal.clases.NotaSalud;
import com.mycompany.materiapoo_proyectofinal.clases.NotaTrabajo;
import com.mycompany.materiapoo_proyectofinal.clases.NotaVarios;
import com.mycompany.materiapoo_proyectofinal.clases.Persona;
import com.mycompany.materiapoo_proyectofinal.clases.Principal;
import com.mycompany.materiapoo_proyectofinal.config.ConexionDB;
import com.mycompany.materiapoo_proyectofinal.interfaces.CRUDs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DAOSPrincipal extends ConexionDB implements CRUDs<Principal> {

    @Override
    public Boolean agregar(Principal objeto) {

        System.out.println("inf de daooooooo---");
        try {

            //preparar la consulta SQL para agregar un nuevo usuario
            String sql = "INSERT INTO notas(id_NotasTrabajo,id_Notasvarios,id_NotasSalud,id_NotasFinanzas,id_NotasAcademicas,id_NotasPersonal,id_Persona)VALUES(?,?,?,?,?,?,?)";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, objeto.getIdNotaTrabajo().getIdNota());
             consulta.setInt(2, objeto.getIdNotaVarios().getIdNota());
            consulta.setInt(3, objeto.getIdNotaSalud().getIdNota());
            consulta.setInt(4, objeto.getIdNotaFinanza().getIdNota());
            consulta.setInt(5, objeto.getIdNotaAcademica().getIdNota());
            consulta.setInt(6, objeto.getIdNotaPersonal().getIdNota());
            consulta.setInt(7, objeto.getIdsPersona().getIdPersona());

            // Ejecutar la consulta 
            int filasAfectadas = consulta.executeUpdate();

            //comprobar si la insercion fue exitosa 
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        }

    }

    @Override
    public Boolean eliminar(Principal objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

//        try {
//            String sql = "DELETE FROM notas WHERE id_NotasTrabajo = ?";
//            PreparedStatement consulta = conexion.prepareStatement(sql);
//            consulta.setInt(1, objeto.get);
//
//            int filasAfectadas = consulta.executeUpdate();
//
//            return filasAfectadas > 0;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }
    }

    @Override
    public Boolean actualizar(Principal objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Principal findOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Principal> cosultar() {

        List<Principal> principals = new ArrayList<>();
        try {

            //Preparar la consulta SQL para obtener todos los artistas
            String sql = "SELECT * FROM notas";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            // Recorrer los resultados y crear objetos Usuario
            while (resultados.next()) {
                int id_NotasTrabajo = resultados.getInt("id_NotasTrabajo");
                int id_Notasvarios = resultados.getInt("id_Notasvarios");
                int id_NotasSalud = resultados.getInt("id_NotasSalud");
                int id_NotasFinanzas = resultados.getInt("id_NotasFinanzas");
                int id_NotasAcademicas = resultados.getInt("id_NotasAcademicas");
                int id_NotasPersonal = resultados.getInt("id_NotasPersonal");
                int id_Persona = resultados.getInt("id_Persona");

                DAOSNotaAcademica dAOSNotaAcademica = new DAOSNotaAcademica();
                NotaAcademica notaAcademica = dAOSNotaAcademica.findOne(id_NotasAcademicas);

                DAOSNotaFinanza dAOSNotaFinanza = new DAOSNotaFinanza();
                NotaFinanza notaFinanza = dAOSNotaFinanza.findOne(id_NotasFinanzas);

                DAOSNotaPersonal dAOSNotaPersonal = new DAOSNotaPersonal();
                NotaPersonal notaPersonal = dAOSNotaPersonal.findOne(id_NotasPersonal);

                DAOSNotaTrabajo dAOSNotaTrabajo = new DAOSNotaTrabajo();
                NotaTrabajo notaTrabajo = dAOSNotaTrabajo.findOne(id_NotasTrabajo);

                DAOSNotaSalud dAOSNotaSalud = new DAOSNotaSalud();
                NotaSalud notaSalud = dAOSNotaSalud.findOne(id_NotasSalud);

                DAOSNotaVarios dAOSNotaVarios = new DAOSNotaVarios();
                NotaVarios notaVarios = dAOSNotaVarios.findOne(id_Notasvarios);

                DAOSRegistro dAOSRegistro = new DAOSRegistro();
                Persona persona = dAOSRegistro.findOne(id_Persona);

                Principal principal = new Principal(notaAcademica, notaPersonal, notaTrabajo, notaSalud, notaVarios, notaFinanza, persona);
                principals.add(principal);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return principals;
    }

    @Override
    public List<Principal> findOneLike(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Principal> listar(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
