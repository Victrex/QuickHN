/*  FUNCION PARA BARRA DE NAVEGACION  */ 

  function myFunction() {
    var x = document.getElementById("headtop");
    if (x.className === "header") {
      x.className += " responsive";
    } else {
      x.className = "header";
    }
  }