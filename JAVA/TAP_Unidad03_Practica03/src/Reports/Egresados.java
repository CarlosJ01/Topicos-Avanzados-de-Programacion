/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import Models.Calificaciones;
import Models.Carrera;
import Models.Egresado;
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
public class Egresados {
    
    //Reporte Listado
    public void listado(String archivo, ArrayList<Egresado> egresados) throws Exception
    {
       Document doc = new Document();
       PdfWriter.getInstance(doc, new FileOutputStream(archivo));
       doc.open();

        // Imagen
        Image imagenITM = Image.getInstance("C:\\Users\\Carlos J\\Documents\\NetBeansProjects\\TAP_Unidad03_Practica03\\src\\Imagenes\\logo_original.png");
        imagenITM.scaleToFit(100,100);
        
        Image img = Image.getInstance("C:\\Users\\Carlos J\\Documents\\NetBeansProjects\\TAP_Unidad03_Practica03\\src\\Imagenes\\ponys.jpg");
        img.scaleToFit(50,50);

        // Texto
        Paragraph parrafo = new Paragraph("ITM");
        Paragraph parrafo2 = new Paragraph("\nListado de egresados:");
        Paragraph parrafo3 = new Paragraph("\n");

        // Tabla
        PdfPTable table = new PdfPTable(5); // 5 columnas
        
        table.addCell(new Phrase("Foto", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
        table.addCell(new Phrase("Numero de Control", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
        table.addCell(new Phrase("Nombre Completo", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
        table.addCell(new Phrase("Fecha de Egreso", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
        table.addCell(new Phrase("Carrera", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));

        for (Egresado e : egresados)
        {
            table.addCell(img);
            table.addCell(e.getNumControl());
            table.addCell(e.getNombreCompleto());
            table.addCell(e.getFechaEgreso());
            table.addCell(e.getCarrera().getNombreCarrera());
        }

        // Agregar todo
        doc.add(imagenITM);
        doc.add(parrafo);
        doc.add(parrafo2);
        doc.add(parrafo3);
        doc.add(table);
        doc.close();
    }
    
    //Reporte recientes por carrera
    public void recientes(String archivo,ArrayList<Egresado> egresados,ArrayList<Carrera> carreras) throws Exception
    {
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(archivo));
        doc.open();

        // Imagen
        Image imagenITM = Image.getInstance("C:\\Users\\Carlos J\\Documents\\NetBeansProjects\\TAP_Unidad03_Practica03\\src\\Imagenes\\logo_original.png");
        imagenITM.scaleToFit(100,100);
        
        Image img = Image.getInstance("C:\\Users\\Carlos J\\Documents\\NetBeansProjects\\TAP_Unidad03_Practica03\\src\\Imagenes\\ponys.jpg");
        img.scaleToFit(50,50);

        // Texto
        Paragraph parrafo = new Paragraph("ITM");
        Paragraph parrafo2 = new Paragraph("\nListado de Egresados recientes por carrera:");
        Paragraph parrafo3 = new Paragraph("\n");

        doc.add(imagenITM);
        doc.add(parrafo);
        doc.add(parrafo2);
        doc.add(parrafo3);

        //Recorrer cada carrera y cada egresado
        for (Carrera car : carreras)
        {
            Paragraph titulo = null;
            PdfPTable table = new PdfPTable(4);
            boolean encontrado = true;

            for (Egresado egr : egresados)
            {

                //Si la carrera es igual a la carrera del egresado
                if (car.getNombreCarrera().equals(egr.getCarrera().getNombreCarrera()))
                {
                    //Si es la primera vez
                    if (encontrado)
                    {
                        titulo = new Paragraph("\n\n"+car.getNombreCarrera()+"\n\n");

                        table.addCell(new Phrase("Foto", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
                        table.addCell(new Phrase("Numero de Control", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
                        table.addCell(new Phrase("Nombre Completo", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
                        table.addCell(new Phrase("Fecha de Egreso", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
                        encontrado = false;
                    }

                    table.addCell(img);
                    table.addCell(egr.getNumControl());
                    table.addCell(egr.getNombreCompleto());
                    table.addCell(egr.getFechaEgreso());                    
                }
            }

            if (encontrado == false)
            {
                doc.add(titulo);
                doc.add(table);
            }
        }

        doc.close();
    }
    
    //Por Generacion
    public void porGeneracion(String archivo,ArrayList<Egresado> egresados,ArrayList<String> generaciones) throws Exception
    {
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
        Paragraph parrafo2 = new Paragraph("\nEgresados Por Generacion");
        Paragraph parrafo3 = new Paragraph("\n\n");

        doc.add(imagenITM);
        doc.add(parrafo);
        doc.add(parrafo2);
        doc.add(parrafo3);

        for (String gen : generaciones)
        {
            Paragraph generacion = new Paragraph((Integer.parseInt(gen)-6)+" - "+gen+"\n\n", new Font(Font.FontFamily.COURIER, 18,Font.BOLD));

            PdfPTable table = new PdfPTable(5);
            table.addCell(new Phrase("Foto", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
            table.addCell(new Phrase("Numero de Control", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
            table.addCell(new Phrase("Nombre", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
            table.addCell(new Phrase("Fecha de Egreso", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
            table.addCell(new Phrase("Carrera", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
            
            for (Egresado item : egresados)
            {
                if (gen.equals(item.getGeneracion()))
                {
                    table.addCell(img);
                    table.addCell(item.getNumControl());
                    table.addCell(item.getNombreCompleto());
                    table.addCell(item.getFechaEgreso());
                    table.addCell(item.getCarrera().getNombreCarrera());
                }
            }

            doc.add(generacion);
            doc.add(table);
        }
        doc.close();
    }
    
    //Kardex Calificaciones
    public void kardexCalificaciones(String archivo, Egresado egresado, ArrayList<Calificaciones> lista, float promedio) throws Exception
    {
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(archivo));
        doc.open();

        // Imagen
        Image imagenITM = Image.getInstance("C:\\Users\\Carlos J\\Documents\\NetBeansProjects\\TAP_Unidad03_Practica03\\src\\Imagenes\\logo_original.png");
        imagenITM.scaleToFit(100,100);

        // Texto
        Paragraph parrafo = new Paragraph("ITM");
        Paragraph parrafo2 = new Paragraph("\nKardex Individual");
        Paragraph parrafo3 = new Paragraph("\n                                                      Datos del Egresado\n");
        Paragraph parrafo4 = new Paragraph("\n                  Numero de Control : " + egresado.getNumControl());
        Paragraph parrafo5 = new Paragraph("\n                  Nombre : " + egresado.getNombreCompleto());
        Paragraph parrafo6 = new Paragraph("\n                  Fecha de Egreso : " + egresado.getFechaEgreso());
        Paragraph parrafo7 = new Paragraph("\n                  Carrera : " + egresado.getCarrera().getNombreCarrera()+"\n\n\n");

        PdfPTable table = new PdfPTable(2);
        
        table.addCell(new Phrase("Materia", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
        table.addCell(new Phrase("Calificacion", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
        
        for (Calificaciones calif : lista)
        {
            table.addCell(calif.getMateria().getNombre_materia());
            table.addCell("" + calif.getCalificacion());
        }

        Paragraph prom = new Paragraph("\n\nPROMEDIO : " + promedio);


        doc.add(imagenITM);
        doc.add(parrafo);
        doc.add(parrafo2);
        doc.add(parrafo3);
        doc.add(parrafo4);
        doc.add(parrafo5);
        doc.add(parrafo6);
        doc.add(parrafo7);
        doc.add(table);
        doc.add(prom);

        doc.close();
    }
     
    //Top 10 por Carrera
    public void Top10Carrera(String archivo, ArrayList<ArrayList<Promedio>> tops,ArrayList<Carrera> carreras) throws Exception
    {
        
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
        Paragraph parrafo2 = new Paragraph("\nTop 10 por Carrera");
        Paragraph parrafo3 = new Paragraph("\n\n");

        doc.add(imagenITM);
        doc.add(parrafo);
        doc.add(parrafo2);
        doc.add(parrafo3);

        int top = -1;
        for (Carrera carrera : carreras)
        {
            top++;
            Paragraph nombreCarrera = new Paragraph(carrera.getNombreCarrera()+"\n\n", new Font(Font.FontFamily.COURIER, 18, Font.BOLD));

            PdfPTable table = new PdfPTable(6);
            table.addCell(new Phrase("Lugar", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
            table.addCell(new Phrase("Foto", new Font(Font.FontFamily.COURIER, 18, Font.BOLD)));
            table.addCell(new Phrase("Numero de Control", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
            table.addCell(new Phrase("Nombre", new Font(Font.FontFamily.COURIER, 18, Font.BOLD)));
            table.addCell(new Phrase("Fecha de Egreso", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
            table.addCell(new Phrase("Promedio", new Font(Font.FontFamily.COURIER, 18,Font.BOLD)));
           
            int lugar = 0;
            for (Promedio promedio : tops.get(top))
            {
                lugar++;
                table.addCell("" + lugar);
                table.addCell(img);
                table.addCell(promedio.getEgresado().getNumControl());
                table.addCell(promedio.getEgresado().getNombreCompleto());
                table.addCell(promedio.getEgresado().getFechaEgreso());
                table.addCell("" + promedio.getProm());
            }
            doc.add(nombreCarrera);
            doc.add(table);
        }

        doc.close();
    }
}
