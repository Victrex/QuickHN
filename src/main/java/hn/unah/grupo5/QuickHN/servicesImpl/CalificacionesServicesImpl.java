/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Calificaciones;
import hn.unah.grupo5.QuickHN.models.Productos;
import hn.unah.grupo5.QuickHN.repositories.CalificacionesRepository;
import hn.unah.grupo5.QuickHN.services.CalificacionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class CalificacionesServicesImpl implements CalificacionesService{
    @Autowired
    private CalificacionesRepository calificacionesRepository;

    @Override
    public List<Calificaciones> getAllCalificaciones() {
        return this.calificacionesRepository.findAll();
    }

    @Override
    public Calificaciones saveCalificacion(Calificaciones calificacion) {
        return this.calificacionesRepository.save(calificacion);
    }

    @Override
    public Calificaciones getCalificacionByID(String idCalificacion) {
        return this.calificacionesRepository.findById(idCalificacion).orElse(null);
    }

    @Override    
    public List<Calificaciones> getCalificacionesByProducto(Productos idProducto){
	return this.calificacionesRepository.findByidproducto(idProducto);
    };
    
}
