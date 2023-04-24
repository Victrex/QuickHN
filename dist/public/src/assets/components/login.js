let submit = document.getElementById('login');

const url2 = "http://localhost:8585/"
login.addEventListener('submit', async (e) => {
    e.preventDefault();

    const id = document.getElementById('email').value;
    const contrenia = document.getElementById('password').value;


    const respuesta = await fetch(`${url2}In/${id}`,{
      method: 'get',
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      }
    });
    const data = await respuesta.json();
    
    if (contrenia === data.contrenia) {
      console.log(data);
    }
});
