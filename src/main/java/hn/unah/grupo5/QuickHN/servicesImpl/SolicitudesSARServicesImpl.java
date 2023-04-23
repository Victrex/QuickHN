/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.SolicitudesSAR;
import hn.unah.grupo5.QuickHN.repositories.SolicitudesSARRepository;
import hn.unah.grupo5.QuickHN.services.SolicitudesSARService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class SolicitudesSARServicesImpl implements SolicitudesSARService{
    @Autowired
    private SolicitudesSARRepository solicitudesSARRepository;

    @Override
    public List<SolicitudesSAR> getAllSolictudesSAR() {
        return this.solicitudesSARRepository.findAll();
    }

    @Override
    public SolicitudesSAR getSolictudSARByID(String idSolicitudSAR) {
        return this.solicitudesSARRepository.findById(idSolicitudSAR).orElse(null);
    }
    
}
