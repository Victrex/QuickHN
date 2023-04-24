/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.Municipios;
import hn.unah.grupo5.QuickHN.servicesImpl.MunicipiosServicesImpl;
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
@RequestMapping("/municipio")
public class MunicipiosController {
    
    @Autowired
    private MunicipiosServicesImpl MunicipioService;
    
    @GetMapping("/getAll")
    public List<Municipios> getAllMunicipios() {
        return this.MunicipioService.getAllMunicipios();
    }
    
    @GetMapping("/getById")
    public Municipios getMunicipioByID(@RequestParam String id){
        return this.MunicipioService.getMunicipioByID(id);
    }
}
