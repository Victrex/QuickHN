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
Object.defineProperty(exports, "__esModule", { value: true });
exports.prdByID = void 0;
const fetch_services_1 = require("../services/fetch.services");
var urlBack2 = "http://192.168.191.91:8080";
const prdByID = (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const id = req.params.id;
    const url = `${urlBack2}/producto/getById?id=${id}`;
    const data = yield (0, fetch_services_1.productoPorId)(url);
    res.send(data); // Enviamos el JSON como respuestas
});
exports.prdByID = prdByID;
