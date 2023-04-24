/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.DTOs.FacturasDTO;
import hn.unah.grupo5.QuickHN.models.Facturas;
import hn.unah.grupo5.QuickHN.models.Isv;
import hn.unah.grupo5.QuickHN.models.PorcentajeComisiones;
import hn.unah.grupo5.QuickHN.models.Proveedores;
import hn.unah.grupo5.QuickHN.models.SolicitudesSAR;
import hn.unah.grupo5.QuickHN.servicesImpl.FacturasServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.IsvServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.PorcentajeComisionesServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.ProveedoresServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.SolicitudesSARServicesImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @Autowired
    private PorcentajeComisionesServicesImpl porcentajeComisionesService;
    
    @Autowired
    private IsvServicesImpl isvService;
    
    @GetMapping("/getAll")
    public List<Facturas> getAllFacturas(){
        return this.facturasService.getAllFacturas();
    }
    
    @GetMapping("/getById")
    public Facturas getFacturaByID(@RequestParam String id){
        return this.facturasService.getFacturaByID(id);
    }
    
    @GetMapping("/getByProveedor")
    public List<Facturas> getFacturasByProveedor(@RequestParam String id){
        Proveedores proveedor=this.proveedoresService.getProveedorByID(id);
        if(proveedor!=null){
            return this.facturasService.getFacturasByProveedor(proveedor);
        }
        return null;
    }
    
    @GetMapping("/save")
    public Facturas saveFactura(@RequestBody FacturasDTO fdto){
        boolean flagFactura=this.facturasService.getFacturaByID(fdto.getIdfactura())==null;
        boolean flagProveedor=this.proveedoresService.getProveedorByID(fdto.getIdproveedor())!=null;
        boolean flagSolicitudSAR=this.solicitudesSARService.getSolictudSARByID(fdto.getIdsolicitudsar())!=null;
        boolean flagPorcentajeComisiones=this.porcentajeComisionesService.getPorcentajeComisionesByID(fdto.getIdporcentajecomision())!=null;
        boolean flagIsv=this.isvService.getIsvByID(fdto.getIdisv()) !=null;
        if((flagFactura&&flagProveedor&&flagSolicitudSAR&&flagPorcentajeComisiones&&flagIsv)==true){
            Proveedores proveedor=this.proveedoresService.getProveedorByID(fdto.getIdproveedor());
            SolicitudesSAR solicitudSAR=this.solicitudesSARService.getSolictudSARByID(fdto.getIdsolicitudsar());
            PorcentajeComisiones porcentajeComision=this.porcentajeComisionesService.getPorcentajeComisionesByID(fdto.getIdporcentajecomision());
            Isv isv = this.isvService.getIsvByID(fdto.getIdisv());
            Facturas f=new Facturas();
            f.setIdfactura(fdto.getIdfactura());
            f.setFechalimite(fdto.getFechalimite());
            f.setFechaemision(fdto.getFechaemision());
            f.setRangosolicitudSAR(fdto.getRangosolicitudSAR());
            f.setNumfactura(fdto.getNumfactura());
            f.setSubtotal(fdto.getSubtotal());
            f.setIdisv(isv);
            f.setTotal(fdto.getTotal());
            f.setIdproveedor(proveedor);
            f.setIdsolicitudsar(solicitudSAR);
            f.setIdporcentajecomision(porcentajeComision);
            return this.facturasService.saveFactura(f);            
        }
        return null;
    }
}
