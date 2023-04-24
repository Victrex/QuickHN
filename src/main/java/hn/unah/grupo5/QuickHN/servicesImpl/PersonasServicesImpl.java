/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Personas;
import hn.unah.grupo5.QuickHN.repositories.PersonasRepository;
import hn.unah.grupo5.QuickHN.services.PersonasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class PersonasServicesImpl implements PersonasService{
    @Autowired
    private PersonasRepository personasRepository;

    @Override
    public List<Personas> getAllPersonas() {
        return this.personasRepository.findAll();
    }

    @Override
    public Personas savePersona(Personas persona) {
        return this.personasRepository.save(persona);
    }

    @Override
    public void deletePersona(String idPersona) {
        this.personasRepository.deleteById(idPersona);
    }

    @Override
    public Personas getPersonaByID(String idPersona) {
        return this.personasRepository.findById(idPersona).orElse(null);
    }
    
}
