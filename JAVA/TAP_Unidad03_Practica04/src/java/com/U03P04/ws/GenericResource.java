/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.U03P04.ws;

import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Carlos J
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of com.U03P04.ws.GenericResource
     * @return an instance of java.lang.String
     */
    
    //El chido
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getXml() {
        return "<h1>Hola Ws</h1>";
    }

    @Path("myFuncion")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String myFuncion(){
        return "<font color='blue'>Mi funcion</font>";
    }
    
    @Path("suma/{a}/{b}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String suma(@PathParam("a")int a,@PathParam("b")int b){
        return "Resultado: "+(a+b);
    }
    
    @Path("persona")
    @GET
    public String persona(){
        JsonObjectBuilder json = Json.createObjectBuilder();
        json.add("Nombre","Carlos Jahir Castro Cázares");
        json.add("Aapellidos","Castro Cázares");
        json.add("Edad",20);
        json.add("Estatura",1.86);
        json.add("Carrera","ISC");
        return json.build().toString();
    }
    
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    
    //Subir contenido
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
