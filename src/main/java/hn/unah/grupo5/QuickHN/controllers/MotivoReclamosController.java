/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.MotivoReclamos;
import hn.unah.grupo5.QuickHN.servicesImpl.MotivoReclamosServicesImpl;
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
@RequestMapping("/motivoReclamos")
public class MotivoReclamosController {
    @Autowired
    private MotivoReclamosServicesImpl motivoReclamosService;
    
    @GetMapping("/getAll")
    public List<MotivoReclamos> getAllMotivoReclamos(){
        return this.motivoReclamosService.getAllMotivoReclamos();
    }
    
    @GetMapping("/getById")
    public MotivoReclamos getMotivoReclamoByID(@RequestParam String id){
        return this.motivoReclamosService.getMotivoReclamoByID(id);
    }
    
}
