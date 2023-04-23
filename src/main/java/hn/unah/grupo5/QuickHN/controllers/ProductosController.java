/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.DTOs.ProductosDTO;
import hn.unah.grupo5.QuickHN.models.CategoriasProducto;
import hn.unah.grupo5.QuickHN.models.Colores;
import hn.unah.grupo5.QuickHN.models.Dimensiones;
import hn.unah.grupo5.QuickHN.models.Imagenes;
import hn.unah.grupo5.QuickHN.models.Productos;
import hn.unah.grupo5.QuickHN.models.Proveedores;
import hn.unah.grupo5.QuickHN.servicesImpl.CategoriasProductoServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.ColoresServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.DimensionesServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.ImagenesServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.ProductosServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.ProveedoresServicesImpl;
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
 * @author Pinedas
 */
@RestController
@RequestMapping("/producto")
public class ProductosController {

    @Autowired
    private ProductosServicesImpl productoService;

    @Autowired
    private CategoriasProductoServicesImpl categoriaProductoService;

    @Autowired
    private ProveedoresServicesImpl proveedoresService;

    @Autowired
    private ImagenesServicesImpl imagenesService;

    @Autowired
    private DimensionesServicesImpl dimensionesService;

    @Autowired
    private ColoresServicesImpl coloresService;

    @GetMapping("/getAll")
    public List<Productos> getAllProductos() {
        return this.productoService.getAllProductos();
    }

    @GetMapping("/getByCategoria")
    public List<Productos> getByCategoria(@RequestParam String id) {
        CategoriasProducto catprod = this.categoriaProductoService.getCategoriasProductoById(id);
        if (catprod != null) {
            return this.productoService.getProductosByCategoria(catprod);
        }
        return null;
    }

    @GetMapping("/getById")
    public Productos getProductoByID(@RequestParam String id) {
        return this.productoService.getProductoByID(id);
    }

    @PostMapping("/save")
    public Productos saveProducto(@RequestBody ProductosDTO pdto) {

        boolean flagproducto = this.productoService.getProductoByID(pdto.getIdproducto()) == null;
        boolean flagproveedor = this.proveedoresService.getProveedorByID(pdto.getIdproveedor()) != null;
        boolean flagimagen = this.imagenesService.getImagenByID(pdto.getIdimagen()) != null;
        boolean flagdimension = this.dimensionesService.getDimensionByID(pdto.getIddimension()) != null;
        boolean flagcolor = this.coloresService.getColorByID(pdto.getIdcolor()) != null;
        if ((flagproducto && flagproveedor && flagimagen && flagdimension && flagdimension && flagcolor) == true) {
            Proveedores proveedor = this.proveedoresService.getProveedorByID(pdto.getIdproveedor());
            Imagenes imagen = this.imagenesService.getImagenByID(pdto.getIdimagen());
            Dimensiones dimension = this.dimensionesService.getDimensionByID(pdto.getIddimension());
            Colores color = this.coloresService.getColorByID(pdto.getIdcolor());
            Productos p = new Productos();
            p.setIdproducto(pdto.getIdproducto());
            p.setCantdiasgarantia(pdto.getCantdiasgarantia());
            p.setDescripcion(pdto.getDescripcion());
            p.setIdproveedor(proveedor);
            p.setIdimagen(imagen);
            p.setIddimension(dimension);
            p.setIdcolor(color);
            return this.productoService.saveProducto(p);
        } else {
            return null;
        }

    }

    @PutMapping("/update")
    public Productos updateProducto(@RequestBody ProductosDTO pdto, @RequestParam String id) {
        boolean flagproducto = this.productoService.getProductoByID(id) != null;
        boolean flagproveedor = this.proveedoresService.getProveedorByID(pdto.getIdproveedor()) != null;
        boolean flagimagen = this.imagenesService.getImagenByID(pdto.getIdimagen()) != null;
        boolean flagdimension = this.dimensionesService.getDimensionByID(pdto.getIddimension()) != null;
        boolean flagcolor = this.coloresService.getColorByID(pdto.getIdcolor()) != null;
        if ((flagproducto && flagproveedor && flagimagen && flagdimension && flagdimension && flagcolor) == true) {
            Proveedores proveedor = this.proveedoresService.getProveedorByID(pdto.getIdproveedor());
            Imagenes imagen = this.imagenesService.getImagenByID(pdto.getIdimagen());
            Dimensiones dimension = this.dimensionesService.getDimensionByID(pdto.getIddimension());
            Colores color = this.coloresService.getColorByID(pdto.getIdcolor());
            Productos p = new Productos();
            p.setCantdiasgarantia(pdto.getCantdiasgarantia());
            p.setDescripcion(pdto.getDescripcion());
            p.setIdproveedor(proveedor);
            p.setIdimagen(imagen);
            p.setIddimension(dimension);
            p.setIdcolor(color);
            return this.productoService.saveProducto(p);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete")
    public void deleteProductos(@RequestParam String id) {
        if (this.productoService.getProductoByID(id) != null) {
            this.productoService.deleteProducto(id);
        }
    }

}
