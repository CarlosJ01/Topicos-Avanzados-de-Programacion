/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Practica05;

import com.Practica05.BD.ManejadorDB;
import com.Practica05.BD.Ropa;
import java.io.StringReader;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Carlos J
 */
@Path("endpoint")
public class EndPoint {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EndPoint
     */
    public EndPoint() {
    }

    /**
     * Retrieves representation of an instance of com.Practica05.EndPoint
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return "Running...";
    }
    
    @GET
    @Path("productos")
    @Produces(MediaType.APPLICATION_JSON)
    public String muestraRopas(){
        
        try {
            JsonArrayBuilder jArray = Json.createArrayBuilder();
            ManejadorDB manejador = new ManejadorDB();
            
            List<Ropa> ropas = manejador.mostrarTodas();
            for (Ropa ropa: ropas) {
                JsonObjectBuilder json = Json.createObjectBuilder();
                json.add("id",ropa.getId());
                json.add("Descripcion",ropa.getDescripcion());
                jArray.add(json);
            }
            return  jArray.build().toString();
        } catch (Exception e) {
            System.out.println("Error al leer la Base de Datos");
            return "Error.\n"+e;
        }
        
    }
    
    @Path("añadir/{producto}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String añadir(@PathParam("producto")String producto){
        
        try {
            ManejadorDB manejador = new ManejadorDB();
            manejador.agregarRopa(producto);
        } catch (Exception e) {
            System.out.println("Error al agregar a la Base de Datos");
            return "Error.\n"+e;
        }
        
        return muestraRopas();
    }
    
    @Path("eliminar/{nombre}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String eliminar(@PathParam("nombre")String nombre){
        
        try {
            ManejadorDB manejador = new ManejadorDB();
            manejador.eliminarRopa(nombre);
        } catch (Exception e) {
            System.out.println("Error al eliminar de la Base de Datos");
            return "Error.\n"+e;
        }
        
        return muestraRopas();
    }
    
    
    @Path("modificar/{ropas}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String modificarRopa(@PathParam("ropas")String ropa){
        try {
            
            //Tranforma un Strin a JSON en WebServices
            //-----------------------------------------------------------------
            StringReader sr = new StringReader(ropa);
            JsonReader reader = Json.createReader(sr);
            JsonObject json = reader.readObject();
            //-----------------------------------------------------------------
            
            Ropa r= new Ropa();
            r.setId(json.getInt("id"));
            r.setDescripcion(json.getString("descripcion"));
           
            ManejadorDB m = new ManejadorDB();
            
            boolean resultado = m.modificar(r);
            
            if(resultado){
                return "{\"resultado\":\"Modificion realizada\"}";
            }
            else{
                return "{\"resultado\":\"No se pudo modificar\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"resultado\":\"Error\"}";
        }
    }
}
