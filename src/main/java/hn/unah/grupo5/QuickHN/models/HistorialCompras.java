/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Kenne
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="HistorialCompras")
public class HistorialCompras implements Serializable{
    @Id
    private String idhistorial;
    
    //pendiente de relacion
    private Clientes idcliente;
    
    //pendiente de relacion
    private Pedidos idpedido;
    
    //pendiente de relacion
    private EstadosPedido idestadopedido;
    
    //pendiente de relacion
    private Proveedores idproveedor;
}
