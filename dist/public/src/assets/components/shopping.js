import { urlBack, url2 } from "../../services/url.js";

window.onload = obtenerLista()


async function obtenerLista() {
    let total = document.getElementById("total")
    let resultado = 0;
    let carrito_productos = document.getElementById("carrito_productos");
    carrito_productos.innerHTML = "";
    const lista = JSON.parse(localStorage.getItem("idProductos")) || [];
    if (lista.length > 0) {
        lista.forEach(async e => {
            const respuesta = await fetch(`${url2}prd/${e}`, {
                method: "get",
                headers: {
                  "Content-Type": "application/json",
                  "Accept": "application/json"
                }
              });
              let cantidad = 2;
              
              const resp = await respuesta.json();
              let i = resp.precio * cantidad;
              carrito_productos.innerHTML += `
              <hr>
              <div class="carrito-producto">
                  <img class="carrito-producto-imagen" src="./src/assets/images/laptop.jpg" alt="Titulo del producto">
                  <div class="carrito-producto-titulo">
                      <small>Titulo</small>
                      <h3>${resp.nombreproducto}</h3>
                  </div>
                  <div class="carrito-producto-cantidad">
                      <small>Cantidad</small>
                      <p>2</p>
                  </div>
                  <div class="carrito-producto-precio">
                      <small>Precio</small>
                      <p>L ${resp.precio}</p>
                  </div>
                  <div class="carrito-producto-subtotal">
                      <small>Subtotal</small>
                      <p>L ${i}</p>
                  </div>
                  <button class="carrito-producto-eliminar trash" id="btnDel" ><i class="bi bi-trash3"></i></button>
              </div>
              <hr>
              `
              resultado = resultado + i;
              total.innerHTML = `L ${resultado}`;
        });

    }
        
      return lista;

  }

let btnDel = document.getElementById("btnDel");
  if (btnDel != null) {
    btnDel.addEventListener("click", async (event) => {
      const card = event.target.closest(".trash");
      if (card) {
        console.log("botonEliminar");
        //EliminarDato(card.id)
        event.stopPropagation();
      }
      location.reload();
    });
    }

    function EliminarDato(nuevoPrd) {
        const lista = JSON.parse(localStorage.getItem("idProductos")) || []; // Obtenemos la lista existente o creamos una nueva si no existe
        const index = lista.indexOf(nuevoPrd); // Obtenemos el índice del elemento en la lista
        if (index > -1) { // Verificamos si el valor ya existe en la lista
          lista.splice(index, 1); // Eliminamos el elemento de la lista
          localStorage.setItem("idProductos", JSON.stringify(lista)); // Actualizamos la lista en LocalStorage
        }
      }