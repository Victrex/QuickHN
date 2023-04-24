/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Clientes;
import hn.unah.grupo5.QuickHN.models.Reclamos;
import hn.unah.grupo5.QuickHN.repositories.ReclamosRepository;
import hn.unah.grupo5.QuickHN.services.ReclamosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class ReclamosServicesImpl implements ReclamosService{
    @Autowired
    private ReclamosRepository reclamosRepository;

    @Override
    public List<Reclamos> getAllReclamos() {
        return this.reclamosRepository.findAll();
    }

    @Override
    public Reclamos saveReclamo(Reclamos reclamo) {
        return this.reclamosRepository.save(reclamo);
    }

    @Override
    public Reclamos getReclamoByID(String idReclamo) {
        return this.reclamosRepository.findById(idReclamo).orElse(null);
    }

    @Override    
    public List<Reclamos> getReclamosByCliente(Clientes idCliente){
	return this.reclamosRepository.findByidcliente(idCliente);
    };
    
}
