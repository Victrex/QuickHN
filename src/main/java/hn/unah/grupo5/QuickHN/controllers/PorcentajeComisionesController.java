/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.PorcentajeComisiones;
import hn.unah.grupo5.QuickHN.servicesImpl.PorcentajeComisionesServicesImpl;
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
@RequestMapping("/PorcentajeComisiones")
public class PorcentajeComisionesController {
    
    @Autowired
    private PorcentajeComisionesServicesImpl PorcentajeComisionesService;
    
    @GetMapping("/getAll")
    public List<PorcentajeComisiones> getAllPorcentajeComisiones() {
        return this.PorcentajeComisionesService.getAllPorcentajeComisiones();
    }
    
    @GetMapping("/getById")
    public PorcentajeComisiones getPorcentajeComisionesByID(@RequestParam String id){
        return this.PorcentajeComisionesService.getPorcentajeComisionesByID(id);
    }
}
