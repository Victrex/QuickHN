let submit = document.getElementById('login');

const url2 = "http://localhost:8585/"
login.addEventListener('submit', async (e) => {
    e.preventDefault();

    const id = document.getElementById('email').value;
    const contrasenia = document.getElementById('password').value;

try{
    const respuesta = await fetch(`${url2}In/${id}`,{
      method: 'get',
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      }
    });
    const data = await respuesta.json();
    if (contrasenia === data.contrasenia) {
      console.log(data);
      establecerCookie(data.correoelectronico)
      window.location.href = "/"
    }else if(contrasenia != data.contrasenia){
      alert("La contraseña es incorrecta");
    }else{
      alert("No se encuentra elcorreo")
    }
  }catch(error){
    alert("no se encuentra el correo");
    window.location.href = "/login"
  }
});

function establecerCookie(nombreUsuario) {
  let fechaExpiracion = new Date();
  fechaExpiracion.setTime(fechaExpiracion.getTime() + (7 * 24 * 60 * 60 * 1000)); // 7 días de duración de la cookie
  let idSesion = Math.random().toString(36).substring(2, 15) + Math.random().toString(36).substring(2, 15); // Generar un identificador de sesión único
  document.cookie = "idSesion=" + idSesion + "; expires=" + fechaExpiracion.toUTCString() + "; path=/";
  localStorage.setItem("nombreUsuario", nombreUsuario); // También puede almacenar el nombre de usuario en el almacenamiento local para futuras referencias.
}
