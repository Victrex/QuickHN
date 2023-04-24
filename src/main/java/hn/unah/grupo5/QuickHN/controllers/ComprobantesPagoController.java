/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.ComprobantesPago;
import hn.unah.grupo5.QuickHN.servicesImpl.ComprobantesPagoServicesImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kenne
 */
@RestController
@RequestMapping("/comprobantesPago")
public class ComprobantesPagoController {
    
    @Autowired
    private ComprobantesPagoServicesImpl comprobantesPagoService;
    
    @GetMapping("/getAll")
    public List<ComprobantesPago> getAllComprobantesPago() {
        return this.comprobantesPagoService.getAllComprobantesPago();
    }
    
    @GetMapping("/getById")
    public ComprobantesPago getComprobantePagoByID(@RequestParam String id){
        return this.comprobantesPagoService.getComprobantePagoByID(id);
    }
}