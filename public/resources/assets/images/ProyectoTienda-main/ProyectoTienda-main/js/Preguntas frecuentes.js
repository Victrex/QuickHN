const Preguntas = document.querySelectorAll('.Preguntas .contenedor-Pregunta');
Preguntas.forEach((Pregunta) => {
    Pregunta.addEventListener('click', (e) => {
        e.currentTarget.classList.toggle('activa');
    

        const Respueta = Pregunta.querySelector('.Respuesta');
        const alturaRealRespuesta = Respueta.scrollHeight;


        if(!Respueta.style.maxHeight){
            Respueta.style.maxHeight = alturaRealRespuesta + 'px';
        }else {
            Respueta.style.maxHeight = null;
           
        }
        
    });
 });


