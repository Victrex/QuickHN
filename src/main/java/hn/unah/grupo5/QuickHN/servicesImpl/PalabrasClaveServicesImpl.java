/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.PalabrasClave;
import hn.unah.grupo5.QuickHN.repositories.PalabrasClaveRepository;
import hn.unah.grupo5.QuickHN.services.PalabrasClaveService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class PalabrasClaveServicesImpl implements PalabrasClaveService{
    @Autowired
    private PalabrasClaveRepository palabrasClaveRepository;

    @Override
    public List<PalabrasClave> getAllPalabrasClave() {
        return this.palabrasClaveRepository.findAll();
    }

    @Override
    public PalabrasClave savePalabraClave(PalabrasClave palabraClave) {
        return this.palabrasClaveRepository.save(palabraClave);
    }

    @Override
    public void deletePalabraClave(String idPalabraClave) {
        this.palabrasClaveRepository.deleteById(idPalabraClave);
    }

    @Override
    public PalabrasClave getPalabraClaveByID(String idPalabraClave) {
        return this.palabrasClaveRepository.findById(idPalabraClave).orElse(null);
    }
    
}
