/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Empleados;
import hn.unah.grupo5.QuickHN.models.Sucursales;
import hn.unah.grupo5.QuickHN.repositories.EmpleadosRepository;
import hn.unah.grupo5.QuickHN.services.EmpleadosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class EmpleadosServicesImpl implements EmpleadosService{
    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Override
    public List<Empleados> getAllEmpleados() {
        return this.empleadosRepository.findAll();
    }

    @Override
    public Empleados saveEmpleado(Empleados empleado) {
        return this.empleadosRepository.save(empleado);
    }

    @Override
    public void deleteEmpleado(String idEmpleado) {
        this.empleadosRepository.deleteById(idEmpleado);
    }

    @Override
    public Empleados getEmpleadoByID(String idEmpleado) {
        return this.empleadosRepository.findById(idEmpleado).orElse(null);
    }

    @Override    
    public List<Empleados> getEmpleadosBySucursal(Sucursales idSucursal){
	return this.empleadosRepository.findByidsucursal(idSucursal);
    };
    
}
