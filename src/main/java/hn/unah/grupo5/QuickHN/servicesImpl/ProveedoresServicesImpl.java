/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Proveedores;
import hn.unah.grupo5.QuickHN.repositories.ProveedoresRepository;
import hn.unah.grupo5.QuickHN.services.ProveedoresService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pinedas
 */
@Service
public class ProveedoresServicesImpl  implements ProveedoresService{
    
    
    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @Override
    public List<Proveedores> getAllProveedores() {
        return this.proveedoresRepository.findAll();
    }

    @Override
    public Proveedores saveProveedor(Proveedores proveedor) {
        return this.proveedoresRepository.save(proveedor);
    }

    @Override
    public void deleteProveedor(String idproveedor) {
        this.proveedoresRepository.deleteById(idproveedor);
    }

    @Override
    public Proveedores getProveedorByID(String idproveedor) {
        return this.proveedoresRepository.findById(idproveedor).orElse(null);
    }

    
}
