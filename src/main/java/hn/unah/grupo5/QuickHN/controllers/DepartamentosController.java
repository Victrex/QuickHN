/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.Departamentos;
import hn.unah.grupo5.QuickHN.servicesImpl.DepartamentosServicesImpl;
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
@RequestMapping("/departamento")
public class DepartamentosController {
    @Autowired
    private DepartamentosServicesImpl departamentosService;
    
    @GetMapping("/getAll")
    public List<Departamentos> getAllDepartamentos(){
        return this.departamentosService.getAllDepartamentos();
    }
    
    @GetMapping("/getById")
    public Departamentos getDepartamentoByID(@RequestParam String id){
        return this.departamentosService.getDepartamentoByID(id);
    }
}
