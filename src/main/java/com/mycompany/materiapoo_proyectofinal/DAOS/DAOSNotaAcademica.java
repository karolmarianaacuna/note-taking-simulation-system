package com.mycompany.materiapoo_proyectofinal.DAOS;

import com.mycompany.materiapoo_proyectofinal.clases.NotaAcademica;
import com.mycompany.materiapoo_proyectofinal.config.ConexionDB;
import com.mycompany.materiapoo_proyectofinal.interfaces.CRUDs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOSNotaAcademica extends ConexionDB implements CRUDs<NotaAcademica> {

    @Override
    public Boolean agregar(NotaAcademica academica) {
        try {

            //preparar la consulta SQL para agregar un nuevo usuario
            String sql = "INSERT INTO notasacademicas(Titulo1_Nota,fecha_Creacion,descripcion,Objetivos_Academicos)VALUES(?,?,?,?)";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, academica.getTituloNota());
            consulta.setDate(2, new java.sql.Date(academica.getFechaCreacion().getTime()));
            consulta.setString(3, academica.getDescripcion());
            consulta.setString(4, academica.getObjetivosAprendizaje());

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
    public Boolean eliminar(NotaAcademica academica) {
        try {
            String sql = "DELETE FROM notasacademicas WHERE id_NotasAcademicas = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, academica.getIdNota());

            int filasAfectadas = consulta.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean actualizar(NotaAcademica academica) {
        try {
            String sql = "UPDATE notasacademicas SET Titulo1_Nota = ?, fecha_Creacion = ?, descripcion = ?, Objetivos_Academicos = ? WHERE id_NotasAcademicas = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, academica.getTituloNota());
            consulta.setDate(2, new java.sql.Date(academica.getFechaCreacion().getTime()));
            consulta.setString(3, academica.getDescripcion());
            consulta.setString(4, academica.getObjetivosAprendizaje());
            consulta.setInt(5, academica.getIdNota());

            int filasAfectadas = consulta.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public NotaAcademica findOne(int id) {
        NotaAcademica nuevoTrabajo = new NotaAcademica();

        try {
            String sql = "SELECT * FROM notasacademicas where id_NotasAcademicas = ? ";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, id);

            // ejecutar consulta y obtener resultados 
            ResultSet resultados = consulta.executeQuery();

            //recorer los resultados y crear objetos Usuario 
            while (resultados.next()) {
                int id_NotasAcademicas = resultados.getInt("id_NotasAcademicas");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                String descripcion = resultados.getString("descripcion");
                String objetivos = resultados.getString("Objetivos_Academicos");

                nuevoTrabajo.setIdNota(id_NotasAcademicas);
                nuevoTrabajo.setTituloNota(Titulo1_Nota);
                nuevoTrabajo.setDescripcion(descripcion);
                nuevoTrabajo.setObjetivosAprendizaje(objetivos);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return nuevoTrabajo;
    }

    @Override
    public List<NotaAcademica> cosultar() {
        List<NotaAcademica> notaAcademicas = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM notasacademicas";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_NotasAcademicas = resultados.getInt("id_NotasAcademicas");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String objetivos = resultados.getString("Objetivos_Academicos");
                

                NotaAcademica notaAcademica = new NotaAcademica(objetivos,  id_NotasAcademicas, Titulo1_Nota, fecha_Creacion, descripcion);
                notaAcademicas.add(notaAcademica);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaAcademicas;
    }

    @Override
    public List<NotaAcademica> findOneLike(String texto) {
        List<NotaAcademica> notaAcademicas = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM  notasacademicas WHERE Titulo1_Nota LIKE ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
             consulta.setString(1, texto);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_NotasAcademicas = resultados.getInt("id_NotasAcademicas");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String objetivos = resultados.getString("Objetivos_Academicos");
                

                NotaAcademica notaAcademica = new NotaAcademica(objetivos, id_NotasAcademicas, Titulo1_Nota, fecha_Creacion, descripcion);
                notaAcademicas.add(notaAcademica);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaAcademicas;
    }

    @Override
    public List<NotaAcademica> listar(String texto) {
       List<NotaAcademica> notaAcademicas = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM notasacademicas";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_NotasAcademicas = resultados.getInt("id_NotasAcademicas");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String objetivos = resultados.getString("Objetivos_Academicos");
                

                NotaAcademica notaAcademica = new NotaAcademica(objetivos,  id_NotasAcademicas, Titulo1_Nota, fecha_Creacion, descripcion);
                notaAcademicas.add(notaAcademica);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaAcademicas;
    }

}// end
