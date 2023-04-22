import { index, productosPorCategoria, prdView } from "../controllers/index.controllers";
import { Express, Router } from "express";

const router = Router();
router.get('/', index);
router.get('/productos', productosPorCategoria);
router.get('/view', prdView);


export default router;