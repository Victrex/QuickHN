"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.prdView = exports.productosPorCategoria = exports.index = void 0;
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
