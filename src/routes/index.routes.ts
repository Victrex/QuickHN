import { index, productosPorCategoria, prdView, categorias, carrito, login, reclamos } from "../controllers/index.controllers";
import { Express, Router } from "express";

const router = Router();
router.get('/', index);
router.get('/productos', productosPorCategoria);
router.get('/view', prdView);
router.get('/categorias', categorias);
router.get('/carrito', carrito);
router.get('/login', login);
router.get('/reclamos', reclamos);

export default router;