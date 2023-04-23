/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.Establecimiento;
import java.util.List;

/**
 *
 * @author Soriano
 */
public interface EstablecimientoService {
    List<Establecimiento> getAllEstablecimiento();
    Establecimiento getEstablecimientoByID(String idEstablecimiento);
    
}
