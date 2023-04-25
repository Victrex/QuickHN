import { productosPorCategoria, prdSimilaresPorCategoria } from "../API/categorias.js";


//MENU DESPLEGABLE PARA CUANDO INICIE SESION Y APAREZCA PARA QUE CIERRE SESION
var sesion = document.getElementById('sesion');


sesion.addEventListener("click", async (event) => {
  const menuDesplegable = sesion.querySelector('.menu_desplegable');
  if (menuDesplegable.style.display === 'none') {
    event.preventDefault();
    menuDesplegable.style.display = 'block';
  } else {
    menuDesplegable.style.display = 'none';
    event.stopPropagation(); // evita la propagación del evento click del enlace
  }
});

/* let contenedor_categoriasIndex = document.getElementById("contenedor_categoriasIndex");


  var resp;
  const cargarCatsIndex = async () => {
    const respuesta = await fetch(`${url2}obtenerCategorias`, {
      method: "get",
    });
     resp = await respuesta.json();

     contenedor_categoriasIndex.innerHTML = "";
     resp.slice(0, 3).forEach(e => {
      contenedor_categoriasIndex.innerHTML += `
      <div class="cardcategoria" id="${e.idcategoriaproducto}">
            <img class="imagen-categoria" src="./src/assets/images/pcescrit.jpg" alt="">
            <h3 class="titulo-categoria">${e.nombre}</h3>
      </div>
      `
    });
    return resp;
  };
  cargarCatsIndex(); */


/* var prdCategoria = document.getElementById("catPrds");
let prdPorCtg = JSON.parse(localStorage.getItem("prdPrCtg"));

if (prdCategoria != null) {
  prdPorCtg.forEach((e) => {
    prdCategoria.innerHTML += `
      <div class="card prCrd" id="${e.idproducto}">
        <img src="https://firebasestorage.googleapis.com/v0/b/testimg-e5335.appspot.com/o/laptop.jpg?alt=media&token=6d36d423-e589-43e0-be4f-5a0ca8774fe7" alt="">
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
} */

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


  //CARROUSEL DE 10 PRODUCTOS PARA EL INDEX
var resp;
const prdPrCtgIndx = async () => {
  const respuesta = await fetch(`${url2}/prds/all`, {
    method: "get",
    headers: {
      "Content-Type": "application/json",
      "Accept": "application/json"
    }
  });
   const resp = await respuesta.json();
   
  console.log(resp);   
  return resp;
}

prdPrCtgIndx();
/* 
//FUNCION QUE RECIBE UN ARREGLO GRANDE Y DEVUELVE UN ARREGLO DE SOLO 10 REGISTROS
function prdSimilaresPorCategoria(arreglo) {
  // Si el arreglo tiene menos de 10 elementos, devolvemos todo el arreglo
  if (arreglo.length <= 10) {
    return arreglo;
  }
  
  // Si el arreglo tiene más de 10 elementos, elegimos 10 elementos al azar
  let elegidos = [];
  let indicesElegidos = new Set();
  while (elegidos.length < 10) {
    let indice = Math.floor(Math.random() * arreglo.length);
    if (!indicesElegidos.has(indice)) {
      elegidos.push(arreglo[indice]);
      indicesElegidos.add(indice);
    }
  }
  
  return elegidos;
  
} */



export {prdSimilaresPorCategoria};
export {productosPorCategoria} ;