package util;

public class CaException extends Exception {
      private String detalle;
      private String clase;
      /**
       * Metodo constructor que recoge la descripci�n del 
       * error que genero la excepci�n.
       * 
       * @param error
       *        cadena que contiene la descripci�n del error.
       */

      public CaException(String clase,String error) {
        super(error);
        this.clase = clase; 
        detalle = error;
      }

    public CaException(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      public String toString() {
        return "["+clase+"] "+detalle;
      }
 }

