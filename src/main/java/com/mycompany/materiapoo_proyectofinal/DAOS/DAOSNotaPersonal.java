/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.materiapoo_proyectofinal.DAOS;

import com.mycompany.materiapoo_proyectofinal.clases.NotaPersonal;
import com.mycompany.materiapoo_proyectofinal.config.ConexionDB;
import com.mycompany.materiapoo_proyectofinal.interfaces.CRUDs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DAOSNotaPersonal extends ConexionDB implements CRUDs<NotaPersonal> {

    @Override
    public Boolean agregar(NotaPersonal notaPersonal) {
        try {

            //preparar la consulta SQL para agregar un nuevo usuario
            String sql = "INSERT INTO notaspersonales(Titulo1_Nota,fecha_Creacion,descripcion,tipo_EMOCION)VALUES(?,?,?,?)";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, notaPersonal.getTituloNota());
            consulta.setDate(2, new java.sql.Date(notaPersonal.getFechaCreacion().getTime()));
            consulta.setString(3, notaPersonal.getDescripcion());
            consulta.setString(4, notaPersonal.getEstadoAnimo());

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
    public Boolean eliminar(NotaPersonal notaPersonal) {

        try {
            String sql = "DELETE FROM notaspersonales WHERE id_NotasPersonal = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, notaPersonal.getIdNota());

            int filasAfectadas = consulta.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean actualizar(NotaPersonal notaPersonal) {
        try {
            String sql = "UPDATE notaspersonales SET Titulo1_Nota = ?, fecha_Creacion = ?, descripcion = ?, tipo_EMOCION = ? WHERE id_NotasPersonal = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, notaPersonal.getTituloNota());
            consulta.setDate(2, new java.sql.Date(notaPersonal.getFechaCreacion().getTime()));
            consulta.setString(3, notaPersonal.getDescripcion());
            consulta.setString(4, notaPersonal.getEstadoAnimo());
            consulta.setInt(5, notaPersonal.getIdNota());

            int filasAfectadas = consulta.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public NotaPersonal findOne(int id) {

        NotaPersonal notaPersonal = new NotaPersonal();

        try {
            String sql = "SELECT * FROM notaspersonales where id_NotasPersonal = ? ";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, id);

            // ejecutar consulta y obtener resultados 
            ResultSet resultados = consulta.executeQuery();

            //recorer los resultados y crear objetos Usuario 
            while (resultados.next()) {
                int id_NotasPersonal = resultados.getInt("id_NotasPersonal");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String tipo_EMOCION = resultados.getString("tipo_EMOCION");

                notaPersonal.setIdNota(id_NotasPersonal);
                notaPersonal.setTituloNota(Titulo1_Nota);
                notaPersonal.setDescripcion(descripcion);
                notaPersonal.setEstadoAnimo(tipo_EMOCION);
                notaPersonal.setFechaCreacion(fecha_Creacion);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaPersonal;
    }

    @Override
    public List<NotaPersonal> cosultar() {
        List<NotaPersonal> notaPersonals = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM notaspersonales";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_NotasPersonal = resultados.getInt("id_NotasPersonal");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                String tipo_EMOCION = resultados.getString("tipo_EMOCION");
                String descripcion = resultados.getString("descripcion");
                java.util.Date fecha_Creacion = resultados.getDate("fecha_Creacion");

                NotaPersonal notaPersonal = new NotaPersonal(tipo_EMOCION, id_NotasPersonal, Titulo1_Nota, fecha_Creacion, descripcion);
                notaPersonals.add(notaPersonal);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaPersonals;

    }

    @Override
    public List<NotaPersonal> findOneLike(String texto) {
          List<NotaPersonal> notaPersonals = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM  notaspersonales WHERE Titulo1_Nota LIKE ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, texto);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_NotasPersonal = resultados.getInt("id_NotasPersonal");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                String tipo_EMOCION = resultados.getString("tipo_EMOCION");
                String descripcion = resultados.getString("descripcion");
                java.util.Date fecha_Creacion = resultados.getDate("fecha_Creacion");

                NotaPersonal notaPersonal = new NotaPersonal(tipo_EMOCION, id_NotasPersonal, Titulo1_Nota, fecha_Creacion, descripcion);
                notaPersonals.add(notaPersonal);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaPersonals;
    }

    @Override
    public List<NotaPersonal> listar(String texto) {
        
        List<NotaPersonal> notaPersonals = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM notaspersonales";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_NotasPersonal = resultados.getInt("id_NotasPersonal");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                String tipo_EMOCION = resultados.getString("tipo_EMOCION");
                String descripcion = resultados.getString("descripcion");
                java.util.Date fecha_Creacion = resultados.getDate("fecha_Creacion");

                NotaPersonal notaPersonal = new NotaPersonal(tipo_EMOCION, id_NotasPersonal, Titulo1_Nota, fecha_Creacion, descripcion);
                notaPersonals.add(notaPersonal);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaPersonals;

    }
    
     
   
    
    

}
