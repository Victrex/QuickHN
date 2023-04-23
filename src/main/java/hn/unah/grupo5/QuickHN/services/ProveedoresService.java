/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.Proveedores;
import java.util.List;

/**
 *
 * @author Pinedas
 */
public interface ProveedoresService {

    List<Proveedores> getAllProveedores();

    Proveedores saveProveedor(Proveedores proveedor);

    void deleteProveedor(String idproveedor);

    Proveedores getProveedorByID(String idproducto);

}
