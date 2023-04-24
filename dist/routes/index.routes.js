"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const index_controllers_1 = require("../controllers/index.controllers");
const categoria_controller_1 = require("../controllers/categoria.controller");
const express_1 = require("express");
const router = (0, express_1.Router)();
router.get('/', index_controllers_1.index);
router.get('/productos', index_controllers_1.productos);
router.get('/view', index_controllers_1.prdView);
router.get('/categorias', index_controllers_1.categorias);
router.get('/carrito', index_controllers_1.carrito);
router.get('/login', index_controllers_1.login);
router.get('/reclamos', index_controllers_1.reclamos);
router.get('/obtenerCategorias', categoria_controller_1.obtenerCategorias);
router.get('/prdCategoria/:id', categoria_controller_1.productosPorCategoria);
exports.default = router;
