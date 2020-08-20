/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabStop;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
public class Factura extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        try {
            String Cedula = request.getParameter("cedula");
            String Placa = request.getParameter("placa");
            String baseGravable = request.getParameter("avaluo");
            String impuesto = request.getParameter("impuesto");
            String tarifa = request.getParameter("tarifa");
            String semaforizacion = request.getParameter("semaforizacion");
            String descuento = request.getParameter("descuentoOC");
            String volunt = request.getParameter("volunt");
            String totalNDes = request.getParameter("totalNDes");
            String totalDes = request.getParameter("totalDes");
            String idLiquidacion = request.getParameter("idLiquidacion");
            String anio = request.getParameter("anio");

            Document documento = new Document();
            PdfWriter.getInstance(documento, out);

            documento.open();

            Image cabecera = Image.getInstance("C:\\Users\\Asus\\Documents\\NetBeansProjects\\ProyectoFinalFBD\\cabeceraPDF.png");
            cabecera.setAlignment(Element.ALIGN_CENTER);
            cabecera.scaleToFit(documento.getPageSize());

            documento.add(cabecera);

            Font fontT = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);

            Paragraph titulo = new Paragraph();
            titulo.add(new Phrase("Impuesto Vehicular", fontT));
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.add(new Phrase(Chunk.NEWLINE));
            titulo.add(new Phrase(Chunk.NEWLINE));
            titulo.add(new Phrase(Chunk.NEWLINE));

            documento.add(titulo);

            Paragraph cedula = new Paragraph();
            cedula.add(new Phrase("Cedula: " + Cedula));
            cedula.add(new Phrase(Chunk.NEWLINE));
            cedula.add(new Phrase(Chunk.NEWLINE));

            documento.add(cedula);

            Paragraph placa = new Paragraph();
            placa.add(new Phrase("Placa: " + Placa));
            placa.add(new Phrase(Chunk.NEWLINE));
            placa.add(new Phrase(Chunk.NEWLINE));

            documento.add(placa);

            Paragraph idLiquidacionP = new Paragraph();
            idLiquidacionP.add(new Phrase("Numero de liquidacion " + idLiquidacion));
            idLiquidacionP.add(new Phrase(Chunk.NEWLINE));
            idLiquidacionP.add(new Phrase(Chunk.NEWLINE));

            documento.add(idLiquidacionP);

            Paragraph anioGra = new Paragraph();
            anioGra.add(new Phrase("Año gravable " + anio));
            anioGra.add(new Phrase(Chunk.NEWLINE));
            anioGra.add(new Phrase(Chunk.NEWLINE));
            anioGra.add(new Phrase(Chunk.NEWLINE));
            anioGra.add(new Phrase(Chunk.NEWLINE));
            anioGra.add(new Phrase(Chunk.NEWLINE));

            documento.add(anioGra);

            PdfPTable tabla = new PdfPTable(3);
            PdfPCell FLimite = new PdfPCell(new Paragraph("Fechas Limite de Pago"));
            PdfPCell F1 = new PdfPCell(new Paragraph("HASTA 05/05/2017"));
            PdfPCell F2 = new PdfPCell(new Paragraph("HASTA 23/06/2017"));

            PdfPCell Tavaluo = new PdfPCell(new Paragraph("Avaluo Comercial"));
            PdfPCell bg1 = new PdfPCell(new Paragraph(baseGravable));
            PdfPCell bg2 = new PdfPCell(new Paragraph(baseGravable));

            PdfPCell tarif = new PdfPCell(new Paragraph("Tarifa Aplicada"));
            PdfPCell t1 = new PdfPCell(new Paragraph(tarifa));
            PdfPCell t2 = new PdfPCell(new Paragraph(tarifa));

            PdfPCell Vimpuesto = new PdfPCell(new Paragraph("Valor Impuesto"));
            PdfPCell v1 = new PdfPCell(new Paragraph(impuesto));
            PdfPCell v2 = new PdfPCell(new Paragraph(impuesto));

            PdfPCell sem = new PdfPCell(new Paragraph("Valor semaforizacion"));
            PdfPCell sem1 = new PdfPCell(new Paragraph(semaforizacion));
            PdfPCell sem2 = new PdfPCell(new Paragraph(semaforizacion));

            PdfPCell descPronto = new PdfPCell(new Paragraph("Descuento por pronto pago"));
            PdfPCell desc1 = new PdfPCell(new Paragraph(descuento));
            PdfPCell desc2 = new PdfPCell(new Paragraph(0));

            PdfPCell voluntcell = new PdfPCell(new Paragraph("Valor Voluntario"));
            PdfPCell volcell1 = new PdfPCell(new Paragraph(volunt));
            PdfPCell volcell2 = new PdfPCell(new Paragraph(volunt));

            PdfPCell pTotal = new PdfPCell(new Paragraph("Pago total"));
            PdfPCell pt1 = new PdfPCell(new Paragraph(totalDes));
            PdfPCell pt2 = new PdfPCell(new Paragraph(totalNDes));

            tabla.addCell(FLimite);
            tabla.addCell(F1);
            tabla.addCell(F2);
            tabla.addCell(Tavaluo);
            tabla.addCell(bg1);
            tabla.addCell(bg2);
            tabla.addCell(Vimpuesto);
            tabla.addCell(v1);
            tabla.addCell(v2);
            tabla.addCell(sem);
            tabla.addCell(sem1);
            tabla.addCell(sem2);
            tabla.addCell(descPronto);
            tabla.addCell(desc1);
            tabla.addCell(desc2);
            tabla.addCell(voluntcell);
            tabla.addCell(volcell1);
            tabla.addCell(volcell2);
            tabla.addCell(pTotal);
            tabla.addCell(pt1);
            tabla.addCell(pt2);

            documento.add(tabla);
            
            Paragraph blanco = new Paragraph();
            blanco.add(new Phrase(""));
            blanco.add(new Phrase(Chunk.NEWLINE));
            blanco.add(new Phrase(Chunk.NEWLINE));
            blanco.add(new Phrase(Chunk.NEWLINE));
            blanco.add(new Phrase(Chunk.NEWLINE));
            blanco.add(new Phrase(Chunk.NEWLINE));
            blanco.add(new Phrase(Chunk.NEWLINE));
            

            documento.add(blanco);
            
            Image barras = Image.getInstance("C:\\Users\\Asus\\Documents\\NetBeansProjects\\ProyectoFinalFBD\\codigoBarras.png");
            barras.setAlignment(Element.ALIGN_CENTER);
            barras.scaleToFit(documento.getPageSize());

            documento.add(barras);

            documento.close();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}