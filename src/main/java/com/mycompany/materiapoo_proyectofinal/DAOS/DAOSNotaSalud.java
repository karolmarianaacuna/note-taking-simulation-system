package com.mycompany.materiapoo_proyectofinal.DAOS;


import com.mycompany.materiapoo_proyectofinal.clases.NotaSalud;
import com.mycompany.materiapoo_proyectofinal.config.ConexionDB;
import com.mycompany.materiapoo_proyectofinal.interfaces.CRUDs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOSNotaSalud extends ConexionDB implements CRUDs<NotaSalud> {

    @Override
    public Boolean agregar(NotaSalud salud) {
        try {

            //preparar la consulta SQL para agregar un nuevo usuario
            String sql = "INSERT INTO notassalud(Titulo1_Nota,fecha_Creacion,descripcion,SignosVitales)VALUES(?,?,?,?)";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, salud.getTituloNota());
            consulta.setDate(2, new java.sql.Date(salud.getFechaCreacion().getTime()));
            consulta.setString(3, salud.getDescripcion());
            consulta.setString(4, salud.getSignosVitales());
            

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
    public Boolean eliminar(NotaSalud salud) {
        try {
            String sql = "DELETE FROM notassalud WHERE id_NotasSalud = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, salud.getIdNota());

            int filasAfectadas = consulta.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean actualizar(NotaSalud salud) {
        try {
            String sql = "UPDATE notassalud SET Titulo1_Nota = ?, fecha_Creacion = ?, descripcion = ?, SignosVitales = ? WHERE id_NotasSalud = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, salud.getTituloNota());
            consulta.setDate(2, new java.sql.Date(salud.getFechaCreacion().getTime()));
            consulta.setString(3, salud.getDescripcion());
            consulta.setString(4, salud.getSignosVitales());
            consulta.setInt(5, salud.getIdNota());
            
        

            int filasAfectadas = consulta.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public NotaSalud findOne(int id) {
        NotaSalud nuevaSalud = new NotaSalud();

        try {
            String sql = "SELECT * FROM notassalud where id_NotasSalud = ? ";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, id);

            // ejecutar consulta y obtener resultados 
            ResultSet resultados = consulta.executeQuery();

            //recorer los resultados y crear objetos Usuario 
            while (resultados.next()) {
                int id_NotasSalud = resultados.getInt("id_NotasSalud");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String SignosVitales = resultados.getString("SignosVitales");
                

                nuevaSalud.setIdNota(id_NotasSalud);
                nuevaSalud.setTituloNota(Titulo1_Nota);
                nuevaSalud.setDescripcion(descripcion);
                nuevaSalud.setSignosVitales(SignosVitales);
                nuevaSalud.setFechaCreacion(fecha_Creacion);
                
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return nuevaSalud;
    }

    @Override
    public List<NotaSalud> cosultar() {
        List<NotaSalud> notaSaluds = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM notassalud";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_NotasSalud = resultados.getInt("id_NotasSalud");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String SignosVitales = resultados.getString("SignosVitales");
              

                NotaSalud notaSalud = new NotaSalud(SignosVitales, id_NotasSalud, Titulo1_Nota, fecha_Creacion, descripcion);
                notaSaluds.add(notaSalud);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaSaluds;
    }

    @Override
    public List<NotaSalud> findOneLike(String texto) {
        List<NotaSalud> notaSaluds = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM  notassalud WHERE Titulo1_Nota LIKE ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
                 consulta.setString(1, texto);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();
       

            while (resultados.next()) {
                int id_NotasSalud = resultados.getInt("id_NotasSalud");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String SignosVitales = resultados.getString("SignosVitales");
            

                NotaSalud notaSalud = new NotaSalud(SignosVitales, id_NotasSalud, Titulo1_Nota, fecha_Creacion, descripcion);
                notaSaluds.add(notaSalud);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaSaluds;
    }

    @Override
    public List<NotaSalud> listar(String texto) {
       List<NotaSalud> notaSaluds = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM notassalud";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_NotasSalud = resultados.getInt("id_NotasSalud");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String SignosVitales = resultados.getString("SignosVitales");

                NotaSalud notaSalud = new NotaSalud(SignosVitales, id_NotasSalud, Titulo1_Nota, fecha_Creacion, descripcion);
                notaSaluds.add(notaSalud);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaSaluds;
    }

}
