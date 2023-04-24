/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.TiposUsuario;
import hn.unah.grupo5.QuickHN.servicesImpl.TiposUsuarioServicesImpl;
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
@RequestMapping("/tipoUsuario")
public class TiposUsuarioController {
    @Autowired
    private TiposUsuarioServicesImpl tiposUsuarioService;
    
    @GetMapping("/getAll")
    public List<TiposUsuario> getAllTiposUsuario(){
        return this.tiposUsuarioService.getAllTiposUsuario();
    }
    
    @GetMapping("/getById")
    public TiposUsuario getTipoUsuarioByID(@RequestParam  String id){
        return this.tiposUsuarioService.getTipoUsuarioByID(id);
    }
    
}
