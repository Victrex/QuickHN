/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.EstadosPedido;
import hn.unah.grupo5.QuickHN.servicesImpl.EstadosPedidoServicesImpl;
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
@RequestMapping("/EstadoPedido")
public class EstadosPedidoController {
    
    @Autowired
    private EstadosPedidoServicesImpl EstadoPedidoService;
    
    @GetMapping("/getAll")
    public List<EstadosPedido> getAllEstadosPedido() {
        return this.EstadoPedidoService.getAllEstadosPedido();
    }
    
    @GetMapping("/getById")
    public EstadosPedido getEstadoPedidoByID(@RequestParam String id){
        return this.EstadoPedidoService.getEstadoPedidoByID(id);
    }
}