import { Express, Request, Response } from "express";
import path from "path";
import {productoPorId} from "../services/fetch.services";
var urlBack2 = "http://192.168.191.91:8080";

export const prdByID = async (req:Request, res:Response) => {
    const id = req.params.id;
    const url = `${urlBack2}/producto/getById?id=${id}`;
    const data = await productoPorId(url);
    res.send(data); // Enviamos el JSON como respuestas

}

