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
import modelo.DetallePedido;
import modelo.Pedido;
import util.CaException;

/**
 *
 * @author danie
 */
@WebServlet(name = "AgregarProducto", urlPatterns = {"/AgregarProducto"})
public class AgregarProducto extends HttpServlet {

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
            String usuario = request.getParameter("usuario");
            String producto_buscado = request.getParameter("busqueda");
            if (usuario.equals("visitante")) {
                response.sendRedirect("templates/sign.jsp");
            } else {
                String id_producto = request.getParameter("id_producto");
                DAOFacade facade = new DAOFacade();
                DetallePedido deped = new DetallePedido();
                Pedido ped = new Pedido();
                if(facade.consultarPedidos(facade.buscarIdCliente(usuario))){
                    facade.consultarPedido(usuario, facade.buscarIdCliente(usuario));
                    deped.setId_pedido(ped.getId_pedido());
                    deped.setCantidad(1);
                    deped.setId_producto(Double.valueOf(id_producto));
                    
                    if(facade.verificarExistencia(ped.getId_pedido(), deped.getId_producto())){
                        facade.actualizarCantidad(ped.getId_pedido(), deped.getId_producto());
                    }else{
                        facade.insertarProductosPedido(usuario, deped);
                    }                    
                }
                else{                    
                    ped.setEstado_pedido(0);
                    ped.setTotal_pedido(1);
                    ped.setId_cedula(facade.buscarIdCliente(usuario));
                    ped.setId_ciudad(1);
                    
                    facade.insertarPedido(usuario, ped);
                    Pedido ped2 = new Pedido();
                    facade.consultarPedido(usuario, facade.buscarIdCliente(usuario));
                    
                    deped.setId_pedido(ped2.getId_pedido());
                    deped.setCantidad(1);
                    deped.setId_producto(Double.parseDouble(id_producto));
                    if(facade.verificarExistencia(ped2.getId_pedido(), deped.getId_producto())){
                        facade.actualizarCantidad(ped.getId_pedido(), deped.getId_producto());
                    }else{
                        facade.insertarProductosPedido(usuario, deped);
                    }  
                }          
                response.sendRedirect("templates/productos.jsp?usuario=" + usuario + "&busqueda=" + producto_buscado);

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
            Logger.getLogger(AgregarProducto.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AgregarProducto.class.getName()).log(Level.SEVERE, null, ex);
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
