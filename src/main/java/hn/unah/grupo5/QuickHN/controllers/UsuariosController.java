/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.DTOs.UsuariosDTO;
import hn.unah.grupo5.QuickHN.models.Imagenes;
import hn.unah.grupo5.QuickHN.models.TiposUsuario;
import hn.unah.grupo5.QuickHN.models.Usuarios;
import hn.unah.grupo5.QuickHN.servicesImpl.ImagenesServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.TiposUsuarioServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.UsuariosServicesImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/usuario")
public class UsuariosController {
    @Autowired
    private UsuariosServicesImpl usuariosService;
    
    @Autowired
    private ImagenesServicesImpl imagenesService;
    
    @Autowired
    private TiposUsuarioServicesImpl tiposUsuarioService;
    
    @GetMapping("/getAll")
    public List<Usuarios> getAllUsuarios(){
        return this.usuariosService.getAllUsuarios();
    }
    
    @GetMapping("/getById")
    public Usuarios getUsuariosByID(@RequestParam String id){
        return this.usuariosService.getUsuarioByID(id);
    }
    
    @GetMapping("/getByTipo")
    public List<Usuarios> getUsuariosByTipo(@RequestParam String id){
        TiposUsuario tipoUsuario=this.tiposUsuarioService.getTipoUsuarioByID(id);
        if(tipoUsuario!=null){
            return this.usuariosService.getUsuariosByTipo(tipoUsuario);
        }
        return null;
    }
    
    @DeleteMapping("/delete")
    public void deleteUsuario(@RequestParam String id){
        if(this.usuariosService.getUsuarioByID(id)!=null){
            this.usuariosService.deleteUsuario(id);
        }
    }
    
    @PostMapping("/save")
    public Usuarios saveUsuario(@RequestBody UsuariosDTO udto){
        boolean flagUsuario=this.usuariosService.getUsuarioByID(udto.getIdusuario())==null;
        boolean flagimagen = this.imagenesService.getImagenByID(udto.getIdimagen())!=null;
        boolean flagTipoUsuario=this.tiposUsuarioService.getTipoUsuarioByID(udto.getIdtipousuario())!=null;
        if((flagUsuario&&flagimagen&&flagTipoUsuario)==true){
            Imagenes imagen = this.imagenesService.getImagenByID(udto.getIdimagen());
            TiposUsuario tipoUsuario=this.tiposUsuarioService.getTipoUsuarioByID(udto.getIdtipousuario());
            Usuarios u=new Usuarios();
            u.setIdusuario(udto.getIdusuario());
            u.setNombreusuario(udto.getNombreusuario());
            u.setCorreoelectronico(udto.getCorreoelectronico());
            u.setContrasenia(udto.getContrasenia());
            u.setIdimagen(imagen);
            u.setIdtipousuario(tipoUsuario);
            return this.usuariosService.saveUsuario(u);
        }
        return null;
    }
    
    @PutMapping("/update")
    public Usuarios updateUsuario(@RequestBody UsuariosDTO udto,@RequestParam String id){
        boolean flagUsuario=this.usuariosService.getUsuarioByID(id)!=null;
        boolean flagimagen = this.imagenesService.getImagenByID(udto.getIdimagen())!=null;
        boolean flagTipoUsuario=this.tiposUsuarioService.getTipoUsuarioByID(udto.getIdtipousuario())!=null;
        if((flagUsuario&&flagimagen&&flagTipoUsuario)==true){
            Imagenes imagen = this.imagenesService.getImagenByID(udto.getIdimagen());
            TiposUsuario tipoUsuario=this.tiposUsuarioService.getTipoUsuarioByID(udto.getIdtipousuario());
            Usuarios u=new Usuarios();
            u.setNombreusuario(udto.getNombreusuario());
            u.setCorreoelectronico(udto.getCorreoelectronico());
            u.setContrasenia(udto.getContrasenia());
            u.setIdimagen(imagen);
            u.setIdtipousuario(tipoUsuario);
            return this.usuariosService.saveUsuario(u);
        }
        return null;
    }
    
}
