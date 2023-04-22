"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const dotenv_1 = __importDefault(require("dotenv"));
const cors_1 = __importDefault(require("cors"));
const path_1 = __importDefault(require("path"));
const method_override_1 = __importDefault(require("method-override"));
const index_routes_1 = __importDefault(require("./routes/index.routes"));
/*import clientRoutes from "./routes/clients.routes";

import motorRoutes from "./routes/motor.routes"
import axios from 'axios'; */
dotenv_1.default.config();
//configs
const app = (0, express_1.default)();
const port = process.env.PORT;
app.use((0, cors_1.default)());
app.use(express_1.default.urlencoded({ extended: false }));
app.set('public', path_1.default.join(__dirname, 'public'));
app.use(express_1.default.json());
app.use(express_1.default.static(path_1.default.join(__dirname, 'public')));
app.use((0, method_override_1.default)('_method'));
//Revisar
//routes
/* app.use('/admin', adminRoutes)

app.use('/motor', motorRoutes) */
app.use('/', index_routes_1.default);
//server
app.listen(port, () => {
    console.log(`[SERVER] running at http://localhost:${port}`);
});
//database
/* async function connectDB() {
    const db = await connect("mongodb+srv://QuickDB:8Xudeey_hA.g8U$@cluster0.gmhxjfx.mongodb.net/?retryWrites=true&w=majority");
    console.log('database is conected to', db.connection.db.databaseName);
}
connectDB(); */ 
