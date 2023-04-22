import { Express, Request, response, Response } from "express";
import path from "path";


export const index = (req:Request, res:Response) => {
    res.sendFile(path.resolve(__dirname,'../public/index.html'));
}

export const productosPorCategoria = (req:Request, res:Response) => {
    res.sendFile(path.resolve(__dirname,'../public/productos.html'));
}
export const prdView = (req:Request, res:Response) => {
    res.sendFile(path.resolve(__dirname,'../public/prdView.html'));
}
