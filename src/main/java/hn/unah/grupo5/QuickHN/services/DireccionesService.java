/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.Direcciones;
import java.util.List;

/**
 *
 * @author Soriano
 */
public interface DireccionesService {
    List<Direcciones> getAllDirecciones();
    Direcciones saveDireccion(Direcciones direccion);
    void deleteDireccion(String idDireccion);
    Direcciones getDireccionByID(String idDireccion);
    
}
