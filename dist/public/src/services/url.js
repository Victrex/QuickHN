const urlBack = "http://192.168.191.91:8080/"
const url2 = "http://localhost:8585/"
export {urlBack, url2};


const cargarCats = async () => {
    const respuesta = await fetch(`${url2}obtenerCategorias`, {
      method: "get",
    });
     resp = await respuesta.json();
}