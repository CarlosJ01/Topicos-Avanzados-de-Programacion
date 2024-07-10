/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Modelos;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Carlos J
 */
public class ManejadorBD {
    private Connection conexion;
    private Statement sentencia;

    public ManejadorBD() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tap_unidad03_practica01","root",null);
        sentencia = (Statement) conexion.createStatement();
    }
    
    public ArrayList<Catalogo> leerBD() throws Exception{
        String qry = "SELECT * FROM catalogo";
        ArrayList<Catalogo> productos = new ArrayList<>();
        
        //Sacar registro de la Base de Datos
        ResultSet rs = sentencia.executeQuery(qry);//Crea un set de resultados
        while(rs.next()){
            Catalogo cat = new Catalogo();
            cat.setId(rs.getInt("id"));
            cat.setProducto(rs.getString("producto"));
            productos.add(cat);
        }
        rs.close();
        conexion.close();
        
        return productos;
    }
    
    public int agregarProducto (String nombre ) throws Exception{
        String qry = "INSERT INTO Catalogo(Producto) VALUES('"+nombre+"')";
        int result = sentencia.executeUpdate(qry);
        conexion.close();
        return result;
    }
    
    public int eliminarProducto (String nombre) throws Exception{
        String instruccion = "DELETE FROM catalogo WHERE producto ='"+nombre+"'";
        int result = sentencia.executeUpdate(instruccion);
        conexion.close();
        return result;
    }
    
    public int modificarProducto (int id,String nombre) throws Exception{
        String instruccion = "UPDATE catalogo SET producto ='"+nombre+"' WHERE id="+id;
        int result = sentencia.executeUpdate(instruccion);
        conexion.close();
        return result;
    }
}
