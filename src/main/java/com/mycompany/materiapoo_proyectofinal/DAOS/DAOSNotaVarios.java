package com.mycompany.materiapoo_proyectofinal.DAOS;

import com.mycompany.materiapoo_proyectofinal.clases.NotaVarios;
import com.mycompany.materiapoo_proyectofinal.config.ConexionDB;
import com.mycompany.materiapoo_proyectofinal.interfaces.CRUDs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOSNotaVarios extends ConexionDB implements CRUDs<NotaVarios> {

    @Override
    public Boolean agregar(NotaVarios varios) {
        try {

            //preparar la consulta SQL para agregar un nuevo usuario
            String sql = "INSERT INTO notasvarios(Titulo1_Nota,fecha_Creacion,descripcion,Recordatorios)VALUES(?,?,?,?)";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, varios.getTituloNota());
            consulta.setDate(2, new java.sql.Date(varios.getFechaCreacion().getTime()));
            consulta.setString(3, varios.getDescripcion());
            consulta.setString(4, varios.getRecordatorios());

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
    public Boolean eliminar(NotaVarios varios) {
        try {
            String sql = "DELETE FROM notasvarios WHERE id_Notasvarios = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, varios.getIdNota());

            int filasAfectadas = consulta.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean actualizar(NotaVarios varios) {
        try {
            String sql = "UPDATE notasvarios SET Titulo1_Nota = ?, fecha_Creacion = ?, descripcion = ?, Recordatorios = ? WHERE id_Notasvarios = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, varios.getTituloNota());
            consulta.setDate(2, new java.sql.Date(varios.getFechaCreacion().getTime()));
            consulta.setString(3, varios.getDescripcion());
            consulta.setString(4, varios.getRecordatorios());
            consulta.setInt(5, varios.getIdNota());

            int filasAfectadas = consulta.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public NotaVarios findOne(int id) {
        NotaVarios nuevoVarios = new NotaVarios();

        try {
            String sql = "SELECT * FROM notasvarios where id_Notasvarios = ? ";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, id);

            // ejecutar consulta y obtener resultados 
            ResultSet resultados = consulta.executeQuery();

            //recorer los resultados y crear objetos Usuario 
            while (resultados.next()) {
                int id_Notasvarios = resultados.getInt("id_Notasvarios");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String Recordatorios = resultados.getString("Recordatorios");

                nuevoVarios.setIdNota(id_Notasvarios);
                nuevoVarios.setTituloNota(Titulo1_Nota);
                nuevoVarios.setDescripcion(descripcion);
                nuevoVarios.setFechaCreacion(fecha_Creacion);
                nuevoVarios.setRecordatorios(Recordatorios);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return nuevoVarios;
    }

    @Override
    public List<NotaVarios> cosultar() {
        List<NotaVarios> notasVarios = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM notasvarios";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_Notasvarios = resultados.getInt("id_Notasvarios");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String Recordatorios = resultados.getString("Recordatorios");

                NotaVarios varios = new NotaVarios(Recordatorios, id_Notasvarios, Titulo1_Nota, fecha_Creacion, descripcion);
                notasVarios.add(varios);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notasVarios;
    }

    @Override
    public List<NotaVarios> findOneLike(String texto) {
        List<NotaVarios> notasVarios = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM  notasvarios WHERE id_Notasvarios LIKE ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_Notasvarios = resultados.getInt("id_Notasvarios");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String Recordatorios = resultados.getString("Recordatorios");

                NotaVarios varios = new NotaVarios(Recordatorios, id_Notasvarios, Titulo1_Nota, fecha_Creacion, descripcion);
                notasVarios.add(varios);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notasVarios;

    }

    @Override
    public List<NotaVarios> listar(String texto) {
        List<NotaVarios> notasVarios = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM notasvarios";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_Notasvarios = resultados.getInt("id_Notasvarios");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String Recordatorios = resultados.getString("Recordatorios");

                NotaVarios varios = new NotaVarios(Recordatorios, id_Notasvarios, Titulo1_Nota, fecha_Creacion, descripcion);
                notasVarios.add(varios);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notasVarios;
    }

}// end
