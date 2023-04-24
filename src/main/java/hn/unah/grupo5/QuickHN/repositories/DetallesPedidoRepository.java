/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.repositories;

import hn.unah.grupo5.QuickHN.models.DetallesPedido;
import hn.unah.grupo5.QuickHN.models.Pedidos;
import hn.unah.grupo5.QuickHN.models.Proveedores;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Soriano
 */
@Repository
public interface DetallesPedidoRepository extends JpaRepository<DetallesPedido,String>{
    List<DetallesPedido> findByidproveedor(Proveedores idProveedor);
    List<DetallesPedido> findByidpedido(Pedidos idPedido);
}
