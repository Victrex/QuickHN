/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
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
@Table(name="DetallesFactura")
public class DetallesFactura implements Serializable {
    @Id
    private String iddetallefactura; //Identificar Relación
    private int cantidad;
    private float preciounitario;
    private float total;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="iddetallepedido", referencedColumnName="iddetallepedido")
    @JsonIgnoreProperties("iddetallefactura")
    private DetallesPedido iddetallepedido;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idfactura", referencedColumnName="idfactura")
    @JsonIgnoreProperties("iddetallefactura")
    private Facturas idfactura;

}
