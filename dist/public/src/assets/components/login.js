let submit = document.getElementById('login');

const url2 = "http://localhost:8585/"
login.addEventListener('submit', async (e) => {
    e.preventDefault();

    const id = document.getElementById('email').value;
    const contrasenia = document.getElementById('password').value;


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
    }else{
      console.log("no hay relevancia" + contrasenia);
    }
});
