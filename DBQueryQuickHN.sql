CREATE DATABASE QuickHN;
GO
USE QuickHN;
GO

CREATE LOGIN quickadmin WITH PASSWORD = '12345';
GO

CREATE USER quickadmin FOR LOGIN quickadmin;
GO

ALTER ROLE [db_owner] ADD MEMBER quickadmin;
GO

CREATE TABLE PorcentajeComisiones(
idporcentajecomision VARCHAR(30) PRIMARY KEY,
porcentaje FLOAT(3) NOT NULL
);
GO
CREATE TABLE MetodosPago(
idmetodopago VARCHAR(30) PRIMARY KEY,
tipometodo VARCHAR(80) NOT NULL
);
GO
CREATE TABLE Imagenes(
idimagen VARCHAR(30) PRIMARY KEY,
tamanio FLOAT(3) NOT NULL,
ruta VARCHAR(100) NOT NULL,
descripcion VARCHAR(255) NOT NULL		
);
GO
CREATE TABLE Usuarios(
idusuario VARCHAR(30) PRIMARY KEY,
nombreusuario VARCHAR(100) NOT NULL,
correoelectronico VARCHAR(50) NOT NULL,
contrasenia VARCHAR(200) NOT NULL,
tipousuario VARCHAR(100) NOT NULL,
idimagen VARCHAR(30) NOT NULL,
FOREIGN KEY (idimagen) REFERENCES Imagenes(idimagen)
);
GO
CREATE TABLE Departamentos(
iddepartamento VARCHAR(30) PRIMARY KEY,
nombre VARCHAR(100) NOT NULL 
);
GO
CREATE TABLE Municipios(
idmunicipio VARCHAR(30) PRIMARY KEY,
iddepartamento VARCHAR(30) NOT NULL,
nombre VARCHAR(100) NOT NULL,
FOREIGN KEY (iddepartamento) REFERENCES Departamentos(iddepartamento)
);
GO
CREATE TABLE Colonias(
idcolonia VARCHAR(30) PRIMARY KEY,
idmunicipio VARCHAR(30) NOT NULL,
nombre VARCHAR(100) NOT NULL,
FOREIGN KEY (idmunicipio) REFERENCES Municipios(idmunicipio)
);
GO
CREATE TABLE Direcciones(
iddireccion VARCHAR(30) PRIMARY KEY,
iddepartamento VARCHAR(30) NOT NULL,
idmunicipio VARCHAR(30) NOT NULL,
idcolonia VARCHAR(30) NOT NULL,
calle VARCHAR(150) NOT NULL,
referencia VARCHAR(200) NOT NULL,
FOREIGN KEY (iddepartamento) REFERENCES Departamentos(iddepartamento),
FOREIGN KEY (idmunicipio) REFERENCES Municipios(idmunicipio),
FOREIGN KEY (idcolonia) REFERENCES Colonias(idcolonia)
);
GO
CREATE TABLE Pedidos(
idpedido VARCHAR(30) PRIMARY KEY,
idusuario VARCHAR(30) NOT NULL,
fechapedido DATE NOT NULL,
subtotal FLOAT(3) NOT NULL,
isv FLOAT(3) NOT NULL,
total FLOAT(3) NOT NULL,
iddireccionentrega VARCHAR(30) NOT NULL,
FOREIGN KEY (idusuario) REFERENCES Usuarios(idusuario),
FOREIGN KEY (iddireccionentrega) REFERENCES Direcciones(iddireccion)
);
GO
CREATE TABLE EstadosProveedor(
idestadoproveedor VARCHAR(50) PRIMARY KEY,
nombreestado VARCHAR(30) NOT NULL,
descripcion VARCHAR(500)  NOT NULL
);
GO
CREATE TABLE Proveedores(
idproveedor VARCHAR(30) PRIMARY KEY,
idusuario VARCHAR(30) NOT NULL,
iddireccion VARCHAR(30) NOT NULL,
rtn VARCHAR(15) NOT NULL,
nombreproveedor VARCHAR(100) NOT NULL,
correoelectronico VARCHAR(50) NOT NULL, 
idestadoproveedor VARCHAR(50) NOT NULL
FOREIGN KEY (idusuario) REFERENCES Usuarios(idusuario),
FOREIGN KEY (iddireccion) REFERENCES Direcciones(iddireccion),
FOREIGN KEY (idestadoproveedor) REFERENCES EstadosProveedor(idestadoproveedor)
);
GO
CREATE TABLE Establecimiento(
idestablecimiento VARCHAR(30) PRIMARY KEY,
valor VARCHAR(3) NOT NULL
);
GO
CREATE TABLE PuntoEmision(
idpuntoemision VARCHAR(30) PRIMARY KEY,
valor VARCHAR(3) NOT NULL
);
GO
CREATE TABLE TipoDocumento(
idtipodocumento VARCHAR(30) PRIMARY KEY,
nombre VARCHAR(2) NOT NULL
);
GO
CREATE TABLE SolicitudesSAR(
idsolicitudsar VARCHAR(30) PRIMARY KEY,
numcaiempresa VARCHAR(32) NOT NULL UNIQUE,
fechalimite DATE NOT NULL,
idestablecimiento VARCHAR(30) NOT NULL,
idpuntoemision VARCHAR(30) NOT NULL,
idtipodocumento VARCHAR(30) NOT NULL,
correlativoactual INT NOT NULL,
numeroinicial INT NOT NULL,
numerofinal INT NOT NULL,
isv FLOAT(3) NOT NULL DEFAULT 0.15,
idimagen VARCHAR(30) NOT NULL,
FOREIGN KEY (idestablecimiento) REFERENCES Establecimiento(idestablecimiento),
FOREIGN KEY (idpuntoemision) REFERENCES PuntoEmision(idpuntoemision),
FOREIGN KEY (idtipodocumento) REFERENCES TipoDocumento(idtipodocumento),
FOREIGN KEY (idimagen) REFERENCES Imagenes(idimagen),
);
GO
CREATE TABLE Facturas(
idfactura VARCHAR(30) PRIMARY KEY,
idproveedor VARCHAR(30) NOT NULL,
idsolicitudsar VARCHAR(30) NOT NULL,
rangosolicitudSAR VARCHAR(31) NOT NULL,
numfactura VARCHAR(19) NOT NULL UNIQUE,
subtotal FLOAT(3) NOT NULL,
idporcentajecomision VARCHAR(30) NOT NULL,
isvtotal FLOAT(3) NOT NULL,
total FLOAT(3) NOT NULL,
fechalimite DATETIME,
fechaemision DATETIME,
FOREIGN KEY (idproveedor) REFERENCES Proveedores(idproveedor),
FOREIGN KEY (idsolicitudsar) REFERENCES SolicitudesSAR(idsolicitudsar),
FOREIGN KEY (idporcentajecomision) REFERENCES PorcentajeComisiones(idporcentajecomision)
);
GO
CREATE TABLE Dimensiones(
iddimension VARCHAR(30) PRIMARY KEY,
alto INT NOT NULL,
ancho INT NOT NULL,
largo INT NOT NULL
);
GO
CREATE TABLE CategoriasProducto(
idcategoriaproducto VARCHAR(30) PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
descripcion VARCHAR(500) ,
idimagen VARCHAR(30) NOT NULL,
FOREIGN KEY (idimagen) REFERENCES Imagenes(idimagen)
);
GO
CREATE TABLE Colores(
idcolor VARCHAR(30) PRIMARY KEY,
nombre VARCHAR(30),
valor VARCHAR(10)
);
GO
CREATE TABLE Productos(
idproducto VARCHAR(30) PRIMARY KEY,
idproveedor VARCHAR(30) NOT NULL,
nombreproducto VARCHAR(100) NOT NULL,
descripcion VARCHAR(200) NOT NULL,
precio FLOAT NOT NULL,
idcategoriaproducto VARCHAR(30) NOT NULL,
stockdisponible INT NOT NULL,
pesoproducto FLOAT NOT NULL,
modeloproducto VARCHAR(100) NOT NULL,
marcaproducto VARCHAR(100) NOT NULL,
cantdiasgarantia INT NOT NULL,
idimagen VARCHAR(30) NOT NULL,
iddimension VARCHAR(30) NOT NULL,
idcolor VARCHAR(30) NOT NULL,
FOREIGN KEY (idproveedor) REFERENCES Proveedores(idproveedor),
FOREIGN KEY (idcategoriaproducto) REFERENCES CategoriasProducto(idcategoriaproducto),
FOREIGN KEY (idimagen) REFERENCES Imagenes(idimagen),
FOREIGN KEY (iddimension) REFERENCES Dimensiones(iddimension),
FOREIGN KEY (idcolor) REFERENCES Colores(idcolor)
);
GO
CREATE TABLE Calificaciones(
idcalificacion VARCHAR(30) PRIMARY KEY,
idproducto VARCHAR(30) NOT NULL,
idusuario VARCHAR(30) NOT NULL,
calificacion INT NOT NULL
FOREIGN KEY (idproducto) REFERENCES Productos(idproducto),
FOREIGN KEY (idusuario) REFERENCES Usuarios(idusuario)
);
GO
CREATE TABLE EstadosPedido(
idestadopedido VARCHAR(30) PRIMARY KEY,
estado VARCHAR(50) NOT NULL
);
GO
CREATE TABLE DetallesPedido(
iddetallepedido VARCHAR(30) PRIMARY KEY,
idproducto VARCHAR(30) NOT NULL,
idpedido VARCHAR(30) NOT NULL,
idproveedor VARCHAR(30) NOT NULL,
cantidad INT NOT NULL,
preciounitario FLOAT NOT NULL,
total FLOAT(3) NOT NULL,
idestadopedido VARCHAR(30) NOT NULL,
FOREIGN KEY (idproducto) REFERENCES Productos(idproducto),
FOREIGN KEY (idpedido) REFERENCES Pedidos(idpedido),
FOREIGN KEY (idproveedor) REFERENCES Proveedores(idproveedor),
FOREIGN KEY (idestadopedido) REFERENCES EstadosPedido(idestadopedido)
);
GO
CREATE TABLE DetallesFactura(
iddetallefactura VARCHAR(30) PRIMARY KEY,
iddetallepedido VARCHAR(30) NOT NULL,
idfactura VARCHAR(30) NOT NULL,
cantidad INT NOT NULL DEFAULT 1,
preciounitario FLOAT(3) NOT NULL,
total FLOAT(3) NOT NULL,
FOREIGN KEY (iddetallepedido) REFERENCES DetallesPedido(iddetallepedido),
FOREIGN KEY (idfactura) REFERENCES Facturas(idfactura)
);
GO
CREATE TABLE PalabrasClave(
idpalabraclave VARCHAR(30) PRIMARY KEY,
palabra VARCHAR(30) NOT NULL
);
GO
CREATE TABLE ProductosPalabrasClave(
idpalabraclave VARCHAR(30),
idproducto VARCHAR(30),
PRIMARY KEY(idpalabraclave,idproducto),
FOREIGN KEY(idpalabraclave) REFERENCES PalabrasClave(idpalabraclave),
FOREIGN KEY(idproducto) REFERENCES Productos(idproducto)
);
CREATE TABLE MotivoReclamos(
idmotivoreclamo VARCHAR(30) PRIMARY KEY,
descripcion VARCHAR NOT NULL
);
GO
CREATE TABLE ComprobantesPago(
idcomprobante VARCHAR(30) PRIMARY KEY,
idpedido VARCHAR(30) NOT NULL,
FOREIGN KEY (idpedido) REFERENCES Pedidos(idpedido)
);
GO
CREATE TABLE Personas(
idpersona VARCHAR(30) PRIMARY KEY,
iddireccion VARCHAR(30) NOT NULL,
identidad VARCHAR(13) NOT NULL UNIQUE,
nombre1 VARCHAR(25) NOT NULL,
nombre2 VARCHAR(25),
apellido1 VARCHAR(25) NOT NULL,
apellido2 VARCHAR(25),
correoelectronico VARCHAR(50) NOT NULL UNIQUE,
telefono VARCHAR(9) NOT NULL,
FOREIGN KEY (iddireccion) REFERENCES Direcciones(iddireccion)
);
GO
CREATE TABLE Clientes(
idcliente VARCHAR(30) PRIMARY KEY,
idusuario VARCHAR(30) NOT NULL,
FOREIGN KEY (idcliente) REFERENCES Personas(idpersona),
FOREIGN KEY (idusuario) REFERENCES Usuarios(idusuario)
);
GO
CREATE TABLE HistorialCompras(
idhistorial VARCHAR(30) PRIMARY KEY,
idcliente VARCHAR(30) NOT NULL,
idpedido VARCHAR(30) NOT NULL,
idestadopedido VARCHAR(30) NOT NULL,
idproveedor VARCHAR(30) NOT NULL,
FOREIGN KEY (idcliente) REFERENCES Clientes(idcliente),
FOREIGN KEY (idpedido) REFERENCES Pedidos(idpedido),
FOREIGN KEY (idestadopedido) REFERENCES EstadosPedido(idestadopedido),
FOREIGN KEY (idproveedor) REFERENCES Proveedores(idproveedor)
);
GO
CREATE TABLE Reclamos(
idreclamo VARCHAR(30) PRIMARY KEY,
idcliente VARCHAR(30) NOT NULL,
iddetallepedido VARCHAR(30) NOT NULL,
descripcion VARCHAR NOT NULL,
idmotivoreclamo VARCHAR(30) NOT NULL
FOREIGN KEY (idcliente) REFERENCES Clientes(idcliente),
FOREIGN KEY (iddetallepedido) REFERENCES DetallesPedido(iddetallepedido),
FOREIGN KEY (idmotivoreclamo) REFERENCES MotivoReclamos(idmotivoreclamo)
);
GO
CREATE TABLE Logs(
idlog VARCHAR(30) PRIMARY KEY,
idusuario VARCHAR(30),
direccionip VARCHAR(15) NOT NULL
FOREIGN KEY (idusuario) REFERENCES Usuarios(idusuario)
);
GO
CREATE TABLE Sucursales(
idsucursal VARCHAR(30) PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
iddepartamento VARCHAR(30) NOT NULL,
FOREIGN KEY (iddepartamento) REFERENCES Departamentos(iddepartamento)
);
GO
CREATE TABLE Empleados(
idempleado VARCHAR(30) PRIMARY KEY,
sueldo FLOAT(3) NOT NULL,
idsucursal VARCHAR(30) NOT NULL,
idimagen VARCHAR(30) NOT NULL,
fechacontratacion DATE NOT NULL,
FOREIGN KEY (idempleado) REFERENCES Personas(idpersona),
FOREIGN KEY (idsucursal) REFERENCES Sucursales(idsucursal),
FOREIGN KEY (idimagen) REFERENCES Imagenes(idimagen)
);
GO
CREATE TABLE PedidosMetodosPago(
idpedido VARCHAR(30) NOT NULL,
idmetodopago VARCHAR(30) NOT NULL,
PRIMARY KEY(idpedido,idmetodopago),
FOREIGN KEY (idpedido) REFERENCES Pedidos(idpedido),
FOREIGN KEY (idmetodopago) REFERENCES MetodosPago(idmetodopago)
);
GO
CREATE TABLE ProductosCategoriasProducto(
idproducto VARCHAR(30),
idcategoriaproducto VARCHAR(30),
PRIMARY KEY(idproducto,idcategoriaproducto),
FOREIGN KEY (idproducto) REFERENCES Productos(idproducto),
FOREIGN KEY (idcategoriaproducto) REFERENCES CategoriasProducto(idcategoriaproducto)
);
GO
