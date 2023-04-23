/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.Dimensiones;
import java.util.List;

/**
 *
 * @author Pinedas
 */
public interface DimensionesService {

    List<Dimensiones> getAllDimensiones();

    Dimensiones saveDimension(Dimensiones dimension);

    void deleteDimension(String iddimension);

    Dimensiones getDimensionByID(String iddimension);
}
