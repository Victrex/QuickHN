/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Clientes;
import hn.unah.grupo5.QuickHN.models.HistorialCompras;
import hn.unah.grupo5.QuickHN.models.Proveedores;
import hn.unah.grupo5.QuickHN.repositories.HistorialComprasRepository;
import hn.unah.grupo5.QuickHN.services.HistorialComprasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class HistorialComprasServicesImpl implements HistorialComprasService{
    @Autowired
    private HistorialComprasRepository historialComprasRepository;

    @Override
    public List<HistorialCompras> getAllHistorialCompras() {
        return this.historialComprasRepository.findAll();
    }

    @Override
    public HistorialCompras saveHistorialCompra(HistorialCompras historialCompra) {
        return this.historialComprasRepository.save(historialCompra);
    }

    @Override
    public HistorialCompras getHistorialCompraByID(String idHistorialCompra) {
        return this.historialComprasRepository.findById(idHistorialCompra).orElse(null);
    }

    @Override    
    public List<HistorialCompras> getHistorialComprasByProveedor(Proveedores idProveedor){
	return this.historialComprasRepository.findByidproveedor(idProveedor);
    };

    @Override    
    public List<HistorialCompras> getHistorialComprasByCliente(Clientes idCliente){
	return this.historialComprasRepository.findByidcliente(idCliente);
    };
    
}
