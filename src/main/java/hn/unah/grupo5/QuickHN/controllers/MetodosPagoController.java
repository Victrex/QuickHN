/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.MetodosPago;
import hn.unah.grupo5.QuickHN.servicesImpl.MetodosPagoServicesImpl;
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
@RequestMapping("/metodosPago")
public class MetodosPagoController {
    @Autowired
    private MetodosPagoServicesImpl metodosPagoService;
    
    @GetMapping("/getAll")
    public List<MetodosPago> getAllMetodosPago(){
        return this.metodosPagoService.getAllMetodosPago();
    }
    
    @GetMapping("/getById")
    public MetodosPago getMetodoPagoByID(@RequestParam String id){
        return this.metodosPagoService.getMetodoPagoByID(id);
    }
    
}
