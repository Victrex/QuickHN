"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.productosPorCategoria = exports.obtenerCategorias = void 0;
const fetch_services_1 = require("../services/fetch.services");
const dotenv_1 = __importDefault(require("dotenv"));
dotenv_1.default.config();
var urlBack = process.env.URL;
//OBTENER TODAS LAS CATEGORIAS
function obtenerCategorias(req, res) {
    return __awaiter(this, void 0, void 0, function* () {
        const url = `http://${urlBack}/categoriaProducto/getAll`;
        try {
            const response = yield fetch(url);
            const data = yield response.json();
            if (data) {
                res.send(data);
            }
            else {
                throw new Error("No se encontró el registro");
            }
        }
        catch (error) {
            if (error instanceof Error) {
                res.status(404).send({ error: error.message + "Error desde Backend" });
            }
            else {
                res.status(500).send({ error: "Error desconocido" });
            }
        }
    });
}
exports.obtenerCategorias = obtenerCategorias;
function productosPorCategoria(req, res) {
    return __awaiter(this, void 0, void 0, function* () {
        const id = req.params.id;
        const url = `http://${urlBack}/producto/getByCategoria?id=${id}`;
        const data = yield (0, fetch_services_1.productosPorCat)(url);
        res.send(data); // Enviamos el JSON como respuestas
    });
}
exports.productosPorCategoria = productosPorCategoria;
