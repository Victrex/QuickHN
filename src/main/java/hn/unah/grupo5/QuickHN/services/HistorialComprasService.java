/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.Clientes;
import hn.unah.grupo5.QuickHN.models.HistorialCompras;
import hn.unah.grupo5.QuickHN.models.Proveedores;
import java.util.List;

/**
 *
 * @author Soriano
 */
public interface HistorialComprasService {
    List<HistorialCompras> getAllHistorialCompras();
    HistorialCompras saveHistorialCompra(HistorialCompras historialCompra);
    HistorialCompras getHistorialCompraByID(String idHistorialCompra);
    List<HistorialCompras> getHistorialComprasByProveedor(Proveedores idProveedor);
    List<HistorialCompras> getHistorialComprasByCliente(Clientes idCliente);
    
}
