import { index, prdView, categorias, carrito, login, register, reclamos, productos, metodo } from "../controllers/index.controllers";
import {obtenerCategorias, productosPorCategoria} from "../controllers/categoria.controller"
import {prdAll, prdByID} from "../controllers/productos.controller"
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
router.get('/metodo', metodo)

router.get('/get', metodo)


//OBTENER TODOS LOS PRODUCTOS
router.get('/prds/all', prdAll)


//GET BY ID
router.get('/In/:id', loginGetUser);
router.get('/prd/:id', prdByID)
router.get('/prdCategoria/:id', productosPorCategoria);
export default router;