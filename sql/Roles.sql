alter session set "_ORACLE_SCRIPT"=true;

--ASIGNACION DE TABLESPACES

create tablespace RAFASE_administrador datafile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_administrador.dbf' size 2M autoextend on;

create temporary tablespace RAFASE_administradorTemp tempfile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_administradorTemp.dbf' size 2M autoextend on;

create tablespace RAFASE_usuarios datafile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_usuarios.dbf' size 2M autoextend on;

create temporary tablespace RAFASE_usuariosTemp tempfile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_usuariosTemp.dbf' size 2M autoextend on;

--ROLES

create role administradorBD;
grant create any table to administradorBD;

create user admin_db identified by dbadministrator;
grant administradorBD to admin_db;
alter user admin_db
default tablespace RAFASE_administrador
temporary tablespace RAFASE_administradorTemp
quota unlimited ON RAFASE_administrador;

--Correr aca el ScripProyecto.sql

create public synonim admon for admin_db.administrador
create public synonim cat for admin_db.categoria
create public synonim ciu for admin_db.ciudad
create public synonim depe for admin_db.detalle_pedido
create public synonim dir for admin_db.direccion
create public synonim env for admin_db.envio
create public synonim fac for admin_db.factura
create public synonim inv for admin_db.inventario
create public synonim ped for admin_db.pedido
create public synonim prod for admin_db.producto 
create public synonim prove for admin_db.proveedor
create public synonim subcat for admin_db.subcategoria
create public synonim sucur for admin_db.sucursal
create public synonim tc for admin_db.tarjetacredito
create public synonim tel for admin_db.telefono
create public synonim tien for admin_db.tienda
create public synonim usur for admin_db.usuario

create role adminRAFASE;
grant create session to adminRAFASE;
grant select on admon to adminRAFASE;
grant select on cat to adminRAFASE;
grant select on ciu to adminRAFASE;
grant select on depe to adminRAFASE;
grant select on dir to adminRAFASE;
grant select on env to adminRAFASE;
grant select on fac to adminRAFASE;
grant select on inv to adminRAFASE;
grant select on ped to adminRAFASE;
grant select on prod to adminRAFASE;
grant select on prove to adminRAFASE;
grant select on subcat to adminRAFASE;
grant select on sucur to adminRAFASE;
grant select on tc to adminRAFASE;
grant select on tel to adminRAFASE;
grant select on tien to adminRAFASE;
grant select on usur to adminRAFASE;
grant insert, update on prove to adminRAFASE;
grant update on inv to adminRAFASE;
grant update on tien to adminRAFASE; 

create role usuarioGeneral;
grant create session to usuarioGeneral;
grant select on admon to usuarioGeneral;
grant select on cat to usuarioGeneral;
grant select on ciu to usuarioGeneral;
grant select on inv to usuarioGeneral;
grant select on prod to usuarioGeneral;
grant select on subcat to usuarioGeneral;
grant select on sucur to usuarioGeneral;
grant select on usur to usuarioGeneral;
grant insert on cli to usuarioGeneral;

create role cliente identified by password;
grant create session to cliente;
grant select on prod to cliente;
grant select on cat to cliente;
grant select on ciu to cliente;
grant select on dir to cliente;
grant select on inv to cliente;
grant select on subcat to cliente;
grant select on sucur to cliente;
grant select on tc to cliente;
grant select on tel to cliente;
grant select on usur to cliente;

grant update on depe to cliente;
grant update on dir to cliente;
grant update on usur to cliente;
grant update on tel to cliente; 

grant insert on depe to cliente;
grant insert on dir to cliente;
grant insert on env to cliente; 
grant insert on fac to cliente;
grant insert on ped to cliente;
grant insert on tc to cliente;
grant insert on tel to cliente; 

--USUARIOS 

create user RAFASEadmin identified by contrasena;
grant ADMINRAFASE to RAFASEadmin;
alter user RAFASEadmin 
default tablespace RAFASE_usuarios
temporary tablespace RAFASE_usuariosTemp;

create user visitante identified by abc123;
grant usuarioGeneral to visitante;