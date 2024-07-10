using iTextSharp.text;
using iTextSharp.text.pdf;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TAP_Unidad03_Practica03.Models;

namespace TAP_Unidad03_Practica03.Reports
{
    class Alumnos
    {
        //Avannce individual de calificaciones
        public void AvanceCalif(String archivo,Alumno alumno, List<Calificaciones> lista, float promedio)
        {
            Document doc = new Document();
            PdfWriter.GetInstance(doc, new FileStream(archivo, FileMode.Create));
            doc.Open();

            // Imagen
            ImageConverter converter = new ImageConverter();

            byte[] byteLogo = (byte[])converter.ConvertTo(TAP_Unidad03_Practica03.Properties.Resources.logo_original, typeof(byte[]));
            iTextSharp.text.Image logo = iTextSharp.text.Image.GetInstance(byteLogo);
            logo.ScaleToFit(100, 100);

            // Texto
            Paragraph parrafo = new Paragraph("ITM");
            Paragraph parrafo2 = new Paragraph("\nAvance de Calificaciones");
            Paragraph parrafo3 = new Paragraph("\n                                                      Datos del Alumno\n");
            Paragraph parrafo4 = new Paragraph("\n                  Numero de Control : " + alumno.NumControl);
            Paragraph parrafo5 = new Paragraph("\n                  Nombre : " + alumno.NombreCompleto);
            Paragraph parrafo6 = new Paragraph("\n                  Semestre : " + alumno.Semestre);
            Paragraph parrafo7 = new Paragraph("\n                  Carrera : " + alumno.Carrera.NombreCarrera);
            Paragraph titulo = new Paragraph("\nCALIFICACIONES\n\n\n");

            PdfPTable table = new PdfPTable(2);
            table.AddCell(new Phrase("Materia", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
            table.AddCell(new Phrase("Calificacion", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));

            foreach (Calificaciones calif in lista)
            {
                table.AddCell(calif.Materia.Nombre_materia);
                table.AddCell(""+calif.Calificacion);
            }

            Paragraph prom = new Paragraph("\n\nPROMEDIO : " + promedio);
            

            doc.Add(logo);
            doc.Add(parrafo);
            doc.Add(parrafo2);
            doc.Add(parrafo3);
            doc.Add(parrafo4);
            doc.Add(parrafo5);
            doc.Add(parrafo6);
            doc.Add(parrafo7);
            doc.Add(titulo);
            doc.Add(table);
            doc.Add(prom);

            doc.Close();
        }

        //Top 10 promedios
        public void Top10(String archivo, List<Promedio> lista)
        {
            Document doc = new Document();
            PdfWriter.GetInstance(doc, new FileStream(archivo, FileMode.Create));
            doc.Open();

            // Imagen
            ImageConverter converter = new ImageConverter();

            byte[] byteImg = (byte[])converter.ConvertTo(TAP_Unidad03_Practica03.Properties.Resources.ponys, typeof(byte[]));
            iTextSharp.text.Image img = iTextSharp.text.Image.GetInstance(byteImg);
            img.ScaleToFit(50, 50);

            byte[] byteLogo = (byte[])converter.ConvertTo(TAP_Unidad03_Practica03.Properties.Resources.logo_original, typeof(byte[]));
            iTextSharp.text.Image logo = iTextSharp.text.Image.GetInstance(byteLogo);
            logo.ScaleToFit(100, 100);

            Paragraph parrafo = new Paragraph("ITM");
            Paragraph parrafo2 = new Paragraph("\nTop 10 mejores promedios");
            Paragraph parrafo3 = new Paragraph("\n");

            PdfPTable table = new PdfPTable(7);
            table.AddCell(new Phrase("Lugar", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
            table.AddCell(new Phrase("Foto", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
            table.AddCell(new Phrase("Numero de Control", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
            table.AddCell(new Phrase("Nombre", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
            table.AddCell(new Phrase("Semestre", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
            table.AddCell(new Phrase("Carrera", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
            table.AddCell(new Phrase("Promedio", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));

            int lugar = 0;
            foreach (Promedio alumno in lista)
            {
                lugar++;
                table.AddCell(""+lugar);
                table.AddCell(img);
                table.AddCell(alumno.Alumno.NumControl);
                table.AddCell(alumno.Alumno.NombreCompleto);
                table.AddCell(""+alumno.Alumno.Semestre);
                table.AddCell(alumno.Alumno.Carrera.NombreCarrera);
                table.AddCell("" + alumno.Prom);
            }

            doc.Add(logo);
            doc.Add(parrafo);
            doc.Add(parrafo2);
            doc.Add(parrafo3);
            doc.Add(table);

            doc.Close();
        }

        //Porcentaje de Reprobacion
        public void PorcentajeReprobacion(String archivo, List<float> porcentaje, List<Materia> materias)
        {
            Document doc = new Document();
            PdfWriter.GetInstance(doc, new FileStream(archivo, FileMode.Create));
            doc.Open();

            // Imagen
            ImageConverter converter = new ImageConverter();

            byte[] byteLogo = (byte[])converter.ConvertTo(TAP_Unidad03_Practica03.Properties.Resources.logo_original, typeof(byte[]));
            iTextSharp.text.Image logo = iTextSharp.text.Image.GetInstance(byteLogo);
            logo.ScaleToFit(100, 100);

            //Texto
            Paragraph parrafo = new Paragraph("ITM");
            Paragraph parrafo2 = new Paragraph("\nPorentaje de Reprobacion");
            Paragraph parrafo3 = new Paragraph("\n");

            //Tabla
            PdfPTable table = new PdfPTable(2);
            table.AddCell(new Phrase("Materia", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
            table.AddCell(new Phrase("Porcentaje", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));

            int indice = -1;
            foreach (Materia item in materias)
            {
                indice++;
                table.AddCell(item.Nombre_materia);
                table.AddCell(porcentaje.ElementAt(indice)+"%");
            }

            doc.Add(logo);
            doc.Add(parrafo);
            doc.Add(parrafo2);
            doc.Add(parrafo3);
            doc.Add(table);

            doc.Close();
        }
    }
}
