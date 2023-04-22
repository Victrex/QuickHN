import { index, productosPorCategoria, prdView, categorias } from "../controllers/index.controllers";
import { Express, Router } from "express";

const router = Router();
router.get('/', index);
router.get('/productos', productosPorCategoria);
router.get('/view', prdView);
router.get('/categorias', categorias);

export default router;