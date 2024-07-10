/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import Models.Alumno;
import Models.Calificaciones;
import Models.Materia;
import Models.Promedio;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Carlos J
 */
public class Alumnos {
    
    //Avance Individual
    public void AvanceCalif(String archivo,Alumno alumno, ArrayList<Calificaciones> lista, float promedio) throws Exception{
        //Abrir Documento
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(archivo));
        doc.open();
        
        
        // Imagen
        Image imagenITM = Image.getInstance("C:\\Users\\Carlos J\\Documents\\NetBeansProjects\\TAP_Unidad03_Practica03\\src\\Imagenes\\logo_original.png");
        imagenITM.scaleToFit(100,100);
        
        // Texto
        Paragraph parrafo = new Paragraph("ITM");
        Paragraph parrafo2 = new Paragraph("\nAvance de Calificaciones");
        Paragraph parrafo3 = new Paragraph("\n                                                      Datos del Alumno\n");
        Paragraph parrafo4 = new Paragraph("\n                  Numero de Control : " + alumno.getNumeroControl());
        Paragraph parrafo5 = new Paragraph("\n                  Nombre : " + alumno.getNombreCompleto());
        Paragraph parrafo6 = new Paragraph("\n                  Semestre : " + alumno.getSemestre());
        Paragraph parrafo7 = new Paragraph("\n                  Carrera : " + alumno.getCarrera().getNombreCarrera());
        Paragraph titulo = new Paragraph("\nCALIFICACIONES\n\n\n");

        //Tabla
        PdfPTable table = new PdfPTable(2);        
        table.addCell(new Phrase("Materia", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
        table.addCell(new Phrase("Calificacion", new Font(Font.FontFamily.COURIER, 18, Font.BOLD)));
        for (Calificaciones calif : lista){
            table.addCell(calif.getMateria().getNombre_materia());
            table.addCell(""+calif.getCalificacion());
        }

        //Promedio
        Paragraph prom = new Paragraph("\n\nPROMEDIO : " + promedio);

        //Agregar
        doc.add(imagenITM);
        doc.add(parrafo);
        doc.add(parrafo2);
        doc.add(parrafo3);
        doc.add(parrafo4);
        doc.add(parrafo5);
        doc.add(parrafo6);
        doc.add(parrafo7);
        doc.add(titulo);
        doc.add(table);
        doc.add(prom);
        doc.close();
    }
    
    //Top 10
    public void Top10(String archivo, ArrayList<Promedio> lista) throws Exception{
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(archivo));
        doc.open();

        // Imagen
        Image imagenITM = Image.getInstance("C:\\Users\\Carlos J\\Documents\\NetBeansProjects\\TAP_Unidad03_Practica03\\src\\Imagenes\\logo_original.png");
        imagenITM.scaleToFit(100,100);
        
        Image img = Image.getInstance("C:\\Users\\Carlos J\\Documents\\NetBeansProjects\\TAP_Unidad03_Practica03\\src\\Imagenes\\ponys.jpg");
        img.scaleToFit(50,50);
        
        //Texto
        Paragraph parrafo = new Paragraph("ITM");
        Paragraph parrafo2 = new Paragraph("\nTop 10 mejores promedios");
        Paragraph parrafo3 = new Paragraph("\n");

        PdfPTable table = new PdfPTable(7);
        table.addCell(new Phrase("Lugar", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
        table.addCell(new Phrase("Foto", new Font(Font.FontFamily.COURIER, 18, Font.BOLD)));
        table.addCell(new Phrase("Numero de Control", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
        table.addCell(new Phrase("Nombre", new Font(Font.FontFamily.COURIER, 18, Font.BOLD)));
        table.addCell(new Phrase("Semestre", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
        table.addCell(new Phrase("Carrera", new Font(Font.FontFamily.COURIER, 18, Font.BOLD)));
        table.addCell(new Phrase("Promedio", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
        
        int lugar = 0;
        for (Promedio alumno : lista)
        {
            lugar++;
            table.addCell(""+lugar);
            table.addCell(img);
            table.addCell(alumno.getAlumno().getNumeroControl());
            table.addCell(alumno.getAlumno().getNombreCompleto());
            table.addCell(""+alumno.getAlumno().getSemestre());
            table.addCell(alumno.getAlumno().getCarrera().getNombreCarrera());
            table.addCell("" + alumno.getProm());
        }

        doc.add(imagenITM);
        doc.add(parrafo);
        doc.add(parrafo2);
        doc.add(parrafo3);
        doc.add(table);

        doc.close();
    }
    
    //Porcentaje de Reprobacion
    public void PorcentajeReprobacion(String archivo, ArrayList<Float> porcentaje, ArrayList<Materia> materias) throws Exception
    {
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(archivo));
        doc.open();

        // Imagen
        Image imagenITM = Image.getInstance("C:\\Users\\Carlos J\\Documents\\NetBeansProjects\\TAP_Unidad03_Practica03\\src\\Imagenes\\logo_original.png");
        imagenITM.scaleToFit(100,100);

        //Texto
        Paragraph parrafo = new Paragraph("ITM");
        Paragraph parrafo2 = new Paragraph("\nPorentaje de Reprobacion");
        Paragraph parrafo3 = new Paragraph("\n");

        //Tabla
        PdfPTable table = new PdfPTable(2);
        table.addCell(new Phrase("Materia", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
        table.addCell(new Phrase("Porcentaje", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
        
        int indice = -1;
        for (Materia item : materias)
        {
            indice++;
            table.addCell(item.getNombre_materia());
            table.addCell(porcentaje.get(indice)+"%");
        }

        doc.add(imagenITM);
        doc.add(parrafo);
        doc.add(parrafo2);
        doc.add(parrafo3);
        doc.add(table);

        doc.close();
    }
}
