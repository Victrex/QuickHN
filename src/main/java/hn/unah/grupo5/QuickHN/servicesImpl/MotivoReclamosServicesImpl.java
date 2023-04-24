/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.MotivoReclamos;
import hn.unah.grupo5.QuickHN.repositories.MotivoReclamosRepository;
import hn.unah.grupo5.QuickHN.services.MotivoReclamosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class MotivoReclamosServicesImpl implements MotivoReclamosService{
    @Autowired
    private MotivoReclamosRepository motivoReclamosRepository;

    @Override
    public List<MotivoReclamos> getAllMotivoReclamos() {
        return this.motivoReclamosRepository.findAll();
    }

    @Override
    public MotivoReclamos saveMotivoReclamo(MotivoReclamos motivoReclamo) {
        return this.motivoReclamosRepository.save(motivoReclamo);
    }

    @Override
    public void deleteMotivoReclamo(String idMotivoReclamo) {
        this.motivoReclamosRepository.deleteById(idMotivoReclamo);
    }

    @Override
    public MotivoReclamos getMotivoReclamoByID(String idMotivoReclamo) {
        return this.motivoReclamosRepository.findById(idMotivoReclamo).orElse(null);
    }
    
}
