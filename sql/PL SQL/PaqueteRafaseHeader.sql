CREATE OR REPLACE PACKAGE PK_PAQUETERAFASE AS

	/*----Función que calcula el total de la compra----*/
	--Recibe el id del pedido
	FUNCTION FU_TOTALPRODUCTOS(PK_PEDIDO IN PEDIDO.ID_PEDIDO%TYPE)
	RETURN NUMBER;

	/*----Función que calcula el iva total de la compra----*/
	--Recibe el id del pedido
	FUNCTION FU_IVATOTAL(PK_PEDIDO IN PEDIDO.ID_PEDIDO%TYPE)
	RETURN NUMBER;

	/*----Función que calcula el total de la compra sin el iva----*/
	--Recibe el id del pedido
	FUNCTION FU_TOTALSINIVA(PK_PEDIDO IN PEDIDO.ID_PEDIDO%TYPE)
	RETURN NUMBER;

	/*----Función que genera la sentencia para crear la factura----*/
	--Recibe el id del pedido
	FUNCTION FU_CREARFACTURA(PK_PEDIDO IN PEDIDO.ID_PEDIDO%TYPE)
	RETURN VARCHAR2;

	/*----Función que simula la existencia del banco----*/
	--Recibe el numero de la tarjeta, el codigo de seguridad y la fecha de vencimiento
	FUNCTION FU_COMPROBARPAGO(NUMERO_TARJETA_INGRESADA IN BANCO.NUMERO_TARJETA%TYPE, CODIGOVV IN BANCO.CVV%TYPE, FECHA_VEN IN BANCO.FECHA_EXP%TYPE)
	RETURN VARCHAR2;

	/*----Procedimiento que actualiza el stock del inventario----*/
	--Recibe el id del pedido
	PROCEDURE PR_ACTUALIZARSTOCK(PK_PEDIDO IN PEDIDO.ID_PEDIDO%TYPE);

END PK_PAQUETERAFASE;