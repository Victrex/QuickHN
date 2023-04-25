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
exports.loginGetUser = void 0;
const dotenv_1 = __importDefault(require("dotenv"));
dotenv_1.default.config();
var urlBack = process.env.URL;
//OBTENER UN USUARIO POR SU CORREO ELECTRONICO
function loginGetUser(req, res) {
    return __awaiter(this, void 0, void 0, function* () {
        const correo = req.params.id;
        const url = `http://${urlBack}/usuario/getByCorreo?correo=${correo}`;
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
exports.loginGetUser = loginGetUser;
/* https://example.com/users?email=${email}&password=${password}&userType=${userType} */ 
