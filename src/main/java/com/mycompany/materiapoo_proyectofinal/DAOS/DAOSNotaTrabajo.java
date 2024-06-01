package com.mycompany.materiapoo_proyectofinal.DAOS;


import com.mycompany.materiapoo_proyectofinal.clases.NotaTrabajo;
import com.mycompany.materiapoo_proyectofinal.config.ConexionDB;
import com.mycompany.materiapoo_proyectofinal.interfaces.CRUDs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOSNotaTrabajo extends ConexionDB implements CRUDs<NotaTrabajo> {

    @Override
    public Boolean agregar(NotaTrabajo trabajo) {
        try {

            //preparar la consulta SQL para agregar un nuevo usuario
            String sql = "INSERT INTO notastrabajo(Titulo1_Nota,fecha_Creacion,descripcion,Prioridad,Recordatorios)VALUES(?,?,?,?,?)";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, trabajo.getTituloNota());
            consulta.setDate(2, new java.sql.Date(trabajo.getFechaCreacion().getTime()));
            consulta.setString(3, trabajo.getDescripcion());
            consulta.setString(4, trabajo.getPrioridad());
            consulta.setString(5, trabajo.getRecordatorios());
            
            

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
    public Boolean eliminar(NotaTrabajo trabajo) {
        try {
            String sql = "DELETE FROM notastrabajo WHERE id_NotasTrabajo = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, trabajo.getIdNota());

            int filasAfectadas = consulta.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean actualizar(NotaTrabajo trabajo) {
        try {
            String sql = "UPDATE notastrabajo SET Titulo1_Nota = ?, fecha_Creacion = ?, descripcion = ?, Prioridad = ?, Recordatorios = ? WHERE id_NotasTrabajo = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
          consulta.setString(1, trabajo.getTituloNota());
            consulta.setDate(2, new java.sql.Date(trabajo.getFechaCreacion().getTime()));
            consulta.setString(3, trabajo.getDescripcion());
            consulta.setString(4, trabajo.getPrioridad());
            consulta.setString(5, trabajo.getRecordatorios());
            consulta.setInt(6, trabajo.getIdNota());

            int filasAfectadas = consulta.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public NotaTrabajo findOne(int id) {
        NotaTrabajo nuevoTrabajo = new NotaTrabajo();

        try {
            String sql = "SELECT * FROM notastrabajo where id_NotasTrabajo = ? ";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, id);

            // ejecutar consulta y obtener resultados 
            ResultSet resultados = consulta.executeQuery();

            //recorer los resultados y crear objetos Usuario 
            while (resultados.next()) {
                int id_NotasTrabajo = resultados.getInt("id_NotasTrabajo");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String prioridad = resultados.getString("Prioridad");
                String Recordatorios = resultados.getString("Recordatorios");

                nuevoTrabajo.setIdNota(id_NotasTrabajo);
                nuevoTrabajo.setTituloNota(Titulo1_Nota);
                nuevoTrabajo.setDescripcion(descripcion);
                nuevoTrabajo.setPrioridad(prioridad);
                nuevoTrabajo.setRecordatorios(Recordatorios);
                nuevoTrabajo.setFechaCreacion(fecha_Creacion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return nuevoTrabajo;
    }

    @Override
    public List<NotaTrabajo> cosultar() {
        List<NotaTrabajo> notaTrabajos = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM notastrabajo";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_NotasTrabajo = resultados.getInt("id_NotasTrabajo");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String prioridad = resultados.getString("Prioridad");
                String Recordatorios = resultados.getString("Recordatorios");
                

                NotaTrabajo notaTrabajo = new NotaTrabajo(prioridad, Recordatorios, id_NotasTrabajo, Titulo1_Nota, fecha_Creacion, descripcion);
                notaTrabajos.add(notaTrabajo);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaTrabajos;
    }

    @Override
    public List<NotaTrabajo> findOneLike(String texto) {
        List<NotaTrabajo> notaTrabajos = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM  notastrabajo WHERE Titulo1_Nota LIKE ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, texto);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_NotasTrabajo = resultados.getInt("id_NotasTrabajo");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String prioridad = resultados.getString("Prioridad");
               String Recordatorios = resultados.getString("Recordatorios");

                NotaTrabajo notaTrabajo = new NotaTrabajo(prioridad, Recordatorios, id_NotasTrabajo, Titulo1_Nota, fecha_Creacion, descripcion);
                notaTrabajos.add(notaTrabajo);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaTrabajos;
    }

    @Override
    public List<NotaTrabajo> listar(String texto) {
        List<NotaTrabajo> notaTrabajos = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM notastrabajo";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_NotasTrabajo = resultados.getInt("id_NotasTrabajo");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String prioridad = resultados.getString("Prioridad");
                String Recordatorios = resultados.getString("Recordatorios");
                

                NotaTrabajo notaTrabajo = new NotaTrabajo(prioridad, Recordatorios, id_NotasTrabajo, Titulo1_Nota, fecha_Creacion, descripcion);
                notaTrabajos.add(notaTrabajo);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaTrabajos;
    }

}
