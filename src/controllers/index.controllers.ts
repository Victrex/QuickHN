import { Express, Request, Response } from "express";
import path from "path";


export const index = (req:Request, res:Response) => {
    res.sendFile(path.resolve(__dirname,'../public/index.html'));
}

export const productos = (req:Request, res:Response) => {
    res.sendFile(path.resolve(__dirname,'../public/productos.html'));
}
export const prdView = (req:Request, res:Response) => {
    res.sendFile(path.resolve(__dirname,'../public/prdView.html'));
}
export const categorias = (req:Request, res:Response) => {
    res.sendFile(path.resolve(__dirname,'../public/categoria.html'));
}

export const carrito = (req:Request, res:Response) => {
    res.sendFile(path.resolve(__dirname, '../public/carrito.html'))
};

export const login = (req:Request, res:Response) => {
    res.sendFile(path.resolve(__dirname, '../public/login.html'))
};

export const reclamos = (req:Request, res:Response) => {
    res.sendFile(path.resolve(__dirname, '../public/reclamos.html'))
};