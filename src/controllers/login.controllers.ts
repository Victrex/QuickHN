import { Request, Response } from "express";
import path from "path";
import { loginValidacion } from "../services/fetch.services";
var urlBack2 = "http://192.168.191.91:8080";
var urlBack3 = "http://192.168.191.91:8080";
export async function loginGetUser(req: Request, res: Response) {
  const correo = req.params.id;
  const url = `${urlBack3}/usuario/getByCorreo?correo=${correo}`;

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
          res.status(404).send({ error: error.message });
      } else {
          res.status(500).send({ error: "Error desconocido" });
      }
  }
}



  /* https://example.com/users?email=${email}&password=${password}&userType=${userType} */