/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 13.5 		*/
/*  Created On : 04-Jul-2020 10:52:21 AM 				*/
/*  DBMS       : Oracle 						*/
/* ---------------------------------------------------- */

/* Drop Tables */

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Administrador  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Categoria  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Ciudad  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Detalle_Pedido  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Direccion  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Envio  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Forma_Pago  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Inventario  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Pedido  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Producto  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Proveedor  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Subcategoria  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Sucursal  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     TarjetaCredito  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Telefono  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Tienda  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE     Usuario  CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;  
/

/* Create Tables */

CREATE TABLE    Administrador 
(
	  ID_ADMINISTRADOR  NUMBER(38) NOT NULL,    -- N. de identificacion del administrador
	  NOMBRE_ADMINISTRADOR  VARCHAR2(50) NOT NULL,    -- Nombre del administrador
	  EMAIL  VARCHAR2(50) NOT NULL,    -- Correo electr�nico del administrador
	  CONTRASENA  VARCHAR2(50) NOT NULL    -- Contrase�a del administrador
)
;

CREATE TABLE    Categoria 
(
	  ID_CATEGORIA  NUMBER(8) NOT NULL,    -- Identificador de la categor�a
	  NOMBRE_CATEGORIA  VARCHAR2(20) NOT NULL,    -- Nombre de la categoria
	  IVA  NUMBER(4,3) NOT NULL,    -- Iva que se le asigna a las distintas caegorias
	  DESCRIPCION_CATEGORIA  VARCHAR2(50) NULL    -- Descripcion de cada categoria
)
;

CREATE TABLE    Ciudad 
(
	  ID_CIUDAD  NUMBER(8) NOT NULL,    -- Identificador de la ciudad
	  NOMBRE  VARCHAR2(20) NOT NULL,    -- Nombre de la ciudad
	  ID_TIENDA  NUMBER(8) NULL
)
;

CREATE TABLE    Detalle_Pedido 
(
	  ID_PEDIDO  NUMBER(12) NOT NULL,    -- Id del pedido al que se ponen los productos, es una llave compuesta con producto
	  ID_PRODUCTO  NUMBER(30) NOT NULL,    -- Id de los productos es una llave compuesta con pedido
	  CANTIDAD  NUMBER(2) NOT NULL    -- Cantidad numerica de el producto relacionado
)
;

CREATE TABLE    Direccion 
(
	  ID_DIRECCION  NUMBER(20) NOT NULL,    -- Identificador de la direcci�n
	  DIRECCION_COMPLETA  VARCHAR2(50) NOT NULL,    -- Direccion completa
	  EXTRAS  VARCHAR2(50) NULL,    -- Detalles extra que el cliente provee para ubicar su direccion
	  TIPO_DIRECCION  VARCHAR2(1) NOT NULL,    -- Diferencia si la direccion es de residencia (R), de env�o (E) o que no esta en uso (N)
	  ID_CEDULA  NUMBER(20) NOT NULL,    -- Documento asociado a esta direcci�n
	  ID_CIUDAD  NUMBER(8) NOT NULL
)
;

CREATE TABLE    Envio 
(
	  ID_ENVIO  NUMBER(8) NOT NULL,    -- C�digo del env�o
	  ESTADO  VARCHAR2(1) NOT NULL,    -- Estado actual del env�o (entregado (E) o pendiente (P))
	  FECHA_ENTREGA_ESTIM  DATE NOT NULL,    -- Fecha en que se asume llegar� el env�o
	  FECHA_ENTREGA_REAL  DATE NULL,    -- Fecha en la que lleg� el env�o
	  TELEFONO_DESTINO  VARCHAR2(15) NOT NULL,    -- Numero de tel�fono de quien resive
	  NOMBRE_DESTINO  VARCHAR2(20) NOT NULL,    -- Mombre de la persona que recibe
	  DIRECCION_ENVIO  VARCHAR2(50) NOT NULL,    -- Direccion donde se va a llevar el env�o
	  EXTRAS  VARCHAR2(50) NULL,    -- Especificaciones de la direccion en caso de un conjunto
	  METODO_PAGO  VARCHAR2(1) NOT NULL,    -- Metodo como se pago
	  FECHA_PAGO  DATE NOT NULL,    -- Fecha cuando se pago
	  ID_PEDIDO  NUMBER(12) NULL    -- Pedido al que se relaciona el envio
)
;

CREATE TABLE    Forma_Pago 
(
	  ID_FACTURA  NUMBER(8) NOT NULL,    -- Numero de Factura
	  FECHA_PAGO  DATE NOT NULL,    -- Fecha en que se realiza el pago
	  METODO_PAGO  VARCHAR2(1) NOT NULL    -- Forma de pago que selecciona el cliente, entre PSE (P) o Tarjeta credito (C)
)
;

CREATE TABLE    Inventario 
(
	  ID_PRODUCTO  NUMBER(30) NOT NULL,    -- Codigo del producto almacenado, llave compuesta con sucursal
	  EXISTENCIAS  NUMBER(5) NOT NULL,    -- Existencias actuales del producto en la tienda
	  ID_CIUDAD  NUMBER(8) NULL,
	  ID_PROVEEDOR  NUMBER(38) NULL
)
;

CREATE TABLE    Pedido 
(
	  ID_PEDIDO  NUMBER(12) NOT NULL,    -- C�digo del pedido
	  ESTADO_PEDIDO  VARCHAR2(2) NOT NULL,    -- Fase actual del pedido 'CA' - carrito, 'PP' -pendiente pago, 'PA' - pagado
	  FECHA_PEDIDO  DATE NOT NULL,    -- Fecha de creacion/modificaciom del pedido
	  TOTAL_PEDIDO  NUMBER(12,2) NOT NULL,    -- Suma de los costos de todos los productos en el pedido
	  ID_CEDULA  NUMBER(20) NOT NULL,    -- Documento del cliente que hace el pedido
	  ID_CIUDAD  NUMBER(8) NOT NULL    -- C�digo de la ciudad donde se va a enviar el pedido
)
;

CREATE TABLE    Producto 
(
	  ID_PRODUCTO  NUMBER(30) NOT NULL,    -- Identificador del producto
	  NOMBRE_PRODUCTO  VARCHAR2(50) NOT NULL,    -- Nombre del producto
	  MARCA_PRODUCTO  VARCHAR2(50) NOT NULL,    -- Marca, editorial o productor del producto
	  REFERENCIA_PRODUCTO  VARCHAR2(50) NOT NULL,    -- Referencia del producto
	  CARACTERISTICAS_PRODUCTO  VARCHAR2(50) NULL,    -- Caracteristicas del producto
	  FOTO  VARCHAR2(50) NOT NULL,    -- Foto del producto en formato .jpg
	  PRECIO_BASE  NUMBER(10,2) NOT NULL,    -- Precio base del producto
	  UNIDAD_MEDIDA  VARCHAR2(15) NOT NULL,    -- Para productos de mercado se manejan lb, kg, g, litros. Para el resto se maneja por Unidad 
	  ID_SUBCATEGORIA  NUMBER(8) NOT NULL    -- Subcategor�a a la que pertenece el producto
)
;

CREATE TABLE    Proveedor 
(
	  ID_PROVEEDOR  NUMBER(38) NOT NULL,    -- Nit del proveedor
	  NOMBRE_PROVEEDOR  VARCHAR2(50) NOT NULL,    -- Nombre o Marca del proveedor
	  DIRECCION_PROVEEDOR  VARCHAR2(50) NOT NULL    -- Direccion donde se ubica el proveedor
)
;

CREATE TABLE    Subcategoria 
(
	  ID_SUBCATEGORIA  NUMBER(8) NOT NULL,    -- Identificador de la subcategoria
	  NOMBRE_SUBCATEGORIA  VARCHAR2(40) NOT NULL,    -- Nombre de la subcategoria
	  ID_CATEGORIA  NUMBER(8) NOT NULL    -- Identificador de la categoria a la que pertenece
)
;

CREATE TABLE    Sucursal 
(
	  ID_SUCURSAL  NUMBER(8) NOT NULL,    -- codigo de la sucursal
	  ID_CIUDAD  NUMBER(8) NOT NULL,    -- codigo de la ciudad donde est� la sucursal
	  ID_TIENDA  NUMBER(8) NOT NULL    -- Codigo de la tienda
)
;

CREATE TABLE    TarjetaCredito 
(
	  ID_TARJETA  NUMBER(38) NOT NULL,    -- Identificador unico dentro de la BD
	  NOMBRETITULAR  VARCHAR2(50) NOT NULL,    -- Nombre que aparece en la tarjeta de credito
	  NUMERO_TARJETA  NUMBER(30) NOT NULL,    -- N�mero de la tarjeta de credito, esta impresa en la tarjeta
	  FECH_EXP  DATE NOT NULL,    -- Fecha de expiracion impreso en la tarjeta  The Oracle standard DATE format for input and output is DD-MON-YY e.g., 01-JAN-17
	  CSV  NUMBER(3) NOT NULL,    -- Card Security Code, codigo de seguridad al respaldo de la tarjeta
	  ID_CEDULA  NUMBER(20) NOT NULL    -- Persona que usa esta tarjeta
)
;

CREATE TABLE    Telefono 
(
	  ID_TELEFONO  NUMBER(10) NOT NULL,    -- Identificador dentro de la base de datos
	  NUMERO_TELEFONO  NUMBER(15) NOT NULL,    -- N�mero telefonico del cliente
	  EN_USO  VARCHAR2(1) NOT NULL,    -- Dice si el telefono es usado por el usuario o no (S) si esta en uso o (N) no esta en uso
	  ID_CEDULA  NUMBER(20) NOT NULL    -- Documento a quien pertenece el n�mero de tel�fono
)
;

CREATE TABLE    Tienda 
(
	  ID_TIENDA  NUMBER(8) NOT NULL,    -- Identificador de la tienda
	  COSTO_ENV_LOC  NUMBER(6,2) NOT NULL,    -- Costo de envio para un pedido en la misma ciudad
	  COSTO_ENV_NAC  NUMBER(6,2) NOT NULL,    -- Costo de envio fuera de la ciudad origen
	  TIEMPO_VIDA_CARRITO  NUMBER(2) NOT NULL,    -- Tiempo (dias) de vida del carrito 
	  MIN_CANTIDAD_PRODUCTOS  NUMBER(2) NOT NULL,    -- Existencias minias admitidas en stock para poder pedir un producto.
	  ID_ADMINISTRADOR  NUMBER(38) NOT NULL    -- Identificador del administrador que maneja la tienda
)
;

CREATE TABLE    Usuario 
(
	  ID_CEDULA  NUMBER(20) NOT NULL,    -- Cedula del usuario
	  PRIMER_NOMB  VARCHAR2(20) NOT NULL,    -- Primer nombre del usuario
	  SEGUNDO_NOMB  VARCHAR2(40) NULL,    -- Segundo nombre del usuario
	  PRIMER_APELL  VARCHAR2(20) NOT NULL,    -- Primer apellido del usuario
	  SEGUNDO_APELL  VARCHAR2(20) NULL,    -- Segundo apellido del usuario
	  PASSWORD  VARCHAR2(50) NOT NULL,    -- contrase�a del usuario
	  FECH_NAC  DATE NOT NULL,    -- Fecha de nacimiento del cliente  The Oracle standard date format for input and output is DD-MON-YY e.g., 01-JAN-17
	  TIPO_ID  VARCHAR2(2) NOT NULL,    -- Tipo de identificaci�n del cliente
	  GENERO  VARCHAR2(1) NOT NULL,    -- Genero del cliente
	  EMAIL  VARCHAR2(50) NOT NULL,    -- e-mail con el que se registra el cliente
	  NICKNAME  VARCHAR2(10) NOT NULL    -- Nombre de usuario seleccionado por el cliente
)
;

/* Create Comments, Sequences and Triggers for Autonumber Columns */

COMMENT ON TABLE    Administrador  IS 'Persona responsable de RAFASE'
;

COMMENT ON COLUMN    Administrador .  ID_ADMINISTRADOR  IS 'N. de identificacion del administrador'
;

COMMENT ON COLUMN    Administrador .  NOMBRE_ADMINISTRADOR  IS 'Nombre del administrador'
;

COMMENT ON COLUMN    Administrador .  EMAIL  IS 'Correo electr�nico del administrador'
;

COMMENT ON COLUMN    Administrador .  CONTRASENA  IS 'Contrase�a del administrador'
;

COMMENT ON TABLE    Categoria  IS 'Categoria general de productos (ENTRETENIMIENTO, HOGAR, MERCADO)'
;

COMMENT ON COLUMN    Categoria .  ID_CATEGORIA  IS 'Identificador de la categor�a'
;

COMMENT ON COLUMN    Categoria .  NOMBRE_CATEGORIA  IS 'Nombre de la categoria'
;

COMMENT ON COLUMN    Categoria .  IVA  IS 'Iva que se le asigna a las distintas caegorias'
;

COMMENT ON COLUMN    Categoria .  DESCRIPCION_CATEGORIA  IS 'Descripcion de cada categoria'
;

COMMENT ON TABLE    Ciudad  IS 'Almacena nombres de ciudades'
;

COMMENT ON COLUMN    Ciudad .  ID_CIUDAD  IS 'Identificador de la ciudad'
;

COMMENT ON COLUMN    Ciudad .  NOMBRE  IS 'Nombre de la ciudad'
;

COMMENT ON TABLE    Detalle_Pedido  IS 'Tabla de rompimiento entre muchos pedidos a muchos productos, guarda la cantidad de un producto en un pedido'
;

COMMENT ON COLUMN    Detalle_Pedido .  ID_PEDIDO  IS 'Id del pedido al que se ponen los productos, es una llave compuesta con producto'
;

COMMENT ON COLUMN    Detalle_Pedido .  ID_PRODUCTO  IS 'Id de los productos es una llave compuesta con pedido'
;

COMMENT ON COLUMN    Detalle_Pedido .  CANTIDAD  IS 'Cantidad numerica de el producto relacionado'
;

COMMENT ON TABLE    Direccion  IS 'Almacena direcciones residenciales y de entrega'
;

COMMENT ON COLUMN    Direccion .  ID_DIRECCION  IS 'Identificador de la direcci�n'
;

COMMENT ON COLUMN    Direccion .  DIRECCION_COMPLETA  IS 'Direccion completa'
;

COMMENT ON COLUMN    Direccion .  EXTRAS  IS 'Detalles extra que el cliente provee para ubicar su direccion'
;

COMMENT ON COLUMN    Direccion .  TIPO_DIRECCION  IS 'Diferencia si la direccion es de residencia (R), de env�o (E) o que no esta en uso (N)'
;

COMMENT ON COLUMN    Direccion .  ID_CEDULA  IS 'Documento asociado a esta direcci�n'
;

COMMENT ON TABLE    Envio  IS 'Control de envios'
;

COMMENT ON COLUMN    Envio .  ID_ENVIO  IS 'C�digo del env�o'
;

COMMENT ON COLUMN    Envio .  ESTADO  IS 'Estado actual del env�o (entregado (E) o pendiente (P))'
;

COMMENT ON COLUMN    Envio .  FECHA_ENTREGA_ESTIM  IS 'Fecha en que se asume llegar� el env�o'
;

COMMENT ON COLUMN    Envio .  FECHA_ENTREGA_REAL  IS 'Fecha en la que lleg� el env�o'
;

COMMENT ON COLUMN    Envio .  TELEFONO_DESTINO  IS 'Numero de tel�fono de quien resive'
;

COMMENT ON COLUMN    Envio .  NOMBRE_DESTINO  IS 'Mombre de la persona que recibe'
;

COMMENT ON COLUMN    Envio .  DIRECCION_ENVIO  IS 'Direccion donde se va a llevar el env�o'
;

COMMENT ON COLUMN    Envio .  EXTRAS  IS 'Especificaciones de la direccion en caso de un conjunto'
;

COMMENT ON COLUMN    Envio .  METODO_PAGO  IS 'Metodo como se pago'
;

COMMENT ON COLUMN    Envio .  FECHA_PAGO  IS 'Fecha cuando se pago'
;

COMMENT ON COLUMN    Envio .  ID_PEDIDO  IS 'Pedido al que se relaciona el envio'
;

COMMENT ON TABLE    Forma_Pago  IS 'Detalle de los pedidos'
;

COMMENT ON COLUMN    Forma_Pago .  ID_FACTURA  IS 'Numero de Factura'
;

COMMENT ON COLUMN    Forma_Pago .  FECHA_PAGO  IS 'Fecha en que se realiza el pago'
;

COMMENT ON COLUMN    Forma_Pago .  METODO_PAGO  IS 'Forma de pago que selecciona el cliente, entre PSE (P) o Tarjeta credito (C)'
;

COMMENT ON TABLE    Inventario  IS 'Relacion que representa Inventario de productos actual en bodega de cada sucursal - tabla de rompimiento de muchos productos en muchas sucursales'
;

COMMENT ON COLUMN    Inventario .  ID_PRODUCTO  IS 'Codigo del producto almacenado, llave compuesta con sucursal'
;

COMMENT ON COLUMN    Inventario .  EXISTENCIAS  IS 'Existencias actuales del producto en la tienda'
;

COMMENT ON TABLE    Pedido  IS 'Ordenes de compra de los clientes, pedidos que un usuario registrado '
;

COMMENT ON COLUMN    Pedido .  ID_PEDIDO  IS 'C�digo del pedido'
;

COMMENT ON COLUMN    Pedido .  ESTADO_PEDIDO  IS 'Fase actual del pedido ''CA'' - carrito, ''PP'' -pendiente pago, ''PA'' - pagado'
;

COMMENT ON COLUMN    Pedido .  FECHA_PEDIDO  IS 'Fecha de creacion/modificaciom del pedido'
;

COMMENT ON COLUMN    Pedido .  TOTAL_PEDIDO  IS 'Suma de los costos de todos los productos en el pedido'
;

COMMENT ON COLUMN    Pedido .  ID_CEDULA  IS 'Documento del cliente que hace el pedido'
;

COMMENT ON COLUMN    Pedido .  ID_CIUDAD  IS 'C�digo de la ciudad donde se va a enviar el pedido'
;

COMMENT ON TABLE    Producto  IS 'Lista de productos ofrecidos por RAFASE'
;

COMMENT ON COLUMN    Producto .  ID_PRODUCTO  IS 'Identificador del producto'
;

COMMENT ON COLUMN    Producto .  NOMBRE_PRODUCTO  IS 'Nombre del producto'
;

COMMENT ON COLUMN    Producto .  MARCA_PRODUCTO  IS 'Marca, editorial o productor del producto'
;

COMMENT ON COLUMN    Producto .  REFERENCIA_PRODUCTO  IS 'Referencia del producto'
;

COMMENT ON COLUMN    Producto .  CARACTERISTICAS_PRODUCTO  IS 'Caracteristicas del producto'
;

COMMENT ON COLUMN    Producto .  FOTO  IS 'Foto del producto en formato .jpg'
;

COMMENT ON COLUMN    Producto .  PRECIO_BASE  IS 'Precio base del producto'
;

COMMENT ON COLUMN    Producto .  UNIDAD_MEDIDA  IS 'Para productos de mercado se manejan lb, kg, g, litros. Para el resto se maneja por Unidad '
;

COMMENT ON COLUMN    Producto .  ID_SUBCATEGORIA  IS 'Subcategor�a a la que pertenece el producto'
;

COMMENT ON TABLE    Proveedor  IS 'Marca o empresa que provee productos a RAFASE'
;

COMMENT ON COLUMN    Proveedor .  ID_PROVEEDOR  IS 'Nit del proveedor'
;

COMMENT ON COLUMN    Proveedor .  NOMBRE_PROVEEDOR  IS 'Nombre o Marca del proveedor'
;

COMMENT ON COLUMN    Proveedor .  DIRECCION_PROVEEDOR  IS 'Direccion donde se ubica el proveedor'
;

COMMENT ON TABLE    Subcategoria  IS 'Grupo especifico al que pertenece el producto'
;

COMMENT ON COLUMN    Subcategoria .  ID_SUBCATEGORIA  IS 'Identificador de la subcategoria'
;

COMMENT ON COLUMN    Subcategoria .  NOMBRE_SUBCATEGORIA  IS 'Nombre de la subcategoria'
;

COMMENT ON COLUMN    Subcategoria .  ID_CATEGORIA  IS 'Identificador de la categoria a la que pertenece'
;

COMMENT ON TABLE    Sucursal  IS 'Bodega de la ciudad'
;

COMMENT ON COLUMN    Sucursal .  ID_SUCURSAL  IS 'codigo de la sucursal'
;

COMMENT ON COLUMN    Sucursal .  ID_CIUDAD  IS 'codigo de la ciudad donde est� la sucursal'
;

COMMENT ON COLUMN    Sucursal .  ID_TIENDA  IS 'Codigo de la tienda'
;

COMMENT ON TABLE    TarjetaCredito  IS 'Tarjetas de credito de usuarios guardadas en el sistema'
;

COMMENT ON COLUMN    TarjetaCredito .  ID_TARJETA  IS 'Identificador unico dentro de la BD'
;

COMMENT ON COLUMN    TarjetaCredito .  NOMBRETITULAR  IS 'Nombre que aparece en la tarjeta de credito'
;

COMMENT ON COLUMN    TarjetaCredito .  NUMERO_TARJETA  IS 'N�mero de la tarjeta de credito, esta impresa en la tarjeta'
;

COMMENT ON COLUMN    TarjetaCredito .  FECH_EXP  IS 'Fecha de expiracion impreso en la tarjeta  The Oracle standard DATE format for input and output is DD-MON-YY e.g., 01-JAN-17'
;

COMMENT ON COLUMN    TarjetaCredito .  CSV  IS 'Card Security Code, codigo de seguridad al respaldo de la tarjeta'
;

COMMENT ON COLUMN    TarjetaCredito .  ID_CEDULA  IS 'Persona que usa esta tarjeta'
;

COMMENT ON TABLE    Telefono  IS 'Almacena los n�meros telef�nicos de los usuarios'
;

COMMENT ON COLUMN    Telefono .  ID_TELEFONO  IS 'Identificador dentro de la base de datos'
;

COMMENT ON COLUMN    Telefono .  NUMERO_TELEFONO  IS 'N�mero telefonico del cliente'
;

COMMENT ON COLUMN    Telefono .  EN_USO  IS 'Dice si el telefono es usado por el usuario o no (S) si esta en uso o (N) no esta en uso'
;

COMMENT ON COLUMN    Telefono .  ID_CEDULA  IS 'Documento a quien pertenece el n�mero de tel�fono'
;

COMMENT ON TABLE    Tienda  IS 'Tabla con los detalles generales de la tienda'
;

COMMENT ON COLUMN    Tienda .  ID_TIENDA  IS 'Identificador de la tienda'
;

COMMENT ON COLUMN    Tienda .  COSTO_ENV_LOC  IS 'Costo de envio para un pedido en la misma ciudad'
;

COMMENT ON COLUMN    Tienda .  COSTO_ENV_NAC  IS 'Costo de envio fuera de la ciudad origen'
;

COMMENT ON COLUMN    Tienda .  TIEMPO_VIDA_CARRITO  IS 'Tiempo (dias) de vida del carrito '
;

COMMENT ON COLUMN    Tienda .  MIN_CANTIDAD_PRODUCTOS  IS 'Existencias minias admitidas en stock para poder pedir un producto.'
;

COMMENT ON COLUMN    Tienda .  ID_ADMINISTRADOR  IS 'Identificador del administrador que maneja la tienda'
;

COMMENT ON TABLE    Usuario  IS 'Un usuario registrado que puede realizar compras dentro del sistema, almacenar tarjetas de credito y guardar un carrito.'
;

COMMENT ON COLUMN    Usuario .  ID_CEDULA  IS 'Cedula del usuario'
;

COMMENT ON COLUMN    Usuario .  PRIMER_NOMB  IS 'Primer nombre del usuario'
;

COMMENT ON COLUMN    Usuario .  SEGUNDO_NOMB  IS 'Segundo nombre del usuario'
;

COMMENT ON COLUMN    Usuario .  PRIMER_APELL  IS 'Primer apellido del usuario'
;

COMMENT ON COLUMN    Usuario .  SEGUNDO_APELL  IS 'Segundo apellido del usuario'
;

COMMENT ON COLUMN    Usuario .  PASSWORD  IS 'contrase�a del usuario'
;

COMMENT ON COLUMN    Usuario .  FECH_NAC  IS 'Fecha de nacimiento del cliente  The Oracle standard date format for input and output is DD-MON-YY e.g., 01-JAN-17'
;

COMMENT ON COLUMN    Usuario .  TIPO_ID  IS 'Tipo de identificaci�n del cliente'
;

COMMENT ON COLUMN    Usuario .  GENERO  IS 'Genero del cliente'
;

COMMENT ON COLUMN    Usuario .  EMAIL  IS 'e-mail con el que se registra el cliente'
;

COMMENT ON COLUMN    Usuario .  NICKNAME  IS 'Nombre de usuario seleccionado por el cliente'
;

/* Create Primary Keys, Indexes, Uniques, Checks, Triggers */

ALTER TABLE    Administrador  
 ADD CONSTRAINT   PK_ADMINISTRADOR 
	PRIMARY KEY (  ID_ADMINISTRADOR ) 
 USING INDEX
;

ALTER TABLE    Administrador  
 ADD CONSTRAINT   CK_ADMINISTRADOR  CHECK (ID_ADMINISTRADOR > 0)
;

ALTER TABLE    Categoria  
 ADD CONSTRAINT   PK_CATEGORIA 
	PRIMARY KEY (  ID_CATEGORIA ) 
 USING INDEX
;

ALTER TABLE    Categoria  
 ADD CONSTRAINT   CK_CATEGORIA  CHECK (ID_CATEGORIA > 0)
;

ALTER TABLE    Categoria  
 ADD CONSTRAINT   CK_IVA  CHECK (IVA > 0)
;

ALTER TABLE    Ciudad  
 ADD CONSTRAINT   PK_CIUDAD 
	PRIMARY KEY (  ID_CIUDAD ) 
 USING INDEX
;

ALTER TABLE    Ciudad  
 ADD CONSTRAINT   CK_CIUDAD  CHECK (ID_CIUDAD > 0)
;

ALTER TABLE    Ciudad  
 ADD CONSTRAINT   CK_TIENDA  CHECK (ID_TIENDA > 0)
;

ALTER TABLE    Detalle_Pedido  
 ADD CONSTRAINT   PK_PEDIDO_PRODUCTO 
	PRIMARY KEY (  ID_PEDIDO ,  ID_PRODUCTO ) 
 USING INDEX
;

ALTER TABLE    Detalle_Pedido  
 ADD CONSTRAINT   CK_CANTIDAD  CHECK (CANTIDAD > 0)
;

ALTER TABLE    Detalle_Pedido  
 ADD CONSTRAINT   CK_PEDIDO  CHECK (ID_PEDIDO > 0)
;

ALTER TABLE    Detalle_Pedido  
 ADD CONSTRAINT   CK_PRODUCTO  CHECK (ID_PRODUCTO > 0)
;

ALTER TABLE    Direccion  
 ADD CONSTRAINT   PK_DIRECCION 
	PRIMARY KEY (  ID_DIRECCION ) 
 USING INDEX
;

ALTER TABLE    Direccion  
 ADD CONSTRAINT   CK_TIPO_DIRECCION  CHECK (TIPO_DIRECCION IN ('R','E','N'))
;

ALTER TABLE    Direccion  
 ADD CONSTRAINT   CK_DIRECCION  CHECK (ID_DIRECCION > 0)
;

ALTER TABLE    Direccion  
 ADD CONSTRAINT   CK_CEDULA  CHECK (ID_CEDULA > 0)
;

ALTER TABLE    Direccion  
 ADD CONSTRAINT   CK_CIUDAD  CHECK (ID_CIUDAD > 0)
;

ALTER TABLE    Envio  
 ADD CONSTRAINT   PK_ENVIO 
	PRIMARY KEY (  ID_ENVIO ) 
 USING INDEX
;

ALTER TABLE    Envio  
 ADD CONSTRAINT   ESTADO  CHECK (ESTADO IN ('E', 'P'))
;

ALTER TABLE    Envio  
 ADD CONSTRAINT   CK_ENVIO  CHECK (CK_ENVIO)
;

ALTER TABLE    Envio  
 ADD CONSTRAINT   CK_PEDIDO  CHECK (CK_PEDIDO)
;

ALTER TABLE    Forma_Pago  
 ADD CONSTRAINT   PK_FACTURA 
	PRIMARY KEY (  ID_FACTURA ) 
 USING INDEX
;

ALTER TABLE    Forma_Pago  
 ADD CONSTRAINT   CK_METODO_PAGO  CHECK (METODO_PAGO in ('P','C'))
;

ALTER TABLE    Inventario  
 ADD CONSTRAINT   PK_INVENTARIO 
	PRIMARY KEY (  ID_PRODUCTO ) 
 USING INDEX
;

ALTER TABLE    Inventario  
 ADD CONSTRAINT   CK_EXISTENCIAS  CHECK (EXISTENCIAS > 0)
;

ALTER TABLE    Inventario  
 ADD CONSTRAINT   CK_PRODUCTO  CHECK (ID_PRODUCTO > 0)
;

ALTER TABLE    Inventario  
 ADD CONSTRAINT   CK_CIUDAD  CHECK (ID_CIUDAD > 0)
;

ALTER TABLE    Inventario  
 ADD CONSTRAINT   CK_PROVEEDOR  CHECK (ID_PROVEEDOR)
;

ALTER TABLE    Pedido  
 ADD CONSTRAINT   PK_PEDIDO 
	PRIMARY KEY (  ID_PEDIDO ) 
 USING INDEX
;

ALTER TABLE    Pedido  
 ADD CONSTRAINT   CK_TOTAL_PEDIDO  CHECK (TOTAL_PEDIDO > 0)
;

ALTER TABLE    Pedido  
 ADD CONSTRAINT   CK_PEDIDO  CHECK (ID_PEDIDO > 0)
;

ALTER TABLE    Pedido  
 ADD CONSTRAINT   CK_CEDULA  CHECK (ID_CEDULA > 0)
;

ALTER TABLE    Pedido  
 ADD CONSTRAINT   CK_CIUDAD  CHECK (ID_CIUDAD > 0)
;

ALTER TABLE    Producto  
 ADD CONSTRAINT   PK_PRODUCTO 
	PRIMARY KEY (  ID_PRODUCTO ) 
 USING INDEX
;

ALTER TABLE    Producto  
 ADD CONSTRAINT   CK_PRECIO_BASE  CHECK (PRECIO_BASE >= 0)
;

ALTER TABLE    Producto  
 ADD CONSTRAINT   CK_PRODUCTO  CHECK (ID_PRODUCTO > 0)
;

ALTER TABLE    Producto  
 ADD CONSTRAINT   CK_SUBCATEGORIA  CHECK (ID_SUBCATEGORIA > 0)
;

ALTER TABLE    Proveedor  
 ADD CONSTRAINT   PK_PROVEEDOR 
	PRIMARY KEY (  ID_PROVEEDOR ) 
 USING INDEX
;

ALTER TABLE    Proveedor  
 ADD CONSTRAINT   CK_PROVEEDOR  CHECK (ID_PROVEEDOR > 0)
;

ALTER TABLE    Subcategoria  
 ADD CONSTRAINT   PK_SUBCATEGORIA 
	PRIMARY KEY (  ID_SUBCATEGORIA ) 
 USING INDEX
;

ALTER TABLE    Subcategoria  
 ADD CONSTRAINT   CK_CATEGORIA  CHECK (ID_CATEGORIA > 0)
;

ALTER TABLE    Subcategoria  
 ADD CONSTRAINT   CK_SUBCATEGORIA  CHECK (ID_SUBCATEGORIA > 0)
;

ALTER TABLE    Sucursal  
 ADD CONSTRAINT   PK_SUCURSAL 
	PRIMARY KEY (  ID_SUCURSAL ) 
 USING INDEX
;

ALTER TABLE    TarjetaCredito  
 ADD CONSTRAINT   PK_METODO_PAGO 
	PRIMARY KEY (  ID_TARJETA ) 
 USING INDEX
;

ALTER TABLE    TarjetaCredito  
 ADD CONSTRAINT   CK_NUMERO_TARJETA  CHECK (NUMERO_TARJETA > 0)
;

ALTER TABLE    TarjetaCredito  
 ADD CONSTRAINT   CK_CSV  CHECK (CSV > 0)
;

ALTER TABLE    TarjetaCredito  
 ADD CONSTRAINT   CK_TARJETA  CHECK (ID_TARJETA > 0)
;

ALTER TABLE    TarjetaCredito  
 ADD CONSTRAINT   CK_CEDULA  CHECK (ID_CEDULA > 0)
;

ALTER TABLE    Telefono  
 ADD CONSTRAINT   PK_TELEFONO 
	PRIMARY KEY (  ID_TELEFONO ) 
 USING INDEX
;

ALTER TABLE    Telefono  
 ADD CONSTRAINT   CK_NUMERO_TELEFONO  CHECK (NUMERO_TELEFONO > 0)
;

ALTER TABLE    Telefono  
 ADD CONSTRAINT   CK_EN_USO  CHECK (EN_USO IN ('S','N'))
;

ALTER TABLE    Telefono  
 ADD CONSTRAINT   CK_TELEFONO  CHECK (ID_TELEFONO > 0)
;

ALTER TABLE    Telefono  
 ADD CONSTRAINT   CK_CEDULA  CHECK (ID_CEDULA > 0)
;

ALTER TABLE    Tienda  
 ADD CONSTRAINT   PK_TIENDA 
	PRIMARY KEY (  ID_TIENDA ) 
 USING INDEX
;

ALTER TABLE    Tienda  
 ADD CONSTRAINT   CK_TIEMPO_VIDA_CARRITO  CHECK (TIEMPO_VIDA_CARRITO > 0)
;

ALTER TABLE    Tienda  
 ADD CONSTRAINT   CK_MIN_CANTIDAD_PRODUCTOS  CHECK (MIN_CANTIDAD_PRODUCTOS > 0)
;

ALTER TABLE    Tienda  
 ADD CONSTRAINT   CK_COSTO_ENV_LOC  CHECK (COSTO_ENV_LOC >= 0)
;

ALTER TABLE    Tienda  
 ADD CONSTRAINT   CK_COSTO_ENV_NAC  CHECK (COSTO_ENV_NAC >= 0)
;

ALTER TABLE    Tienda  
 ADD CONSTRAINT   CK_TIENDA  CHECK (ID_TIENDA > 0)
;

ALTER TABLE    Tienda  
 ADD CONSTRAINT   CK_ADMINISTRADOR  CHECK (ID_ADMINISTRADOR > 0)
;

ALTER TABLE    Usuario  
 ADD CONSTRAINT   PK_CLIENTE 
	PRIMARY KEY (  ID_CEDULA ) 
 USING INDEX
;

ALTER TABLE    Usuario  
 ADD CONSTRAINT   CK_CEDULA  CHECK (ID_CEDULA > 0)
;

ALTER TABLE    Usuario  
 ADD CONSTRAINT   CK_GENERO  CHECK (GENERO IN ('F','M','O'))
;

ALTER TABLE    Usuario  
 ADD CONSTRAINT   CK_TIPO_ID  CHECK (TIPO_ID IN ('CC','CE'))
;

/* Create Foreign Key Constraints */

ALTER TABLE    Ciudad  
 ADD CONSTRAINT   FK_CIUDAD_TIENDA 
	FOREIGN KEY (  ID_TIENDA ) REFERENCES    Tienda  (  ID_TIENDA )
;

ALTER TABLE    Detalle_Pedido  
 ADD CONSTRAINT   FK_PEDIDO_PRODUCTO_PEDIDO 
	FOREIGN KEY (  ID_PEDIDO ) REFERENCES    Pedido  (  ID_PEDIDO )
;

ALTER TABLE    Detalle_Pedido  
 ADD CONSTRAINT   FK_PEDIDO_PRODUCTO_PRODUCTO 
	FOREIGN KEY (  ID_PRODUCTO ) REFERENCES    Producto  (  ID_PRODUCTO )
;

ALTER TABLE    Direccion  
 ADD CONSTRAINT   FK_DIRECCION_CIUDAD 
	FOREIGN KEY (  ID_CIUDAD ) REFERENCES    Ciudad  (  ID_CIUDAD )
;

ALTER TABLE    Direccion  
 ADD CONSTRAINT   FK_DIRECCION_USUARIO 
	FOREIGN KEY (  ID_CEDULA ) REFERENCES    Usuario  (  ID_CEDULA )
;

ALTER TABLE    Envio  
 ADD CONSTRAINT   FK_ENVIO_PEDIDO 
	FOREIGN KEY (  ID_PEDIDO ) REFERENCES    Pedido  (  ID_PEDIDO )
;

ALTER TABLE    Forma_Pago  
 ADD CONSTRAINT   FK_FACTURA_PEDIDO 
	FOREIGN KEY (  ID_FACTURA ) REFERENCES    Pedido  (  ID_PEDIDO )
;

ALTER TABLE    Inventario  
 ADD CONSTRAINT   FK_INVENTARIO_CIUDAD 
	FOREIGN KEY (  ID_CIUDAD ) REFERENCES    Ciudad  (  ID_CIUDAD )
;

ALTER TABLE    Inventario  
 ADD CONSTRAINT   FK_INVENTARIO_PRODUCTO 
	FOREIGN KEY (  ID_PRODUCTO ) REFERENCES    Producto  (  ID_PRODUCTO )
;

ALTER TABLE    Inventario  
 ADD CONSTRAINT   FK_INVENTARIO_PROVEEDOR 
	FOREIGN KEY (  ID_PROVEEDOR ) REFERENCES    Proveedor  (  ID_PROVEEDOR )
;

ALTER TABLE    Pedido  
 ADD CONSTRAINT   FK_PEDIDO_CIUDAD 
	FOREIGN KEY (  ID_CIUDAD ) REFERENCES    Ciudad  (  ID_CIUDAD )
;

ALTER TABLE    Pedido  
 ADD CONSTRAINT   FK_PEDIDO_USUARIO 
	FOREIGN KEY (  ID_CEDULA ) REFERENCES    Usuario  (  ID_CEDULA )
;

ALTER TABLE    Producto  
 ADD CONSTRAINT   FK_PRODUCTO_SUBCATEGORIA 
	FOREIGN KEY (  ID_SUBCATEGORIA ) REFERENCES    Subcategoria  (  ID_SUBCATEGORIA )
;

ALTER TABLE    Subcategoria  
 ADD CONSTRAINT   FK_SUBCATEGORIA_CATEGORIA 
	FOREIGN KEY (  ID_CATEGORIA ) REFERENCES    Categoria  (  ID_CATEGORIA )
;

ALTER TABLE    Sucursal  
 ADD CONSTRAINT   FK_SUCURSAL_CIUDAD 
	FOREIGN KEY (  ID_CIUDAD ) REFERENCES    Ciudad  (  ID_CIUDAD )
;

ALTER TABLE    Sucursal  
 ADD CONSTRAINT   FK_SUCURSAL_TIENDA 
	FOREIGN KEY (  ID_TIENDA ) REFERENCES    Tienda  (  ID_TIENDA )
;

ALTER TABLE    TarjetaCredito  
 ADD CONSTRAINT   FK_TARJETACREDITO_USUARIO 
	FOREIGN KEY (  ID_CEDULA ) REFERENCES    Usuario  (  ID_CEDULA )
;

ALTER TABLE    Telefono  
 ADD CONSTRAINT   FK_TELEFONO_USUARIO 
	FOREIGN KEY (  ID_CEDULA ) REFERENCES    Usuario  (  ID_CEDULA )
;

ALTER TABLE    Tienda  
 ADD CONSTRAINT   FK_TIENDA_ADMINISTRADOR 
	FOREIGN KEY (  ID_ADMINISTRADOR ) REFERENCES    Administrador  (  ID_ADMINISTRADOR )
;
