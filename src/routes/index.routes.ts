import { index, prdView, categorias, carrito, login, register, reclamos, productos } from "../controllers/index.controllers";
import {obtenerCategorias, productosPorCategoria} from "../controllers/categoria.controller"
import {prdByID} from "../controllers/productos.controller"
import { Express, Router } from "express";
import { loginGetUser } from "../controllers/login.controllers";

const router = Router();
router.get('/', index);
router.get('/productos', productos);
router.get('/view', prdView);
router.get('/categorias', categorias);
router.get('/carrito', carrito);
router.get('/login', login);
router.get('/registrarse', register)
router.get('/reclamos', reclamos);
router.get('/obtenerCategorias', obtenerCategorias);
router.get('/prdCategoria/:id', productosPorCategoria);




//GET BY ID
router.get('/In/:id', loginGetUser);
router.get('/prd/:id', prdByID)

export default router;