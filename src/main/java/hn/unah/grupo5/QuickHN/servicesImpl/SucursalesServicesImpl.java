/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Sucursales;
import hn.unah.grupo5.QuickHN.repositories.SucursalesRepository;
import hn.unah.grupo5.QuickHN.services.SucursalesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class SucursalesServicesImpl implements SucursalesService{
    @Autowired
    private SucursalesRepository sucursalesRepository;

    @Override
    public List<Sucursales> getAllSucursales() {
        return this.sucursalesRepository.findAll();
    }

    @Override
    public Sucursales getSucursalByID(String idSucursal) {
        return this.sucursalesRepository.findById(idSucursal).orElse(null);
    }
    
    
}
