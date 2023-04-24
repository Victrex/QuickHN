/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.MotivoReclamos;
import java.util.List;

/**
 *
 * @author Soriano
 */
public interface MotivoReclamosService {
    List<MotivoReclamos> getAllMotivoReclamos();
    MotivoReclamos saveMotivoReclamo(MotivoReclamos motivoReclamo);
    void deleteMotivoReclamo(String idMotivoReclamo);
    MotivoReclamos getMotivoReclamoByID(String idMotivoReclamo);
    
}
