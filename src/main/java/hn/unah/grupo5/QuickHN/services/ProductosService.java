/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.Productos;
import java.util.List;

/**
 *
 * @author Pinedas
 */
public interface ProductosService {

    List<Productos> getAllProductos();

    Productos saveProducto(Productos producto);

    void deleteProducto(String idproducto);

    Productos getProductoByID(String idproducto);

    List<Productos> getProductosByCategoria(String idcategoria);
}
