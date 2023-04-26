USE QuickHN;
GO

INSERT INTO Isv(idisv, isv)
VALUES('isv1',0.15);
GO

INSERT INTO Colores (idcolor, nombre, valor)
VALUES ('col1', 'Negro', '#000000');
GO

INSERT INTO Departamentos (iddepartamento, nombre)
VALUES ('depto1', 'Cortés');
GO

INSERT INTO Municipios (idmunicipio, iddepartamento, nombre)
VALUES ('muni1', 'depto1', 'San Pedro Sula');
GO

INSERT INTO Colonias (idcolonia, idmunicipio, nombre)
VALUES ('col1', 'muni1', 'Altos del Trapiche');
GO

INSERT INTO Imagenes (idimagen, tamanio, ruta, descripcion)
VALUES ('img1', 1024, '/images/productos/img1.jpg', 'Imagen del producto');
GO

INSERT INTO TiposUsuario (idtipousuario, descripcion)
VALUES ('tp1','cliente');
GO

INSERT INTO TiposUsuario (idtipousuario, descripcion)
VALUES ('tp2','proveedor');
GO

INSERT INTO Usuarios (idusuario, nombreusuario, correoelectronico, contrasenia, idtipousuario, idimagen)
VALUES ('user1', 'Juan Pérez', 'juanperez@example.com', 'contraseña123', 'tp1', 'img1');
GO

INSERT INTO Usuarios (idusuario, nombreusuario, correoelectronico, contrasenia, idtipousuario, idimagen)
VALUES 
('user2', 'Usuario 2', 'usuario2@example.com', 'contrasenia2', 'tp2', 'img1'),
('user3', 'Usuario 3', 'usuario3@example.com', 'contrasenia3', 'tp1', 'img1'),
('user4', 'Usuario 4', 'usuario4@example.com', 'contrasenia4', 'tp2', 'img1');
GO

INSERT INTO EstadosProveedor (idestadoproveedor, nombreestado, descripcion)
VALUES ('estado1', 'Activo', 'El proveedor se encuentra activo y habilitado para realizar transacciones.');
GO

INSERT INTO Proveedores (idproveedor, idusuario, rtn, nombreproveedor, correoelectronico, idestadoproveedor)
VALUES ('prov1', 'user1', '12345678901234', 'Distribuidora XYZ', 'info@distribuidoraxyz.com', 'estado1');
GO

INSERT INTO Dimensiones (iddimension, alto, ancho, largo)
VALUES ('dim1', 10, 20, 30);
GO
INSERT INTO CategoriasProducto (idcategoriaproducto, nombre, descripcion, idimagen)
VALUES ('cat1', 'Electrónica', 'Productos electrónicos', 'img1');
GO

INSERT INTO CategoriasProducto (idcategoriaproducto, nombre, descripcion, idimagen)
VALUES ('cat2', 'Entretenimiento', 'Productos Entretenimiento', 'img1');
GO
INSERT INTO CategoriasProducto (idcategoriaproducto, nombre, descripcion, idimagen)
VALUES ('cat3', 'Academico', 'Productos Academicos', 'img1');
GO
INSERT INTO CategoriasProducto (idcategoriaproducto, nombre, descripcion, idimagen)
VALUES ('cat4', 'Financiero', 'Productos Financieros', 'img1');
GO

INSERT INTO Productos (idproducto, idproveedor, nombreproducto, descripcion, precio, stockdisponible, pesoproducto, modeloproducto, marcaproducto, cantdiasgarantia, idimagen, iddimension, idcolor)
VALUES ('prod1', 'prov1', 'Laptop HP', 'Laptop de la marca HP', 15000.00, 10, 2.0, 'Pavilion', 'HP', 365, 'img1', 'dim1', 'col1');
GO

INSERT INTO Productos (idproducto, idproveedor, nombreproducto, descripcion, precio, stockdisponible, pesoproducto, modeloproducto, marcaproducto, cantdiasgarantia, idimagen, iddimension, idcolor)
VALUES ('prod2', 'prov1', 'Casio', 'Calculadora Casio', 22000.00, 10, 2.0, 'Sepa', 'Casio', 365, 'img1', 'dim1', 'col1');
GO

INSERT INTO Calificaciones(idcalificacion, calificacion, idproducto, idusuario)
VALUES
('cal1',1,'prod1','user1'),
('cal2',3,'prod2','user2'),
('cal3',5,'prod1','user3'),
('cal4',2,'prod1','user4');
GO

INSERT INTO Calificaciones(idcalificacion, calificacion, idproducto, idusuario)
VALUES
('cal5',5,'prod2','user1');
GO

INSERT INTO ProductosCategoriasProducto(idproducto, idcategoriaproducto)
VALUES ('prod1','cat1');
GO

INSERT INTO ProductosCategoriasProducto(idproducto, idcategoriaproducto)
VALUES ('prod1','cat2');
GO

INSERT INTO ProductosCategoriasProducto(idproducto, idcategoriaproducto)
VALUES ('prod2','cat1');
GO

INSERT INTO ProductosCategoriasProducto(idproducto, idcategoriaproducto)
VALUES ('prod2','cat4');
GO

INSERT INTO PalabrasClave (idpalabraclave, palabra)
VALUES 
('pc1', 'tecnología'),
('pc2', 'innovación'),
('pc3', 'empoderamiento'),
('pc4', 'sostenibilidad'),
('pc5', 'creatividad');
GO
INSERT INTO ProductosPalabrasClave (idpalabraclave, idproducto)
VALUES
('pc1','prod1'),
('pc1','prod2'),
('pc2','prod1'),
('pc3','prod1'),
('pc3','prod2'),
('pc4','prod1'),
('pc5','prod1')

INSERT INTO Personas(idpersona, identidad, nombre1, nombre2, apellido1, apellido2, correoelectronico, telefono)
VALUES ('per1','0801','pedro','alfredo','perez','pereira','correopedro','9965'),
 ('per2','0501','juan','ramon','flores','madrid','correojuan','1124433');

INSERT INTO Direcciones (iddireccion, iddepartamento, idmunicipio, idcolonia, calle, referencia, idpersona)
VALUES ('dir1', 'depto1', 'muni1', 'col1', 'Avenida Circunvalación', 'Frente a la gasolinera','per1'),
('dir2', 'depto1', 'muni1', 'col1', 'Las torres', 'atras del banco lafise','per1');
GO

INSERT INTO Pedidos (idpedido, idusuario, fechapedido, idisv, iddireccionentrega)
VALUES ('pedido1', 'user1', '2023-04-23', 'isv1', 'dir1'),
       ('pedido2', 'user2', '2023-04-23', 'isv1', 'dir1')
GO

INSERT INTO EstadosPedido (idestadopedido, estado)
VALUES 
('pendiente', 'Pedido pendiente de ser procesado'),
('enviado', 'Pedido enviado por el proveedor'),
('entregado', 'Pedido entregado al cliente');
GO

INSERT INTO DetallesPedido (iddetallepedido,idproducto,idpedido,idproveedor,cantidad,preciounitario,total,idestadopedido)
VALUES('dp1','prod1','pedido1','prov1',3,100,300,'pendiente')
	  
GO

INSERT INTO DetallesPedido (iddetallepedido,idproducto,idpedido,idproveedor,cantidad,preciounitario,total,idestadopedido)
VALUES('dp2','prod2','pedido2','prov1',2,500,1000,'enviado');
GO

UPDATE Pedidos
SET subtotal = (SELECT total FROM DetallesPedido WHERE idpedido ='pedido1')
WHERE idpedido = 'pedido1';

GO
UPDATE Pedidos
SET total = subtotal * (1+0.15)
WHERE idpedido = 'pedido1';
GO

UPDATE Pedidos
SET subtotal = (SELECT total FROM DetallesPedido WHERE idpedido ='pedido2')
WHERE idpedido = 'pedido2';

GO
UPDATE Pedidos
SET total = subtotal * (1+0.15)
WHERE idpedido = 'pedido2';
GO

INSERT INTO ComprobantesPago(idcomprobante, idpedido)
VALUES('cmpbr1','pedido1'),
	  ('cmpbr2','pedido2');
GO

INSERT INTO MetodosPago (idmetodopago, tipometodo)
VALUES 
('mp1', 'Tarjeta de crédito'),
('mp2', 'PayPal'),
('mp3', 'Tarjeta de Débito');
GO

INSERT INTO PedidosMetodosPago (idpedido, idmetodopago)
VALUES 
('pedido1', 'mp1'),
('pedido2', 'mp2'),
('pedido2', 'mp3');
GO

INSERT INTO PorcentajeComisiones(idporcentajecomision, porcentaje)
VALUES
('pc2', 0.02),
('pc8', 0.08);

INSERT INTO Establecimiento(idestablecimiento, valor) VALUES ('est1', '001');
INSERT INTO Establecimiento(idestablecimiento, valor) VALUES ('est2', '002');
INSERT INTO PuntoEmision(idpuntoemision, valor) VALUES ('pe1', '001');
INSERT INTO PuntoEmision(idpuntoemision, valor) VALUES ('pe2', '002');
INSERT INTO TipoDocumento(idtipodocumento, nombre) VALUES ('td1', '01');
GO
INSERT INTO SolicitudesSAR(idsolicitudsar, numcaiempresa,
fechalimite, idestablecimiento, idpuntoemision, idtipodocumento, correlativoactual,
numeroinicial, numerofinal, idimagen)
VALUES ('solsar1', '00000000000000000000000000000001',
'2023-12-31', 'est1', 'pe1', 'td1', 00000001, 00000001, 10000000, 'img1');