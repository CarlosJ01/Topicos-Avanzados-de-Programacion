/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Practica05.BD;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Carlos J
 */
public class ManejadorDB {
   private Connection conexion;
    private Statement sentencia;

    private void abrir() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tap_unidad03_practica05","root",null);
        sentencia = (Statement) conexion.createStatement();
    }
    
    private void cerrar() throws Exception{
        sentencia.close();
        conexion.close();
    }
    
    public ArrayList<Ropa> mostrarTodas() throws Exception{
        String qry = "SELECT * FROM catalogo";
        
        abrir();
        ResultSet rs = sentencia.executeQuery(qry);
        ArrayList<Ropa> ropas = new ArrayList<>();
        
        while(rs.next()){
            Ropa ropa = new Ropa();
            ropa.setId(rs.getInt("id"));
            ropa.setDescripcion(rs.getString("Producto"));
            ropas.add(ropa);
        }
        cerrar();
        
        return ropas;
    }
    
    
    public int agregarRopa(String producto) throws Exception{
        abrir();
        
        String qry = "INSERT INTO Catalogo(Producto) VALUES('"+producto+"')";
        int result = sentencia.executeUpdate(qry);
        
        cerrar();
        return result;
    }
    
    
    public int eliminarRopa(String nombre) throws Exception{
        abrir();
        
        String instruccion = "DELETE FROM catalogo WHERE Producto ='"+nombre+"'";
        int result = sentencia.executeUpdate(instruccion);
        
        cerrar();
        return result;
    }
    
    public boolean modificar(Ropa nueva) throws Exception{
        abrir();
        String qry = "UPDATE catalogo SET producto=? WHERE id=?";
        
        PreparedStatement ps = conexion.clientPrepareStatement(qry);

        ps.setString(1,nueva.getDescripcion());
        ps.setInt(2,nueva.getId());

        int resultado = ps.executeUpdate();

        cerrar();
        return (resultado>0);
    }
    
}
