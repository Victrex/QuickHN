/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.Isv;
import hn.unah.grupo5.QuickHN.servicesImpl.IsvServicesImpl;
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
@RequestMapping("/isv")
public class IsvController {
    
    @Autowired
        private IsvServicesImpl IsvService;
    
    @GetMapping("/getAll")
    public List<Isv> getAllIsv() {
        return this.IsvService.getAllIsv();
    }
    
    @GetMapping("/getById")
    public Isv getIsvByID(@RequestParam String id){
        return this.IsvService.getIsvByID(id);
    }
    
}
