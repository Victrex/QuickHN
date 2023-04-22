"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const index_controllers_1 = require("../controllers/index.controllers");
const express_1 = require("express");
const router = (0, express_1.Router)();
router.get('/', index_controllers_1.index);
router.get('/productos', index_controllers_1.productosPorCategoria);
router.get('/view', index_controllers_1.prdView);
exports.default = router;
