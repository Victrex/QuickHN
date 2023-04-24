

const formulario = document.querySelector('.formulario-iniciosesion');
const email = document.getElementById('email');
const nombre1 = document.getElementById('nombre1');
const nombre2 = document.getElementById('nombre2');
const apellido1 = document.getElementById('apellido1');
const apellido2 = document.getElementById('apellido2');
const telefono = document.getElementById('telefono');
const id = document.getElementById('id');
const contra = document.getElementById('contra');
const contravalid = document.getElementById('contravalid');
const botonCrearCuenta = document.querySelector('.imput-ingresar');


formulario.addEventListener('submit', async (e) => {
  e.preventDefault();

  
  if (email.value === '' || nombre1.value === '' || apellido1.value === '' || telefono.value === '' || id.value === '' || contra.value === '' || contravalid.value === '') {
    Swal.fire({
        icon: 'error',
        text: 'Por favor, rellene todos los campos',
      })
    return;
  }
  if (contra.value !== contravalid.value) {
    Swal.fire({
        icon: 'error',
        text: 'Las contraseñas no coinciden',
      })
    return;
  }else{
    Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Ingreso sesion correctamnte',
        showConfirmButton: false,
        timer: 1500
      })
    return;
  }

  const datosFormulario = {
    email: email.value,
    nombre1: nombre1.value,
    nombre2: nombre2.value,
    apellido1: apellido1.value,
    apellido2: apellido2.value,
    telefono: telefono.value,
    id: id.value,
    contra: contra.value
  };

  
});


