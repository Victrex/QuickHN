/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.DTOs.DetallesFacturaDTO;
import hn.unah.grupo5.QuickHN.models.DetallesFactura;
import hn.unah.grupo5.QuickHN.models.DetallesPedido;
import hn.unah.grupo5.QuickHN.models.Facturas;
import hn.unah.grupo5.QuickHN.servicesImpl.DetallesFacturaServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.DetallesPedidoServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.FacturasServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Kenne
 */
public class DetallesFacturaController {

    @Autowired
    private DetallesFacturaServicesImpl detallesFacturaService;

    @Autowired
    private DetallesPedidoServicesImpl detallesPedidoService;

    @Autowired
    private FacturasServicesImpl facturasService;

    public DetallesFactura saveDetalleFactura(@RequestBody DetallesFacturaDTO dfdto) {

        boolean flagDetalleFactura = this.detallesFacturaService.getDetalleFacturaByID(dfdto.getIddetallefactura()) == null;
        boolean flagDetallePedido = this.detallesPedidoService.getDetallePedidoByID(dfdto.getIddetallepedido()) != null;
        boolean flagFactura = this.facturasService.getFacturaByID(dfdto.getIdfactura()) != null;
        if ((flagDetalleFactura && flagDetallePedido && flagFactura) == true) {
            DetallesPedido detallespedido = this.detallesPedidoService.getDetallePedidoByID(dfdto.getIddetallepedido());
            Facturas factura = this.facturasService.getFacturaByID(dfdto.getIdfactura());
            DetallesFactura df =  new DetallesFactura();
            df.setCantidad(dfdto.getCantidad());
            df.setIddetallefactura(dfdto.getIddetallefactura());
            df.setIddetallepedido(detallespedido);
            df.setIdfactura(factura);
            df.setPreciounitario(dfdto.getPreciounitario());
            df.setTotal(dfdto.getTotal());
            return this.detallesFacturaService.saveDetalleFactura(df);
        }

        return null;
    }

}
