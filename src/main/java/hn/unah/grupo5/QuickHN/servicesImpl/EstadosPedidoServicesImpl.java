/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.EstadosPedido;
import hn.unah.grupo5.QuickHN.repositories.EstadosPedidoRepository;
import hn.unah.grupo5.QuickHN.services.EstadosPedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class EstadosPedidoServicesImpl implements EstadosPedidoService{
    @Autowired
    private EstadosPedidoRepository estadosPedidoRepository;

    @Override
    public List<EstadosPedido> getAllEstadosPedido() {
        return this.estadosPedidoRepository.findAll();
    }

    @Override
    public EstadosPedido getEstadoPedidoByID(String idEstadoPedido) {
        return this.estadosPedidoRepository.findById(idEstadoPedido).orElse(null);
    }
    
}
