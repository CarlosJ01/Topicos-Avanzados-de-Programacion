/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws;


import com.DB.ManejadorBD;
import com.DB.Personales;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Carlos J
 */
@Path("service")
public class Service {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Service
     */
    public Service() {
    }

    /**
     * Retrieves representation of an instance of com.ws.Service
     * @return an instance of java.lang.String
     */
    
    //Mensaje de entrada
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String index() {
        return "Running.....";
    }

    //Mostrar usuarios
    @Path("users")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray usuarios() {
        JsonArrayBuilder array = Json.createArrayBuilder();
        try {
            ManejadorBD m = new ManejadorBD();
            List<String> usuarios = m.listarUsurios();
            for(String u : usuarios) {
                array.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array.build();
    }
    
    //Datos para Reporte
    @Path("datos_reporte")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray datosReporte() {
        JsonArrayBuilder array = Json.createArrayBuilder();
        try {
            ManejadorBD m = new ManejadorBD();
            ArrayList<Personales> lista = m.datosReporte();
            
            for(Personales usuario : lista){
                
                //Imagen
                String base64Foto = "";
                if(usuario.getFoto() != null) {
                    byte[] encoded = Base64.getEncoder().encode(usuario.getFoto());
                    base64Foto = new String(encoded);
                }
                
                //Datos
                JsonObjectBuilder jsonB = Json.createObjectBuilder();
                jsonB.add("id_usuario", usuario.getUsuario().getId());
                jsonB.add("id_personales", usuario.getId());
                jsonB.add("usuario", usuario.getUsuario().getUsuario());
                jsonB.add("contrasenia", usuario.getUsuario().getContrasenia());
                jsonB.add("datos_personales", usuario.getDatos_peronales());
                jsonB.add("foto", base64Foto);
               
                //Concatenar
                array.add(jsonB);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return array.build();
    }
    
    //Dar acceso a un usuario
    @Path("acceso")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject acceso(@QueryParam("usr")String usr, @QueryParam("pass")String pass) {
        JsonObjectBuilder jsonB = Json.createObjectBuilder();
        try {
            
            ManejadorBD m = new ManejadorBD();
            Personales personales = m.datosUsuario(usr, pass);
            
            String base64Foto = "";
            if(personales.getFoto() != null) {
                byte[] encoded = Base64.getEncoder().encode(personales.getFoto());
                base64Foto = new String(encoded);
            }
            
            jsonB.add("id_usuario", personales.getUsuario().getId());
            jsonB.add("id_personales", personales.getId());
            jsonB.add("usuario", personales.getUsuario().getUsuario());
            jsonB.add("contrasenia", personales.getUsuario().getContrasenia());
            jsonB.add("datos_personales", personales.getDatos_peronales());
            jsonB.add("foto", base64Foto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonB.build();
    }
    
    //Registrar un nuevo usuario
    @Path("registrar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject registrar(@QueryParam("usr")String usr, @QueryParam("pass")String pass) {
        JsonObject json = null;
        try {
            ManejadorBD m = new ManejadorBD();
            if( ! m.nuevoUsuario(usr, pass) ) {
                System.out.println("Se registro nuevo usuario");
                
                json = acceso(usr,pass);
                
                System.out.println(json.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
    
    //Guardar los datos de un nuevo usuario
    @PUT
    @Path("datos")
    public void guardarFoto(@FormParam("id")String id, @FormParam("datos")String datos, @FormParam("foto")String foto) {
        System.out.println(foto);
        try {
            byte[] byteFoto = Base64.getDecoder().decode(foto);
            
            ManejadorBD m = new ManejadorBD();
            if( ! m.nuevosDatosDeUsuario(datos, byteFoto, id) ) {
                System.out.println("Datos personales registrados");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
