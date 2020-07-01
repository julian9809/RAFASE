/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.ClienteDAO;
import control.PedidoDAO;
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
import modelo.Cliente;
import util.CaException;

/**
 *
 * @author david
 */
@WebServlet(name = "registro_user", urlPatterns = {"/registro_user"})
public class registro_user extends HttpServlet {

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
            throws ServletException, IOException, CaException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nombre = request.getParameter("nombre");
            String[] nombres = nombre.split(" ");
            String primerNombre = nombres[0];
            String segundoNombre;
            if(nombres.length == 1){
                segundoNombre = "";
            }
            else{
                segundoNombre = nombres[1];
            }
            String apellido = request.getParameter("apellido");
            String[] apellidos = apellido.split(" ");
            String primerApellido = apellidos[0];
            String segundoApellido;
            if(apellidos.length == 1){
                segundoApellido = "";
            }
            else{
                segundoApellido = apellidos[1];
            }
            Long cedula = Long.valueOf(request.getParameter("cedula"));
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            String nickname = request.getParameter("nickname");
            String fecha_nacimiento = request.getParameter("fecha_nacimiento");
            String password = request.getParameter("password");
            String confirme_password = request.getParameter("confirme_password");
            if (password.equals(confirme_password)) {
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cli = new Cliente();
                cli.setPrimer_nombre(primerNombre);
                cli.setSegundo_nombre(segundoNombre);
                cli.setPrimer_apellido(primerApellido);
                cli.setSegundo_apellido(segundoApellido);
                cli.setTipo_id("CC");
                cli.setId_cedula(cedula);
                cli.setEmail(email);
                cli.setGenero(gender);
                cli.setNickname(nickname);
                cli.setFecha_nacimiento((Date.valueOf(fecha_nacimiento)));
                cli.setPassword(password);
                System.out.println(""+password);
                clienteDAO.insertarCliente("admin_db", "dbadministrator", cli);
                clienteDAO.crearUsuario(nickname, password);
                PedidoDAO pedidoDAO = new PedidoDAO();
                pedidoDAO.crearCarrito(nickname, cli.getId_cedula());
                response.sendRedirect("index.jsp?usuario=" + nickname);
            } else {
                response.sendRedirect("templates/registro_user.jsp");
            }

            //response.sendRedirect("templates/buscarProductos.jsp?busqueda="+producto);
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
        try {
            processRequest(request, response);
        } catch (CaException ex) {
            Logger.getLogger(registro_user.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (CaException ex) {
            Logger.getLogger(registro_user.class.getName()).log(Level.SEVERE, null, ex);
        }
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
