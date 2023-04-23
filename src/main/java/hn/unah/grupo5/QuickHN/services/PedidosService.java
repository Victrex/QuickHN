/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.Pedidos;
import java.util.List;

/**
 *
 * @author Soriano
 */
public interface PedidosService {    
    List<Pedidos> getAllPedidos();
    Pedidos savePedido(Pedidos pedido);
    Pedidos getPedidoByID(String idPedido);
    List<Pedidos> getPedidosByUsuario(String idPedido);
}
