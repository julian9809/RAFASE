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
import control.DAOFacade;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.factura;

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
            DAOFacade facade = new DAOFacade();
            HttpSession sesion = request.getSession();
            String usuario = sesion.getAttribute("usuario").toString();
            String password = sesion.getAttribute("contraseña").toString();
            Long id_cliente = facade.buscarIdCliente(usuario, password);

            facade.cerrarConexion();
            facade.setearAdminDB();
            facade.realizarConexion();

            factura fact = facade.getFactura();
            facade.buscarFactura(Long.valueOf(id_factura));

            Cliente cli = facade.getCliente();
            facade.buscarDatosCliente(usuario, password, id_cliente);

            facade.cerrarConexion();
            facade.nombreUsuario(usuario);
            facade.passwordUsuario(password);
            facade.realizarConexion();

            Document documento = new Document();
            PdfWriter.getInstance(documento, out);

            documento.open();

            String relativeWebPath = "img/Logo.png";
            String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
            Image cabecera = Image.getInstance(absoluteDiskPath);
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
            cedula.add(new Phrase("Cedula: " + fact.getId_cedula_array().get(0)));
            cedula.add(new Phrase(Chunk.NEWLINE));
            cedula.add(new Phrase(Chunk.NEWLINE));

            documento.add(cedula);
            
            Paragraph cliente = new Paragraph();
            cliente.add(new Phrase("Cliente: " + cli.getPrimer_nombre_array().get(0) + " " + cli.getPrimer_apellido_array().get(0)));
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

            PdfPTable tabla = new PdfPTable(4);
            PdfPCell Producto = new PdfPCell(new Paragraph("Producto"));
            PdfPCell Iva = new PdfPCell(new Paragraph("IVA"));
            PdfPCell Cantidad = new PdfPCell(new Paragraph("Cantidad"));
            PdfPCell Total = new PdfPCell(new Paragraph("Total precio base"));

            tabla.addCell(Producto);
            tabla.addCell(Iva);
            tabla.addCell(Cantidad);
            tabla.addCell(Total);

            for (int i = 0; i < fact.getId_pedido_array().size(); i++) {
                PdfPCell Pro = new PdfPCell(new Paragraph(fact.getNombreProducto_array().get(i)));
                PdfPCell Iva2 = new PdfPCell(new Paragraph(fact.getIva_array().get(i).toString()));
                PdfPCell Cant = new PdfPCell(new Paragraph(fact.getCantidad_array().get(i).toString()));
                PdfPCell Tot = new PdfPCell(new Paragraph("" + fact.getPrecioProd_array().get(i) * fact.getCantidad_array().get(i)));

                tabla.addCell(Pro);
                tabla.addCell(Iva2);
                tabla.addCell(Cant);
                tabla.addCell(Tot);
            }

            PdfPCell Pro = new PdfPCell(new Paragraph(""));
            PdfPCell Iva2 = new PdfPCell(new Paragraph(""));
            PdfPCell Cant = new PdfPCell(new Paragraph("subtotal"));
            PdfPCell Tot = new PdfPCell(new Paragraph(fact.getPrecioSinIva_array().get(0).toString()));

            tabla.addCell(Pro);
            tabla.addCell(Iva2);
            tabla.addCell(Cant);
            tabla.addCell(Tot);

            documento.add(tabla);

            documento.add(blanco);

            Paragraph impuesto = new Paragraph();
            impuesto.add(new Phrase("Calculo total"));
            impuesto.setAlignment(Element.ALIGN_CENTER);
            impuesto.add(new Phrase(Chunk.NEWLINE));
            impuesto.add(new Phrase(Chunk.NEWLINE));

            documento.add(impuesto);

            PdfPTable tablaIva = new PdfPTable(2);

            PdfPCell Pro2 = new PdfPCell(new Paragraph("Subtotal"));
            PdfPCell Cant2 = new PdfPCell(new Paragraph(fact.getPrecioSinIva_array().get(0).toString()));

            tablaIva.addCell(Pro2);
            tablaIva.addCell(Cant2);

            PdfPCell Pro3 = new PdfPCell(new Paragraph("Subtotal IVA"));
            PdfPCell Cant3 = new PdfPCell(new Paragraph(fact.getIvaCompleto_array().get(0).toString()));

            tablaIva.addCell(Pro3);
            tablaIva.addCell(Cant3);

            PdfPCell Pro4 = new PdfPCell(new Paragraph("Total"));
            PdfPCell Cant4 = new PdfPCell(new Paragraph(fact.getPrecioConIva_array().get(0).toString()));

            tablaIva.addCell(Pro4);
            tablaIva.addCell(Cant4);

            documento.add(tablaIva);

            documento.add(blanco);

            Paragraph mensaje = new Paragraph();
            mensaje.add(new Phrase("#QuedateEnCasa  #5Pa'Los3", fontT));
            mensaje.setAlignment(Element.ALIGN_CENTER);
            mensaje.add(new Phrase(Chunk.NEWLINE));
            mensaje.add(new Phrase(Chunk.NEWLINE));

            documento.add(mensaje);

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
