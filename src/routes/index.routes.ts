import { index, prdView, categorias, carrito, login, reclamos, productos } from "../controllers/index.controllers";
import {obtenerCategorias, productosPorCategoria} from "../controllers/categoria.controller"
import { Express, Router } from "express";
import { loginGetUser } from "../controllers/login.controllers";

const router = Router();
router.get('/', index);
router.get('/productos', productos);
router.get('/view', prdView);
router.get('/categorias', categorias);
router.get('/carrito', carrito);
router.get('/login', login);
router.get('/reclamos', reclamos);
router.get('/obtenerCategorias', obtenerCategorias);
router.get('/prdCategoria/:id', productosPorCategoria);




//POST
router.get('/In/:id', loginGetUser);


export default router;