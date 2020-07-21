-- Correr como admin_db
create public synonym admon for admin_db.administrador;
create public synonym cat for admin_db.categoria;
create public synonym ciu for admin_db.ciudad;
create public synonym depe for admin_db.detalle_pedido;
create public synonym dir for admin_db.direccion;
create public synonym env for admin_db.envio;
create public synonym inv for admin_db.inventario;
create public synonym ped for admin_db.pedido;
create public synonym prod for admin_db.producto;
create public synonym prove for admin_db.proveedor;
create public synonym subcat for admin_db.subcategoria;
create public synonym sucur for admin_db.sucursal;
create public synonym tc for admin_db.tarjetacredito;
create public synonym tel for admin_db.telefono;
create public synonym tien for admin_db.tienda;
create public synonym usur for admin_db.usuario;

create role adminRAFASE;
grant create session to adminRAFASE;
grant select on admon to adminRAFASE;
grant select on cat to adminRAFASE;
grant select on ciu to adminRAFASE;
grant select on depe to adminRAFASE;
grant select on dir to adminRAFASE;
grant select on env to adminRAFASE;
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
grant insert on ped to cliente;
grant insert on tc to cliente;
grant insert on tel to cliente; 

--USUARIOS 

create user RAFASEadmin identified by contrasena
default tablespace RAFASE_usuarios
temporary tablespace RAFASE_usuariosTemp
quota 2m on RAFASE_usuarios;
grant adminRAFASE to RAFASEadmin;

create user visitante identified by abc123;
grant usuarioGeneral to visitante;