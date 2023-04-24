/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.ComprobantesPago;
import java.util.List;

/**
 *
 * @author Soriano
 */
public interface ComprobantesPagoService {
    List<ComprobantesPago> getAllComprobantesPago();
    ComprobantesPago saveComprobantePago(ComprobantesPago comprobantePago);
    ComprobantesPago getComprobantePagoByID(String idComprobantePago);
    
}
