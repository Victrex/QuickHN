/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.DTOs.PedidosDTO;
import hn.unah.grupo5.QuickHN.models.Direcciones;
import hn.unah.grupo5.QuickHN.models.Pedidos;
import hn.unah.grupo5.QuickHN.models.Usuarios;
import hn.unah.grupo5.QuickHN.servicesImpl.DireccionesServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.PedidosServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.UsuariosServicesImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Soriano
 */
@RestController
@RequestMapping("/pedido")
public class PedidosController {
    @Autowired
    private PedidosServicesImpl pedidosService;
    
    @Autowired
    private UsuariosServicesImpl usuariosService;
    
    @Autowired
    private DireccionesServicesImpl direccionesService;
    
    @GetMapping("/getAll")
    public List<Pedidos> getAllPedidos(){
        return this.pedidosService.getAllPedidos();
    }
    
    @GetMapping("/getById")
    public Pedidos getPedidoById(@RequestParam String id){
        return this.pedidosService.getPedidoByID(id);
    }
    
    @GetMapping("/getByUsuario")
    public List<Pedidos> getPedidosByUsuario(@RequestBody String id){
        Usuarios usuario=this.usuariosService.getUsuarioByID(id);
        if(usuario!=null){
            return this.pedidosService.getPedidosByUsuario(usuario);
        }
        return null;
    }
    
    @PostMapping("/save")
    public Pedidos savePedido(@RequestBody PedidosDTO pdto){
        boolean flagPedido=this.pedidosService.getPedidoByID(pdto.getIdpedido())==null;
        boolean flagUsuario=this.usuariosService.getUsuarioByID(pdto.getIdusuario())!=null;
        boolean flagDireccion=this.direccionesService.getDireccionByID(pdto.getIddireccionentrega())!=null;
        
        if((flagPedido&&flagDireccion&&flagUsuario)==true){
            Usuarios usuario=this.usuariosService.getUsuarioByID(pdto.getIdusuario());
            Direcciones direccion=this.direccionesService.getDireccionByID(pdto.getIddireccionentrega());
            Pedidos ptemp=new Pedidos();
            ptemp.setIdpedido(pdto.getIdpedido());
            ptemp.setFechapedido(pdto.getFechapedido());
            ptemp.setSubtotal(pdto.getSubtotal());
            ptemp.setIsv(pdto.getIsv());
            ptemp.setTotal(pdto.getTotal());
            ptemp.setIdusuario(usuario);
            ptemp.setIddireccionentrega(direccion);
            return this.pedidosService.savePedido(ptemp);
        }
        return null;
    }
    
    @PutMapping("/update")
    public Pedidos updatePedido(@RequestBody PedidosDTO pdto,@RequestParam String id){
        boolean flagPedido=this.pedidosService.getPedidoByID(id)!=null;
        boolean flagUsuario=this.usuariosService.getUsuarioByID(pdto.getIdusuario())!=null;
        boolean flagDireccion=this.direccionesService.getDireccionByID(pdto.getIddireccionentrega())!=null;
        
        if((flagPedido&&flagDireccion&&flagUsuario)==true){
            Usuarios usuario=this.usuariosService.getUsuarioByID(pdto.getIdusuario());
            Direcciones direccion=this.direccionesService.getDireccionByID(pdto.getIddireccionentrega());
            Pedidos ptemp=new Pedidos();
            ptemp.setFechapedido(pdto.getFechapedido());
            ptemp.setSubtotal(pdto.getSubtotal());
            ptemp.setIsv(pdto.getIsv());
            ptemp.setTotal(pdto.getTotal());
            ptemp.setIdusuario(usuario);
            ptemp.setIddireccionentrega(direccion);
            return this.pedidosService.savePedido(ptemp);
        }
        return null;        
    }
}
