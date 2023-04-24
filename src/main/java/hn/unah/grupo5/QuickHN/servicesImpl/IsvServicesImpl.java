/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Isv;
import hn.unah.grupo5.QuickHN.repositories.IsvRepository;
import hn.unah.grupo5.QuickHN.services.IsvService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kenne
 */
@Service
public class IsvServicesImpl implements IsvService{

    @Autowired
    private IsvRepository isvRepository;
    
    @Override
    public List<Isv> getAllIsv() {
        return this.isvRepository.findAll();
    }

    @Override
    public Isv getIsvByID(String idisv) {
        return this.isvRepository.findById(idisv).orElse(null);
    }
    
}
