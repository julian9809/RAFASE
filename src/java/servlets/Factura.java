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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(name = "Factura", urlPatterns = {"/Factura"})
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

            String id_factura = request.getParameter("idPedido");

            Document documento = new Document();
            PdfWriter.getInstance(documento, out);

            documento.open();          

            Image cabecera = Image.getInstance("C:\\Users\\julia\\Documents\\Proyecto final BD2\\RAFASE\\web\\img\\Logo.png");
            cabecera.setAlignment(Element.ALIGN_CENTER);
            cabecera.scaleToFit(100, 100);
            
            documento.add(cabecera);

            Font fontT = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);

            Paragraph titulo = new Paragraph();
            titulo.add(new Phrase("Factura de compra", fontT));
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.add(new Phrase(Chunk.NEWLINE));

            documento.add(titulo);
            
            Paragraph factura = new Paragraph();
            factura.add(new Phrase("Factura No. " + id_factura));
            factura.setAlignment(Element.ALIGN_CENTER);
            factura.add(new Phrase(Chunk.NEWLINE));
            factura.add(new Phrase(Chunk.NEWLINE));
            factura.add(new Phrase(Chunk.NEWLINE));

            documento.add(factura);

            Paragraph cedula = new Paragraph();
            cedula.add(new Phrase("Cedula: "));
            cedula.add(new Phrase(Chunk.NEWLINE));
            cedula.add(new Phrase(Chunk.NEWLINE));

            documento.add(cedula);

            Paragraph cliente = new Paragraph();
            cliente.add(new Phrase("Cliente: "));
            cliente.add(new Phrase(Chunk.NEWLINE));
            cliente.add(new Phrase(Chunk.NEWLINE));

            documento.add(cliente);

            Paragraph vendedor = new Paragraph();
            vendedor.add(new Phrase("Vendedor: RAFASE JDJ"));
            vendedor.add(new Phrase(Chunk.NEWLINE));
            vendedor.add(new Phrase(Chunk.NEWLINE));

            documento.add(vendedor);
            
            Paragraph blanco = new Paragraph();
            blanco.add(new Phrase(""));
            blanco.add(new Phrase(Chunk.NEWLINE));
            blanco.add(new Phrase(Chunk.NEWLINE));
            blanco.add(new Phrase(Chunk.NEWLINE));
            blanco.add(new Phrase(Chunk.NEWLINE));
            

            documento.add(blanco); 

            PdfPTable tabla = new PdfPTable(3);
            PdfPCell Producto = new PdfPCell(new Paragraph("Producto"));
            PdfPCell Cantidad = new PdfPCell(new Paragraph("Cantidad"));
            PdfPCell Total = new PdfPCell(new Paragraph("Total"));           

            tabla.addCell(Producto);
            tabla.addCell(Cantidad);
            tabla.addCell(Total);

            documento.add(tabla);          
                      
            

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