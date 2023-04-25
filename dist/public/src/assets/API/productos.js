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




var resp;
const prdPrCtg = async (id) => {
  const respuesta = await fetch(`${url2}prdCategoria/${id}`, {
    method: "get",
    headers: {
      "Content-Type": "application/json",
      "Accept": "application/json"
    }
  });
   const resp = await respuesta.json();
   return resp;
}

var contenedorCategorias = document.getElementById("contenedor_categorias");
var contenedorProductos = document.getElementById("catPrds");

if (contenedorCategorias != null) {
contenedorCategorias.addEventListener("click", async (event) => {
  const card = event.target.closest(".cardcategoria");
  if (card) {
    const respuesta = await prdPrCtg(card.id);
    localStorage.setItem("prdPrCtg", JSON.stringify(respuesta));
    window.location.href = `/productos`;
    event.stopPropagation();
  }
});
}


var prdCategoria = document.getElementById("catPrds");
let prdPorCtg = JSON.parse(localStorage.getItem("prdPrCtg"));

if (prdCategoria != null) {
  prdPorCtg.forEach((e) => {
    prdCategoria.innerHTML += `
      <div class="card prCrd" id="${e.idproducto}" >
        <a href="/view"  id="${e.idproducto}">
          <img src="https://firebasestorage.googleapis.com/v0/b/testimg-e5335.appspot.com/o/laptop.jpg?alt=media&token=6d36d423-e589-43e0-be4f-5a0ca8774fe7" alt="">
        </a>
          <div class="cardContent">
          <div class="titulo">
              <a href="/view" id="${e.idproducto}"> <h3>${e.nombreproducto} </h3> </a>
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
};
if (contenedorProductos != null) {
  contenedorProductos.addEventListener("click", async (event) => {
    const card = event.target.closest(".prCrd");
    if (card) {
      //const respuesta = await prdPrCtg(card.id);
      localStorage.setItem("prCrdItem", card.id);
      console.log("Kenneth se la come");
      //window.location.href = `/productos`;
      event.stopPropagation();
    }
  });
  }


/* contenedorProductos.addEventListener("click", async (event) => {
  const card = event.target.closest(".cardcategoria");
  if (card) {
    //const respuesta = await prdPrCtg(card.id);
    console.log(card.id);
    //localStorage.setItem("prdPrCtg", JSON.stringify(respuesta));
    //window.location.href = `/productos`;
    event.stopPropagation();
  }
}); */
/* document.addEventListener('click', function(event) {
  const card = event.target.closest(".cardcategoria");
  if (event.target.classList.contains('prCrd')) {
    console.log(event.target.id);
  }
}); */





export {productoElegido};