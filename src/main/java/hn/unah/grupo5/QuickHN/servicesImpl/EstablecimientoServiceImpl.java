/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Establecimiento;
import hn.unah.grupo5.QuickHN.repositories.EstablecimientoRepository;
import hn.unah.grupo5.QuickHN.services.EstablecimientoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class EstablecimientoServiceImpl implements EstablecimientoService{
    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    @Override
    public List<Establecimiento> getAllEstablecimiento() {
        return this.establecimientoRepository.findAll();
    }

    @Override
    public Establecimiento getEstablecimientoByID(String idEstablecimiento) {
        return this.establecimientoRepository.findById(idEstablecimiento).orElse(null);
    }
    
}
