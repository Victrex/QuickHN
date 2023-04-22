
/* CREATE TABLE CategoriasProducto(
idcategoriaproducto VARCHAR(30) PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
descripción VARCHAR(500) ,
idimagen VARCHAR(30) NOT NULL,
FOREIGN KEY (idimagen) REFERENCES Imagenes(idimagen)
); */


 const categ = [
    {
        idcategoriaproducto : "cat001",
        nombre : "Laptops",
        descripcion : "Venta de Laptops para trabajo",
        idimagen : ""
    },
    {
        idcategoriaproducto : "cat002",
        nombre : "PC Gaming",
        descripcion : "Venta de Laptops para trabajo",
        idimagen : ""
    }
]

exports.categ = categ;