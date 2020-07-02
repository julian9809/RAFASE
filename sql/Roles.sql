alter session set "_ORACLE_SCRIPT"=true;

--ASIGNACION DE TABLESPACES

create tablespace RAFASE_sistema datafile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_sistema.dbf' size 2M autoextend on;

create temporary tablespace RAFASE_sistemaTemp tempfile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_sistemaTemp.dbf' size 2M autoextend on;

create tablespace RAFASE_administrador datafile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_administrador.dbf' size 2M autoextend on;

create temporary tablespace RAFASE_administradorTemp tempfile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_administradorTemp.dbf' size 2M autoextend on;

create tablespace RAFASE_adminRafase datafile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_adminRafase.dbf' size 2M autoextend on;

create temporary tablespace RAFASE_adminRafaseTemp tempfile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_adminRafaseTemp.dbf' size 2M autoextend on;

create tablespace RAFASE_usuarioGeneral datafile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_usuarioGeneral.dbf' size 2M autoextend on;

create temporary tablespace RAFASE_usuarioGeneralTemp tempfile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_usuarioGeneralTemp.dbf' size 2M autoextend on;

create tablespace RAFASE_Cliente datafile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_Cliente.dbf' size 2M autoextend on;

create temporary tablespace RAFASE_ClienteTemp tempfile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_ClienteTemp.dbf' size 2M autoextend on;

--CREAR USUARIO admin_db LINEA 59

--ROLES

create role sistema; 
grant create session, create user to sistema;
grant insert any table, update any table to sistema;
grant grant any role to sistema;


create role administradorBD;
grant dba to administradorBD with admin option;


create role adminRAFASE;
grant create session to adminRAFASE;
grant select any table to adminRAFASE;
grant insert, update on admin_db.proveedor to adminRAFASE;
grant update on admin_db.inventario to adminRAFASE;
grant update on admin_db.tienda to adminRAFASE; 

create role usuarioGeneral;
grant create session to usuarioGeneral;
grant  select any table to usuarioGeneral;

create role cliente identified by password;
grant create session to cliente;
grant  select any table to cliente;
grant insert on admin_db.usuario to cliente;
grant insert on admin_db.telefono to cliente; 
grant insert on admin_db.direccion to cliente; 
grant insert on admin_db.tarjetacredito to cliente;

--USUARIOS 
create user admin_db identified by dbadministrator;
grant administradorBD to admin_db;
alter user admin_db
default tablespace RAFASE_sistema
temporary tablespace RAFASE_sistemaTemp
quota unlimited ON RAFASE_sistema;


create user RAFASEadmin identified by contrasena;
grant ADMINRAFASE to RAFASEadmin;
alter user RAFASEadmin 
default tablespace RAFASE_adminRafase
temporary tablespace RAFASE_adminRafaseTemp;

create user visitante identified by abc123;
grant usuarioGeneral to visitante;


--create view [CarritoCliente] AS
--SELECT admin_db.Producto.nombre, admin_db.Pedido_Producto.cantidad 
--FROM admin_db.Producto, admin_db.Pedido_Producto, admin_db.Pedido, admin_db.Usuario
--WHERE admin_db.Producto.id_producto = admin_db.Pedido_Producto.FK_pedido_producto_producto AND admin_db.Pedido_producto.fk_pedido = admin_db.Pedido.id_pedido;


