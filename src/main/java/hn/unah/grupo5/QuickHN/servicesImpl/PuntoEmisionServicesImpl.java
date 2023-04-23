/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.PuntoEmision;
import hn.unah.grupo5.QuickHN.repositories.PuntoEmisionRepository;
import hn.unah.grupo5.QuickHN.services.PuntoEmisionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class PuntoEmisionServicesImpl implements PuntoEmisionService{
    @Autowired
    private PuntoEmisionRepository puntoEmisionRepository;

    @Override
    public List<PuntoEmision> getAllPuntoEmision() {
        return this.puntoEmisionRepository.findAll();
    }

    @Override
    public PuntoEmision getPuntoEmisionByID(String idPuntoEmision) {
        return this.puntoEmisionRepository.findById(idPuntoEmision).orElse(null);
    }
    
}
