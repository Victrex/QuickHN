import { productosPorCategoria, prdSimilaresPorCategoria } from "../API/categorias.js";



console.log("ProductosPorCategoria" + productosPorCategoria);
let artSection = document.getElementById("art_section");
var arrPrdSection = prdSimilaresPorCategoria(productosPorCategoria);
const listSimilarPrd = () => {
    artSection.innerHTML = "";
    arrPrdSection.forEach(e => {
        artSection.innerHTML += `
        <div class="card">
        <img src="${e.idimagen}" alt="">
        <div class="cardContent">
            <div class="titulo">
                <h3>${e.nombreproducto} </h3>
                <h4>L ${e.precio} </h4>
            </div>
    
            <p>${e.descripcion}</p>
            <div class="cardButton indexBtn">
                <a href=""><i class="fa-solid fa-cart-shopping"></i> Agregar al Carrito</a>
            </div>
        </div>
    </div>
        `
    });
};

listSimilarPrd();
var prdCategoria = document.getElementById("art_section");
let prdPorCtg = JSON.parse(localStorage.getItem("prdPrCtg"));

//FUNCION FOR EACH QUE AGREGA LOS PRODUCTOS POR SU CATEGORIA AL CONTENEDOR .art_section >>> PRODUCTOS SIMILARES 
if (prdCategoria != null) {
  let arr
  if (prdPorCtg.length > 10) {
    arr = prdPorCtg.slice(0, 10);
  }else{
    arr = prdPorCtg
  }
  arr.forEach((e) => {
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
//CUANDO SELECCIONE UNA CARD DEL CARROUSEL DE 10 PRODUCTOS, QUE ENVIE EL EL ID CARD AL LOCALSTORAGE
var contenedorProductos = document.getElementById("art_section");
if (contenedorProductos != null) {
  contenedorProductos.addEventListener("click", async (event) => {
    const card = event.target.closest(".prCrd");
    if (card) {
      //const respuesta = await prdPrCtg(card.id);
      localStorage.setItem("prCrdItem", card.id);
      //window.location.href = `/productos`;
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



console.log(arrPrdSection);