/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.TipoDocumento;
import hn.unah.grupo5.QuickHN.repositories.TipoDocumentoRepository;
import hn.unah.grupo5.QuickHN.services.TipoDocumentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class TipoDocumentoServicesImpl implements TipoDocumentoService{
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumento> getAllTipoDocumento() {
        return this.tipoDocumentoRepository.findAll();
    }

    @Override
    public TipoDocumento getTipoDocumentoByID(String idTipoDocumento) {
        return this.tipoDocumentoRepository.findById(idTipoDocumento).orElse(null);
    }
    
}
