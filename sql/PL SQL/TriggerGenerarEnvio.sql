CREATE OR REPLACE TRIGGER TG_GENERARENVIO
AFTER UPDATE OF ESTADO_PEDIDO ON PEDIDO
FOR EACH ROW

DECLARE
	
	NUEVO_ID NUMBER;

BEGIN
	--Confirmación del estado del pedido original para asegurar el envio de solo los pedidos pagados
	IF :new.ESTADO_PEDIDO = 'PA' THEN
		NUEVO_ID := ID_ENVIO.NEXTVAL;
	    INSERT INTO ENVIO(ID_ENVIO,ESTADO, FECHA_ENTREGA_ESTIM, TELEFONO_DESTINO, NOMBRE_DESTINO, DIRECCION_ENVIO, METODO_PAGO, FECHA_PAGO, ID_PEDIDO, CIUDAD_DESTINO) VALUES (NUEVO_ID,'P',SYSDATE+1,1,'NOMBRE','placeholder','D',SYSDATE,:old.ID_PEDIDO,'placeholder');
	END IF;
END TG_GENERARENVIO;