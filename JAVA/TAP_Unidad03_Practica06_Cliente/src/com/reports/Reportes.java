/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reports;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Carlos J
 */
public class Reportes {

    public Reportes() {
    }
    
    public void generar(int tipo,String archivo,JSONArray array) throws Exception{
        
        //Reconocer tipo
        switch (tipo) {
            case 1:
                    reporte(archivo, array);
                break;
            case 2:
                    generos(archivo,array);
                break;
            case 3:
                    edades(archivo, array);
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
    private void reporte(String archivo,JSONArray lista) throws Exception{
        //Abrir Documento
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(archivo));
        doc.open();
        
        // Texto
        Paragraph titulo = new Paragraph(new Phrase("\n             Reporte", new Font(Font.FontFamily.COURIER, 25,Font.BOLD)));
        Paragraph parrafo01 = new Paragraph(new Phrase("\nUSUARIOS\n\n", new Font(Font.FontFamily.COURIER, 20,Font.BOLD)));
        
        // Tabla
        PdfPTable table = new PdfPTable(5);
        
        table.addCell(new Phrase("Foto", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        table.addCell(new Phrase("Usuario", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        table.addCell(new Phrase("Nombre Completo", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        table.addCell(new Phrase("Genero", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        table.addCell(new Phrase("Edad", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        
        for (int i = 0; i < lista.size(); i++) {
            JSONObject usu = (JSONObject) lista.get(i);
            
            //Tratar la foto
            String cadenaFoto = usu.get("foto").toString();
            byte[] bites = Base64.getDecoder().decode(cadenaFoto);
            Image imagen = Image.getInstance(bites);
            imagen.scaleToFit(200,200);
            
            //Datos de Ususario
            JSONParser jParser = new JSONParser();
            JSONObject datos = (JSONObject) jParser.parse(usu.get("datos_personales").toString());
            
            table.addCell(imagen);
            table.addCell(usu.get("usuario").toString());
            table.addCell(datos.get("nombre").toString());
            table.addCell(datos.get("genero").toString());
            table.addCell(datos.get("edad").toString());
        }
        
        doc.add(titulo);
        doc.add(parrafo01);
        doc.add(table);
        doc.close();
    }
    
    private void generos(String archivo,JSONArray lista) throws Exception{
        //Abrir Documento
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(archivo));
        doc.open();
        
        // Texto
        Paragraph titulo = new Paragraph(new Phrase("\n             Generos", new Font(Font.FontFamily.COURIER, 25,Font.BOLD)));
        
        // Tabla Masculino
        Paragraph masculino = new Paragraph(new Phrase("\n\nMASCULINO\n\n", new Font(Font.FontFamily.COURIER, 20,Font.BOLD)));
        
        PdfPTable tableMasculino = new PdfPTable(4);
        tableMasculino.addCell(new Phrase("Foto", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        tableMasculino.addCell(new Phrase("Usuario", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        tableMasculino.addCell(new Phrase("Nombre Completo", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        tableMasculino.addCell(new Phrase("Edad", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        
        for (int i = 0; i < lista.size(); i++) {
            JSONObject usu = (JSONObject) lista.get(i);
            
            //Tratar la foto
            String cadenaFoto = usu.get("foto").toString();
            byte[] bites = Base64.getDecoder().decode(cadenaFoto);
            Image imagen = Image.getInstance(bites);
            imagen.scaleToFit(200,200);
            
            //Datos de Ususario
            JSONParser jParser = new JSONParser();
            JSONObject datos = (JSONObject) jParser.parse(usu.get("datos_personales").toString());
            
            String genero = datos.get("genero").toString();
            if (genero.equals("Hombre")) {
                tableMasculino.addCell(imagen);
                tableMasculino.addCell(usu.get("usuario").toString());
                tableMasculino.addCell(datos.get("nombre").toString());
                tableMasculino.addCell(datos.get("edad").toString());
            }
            
        }
        
        // Tabla Femenino
        Paragraph femenino = new Paragraph(new Phrase("\n\nFEMENINO\n\n", new Font(Font.FontFamily.COURIER, 20,Font.BOLD)));
        
        PdfPTable tableFemenino = new PdfPTable(4);
        tableFemenino.addCell(new Phrase("Foto", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        tableFemenino.addCell(new Phrase("Usuario", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        tableFemenino.addCell(new Phrase("Nombre Completo", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        tableFemenino.addCell(new Phrase("Edad", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        
        for (int i = 0; i < lista.size(); i++) {
            JSONObject usu = (JSONObject) lista.get(i);
            
            //Tratar la foto
            String cadenaFoto = usu.get("foto").toString();
            byte[] bites = Base64.getDecoder().decode(cadenaFoto);
            Image imagen = Image.getInstance(bites);
            imagen.scaleToFit(200,200);
            
            //Datos de Ususario
            JSONParser jParser = new JSONParser();
            JSONObject datos = (JSONObject) jParser.parse(usu.get("datos_personales").toString());
            
            String genero = datos.get("genero").toString();
            if (genero.equals("Mujer")) {
                tableFemenino.addCell(imagen);
                tableFemenino.addCell(usu.get("usuario").toString());
                tableFemenino.addCell(datos.get("nombre").toString());
                tableFemenino.addCell(datos.get("edad").toString());
            }
            
        }
        
        doc.add(titulo);
        doc.add(masculino);
        doc.add(tableMasculino);
        doc.add(femenino);
        doc.add(tableFemenino);
        doc.close();
    }
    
    private void edades(String archivo,JSONArray lista) throws Exception{
        //Abrir Documento
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(archivo));
        doc.open();
        
        // Texto
        Paragraph titulo = new Paragraph(new Phrase("\n             Edades", new Font(Font.FontFamily.COURIER, 25,Font.BOLD)));
        
        // Tabla Menores de Edad
        Paragraph menores = new Paragraph(new Phrase("\n\nMENORES DE EDAD\n\n", new Font(Font.FontFamily.COURIER, 20,Font.BOLD)));
        
        PdfPTable tableMenores = new PdfPTable(5);
        
        tableMenores.addCell(new Phrase("Foto", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        tableMenores.addCell(new Phrase("Usuario", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        tableMenores.addCell(new Phrase("Nombre Completo", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        tableMenores.addCell(new Phrase("Genero", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        tableMenores.addCell(new Phrase("Edad", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        
        // Tabla Mayores de Edad
        Paragraph mayores = new Paragraph(new Phrase("\n\nMAYORES DE EDAD\n\n", new Font(Font.FontFamily.COURIER, 20,Font.BOLD)));
        
        PdfPTable tableMayores = new PdfPTable(5);
        
        tableMayores.addCell(new Phrase("Foto", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        tableMayores.addCell(new Phrase("Usuario", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        tableMayores.addCell(new Phrase("Nombre Completo", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        tableMayores.addCell(new Phrase("Genero", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        tableMayores.addCell(new Phrase("Edad", new Font(Font.FontFamily.COURIER, 15,Font.BOLD)));
        
        
        for (int i = 0; i < lista.size(); i++) {
            JSONObject usu = (JSONObject) lista.get(i);
            
            //Tratar la foto
            String cadenaFoto = usu.get("foto").toString();
            byte[] bites = Base64.getDecoder().decode(cadenaFoto);
            Image imagen = Image.getInstance(bites);
            imagen.scaleToFit(200,200);
            
            //Datos de Ususario
            JSONParser jParser = new JSONParser();
            JSONObject datos = (JSONObject) jParser.parse(usu.get("datos_personales").toString());
            
            int edad = Integer.parseInt(datos.get("edad").toString());
            
            if (edad >= 18) {
                tableMayores.addCell(imagen);
                tableMayores.addCell(usu.get("usuario").toString());
                tableMayores.addCell(datos.get("nombre").toString());
                tableMayores.addCell(datos.get("genero").toString());
                tableMayores.addCell(datos.get("edad").toString());
            }else{
                tableMenores.addCell(imagen);
                tableMenores.addCell(usu.get("usuario").toString());
                tableMenores.addCell(datos.get("nombre").toString());
                tableMenores.addCell(datos.get("genero").toString());
                tableMenores.addCell(datos.get("edad").toString());
            }
            
        }
        
        doc.add(titulo);
        doc.add(menores);
        doc.add(tableMenores);
        doc.add(mayores);
        doc.add(tableMayores);
        doc.close();
    }
    
}
