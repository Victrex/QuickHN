import { urlBack, url2 } from "../../services/url.js";
/* 
https://firebasestorage.googleapis.com/v0/b/testimg-e5335.appspot.com/o/laptop.jpg?alt=media&token=6d36d423-e589-43e0-be4f-5a0ca8774fe7
*/
    let item = localStorage.getItem("prCrdItem")
    
const prdPrId = async (id) => {
    //LLAMAR A TODOS LOS ELEMENTOS DEL DOM QUE VAN A SER CAMBIADOS
    let modelo = document.getElementById("modelo");
    let prdViewTitulo = document.getElementById("prdViewTitulo");
    let descripcion = document.getElementById("descripcion");
    let precio = document.getElementById("precio");
    let detallesPrd = document.getElementById("detallesPrd");
    let prdViewImg = document.getElementById("prdViewImg");
    let botonCarrito = document.getElementById("btnCarrito")
//PETICION FETCH
  const respuesta = await fetch(`${url2}prd/${id}`, {
    method: "get",
    headers: {
      "Content-Type": "application/json",
      "Accept": "application/json"
    }
  });
  //RESPUESTA DE LA PETICION
   const resp = await respuesta.json();
   console.log(resp);
    prdViewImg.innerHTML =`<img src="https://firebasestorage.googleapis.com/v0/b/testimg-e5335.appspot.com/o/laptop.jpg?alt=media&token=6d36d423-e589-43e0-be4f-5a0ca8774fe7">`;
    modelo.innerHTML = `${resp.modeloproducto}`;
    prdViewTitulo.innerHTML = `${resp.nombreproducto}`;
    descripcion.innerHTML = `${resp.descripcion}`;
    precio.innerHTML = `L ${resp.precio}`;
    detallesPrd.innerHTML =`
        <li> <b>Peso :</b> ${resp.pesoproducto} KG</li>
        <li> <b>Marca del producto :</b> ${resp.marcaproducto}</li>
        <li> <b>Garantia :</b> ${resp.cantdiasgarantia} dias</li>
        <li> <b>En Stock :</b> ${resp.stockdisponible} productos disponibles</li>
        `
    botonCarrito.innerHTML = `
      <a href="/carrito" id="${resp.idproducto}" class="carHREF"> <i class="fa-solid fa-cart-shopping"></i> <span>agregar al carrito </span> </a>
    
    `
};

if (item) {prdPrId(item);}else{
    let prdView = document.getElementById("prdView");
    prdView.innerHTML = `<h1>NO SE ENCUENTRA LA PAGINA</h1>`;
}


let botonCarrito = document.getElementById("btnCarrito")
if (botonCarrito != null) {
  botonCarrito.addEventListener("click", async (event) => {

    const card = event.target.closest(".carHREF");
    if (card) {
      actualizarLista(card.id)
      event.stopPropagation();
    }
  });
  }




function actualizarLista(nuevoPrd) {
  const lista = JSON.parse(localStorage.getItem("idProductos")) || []; // Obtenemos la lista existente o creamos una nueva si no existe
  if (!lista.includes(nuevoPrd)) { // Verificamos si el valor ya existe en la lista
    lista.push(nuevoPrd);
    localStorage.setItem("idProductos", JSON.stringify(lista));
  }
   // Actualizamos la lista en LocalStorage
}
function EliminarDato(nuevoPrd) {
  const lista = JSON.parse(localStorage.getItem("idProductos")) || []; // Obtenemos la lista existente o creamos una nueva si no existe
  const index = lista.indexOf(nuevoPrd); // Obtenemos el índice del elemento en la lista
  if (index > -1) { // Verificamos si el valor ya existe en la lista
    lista.splice(index, 1); // Eliminamos el elemento de la lista
    localStorage.setItem("idProductos", JSON.stringify(lista)); // Actualizamos la lista en LocalStorage
  }
}