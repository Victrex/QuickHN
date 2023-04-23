/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name="detallesfactura")
public class DetallesFactura implements Serializable {
    @Id
    @Column(name="iddetallefactura")
    private String iddetallefactura; //Identificar Relación
    
    private int cantidad;
    private float preciounitario;
    private float total;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="iddetallepedido", referencedColumnName="iddetallepedido")
    @JsonIncludeProperties("iddetallepedido")
    private DetallesPedido iddetallepedido;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idfactura", referencedColumnName="idfactura")
    @JsonIncludeProperties("idfactura")
    private Facturas idfactura;

}
