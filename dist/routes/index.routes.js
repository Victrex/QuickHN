"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const index_controllers_1 = require("../controllers/index.controllers");
const categoria_controller_1 = require("../controllers/categoria.controller");
const productos_controller_1 = require("../controllers/productos.controller");
const express_1 = require("express");
const login_controllers_1 = require("../controllers/login.controllers");
const router = (0, express_1.Router)();
router.get('/', index_controllers_1.index);
router.get('/productos', index_controllers_1.productos);
router.get('/view', index_controllers_1.prdView);
router.get('/categorias', index_controllers_1.categorias);
router.get('/carrito', index_controllers_1.carrito);
router.get('/login', index_controllers_1.login);
router.get('/registrarse', index_controllers_1.register);
router.get('/reclamos', index_controllers_1.reclamos);
router.get('/obtenerCategorias', categoria_controller_1.obtenerCategorias);
router.get('/metodo', index_controllers_1.metodo);
router.get('/get', index_controllers_1.metodo);
//OBTENER TODOS LOS PRODUCTOS
router.get('/prds/all', productos_controller_1.prdAll);
//GET BY ID
router.get('/In/:id', login_controllers_1.loginGetUser);
router.get('/prd/:id', productos_controller_1.prdByID);
router.get('/prdCategoria/:id', categoria_controller_1.productosPorCategoria);
exports.default = router;
