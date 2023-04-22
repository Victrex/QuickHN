/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="Facturas")
public class Facturas implements Serializable {
    @Id
    private String idfactura;
    private Date fechalimite;
    @Column(name="rangosolicitudsar")
    private String rangosolicitudSAR;
    private int numfactura;
    private float subtotal;
    private float isvtotal;
    private float total;
    private Date fechaemision;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idproveedor", referencedColumnName="idproveedor")
    @JsonIgnoreProperties("idfactura")
    private Proveedores idproveedor;

    //Identificar Relación
    private SolicitudesSAR idsolicitudsar;

    //Identificar Relación
    private PorcentajeComisiones idporcentajecomision;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    //pendiente de relacion
    private DetallesFactura iddetallefactura;

}
