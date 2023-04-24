/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.Calificaciones;
import hn.unah.grupo5.QuickHN.models.Productos;
import java.util.List;

/**
 *
 * @author Soriano
 */
public interface CalificacionesService {
    List<Calificaciones> getAllCalificaciones();
    Calificaciones saveCalificacion(Calificaciones calificacion);
    Calificaciones getCalificacionByID(String idCalificacion);
    List<Calificaciones> getCalificacionesByProducto(Productos idProducto);
    
}
