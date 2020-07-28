CREATE OR REPLACE VIEW INVENTARIO_RAFASE AS
(SELECT ciu.ID_CIUDAD,categ.ID_CATEGORIA,categ.NOMBRE_CATEGORIA,categ.DESCRIPCION_CATEGORIA,
	subcat.ID_SUBCATEGORIA,subcat.NOMBRE_SUBCATEGORIA,prod.ID_PRODUCTO,prod.NOMBRE_PRODUCTO,
	prod.MARCA_PRODUCTO,prod.REFERENCIA_PRODUCTO,prod.CARACTERISTICAS_PRODUCTO,prod.FOTO,
	prod.ID_SUBCATEGORIA,prod.IVA,prod.UNIDAD_MEDIDA,inv.EXISTENCIAS,inv.PRECIO_BASE
	FROM prod,inv,ciu,subcat,categ
	WHERE prod.ID_PRODUCTO = inv.ID_PRODUCTO
	AND ciu.ID_CIUDAD = inv.ID_CIUDAD
	AND prod.ID_SUBCATEGORIA = subcat.ID_SUBCATEGORIA
	AND subcat.ID_CATEGORIA = categ.ID_CATEGORIA);
