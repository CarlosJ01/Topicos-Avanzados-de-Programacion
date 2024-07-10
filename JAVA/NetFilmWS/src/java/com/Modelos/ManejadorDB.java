/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Modelos;

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

    //Constructor
    public ManejadorDB() throws Exception{
        this.conexion=null;
        this.sentencia=null;
    }
    
    //Abrir enlace
    private void abrir() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/netfilm","root",null);
        sentencia = (Statement) conexion.createStatement();
    }
    
    //Cerrar enlace
    private void cerrar() throws Exception {
        sentencia.close();
        conexion.close();
    }

    //Numero de Perfules
    public int numPerfiles(Usuario user) throws Exception{
        String qry ="SELECT COUNT(p.perfil_id) AS numero " +
        "FROM usuario u INNER JOIN perfil p ON u.id=p.usuario_id " +
        "WHERE usuario=? AND u.contrasenia=SHA1(?)";
        
        int num = 0;
        
        abrir();
        
        PreparedStatement ps = conexion.clientPrepareStatement(qry);
        ps.setString(1, user.getNombre());
        ps.setString(2, user.getContrasenia());
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            num = rs.getInt(1);
        }
        
        cerrar();
        
        System.out.println("Mensaje:Acceso consedido "+num);
        return num;
    }
    
    //Lista de Usuarios
    public ArrayList<Usuario> listaUsuarios() throws Exception{
        String qry = "SELECT * FROM usuario WHERE contrasenia IS NOT NULL";
        ArrayList<Usuario> lista = new ArrayList<>();
        
        abrir();
        
        ResultSet rs = sentencia.executeQuery(qry);
        while (rs.next()) {     
            Usuario usr = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3));
            lista.add(usr);
        }
        
        cerrar();
        
        return lista;
    }
    
    //Buscar un usario y sus datos
    public Usuario buscarUsuario(Usuario usr) throws Exception{
        String qry ="SELECT * FROM usuario WHERE usuario='"+usr.getNombre()+"'";
        Usuario user = new Usuario();
        
        abrir();
            ResultSet rs = sentencia.executeQuery(qry);
            while (rs.next()) {     
                user.setId(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setContrasenia(rs.getString(3));
            }
        cerrar();
        
        return user;
    }
    
    //Imgresar un Usuario
    public boolean ingresarUsuario(Usuario user) throws Exception{
        String qry = "INSERT INTO usuario VALUES(DEFAULT,?,SHA1(?))";
        boolean acep = false;
        
        abrir();
            PreparedStatement ps = conexion.clientPrepareStatement(qry);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getContrasenia());
            
            int rsl = ps.executeUpdate();
            
            if (rsl==1) {
                acep=true;
            }
        cerrar();
        
        return acep;
    }
    
    //Imgresar Datos de usuario
    public boolean ingresarDatosUsuario(DatosUsuario datos) throws Exception{
        String qry = "INSERT INTO datos_usuario VALUES(?,?,?,?)";
        boolean acep = false;
        
        abrir();
            PreparedStatement ps = conexion.clientPrepareStatement(qry);
            ps.setString(1,""+datos.getUsuario().getId());
            ps.setString(2,""+datos.getNombre());
            ps.setString(3,""+datos.getDatos());
            ps.setBytes(4,datos.getImagen());
            
            acep = ps.execute();
            
        cerrar();
        
        return acep;
    }
    
    //Imgresar un perfil
    public boolean ingresarPerfil(Usuario user,int idPer,int opc) throws Exception{
        String qry = "insert into perfil values(?,?)";
        boolean acep = false;
        if(opc==1){
            abrir();
                PreparedStatement ps = conexion.clientPrepareStatement(qry);
                ps.setString(1,""+user.getId());
                ps.setString(2,""+idPer);

                int res = ps.executeUpdate();

                if (res==1) {
                    acep=true;
                }
            cerrar();
        }if (opc==2) {
            abrir();
                PreparedStatement ps = conexion.clientPrepareStatement(qry);
                ps.setString(1,""+idPer);
                ps.setString(2,""+user.getId());

                int res = ps.executeUpdate();

                if (res==1) {
                    acep=true;
                }
            cerrar();
        }
        return acep;
    }
    
    //Obtener todos los perfiles de un usuario
    public ArrayList<DatosUsuario> listaPerfiles(int id) throws Exception{
        String qry ="SELECT du.* FROM perfil p INNER JOIN datos_usuario du ON p.usuario_id=? AND p.perfil_id=du.usuario_id;  ";
        ArrayList<DatosUsuario> lista = new ArrayList<>();
        
        abrir();
        PreparedStatement ps = conexion.clientPrepareStatement(qry);
        ps.setInt(1,id);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {     
            Usuario usr = new Usuario(rs.getInt("usuario_id"),"","");
            DatosUsuario datos = new DatosUsuario(usr,rs.getString("nombre"),rs.getString("datos"),rs.getBytes("imagen"));
            lista.add(datos);
        }
        
        cerrar();
        
        return lista;
    }
    
    //Actualizar datos de usuario
    public boolean actualizarDatos(DatosUsuario datos) throws Exception{
        String qry ="UPDATE datos_usuario SET nombre=?,datos=?,imagen=? WHERE usuario_id = ?";
        boolean siono = false;
        
        abrir();
            PreparedStatement ps = conexion.clientPrepareStatement(qry);
            ps.setString(1,datos.getNombre());
            ps.setString(2,datos.getDatos());
            ps.setBytes(3,datos.getImagen());
            ps.setInt(4,datos.getUsuario().getId());
            
            int res = ps.executeUpdate();
            
            if (res==1) {
                siono=true;
            }
        cerrar();
        
        return siono;
    }
    
    //Eliminar un usuario
    public boolean eliminarUsuario(int id) throws Exception{
        String qry1 = "DELETE FROM datos_usuario WHERE usuario_id=?";
        String qry2 = "DELETE FROM perfil WHERE perfil_id=?";
        String qry3 = "DELETE FROM favoritos WHERE usuario_id=?";
        String qry4 = "DELETE FROM usuario WHERE id=?";
        boolean siono = false;
        boolean siono1 = false;
        boolean siono2 = false;
        boolean siono3 = false;
        boolean siono4 = false;
        int res;
        PreparedStatement ps = null;
        
        abrir();
            ps = conexion.clientPrepareStatement(qry1);
            ps.setInt(1,id);
            res = ps.executeUpdate();
            if (res==1) {
                siono1=true;
            }
        cerrar();
        
        abrir();
            ps = conexion.clientPrepareStatement(qry2);
            ps.setInt(1,id);
            res = ps.executeUpdate();
            if (res==1) {
                siono2=true;
            }
        cerrar();
        
        abrir();
            ps = conexion.clientPrepareStatement(qry3);
            ps.setInt(1,id);
            res = ps.executeUpdate();
            if (res==1) {
                siono3=true;
            }
        cerrar();
        
        abrir();
            ps = conexion.clientPrepareStatement(qry4);
            ps.setInt(1,id);
            res = ps.executeUpdate();
            if (res==1) {
                siono4=true;
            }
        cerrar();
        
        if(siono1 && siono2 && siono3 && siono4){
            siono=true;
        }
        
        return siono;
    }
    
    //Peliculas favoritas por usuario
    public ArrayList<Pelicula> peliculasFavoritas(int id) throws Exception{
        String qry = "SELECT p.* FROM favoritos f INNER JOIN pelicula p ON f.pelicula_id=p.id WHERE f.usuario_id=?";
        ArrayList<Pelicula> lista = new ArrayList<>();
        
        abrir();
        
        PreparedStatement ps = conexion.clientPrepareStatement(qry);
        ps.setInt(1,id);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Pelicula peli = new Pelicula();
            peli.setId(rs.getInt("id"));
            peli.setTitulo(rs.getString("titulo"));
            peli.setDescripcion(rs.getString("descripcion"));
            peli.setGenero(rs.getString("genero"));
            peli.setRuta(rs.getString("ruta"));
            peli.setIcono(rs.getBytes("icono"));
            peli.setPoster(rs.getBytes("poster"));
            
            lista.add(peli);
        }
        
        cerrar();
        
        return lista;
    }
    
    //Insertar un favorito
    public boolean nuevoFavorito(int idUsr,int idPeli) throws Exception{
        String qry ="INSERT INTO favoritos VALUES(?,?)";
        boolean acep = false;
        
        abrir();
        PreparedStatement ps = conexion.clientPrepareStatement(qry);
        ps.setInt(1,idUsr);
        ps.setInt(2,idPeli);

        int res = ps.executeUpdate();

        if (res==1) {
            acep=true;
        }
        cerrar();
        
        return acep;
    }
    
    //Eliminar un favorito
    public boolean eliminarFavorito(int idUsr,int idPeli) throws Exception{
        String qry1 = "DELETE FROM favoritos WHERE usuario_id=? AND pelicula_id=?";
        boolean siono = false;
        
        abrir();
            PreparedStatement ps = conexion.clientPrepareStatement(qry1);
            ps.setInt(1,idUsr);
            ps.setInt(2,idPeli);
            
            int res = ps.executeUpdate();
            
            if (res==1) {
                siono=true;
            }
        cerrar();
        
        return siono;
    }
    
    //Sacar todas las peliculas
    public ArrayList<Pelicula> todasPeliculas() throws Exception{
        String qry = "SELECT * FROM pelicula";
        ArrayList<Pelicula> lista = new ArrayList<>();
        
        abrir();
        
        PreparedStatement ps = conexion.clientPrepareStatement(qry);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Pelicula peli = new Pelicula();
            peli.setId(rs.getInt("id"));
            peli.setTitulo(rs.getString("titulo"));
            peli.setDescripcion(rs.getString("descripcion"));
            peli.setGenero(rs.getString("genero"));
            peli.setRuta(rs.getString("ruta"));
            peli.setIcono(rs.getBytes("icono"));
            peli.setPoster(rs.getBytes("poster"));
            
            lista.add(peli);
        }
        
        cerrar();
        
        return lista;
    }
    
    //Sacar Busqueda
    public ArrayList<Pelicula> busqueda(String pal) throws Exception{
        String qry = "SELECT * FROM pelicula WHERE titulo LIKE \"%"+pal+"%\"";
        System.out.println("Mensaje : "+qry);
        ArrayList<Pelicula> lista = new ArrayList<>();
        
        abrir();
        
        PreparedStatement ps = conexion.clientPrepareStatement(qry);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Pelicula peli = new Pelicula();
            peli.setId(rs.getInt("id"));
            peli.setTitulo(rs.getString("titulo"));
            peli.setDescripcion(rs.getString("descripcion"));
            peli.setGenero(rs.getString("genero"));
            peli.setRuta(rs.getString("ruta"));
            peli.setIcono(rs.getBytes("icono"));
            peli.setPoster(rs.getBytes("poster"));
            
            lista.add(peli);
        }
        
        cerrar();
        
        return lista;
    }
}
