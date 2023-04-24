/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.ComprobantesPago;
import hn.unah.grupo5.QuickHN.repositories.ComprobantesPagoRepository;
import hn.unah.grupo5.QuickHN.services.ComprobantesPagoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class ComprobantesPagoServicesImpl implements ComprobantesPagoService{
    @Autowired
    private ComprobantesPagoRepository comprobantesPagoRepository;

    @Override
    public List<ComprobantesPago> getAllComprobantesPago() {
        return this.comprobantesPagoRepository.findAll();
    }

    @Override
    public ComprobantesPago saveComprobantePago(ComprobantesPago comprobantePago) {
        return this.comprobantesPagoRepository.save(comprobantePago);
    }

    @Override
    public ComprobantesPago getComprobantePagoByID(String idComprobantePago) {
        return this.comprobantesPagoRepository.findById(idComprobantePago).orElse(null);
    }
    
}
