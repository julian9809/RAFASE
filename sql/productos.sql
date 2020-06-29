INSERT INTO Ciudad(ID_CIUDAD, NOMBRE) VALUES (1,'Bogota');
INSERT INTO Ciudad(ID_CIUDAD, NOMBRE) VALUES (2,'Medellin');
INSERT INTO Ciudad(ID_CIUDAD, NOMBRE) VALUES (3,'Cali');
INSERT INTO Ciudad(ID_CIUDAD, NOMBRE) VALUES (4,'Cartagena');

INSERT INTO Administrador(ID_ADMINISTRADOR, NOMBRE_ADMINISTRADOR, EMAIL, CONTRASENA) VALUES (1, 'RAFASEadmin', 'admin@rafase.com','contrasena');

INSERT INTO Tienda(ID_TIENDA, COSTO_ENV_LOC, COSTO_ENV_NAC, TIEMPO_VIDA_CARRITO, MIN_CANTIDAD_PRODUCTOS, ID_ADMINISTRADOR) VALUES (1, 1, 60, 7, 20,1);

INSERT INTO Sucursal(ID_SUCURSAL,ID_CIUDAD,ID_TIENDA) VALUES (1,1,1);
INSERT INTO Sucursal(ID_SUCURSAL,ID_CIUDAD,ID_TIENDA) VALUES (2,2,1);
INSERT INTO Sucursal(ID_SUCURSAL,ID_CIUDAD,ID_TIENDA) VALUES (3,3,1);
INSERT INTO Sucursal(ID_SUCURSAL,ID_CIUDAD,ID_TIENDA) VALUES (4,4,1);

INSERT INTO Proveedor(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR, ID_SUCURSAL) VALUES (1, 'Proveedor arroz', 'Calle 1 # 1-1',1);
INSERT INTO Proveedor(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR, ID_SUCURSAL) VALUES (2, 'Proveedor libros', 'Calle 2 # 1-1',1);
INSERT INTO Proveedor(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR, ID_SUCURSAL) VALUES (3, 'Proveedor musica', 'Calle 3 # 1-1',2);
INSERT INTO Proveedor(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR, ID_SUCURSAL) VALUES (4, 'Proveedor arroz', 'Calle 4 # 1-1',2);
INSERT INTO Proveedor(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR, ID_SUCURSAL) VALUES (5, 'Proveedor libros', 'Carrera 1 # 1-1',3);
INSERT INTO Proveedor(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR, ID_SUCURSAL) VALUES (6, 'Proveedor dulces', 'Carrera 2 # 1-1',3);
INSERT INTO Proveedor(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR, ID_SUCURSAL) VALUES (7, 'Proveedor tecnologia', 'Carrera 3 # 1-1',4);
INSERT INTO Proveedor(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR, ID_SUCURSAL) VALUES (8, 'Proveedor arroz', 'Carrera 4 # 1-1',4);

INSERT INTO Categoria(ID_CATEGORIA, NOMBRE_CATEGORIA, IVA, DESCRIPCION_CATEGORIA) VALUES (1, 'Entretenimiento', 0, 'Libros, música y peliculas');
INSERT INTO Categoria(ID_CATEGORIA, NOMBRE_CATEGORIA, IVA, DESCRIPCION_CATEGORIA) VALUES (2, 'Hogar', 0.19, 'Electrodomestidos y muebles');
INSERT INTO Categoria(ID_CATEGORIA, NOMBRE_CATEGORIA, IVA, DESCRIPCION_CATEGORIA) VALUES (3, 'Mercado', 0.8, 'Canasta básica');

INSERT INTO Subcategoria(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (1, 'Libros', 1);
INSERT INTO Subcategoria(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (2, 'Musica', 1);
INSERT INTO Subcategoria(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (3, 'Peliculas', 1);
INSERT INTO Subcategoria(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (4, 'Cocina', 2);
INSERT INTO Subcategoria(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (5, 'Entretenimiento', 2);
INSERT INTO Subcategoria(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (6, 'Decoracion', 2);
INSERT INTO Subcategoria(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (7, 'Carnes', 3);
INSERT INTO Subcategoria(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (8, 'Granos', 3);
INSERT INTO Subcategoria(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (9, 'Dulces', 3);

INSERT INTO Producto(ID_PRODUCTO, NOMBRE_PRODUCTO, MARCA_PRODUCTO, REFERENCIA_PRODUCTO, CARACTERISTICAS_PRODUCTO, FOTO, PRECIO_BASE, UNIDAD_MEDIDA,ID_SUBCATEGORIA) VALUES (1, 'El olvido que seremos', 'Alfaguara','7015283947','Biografía novelada','el_olvido_seremos_todos.jpg', 52000, 'Unidad', 1);
INSERT INTO Producto(ID_PRODUCTO, NOMBRE_PRODUCTO, MARCA_PRODUCTO, REFERENCIA_PRODUCTO, CARACTERISTICAS_PRODUCTO, FOTO, PRECIO_BASE, UNIDAD_MEDIDA,ID_SUBCATEGORIA) VALUES (2, 'El muñeco que cae', 'Arcoiris','70152783947','Cuento','el_muñeco_que_cae.jpg', 53000, 'Unidad', 1);



INSERT INTO Producto VALUES ( 99,'gomitas rellenas','italo','g001','gomitas rellenas de jalea dulce','img.jpg',1500,'libra',9);
INSERT INTO Producto VALUES ( 98,'choco balons','nacional de chocolates','choco002','mini balones de chocolate','img.jpg',2500,'libra',9);
INSERT INTO Producto VALUES ( 89,'fríjoles','del campo','fri003','fríjoles rojos mexicanos','img.jpg',2500,'kilo',8);
INSERT INTO Producto VALUES ( 88,'lentejas','del campo','len004','lentejas nacionales','img.jpg',2200,'kilo',8);
INSERT INTO Producto VALUES ( 79,'colombinas','districarnes','col005','colombinas de pollo','img.jpg',3500,'kilo',7);
INSERT INTO Producto VALUES ( 78,'chunchullo','districarnes','chu006','tripas de res','img.jpg',5200,'kilo',7);
INSERT INTO Producto VALUES ( 69,'paisaje','decorex','dec007','cuadro de pared','img.jpg',355500,'unidad',6);
INSERT INTO Producto VALUES ( 68,'modelos','decorex','mod008','cuadro de pared','img.jpg',999999.99,'unidad',6);
INSERT INTO Producto VALUES ( 59,'monopolio','hasbro','mono009','juego de mesa para toda la familiar','img.jpg',12500,'unidad',5);
INSERT INTO Producto VALUES ( 58,'corazones','punto rosa','cor010','juego virtual para adultos','img.jpg',22200,'unidad',5);
INSERT INTO Producto VALUES ( 49,'molinillo','tu cocina','moli011','milinillo para chocolate','img.jpg',1999.99,'unidad',4);
INSERT INTO Producto VALUES ( 48,'olleta','tu cocina','oll012','olleta para chocolate','img.jpg',7200,'unidad',4);
INSERT INTO Producto VALUES ( 39,'batman','dc comics','accion - ficcion','batman primera entrega','img.jpg',32500,'unidad',3);
INSERT INTO Producto VALUES ( 38,'spiderman','marvel comics','accion - ficcion','spiderman segunda entrega','img.jpg',32200,'unidado',3);
INSERT INTO Producto VALUES ( 29,'Jazz','sony music','viejitos','grandes exitos del Jazz','img.jpg',32000,'unidad',2);
INSERT INTO Producto VALUES ( 28,'Blues','sony music','viejitos','grandes exitos del Blues','img.jpg',32000,'unidad',2);
INSERT INTO Producto VALUES ( 9780563528883,'El señor de los anillos','George Allen And Unwin','la comunidad del anillo','el señor de los anillos primera entrega','img.jpg',92500,'unidad',1);
INSERT INTO Producto VALUES ( 9781481510714,'El señor de los anillos','George Allen And Unwin','el retorno del rey','el señor de los anillos tercera entrega','img.jpg',92500,'unidad',1);
INSERT INTO Producto VALUES ( 9780898452235,'El señor de los anillos','George Allen And Unwin','las dos torres','el señor de los anillos segunda entrega','img.jpg',92500,'unidad',1);
