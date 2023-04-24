

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
 function verificarSesion() {
    let idSesion = getCookie("idSesion");
    if (idSesion != "") {
      // La cookie de sesión está establecida
      let id = localStorage.getItem("nombreUsuario");
      console.log("Bienvenido, " + id);
      //let active = await usuarioActivo(id)
      LoginOrActive(true, id)
    } else {
      // La cookie de sesión no está establecida
      let id = "";
      LoginOrActive(false, id);
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
      });
      const data = await response.json();
      console.log(data);
      return data;
    }


  const LoginOrActive = async (bool, id) => {
    if (bool == true) {
      let a = await usuarioActivo(id);
      sesion.innerHTML = `
      <div class="sesion userActive" id="sesion">
            
              <i class="fa-solid fa-user Iactive"></i>
              <span>${a.nombreusuario}</span>
            
            <ul class="menu_desplegable menuSesion">
              <li><a href="#"> <i class="fa-solid fa-user"></i> Perfil</a></li>
              <li><a href="#"> <i class="fa-solid fa-gear"></i> Configuración</a></li>
              <li >
              <a href="/login" id="logout"> <i class="fa-solid fa-right-from-bracket" style="color: #ea4343;"></i> Cerrar sesión </a></li>
            </ul> 
      </div>`;
      let logout = document.getElementById("logout");
      logout.addEventListener("click", cerrarSesion)

    }else if (bool == false) {
      sesion.innerHTML = `
      <div class="sesion userInactive" id="sesion">
          <a href="/login">
            <i class="fa-solid fa-user"></i>
            <span>Iniciar Sesion</span></a> 
      </div>`
    }
    
  } 

  function cerrarSesion() {
    document.cookie = "idSesion=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    localStorage.removeItem("nombreUsuario"); // También debe eliminar el nombre de usuario del almacenamiento local.
    console.log("Ha cerrado la sesión.");
    //window.location.href = "pagina-de-inicio-de-sesion.html";
  }



