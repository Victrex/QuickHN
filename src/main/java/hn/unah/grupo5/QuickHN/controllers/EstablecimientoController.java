/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.Establecimiento;
import hn.unah.grupo5.QuickHN.servicesImpl.EstablecimientoServicesImpl;
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
@RequestMapping("/establecimiento")
public class EstablecimientoController {
    
    @Autowired
    private EstablecimientoServicesImpl EstablecimientoService;
    
    @GetMapping("/getAll")
    public List<Establecimiento> getAllEstablecimiento() {
        return this.EstablecimientoService.getAllEstablecimiento();
    }
    
    @GetMapping("/getById")
    public Establecimiento getEstablecimientoByID(@RequestParam String id){
        return this.EstablecimientoService.getEstablecimientoByID(id);
    }
}