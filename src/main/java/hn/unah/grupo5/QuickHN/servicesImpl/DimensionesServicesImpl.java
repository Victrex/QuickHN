/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Dimensiones;
import hn.unah.grupo5.QuickHN.repositories.DimensionesRepository;
import hn.unah.grupo5.QuickHN.services.DimensionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pinedas
 */
@Service
public class DimensionesServicesImpl implements DimensionesService {

    @Autowired
    private DimensionesRepository dimensionesRepository;

    @Override
    public List<Dimensiones> getAllDimensiones() {
        return this.dimensionesRepository.findAll();
    }

    @Override
    public Dimensiones saveDimension(Dimensiones dimension) {
        return this.dimensionesRepository.save(dimension);
    }

    @Override
    public void deleteDimension(String iddimension) {
        this.dimensionesRepository.deleteById(iddimension);
    }

    @Override
    public Dimensiones getDimensionByID(String iddimension) {
        return this.dimensionesRepository.findById(iddimension).orElse(null);
    }
    
}
