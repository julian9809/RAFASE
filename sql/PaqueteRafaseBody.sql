CREATE OR REPLACE PACKAGE BODY PK_PAQUETERAFASE AS

	FUNCTION FU_TOTALPRODUCTOS(PK_PEDIDO IN PEDIDO.ID_PEDIDO%TYPE) RETURN NUMBER
	IS

		TOTAL NUMBER;
		VALORPRODUCTO NUMBER;
		IVA NUMBER;

		CURSOR C_TOTALPROD IS
		SELECT DEPE.CANTIDAD AS CANTIDAD, INV.PRECIO_BASE AS PRECIO, PROD.IVA AS IVA FROM PED, DEPE, INV, PROD WHERE PED.ID_PEDIDO = DEPE.ID_PEDIDO AND DEPE.ID_PRODUCTO = PROD.ID_PRODUCTO AND  INV.ID_PRODUCTO = PROD.ID_PRODUCTO AND PED.ID_PEDIDO = PK_PEDIDO;
		
	BEGIN
	TOTAL := 0;
		FOR VALORES IN C_TOTALPROD LOOP
			VALORPRODUCTO := VALORES.CANTIDAD * VALORES.PRECIO;
			IVA := VALORPRODUCTO * VALORES.IVA;
			TOTAL := TOTAL + VALORPRODUCTO + IVA;
		END LOOP;

		RETURN TOTAL;
	END FU_TOTALPRODUCTOS;

	FUNCTION FU_IVATOTAL(PK_PEDIDO IN PEDIDO.ID_PEDIDO%TYPE) RETURN NUMBER
	IS

		TOTAL NUMBER;
		VALORPRODUCTO NUMBER;
		IVA NUMBER;

		CURSOR C_TOTALPROD IS
		SELECT DEPE.CANTIDAD AS CANTIDAD, INV.PRECIO_BASE AS PRECIO, PROD.IVA AS IVA FROM PED, DEPE, INV, PROD WHERE PED.ID_PEDIDO = DEPE.ID_PEDIDO AND DEPE.ID_PRODUCTO = PROD.ID_PRODUCTO AND  INV.ID_PRODUCTO = PROD.ID_PRODUCTO AND PED.ID_PEDIDO = PK_PEDIDO;
		
	BEGIN
	TOTAL := 0;
		FOR VALORES IN C_TOTALPROD LOOP
			VALORPRODUCTO := VALORES.PRECIO;
			IVA := VALORPRODUCTO * VALORES.IVA;
			TOTAL := TOTAL + IVA;
		END LOOP;

		RETURN TOTAL;
	END FU_IVATOTAL;

	FUNCTION FU_TOTALSINIVA(PK_PEDIDO IN PEDIDO.ID_PEDIDO%TYPE) RETURN NUMBER
	IS

		TOTAL NUMBER;
		VALORPRODUCTO NUMBER;

		CURSOR C_TOTALPROD IS
		SELECT DEPE.CANTIDAD AS CANTIDAD, INV.PRECIO_BASE AS PRECIO, PROD.IVA AS IVA FROM PED, DEPE, INV, PROD WHERE PED.ID_PEDIDO = DEPE.ID_PEDIDO AND DEPE.ID_PRODUCTO = PROD.ID_PRODUCTO AND  INV.ID_PRODUCTO = PROD.ID_PRODUCTO AND PED.ID_PEDIDO = PK_PEDIDO;
		
	BEGIN
	TOTAL := 0;
		FOR VALORES IN C_TOTALPROD LOOP
			VALORPRODUCTO := VALORES.CANTIDAD * VALORES.PRECIO;
			TOTAL := TOTAL + VALORPRODUCTO;
		END LOOP;

		RETURN TOTAL;
	END FU_TOTALSINIVA;

	FUNCTION FU_CREARFACTURA(PK_PEDIDO IN PEDIDO.ID_PEDIDO%TYPE) RETURN VARCHAR2
	IS

		SENTENCIA VARCHAR2(2000);

	BEGIN
		SENTENCIA := 'CREATE OR REPLACE VIEW FACTURA' || PK_PEDIDO || ' AS SELECT USUR.ID_CEDULA, USUR.TIPO_ID, PED.ID_PEDIDO, DEPE.CANTIDAD AS CANTIDAD, INV.PRECIO_BASE AS PRECIO, PROD.IVA AS IVA, (SELECT PK_PAQUETERAFASE.FU_TOTALPRODUCTOS(' || PK_PEDIDO || ') FROM DUAL) AS PRECIOCOMPLETO, (SELECT PK_PAQUETERAFASE.FU_IVATOTAL(' || PK_PEDIDO || ') FROM DUAL) AS IVACOMPLETO, (SELECT PK_PAQUETERAFASE.FU_TOTALSINIVA(' || PK_PEDIDO || ') FROM DUAL) AS PRECIOSINIVA, ENV.METODO_PAGO, CIU.ID_CIUDAD FROM PED, DEPE, INV, PROD, ENV, USUR, CIU WHERE PED.ID_PEDIDO = DEPE.ID_PEDIDO AND DEPE.ID_PRODUCTO = PROD.ID_PRODUCTO AND INV.ID_PRODUCTO = PROD.ID_PRODUCTO AND PED.ID_PEDIDO = ENV.ID_PEDIDO AND PED.ID_PEDIDO = ' || PK_PEDIDO || ' AND USUR.ID_CEDULA = PED.ID_CEDULA AND USUR.TIPO_ID = PED.TIPO_ID AND CIU.ID_CIUDAD = PED.ID_CIUDAD';
		
		RETURN SENTENCIA;
	END FU_CREARFACTURA;

	FUNCTION FU_COMPROBARPAGO(NUMERO_TARJETA_INGRESADA IN BANCO.NUMERO_TARJETA%TYPE, CODIGOVV IN BANCO.CVV%TYPE, FECHA_VEN IN BANCO.FECHA_EXP%TYPE) RETURN VARCHAR2
	IS
	
		RESULTADO NUMBER;

		CURSOR C_TOTALPROD IS
		SELECT COUNT(*) AS CANTIDAD FROM BANCO WHERE NUMERO_TARJETA = NUMERO_TARJETA_INGRESADA AND CVV = CODIGOVV AND FECHA_VEN = FECHA_EXP;
	
	BEGIN
		FOR VALOR IN C_TOTALPROD LOOP
			RESULTADO := VALOR.CANTIDAD;
		END LOOP;
		IF RESULTADO = 1 THEN
			RETURN 'TRUE';
		ELSE
			RETURN 'FALSE';
		END IF;
	END FU_COMPROBARPAGO;

END PK_PAQUETERAFASE;

