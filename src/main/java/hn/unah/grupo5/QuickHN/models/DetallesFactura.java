/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author mcenteno
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="DetallesFactura")
public class DetallesFactura implements Serializable {
    @Id
    private String iddetallefactura; //Identificar Relación
    private int cantidad;
    private float preciounitario;
    private float total;

    //Identificar Relación
    private DetallesPedido iddetallepedido;

    //Identificar Relación
    private Facturas idfactura;

}
