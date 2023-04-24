/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.controllers;

import hn.unah.grupo5.QuickHN.DTOs.DetallesPedidoDTO;
import hn.unah.grupo5.QuickHN.models.DetallesPedido;
import hn.unah.grupo5.QuickHN.models.EstadosPedido;
import hn.unah.grupo5.QuickHN.models.Pedidos;
import hn.unah.grupo5.QuickHN.models.Productos;
import hn.unah.grupo5.QuickHN.models.Proveedores;
import hn.unah.grupo5.QuickHN.servicesImpl.DetallesPedidoServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.EstadosPedidoServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.PedidosServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.ProductosServicesImpl;
import hn.unah.grupo5.QuickHN.servicesImpl.ProveedoresServicesImpl;
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
@RequestMapping("/detallesPedido")
public class DetallesPedidoController {
    @Autowired
    private DetallesPedidoServicesImpl detallesPedidoService;
    
    @Autowired
    private ProveedoresServicesImpl proveedoresService;
    
    @Autowired
    private PedidosServicesImpl pedidosService;
    
    @Autowired
    private EstadosPedidoServicesImpl estadosPedidoService;
    
    @Autowired
    private ProductosServicesImpl productosService;
    
    @GetMapping("/getAll")
    public List<DetallesPedido> getAllDetallesPedido(){
        return this.detallesPedidoService.getAllDetallesPedido();
    }
    
    @GetMapping("/getById")
    public DetallesPedido getDetallePedidoByID(@RequestParam String id){
        return this.detallesPedidoService.getDetallePedidoByID(id);
    }
    
    @GetMapping("/getByProveedor")
    public List<DetallesPedido> getDetallesPedidoByProveedor(@RequestParam String id){
        Proveedores proveedor=this.proveedoresService.getProveedorByID(id);
        if(proveedor!=null){
            return this.detallesPedidoService.getDetallesPedidoByProveedor(proveedor);
        }
        return null;
    }
    
    @GetMapping("/getByPedido")
    public List<DetallesPedido> getDetallesPedidoByPedido(@RequestParam String id){
        Pedidos pedido=this.pedidosService.getPedidoByID(id);
        if(pedido!=null){
            return this.detallesPedidoService.getDetallesPedidoByPedido(pedido);
        }
        return null;
    }
    
    @PostMapping("/save")
    public DetallesPedido saveDetallePedido(@RequestBody DetallesPedidoDTO dpdto){
        boolean flagDetallePedido=this.detallesPedidoService.getDetallePedidoByID(dpdto.getIddetallepedido())==null;
        boolean flagProveedor=this.proveedoresService.getProveedorByID(dpdto.getIdproveedor())!=null;
        boolean flagProducto=this.productosService.getProductoByID(dpdto.getIdproducto())!=null;
        boolean flagEstadoPedido=this.estadosPedidoService.getEstadoPedidoByID(dpdto.getIdestadopedido())!=null;
        boolean flagPedido=this.pedidosService.getPedidoByID(dpdto.getIdpedido())!=null;
        if((flagDetallePedido&&flagPedido&&flagProveedor&&flagProducto&&flagEstadoPedido)==true){
            Proveedores proveedor = this.proveedoresService.getProveedorByID(dpdto.getIdproveedor());
            Pedidos pedido=this.pedidosService.getPedidoByID(dpdto.getIdpedido());
            Productos producto=this.productosService.getProductoByID(dpdto.getIdproducto());
            EstadosPedido estadoPedido=this.estadosPedidoService.getEstadoPedidoByID(dpdto.getIdestadopedido());
            DetallesPedido dp=new DetallesPedido();
            dp.setIddetallepedido(dpdto.getIddetallepedido());
            dp.setCantidad(dpdto.getCantidad());
            dp.setPreciounitario(dpdto.getPreciounitario());
            dp.setTotal(dpdto.getCantidad()*dpdto.getPreciounitario());
            dp.setIdproducto(producto);
            dp.setIdpedido(pedido);
            dp.setIdproveedor(proveedor);
            dp.setIdestadopedido(estadoPedido);
            return this.detallesPedidoService.saveDetallePedido(dp);          
        }
        return null;
    }
}
