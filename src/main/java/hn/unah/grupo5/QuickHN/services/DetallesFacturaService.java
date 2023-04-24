/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.DetallesFactura;
import java.util.List;

/**
 *
 * @author Soriano
 */
public interface DetallesFacturaService {
    List<DetallesFactura> getAllDetallesFactura();
    DetallesFactura saveDetalleFactura(DetallesFactura detalleFactura);
    DetallesFactura getDetalleFacturaByID(String idDetalleFactura);
    
}
