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
import util.CaException;

/**
 *
 * @author david
 */
@WebServlet(name = "pagarPedido", urlPatterns = {"/pagarPedido"})
public class pagarPedido extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            HttpSession sesion = request.getSession();

            String usuario = sesion.getAttribute("usuario").toString();
            String password = sesion.getAttribute("contraseña").toString();
            String ciudad = sesion.getAttribute("Ciudad").toString();
            //Seteo de variables del formulario
            request.setCharacterEncoding("UTF-8");
            String nombre = request.getParameter("nombre");
            String[] nombres = nombre.split(" ");
            String primerNombre = nombres[0];
            String segundoNombre;
            if (nombres.length == 1) {
                segundoNombre = "";
            } else {
                segundoNombre = nombres[1];
            }
            String apellido = request.getParameter("apellido");
            String[] apellidos = apellido.split(" ");
            String primerApellido = apellidos[0];
            String segundoApellido;
            if (apellidos.length == 1) {
                segundoApellido = "";
            } else {
                segundoApellido = apellidos[1];
            }
            String nombreCompleto = nombre + " " + apellido;

            String direccion = request.getParameter("direccion");
            long telefono = Long.valueOf(request.getParameter("telefono"));
            String extras = request.getParameter("extras");
            String ciudadEnv = request.getParameter("ciudadEnv");

            String tipoPago = request.getParameter("tipoPago");
            String nombreTarCre = request.getParameter("nombreTarCre");
            Long numeroTarCre = Long.valueOf(request.getParameter("numeroTarCre"));
            String fechaTarCre = request.getParameter("mes") + "/" + request.getParameter("año");
            Long cvv = Long.valueOf(request.getParameter("CVV"));
            //Fin seteo de variables del formulario

            DAOFacade facade = new DAOFacade();
            long id_cliente = facade.buscarIdCliente(usuario, apellido);
            long id_ciudad = facade.buscarIdCiudad(usuario, apellido, ciudad);
            long pedido_id = facade.consultarIdPedido(id_cliente, id_ciudad);
            facade.cerrarConexion();
            facade.setearAdminDB();
            facade.realizarConexion();

            //Pago del pedido y simulación del banco
            facade.actualizarEstadoPedido(pedido_id, facade.obtenerTotalPedido(pedido_id));
            if (facade.confirmarTajertaConBanco(numeroTarCre, cvv, fechaTarCre, pedido_id)) {
                //Exito xd
                System.out.println("pago con exito");
                facade.actualizarEnvio(telefono, direccion, extras, nombreCompleto, tipoPago, ciudadEnv);
                System.out.println("envio exito");
                facade.nombreUsuario(usuario);
                facade.passwordUsuario(password);
                facade.realizarConexion();
                response.sendRedirect("templates/index.jsp");
            } else {
                //Sad xd
                System.out.println("pago malo");
                facade.nombreUsuario(usuario);
                facade.passwordUsuario(password);
                facade.realizarConexion();
                response.sendRedirect("templates/productos.jsp");
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
        try {
            processRequest(request, response);
        } catch (CaException ex) {
            Logger.getLogger(pagarPedido.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(pagarPedido.class.getName()).log(Level.SEVERE, null, ex);
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
