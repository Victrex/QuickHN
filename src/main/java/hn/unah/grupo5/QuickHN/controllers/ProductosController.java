/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.DTOs.ProductosDTO;
import hn.unah.grupo5.QuickHN.models.Productos;
import hn.unah.grupo5.QuickHN.models.Proveedores;
import hn.unah.grupo5.QuickHN.repositories.ProveedoresRepository;
import hn.unah.grupo5.QuickHN.servicesImpl.ProductosServicesImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pinedas
 */
@RestController
@RequestMapping("/producto")
public class ProductosController {

    @Autowired
    private ProductosServicesImpl productoService;

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @GetMapping("/getAllProductos")
    public List<Productos> getAllProductos() {
        return this.productoService.getAllProductos();
    }

    @PutMapping("/updateProducto")
    public Productos updateProducto(@RequestBody ProductosDTO pdto, @RequestParam String id) {
        boolean flagproducto = this.productoService.getProductoByID(id) != null;
        boolean flagproveedor = this.proveedoresRepository.findById(pdto.getIdproveedor()).orElse(null) != null;
        boolean flagcategoria =  this.proveedoresRepository.findById(pdto.getIdproveedor()).orElse(null) != null;
        if (flagproducto && flagproveedor == true) {
                Proveedores proveedor = this.proveedoresRepository.findById(pdto.getIdproveedor()).orElse(null);
                Productos p = new Productos();
                p.setCantdiasgarantia(pdto.getCantdiasgarantia());
                p.setDescripcion(pdto.getDescripcion());
                p.setIdproveedor(proveedor);
                return this.productoService.saveProducto(null);
        }
        
        /*
        categ
        imagen
        dim
        color
        */
        return null;
    }

}


/*

{

nombre: "a",
descripcion: "asdasd",
idcategoria: "1"
*/
