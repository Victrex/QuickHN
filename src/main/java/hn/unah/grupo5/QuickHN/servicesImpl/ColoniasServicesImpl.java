/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Colonias;
import hn.unah.grupo5.QuickHN.repositories.ColoniasRepository;
import hn.unah.grupo5.QuickHN.services.ColoniasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class ColoniasServicesImpl implements ColoniasService{
    @Autowired
    private ColoniasRepository coloniasRepository;

    @Override
    public List<Colonias> getAllColonias() {
        return this.coloniasRepository.findAll();
    }

    @Override
    public Colonias getColoniaByID(String idColonia) {
        return this.coloniasRepository.findById(idColonia).orElse(null);
    }
    
}
