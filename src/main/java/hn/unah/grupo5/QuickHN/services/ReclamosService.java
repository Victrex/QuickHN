/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.Clientes;
import hn.unah.grupo5.QuickHN.models.Reclamos;
import java.util.List;

/**
 *
 * @author Soriano
 */
public interface ReclamosService {
    List<Reclamos> getAllReclamos();
    Reclamos saveReclamo(Reclamos reclamo);
    Reclamos getReclamoByID(String idReclamo);
    List<Reclamos> getReclamosByCliente(Clientes idCliente);
    
}
