/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.Empleados;
import hn.unah.grupo5.QuickHN.models.Sucursales;
import java.util.List;

/**
 *
 * @author Soriano
 */
public interface EmpleadosService {
    List<Empleados> getAllEmpleados();
    Empleados saveEmpleado(Empleados empleado);
    void deleteEmpleado(String idEmpleado);
    Empleados getEmpleadoByID(String idEmpleado);
    List<Empleados> getEmpleadosBySucursal(Sucursales idSucursal);
    
}
