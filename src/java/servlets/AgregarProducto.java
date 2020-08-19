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
     * @throws util.CaException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, CaException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            request.setCharacterEncoding("UTF-8");
            HttpSession sesion = request.getSession();

            String usuario = sesion.getAttribute("usuario").toString();
            String producto_buscado = request.getParameter("busqueda");
            String categoria_buscada = request.getParameter("categoria");
            String id_productoQuitar = request.getParameter("id_producto");
            String id_pedidoQuitar = request.getParameter("id_pedido");
            String cantidad_quitar = request.getParameter("cantidadQuitar");

            DAOFacade facade = new DAOFacade();
            Pedido pedido = facade.getPedido();
            DetallePedido detalle_pedido = facade.getDetallePedido();

            if (cantidad_quitar == null) {
                if (usuario.equals("visitante")) {
                    response.sendRedirect("templates/sign.jsp");
                } else {
                    long id_producto = Long.valueOf(request.getParameter("id_producto"));
                    long cantidad = Long.valueOf(request.getParameter("cantidad"));
                    long id_cliente = facade.buscarIdCliente(usuario, sesion.getAttribute("contraseña").toString());
                    long id_ciudad = facade.buscarIdCiudad(usuario, sesion.getAttribute("contraseña").toString(), sesion.getAttribute("Ciudad").toString());
                    System.out.println("id_cliente: " + id_cliente + " id ciudad: " + id_ciudad);
                    if (facade.existeCarrito(id_cliente, id_ciudad)) {
                        facade.consultarPedido(id_cliente, id_ciudad);
                        detalle_pedido.setId_pedido(pedido.getId_pedido_array().get(0));
                        detalle_pedido.setCantidad(cantidad);
                        detalle_pedido.setId_producto(id_producto);
                        if (facade.verificarExistencia(pedido.getId_pedido_array().get(0), detalle_pedido.getId_producto())) {
                            facade.actualizarCantidad(pedido.getId_pedido_array().get(0), detalle_pedido.getId_producto(), detalle_pedido.getCantidad());
                        } else {
                            facade.insertarProductosPedido(usuario);
                        }
                    } else {
                        pedido.setEstado_pedido("CA");
                        pedido.setTotal_pedido(1);
                        pedido.setId_cedula(id_cliente);
                        pedido.setId_ciudad(facade.buscarIdCiudad(usuario, sesion.getAttribute("contraseña").toString(), sesion.getAttribute("Ciudad").toString()));
                        pedido.setTipo_id(facade.buscarTipoID(usuario, sesion.getAttribute("contraseña").toString()));

                        facade.insertarPedido(usuario);
                        long id_pedido = facade.consultarIdPedido(id_cliente, id_ciudad);
                        System.out.println("el id del pedido es: " + id_pedido);
                        detalle_pedido.setId_pedido(facade.consultarIdPedido(id_cliente, id_ciudad));
                        detalle_pedido.setCantidad(cantidad);
                        detalle_pedido.setId_producto(id_producto);
                        if (facade.verificarExistencia(id_pedido, id_producto)) {
                            facade.actualizarCantidad(pedido.getId_pedido(), detalle_pedido.getId_producto(), detalle_pedido.getCantidad());
                        } else {
                            facade.insertarProductosPedido(usuario);
                        }
                    }
                    response.sendRedirect("templates/productos.jsp?busqueda=" + producto_buscado + "&categoria=" + categoria_buscada);
                }
            } else {
                System.out.println("cantidad: " + cantidad_quitar);
                System.out.println("ciudad: " + id_pedidoQuitar);
                facade.quitarProducto(Long.valueOf(id_productoQuitar), Long.valueOf(id_pedidoQuitar), Long.valueOf(cantidad_quitar));
                response.sendRedirect("templates/pago.jsp");
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
