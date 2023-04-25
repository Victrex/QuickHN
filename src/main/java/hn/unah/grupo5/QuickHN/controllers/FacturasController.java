/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.DTOs.DetallesFacturaDTO;
import hn.unah.grupo5.QuickHN.DTOs.FacturaRequestDTO;
import hn.unah.grupo5.QuickHN.DTOs.FacturasDTO;
import hn.unah.grupo5.QuickHN.models.DetallesPedido;
import hn.unah.grupo5.QuickHN.models.Facturas;
import hn.unah.grupo5.QuickHN.models.Isv;
import hn.unah.grupo5.QuickHN.models.PorcentajeComisiones;
import hn.unah.grupo5.QuickHN.models.Proveedores;
import hn.unah.grupo5.QuickHN.models.SolicitudesSAR;
import hn.unah.grupo5.QuickHN.servicesImpl.DetallesPedidoServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.FacturasServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.IsvServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.PorcentajeComisionesServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.ProveedoresServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.SolicitudesSARServicesImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    private DetallesPedidoServicesImpl detallesPedidoService;

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

    @Autowired
    private DetallesFacturaController detallesFacturaController;
    

    @GetMapping("/getAll")
    public List<Facturas> getAllFacturas() {
        return this.facturasService.getAllFacturas();
    }

    @GetMapping("/getById")
    public Facturas getFacturaByID(@RequestParam String id) {
        return this.facturasService.getFacturaByID(id);
    }

    @GetMapping("/getByProveedor")
    public List<Facturas> getFacturasByProveedor(@RequestParam String id) {
        Proveedores proveedor = this.proveedoresService.getProveedorByID(id);
        if (proveedor != null) {
            return this.facturasService.getFacturasByProveedor(proveedor);
        }
        return null;
    }

    @PostMapping("/save")
    public Facturas saveFactura(@RequestBody FacturaRequestDTO frdto) {
        FacturasDTO fdto = frdto.getFactura();
        List<DetallesFacturaDTO> dfdto = frdto.getDetallesFactura();

        Proveedores proveedor = this.proveedoresService.getProveedorByID(fdto.getIdproveedor());
        SolicitudesSAR solicitudSAR = this.solicitudesSARService.getSolictudSARByID(fdto.getIdsolicitudsar());
        Isv isv = this.isvService.getIsvByID(fdto.getIdisv());
        
        boolean flagFactura = this.facturasService.getFacturaByID(fdto.getIdfactura()) == null;
        boolean flagProveedor = this.proveedoresService.getProveedorByID(fdto.getIdproveedor()) != null;
        boolean flagSolicitudSAR = this.solicitudesSARService.getSolictudSARByID("solsar1") != null;
        boolean flagIsv = this.isvService.getIsvByID(fdto.getIdisv()) != null;
        
        System.out.println(flagFactura +""+ flagProveedor +""+ flagSolicitudSAR +""+ flagIsv);
        if ((flagFactura && flagProveedor && flagSolicitudSAR && flagIsv) == true) {

            int totaldp = 0;
            for (DetallesFacturaDTO detallefacdto : dfdto) {
                DetallesPedido dpedido = this.detallesPedidoService.getDetallePedidoByID(detallefacdto.getIddetallepedido());
                totaldp += dpedido.getTotal();
            }

            PorcentajeComisiones porcentajeComision = new PorcentajeComisiones();
            if (totaldp >= 10000) {
                porcentajeComision = this.porcentajeComisionesService.getPorcentajeComisionesByID("pc2");
            } else {
                porcentajeComision = this.porcentajeComisionesService.getPorcentajeComisionesByID("pc8");
            }

            Facturas f = new Facturas();
            f.setIdfactura(fdto.getIdfactura());
            f.setFechaemision(fdto.getFechaemision());
            String rango = String.format("%d-%d",solicitudSAR.getNumeroinicial(),solicitudSAR.getNumerofinal());
            f.setRangosolicitudSAR(rango);
            String numfac = String.format("%s-%s-%s-%d",
                    solicitudSAR.getIdestablecimiento().getValor(),
                    solicitudSAR.getIdpuntoemision().getValor(),
                    solicitudSAR.getIdtipodocumento().getNombre(),
                    solicitudSAR.getCorrelativoactual()
                    );
            f.setNumfactura(numfac);
            f.setIdisv(isv);
            f.setIdproveedor(proveedor);
            f.setIdsolicitudsar(solicitudSAR);
            f.setIdporcentajecomision(porcentajeComision);
            this.facturasService.saveFactura(f);
            for (DetallesFacturaDTO detallefacdto : dfdto) {

                detallefacdto.setIdfactura(fdto.getIdfactura());
                DetallesPedido dpedido = this.detallesPedidoService.getDetallePedidoByID(detallefacdto.getIddetallepedido());
                detallefacdto.setPreciounitario(dpedido.getTotal() * porcentajeComision.getPorcentaje());
                detallefacdto.setTotal(detallefacdto.getCantidad() * detallefacdto.getPreciounitario());
                this.detallesFacturaController.saveDetalleFactura(detallefacdto);

            }
            f.setSubtotal(totaldp);
            f.setTotal(totaldp * (1 + f.getIdisv().getIsv()));
            this.solicitudesSARService.updateCorrelativoActual(solicitudSAR.getIdsolicitudsar());
            return this.facturasService.saveFactura(f);
        }
        return null;
    }
}
