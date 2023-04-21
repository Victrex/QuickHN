/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import java.io.Serializable;

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
@Table(name="Pedidos")
public class Pedidos implements Serializable {
    @Id
    private String idpedido; //Identificar Relación
    
    @Column(name="fechapedido")
    private String fechapedido;

    @Column(name="subtotal")
    private float subtotal;

    @Column(name="isv")
    private float isv;

    @Column(name="total")
    private float total;

    //Identificar Relación
    @Column(name="idusuario")
    private String idusuario;

    //Identificar Relación
    @Column(name="idmetodopago")
    private String idmetodopago;

    //Identificar Relación
    @Column(name="iddireccionentrega")
    private String iddireccionentrega;

}
