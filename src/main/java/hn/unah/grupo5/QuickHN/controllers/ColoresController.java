/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.Colores;
import hn.unah.grupo5.QuickHN.models.Productos;
import hn.unah.grupo5.QuickHN.servicesImpl.ColoresServicesImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pinedas
 */
@RestController
@RequestMapping("/color")
public class ColoresController {
    
    @Autowired
    private ColoresServicesImpl ColorService;
    
    @GetMapping("/getAll")
    public List<Colores> getAllColores() {
        return this.ColorService.getAllColores();
    }
    
    @GetMapping("/getById")
    public Colores getColorByID(@RequestParam String id){
        return this.ColorService.getColorByID(id);
    }
}
