"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.carrito = exports.categorias = exports.prdView = exports.productosPorCategoria = exports.index = void 0;
const path_1 = __importDefault(require("path"));
const index = (req, res) => {
    res.sendFile(path_1.default.resolve(__dirname, '../public/index.html'));
};
exports.index = index;
const productosPorCategoria = (req, res) => {
    res.sendFile(path_1.default.resolve(__dirname, '../public/productos.html'));
};
exports.productosPorCategoria = productosPorCategoria;
const prdView = (req, res) => {
    res.sendFile(path_1.default.resolve(__dirname, '../public/prdView.html'));
};
exports.prdView = prdView;
const categorias = (req, res) => {
    res.sendFile(path_1.default.resolve(__dirname, '../public/categoria.html'));
};
exports.categorias = categorias;
const carrito = (req, res) => {
    res.sendFile(path_1.default.resolve(__dirname, '../public/carrito.html'));
};
exports.carrito = carrito;
