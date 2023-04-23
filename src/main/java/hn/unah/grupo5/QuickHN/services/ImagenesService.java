/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.Imagenes;
import java.util.List;

/**
 *
 * @author Pinedas
 */
public interface ImagenesService {

    List<Imagenes> getAllImagenes();

    Imagenes saveImagen(Imagenes imagen);

    void deleteImagen(String idimagen);

    Imagenes getImagenByID(String idimagen);

}
