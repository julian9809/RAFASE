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

    private long ID_DETALLE_PEDIDO;
    private String CANTIDAD;
    private String ID_PEDIDO;
    private String ID_PRODUCTO;

    public long getID_DETALLE_PEDIDO() {
        return ID_DETALLE_PEDIDO;
    }

    public void setID_DETALLE_PEDIDO(long ID_DETALLE_PEDIDO) {
        this.ID_DETALLE_PEDIDO = ID_DETALLE_PEDIDO;
    }

    public String getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(String CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public String getID_PEDIDO() {
        return ID_PEDIDO;
    }

    public void setID_PEDIDO(String ID_PEDIDO) {
        this.ID_PEDIDO = ID_PEDIDO;
    }

    public String getID_PRODUCTO() {
        return ID_PRODUCTO;
    }

    public void setID_PRODUCTO(String ID_PRODUCTO) {
        this.ID_PRODUCTO = ID_PRODUCTO;
    }
    
    
}


