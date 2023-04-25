import { urlBack, url2 } from "../../services/url.js";
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

var contenedorCategorias = document.getElementById("contenedor_categorias"); //le agregue 1 2 3 al elemento ID
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

//FUNCION FOR EACH QUE AGREGA LOS PRODUCTOS POR SU CATEGORIA AL CONTENEDOR .catPrds 
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
          <div class="cardButton indexBtn" id="${e.idproducto}">
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
      window.location.href = `/view`;
      event.stopPropagation();
    }
  });
  }
//EVENTO PARA BOTON DE CARRITO DE LAS CARDS
let botonCarrito = document.getElementById("catPrds")
if (botonCarrito != null) {
  botonCarrito.addEventListener("click", async (event) => {
    event.preventDefault();
    const card = event.target.closest(".cardButton");
    if (card) {
      actualizarLista(card.id)
      event.stopPropagation();
    }
  });
  }


contenedorProductos.addEventListener("click", async (event) => {
  const card = event.target.closest(".cardcategoria");
  if (card) {
    //const respuesta = await prdPrCtg(card.id);
    console.log(card.id);
    //localStorage.setItem("prdPrCtg", JSON.stringify(respuesta));
    //window.location.href = `/productos`;
    event.stopPropagation();
  }
}); 
document.addEventListener('click', function(event) {
  const card = event.target.closest(".cardcategoria");
  if (event.target.classList.contains('prCrd')) {
    console.log(event.target.id);
  }
}); 





//export {productoElegido};