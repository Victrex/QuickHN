const productos = [
  {
    idproducto: "PRD001",
    idproveedor: "PRD002",
    nombreproducto: "Latitude E6410",
    descripcion: "Latitude E6410 nitida sin rayones y en perfecto estado",
    precio: 6700.0,
    idcategoria: "CAT001",
    stockdisponible: 10,
    pesoproducto: 2.0,
    modeloproducto: "DLLT001",
    marcaproducto: "DELL",
    cantidadgarantia: 30,
    idimagen: "https://picsum.photos/200",
    iddimension: "14'",
    idcolor: "negro",
  },
  {
    idproducto: "PRD002",
    idproveedor: "PRD002",
    nombreproducto: "Latitude E6410",
    descripcion: "Latitude E6410 nitida sin rayones y en perfecto estado",
    precio: 6700.0,
    idcategoria: "CAT001",
    stockdisponible: 10,
    pesoproducto: 2.0,
    modeloproducto: "DLLT001",
    marcaproducto: "DELL",
    cantidadgarantia: 30,
    idimagen: "https://picsum.photos/200",
    iddimension: "14'",
    idcolor: "negro",
  },
  {
    idproducto: "PRD003",
    idproveedor: "PRD002",
    nombreproducto: "Inspiron N4010",
    descripcion: "Inspiron N4010 en buen estado con cargador y batería",
    precio: 5000.0,
    idcategoria: "CAT001",
    stockdisponible: 5,
    pesoproducto: 1.5,
    modeloproducto: "DN4010",
    marcaproducto: "DELL",
    cantidadgarantia: 30,
    idimagen: "https://picsum.photos/200",
    iddimension: "14'",
    idcolor: "negro",
  },
  {
    idproducto: "PRD004",
    idproveedor: "PRD002",
    nombreproducto: "Inspiron N5010",
    descripcion: "Inspiron N5010 en buen estado con cargador y batería",
    precio: 6000.0,
    idcategoria: "CAT001",
    stockdisponible: 8,
    pesoproducto: 2.0,
    modeloproducto: "DN5010",
    marcaproducto: "DELL",
    cantidadgarantia: 30,
    idimagen: "https://picsum.photos/200",
    iddimension: "15'",
    idcolor: "negro",
  },
  {
    idproducto: "PRD005",
    idproveedor: "PRD002",
    nombreproducto: "Latitude E6430",
    descripcion: "Latitude E6430 en perfecto estado con cargador y batería",
    precio: 7500.0,
    idcategoria: "CAT001",
    stockdisponible: 3,
    pesoproducto: 2.5,
    modeloproducto: "DLLT002",
    marcaproducto: "DELL",
    cantidadgarantia: 30,
    idimagen: "https://picsum.photos/200",
    iddimension: "14'",
    idcolor: "negro",
  },
  {
    idproducto: "PRD001",
    idproveedor: "PRD002",
    nombreproducto: "Laptop Dell Latitude E6410 Core i5 4GB RAM 250GB HDD",
    descripcion: "Latitude E6410 nitida sin rayones y en perfecto estado",
    precio: 6700.0,
    idcategoria: "CAT001",
    stockdisponible: 10,
    pesoproducto: 2.0,
    modeloproducto: "DLLT001",
    marcaproducto: "DELL",
    cantidadgarantia: 30,
    idimagen: "https://picsum.photos/id/10/300/300",
    iddimension: "14'",
    idcolor: "negro",
  },
  {
    idproducto: "PRD002",
    idproveedor: "PRD003",
    nombreproducto: "Laptop HP EliteBook 8460p Core i5 8GB RAM 500GB HDD",
    descripcion: "EliteBook 8460p en excelente estado",
    precio: 8900.0,
    idcategoria: "CAT001",
    stockdisponible: 5,
    pesoproducto: 2.5,
    modeloproducto: "HPLT001",
    marcaproducto: "HP",
    cantidadgarantia: 30,
    idimagen: "https://picsum.photos/id/20/300/300",
    iddimension: "14'",
    idcolor: "plata",
  },
  {
    idproducto: "PRD003",
    idproveedor: "PRD004",
    nombreproducto: "Laptop Lenovo ThinkPad T440s Core i7 8GB RAM 512GB SSD",
    descripcion: "ThinkPad T440s en excelentes condiciones",
    precio: 12000.0,
    idcategoria: "CAT001",
    stockdisponible: 7,
    pesoproducto: 2.0,
    modeloproducto: "LNVLPT001",
    marcaproducto: "Lenovo",
    cantidadgarantia: 30,
    idimagen: "https://picsum.photos/id/30/300/300",
    iddimension: "14'",
    idcolor: "negro",
  },
  {
    idproducto: "PRD004",
    idproveedor: "PRD002",
    nombreproducto:
      "Laptop Dell Inspiron 14 3000 Series Core i3 4GB RAM 128GB SSD",
    descripcion:
      "Inspiron 14 en excelente estado, ideal para trabajo y estudio",
    precio: 8200.0,
    idcategoria: "CAT001",
    stockdisponible: 3,
    pesoproducto: 1.5,
    modeloproducto: "DLLT002",
    marcaproducto: "DELL",
    cantidadgarantia: 30,
    idimagen: "https://picsum.photos/id/40/300/300",
    iddimension: "14'",
    idcolor: "negro",
  },
];

console.log("ssd");

var prdCategoria = document.getElementById("catPrds");

productos.forEach((e) => {
  prdCategoria.innerHTML += `
    <div class="card">
    <img src="${e.idimagen}" alt="">
    <div class="cardContent">
        <div class="titulo">
            <h3>${e.nombreproducto} </h3>
            <h4>L ${e.precio} </h4>
        </div>

        <p>${e.descripcion}</p>
        <span>0.5/5</span>
        <div class="cardButton indexBtn">
            <a href=""><i class="fa-solid fa-cart-shopping"></i> Agregar al Carrito</a>
        </div>
    </div>
</div>
    `;
});

/* const filter = (arreglo) => {
  var NuevoArreglo = [];
  arreglo.forEach((e) => {
    NuevoArreglo.forEach((f) => {
      if (e.marca != f) {
        NuevoArreglo.push(e);
      }
    });
  });
  return NuevoArreglo;
};

console.log(filter(productos)); */
