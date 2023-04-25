
import { urlBack, url2 } from "../../services/url.js";
let contenedor_categorias = document.getElementById("contenedor_categorias");
const productosPorCategoria = []

  var resp;
  let categorias;
  const cargarCats = async () => {
    const respuesta = await fetch(`${url2}obtenerCategorias`, {
      method: "get",
    });
     resp = await respuesta.json();

     contenedor_categorias.innerHTML = "";
    resp.forEach(e => {
      contenedor_categorias.innerHTML += `
      <div class="cardcategoria" id="${e.idcategoriaproducto}">
                    <img class="imagen-categoria" src="./src/assets/images/pcescrit.jpg" alt="">
                        <h3 class="titulo-categoria">${e.nombre}</h3>
      </div>
      `
    });
    return resp;
  };
  cargarCats();


  const categoriasSelec = document.querySelectorAll('.cardcategoria');
  categoriasSelec.forEach(e => {
      e.addEventListener('click', () => {
          const idCategoria = e.id;
          console.log('Categoría seleccionadass:', idCategoria);
      });
  });




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
    
  }

  
  
  export {prdSimilaresPorCategoria};
  export {productosPorCategoria} ;
