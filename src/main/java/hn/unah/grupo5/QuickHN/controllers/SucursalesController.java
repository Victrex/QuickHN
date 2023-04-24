/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.Sucursales;
import hn.unah.grupo5.QuickHN.servicesImpl.SucursalesServicesImpl;
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
@RequestMapping("/sucursal")
public class SucursalesController {
    @Autowired
    private SucursalesServicesImpl sucursalesService;
    
    @GetMapping("/getAll")
    public List<Sucursales> getAllSucursales(){
        return this.sucursalesService.getAllSucursales();
    }
    
    @GetMapping("/getById")
    public Sucursales getSucursalByID(@RequestParam String id){
        return this.sucursalesService.getSucursalByID(id);
    }
    
}
