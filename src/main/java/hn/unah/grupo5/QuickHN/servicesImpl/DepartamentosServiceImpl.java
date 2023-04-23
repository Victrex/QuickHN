/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Departamentos;
import hn.unah.grupo5.QuickHN.repositories.DepartamentosRepository;
import hn.unah.grupo5.QuickHN.services.DepartamentosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class DepartamentosServiceImpl implements DepartamentosService{
    @Autowired
    private DepartamentosRepository departamentosRepository;

    @Override
    public List<Departamentos> getAllDepartamentos() {
        return this.departamentosRepository.findAll();
    }

    @Override
    public Departamentos getDepartamentoByID(String idDepartamento) {
        return this.departamentosRepository.findById(idDepartamento).orElse(null);
    }
    
}
