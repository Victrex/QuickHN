//import url2 from "../URLS/url.js"
let sesion = document.getElementById("sesion")
window.onload = function() {
    verificarSesion();
  }
console.log(sesion);
  function getCookie(name) {
    // Buscar la cookie con el nombre dado
    const cookies = document.cookie.split(';');
    for (let i = 0; i < cookies.length; i++) {
      const cookie = cookies[i].trim();
      if (cookie.startsWith(name + '=')) {
        return cookie.substring(name.length + 1);
      }
    }
    return "";
  }

  const url2 = "http://localhost:8585/"
async function verificarSesion() {
    let idSesion = getCookie("idSesion");
    if (idSesion != "") {
      // La cookie de sesión está establecida
      let id = localStorage.getItem("nombreUsuario");
      console.log("Bienvenido, " + id);
      let active = await usuarioActivo(id)
      console.log(active);
    } else {
      // La cookie de sesión no está establecida
      console.log("Debe iniciar sesión para acceder a esta página.");
      ///window.location.href = "/login";
    }
  }

  const usuarioActivo = async (id) => {
    const response = await fetch(`${url2}In/${id}`,{
        method: 'get',
        headers: {
          "Content-Type": "application/json",
          "Accept": "application/json"
        }
      }).then(response => response.json());
/*       const data = await response.json();
      console.log(data); */
    }