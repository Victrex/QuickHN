import { Express, Request, Response, response } from "express";
import path from "path";
import {categoriasGet, productosPorCat} from "../services/fetch.services";
import { categorias } from "./index.controllers";
import dotenv from 'dotenv';
dotenv.config();
var urlBack = process.env.URL;
  //OBTENER TODAS LAS CATEGORIAS
export async function obtenerCategorias(req:Request , res:Response) {
    const url = `http://${urlBack}/categoriaProducto/getAll`;
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




  export async function productosPorCategoria(req:Request , res:Response) {
    const id = req.params.id;

    const url = `http://${urlBack}/producto/getByCategoria?id=${id}`;
    const data = await productosPorCat(url);
    res.send(data); // Enviamos el JSON como respuestas
  }