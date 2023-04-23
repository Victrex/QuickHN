/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Direcciones;
import hn.unah.grupo5.QuickHN.repositories.DireccionesRepository;
import hn.unah.grupo5.QuickHN.services.DireccionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class DireccionesServicesImpl implements DireccionesService{
    @Autowired
    private DireccionesRepository direccionesRepository;

    @Override
    public List<Direcciones> getAllDirecciones() {
        return this.direccionesRepository.findAll();
    }

    @Override
    public Direcciones saveDireccion(Direcciones direccion) {
        return this.direccionesRepository.save(direccion);
    }

    @Override
    public void deleteDireccion(String idDireccion) {
        this.direccionesRepository.deleteById(idDireccion);
    }

    @Override
    public Direcciones getDireccionByID(String idDireccion) {
        return this.direccionesRepository.findById(idDireccion).orElse(null);
    }
    
}
