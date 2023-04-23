/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Colores;
import hn.unah.grupo5.QuickHN.repositories.ColoresRepository;
import hn.unah.grupo5.QuickHN.services.ColoresService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Pinedas
 */
public class ColoresServicesImpl implements ColoresService {

    @Autowired
    private ColoresRepository coloresRepository;

    @Override
    public List<Colores> getAllColores() {
        return this.coloresRepository.findAll();
    }

    @Override
    public Colores getColorByID(String idcolor) {
        return this.coloresRepository.findById(idcolor).orElse(null);
    }
}
