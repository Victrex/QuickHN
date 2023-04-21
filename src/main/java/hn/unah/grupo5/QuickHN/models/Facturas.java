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
@Table(name="Facturas")
public class Facturas implements Serializable {
    @Id
    private String idfactura; //Identificar Relación
    
    @Column(name="fechalimite")
    private Date fechalimite;

    @Column(name="rangosolicitudSAR")
    private String rangosolicitudSAR;

    @Column(name="numfactura")
    private int numfactura;

    @Column(name="subtotal")
    private float subtotal;

    @Column(name="isvtotal")
    private float isvtotal;

    @Column(name="total")
    private float total;

    @Column(name="fechaemision")
    private Date fechaemision;

    //Identificar Relación
    @Column(name="idproveedor")
    private String idproveedor;

    //Identificar Relación
    @Column(name="numcaiempresa")
    private String numcaiempresa;

    //Identificar Relación
    @Column(name="idsolicitudsar")
    private String idsolicitudsar;

    //Identificar Relación
    @Column(name="idporcentajecomision")
    private String idporcentajecomision;

}
