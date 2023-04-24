/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.Colonias;
import hn.unah.grupo5.QuickHN.servicesImpl.ColoniasServicesImpl;
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
@RequestMapping("/colonia")
public class ColoniasController {
    @Autowired
    private ColoniasServicesImpl coloniasService;
    
    @GetMapping("/getAll")
    public List<Colonias> getAllColonias(){
        return this.coloniasService.getAllColonias();
    }
    
    @GetMapping("/getById")
    public Colonias getColoniaByID(@RequestParam String id){
        return this.coloniasService.getColoniaByID(id);
    }
    
}
