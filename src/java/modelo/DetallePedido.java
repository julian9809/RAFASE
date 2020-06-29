/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Mateo
 */
public class DetallePedido {

    private double ID_DETALLE_PEDIDO;
    private double CANTIDAD;
    private double ID_PEDIDO;
    private double ID_PRODUCTO;

    public double getID_DETALLE_PEDIDO() {
        return ID_DETALLE_PEDIDO;
    }

    public void setID_DETALLE_PEDIDO(double ID_DETALLE_PEDIDO) {
        this.ID_DETALLE_PEDIDO = ID_DETALLE_PEDIDO;
    }

    public double getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(double CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public double getID_PEDIDO() {
        return ID_PEDIDO;
    }

    public void setID_PEDIDO(double ID_PEDIDO) {
        this.ID_PEDIDO = ID_PEDIDO;
    }

    public double getID_PRODUCTO() {
        return ID_PRODUCTO;
    }

    public void setID_PRODUCTO(double ID_PRODUCTO) {
        this.ID_PRODUCTO = ID_PRODUCTO;
    }

  
    
}


