/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
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

    @Column(name="cantidad")
    private int cantidad;

    @Column(name="preciounitario")
    private float preciounitario;

    @Column(name="total")
    private float total;

    //Identificar Relación
    @Column(name="iddetallepedido")
    private String iddetallepedido;

    //Identificar Relación
    @Column(name="idfactura")
    private String idfactura;

}
