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
    public List<Productos> getProductos() {
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
    public void updateProducto(Productos producto, String idproductos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Productos getProductoByID(String idproducto) {
        return this.productosRepository.findById(idproducto).get();
    }

    @Override
    public List<Productos> getProductosByCategoria(String idcategoria) {
                List<Productos> lista = this.productosRepository.findAll();
        List<Productos> listaByTipo = null;
        listaByTipo.clear();
        for(Productos p :lista){
            if(Objects.equals(p.getIdcategoriaproducto()., idcategoria)){
                listaByTipo.add(p);
            }
        }
        
        return listaByTipo;
        
    }

}
