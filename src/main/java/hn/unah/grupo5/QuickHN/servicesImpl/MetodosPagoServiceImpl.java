/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.MetodosPago;
import hn.unah.grupo5.QuickHN.repositories.MetodosPagoRepository;
import hn.unah.grupo5.QuickHN.services.MetodosPagoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class MetodosPagoServiceImpl implements MetodosPagoService{
    @Autowired
    private MetodosPagoRepository metodosPagoRepository;

    @Override
    public List<MetodosPago> getAllMetodosPago() {
        return this.metodosPagoRepository.findAll();
    }

    @Override
    public MetodosPago saveMetodoPago(MetodosPago metodoPago) {
        return this.metodosPagoRepository.save(metodoPago);
    }

    @Override
    public void deleteMetodoPago(String idMetodoPago) {
        this.metodosPagoRepository.deleteById(idMetodoPago);
    }

    @Override
    public MetodosPago getMetodoPagoByID(String idMetodoPago) {
        return this.metodosPagoRepository.findById(idMetodoPago).orElse(null);
    }
    
}
