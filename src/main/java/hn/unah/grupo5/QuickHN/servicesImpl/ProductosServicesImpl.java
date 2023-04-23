/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Productos;
import hn.unah.grupo5.QuickHN.repositories.ProductosRepository;
import hn.unah.grupo5.QuickHN.services.ProductosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pinedas
 */
@Service
public class ProductosServicesImpl implements ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<Productos> getAllProductos() {
        return this.productosRepository.findAll();
    }

    @Override
    public Productos saveProducto(Productos producto) {
        return this.productosRepository.save(producto);
    }

    @Override
    public void deleteProducto(String idproducto) {
        this.productosRepository.deleteById(idproducto);
    }

    @Override
    public Productos getProductoByID(String idproducto) {
        return this.productosRepository.findById(idproducto).orElse(null);
    }

    @Override
    public List<Productos> getProductosByCategoria(String idcategoria) {
         return this.productosRepository.findByidcategoriaproducto(idcategoria);        
    }

}
