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
};
prdPrId(item);
