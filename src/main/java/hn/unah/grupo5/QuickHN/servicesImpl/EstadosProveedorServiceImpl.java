/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.EstadosProveedor;
import hn.unah.grupo5.QuickHN.repositories.EstadosProveedorRepository;
import hn.unah.grupo5.QuickHN.services.EstadosProveedorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class EstadosProveedorServiceImpl implements EstadosProveedorService{
    @Autowired
    private EstadosProveedorRepository estadosProveedorRepository;

    @Override
    public List<EstadosProveedor> getAllEstadosProveedor() {
        return this.estadosProveedorRepository.findAll();
    }

    @Override
    public EstadosProveedor getEstadoProveedorByID(String idEstadoProveedor) {
        return this.estadosProveedorRepository.findById(idEstadoProveedor).orElse(null);
    }
    
}
