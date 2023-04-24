import { Request, Response } from "express";
import path from "path";
import { loginValidacion } from "../services/fetch.services";
var urlBack2 = "http://192.168.191.91:8080";
var urlBack3 = "http://192.168.191.234:8080";
export async function loginGetUser(req:Request , res:Response) {
    const correo = req.params.id;

/*     try { */
        const url = `${urlBack3}/usuario/getByCorreo?correo=${correo}`;
        const response = await fetch(url);
        const data = await response.json(); 
        res.send(data);
/*         if (data && data.length > 0) {
            const user = data[0];
            res.json(user);
            res.send(data); 
          } else {
            res.json(null);
          }
      } catch (error) {
        console.error('Error al realizar la solicitud:', error);
        res.json({ success: false, message: 'Error al iniciar sesión' + error });
      } */
//    res.send(data); 
  }

  /* https://example.com/users?email=${email}&password=${password}&userType=${userType} */