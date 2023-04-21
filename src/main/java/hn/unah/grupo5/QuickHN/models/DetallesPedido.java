/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Soriano
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="DetallesPedido")
public class DetallesPedido {
    @Id
    private String iddetallepedido;
    private int cantidad;
    private float preciounitario;
    private float total;
    
    private Productos idproducto;
    
    private Pedidos idpedido;
    
    private Proveedores idproveedor;
    
    private EstadosPedido idestadopedido;
    
    
}
