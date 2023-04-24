/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.DetallesPedido;
import hn.unah.grupo5.QuickHN.models.Proveedores;
import hn.unah.grupo5.QuickHN.repositories.DetallesPedidoRepository;
import hn.unah.grupo5.QuickHN.services.DetallesPedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class DetallesPedidoServicesImpl implements DetallesPedidoService{
    @Autowired
    private DetallesPedidoRepository detallesPedidoRepository;

    @Override
    public List<DetallesPedido> getAllDetallesPedido() {
        return this.detallesPedidoRepository.findAll();
    }

    @Override
    public DetallesPedido saveDetallePedido(DetallesPedido detallePedido) {
        return this.detallesPedidoRepository.save(detallePedido);
    }

    @Override
    public DetallesPedido getDetallePedidoByID(String idDetallePedido) {
        return this.detallesPedidoRepository.findById(idDetallePedido).orElse(null);
    }

    @Override    
    public List<DetallesPedido> getDetallesPedidoByProveedor(Proveedores idProveedor){
	return this.detallesPedidoRepository.findByidproveedor(idProveedor);
    };
    
}
