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
import modelo.Ciudad;
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
     * @throws util.CaException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, CaException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
            Long cedula = Long.valueOf(request.getParameter("cedula"));
            String tipo_id = request.getParameter("tipo_id");
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            String username = request.getParameter("username");
            String fecha_nacimiento = request.getParameter("fecha_nacimiento");
            String password = request.getParameter("password");
            String confirme_password = request.getParameter("confirme_password");
            //Fin seteo de variables del formulario

            HttpSession sesion = request.getSession();
            DAOFacade facade = new DAOFacade();
            //Buscar NO existe un usuario ya con ese nickname
            if (!facade.buscarExisteCliente(sesion.getAttribute("usuario")
                    .toString(), sesion.getAttribute("contraseña").toString(),
                    username)) {

                Cliente cli = facade.getCliente();
                cli.setPrimer_nombre(primerNombre);
                cli.setSegundo_nombre(segundoNombre);
                cli.setPrimer_apellido(primerApellido);
                cli.setSegundo_apellido(segundoApellido);
                cli.setTipo_id(tipo_id);
                cli.setId_cedula(cedula);
                cli.setEmail(email);
                cli.setGenero(gender);
                cli.setNickname(username);
                cli.setFecha_nacimiento((Date.valueOf(fecha_nacimiento)));
                cli.setPassword(password);

                //Conectarse como admin para crear usuario
                facade.cerrarConexion();
                facade.setearAdminDB();
                if (facade.realizarConexion()) {
                    //Crear usuario y carritos con AdminDB
                    facade.crearUsuario();
                    
                    Ciudad ciudad = facade.getCiudad();
                    facade.buscarCiudades(username, password);
                    //Se crea un carrito para todas la ciudades
                    for (int i = 0; i < ciudad.getId_ciudad_array().size(); i++) {
                        facade.crearCarrito(username, cli.getId_cedula(),
                                ciudad.getId_ciudad_array().get(i));
                    }
                    //Cierra conexión y setea los datos del usuario
                    facade.cerrarConexion();
                    facade.nombreUsuario(username);
                    facade.passwordUsuario(password);
                    if (facade.realizarConexion()) {
                        sesion.setAttribute("usuario", username);
                        sesion.setAttribute("contraseña", password);
                        response.sendRedirect("templates/index.jsp");
                    } else {
                        facade.cerrarConexion();
                        facade.nombreUsuario("visitante");
                        facade.passwordUsuario("abc123");
                        facade.realizarConexion();
                        response.sendRedirect("templates/index.jsp");
                    }
                } else {
                    facade.cerrarConexion();
                    facade.nombreUsuario("visitante");
                    facade.passwordUsuario("abc123");
                    facade.realizarConexion();
                    response.sendRedirect("templates/index.jsp");
                }

            } else {
                response.sendRedirect("templates/registro_user.jsp?e=1");
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
