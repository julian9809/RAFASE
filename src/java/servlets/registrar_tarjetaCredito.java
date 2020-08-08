/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.DAOFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.TarjetaCredito;
import util.CaException;

/**
 *
 * @author julia
 */
@WebServlet(name = "registrar_tarjetaCredito", urlPatterns = {"/registrar_tarjetaCredito"})
public class registrar_tarjetaCredito extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            request.setCharacterEncoding("UTF-8");            
            HttpSession sesion = request.getSession();
            DAOFacade facade = new DAOFacade(); 
            TarjetaCredito tarCre = facade.getTarjetaCredito();
            
            String usuario = sesion.getAttribute("usuario").toString();
            String contraseña = sesion.getAttribute("contraseña").toString();
            String nombre = request.getParameter("nombre");
            Long numero = Long.valueOf(request.getParameter("numero"));
            String fecha = request.getParameter("mes") + "/" + request.getParameter("año");
            
            tarCre.setNombreTitular(nombre);
            tarCre.setNumeroTarjeta(numero);
            tarCre.setFechaExp(fecha);
            try {
                tarCre.setIdCedula(facade.buscarIdCliente(usuario, contraseña));
                tarCre.setTipoID(facade.buscarTipoID(usuario, contraseña));
                facade.insertarTarjetaCredito(usuario, contraseña);
                
                response.sendRedirect("templates/perfil_user.jsp");
            } catch (CaException ex) {
                Logger.getLogger(registrar_tarjetaCredito.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
