//OBTENER TODAS LAS CATEGORIAS
async function categoriasGet(url: string) {
    const response = await fetch(url);
    const data = await response.json();
    return data;
  };
//OBTENER TODOS LOS PRODUCTOS POR CATEGORIA
  async function productosPorCat(url: string) {
    const response = await fetch(url);
    const data = await response.json();
    return data;
  };

  //OBTENER UNA VALIDACION DE UN LOGIN 
  async function loginValidacion(url: string) {
    const response = await fetch(url);
    const data = await response.json();
    
    return data;
  };
  






  export {categoriasGet, productosPorCat, loginValidacion};