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
@Table(name="Reclamos")
public class Reclamos implements Serializable{
    
    @Id
    private String idreclamo;
    
    private Clientes idcliente;
    
    private DetallesPedido iddetallepedido;
    
    private MotivoReclamos idmotivoreclamo;
    
}
