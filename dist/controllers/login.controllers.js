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
exports.loginGetUser = void 0;
var urlBack2 = "http://192.168.191.91:8080";
var urlBack3 = "http://192.168.191.91:8080";
function loginGetUser(req, res) {
    return __awaiter(this, void 0, void 0, function* () {
        const correo = req.params.id;
        const url = `${urlBack3}/usuario/getByCorreo?correo=${correo}`;
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
                res.status(404).send({ error: error.message });
            }
            else {
                res.status(500).send({ error: "Error desconocido" });
            }
        }
    });
}
exports.loginGetUser = loginGetUser;
/* https://example.com/users?email=${email}&password=${password}&userType=${userType} */ 
