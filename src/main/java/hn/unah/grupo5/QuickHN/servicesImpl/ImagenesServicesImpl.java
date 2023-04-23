/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Imagenes;
import hn.unah.grupo5.QuickHN.repositories.ImagenesRepository;
import hn.unah.grupo5.QuickHN.services.ImagenesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pinedas
 */
@Service
public class ImagenesServicesImpl implements ImagenesService{
    
    @Autowired
    private ImagenesRepository imagenesRepository;

    @Override
    public List<Imagenes> getAllImagenes() {
        return this.imagenesRepository.findAll();
    }

    @Override
    public Imagenes saveImagen(Imagenes imagen) {
        return this.imagenesRepository.save(imagen);
    }

    @Override
    public void deleteImagen(String idimagen) {
        this.imagenesRepository.deleteById(idimagen);
    }

    @Override
    public Imagenes getImagenByID(String idimagen) {
        return this.imagenesRepository.findById(idimagen).orElse(null);
    }
    
}
