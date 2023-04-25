/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.DTOs.DetallesPedidoDTO;
import hn.unah.grupo5.QuickHN.DTOs.PedidoRequestDTO;
import hn.unah.grupo5.QuickHN.DTOs.PedidosDTO;
import hn.unah.grupo5.QuickHN.models.ComprobantesPago;
import hn.unah.grupo5.QuickHN.models.DetallesPedido;
import hn.unah.grupo5.QuickHN.models.Direcciones;
import hn.unah.grupo5.QuickHN.models.Isv;
import hn.unah.grupo5.QuickHN.models.Pedidos;
import hn.unah.grupo5.QuickHN.models.Usuarios;
import hn.unah.grupo5.QuickHN.servicesImpl.ComprobantesPagoServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.DireccionesServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.IsvServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.PedidosServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.UsuariosServicesImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Soriano
 */
@RestController
@RequestMapping("/pedido")
public class PedidosController {

    @Autowired
    private PedidosServicesImpl pedidosService;

    @Autowired
    private UsuariosServicesImpl usuariosService;

    @Autowired
    private DireccionesServicesImpl direccionesService;

    @Autowired
    private IsvServicesImpl isvService;
    
    private ComprobantesPagoServicesImpl comprobantesService;

    @Autowired
    private DetallesPedidoController detallepedidoscontroller;

    @GetMapping("/getAll")
    public List<Pedidos> getAllPedidos() {
        return this.pedidosService.getAllPedidos();
    }

    @GetMapping("/getById")
    public Pedidos getPedidoById(@RequestParam String id) {
        return this.pedidosService.getPedidoByID(id);
    }

    @GetMapping("/getByUsuario")
    public List<Pedidos> getPedidosByUsuario(@RequestBody String id) {
        Usuarios usuario = this.usuariosService.getUsuarioByID(id);
        if (usuario != null) {
            return this.pedidosService.getPedidosByUsuario(usuario);
        }
        return null;
    }

    @PostMapping("/save")
    public Pedidos savePedido(@RequestBody PedidoRequestDTO prdto) {

        PedidosDTO pdto = prdto.getPedido();
        List<DetallesPedidoDTO> dpdto = prdto.getDetallesPedido();

        boolean flagPedido = this.pedidosService.getPedidoByID(pdto.getIdpedido()) == null;
        boolean flagUsuario = this.usuariosService.getUsuarioByID(pdto.getIdusuario()) != null;
        boolean flagDireccion = this.direccionesService.getDireccionByID(pdto.getIddireccionentrega()) != null;
        boolean flagIsv = this.isvService.getIsvByID(pdto.getIdisv()) != null;
        if ((flagPedido && flagDireccion && flagUsuario && flagIsv) == true) {
            Usuarios usuario = this.usuariosService.getUsuarioByID(pdto.getIdusuario());
            Direcciones direccion = this.direccionesService.getDireccionByID(pdto.getIddireccionentrega());
            Isv isv = this.isvService.getIsvByID(pdto.getIdisv());
            Pedidos ptemp = new Pedidos();
            ptemp.setIdpedido(pdto.getIdpedido());
            ptemp.setFechapedido(pdto.getFechapedido());
            //ptemp.setSubtotal(pdto.getSubtotal());
            ptemp.setIdisv(isv);
            //ptemp.setTotal(pdto.getTotal());
            ptemp.setIdusuario(usuario);
            ptemp.setIddireccionentrega(direccion);
            //return this.pedidosService.savePedido(ptemp);
            this.pedidosService.savePedido(ptemp);

            float subtotal = 0;
            for (DetallesPedidoDTO detalledto : dpdto) {
                detalledto.setIdpedido(pdto.getIdpedido());
                DetallesPedido detalletemp = this.detallepedidoscontroller.saveDetallePedido(detalledto);
                subtotal += detalletemp.getTotal();
            }

            float total = 0;
            total = subtotal * isv.getIsv();
            ptemp.setSubtotal(subtotal);
            ptemp.setTotal(total);
            this.pedidosService.savePedido(ptemp);
            ComprobantesPago comprobante = new ComprobantesPago("comp"+pdto.getIdpedido(),ptemp);
            this.comprobantesService.saveComprobantePago(comprobante);
            return this.pedidosService.savePedido(ptemp);

        }
        return null;
    }

    @PutMapping("/update")
    public Pedidos updatePedido(@RequestBody PedidosDTO pdto, @RequestParam String id) {
        boolean flagPedido = this.pedidosService.getPedidoByID(id) != null;
        boolean flagUsuario = this.usuariosService.getUsuarioByID(pdto.getIdusuario()) != null;
        boolean flagDireccion = this.direccionesService.getDireccionByID(pdto.getIddireccionentrega()) != null;
        boolean flagIsv = this.isvService.getIsvByID(pdto.getIdisv()) != null;
        if ((flagPedido && flagDireccion && flagUsuario && flagIsv) == true) {
            Usuarios usuario = this.usuariosService.getUsuarioByID(pdto.getIdusuario());
            Direcciones direccion = this.direccionesService.getDireccionByID(pdto.getIddireccionentrega());
            Isv isv = this.isvService.getIsvByID(pdto.getIdisv());
            Pedidos ptemp = this.pedidosService.getPedidoByID(id);
            ptemp.setFechapedido(pdto.getFechapedido());
            ptemp.setSubtotal(pdto.getSubtotal());
            ptemp.setIdisv(isv);
            ptemp.setTotal(pdto.getTotal());
            ptemp.setIdusuario(usuario);
            ptemp.setIddireccionentrega(direccion);
            return this.pedidosService.savePedido(ptemp);
        }
        return null;
    }
}
