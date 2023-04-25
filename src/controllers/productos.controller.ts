import { Express, Request, Response } from "express";
import path from "path";
import {productoPorId} from "../services/fetch.services";
import dotenv from 'dotenv';
dotenv.config();
var urlBack = process.env.URL;
  //OBTENER UN PRODUCTO POR SU ID 
export const prdByID = async (req:Request, res:Response) => {
    const id = req.params.id;
    const url = `http://${urlBack}/producto/getById?id=${id}`;
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
            res.status(404).send({ error: error.message +"  No se encuentra el producto" }, );
        } else {
            res.status(500).send({ error: "Error desconocido" });
        }
    }
}

//OBTENER TODOS LOS PRODUCTOS

export const prdAll = async (req:Request, res:Response) => {
    const id = req.params.id;
    const url = `http://${urlBack}/producto/getAll`;
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
            res.status(404).send({ error: error.message +"  No se encuentra los productos" }, );
        } else {
            res.status(500).send({ error: "Error desconocido" });
        }
    }
}