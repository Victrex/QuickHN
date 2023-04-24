/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.PuntoEmision;
import hn.unah.grupo5.QuickHN.servicesImpl.PuntoEmisionServicesImpl;
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
@RequestMapping("/puntoEmision")
public class PuntoEmisionController {
    @Autowired
    private PuntoEmisionServicesImpl puntoEmisionService;
    
    @GetMapping("/getAll")
    public List<PuntoEmision> getAllPuntoEmision(){
        return this.puntoEmisionService.getAllPuntoEmision();
    }
    
    @GetMapping("/getById")
    public PuntoEmision getPuntoEmisionByID(@RequestParam String id){
        return this.puntoEmisionService.getPuntoEmisionByID(id);
    }
    
}
