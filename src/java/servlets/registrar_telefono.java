/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.DAOFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Telefono;
import util.CaException;

/**
 *
 * @author julia
 */
@WebServlet(name = "registrar_telefono", urlPatterns = {"/registrar_telefono"})
public class registrar_telefono extends HttpServlet {

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
            
            String usuario = sesion.getAttribute("usuario").toString();
            String contraseña = sesion.getAttribute("contraseña").toString();
            Long telefono = Long.valueOf(request.getParameter("telefono"));
            
            DAOFacade facade = new DAOFacade();
            Telefono tel = facade.getTelefono();            
            
            tel.setNumeroTelefono(telefono);
            tel.setEnUso("S");
            
            try {                
                System.out.println("paso1");
                long algo = facade.buscarIdCliente(usuario, contraseña);
                System.out.println("paso2");
                tel.setIdCedula(algo);
                System.out.println("paso3");
                tel.setTipoID(facade.buscarTipoID(usuario, contraseña));
            } catch (CaException ex) {
                System.out.println("error " + ex);
            }
            
            response.sendRedirect("templates/perfil_user.jsp");
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
