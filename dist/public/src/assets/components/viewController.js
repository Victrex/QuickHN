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




console.log(arrPrdSection);