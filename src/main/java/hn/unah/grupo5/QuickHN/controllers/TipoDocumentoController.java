/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.TipoDocumento;
import hn.unah.grupo5.QuickHN.servicesImpl.TipoDocumentoServicesImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Soriano
 */
@RestController
@RequestMapping("/tipoDocumento")
public class TipoDocumentoController {
    @Autowired
    private TipoDocumentoServicesImpl tipoDocumentoService;
    
    @GetMapping("/getAll")
    public List<TipoDocumento> getAllTipoDocumento(){
        return this.tipoDocumentoService.getAllTipoDocumento();
    }
    
    @GetMapping("/getById")
    public TipoDocumento getTipoDocumentoByID(@RequestParam String id){
        return this.tipoDocumentoService.getTipoDocumentoByID(id);
    }
    
}
