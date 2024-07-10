/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DB;


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
public class ManejadorBD {
    private Connection conexion;
    private Statement sentencia;
    
    //Abrir enlace
    private void abrir() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tap_unidad03_practica06","root",null);
        sentencia = (Statement) conexion.createStatement();
    }
    
    //Cerrar enlace
    private void cerrar() throws Exception {
        sentencia.close();
        conexion.close();
    }
    
    //Lista de Nombres de Usuarios
    public ArrayList<String> listarUsurios() throws Exception {
        abrir();
        
        String qry = "SELECT usuario FROM usuarios";
        ResultSet rs = sentencia.executeQuery(qry);
        
        ArrayList<String> usuarios = new ArrayList<>();
        while(rs.next()) {
            usuarios.add(rs.getString(1));
        }
        rs.close();
        
        cerrar();
        
        return usuarios;
    }
    
    //Generar Reporte
    public ArrayList<Personales> datosReporte() throws Exception {
        abrir();
        
        String qry = "SELECT usuario,datos_personales,foto FROM usuarios, personales WHERE usuarios.id=personales.id_usuario";
        ResultSet rs = sentencia.executeQuery(qry);
        
        ArrayList<Personales> lista = new ArrayList<>();
        while (rs.next()) {     
            Usuario usuario = new Usuario(0, rs.getString("usuario"),"");
            Personales user = new Personales(0,rs.getString("datos_personales"),rs.getBytes("foto"), usuario);
            lista.add(user);
        }
        
        rs.close();
        
        cerrar();
        
        return lista;
    }
    
    //Buscar un usuario y sus datos
    public Personales datosUsuario(String usr, String pass) throws Exception {
        abrir();
        
        String qry = "";
        qry += " SELECT u.id, u.usuario, u.contrasenia, ";
        qry += " p.id AS id_personales, p.datos_personales, p.foto ";
        qry += " FROM usuarios u ";
        qry += "    LEFT JOIN personales p ON u.id = p.id_usuario ";
        qry += " WHERE u.usuario=? AND u.contrasenia=SHA1(?) ";
        
        PreparedStatement ps = conexion.clientPrepareStatement(qry);
        ps.setString(1, usr);
        ps.setString(2, pass);
        
        Personales resultado = null;
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("usuario"), rs.getString("contrasenia"));
            
            resultado = new Personales(
                rs.getInt("id_personales"),
                rs.getString("datos_personales"),
                rs.getBytes("foto"),
                usuario
            );
        }
        
        cerrar();
        
        return resultado;
    }
    
    //Ingresar un usario
    public boolean nuevoUsuario(String usr, String pass) throws Exception {
        abrir();
        
        String qry = "INSERT INTO usuarios(usuario,contrasenia) VALUES(?,SHA1(?))";
        
        PreparedStatement ps = conexion.clientPrepareStatement(qry);
        ps.setString(1, usr);
        ps.setString(2, pass);
        
        boolean resultado = ps.execute();
        
        cerrar();
        
        return resultado;
    }
    
    //Ingresar nuevos datos al usuario
    public boolean nuevosDatosDeUsuario(String datos, byte[] foto, String idUsr) throws Exception {
        abrir();
        
        String qry = "INSERT INTO personales(id_usuario,datos_personales,foto) VALUES(?,?,?)";
        
        PreparedStatement ps = conexion.clientPrepareStatement(qry);
        ps.setInt(1, Integer.parseInt(idUsr));
        ps.setString(2, datos);
        ps.setBytes(3, foto);
        
        boolean resultado = ps.execute();
        
        cerrar();
        
        return resultado;
    }
}
