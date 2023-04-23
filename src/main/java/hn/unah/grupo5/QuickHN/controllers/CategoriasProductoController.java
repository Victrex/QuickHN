/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.DTOs.CategoriasProductoDTO;
import hn.unah.grupo5.QuickHN.models.CategoriasProducto;
import hn.unah.grupo5.QuickHN.models.Imagenes;
import hn.unah.grupo5.QuickHN.servicesImpl.CategoriasProductoServiceImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.ImagenesServicesImpl;
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
@RequestMapping("/categoriaProducto")
public class CategoriasProductoController {
    @Autowired
    private CategoriasProductoServiceImpl categoriaProductoService;
    
    @Autowired
    private ImagenesServicesImpl imagenService;
    
    
    //MAPEO DE RUTAS EN LA WEB
    @GetMapping("/getAll")
    public List<CategoriasProducto> getAllCategoriasProducto(){
        return this.categoriaProductoService.getAllCategoriasProducto();
    }
    
    @PostMapping("/save")
    public CategoriasProducto saveCategoriaProducto(@RequestBody CategoriasProductoDTO cpdto){
        boolean flagImagenes=this.categoriaProductoService.getCategoriasProductoById(cpdto.getIdcategoriaproducto())!=null;
        if(flagImagenes==true){
            CategoriasProducto cp=new CategoriasProducto();
            Imagenes imagen = this.imagenService.getImagenByID(cpdto.getIdimagen());
            cp.setIdcategoriaproducto(cpdto.getIdcategoriaproducto());
            cp.setNombre(cpdto.getNombre());
            cp.setDescripcion(cpdto.getDescripcion());
            cp.setIdimagen(imagen);
            
            return this.categoriaProductoService.saveCategoriaProducto(cp);
        }
        return null;
    }
    
    @GetMapping("/getById")
    public CategoriasProducto getCategoriasProductoById(@RequestParam String id){
        return this.categoriaProductoService.getCategoriasProductoById(id);
    }
    
    @DeleteMapping("/delete")
    public void deleteCategoriasProducto(@RequestParam String id){
        if(this.categoriaProductoService.getCategoriasProductoById(id)!=null){
            this.categoriaProductoService.deleteCategoriasProducto(id);
        }
    }
    
    @PutMapping("/update")
    public CategoriasProducto updateCategoriaProducto(@RequestBody CategoriasProductoDTO cpdto,@RequestParam String id){
        boolean flagCategoriaProducto=this.categoriaProductoService.getCategoriasProductoById(id)!=null;
        boolean flagImagen=this.imagenService.getImagenByID(cpdto.getIdimagen())!=null;
        if((flagCategoriaProducto&&flagImagen)==true){
            CategoriasProducto cp=new CategoriasProducto();
            Imagenes imagen = this.imagenService.getImagenByID(cpdto.getIdimagen());
            cp.setNombre(cpdto.getNombre());
            cp.setDescripcion(cpdto.getDescripcion());
            cp.setIdimagen(imagen);
            
            return this.categoriaProductoService.saveCategoriaProducto(cp);
        }
        return null;
    }
        
}
