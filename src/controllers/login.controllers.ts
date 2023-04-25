import { Request, Response } from "express";
import path from "path";
import { loginValidacion } from "../services/fetch.services";
import dotenv from 'dotenv';
dotenv.config();
var urlBack = process.env.URL;


  //OBTENER UN USUARIO POR SU CORREO ELECTRONICO
export async function loginGetUser(req: Request, res: Response) {
  const correo = req.params.id;
  const url = `http://${urlBack}/usuario/getByCorreo?correo=${correo}`;

  try {
      const response = await fetch(url);
      const data = await response.json();
      if (data) {
          res.send(data);
      } else {
          throw new Error("No se encontró el registro");
      }
  } catch (error: unknown) {
      if (error instanceof Error) {
          res.status(404).send({ error: error.message +"Error desde Backend" }, );
      } else {
          res.status(500).send({ error: "Error desconocido" });
      }
  }
}



  /* https://example.com/users?email=${email}&password=${password}&userType=${userType} */