/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.DTOs.CalificacionesDTO;
import hn.unah.grupo5.QuickHN.models.Calificaciones;
import hn.unah.grupo5.QuickHN.models.Productos;
import hn.unah.grupo5.QuickHN.models.Usuarios;
import hn.unah.grupo5.QuickHN.servicesImpl.CalificacionesServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.ProductosServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.UsuariosServicesImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Soriano
 */
@RestController
@RequestMapping("/calificacion")
public class CalificacionesController {
    @Autowired
    private CalificacionesServicesImpl calificacionesService;
    
    @Autowired
    private ProductosServicesImpl productosService;
    
    @Autowired
    private UsuariosServicesImpl usuariosService;
    
    @GetMapping("/getAll")
    public List<Calificaciones> getAllCalificaciones(){
        return this.calificacionesService.getAllCalificaciones();
    }
    
    @GetMapping("/getByProducto")
    public List<Calificaciones> getCalificacionesByProducto(@RequestParam String id){
        Productos producto=this.productosService.getProductoByID(id);
        if(producto!=null){
            return this.calificacionesService.getCalificacionesByProducto(producto);
        }
        return null;
    }
    
    @GetMapping("/getById")
    public Calificaciones getCalificacionesByID(@RequestParam String id){
        return this.calificacionesService.getCalificacionByID(id);
    }
    
    @PostMapping("/save")
    public Calificaciones saveCalificacion(@RequestBody CalificacionesDTO cdto){
        boolean flagCalificacion=this.calificacionesService.getCalificacionByID(cdto.getIdcalificacion())==null;
        boolean flagProducto=this.productosService.getProductoByID(cdto.getIdproducto())!=null;
        boolean flagUsuario=this.usuariosService.getUsuarioByID(cdto.getIdusuario())!=null;
        if((flagCalificacion&&flagProducto&&flagUsuario)==true){
            Productos producto=this.productosService.getProductoByID(cdto.getIdproducto());
            Usuarios usuario=this.usuariosService.getUsuarioByID(cdto.getIdusuario());
            Calificaciones c=new Calificaciones();
            c.setIdcalificacion(cdto.getIdcalificacion());
            c.setCalificacion(cdto.getCalificacion());
            c.setIdproducto(producto);
            c.setIdusuario(usuario);
            return this.calificacionesService.saveCalificacion(c);
        }
        System.out.println("no se guardo el elemento"+flagCalificacion);
        return null;            
    }
}
