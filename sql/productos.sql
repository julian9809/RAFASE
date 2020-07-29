INSERT INTO ADMON(ID_ADMINISTRADOR, NOMBRE_ADMINISTRADOR, EMAIL, CONTRASENA) VALUES (1, 'RAFASEadmin', 'admin@rafase.com','contrasena');

INSERT INTO TIEN(ID_TIENDA, COSTO_ENV_LOC, COSTO_ENV_NAC, TIEMPO_VIDA_CARRITO, MIN_CANTIDAD_PRODUCTOS, ID_ADMINISTRADOR) VALUES (1, 5000, 8000, 7, 20,1);

INSERT INTO CIU(ID_CIUDAD, NOMBRE, ID_TIENDA) VALUES (1,'Bogotá',1);
INSERT INTO CIU(ID_CIUDAD, NOMBRE, ID_TIENDA) VALUES (2,'Medellin',1);
INSERT INTO CIU(ID_CIUDAD, NOMBRE, ID_TIENDA) VALUES (3,'Cali',1);
INSERT INTO CIU(ID_CIUDAD, NOMBRE, ID_TIENDA) VALUES (4,'Cartagena',1);

INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (1, 'Proveedor arroz', 'Calle 1 # 1-1');
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (2, 'Proveedor libros', 'Calle 2 # 1-1');
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (3, 'Proveedor musica', 'Calle 3 # 1-1');
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (4, 'Proveedor arroz', 'Calle 4 # 1-1');
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (5, 'Proveedor libros', 'Carrera 1 # 1-1');
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (6, 'Proveedor dulces', 'Carrera 2 # 1-1');
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (7, 'Proveedor tecnologia', 'Carrera 3 # 1-1');
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (8, 'Proveedor arroz', 'Carrera 4 # 1-1');

INSERT INTO CATEG(ID_CATEGORIA, NOMBRE_CATEGORIA, DESCRIPCION_CATEGORIA) VALUES (1, 'Entretenimiento', 'Libros, música y peliculas');
INSERT INTO CATEG(ID_CATEGORIA, NOMBRE_CATEGORIA, DESCRIPCION_CATEGORIA) VALUES (2, 'Hogar', 'Electrodomestidos y muebles');
INSERT INTO CATEG(ID_CATEGORIA, NOMBRE_CATEGORIA, DESCRIPCION_CATEGORIA) VALUES (3, 'Mercado', 'Canasta básica');

INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (1, 'Libros', 1);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (2, 'Musica', 1);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (3, 'Peliculas', 1);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (4, 'Cocina', 2);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (5, 'Entretenimiento', 2);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (6, 'Decoracion', 2);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (7, 'Carnes', 3);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (8, 'Granos', 3);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (9, 'Dulces', 3);

INSERT INTO PROD VALUES (1, 'El olvido que seremos', 'Alfaguara','7015283947','Biografía novelada','el_olvido_seremos_todos.jpg', 1, 'Unidad', 0);
INSERT INTO PROD VALUES (2, 'El muñeco que cae', 'Arcoiris','70152783947','Cuento','el_muñeco_que_cae.jpg', 1, 'Unidad', 0);
INSERT INTO PROD VALUES ( 99,'gomitas rellenas','italo','g001','gomitas rellenas de jalea dulce','gomitas_rellenas.png',1500,'libra',9);
INSERT INTO PROD VALUES ( 98,'choco balons','nacional de chocolates','choco002','mini balones de chocolate','chocobolas.png',2500,'libra',9);
INSERT INTO PROD VALUES ( 89,'fríjoles','del campo','fri003','fríjoles rojos mexicanos','frijol.png',2500,'kilo',8);
INSERT INTO PROD VALUES ( 88,'lentejas','del campo','len004','lentejas nacionales','lentejas.png',2200,'kilo',8);
INSERT INTO PROD VALUES ( 79,'colombinas','districarnes','col005','colombinas de pollo','colombinas.png',3500,'kilo',7);
INSERT INTO PROD VALUES ( 78,'chunchullo','districarnes','chu006','tripas de res','chunchullo.png',5200,'kilo',7);
INSERT INTO PROD VALUES ( 69,'paisaje','decorex','dec007','cuadro de pared','paisaje.png',355500,'unidad',6);
INSERT INTO PROD VALUES ( 68,'modelos','decorex','mod008','cuadro de pared','modelos.png',999999.99,'unidad',6);
INSERT INTO PROD VALUES ( 59,'monopolio','hasbro','mono009','juego de mesa para toda la familiar','monopoly.png',12500,'unidad',5);
INSERT INTO PROD VALUES ( 58,'corazones','punto rosa','cor010','juego virtual para adultos','corazones.png',22200,'unidad',5);
INSERT INTO PROD VALUES ( 49,'molinillo','tu cocina','moli011','milinillo para chocolate','molinillo.png',1999.99,'unidad',4);
INSERT INTO PROD VALUES ( 48,'olleta','tu cocina','oll012','olleta para chocolate','olleta.png',7200,'unidad',4);
INSERT INTO PROD VALUES ( 39,'batman','dc comics','accion - ficcion','batman primera entrega','batman.png',32500,'unidad',3);
INSERT INTO PROD VALUES ( 38,'spiderman','marvel comics','accion - ficcion','spiderman segunda entrega','spiderman.png',32200,'unidado',3);
INSERT INTO PROD VALUES ( 29,'Jazz','sony music','viejitos','grandes exitos del Jazz','jazz.png',32000,'unidad',2);
INSERT INTO PROD VALUES ( 28,'Blues','sony music','viejitos','grandes exitos del Blues','Blues.png',32000,'unidad',2);
INSERT INTO PROD VALUES ( 9780563528883,'El señor de los anillos','George Allen And Unwin','la comunidad del anillo','el señor de los anillos primera entrega','El_señor_de_los_anillos_1.png',92500,'unidad',1);
INSERT INTO PROD VALUES ( 9781481510714,'El señor de los anillos','George Allen And Unwin','el retorno del rey','el señor de los anillos tercera entrega','El_señor_de_los_anillos_2.png',92500,'unidad',1);
INSERT INTO PROD VALUES ( 9780898452235,'El señor de los anillos','George Allen And Unwin','las dos torres','el señor de los anillos segunda entrega','El_señor_de_los_anillos_2.png',92500,'unidad',1);

INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (1,5,1,20,35000);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (2,5,1,10,35000);