import { urlBack, url2 } from "../../services/url.js";
const productoElegido = [
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
]


console.log("productos");

const categorias = document.querySelectorAll('.cardcategoria');
const cat1 = document.getElementById("cat1");


var contenedorCategorias = document.getElementById("contenedor_categorias");

/* var resp;
const prdPrCtg = async (id) => {
  const respuesta = await fetch(`${url2}prdCategoria/${id}`, {
    method: "get",
  });
   resp = await respuesta.json();
   window.location.href = `/productos`;
   return resp;
}


contenedorCategorias.addEventListener("click", async (event) => {
  const card = event.target.closest(".cardcategoria");
  if (card) {
    const respuesta = await prdPrCtg(card.id);
    console.log("El id de la card es: ", respuesta);
    event.stopPropagation();
    
  }
}); */

var resp;
const prdPrCtg = async (id) => {
  const respuesta = await fetch(`${url2}prdCategoria/${id}`, {
    method: "get",
  });
   resp = await respuesta.json();
   
   return resp;
}

contenedorCategorias.addEventListener("click", async (event) => {
  const card = event.target.closest(".cardcategoria");
  if (card) {
    const respuesta = await prdPrCtg(card.id);
    console.log("El id de la card es: ", respuesta);
    localStorage.setItem("prdPrCtg", JSON.stringify(respuesta));
   // window.location.href = `/productos`;
    event.stopPropagation();
  }
});



export {productoElegido};