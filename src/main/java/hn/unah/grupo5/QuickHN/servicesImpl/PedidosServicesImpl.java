/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Pedidos;
import hn.unah.grupo5.QuickHN.repositories.PedidosRepository;
import hn.unah.grupo5.QuickHN.services.PedidosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class PedidosServicesImpl implements PedidosService{
    @Autowired
    private PedidosRepository pedidosRepository;

    @Override
    public List<Pedidos> getAllPedidos() {
        return this.pedidosRepository.findAll();
    }

    @Override
    public Pedidos savePedido(Pedidos pedido) {
        return this.pedidosRepository.save(pedido);
    }

    @Override
    public Pedidos getPedidoByID(String idPedido) {
        return this.pedidosRepository.findById(idPedido).orElse(null);
    }

    @Override    
    public List<Pedidos> getPedidosByUsuario(String idUsuario){
	return this.pedidosRepository.findByidusuario(idUsuario);
    };
    
}
