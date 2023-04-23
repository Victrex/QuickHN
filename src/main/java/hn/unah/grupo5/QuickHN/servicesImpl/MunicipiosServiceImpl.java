/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Municipios;
import hn.unah.grupo5.QuickHN.repositories.MunicipiosRepository;
import hn.unah.grupo5.QuickHN.services.MunicipiosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class MunicipiosServiceImpl implements MunicipiosService{
    @Autowired
    private MunicipiosRepository municipiosRepository;

    @Override
    public List<Municipios> getAllMunicipios() {
        return this.municipiosRepository.findAll();
    }

    @Override
    public Municipios getMunicipioByID(String idMunicipio) {
        return this.municipiosRepository.findById(idMunicipio).orElse(null);
    }
    
}
