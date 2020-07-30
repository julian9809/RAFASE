INSERT INTO ADMON(ID_ADMINISTRADOR, NOMBRE_ADMINISTRADOR, EMAIL, CONTRASENA) VALUES (1, 'RAFASEadmin', 'admin@rafase.com','contrasena');

INSERT INTO TIEN(ID_TIENDA, COSTO_ENV_LOC, COSTO_ENV_NAC, TIEMPO_VIDA_CARRITO, MIN_CANTIDAD_PRODUCTOS, ID_ADMINISTRADOR) VALUES (1, 5000, 8000, 7, 20,1);

INSERT INTO CIU(ID_CIUDAD, NOMBRE, ID_TIENDA) VALUES (1,'Bogotá',1);
INSERT INTO CIU(ID_CIUDAD, NOMBRE, ID_TIENDA) VALUES (2,'Medellin',1);
INSERT INTO CIU(ID_CIUDAD, NOMBRE, ID_TIENDA) VALUES (3,'Cali',1);
INSERT INTO CIU(ID_CIUDAD, NOMBRE, ID_TIENDA) VALUES (4,'Cartagena',1);

--musica
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10101, 'CODISCOS S.A.S', 'Medellín - Colombia');
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10102, 'SONY MUSIC', 'Nueva York‎ - Estados Unidos');
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10103, 'Aftermath Entertainment', 'California - Estados Unidos');
--libros
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10201, 'PANAMERICANA LIBRERÍA Y PAPELERÍA S.A.', 'Calle 12 # 34 -30, Bogotá D.C.');
--juegos
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10301, 'Rockstar Games', 'Nueva York‎ - Estados Unidos');
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10302, 'Microsoft Game Studios', 'Washington - Estados Unidos');
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10303, 'Hasbro', 'Rhode Island - Estados Unidos');
--electrodomesticos
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10401, 'Electroferia - Carrera 13', 'Carrera 13 No. 15 – 37');
--muebles y lenceria
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10501, 'Fiotti', 'Bogotá - Colombia');
--frutas - verduras
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10601, 'Corabastos', 'Av. Carrera 80 No 2 - 51');
--lácteos - carnes
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10701, 'Macpollo', 'Bogotá - Colombia');
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10702, 'Alqueria', 'Bogotá - Colombia');
--granos - variedad
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10801, 'Grupo Diana', 'Ibague - Colombia');
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10802, 'Casa Luker', ' Calle 13 Nº 68-98 Zona Industrial');
--mascotas
INSERT INTO PROVE(ID_PROVEEDOR, NOMBRE_PROVEEDOR, DIRECCION_PROVEEDOR) VALUES (10901, 'Productos para mascotas', 'Bogotá - Colombia');

INSERT INTO CATEG(ID_CATEGORIA, NOMBRE_CATEGORIA, DESCRIPCION_CATEGORIA) VALUES (1, 'Entretenimiento', 'Música, libros y juegos');
INSERT INTO CATEG(ID_CATEGORIA, NOMBRE_CATEGORIA, DESCRIPCION_CATEGORIA) VALUES (2, 'Hogar', 'Electrodomésticos, muebles y lencería');
INSERT INTO CATEG(ID_CATEGORIA, NOMBRE_CATEGORIA, DESCRIPCION_CATEGORIA) VALUES (3, 'Mercado', 'Productos para el hogar');

INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (1, 'Música', 1);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (2, 'Libros', 1);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (3, 'Juegos', 1);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (4, 'Electrodomésticos', 2);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (5, 'Muebles y Lencería', 2);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (6, 'Frutas - verduras', 3);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (7, 'Lácteos - carnes', 3);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (8, 'Granos - variedad', 3);
INSERT INTO SUBCAT(ID_SUBCATEGORIA, NOMBRE_SUBCATEGORIA, ID_CATEGORIA) VALUES (9, 'Mascotas', 3);

--id,nombre,marca,referencia,caracteristicas,foto,subcategoria,unidad,iva

--musica
INSERT INTO PROD VALUES (101001, 'Music to Be Murdered By - Eminem', 'Aftermath Entertainment', '101001', 'Hip hop, hardcore hip hop, rap', 'principal.jpg', 1, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (101001,10103,4,100,22900);
INSERT INTO PROD VALUES (101002, 'Seguimos por lo alto - Binomio de oro', 'Codiscos', '101002', 'Vallenato', 'principal.jpg', 1, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (101002,10101,3,100,22900);
INSERT INTO PROD VALUES (101003, 'Trece - Andrés Cepeda', 'Sony Music', '101003', 'Pop, urbano, tropipop, mariachi, country, rock', 'principal.jpg', 1, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (101003,10102,1,100,22900);
--libros
INSERT INTO PROD VALUES (102001, 'El olvido que seremos - Héctor Abad Faciolince', 'Alfaguara','102001','Biografía novelada','principal.jpg', 2, 'Unidad', 0);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (102001,10201,1,20,5200);
INSERT INTO PROD VALUES (102002, 'La melancolía de los feos - Mario Mendoza', 'Planeta', '102002', 'Ficción', 'principal.jpg', 2, 'Unidad', 0);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (102002,10201,2,15,39900);
INSERT INTO PROD VALUES (102003, 'El país de la canela - William Ospina', 'Literatura Mondadori', '102003', 'Ficción histórica', 'principal.jpg', 2, 'Unidad', 0);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (102003,10201,3,15,59000);
--juegos
INSERT INTO PROD VALUES (103001, 'Grand Theft Auto V', 'Rockstar North', '103001', 'Un jugador y Multijugador (en línea)', 'principal.jpg', 3, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (103001,10301,1,24,159034);
INSERT INTO PROD VALUES (103002, 'Halo Reach', 'Bungie Studios', '103002', 'Videojuego de un jugador, Videojuego multijugador', 'principal.jpg', 3, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (103002,10302,3,32,59900);
INSERT INTO PROD VALUES (103003, 'Monopoly', 'Parker Brothers, Hasbro', '103003', 'Negociación', 'principal.jpg', 3, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (103003,10303,2,15,116900);
--electrodomesticos
INSERT INTO PROD VALUES (104001, 'Nevera SAMSUNG RT29K571JS8 Gris', 'SAMSUNG', '104001', 'No Frost Congelador Superior 308 Litros Brutos', 'principal.jpg', 4, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (104001,10401,1,30,1539900);
INSERT INTO PROD VALUES (104002, 'Lavadora Whirlpool 7MWFW5622HW', 'Whirlpool', '104002', 'Carga frontal Sistema LoadyGo 18Kgs', 'principal.jpg', 4, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (104002,10401,2,25,3460000);
INSERT INTO PROD VALUES (104003, 'Televisor Challenger LED32L85', 'Challenger', '104003', '32 Pulgadas', 'principal.jpg', 4, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (104003,10401,3,15,459000);
--muebles y lenceria
INSERT INTO PROD VALUES (105001, 'COMEDOR WALERAN CRIS', 'WALERAN', '105001', '4 Puestos Negro', 'principal.jpg', 5, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (105001,10501,1,32,429900);
INSERT INTO PROD VALUES (105002, 'SALA EN L PETIT', 'PETIT', '105002', 'Derecha 2C', 'principal.jpg', 5, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (105002,10501,1,58,828900);
INSERT INTO PROD VALUES (105003, 'BASE CAMA', 'cafémoka', '105003', 'TAPIZADA DOBLE', 'principal.jpg', 5, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (105003,10501,4,46,340900);
INSERT INTO PROD VALUES (105004, 'COMFORTER HOJARASCA', 'HOJARASCA', '105004', 'DOBLE ESTAMPADA CH', 'principal.jpg', 5, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (105004,10501,3,54,207341);
INSERT INTO PROD VALUES (105005, 'COMFORTER TUCAN', 'TUCAN', '105005', 'DOBLE ESTAMPADO BL', 'principal.jpg', 5, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (105005,10501,4,65,207341);
INSERT INTO PROD VALUES (105006, 'COJIN BORDADO', 'Generico', '105006', 'AZ 45*45CM', 'principal.jpg', 5, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (105006,10501,1,41,38280);
--frutas - verduras
INSERT INTO PROD VALUES (106001, 'Patilla', 'abastos', '106001', 'frutas de excelente calidad', 'principal.jpg', 6, 'Kilo', 0);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (106001,10601,1,50,750);
INSERT INTO PROD VALUES (106002, 'Curuba Bernardo', 'abastos', '106002', 'frutas de excelente calidad', 'principal.jpg', 6, 'Kilo', 0);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (106002,10601,2,60,1400);
INSERT INTO PROD VALUES (106003, 'Ahuyama', 'abastos', '106003', 'Verduras de excelente calidad', 'principal.jpg', 6, 'Kilo', 0);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (106003,10601,2,45,700);
--Lacteos - carnes
INSERT INTO PROD VALUES (107001, 'Pierna pernil', 'Macpollo', '107001', 'Pollo de excelente calidad', 'principal.jpg', 7, 'Kilo', 0);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (107001,10701,4,45,9150);
INSERT INTO PROD VALUES (107002, 'Pierna', 'Macpollo', '107002', 'Pollo de excelente calidad', 'principal.jpg', 7, 'Kilo', 0);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (107002,10701,3,24,10800);
INSERT INTO PROD VALUES (107003, 'Leche Alqueria', 'Alqueria', '107003', 'Leche de excelente calidad', 'principal.jpg', 7, 'Sixpack', 0);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (107003,10702,2,32,19950);
--Granos - Variedad
INSERT INTO PROD VALUES (108001, 'Arroz', 'Diana', '108001', 'Arroz de excelente calidad', 'principal.jpg', 8, 'Kilo', 0);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (108001,10801,1,24,3520);
INSERT INTO PROD VALUES (108002, 'Lentejas', 'Diana', '108002', 'Lentejas de excelente calidad', 'principal.jpg', 8, 'Libra', 0);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (108002,10801,3,32,2590);
INSERT INTO PROD VALUES (108003, 'Chocolate Corona', 'Casa luker', '108003', 'Chocolate de excelente calidad', 'principal.jpg', 8, 'Libra', 0.05);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (108003,10802,2,98,5990);
--Mascotas
INSERT INTO PROD VALUES (109001, 'Dougurmet', 'Purina', '109001', 'Purina de excelente calidad', 'principal.jpg', 9, 'Libra', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (109001,10901,1,25,2500);
INSERT INTO PROD VALUES (109002, 'Shampoo canino', 'Perros limpios', '109002', 'Deja limpio a tu amigo peludo', 'principal.jpg', 9, 'Litro', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (109002,10901,3,15,10900);
INSERT INTO PROD VALUES (109003, 'Jabón Asunto', 'Bayer', '109003', 'Anti-Pulgas', 'principal.jpg', 9, 'Unidad', 0.19);
INSERT INTO INV(ID_PRODUCTO,ID_PROVEEDOR,ID_CIUDAD,EXISTENCIAS,PRECIO_BASE) VALUES (109003,10901,1,87,6990);

