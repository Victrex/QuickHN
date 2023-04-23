/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Facturas;
import hn.unah.grupo5.QuickHN.models.Proveedores;
import hn.unah.grupo5.QuickHN.repositories.FacturasRepository;
import hn.unah.grupo5.QuickHN.services.FacturasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class FacturasServicesImpl implements FacturasService{
    @Autowired
    private FacturasRepository facturasRepository;

    @Override
    public List<Facturas> getAllFacturas() {
        return this.facturasRepository.findAll();
    }

    @Override
    public Facturas saveFactura(Facturas factura) {
        return this.facturasRepository.save(factura);
    }

    @Override
    public Facturas getFacturaByID(String idFactura) {
        return this.facturasRepository.findById(idFactura).orElse(null);
    }

    @Override
    public List<Facturas> getFacturasByProveedor(Proveedores idProveedor) {
        return this.facturasRepository.findByidproveedor(idProveedor);
    }
    
}
