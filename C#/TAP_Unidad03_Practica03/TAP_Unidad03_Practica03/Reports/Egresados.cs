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
    class Egresados
    {
        // Documentacion https://simpledotnetsolutions.wordpress.com/2012/04/08/itextsharp-few-c-examples/

        public void listado(String archivo, List<Egresado> egresados)
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
            
            // Texto
            Paragraph parrafo = new Paragraph("ITM");
            Paragraph parrafo2 = new Paragraph("\nListado de egresados:");
            Paragraph parrafo3 = new Paragraph("\n");
            
            // Tabla
            PdfPTable table = new PdfPTable(5); // 5 columnas
            // Theader
            table.AddCell(new Phrase("Foto", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
            table.AddCell(new Phrase("N° de Control", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
            table.AddCell(new Phrase("Nombre Completo", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
            table.AddCell(new Phrase("Fecha de Egreso", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
            table.AddCell(new Phrase("Carrera", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
            
            // Tbody
            foreach (Egresado e in egresados)
            {
                table.AddCell(img);
                table.AddCell(e.NumControl);
                table.AddCell(e.NombreCompleto);
                table.AddCell(e.FechaEgreso);
                table.AddCell(e.Carrera.NombreCarrera);
            }

            // Agregar todo
            doc.Add(logo);
            doc.Add(parrafo);
            doc.Add(parrafo2);
            doc.Add(parrafo3);
            doc.Add(table);
            doc.Close();
        }

        //Crea el PDF con los egresador recientes por carrera
        public void recientes(String archivo,List<Egresado> egresados,List<Carrera> carreras)
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

            // Texto
            Paragraph parrafo = new Paragraph("ITM");
            Paragraph parrafo2 = new Paragraph("\nListado de Egresados recientes por carrera:");
            Paragraph parrafo3 = new Paragraph("\n");

            doc.Add(logo);
            doc.Add(parrafo);
            doc.Add(parrafo2);
            doc.Add(parrafo3);
            
            //Recorrer cada carrera y cada egresado
            foreach (Carrera car in carreras)
            {
                Paragraph titulo = null;
                PdfPTable table = new PdfPTable(4);
                bool encontrado = true;

                foreach (Egresado egr in egresados)
                {

                    //Si la carrera es igual a la carrera del egresado
                    if (car.NombreCarrera == egr.Carrera.NombreCarrera)
                    {
                        //Si es la primera vez
                        if (encontrado)
                        {
                            titulo = new Paragraph("\n\n"+car.NombreCarrera+"\n\n");

                            table.AddCell(new Phrase("Foto", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
                            table.AddCell(new Phrase("N° de Control", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
                            table.AddCell(new Phrase("Nombre Completo", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
                            table.AddCell(new Phrase("Fecha de Egreso", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
                            encontrado = false;
                        }

                        table.AddCell(img);
                        table.AddCell(egr.NumControl);
                        table.AddCell(egr.NombreCompleto);
                        table.AddCell(egr.FechaEgreso);                    }
                }

                if (encontrado == false)
                {
                    doc.Add(titulo);
                    doc.Add(table);
                }
            }

            doc.Close();

        }

        //Kardex Calificaciones
        public void kardexCalificaciones(String archivo, Egresado egresado, List<Calificaciones> lista, float promedio)
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
            Paragraph parrafo2 = new Paragraph("\nKardex Individual");
            Paragraph parrafo3 = new Paragraph("\n                                                      Datos del Egresado\n");
            Paragraph parrafo4 = new Paragraph("\n                  Numero de Control : " + egresado.NumControl);
            Paragraph parrafo5 = new Paragraph("\n                  Nombre : " + egresado.NombreCompleto);
            Paragraph parrafo6 = new Paragraph("\n                  Fecha de Egreso : " + egresado.FechaEgreso);
            Paragraph parrafo7 = new Paragraph("\n                  Carrera : " + egresado.Carrera.NombreCarrera+"\n\n\n");

            PdfPTable table = new PdfPTable(2);
            table.AddCell(new Phrase("Materia", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
            table.AddCell(new Phrase("Calificacion", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));

            foreach (Calificaciones calif in lista)
            {
                table.AddCell(calif.Materia.Nombre_materia);
                table.AddCell("" + calif.Calificacion);
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
            doc.Add(table);
            doc.Add(prom);

            doc.Close();
        }

        //Top 10 por Carrera
        public void Top10Carrera(String archivo, List<List<Promedio>> tops,List<Carrera> carreras)
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

            //Texto
            Paragraph parrafo = new Paragraph("ITM");
            Paragraph parrafo2 = new Paragraph("\nTop 10 por Carrera");
            Paragraph parrafo3 = new Paragraph("\n\n");

            doc.Add(logo);
            doc.Add(parrafo);
            doc.Add(parrafo2);
            doc.Add(parrafo3);

            int top = -1;
            foreach (Carrera carrera in carreras)
            {
                top++;
                Paragraph nombreCarrera = new Paragraph(carrera.NombreCarrera+"\n\n", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD));

                PdfPTable table = new PdfPTable(6);
                table.AddCell(new Phrase("Lugar", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
                table.AddCell(new Phrase("Foto", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
                table.AddCell(new Phrase("Numero de Control", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
                table.AddCell(new Phrase("Nombre", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
                table.AddCell(new Phrase("Fecha de Egreso", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
                table.AddCell(new Phrase("Promedio", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));

                int lugar = 0;
                foreach (Promedio promedio in tops[top])
                {
                    lugar++;
                    table.AddCell("" + lugar);
                    table.AddCell(img);
                    table.AddCell(promedio.Egresado.NumControl);
                    table.AddCell(promedio.Egresado.NombreCompleto);
                    table.AddCell(promedio.Egresado.FechaEgreso);
                    table.AddCell("" + promedio.Prom);
                }
                doc.Add(nombreCarrera);
                doc.Add(table);
            }
            
            doc.Close();
        }

        //Por Generacion
        public void porGeneracion(String archivo,List<Egresado> egresados,List<String> generaciones)
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

            //Texto
            Paragraph parrafo = new Paragraph("ITM");
            Paragraph parrafo2 = new Paragraph("\nEgresados Por Generacion");
            Paragraph parrafo3 = new Paragraph("\n\n");

            doc.Add(logo);
            doc.Add(parrafo);
            doc.Add(parrafo2);
            doc.Add(parrafo3);

            foreach (String gen in generaciones)
            {
                Paragraph generacion = new Paragraph((int.Parse(gen)-6)+" - "+gen+"\n\n", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD));

                PdfPTable table = new PdfPTable(5);
                table.AddCell(new Phrase("Foto", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
                table.AddCell(new Phrase("Numero de Control", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
                table.AddCell(new Phrase("Nombre", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
                table.AddCell(new Phrase("Fecha de Egreso", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));
                table.AddCell(new Phrase("Carrera", new iTextSharp.text.Font(iTextSharp.text.Font.FontFamily.COURIER, 18, iTextSharp.text.Font.BOLD)));

                foreach (Egresado item in egresados)
                {
                    if (gen == item.Generacion)
                    {
                        table.AddCell(img);
                        table.AddCell(item.NumControl);
                        table.AddCell(item.NombreCompleto);
                        table.AddCell(item.FechaEgreso);
                        table.AddCell(item.Carrera.NombreCarrera);
                    }
                }

                doc.Add(generacion);
                doc.Add(table);
            }
            
            /*
            
            int top = -1;
            foreach (Carrera carrera in carreras)
            {
                top++;
                

                
                int lugar = 0;
                foreach (Promedio promedio in tops[top])
                {
                    lugar++;
                    
                }
                
            }
            */
            doc.Close();
        }
    }
}
