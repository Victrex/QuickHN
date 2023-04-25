"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.reclamos = exports.register = exports.login = exports.metodo = exports.carrito = exports.categorias = exports.prdView = exports.productos = exports.index = void 0;
const path_1 = __importDefault(require("path"));
const dotenv_1 = __importDefault(require("dotenv"));
dotenv_1.default.config();
var urlBack = process.env.URL;
const index = (req, res) => {
    res.sendFile(path_1.default.resolve(__dirname, '../public/index.html'));
};
exports.index = index;
const productos = (req, res) => {
    res.sendFile(path_1.default.resolve(__dirname, '../public/productos.html'));
};
exports.productos = productos;
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
const metodo = (req, res) => {
    res.sendFile(path_1.default.resolve(__dirname, '../public/mtdPago.html'));
};
exports.metodo = metodo;
const login = (req, res) => {
    try {
        res.sendFile(path_1.default.resolve(__dirname, '../public/login.html'));
    }
    catch (error) {
        res.send("error");
    }
};
exports.login = login;
const register = (req, res) => {
    res.sendFile(path_1.default.resolve(__dirname, '../public/registro.html'));
};
exports.register = register;
const reclamos = (req, res) => {
    res.sendFile(path_1.default.resolve(__dirname, '../public/reclamos.html'));
};
exports.reclamos = reclamos;
