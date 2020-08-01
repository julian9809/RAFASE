CREATE OR REPLACE VIEW INVENTARIO_RAFASE AS
(SELECT ciu.ID_CIUDAD,ciu.NOMBRE,categ.ID_CATEGORIA,categ.NOMBRE_CATEGORIA,categ.DESCRIPCION_CATEGORIA,
	subcat.ID_SUBCATEGORIA,subcat.NOMBRE_SUBCATEGORIA,prod.ID_PRODUCTO,prod.NOMBRE_PRODUCTO,
	prod.MARCA_PRODUCTO,prod.REFERENCIA_PRODUCTO,prod.CARACTERISTICAS_PRODUCTO,prod.FOTO,
	prod.IVA,prod.UNIDAD_MEDIDA,inv.EXISTENCIAS,inv.PRECIO_BASE
	FROM prod,inv,ciu,subcat,categ
	WHERE prod.ID_PRODUCTO = inv.ID_PRODUCTO
	AND ciu.ID_CIUDAD = inv.ID_CIUDAD
	AND prod.ID_SUBCATEGORIA = subcat.ID_SUBCATEGORIA
	AND subcat.ID_CATEGORIA = categ.ID_CATEGORIA);

create public synonym inv_rafa for admin_db.inventario_rafase;

grant select on inv_rafa to usuarioGeneral;
grant select on inv_rafa to cliente;
grant select on inv_rafa to adminRAFASE;