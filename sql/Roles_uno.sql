alter session set "_ORACLE_SCRIPT"=true;

--ASIGNACION DE TABLESPACES

create tablespace RAFASE_administrador datafile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_administrador.dbf' size 2M autoextend on;

create temporary tablespace RAFASE_administradorTemp tempfile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_administradorTemp.dbf' size 2M autoextend on;

create tablespace RAFASE_usuarios datafile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_usuarios.dbf' size 2M autoextend on;

create temporary tablespace RAFASE_usuariosTemp tempfile 'C:\oraclexe\app\oracle\oradata\XE\RAFASE_usuariosTemp.dbf' size 2M autoextend on;

--ROLES

create role administradorBD;
grant create session to administradorBD with admin option;
grant create any table to administradorBD;
grant create any view to administradorBD;
grant create role to administradorBD;
grant create user to administradorBD;
grant create public synonym to admin_db;

create user admin_db identified by dbadministrator;
grant administradorBD to admin_db;
alter user admin_db
default tablespace RAFASE_administrador
temporary tablespace RAFASE_administradorTemp
quota unlimited ON RAFASE_administrador;

--Correr aca el ScripProyecto.sql con el usuario admin_db