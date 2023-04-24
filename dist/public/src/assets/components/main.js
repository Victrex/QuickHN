import { productosPorCategoria, prdSimilaresPorCategoria } from "../API/categorias.js";
import { productoElegido } from "../API/productos.js";
console.log("ss");
let prdPrCtg = JSON.parse(localStorage.getItem("prdPrCtg"));

var prdCategoria = document.getElementById("catPrds");



if (prdCategoria != null) {
  prdPrCtg.forEach((e) => {
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
}

let more = document.getElementById('more');
var quantity = document.getElementById('quan_input');
let less = document.getElementById('less');
let cont = 1;

more.addEventListener("click", e => {
    quantity.value = ++cont;
});
less.addEventListener("click", e => {
    quantity.value = --cont;
  if (cont < 1) {
    alert('La Cantidad no Es valida')
    cont = 1;
    quantity.value = cont--;
  }
})

/* const moreQ = () =>{
  quantity.value = ++cont; //el precio del producto
}
const lessQ = () =>{
  let totalOrder;
  quantity.value = --cont;
  if (cont < 1) {
    alert('La Cantidad no Es valida')
    cont = 1;
    quantity.value = cont--;
  }
} */


const prdViewLoad = () =>{
  let prdViewChose = productoElegido;
  let prdView = document.getElementById("prdView");
  let prdViewImg = document.getElementById("prdViewImg");
  let prdViewTitulo = document.getElementById("prdViewTitulo");
  let PrdViewmodelo = document.getElementById("modelo");
  let PrdViewdescripcion = document.getElementById("descripcion");
  let PrdViewprecio = document.getElementById("precio");
  let PrdViewdetalles = document.getElementById("detallesPrd");


  prdViewImg.innerHTML = ` <img class="imagen" src="${prdViewChose[0].idimagen}" alt="">`;
  prdViewTitulo.innerHTML = prdViewChose[0].nombreproducto;
   PrdViewmodelo.innerHTML = prdViewChose[0].modeloproducto;
 PrdViewdescripcion.innerHTML = prdViewChose[0].descripcion;
  PrdViewprecio.innerHTML ="L. " + prdViewChose[0].precio;
  PrdViewdetalles.innerHTML = `
  <li> <b> Marca</b> ${prdViewChose[0].marcaproducto}</li>
  <li> <b> Peso KG</b> ${prdViewChose[0].pesoproducto}</li>
  <li> <b> Stock</b> ${prdViewChose[0].stockdisponible}</li>
  `
}
/*   console.log("Esto es el arreglo"+ prdSimilaresPorCategoria(productosPorCategoria));
  var arrPrdSection = prdSimilaresPorCategoria(productosPorCategoria);
  var artSection = document.getElementById("art_section");
  arrPrdSection.forEach(e => {
      artSection.innerHTML = `
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
  }); */

  prdViewLoad()
