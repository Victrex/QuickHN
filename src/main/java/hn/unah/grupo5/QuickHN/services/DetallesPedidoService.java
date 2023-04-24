/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.DetallesPedido;
import hn.unah.grupo5.QuickHN.models.Pedidos;
import hn.unah.grupo5.QuickHN.models.Proveedores;
import java.util.List;

/**
 *
 * @author Soriano
 */
public interface DetallesPedidoService {
    List<DetallesPedido> getAllDetallesPedido();
    DetallesPedido saveDetallePedido(DetallesPedido detallePedido);
    DetallesPedido getDetallePedidoByID(String idDetallePedido);
    List<DetallesPedido> getDetallesPedidoByProveedor(Proveedores idProveedor);
    List<DetallesPedido> getDetallesPedidoByPedido(Pedidos idPedido);
}
