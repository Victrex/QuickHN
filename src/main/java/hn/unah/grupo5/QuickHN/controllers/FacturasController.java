/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.servicesImpl.FacturasServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.PorcentajeComisionesServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.ProveedoresServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.SolicitudesSARServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Soriano
 */
@RestController
@RequestMapping("/factura")
public class FacturasController {
    @Autowired
    private FacturasServicesImpl facturasService;
    
    @Autowired
    private ProveedoresServicesImpl proveedoresService;
    
    @Autowired
    private SolicitudesSARServicesImpl solicitudesSARService;
    
//    @Autowired
//    private PorcentajeComisionesServiceImpl porcentajeComisionesService;
}
