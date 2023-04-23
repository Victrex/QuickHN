/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.CategoriasProducto;
import hn.unah.grupo5.QuickHN.repositories.CategoriasProductoRepository;
import hn.unah.grupo5.QuickHN.services.CategoriasProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class CategoriasProductoServicesImpl implements CategoriasProductoService {

    @Autowired
    private CategoriasProductoRepository catprodrepository;

    @Override
    public List<CategoriasProducto> getAllCategoriasProducto() {
        return this.catprodrepository.findAll();
    }

    @Override
    public CategoriasProducto saveCategoriaProducto(CategoriasProducto categoriaProducto) {
        return this.catprodrepository.save(categoriaProducto);
    }

    @Override
    public void deleteCategoriasProducto(String idCategoriaProducto) {
        this.catprodrepository.deleteById(idCategoriaProducto);
    }

    @Override
    public CategoriasProducto getCategoriasProductoById(String idcategoriaproducto) {
        return this.catprodrepository.findById(idcategoriaproducto).orElse(null);
    }

}
