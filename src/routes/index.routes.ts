import { index, productosPorCategoria, prdView, categorias, carrito } from "../controllers/index.controllers";
import { Express, Router } from "express";

const router = Router();
router.get('/', index);
router.get('/productos', productosPorCategoria);
router.get('/view', prdView);
router.get('/categorias', categorias);
router.get('/carrito', carrito);


export default router;