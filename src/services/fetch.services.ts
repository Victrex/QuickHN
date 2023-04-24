async function categoriasGet(url: string) {
    const response = await fetch(url);
    const data = await response.json();
    return data;
  };

  async function productosPorCat(url: string) {
    const response = await fetch(url);
    const data = await response.json();
    return data;
  };



  export {categoriasGet, productosPorCat};