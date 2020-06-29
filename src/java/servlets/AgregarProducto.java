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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
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
                PedidoDAO pedidoDAO = new PedidoDAO();
                ClienteDAO clienteDAO = new ClienteDAO();
                DetallePedido deped = new DetallePedido();
                Pedido ped = new Pedido();
                if(pedidoDAO.consultarPedidos(clienteDAO.buscarIdCliente(usuario))){
                    ped = pedidoDAO.consultarPedido(usuario, clienteDAO.buscarIdCliente(usuario));
                    deped.setID_PEDIDO(ped.getId_pedido());
                    deped.setCANTIDAD(1);
                    deped.setID_PRODUCTO(Double.valueOf(id_producto));
                    pedidoDAO.insertarProductosPedido(usuario, deped);
                }
                else{                    
                    ped.setEstado_pedido(0);
                    ped.setTotal_pedido(1);
                    ped.setId_cedula(clienteDAO.buscarIdCliente(usuario));
                    ped.setId_ciudad(1);
                    
                    pedidoDAO.insertarPedido(usuario, ped);
                    Pedido ped2 = new Pedido();
                    ped2 = pedidoDAO.consultarPedido(usuario, clienteDAO.buscarIdCliente(usuario));
                    
                    deped.setID_PEDIDO(ped2.getId_pedido());
                    deped.setCANTIDAD(1);
                    deped.setID_PRODUCTO(Double.parseDouble(id_producto));
                    pedidoDAO.insertarProductosPedido(usuario, deped);
                }          
                System.out.println(id_producto);
                response.sendRedirect("templates/buscarProductos.jsp?usuario=" + usuario + "&busqueda=" + producto_buscado);

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
