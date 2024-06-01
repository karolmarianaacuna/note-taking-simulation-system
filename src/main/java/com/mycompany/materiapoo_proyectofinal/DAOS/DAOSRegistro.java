
package com.mycompany.materiapoo_proyectofinal.DAOS;

import com.mycompany.materiapoo_proyectofinal.clases.Persona;
import com.mycompany.materiapoo_proyectofinal.config.ConexionDB;
import com.mycompany.materiapoo_proyectofinal.interfaces.CRUDs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOSRegistro extends ConexionDB implements CRUDs<Persona>{

    @Override
    public Boolean agregar(Persona persona) {
        //preparar consulta 
        try {

            //preparar la consulta SQL para agregar un nuevo usuario
            String sql = "INSERT INTO personas(nombre,apellido,genero,email)VALUES(?,?,?,?)";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, persona.getNombre());
            consulta.setString(2, persona.getApellido());
            consulta.setString(3, persona.getGenero());
            consulta.setString(4, persona.getEmail());
            

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
    public Boolean eliminar(Persona objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean actualizar(Persona objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Persona findOne(int id) {
        
        Persona persona = new Persona();

        try {
            String sql = "SELECT * FROM personas where id_Persona = ? ";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, id);

            // ejecutar consulta y obtener resultados 
            ResultSet resultados = consulta.executeQuery();

            //recorer los resultados y crear objetos Usuario 
            while (resultados.next()) {
                int id_Persona = resultados.getInt("id_Persona");
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                String genero = resultados.getString("genero");
                String email = resultados.getString("email");
                
                
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setGenero(genero);
                persona.setIdPersona(id_Persona);
                persona.setEmail(email);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return persona;
        
    }

    @Override
    public List<Persona> cosultar() {
        List<Persona> personas = new ArrayList<>();

        try {
            //preparar la consulta SQL 
            String sql = "SELECT * FROM personas";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // ejecutar la consulta y obtener resultados
            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {
                int id_Persona = resultados.getInt("id_Persona");
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                String genero = resultados.getString("genero");
                String email = resultados.getString("email");
                

                Persona persona = new Persona(id_Persona, nombre, apellido, genero, email);
                personas.add(persona);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return personas;
    }

    @Override
    public List<Persona> findOneLike(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Persona> listar(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
