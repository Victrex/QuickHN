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
@RequestMapping("/estadosPedido")
public class EstadosPedidoController {
    
    @Autowired
    private EstadosPedidoServicesImpl estadosPedidoService;
    
    @GetMapping("/getAll")
    public List<EstadosPedido> getAllEstadosPedido() {
        return this.estadosPedidoService.getAllEstadosPedido();
    }
    
    @GetMapping("/getById")
    public EstadosPedido getEstadoPedidoByID(@RequestParam String id){
        return this.estadosPedidoService.getEstadoPedidoByID(id);
    }
}