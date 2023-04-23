/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.models.CategoriasProducto;
import hn.unah.grupo5.QuickHN.servicesImpl.CategoriasProductoServiceImpl;
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
    private CategoriasProductoServiceImpl catProdService;
    
    //MAPEO DE RUTAS EN LA WEB
    @GetMapping("/getAll")
    public List<CategoriasProducto> getAllCategoriasProducto(){
        return this.catProdService.getAllCategoriasProducto();
    }
    
    @PostMapping("/save")
    public CategoriasProducto saveCategoriaProducto(@RequestBody CategoriasProducto catProd){
        if(this.getCategoriasProductoById(catProd.getIdcategoriaproducto())==null){
            return this.catProdService.saveCategoriaProducto(catProd);
        }
        return null;
    }
    
    @GetMapping("/getById")
    public CategoriasProducto getCategoriasProductoById(@RequestParam String id){
        return this.catProdService.getCategoriasProductoById(id);
    }
    
    @DeleteMapping("/delete")
    public void deleteCategoriasProducto(@RequestParam String id){
        if(this.getCategoriasProductoById(id)!=null){
            this.catProdService.deleteCategoriasProducto(id);
        }
    }
    
    @PutMapping("/update")
    public CategoriasProducto updateCategoriaProducto(@RequestBody CategoriasProducto catProd,@RequestParam String id){
        if(this.catProdService.getCategoriasProductoById(id)!=null){
            return this.catProdService.saveCategoriaProducto(catProd);
        }
        return null;
    }
        
}
