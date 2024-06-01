
package com.mycompany.materiapoo_proyectofinal.DAOS;


import com.mycompany.materiapoo_proyectofinal.clases.NotaFinanza;
import com.mycompany.materiapoo_proyectofinal.clases.NotaPersonal;
import com.mycompany.materiapoo_proyectofinal.config.ConexionDB;
import com.mycompany.materiapoo_proyectofinal.interfaces.CRUDs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DAOSNotaFinanza extends ConexionDB implements CRUDs<NotaFinanza>{

    @Override
    public Boolean agregar(NotaFinanza finanza) {
        
        System.out.println("inf de daooooooo---");
        try {

            //preparar la consulta SQL para agregar un nuevo usuario
            String sql = "INSERT INTO notasfinanzas(Titulo1_Nota,fecha_Creacion,descripcion,medioPago)VALUES(?,?,?,?)";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, finanza.getTituloNota());
            consulta.setDate(2, new java.sql.Date(finanza.getFechaCreacion().getTime()));
            consulta.setString(3, finanza.getDescripcion());
            consulta.setString(4, finanza.getMedioPago());
            

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
    public Boolean eliminar(NotaFinanza finanza) {
        try {
            String sql = "DELETE FROM notasfinanzas WHERE id_NotasFinanzas = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, finanza.getIdNota());

            int filasAfectadas = consulta.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean actualizar(NotaFinanza finanza) {
        try {
            String sql = "UPDATE notasfinanzas SET Titulo1_Nota = ?, fecha_Creacion = ?, descripcion = ?, medioPago = ? WHERE id_NotasFinanzas = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, finanza.getTituloNota());
            consulta.setDate(2, new java.sql.Date(finanza.getFechaCreacion().getTime()));
            consulta.setString(3, finanza.getDescripcion());
            consulta.setString(4, finanza.getMedioPago());
            consulta.setInt(5, finanza.getIdNota());

            int filasAfectadas = consulta.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public NotaFinanza findOne(int id) {
        NotaFinanza nuevaFinanza = new NotaFinanza();

        try {
            String sql = "SELECT * FROM notasfinanzas where id_NotasFinanzas = ? ";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, id);

            // ejecutar consulta y obtener resultados 
            ResultSet resultados = consulta.executeQuery();

            //recorer los resultados y crear objetos Usuario 
            while (resultados.next()) {
                int id_NotasFinanzas = resultados.getInt("id_NotasFinanzas");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String medioPago = resultados.getString("medioPago");
                

                nuevaFinanza.setIdNota(id_NotasFinanzas);
                nuevaFinanza.setTituloNota(Titulo1_Nota);
                nuevaFinanza.setDescripcion(descripcion);
                nuevaFinanza.setFechaCreacion(fecha_Creacion);
                nuevaFinanza.setMedioPago(medioPago);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return nuevaFinanza;
    }

    @Override
    public List<NotaFinanza> cosultar() {
        List<NotaFinanza> notaFinanzas = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM notasfinanzas";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_NotasFinanzas = resultados.getInt("id_NotasFinanzas");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String medioPago = resultados.getString("medioPago");
               

                NotaFinanza notaFinanza = new NotaFinanza(medioPago, id_NotasFinanzas, Titulo1_Nota, fecha_Creacion, descripcion);
                notaFinanzas.add(notaFinanza);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaFinanzas;
    }

    @Override
    public List<NotaFinanza> findOneLike(String texto) {
        List<NotaFinanza> notaFinanzas = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM  notasfinanzas WHERE Titulo1_Nota LIKE ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, texto);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_NotasFinanzas = resultados.getInt("id_NotasFinanzas");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String medioPago = resultados.getString("medioPago");
                

                NotaFinanza notaFinanza = new NotaFinanza(medioPago, id_NotasFinanzas, Titulo1_Nota, fecha_Creacion, descripcion);
                notaFinanzas.add(notaFinanza);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaFinanzas;
    }

    @Override
    public List<NotaFinanza> listar(String texto) {
        
      List<NotaFinanza> notaFinanzas = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM notasfinanzas";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_NotasFinanzas = resultados.getInt("id_NotasFinanzas");
                String Titulo1_Nota = resultados.getString("Titulo1_Nota");
                Date fecha_Creacion = resultados.getDate("fecha_Creacion");
                String descripcion = resultados.getString("descripcion");
                String medioPago = resultados.getString("medioPago");
               

                NotaFinanza notaFinanza = new NotaFinanza(medioPago, id_NotasFinanzas, Titulo1_Nota, fecha_Creacion, descripcion);
                notaFinanzas.add(notaFinanza);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return notaFinanzas;
    }
    
}// end
