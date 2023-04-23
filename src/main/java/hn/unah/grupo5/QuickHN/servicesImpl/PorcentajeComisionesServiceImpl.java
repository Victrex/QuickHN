/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.PorcentajeComisiones;
import hn.unah.grupo5.QuickHN.repositories.PorcentajeComisionesRepository;
import hn.unah.grupo5.QuickHN.services.PorcentajeComisionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class PorcentajeComisionesServiceImpl implements PorcentajeComisionesService{
    @Autowired
    private PorcentajeComisionesRepository porcentajeComisionesRepository;

    @Override
    public List<PorcentajeComisiones> getAllPorcentajeComisiones() {
        return this.porcentajeComisionesRepository.findAll();
    }

    @Override
    public PorcentajeComisiones savePorcentajeComisiones(PorcentajeComisiones imagen) {
        return this.porcentajeComisionesRepository.save(imagen);
    }

    @Override
    public void deletePorcentajeComisiones(String idPorcentajeComisiones) {
        this.porcentajeComisionesRepository.deleteById(idPorcentajeComisiones);
    }

    @Override
    public PorcentajeComisiones getPorcentajeComisionesByID(String idPorcentajeComisiones) {
        return this.porcentajeComisionesRepository.findById(idPorcentajeComisiones).orElse(null);
    }
}
