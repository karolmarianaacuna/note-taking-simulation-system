package com.mycompany.materiapoo_proyectofinal.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ConexionDB {

    private String usuario;
    private String clave;
    private String driver;
    private String url;

    protected String cadenaSQL;
    protected ResultSet registros;
    protected Integer filas;
    protected Connection conexion;
    protected PreparedStatement consulta;

    public ConexionDB() {
        clave = "1287";
        usuario = "user_Java1";
        url = "jdbc:mysql://localhost:3306/proyectofinal";
        driver = "com.mysql.cj.jdbc.Driver";
        conectarse();
    }

    private void conectarse() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("conectado");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
