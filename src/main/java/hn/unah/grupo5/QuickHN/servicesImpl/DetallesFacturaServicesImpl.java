/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.DetallesFactura;
import hn.unah.grupo5.QuickHN.repositories.DetallesFacturaRepository;
import hn.unah.grupo5.QuickHN.services.DetallesFacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class DetallesFacturaServicesImpl implements DetallesFacturaService{
    @Autowired
    private DetallesFacturaRepository detallesFacturaRepository;

    @Override
    public List<DetallesFactura> getAllDetallesFactura() {
        return this.detallesFacturaRepository.findAll();
    }

    @Override
    public DetallesFactura saveDetalleFactura(DetallesFactura detalleFactura) {
        return this.detallesFacturaRepository.save(detalleFactura);
    }

    @Override
    public DetallesFactura getDetalleFacturaByID(String idDetalleFactura) {
        return this.detallesFacturaRepository.findById(idDetalleFactura).orElse(null);
    }
    
}
