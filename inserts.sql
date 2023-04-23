USE QuickHN;
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

INSERT INTO Productos (idproducto, idproveedor, nombreproducto, descripcion, precio, idcategoriaproducto, stockdisponible, pesoproducto, modeloproducto, marcaproducto, cantdiasgarantia, idimagen, iddimension, idcolor)
VALUES ('prod1', 'prov1', 'Laptop HP', 'Laptop de la marca HP', 15000.00, 'cat1', 10, 2.0, 'Pavilion', 'HP', 365, 'img1', 'dim1', 'col1');
GO

INSERT INTO Productos (idproducto, idproveedor, nombreproducto, descripcion, precio, idcategoriaproducto, stockdisponible, pesoproducto, modeloproducto, marcaproducto, cantdiasgarantia, idimagen, iddimension, idcolor)
VALUES ('prod2', 'prov1', 'Casio', 'Calculadora Casio', 22000.00, 'cat3', 10, 2.0, 'Sepa', 'Casio', 365, 'img1', 'dim1', 'col1');
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

INSERT INTO Personas(idpersona, identidad, nombre1, nombre2, apellido1, apellido2, correoelectronico, telefono)
VALUES ('per1','0801','pedro','alfredo','perez','pereira','correopedro','9965');

INSERT INTO Direcciones (iddireccion, iddepartamento, idmunicipio, idcolonia, calle, referencia, idpersona)
VALUES ('dir1', 'depto1', 'muni1', 'col1', 'Avenida Circunvalación', 'Frente a la gasolinera','per1');
GO

