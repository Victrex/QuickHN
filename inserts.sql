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

INSERT INTO Direcciones (iddireccion, iddepartamento, idmunicipio, idcolonia, calle, referencia)
VALUES ('dir1', 'depto1', 'muni1', 'col1', 'Avenida Circunvalación', 'Frente a la gasolinera');
GO

INSERT INTO Imagenes (idimagen, tamanio, ruta, descripcion)
VALUES ('img1', 1024, '/images/productos/img1.jpg', 'Imagen del producto');
GO

INSERT INTO Usuarios (idusuario, nombreusuario, correoelectronico, contrasenia, tipousuario, idimagen)
VALUES ('user1', 'Juan Pérez', 'juanperez@example.com', 'contraseña123', 'cliente', 'img1');
GO

INSERT INTO EstadosProveedor (idestadoproveedor, nombreestado, descripcion)
VALUES ('estado1', 'Activo', 'El proveedor se encuentra activo y habilitado para realizar transacciones.');
GO

INSERT INTO Proveedores (idproveedor, idusuario, iddireccion, rtn, nombreproveedor, correoelectronico, idestadoproveedor)
VALUES ('prov1', 'user1', 'dir1', '12345678901234', 'Distribuidora XYZ', 'info@distribuidoraxyz.com', 'estado1');
GO

INSERT INTO Dimensiones (iddimension, alto, ancho, largo)
VALUES ('dim1', 10, 20, 30);
GO
INSERT INTO CategoriasProducto (idcategoriaproducto, nombre, descripcion, idimagen)
VALUES ('cat1', 'Electrónica', 'Productos electrónicos', 'img1');
GO

INSERT INTO Productos (idproducto, idproveedor, nombreproducto, descripcion, precio, idcategoriaproducto, stockdisponible, pesoproducto, modeloproducto, marcaproducto, cantdiasgarantia, idimagen, iddimension, idcolor)
VALUES ('prod1', 'prov1', 'Laptop HP', 'Laptop de la marca HP', 15000.00, 'cat1', 10, 2.0, 'Pavilion', 'HP', 365, 'img1', 'dim1', 'col1');
GO

INSERT INTO Personas(idpersona, iddireccion, identidad, nombre1, nombre2, apellido1, apellido2, correoelectronico, telefono)
VALUES ('per1','dir1','0801','pedro','alfredo','perez','pereira','correopedro','9965');

