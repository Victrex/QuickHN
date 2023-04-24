import { Express, Request, Response } from "express";
import {categoriasGet, productosPorCat} from "../services/fetch.services";
import { categorias } from "./index.controllers";
import path from "path";
var  urlBack = "http://192.168.191.91:8080";
var urlBack2 = "http://192.168.191.202:8080";
export async function obtenerCategorias(req:Request , res:Response) {
    const url = `${urlBack}/categoriaProducto/getAll`;
    const data = await categoriasGet(url);
    res.send(data);
  }




  export async function productosPorCategoria(req:Request , res:Response) {
    const id = req.params.id;

    const url = `${urlBack2}/producto/getByCategoria?id=${id}`;
    const data = await productosPorCat(url);
    res.send(data); 
  }